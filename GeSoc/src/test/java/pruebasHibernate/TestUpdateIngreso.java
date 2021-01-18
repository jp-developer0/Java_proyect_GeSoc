package pruebasHibernate;

import db.EntityManagerHelper;
import operacionIngreso.OperacionIngreso;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.time.LocalDate;
import java.util.Date;

public class TestUpdateIngreso extends AbstractPersistenceTest implements WithGlobalEntityManager {

private OperacionIngreso ingreso;

    @Before
    public void init() {
        LocalDate fecha = LocalDate.now();
        this.ingreso = new OperacionIngreso("descripcion del ingreso", 120,fecha,fecha);
    }

    @Test
    public void updateIngresoTest(){
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.entityManager().merge(this.ingreso);
        EntityManagerHelper.commit();
    }
}


