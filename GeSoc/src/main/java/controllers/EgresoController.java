package controllers;

import categoria.Categoria;
import converters.LocalDateAttributeConverter;
import criterioClasificacionEgresos.CategoriaEgreso;
import criterioClasificacionEgresos.CriterioEgreso;
import db.EntityManagerHelper;
import domain.EntidadJuridica;
import operacionEgreso.*;
import operacionEgreso.CriterioProveedor.CriteriosParaProveedores;
import operacionEgreso.CriterioProveedor.MenorValor;
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

public class EgresoController {
    private Repositorio<OperacionEgreso> repoEgreso;
    private Repositorio<Usuario> repoUsuarios;
    LocalDateAttributeConverter ldac;
    private Repositorio<CategoriaEgreso> repoCategoria;

    public EgresoController(){
        this.repoEgreso = FactoryRepositorio.get(OperacionEgreso.class);
        this.repoCategoria = FactoryRepositorio.get(CategoriaEgreso.class);
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
    }

    public ModelAndView egresosUsu(Request request, Response response){
        String usuario = request.params("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios.stream().filter(u->u.getUsuario().equals(usuario)).collect(Collectors.toList());
        Usuario user = usuarios.get(0);

        EntidadJuridica entidadJuridica = user.getEntidadJuridica();
        List<OperacionEgreso> egresos = this.repoEgreso.buscarTodos();



        /*
        int p=0;
        if(usuario.equals("aroco")){
            p=1;
        }else
            p=2;

        int finalP = p;
        */

        List<OperacionEgreso> egresos2 = egresos.stream().filter(e->e.getEntidadJuridica().getId() == entidadJuridica.getId()).collect(Collectors.toList());



        List<CategoriaEgreso> categorias = this.repoCategoria.buscarTodos();
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("egresos",egresos2);
        parametros.put("categorias",categorias);
        return new ModelAndView(parametros, "egresos.hbs");
    }

    public ModelAndView egresos(Request request, Response response){
        List<OperacionEgreso> egresos = this.repoEgreso.buscarTodos();
        List<CategoriaEgreso> categorias = this.repoCategoria.buscarTodos();
        Map<String,Object> parametros = new HashMap<>();
        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios=usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        EntidadJuridica entidadJuridica = usuario.getEntidadJuridica();
        egresos = egresos.stream().filter(e->e.getEntidadJuridica()==(entidadJuridica)).collect(Collectors.toList());

        //for(OperacionEgreso egreso:egresos){
            //System.out.println(egreso.getIngreso().getId());
        //}

        parametros.put("egresos",egresos);
        parametros.put("categorias",categorias);
        return new ModelAndView(parametros, "egresos.hbs");
    }

    public Response egreso(Request request, Response response) throws ParseException {

        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios=usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        System.out.println(usuario.getEntidadJuridica().getId());

        EntidadJuridica entidadJuridica = usuario.getEntidadJuridica();



        ldac = new LocalDateAttributeConverter();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MedioDePago medio = new MedioDePago();
        CriteriosParaProveedores criterioProveedor;
        criterioProveedor = new MenorValor();
        //medio.setIdentificacion(new Integer(request.queryParams("identificacion")));

        medio.setMedio(request.queryParams("medioDePago"));

        sdf.setTimeZone(TimeZone.getTimeZone("UTC")); // set UTC to the format
        Date date = sdf.parse(request.queryParams("fechaOperacion"));
        LocalDate d = date.toInstant().atZone(ZoneOffset.UTC).toLocalDate();

        Date fecha = ldac.convertToDatabaseColumn(d);
        System.out.println(fecha);

        //boolean requiere = Boolean.parseBoolean(request.queryParams("requierePresupuesto"));//ver si convierte string a bool, no esta llegando por el checkbox nuevo

        /*
        String requiereON = request.queryParams("requierePresupuesto");
        int numeroPresupuestos=0;
        boolean requiere=false;
        if(requiereON.equals("on")){
            numeroPresupuestos= new Integer(request.queryParams("cantPresupuestosRequeridos"));
            requiere=true;
        }

        */
        int numeroPresupuestos= new Integer(request.queryParams("cantPresupuestosRequeridos"));
        /*
        if (requiere)
            numeroPresupuestos = new Integer(request.queryParams("cantPresupuestosRequeridos"));
        else
            numeroPresupuestos = 0;
         */

        boolean requiere=true;//funciona
        if(numeroPresupuestos==0)
            requiere=false;

        //System.out.println(requiereON);
        System.out.println(requiere);
        System.out.println(numeroPresupuestos);

        List<Presupuesto> presupuestos = new ArrayList<>();
        Presupuesto presupuestoElegido = null;

        CriteriosParaProveedores criteriosParaProveedores;
        if(request.queryParams("categoria").compareTo("Menor Valor") != 0)
            criteriosParaProveedores = null;
        else
            criteriosParaProveedores = new MenorValor();

        String[] c=request.queryParams("categoria").split("-");
        int idCategoria=new Integer(c[0]);
        CategoriaEgreso categoriaEgreso = this.repoCategoria.buscar(idCategoria);

        List<CategoriaEgreso> listaCatEg = new ArrayList<>();
        listaCatEg.add(categoriaEgreso);

        //CriterioEgreso ce = new CriterioEgreso();
        //ce.setDescripcion("algo");
        //ce.setCriterioPadre(ce);
        //ce.setCategoriasEgreso(listaCatEg);

        OperacionIngreso ingreso = null;

        float total = new Float(request.queryParams("total"));
        OperacionEgreso egresoNuevo= new OperacionEgreso(
                medio,
                d,
                requiere,
                numeroPresupuestos,
                presupuestos,
                null,
                criteriosParaProveedores,
                listaCatEg,
                null,
                total);

        egresoNuevo.setCriterioProveedor(criterioProveedor);
        egresoNuevo.setEntidadJuridica(entidadJuridica);//agregue Marcos
        egresoNuevo.setCategoriasEgreso(listaCatEg);//agregue Marcos

        //repoEgreso.agregar(egresoNuevo);
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(egresoNuevo);
        EntityManagerHelper.commit();

        response.redirect("/egresos");

        return response;
    }

    public ModelAndView asociarEgreso(Request request, Response response){
          //TODO: ASOCIAR A CATEGORIAS!
        System.out.println("AsociarEgreso");

        String[] c=request.queryParams("categoria").split("-");
        int idEgreso=new Integer(request.queryParams("egreso"));
        int idCategoria=new Integer(c[0]);
        OperacionEgreso egreso = this.repoEgreso.buscar(idEgreso);
        CategoriaEgreso categoria = this.repoCategoria.buscar(idCategoria);
        egreso.addCategoria(categoria);
        this.repoEgreso.modificar(egreso);
        return this.egresos(request,response);
    }
}
