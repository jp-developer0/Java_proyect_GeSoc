package controllers;

import categoria.Categoria;
import converters.LocalDateAttributeConverter;
import criterioClasificacionEgresos.CategoriaEgreso;
import db.EntityManagerHelper;
import domain.EntidadJuridica;
import operacionEgreso.*;
import operacionIngreso.OperacionIngreso;
import repositories.FactoryRepositorio;
import repositories.Repositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class PresupuestoController {
    private Repositorio<Usuario> repoUsuarios;
    private Repositorio<Presupuesto> repoPresupuesto;
    private Repositorio<Proveedor> repoProveedores;
    private Repositorio<OperacionEgreso> repoEgresos;
    public PresupuestoController(){
        this.repoPresupuesto = FactoryRepositorio.get(Presupuesto.class);
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
        this.repoProveedores = FactoryRepositorio.get(Proveedor.class);
        this.repoEgresos = FactoryRepositorio.get(OperacionEgreso.class);
    }
    private Repositorio<CategoriaEgreso> repoCategoria=FactoryRepositorio.get(CategoriaEgreso.class);


    public ModelAndView presupuestos(Request request, Response response){
        List<CategoriaEgreso> categorias = repoCategoria.buscarTodos();
        List<Presupuesto> presupuestos = this.repoPresupuesto.buscarTodos();
        List<Proveedor> proveedoresSinRepetidos = presupuestos.stream().map(Presupuesto::getProveedor).collect(Collectors.toSet()).stream().collect(Collectors.toList());
        List<OperacionEgreso> egresos = this.repoEgresos.buscarTodos();

        Map<String,Object> parametros = new HashMap<>();
        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios=usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        EntidadJuridica entidadJuridica =usuario.getEntidadJuridica();

        presupuestos = presupuestos.stream().filter(e->(e.getEntidadJuridica() !=null && e.getEntidadJuridica().equals(entidadJuridica))).collect(Collectors.toList());

        List<Presupuesto> presupuestosTotal= new ArrayList<>();
        for(Presupuesto presupuesto:presupuestos){
            presupuesto.obtenerTotal();
            presupuestosTotal.add(presupuesto);
        }
        //agrego esto para ver si se ven lo de la sesion del usuario
        List<OperacionEgreso> egresos2 = egresos.stream().filter(e->e.getEntidadJuridica().getId() == entidadJuridica.getId()).collect(Collectors.toList());

        parametros.put("presupuestos",presupuestosTotal);
        parametros.put("categorias",categorias);
        parametros.put("egresos",egresos2);
        parametros.put("proveedoresSinRepetidos",proveedoresSinRepetidos);
        return new ModelAndView(parametros, "presupuestos.hbs");
    }

    public ModelAndView asociar(Request request, Response response){

        String[] c=request.queryParams("presupuesto").split("-");
        int idPresupuesto= new Integer(c[0]);;
        int idEgreso=new Integer(request.queryParams("egreso"));
        Presupuesto presupuesto = this.repoPresupuesto.buscar(idPresupuesto);
        OperacionEgreso egreso = this.repoEgresos.buscar(idEgreso);

        egreso.agregarPresupuesto(presupuesto);

        this.repoEgresos.modificar(egreso);
        return this.presupuestos(request,response);
    }
    public ModelAndView presupuestoElegido(Request request, Response response){
        System.out.println("Elegir");

        String[] c=request.queryParams("presupuestoElegido").split("-");
        int idPresupuesto= new Integer(c[0]);
        int idEgreso = new Integer(request.queryParams("egreso"));
        Presupuesto presupuesto = this.repoPresupuesto.buscar(idPresupuesto);
        OperacionEgreso egreso = this.repoEgresos.buscar(idEgreso);
        egreso.setPresupuestoElegido(presupuesto);

        presupuesto.setOperacionEgreso(egreso);

        this.repoEgresos.modificar(egreso);
        this.repoPresupuesto.modificar(presupuesto);

        return this.presupuestos(request,response);
    }



    public Response presupuesto(Request request, Response response) throws ParseException {

        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios=usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        System.out.println(usuario.getEntidadJuridica().getId());
        EntidadJuridica entidadJuridica =usuario.getEntidadJuridica();

        LocalDateAttributeConverter ldac = new LocalDateAttributeConverter();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // set UTC to the format
        Date date = sdf.parse(request.queryParams("fechaPresupuesto"));
        LocalDate d = date.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
        Date fecha = ldac.convertToDatabaseColumn(d);
        Item item1 = new Item(request.queryParams("descripcionArt1"),new Float(request.queryParams("montoArt1")),new Integer(request.queryParams("cantArt1")));
        Item item2 = new Item(request.queryParams("descripcionArt2"),new Float(request.queryParams("montoArt2")),new Integer(request.queryParams("cantArt2")));
        Item item3 = new Item(request.queryParams("descripcionArt3"),new Float(request.queryParams("montoArt3")),new Integer(request.queryParams("cantArt3")));
        Item item4 = new Item(request.queryParams("descripcionArt4"),new Float(request.queryParams("montoArt4")),new Integer(request.queryParams("cantArt4")));


        String proveedor = request.queryParams("proveedor");
        List<Proveedor> proveedores = this.repoProveedores.buscarTodos();
        proveedores=proveedores.stream().filter(p->p.getNombre().equals(proveedor)).collect(Collectors.toList());
        Proveedor proveedor1= proveedores.get(0);

        Presupuesto presupuestoNuevo = new Presupuesto();
        presupuestoNuevo.setEntidadJuridica(entidadJuridica);
        presupuestoNuevo.setFecha(d);
        presupuestoNuevo.setProveedor(proveedor1);
        presupuestoNuevo.getItems().add(item1);
        presupuestoNuevo.getItems().add(item2);
        presupuestoNuevo.getItems().add(item3);
        presupuestoNuevo.getItems().add(item4);
        //presupuestoNuevo.setTotal(item1.getValor());


        EntityManagerHelper.beginTransaction();
        //EntityManagerHelper.getEntityManager().persist(item1);
        //EntityManagerHelper.getEntityManager().persist(item2);
        //EntityManagerHelper.getEntityManager().persist(item3);
        //EntityManagerHelper.getEntityManager().persist(item4);
        EntityManagerHelper.getEntityManager().persist(presupuestoNuevo);
        EntityManagerHelper.commit();
        response.redirect("/presupuestos");

        return response;
    }

}
