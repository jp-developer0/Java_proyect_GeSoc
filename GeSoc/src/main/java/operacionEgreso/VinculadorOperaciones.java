package operacionEgreso;

import apiRest.ApiComponenteExterno;
import com.google.gson.Gson;
import db.EntityManagerHelper;
import domain.EntidadJuridica;
import operacionIngreso.IngresoDTO;
import operacionIngreso.OperacionIngreso;
import repositories.FactoryRepositorio;
import repositories.Repositorio;
import retrofit2.Response;
import spark.Request;
import usuario.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class VinculadorOperaciones {

    private List<EgresoDTO> egresos;
    private List<IngresoDTO> ingresos;
    private Repositorio<Usuario> repoUsuarios = FactoryRepositorio.get(Usuario.class);
    //private Integer criterio;

    public List<EgresoDTO> getEgresos() {
        return egresos;
    }

    public void setEgresos(List<EgresoDTO> egresos) {
        this.egresos = egresos;
    }



    public List<IngresoDTO> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<IngresoDTO> ingresos) {
        this.ingresos = ingresos;
    }

    public VinculadorOperaciones() {
    }

    public void cargarListas(Request request){
        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios=usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        EntidadJuridica entidadJuridica = usuario.getEntidadJuridica();

        List<OperacionIngreso> i = (List<OperacionIngreso>) EntityManagerHelper
                .createQuery("from "+ OperacionIngreso.class.getName()).getResultList();

        i = i.stream().filter(e->e.getEntidadJuridica()==(entidadJuridica)).collect(Collectors.toList());
        i = i.stream().filter(a -> a.getSaldoRemanente() > 0.0).collect(Collectors.toList());
        this.ingresos = i.stream().map(t->t.convertirDto(t)).collect(Collectors.toList());


        List<OperacionEgreso> e = (List<OperacionEgreso>) EntityManagerHelper
                .createQuery("from "+ OperacionEgreso.class.getName()).getResultList();

        e = e.stream().filter(eg->eg.getEntidadJuridica()==(entidadJuridica)).collect(Collectors.toList());
        e = e.stream().filter(a -> a.getIngreso() == null && a.getTotal() > 0.0).collect(Collectors.toList());
        this.egresos = e.stream().map(t->t.convertirDto(t)).collect(Collectors.toList());

    }
    public void vincular(Request request){
        this.cargarListas(request);
        Gson g = new Gson();
        String jsonOperaciones = g.toJson(this);
        System.out.println(jsonOperaciones);

        ApiComponenteExterno apiComponenteExterno = ApiComponenteExterno.instancia();
        Response response = null;
        try {

            response = apiComponenteExterno.enviarJson(jsonOperaciones);

            VinculadorOperaciones vo = (VinculadorOperaciones) response.body();

            for (IngresoDTO oidto : vo.getIngresos()){
                OperacionIngreso oii = (OperacionIngreso) EntityManagerHelper.createQuery("from OperacionIngreso where id = " + oidto.getId()).getSingleResult();
                for(Integer oedto : oidto.getEgresos()){
                    OperacionEgreso oee = (OperacionEgreso) EntityManagerHelper.createQuery("from OperacionEgreso where id = " + oedto).getSingleResult();
                    oee.setIngreso(oii);
                    oii.getOperacionesEgreso().add(oee);
                    oii.setSaldoRemanente(oii.getSaldoRemanente()-oee.getTotal());

                }

                EntityManagerHelper.beginTransaction();
                EntityManagerHelper.entityManager().merge(oii);
                EntityManagerHelper.commit();
            }

            System.out.println(response.body());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
