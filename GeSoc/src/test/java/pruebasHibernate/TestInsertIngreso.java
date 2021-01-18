package pruebasHibernate;


import static org.junit.Assert.*;

import db.EntityManagerHelper;
import operacionEgreso.OperacionEgreso;
import operacionIngreso.OperacionIngreso;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import usuario.Usuario;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.*;

public class TestInsertIngreso {

    private OperacionIngreso oi;

    public TestInsertIngreso() {
    }

    @Before
    public void init() {


        LocalDate date = LocalDate.of(2020, Calendar.FEBRUARY, 07);
        System.out.println(date);
        oi = new OperacionIngreso("delamanodelrojo", 5, date,date);

        OperacionEgreso oe1 = new OperacionEgreso();
        oe1.setTotal(500);
        OperacionEgreso oe2 = new OperacionEgreso();
        oe2.setTotal(200);
        List<OperacionEgreso> lista = new ArrayList<>();
        lista.add(oe1);
        lista.add(oe2);

        oi.setOperacionesEgreso(lista);

    }

    @Test
    public void persistEgresoTest(){

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(this.oi);
        EntityManagerHelper.commit();


    }
}
