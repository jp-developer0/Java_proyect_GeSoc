package controllers;

import converters.LocalDateAttributeConverter;
import criterioClasificacionEgresos.CategoriaEgreso;
import criterioClasificacionEgresos.CriterioEgreso;
import db.EntityManagerHelper;
import domain.EntidadJuridica;
import operacionEgreso.CriterioProveedor.CriteriosParaProveedores;
import operacionEgreso.CriterioProveedor.MenorValor;
import operacionEgreso.MedioDePago;
import operacionEgreso.OperacionEgreso;
import operacionEgreso.Presupuesto;
import operacionEgreso.VinculadorOperaciones;
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

public class IngresoController {
    private Repositorio<OperacionIngreso> repoIngreso;
    private Repositorio<Usuario> repoUsuarios;

    public IngresoController(){
        this.repoIngreso = FactoryRepositorio.get(OperacionIngreso.class);
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
    }

    public ModelAndView ingresos(Request request, Response response){

        List<OperacionIngreso> ingresos = this.repoIngreso.buscarTodos();
        Map<String,Object> parametros = new HashMap<>();
        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios=usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        //System.out.println(usuario.getEntidadJuridica().getId());
        EntidadJuridica entidadJuridica =usuario.getEntidadJuridica();
        ingresos = ingresos.stream().filter(e->e.getEntidadJuridica()==(entidadJuridica)).collect(Collectors.toList());

        parametros.put("ingresos",ingresos);
        return new ModelAndView(parametros, "ingresos.hbs");
    }
    public ModelAndView vincular(Request request, Response response){
        VinculadorOperaciones vin=new VinculadorOperaciones();
        vin.vincular(request);
        return this.ingresos(request,response);
    }
    public Response ingreso(Request request, Response response) throws ParseException {

        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios=usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        System.out.println(usuario.getEntidadJuridica().getId());
        EntidadJuridica entidadJuridica =usuario.getEntidadJuridica();

        LocalDateAttributeConverter ldac = new LocalDateAttributeConverter();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // set UTC to the format
        Date dateIngreso = sdf.parse(request.queryParams("fechaIngreso"));
        Date dateLimiteEgreso= sdf.parse(request.queryParams("fechaLimEgreso"));

        LocalDate d = dateIngreso.toInstant().atZone(ZoneOffset.UTC).toLocalDate();
        LocalDate d2 = dateLimiteEgreso.toInstant().atZone(ZoneOffset.UTC).toLocalDate();

        Date fechaIngreso = ldac.convertToDatabaseColumn(d);
        Date fechaLimiteEgreso = ldac.convertToDatabaseColumn(d2);

        float total = new Float(request.queryParams("total"));
        System.out.println(total);

        String descripcion = request.queryParams("descripcion");
        System.out.println(descripcion);

        OperacionIngreso ingresoNuevo = new OperacionIngreso(descripcion,total,d,d2);
        ingresoNuevo.setEntidadJuridica(entidadJuridica);
        //ingresoNuevo.setDescripcion("harcodeado");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(ingresoNuevo);
        EntityManagerHelper.commit();
        response.redirect("/ingresos");

        return response;
    }
}
