package controllers;

import repositories.FactoryRepositorio;
import db.EntityManagerHelper;
import repositories.Repositorio;
import repositories.daos.DAOHibernate;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController {

    private Repositorio<Usuario> repoUsuario;
    public UsuarioController(){
        this.repoUsuario = FactoryRepositorio.get(Usuario.class);
    }

    public String usuario(Request request, Response response){
        return "hola Grupo 4";
    }

    public ModelAndView crearUsuario(Request request, Response response){
        //Usuario usuario = new Usuario();
        return new ModelAndView(null,"g4.hbs");
    }

//    public Response login (Request request, Response response) {
//
//        if (userExists(request.queryParams("user"),request.queryParams("password"))){
//            response.redirect("/home");
//        } else {
//
//            response.redirect("/index");
//        }
//        return response;
//    }

    public ModelAndView logi(Request request, Response response){
        return new ModelAndView(null,"home.hbs");
    }

    public ModelAndView loginn(Request request, Response response){

        request.session(true);

        Map<String,Object> parametros = new HashMap<>();
        String usu=request.queryParams("user");
        String pas=request.queryParams("password");
        Usuario usuario = new Usuario(usu,pas);
        parametros.put("usu",usuario);
        if (userExists(request.queryParams("user"),request.queryParams("password"))){
            request.session().attribute("usuario",usu);
            return new ModelAndView(parametros,"home.hbs");
        } else {
            return new ModelAndView(null,"index.hbs");
        }


    }
    public ModelAndView login (Request request, Response response) {

        if (userExists(request.queryParams("user"),request.queryParams("password"))){
            return new ModelAndView(null,"home.hbs");
        } else {
            return new ModelAndView(null,"index.hbs");
        }
    }

    private boolean userExists (String user, String pass){
        boolean resp = false;
        Usuario u = null;

        try{
            u = (Usuario) EntityManagerHelper.createQuery(
                    "from Usuario u where u.usuario = '" + user + "' and u.password = '" + pass + "'"
            ).getSingleResult();
        }catch(Exception e){
            System.out.println(u);
        }

        if (u != null){
            resp = true;
        }

        return resp;
    }
}
