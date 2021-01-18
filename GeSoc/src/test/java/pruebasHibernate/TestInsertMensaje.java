package pruebasHibernate;


import db.EntityManagerHelper;
import operacionEgreso.CriterioProveedor.MenorValor;
import operacionEgreso.OperacionEgreso;
import org.junit.Before;
import org.junit.Test;
import usuario.mensajes.Mensaje;
import validador.CriterioProveedor;

public class TestInsertMensaje {

    private Mensaje mensaje;

    public TestInsertMensaje() {
    }

    @Before


    public void init() {
        OperacionEgreso egreso = new OperacionEgreso();
        mensaje = new Mensaje(true,true,true,4,egreso);

    }

    @Test
    public void persistMensajeTest(){

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(this.mensaje);
        EntityManagerHelper.commit();


    }
}
