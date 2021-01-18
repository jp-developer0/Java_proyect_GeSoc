package usuario;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Login {

    private String usuario = "Administrador";
    private String clave = "1234";
    private int contadorIntentos = 1;
    private int intentosMaximos = 5;
    private String log = "";

    public String getLog() { return log; }

    private void logear(String textoALogear) {
        System.out.println(textoALogear);
        this.log = textoALogear;
    }

    public void ingresoUsuario() {
        Scanner nombre = new Scanner(System.in);
        this.logear("Ingrese usuario");
        String usuario = nombre.next();
    }

    public void ingresoClave() {
        Scanner clave = new Scanner(System.in);
        this.logear("Ingrese clave");
        String pass = clave.next();
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Ingrese clave nuevamente.");
                String pass = clave.next();
            }
        };
        while (contadorIntentos < intentosMaximos) {

            if (this.clave.equals(pass)) {
                this.logear("Logueo exitoso.");
                break;
            } else {
                timer.schedule(tarea, 30000 * contadorIntentos);
                this.logear("Error de clave, espere " + 30 * contadorIntentos + " segundos para el proximo ingreso de clave.");
                contadorIntentos++;
            }
        }

    }

}
