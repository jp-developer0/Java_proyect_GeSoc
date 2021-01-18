package server;

import controllers.*;
import spark.ResponseTransformer;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sparkutils.BooleanHelper;
import sparkutils.HandlebarsTemplateEngineBuilder;

public class Router {

    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        Controlador controlador = new Controlador();
        UsuarioController usuarioController= new UsuarioController();
        EgresoController egresoController = new EgresoController();
        IngresoController ingresoController = new IngresoController();
        MensajeController mensajeController = new MensajeController();
        PresupuestoController presupuestoController = new PresupuestoController();
        DBController dBController = new DBController();

        Spark.get("/areWeConnected", controlador::areWeConnected);

        Spark.get("/index", controlador::index, Router.engine);

        Spark.get("/g4", controlador::g4, Router.engine);

        Spark.get("/usuario", usuarioController::crearUsuario,Router.engine );

        Spark.get("/egresos", egresoController::egresos,Router.engine );

        Spark.get("/egresosUsu/:usuario", egresoController::egresosUsu,Router.engine );

        Spark.get("/presupuestos", presupuestoController::presupuestos,Router.engine );

        Spark.get("/asociar",presupuestoController::asociar,Router.engine);

        Spark.get("/presupuestoElegido",presupuestoController::presupuestoElegido,Router.engine);

        Spark.get("/asociarEgreso",egresoController::asociarEgreso,Router.engine);

        Spark.get("/ingresos", ingresoController::ingresos,Router.engine );

        //Spark.get("/proveedores", presupuestoController::proveedores,Router.engine );

        Spark.get("/vincular", ingresoController::vincular,Router.engine);

        Spark.get("/insertDB", dBController::insertDB);

        Spark.post("/usuario/:id",usuarioController::login);

        Spark.post("/loginn",usuarioController::loginn,Router.engine);
        Spark.post("/logi",usuarioController::logi,Router.engine);

        Spark.post("/login",usuarioController::login,Router.engine);

        Spark.post("/egreso",egresoController::egreso);
        Spark.post("/ingreso",ingresoController::ingreso);
        Spark.post("/presupuesto",presupuestoController::presupuesto);


        Spark.get("/home",mensajeController::mostrarTodos,Router.engine );

    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
