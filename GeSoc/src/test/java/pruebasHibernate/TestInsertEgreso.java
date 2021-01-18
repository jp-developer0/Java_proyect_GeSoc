package pruebasHibernate;


import static org.junit.Assert.*;

import db.EntityManagerHelper;
import operacionEgreso.*;
import operacionEgreso.CriterioProveedor.CriteriosParaProveedores;
import operacionEgreso.CriterioProveedor.MenorValor;
import operacionIngreso.OperacionIngreso;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import usuario.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestInsertEgreso {

    private OperacionEgreso operacionEgreso;
    private MedioDePago paypal;
    private MedioDePago rapidcash;
    private LocalDate fechaA;
    private LocalDate fechaB;
    private List<Presupuesto> presupuestos;
    private CriteriosParaProveedores criterioProveedor;
    private List<Usuario> revisores;
    private Presupuesto presupuestoA;

    public TestInsertEgreso() {
    }

    @Before
    public void init() {


        this.paypal = new MedioDePago();
        this.paypal.setMedio("Paypal");
        this.rapidcash = new MedioDePago();
        this.rapidcash.setMedio("RapidCash");
        this.fechaA = LocalDate.now();

        DocumentoComercial documentoComercialA = new DocumentoComercial("factura", 1234, "adjunto", "transac");
        Proveedor starbucks = new Proveedor("Starbucks", "STA", "Falsedad 1234");
        List<Item> itemsA = new ArrayList();
        this.fechaB = LocalDate.now();
        Presupuesto presupuestoMasCaro = new Presupuesto("presupuestoMasCaro", documentoComercialA, itemsA, starbucks);
        this.presupuestos = new ArrayList();
        this.presupuestos.add(presupuestoMasCaro);
        this.criterioProveedor = new MenorValor();
        this.revisores = new ArrayList();
        this.operacionEgreso = new OperacionEgreso(this.paypal,this.fechaA,false,0,this.presupuestos,null,this.criterioProveedor,null,null,0.33f);

    }

    @Test
    public void persistEgresoTest(){

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(this.operacionEgreso);
        EntityManagerHelper.commit();


    }
}
