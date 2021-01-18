package pruebasDeUsuario.pruebasDeMensajes;

import domain.EntidadJuridica;
import fj.P;
import operacionEgreso.*;
import operacionEgreso.CriterioProveedor.CriteriosParaProveedores;
import operacionEgreso.CriterioProveedor.MenorValor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.Usuario;
import usuario.mensajes.Mensaje;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class TestMensaje {

    private OperacionEgreso egreso;
    private MedioDePago paypal;
    private MedioDePago rapidcash;
    private LocalDate fechaA = LocalDate.of(2020,10,12);
    private LocalDate fechaB = LocalDate.of(2020,9,3);
    private List<Presupuesto> presupuestos;
    private CriteriosParaProveedores criterioProveedor;
    private List<Usuario> revisores;
    private Presupuesto presupuestoA;
    private Mensaje mensaje;

    public TestMensaje() {
    }

    @Before
    public void init() {

        this.paypal = new MedioDePago();
        this.rapidcash = new MedioDePago();
        this.presupuestos = new ArrayList();
        //this.presupuestoA = new Presupuesto("PresupuestoA", 358.0F, (DocumentoComercial)null, (List)null, (Proveedor)null);
        this.criterioProveedor = new MenorValor();
        this.revisores = new ArrayList();
        MenorValor criterioProveedorMenorValor = new MenorValor();




        //egreso.setCriterioProveedor(criterioProveedorMenorValor);
        //egreso.setCantidadPresupuestosRequeridos(2);

        // 1° Presupuesto

        Item i1p1 = new Item("PINTURA Z10 LATEX SUPERCUBRITIVO 20L",9900L,1);
        Item i2p1 = new Item("PINTURA LOXON FTES IMPERMEABILIZANTE 10L", 7200L,1);
        Item i3p1 = new Item("PINTURA BRIKOL PISOS NEGRO 4L", 4350L,1);
        List<Item> p1Items = new ArrayList<>();
        p1Items.add(i1p1);
        p1Items.add(i2p1);
        p1Items.add(i3p1);
        EntidadJuridica EAAFBA=new EntidadJuridica();
        Proveedor pintureriasREX=new Proveedor();

        Presupuesto presupuesto1 = new Presupuesto("", null,p1Items,pintureriasREX);
        presupuesto1.setEntidadJuridica(EAAFBA);
        presupuesto1.setFecha(LocalDate.of(2020, 2, 25));


        // 2° Presupuesto
        Item i1p2 = new Item("PINTURA Z10 LATEX SUPERCUBRITIVO 20L",9610L,1);;
        Item i2p2 = new Item("PINTURA LOXON FTES IMPERMEABILIZANTE 10L", 6590L,1);
        Item i3p2 = new Item("PINTURA BRIKOL PISOS NEGRO 4L", 4100L,1);
        List<Item> p2Items = new ArrayList<>();
        p2Items.add(i1p2);
        p2Items.add(i2p2);
        p2Items.add(i3p2);
        Proveedor pintureriasSanJorge=new Proveedor();
        Presupuesto presupuesto2 = new Presupuesto("", null, p2Items, pintureriasSanJorge);
        presupuesto2.setEntidadJuridica(EAAFBA);
        presupuesto2.setFecha(LocalDate.of(2020, 2, 26));

        presupuestos.add(presupuesto1);
        presupuestos.add(presupuesto2);

        this.egreso = new OperacionEgreso(this.paypal, this.fechaA, true, 2, this.presupuestos, criterioProveedorMenorValor, this.revisores, (float) 0.1);

        //egreso.getPresupuestos().add(presupuesto1);
        //egreso.getPresupuestos().add(presupuesto2);

        egreso.setPresupuestoElegido(presupuesto2);

        List<OperacionEgreso> egresos2=new ArrayList<>();
        egresos2.add(egreso);

        EAAFBA.setEgresos(egresos2);

        EAAFBA.getValidador().validar();

        this.mensaje = EAAFBA.getBandejaDeMensajes().get(0);

        //this.mensaje = new Mensaje(true, true, true,1,egreso);
    }

//    @Test
//    public void chequeoIdentidad() {
//        Assert.assertEquals(true, this.mensaje.isProveedorElegidoXCriterio());
//        Assert.assertEquals(true, this.mensaje.isCantPresupuestos());
//        Assert.assertEquals(true, this.mensaje.isCompraPresupuestoCargado());
//    }
//
//    @Test
//    public void chequeoSETProveedorElegidoPorCriterio() {
//        this.mensaje.setProveedorElegidoXCriterio(false);
//        Assert.assertEquals(false, this.mensaje.isProveedorElegidoXCriterio());
//    }
//
//    @Test
//    public void chequeoSETCantPresupuestos() {
//        this.mensaje.setCantPresupuestos(false);
//        Assert.assertEquals(false, this.mensaje.isCantPresupuestos());
//    }

//    @Test
//    public void chequeoSETCompraPresupuestoCargado() {
//        this.mensaje.setCompraPresupuestoCargado(false);
//        Assert.assertEquals(false, this.mensaje.isCompraPresupuestoCargado());
//    }
}
