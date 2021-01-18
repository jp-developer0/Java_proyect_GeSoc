package pruebasDeEgreso;

import operacionEgreso.CriterioProveedor.MenorValor;
import operacionEgreso.DocumentoComercial;
import operacionEgreso.Item;
import operacionEgreso.Presupuesto;
import operacionEgreso.Proveedor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCriteriosParaProveedores {
    private MenorValor criterioMenorValor;
    private List<Item> itemsA;
    private List<Item> itemsB;
    private Proveedor starbucks;
    private Proveedor bonafide;
    private DocumentoComercial documentoComercialA;
    private DocumentoComercial documentoComercialB;
    private Presupuesto presupuestoMasCaro;
    private Presupuesto presupuestoB;
    private Presupuesto presupuestoMasEconomico;
    private List<Presupuesto> presupuestos;

    public TestCriteriosParaProveedores() {
    }

    @Before
    public void init() {
        this.criterioMenorValor = new MenorValor();
        this.itemsA = new ArrayList();
        this.itemsB = new ArrayList();
        this.starbucks = new Proveedor("Starbucks", "STA", "Falsedad 1234");
        this.bonafide = new Proveedor("Bonafide", "BON", "Av. Perdida 552");
        this.documentoComercialA = new DocumentoComercial("factura", 1234, "adjunto", "transac");
        this.documentoComercialB = new DocumentoComercial("ticket", 6571, "teDeboUnAdjunto", "otras");
        this.presupuestoMasCaro = new Presupuesto("presupuestoMasCaro", this.documentoComercialA, this.itemsA, this.starbucks);
        this.presupuestoB = new Presupuesto("presupuestoB",  this.documentoComercialA, this.itemsB, this.bonafide);
        this.presupuestoMasEconomico = new Presupuesto("presupuestoMasEconomico", this.documentoComercialB, this.itemsA, this.bonafide);
        this.presupuestos = new ArrayList();
        this.presupuestos.add(this.presupuestoMasCaro);
        this.presupuestos.add(this.presupuestoB);
        this.presupuestos.add(this.presupuestoMasEconomico);
    }

    @Test
    public void testMenorValor() {
        Assert.assertEquals(this.presupuestoMasEconomico, this.criterioMenorValor.aplicarCriterio(this.presupuestos));
        Assert.assertNotEquals(this.presupuestoB, this.criterioMenorValor.aplicarCriterio(this.presupuestos));
        Assert.assertNotEquals(this.presupuestoMasCaro, this.criterioMenorValor.aplicarCriterio(this.presupuestos));
    }

}
