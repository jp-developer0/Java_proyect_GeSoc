package controllers;
import criterioClasificacionEgresos.CategoriaEgreso;
import domain.EntidadJuridica;
import operacionEgreso.OperacionEgreso;
import operacionIngreso.OperacionIngreso;
import repositories.FactoryRepositorio;
import repositories.Repositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.Usuario;
import usuario.mensajes.Mensaje;
import validador.Validador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MensajeController {
    private Repositorio<Mensaje> repoMensaje;
    private Repositorio<Usuario> repoUsuarios;
    private Repositorio<EntidadJuridica> repoEntidades;
    public MensajeController(){
        this.repoMensaje = FactoryRepositorio.get(Mensaje.class);
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
        this.repoEntidades = FactoryRepositorio.get(EntidadJuridica.class);
    }
    /*
    public ModelAndView mostrarTodos(Request request, Response response){
        List<Mensaje> mensajes= this.repoMensaje.buscarTodos();
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("mensajes",mensajes);
        return new ModelAndView(parametros,"home.hbs");
    }
    */
    public ModelAndView mostrarTodos(Request request, Response response){
        //List<OperacionEgreso> egresos = this.repoEgreso.buscarTodos();
        //List<CategoriaEgreso> categorias = this.repoCategoria.buscarTodos();

        Map<String,Object> parametros = new HashMap<>();

        String nombreUsu = request.session().attribute("usuario");
        List<Usuario> usuarios = this.repoUsuarios.buscarTodos();
        usuarios = usuarios.stream().filter(u->u.getUsuario().equals(nombreUsu)).collect(Collectors.toList());
        Usuario usuario = usuarios.get(0);
        EntidadJuridica entidadJuridica = usuario.getEntidadJuridica();


        System.out.println(entidadJuridica.getNombreFicticio());
        Validador validador = new Validador(entidadJuridica);
        List<Mensaje> mensajes2 = validador.validar();

        for(Mensaje m:mensajes2) {
            this.repoMensaje.agregar(m);
            entidadJuridica.getBandejaDeMensajes().add(m);
        }
        this.repoEntidades.modificar(entidadJuridica);

        parametros.put("usu",usuario);
        parametros.put("mensajes",mensajes2);
        //parametros.put("categorias",categorias);
        return new ModelAndView(parametros, "home.hbs");
    }

    public void validarMensajesNuevos(){

    }
}
