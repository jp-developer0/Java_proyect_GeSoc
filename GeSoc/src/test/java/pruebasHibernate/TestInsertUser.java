package pruebasHibernate;


import db.EntityManagerHelper;
import org.junit.Before;
import org.junit.Test;
import usuario.Usuario;

import java.util.*;

public class TestInsertUser {

    private Usuario user;

    public TestInsertUser() {
    }

    @Before
    public void init() {

        user = new Usuario();
        user.setUsuario("admin");
        user.setPassword("admin");

    }

    @Test
    public void persistEgresoTest(){

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(this.user);
        EntityManagerHelper.commit();


    }
}
