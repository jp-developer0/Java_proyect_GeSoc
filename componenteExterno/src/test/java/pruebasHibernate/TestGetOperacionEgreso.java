package pruebasHibernate;

import db.EntityManagerHelper;
import operacionEgreso.OperacionEgreso;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestGetOperacionEgreso {

    private OperacionEgreso oe;

    @Before
    public void init() {

    }


    @Test
    public void persistEgresoTest(){

        OperacionEgreso oe = (OperacionEgreso) EntityManagerHelper
                                .createQuery("from OperacionEgreso where id = 2").getSingleResult();
        //OBSERVACION: si no tienen una operacion con id=2 en su DB, les va a KBR
        System.out.println("Fecha de tu operacion es ---> "+oe.getFechaOperacion());

    }
}
