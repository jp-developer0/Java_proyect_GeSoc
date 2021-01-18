package pruebasHibernate;

import db.EntityManagerHelper;
import operacionIngreso.OperacionIngreso;
import org.junit.Test;

public class testSelectIngreso {

    @Test
    public void getIngresoTest(){

        OperacionIngreso oi = (OperacionIngreso) EntityManagerHelper.createQuery("from OperacionIngreso where id = 1").getSingleResult();
        System.out.println("pone un breakpoint aca, DEBUGEA y mira el objeto oi en variables aver si se cargó Bien !!! ");


    }

}
