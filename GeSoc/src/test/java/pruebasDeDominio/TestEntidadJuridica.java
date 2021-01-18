package pruebasDeDominio;

import apiRest.ApiMercadoLibre;
import apiRest.Cities;
import apiRest.Country;
import apiRest.States;
import categoria.CategoriaEmpresa;
import criterioClasificacionEgresos.CategoriaEgreso;
import criterioClasificacionEgresos.CriterioEgreso;
import direccionPostal.Direccion;
import direccionPostal.DireccionPostal;
import domain.EntidadBase;
import domain.EntidadJuridica;
import operacionEgreso.DocumentoComercial;
import operacionEgreso.Item;
import operacionEgreso.MedioDePago;
import operacionEgreso.OperacionEgreso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestEntidadJuridica {

    private EntidadJuridica entidadJuridicaA;
    private EntidadJuridica entidadJuridicaB;
    private EntidadBase unaEntidadBase;
    private List<EntidadBase> unaListaDeEntidadesBase;
    private List<EntidadBase> otraListaDeEntidadesBase;
    private CategoriaEmpresa unaCategoriaEmpresa;
    private CategoriaEmpresa otraCategoriaEmpresa;
    private List<OperacionEgreso> unaListaDeEgresos;
    private List<OperacionEgreso> otraListaDeEgresos;
    private List<Usuario> unaListaDeUsuarios;
    private List<Usuario> otraListaDeUsuarios;
    //private Administrador administrador;
    //private Estandar estandar;
    private DireccionPostal direccionPostal;
    private Direccion direccion;
    private OperacionEgreso operacionEgreso;
    private MedioDePago paypal;
    private List<Item> itemsA;
    private DocumentoComercial documentoComercialA;
    private Date fechaA;

    public TestEntidadJuridica() {
    }

    @Before
    public void init() throws IOException {
        this.unaListaDeEntidadesBase = new ArrayList();
        this.otraListaDeEntidadesBase = new ArrayList();
        this.unaListaDeEgresos = new ArrayList();
        this.otraListaDeEgresos = new ArrayList();
        this.unaListaDeUsuarios = new ArrayList();
        this.unaEntidadBase = new EntidadBase("Entidad Base A", "Es la primer entidad base para pruebas");
        this.paypal = new MedioDePago();
        this.itemsA = new ArrayList();
        this.direccion = new Direccion("Calle Falsa", 123, "4D");
        this.direccionPostal = new DireccionPostal("C.A.B.A.", "Buenos Aires", "Argentina", direccion);
        this.documentoComercialA = new DocumentoComercial("factura", 1234, "adjunto", "transac");
        this.fechaA = new Date(1590540149L);
        this.otraListaDeEgresos.add(this.operacionEgreso);
        this.otraListaDeEgresos.add(this.operacionEgreso);
        this.otraListaDeEgresos.add(this.operacionEgreso);
        this.entidadJuridicaA = new EntidadJuridica("Entidad Juridica S.A.", "Ntidad Shuridik", "30-75542553-9", direccionPostal, "", this.unaListaDeEntidadesBase, this.unaCategoriaEmpresa, this.unaListaDeEgresos, this.unaListaDeUsuarios);
        this.entidadJuridicaB = new EntidadJuridica("Entidad Juridica B S.A.", "Ntidad Shuridik B2PLUS", "30-56147825-4", direccionPostal, "", this.unaListaDeEntidadesBase, this.unaCategoriaEmpresa, this.otraListaDeEgresos, this.unaListaDeUsuarios);
    }

    @Test
    public void chequeoEntidad() {
        Assert.assertEquals("Entidad Juridica S.A.", this.entidadJuridicaA.getRazonSocial());
        Assert.assertEquals("Ntidad Shuridik", this.entidadJuridicaA.getNombreFicticio());
        Assert.assertEquals("30-75542553-9", this.entidadJuridicaA.getCuit());
        Assert.assertEquals(this.direccionPostal, this.entidadJuridicaA.getDireccionPostal());
        Assert.assertEquals("", this.entidadJuridicaA.getCodigoInscripcion());
        Assert.assertEquals(this.unaListaDeEntidadesBase, this.entidadJuridicaA.getEntidadesBase());
        Assert.assertEquals(this.unaCategoriaEmpresa, this.entidadJuridicaA.getCategoria());
        Assert.assertEquals(this.unaListaDeEgresos, this.entidadJuridicaA.getEgresos());
        Assert.assertEquals(this.unaListaDeUsuarios, this.entidadJuridicaA.getUsuarios());
        Assert.assertNotNull(this.entidadJuridicaA.getCriteriosEgreso());
        Assert.assertNotNull(this.entidadJuridicaA.getBandejaDeMensajes());
        Assert.assertNotNull(this.entidadJuridicaA.getValidador());
    }

    @Test
    public void chequeoSetRazonSocial() {
        this.entidadJuridicaA.setRazonSocial("Razon Social Para Prueba S.A.");
        Assert.assertEquals("Razon Social Para Prueba S.A.", this.entidadJuridicaA.getRazonSocial());
    }

    @Test
    public void chequeoSetNombreFicticio() {
        this.entidadJuridicaA.setNombreFicticio("Ntidad De Prueba");
        Assert.assertEquals("Ntidad De Prueba", this.entidadJuridicaA.getNombreFicticio());
    }

    @Test
    public void chequeoSetCuit() {
        this.entidadJuridicaA.setCuit("30-12345678-3");
        Assert.assertEquals("30-12345678-3", this.entidadJuridicaA.getCuit());
    }

    @Test
    public void chequeoSetDireccionPostal() {
        this.entidadJuridicaA.setDireccionPostal(direccionPostal);
        Assert.assertEquals(direccionPostal, this.entidadJuridicaA.getDireccionPostal());
    }

    @Test
    public void chequeoSetCodigoInscripcion() {
        this.entidadJuridicaA.setCodigoInscripcion("504123");
        Assert.assertEquals("504123", this.entidadJuridicaA.getCodigoInscripcion());
    }

    @Test
    public void chequeoSetEntidadesBase() {
        this.otraListaDeEntidadesBase.add(this.unaEntidadBase);
        this.entidadJuridicaA.setEntidadesBase(this.otraListaDeEntidadesBase);
        Assert.assertEquals(this.otraListaDeEntidadesBase, this.entidadJuridicaA.getEntidadesBase());
    }

    @Test
    public void chequeoSetCategoria() {
        this.entidadJuridicaA.setCategoria(this.otraCategoriaEmpresa);
        Assert.assertEquals(this.otraCategoriaEmpresa, this.entidadJuridicaA.getCategoria());
    }

    @Test
    public void chequeoSetEgresos() {
        this.entidadJuridicaA.setEgresos(this.otraListaDeEgresos);
        Assert.assertEquals(this.otraListaDeEgresos, this.entidadJuridicaA.getEgresos());
    }

    @Test
    public void chequeoSetUsuarios() {
        this.entidadJuridicaA.setUsarios(this.otraListaDeUsuarios);
        Assert.assertEquals(this.otraListaDeUsuarios, this.entidadJuridicaA.getUsuarios());
    }

    @Test
    public void chequeoRegistrarEgreso() {
        this.entidadJuridicaA.registrarEgreso(this.operacionEgreso);
        this.entidadJuridicaA.registrarEgreso(this.operacionEgreso);
        this.entidadJuridicaA.registrarEgreso(this.operacionEgreso);
        Assert.assertEquals(this.otraListaDeEgresos, this.entidadJuridicaA.getEgresos());
    }

    @Test
    public void chequeoCrearUsuarioAdmin() {
       // Usuario usuarioA = new Usuario("usuA", "AusurioaA123", this.administrador);
      //  this.entidadJuridicaA.crearUsuario("usuA", "AusurioaA123", "Estandar");
     //   Assert.assertEquals(usuarioA, this.entidadJuridicaA.getUsuarios().get(0));
    }

    @Test
    public void chequeoCrearUsuarioEstandar() {
        //Usuario usuarioA = new Usuario("usuA", "AusurioaA123", this.estandar);
     //   this.entidadJuridicaA.crearUsuario("usuA", "AusurioaA123", "Estandar");
      //  Assert.assertEquals(usuarioA, this.entidadJuridicaA.getUsuarios().get(0));
    }

    @Test
    public void chequeoCrearCriterioEgreso() {
        this.entidadJuridicaA.crearCriterioEgreso((CriterioEgreso)null, "Criterio egreso para testing");
        CriterioEgreso criterioParaTesting = new CriterioEgreso(null, "");
        criterioParaTesting = (CriterioEgreso)this.entidadJuridicaA.getCriteriosEgreso().get(0);
        Assert.assertNull(criterioParaTesting.getCriterioPadre());
        Assert.assertEquals("Criterio egreso para testing", criterioParaTesting.getDescripcion());
    }

    @Test
    public void chequeoCrearCategoriaEgreso() {
        CriterioEgreso criterioParaTestearCategoriaEgreso = new CriterioEgreso((CriterioEgreso)null, "Criterio egreso para testing");
        this.entidadJuridicaA.crearCategoriaEgreso("Categoria egreso para testing", criterioParaTestearCategoriaEgreso);
        Assert.assertEquals("Categoria egreso para testing", ((CategoriaEgreso)criterioParaTestearCategoriaEgreso.getCategoriasEgreso().get(0)).getDescripcion());
    }
}
