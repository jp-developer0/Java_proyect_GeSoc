package server;

import spark.Spark;
import spark.debug.DebugScreen;

import static server.Router.getHerokuAssignedPort;

public class Server {
    public static void main(String[] args) {
        Spark.port(getHerokuAssignedPort());// aca va esto en el puerto para poder deployar getHerokuAssignedPort()
        Router.init();
        DebugScreen.enableDebugScreen();
    }
}
