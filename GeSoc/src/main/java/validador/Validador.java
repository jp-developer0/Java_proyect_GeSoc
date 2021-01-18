package validador;

import domain.EntidadJuridica;
import operacionEgreso.OperacionEgreso;
import persistencia.EntidadPersistente;
import usuario.mensajes.Mensaje;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
//@Entity
//@Table
public class Validador {
    //@OneToOne
    private EntidadJuridica entidadJuridica;

    public Validador() {

    }

    private void scheduler(int tiempo) {//el tiempo es en microSegundos
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                validar();
            }
        };
        timer.schedule(tarea, tiempo * 1000);
    }

    public Mensaje  validarUnEgreso(OperacionEgreso egreso) {

        boolean cumpleCriterioProveedor;
        CriterioProveedor criterioProveedor = new CriterioProveedor();
        cumpleCriterioProveedor = criterioProveedor.teCumplisCon(egreso);

        boolean cumpleCantidadDePresupuestosObligatorios;
        CantidadPresupuesto cantidadPresupuesto = new CantidadPresupuesto();
        cumpleCantidadDePresupuestosObligatorios = cantidadPresupuesto.teCumplisCon(egreso);

        boolean comproSegunPresupuestoCargado;
        ComprarPorPresupuestoCargado comprarPorPresupuestoCargado = new ComprarPorPresupuestoCargado();
        comproSegunPresupuestoCargado = comprarPorPresupuestoCargado.teCumplisCon(egreso);

        int cantPresu= egreso.getPresupuestos().size();

        Mensaje mensaje = new Mensaje(cumpleCriterioProveedor, cumpleCantidadDePresupuestosObligatorios, comproSegunPresupuestoCargado, cantPresu,egreso);

        //egreso.setMensaje(mensaje);
        return mensaje;
       // this.depositarMensaje(mensaje);
    }

    private void depositarMensaje(Mensaje mensaje) {

        entidadJuridica.getBandejaDeMensajes().add(mensaje);
    }

    public List<Mensaje> validar() {
        List<Mensaje> mensajes = new ArrayList<>();
        List<OperacionEgreso> egresos = entidadJuridica.getEgresos();
        egresos=egresos.stream().filter(egreso -> !egreso.getPresupuestos().isEmpty()).collect(Collectors.toList());
        for (OperacionEgreso egreso:egresos){
            mensajes.add(validarUnEgreso(egreso));
        }
        return mensajes;
    }

    public Validador(EntidadJuridica entidadJuridica) {
        this.entidadJuridica = entidadJuridica;
        //this.scheduler(10);
    }
}
