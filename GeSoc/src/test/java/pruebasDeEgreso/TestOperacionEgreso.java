package pruebasDeEgreso;

import criterioClasificacionEgresos.CategoriaEgreso;
import operacionEgreso.CriterioProveedor.CriteriosParaProveedores;
import operacionEgreso.CriterioProveedor.MenorValor;
import operacionEgreso.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.Usuario;
import usuario.mensajes.Mensaje;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestOperacionEgreso {
    private OperacionEgreso operacionEgreso;
    private MedioDePago paypal;
    private MedioDePago rapidcash;
    private LocalDate fechaA;
    private LocalDate fechaB;
    private List<Presupuesto> presupuestos;
    private CriteriosParaProveedores criterioProveedor;
    private List<Usuario> revisores;
    private Presupuesto presupuestoA;

    public TestOperacionEgreso() {
    }

    @Before
    public void init() {
        this.paypal = new MedioDePago();
        this.rapidcash = new MedioDePago();
        this.fechaA = LocalDate.now();
        this.fechaB = LocalDate.now();
        this.presupuestos = new ArrayList();
        this.presupuestoA = new Presupuesto("PresupuestoA", (DocumentoComercial)null, (List)null, (Proveedor)null);
        this.criterioProveedor = new MenorValor();
        this.revisores = new ArrayList();
        this.operacionEgreso = new OperacionEgreso(this.paypal, this.fechaA, false, 0, this.presupuestos, this.criterioProveedor, this.revisores, (float) 0);
    }

    @Test
    public void chequeoIdentidad() {
        Assert.assertEquals(this.paypal, this.operacionEgreso.getMedioDePago());
        Assert.assertEquals(this.fechaA, this.operacionEgreso.getFechaOperacion());
        Assert.assertEquals(false, this.operacionEgreso.getRequierePresupuestos());
        Assert.assertEquals(0L, (long)this.operacionEgreso.getCantidadPresupuestosRequeridos());
        Assert.assertEquals(this.presupuestos, this.operacionEgreso.getPresupuestos());
        Assert.assertEquals(this.criterioProveedor, this.operacionEgreso.getCriterioProveedor());
        Assert.assertEquals(this.revisores, this.operacionEgreso.getRevisores());
        Assert.assertNull(this.operacionEgreso.getPresupuestoElegido());
        Assert.assertNull(this.operacionEgreso.getCategoriasEgreso());
        Assert.assertNull(this.operacionEgreso.getMensaje());
    }

    @Test
    public void chequeoSETMedioPago() {
        this.operacionEgreso.setMedioDePago(this.rapidcash);
        Assert.assertEquals(this.rapidcash, this.operacionEgreso.getMedioDePago());
    }

    @Test
    public void chequeoSETFechaOperacion() {
        this.operacionEgreso.setFechaOperacion(this.fechaB);
        Assert.assertEquals(this.fechaB, this.operacionEgreso.getFechaOperacion());
    }

    @Test
    public void chequeoSETRequierePresupuestos() {
        this.operacionEgreso.setRequierePresupuestos(true);
        Assert.assertTrue(this.operacionEgreso.getRequierePresupuestos());
    }

    @Test
    public void chequeoSETCantidadPresupuestosRequeridos() {
        this.operacionEgreso.setCantidadPresupuestosRequeridos(5);
        Assert.assertEquals(5L, (long)this.operacionEgreso.getCantidadPresupuestosRequeridos());
    }

    @Test
    public void chequeoSETPresupuestos() {
        List<Presupuesto> presupuestosDePrueba = new ArrayList();
        this.operacionEgreso.setPresupuestos(presupuestosDePrueba);
        Assert.assertEquals(presupuestosDePrueba, this.operacionEgreso.getPresupuestos());
    }

    @Test
    public void chequeoSETPresupuestoElegido() {
        Presupuesto presupuestoB = new Presupuesto("PresupuestoB", (DocumentoComercial)null, (List)null, (Proveedor)null);
        this.operacionEgreso.setPresupuestoElegido(presupuestoB);
        Assert.assertEquals(presupuestoB, this.operacionEgreso.getPresupuestoElegido());
    }

    @Test
    public void chequeoSETCriterioProveedor() {
        MenorValor criterioDePrueba = new MenorValor();
        this.operacionEgreso.setCriterioProveedor(criterioDePrueba);
        Assert.assertEquals(criterioDePrueba, this.operacionEgreso.getCriterioProveedor());
    }

    @Test
    public void chequeoSETCategoriaEgreso() {
        CategoriaEgreso categoriaDePrueba = new CategoriaEgreso("Categoria de prueba");
        this.operacionEgreso.addCategoria(categoriaDePrueba);
        Assert.assertEquals(categoriaDePrueba, this.operacionEgreso.getCategoriasEgreso());
    }

    @Test
    public void chequeoSETRevisores() {
        List<Usuario> revisoresDePrueba = new ArrayList();
        this.operacionEgreso.setRevisores(revisoresDePrueba);
        Assert.assertEquals(revisoresDePrueba, this.operacionEgreso.getRevisores());
    }

    @Test
    public void chequeoSETMensaje() {
        Mensaje mensajeDePrueba = new Mensaje();
        this.operacionEgreso.setMensaje(mensajeDePrueba);
        Assert.assertEquals(mensajeDePrueba, this.operacionEgreso.getMensaje());
    }
}
