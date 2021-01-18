package pruebasDeValidador;

import apiRest.ApiMercadoLibre;
import apiRest.Cities;
import apiRest.Country;
import apiRest.States;
import categoria.CategoriaEmpresa;
import direccionPostal.Direccion;
import direccionPostal.DireccionPostal;
import domain.EntidadBase;
import domain.EntidadJuridica;
import operacionEgreso.CriterioProveedor.MenorValor;
import operacionEgreso.DocumentoComercial;
import operacionEgreso.Item;
import operacionEgreso.MedioDePago;
import operacionEgreso.OperacionEgreso;
import org.junit.Before;
import usuario.Usuario;
import validador.CriterioProveedor;
import validador.Validador;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestValidador {

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
   // private Administrador administrador;
    //private Estandar estandar;
    private OperacionEgreso operacionEgreso;
    private MedioDePago paypal;
    private List<Item> itemsA;
    private ApiMercadoLibre api;
    private DireccionPostal direccionPostal;
    private Direccion direccion;
    private DocumentoComercial documentoComercialA;
    private Date fechaA;
    private Validador miValidadorParaProbar;
    private CriterioProveedor miCriterioProveedor = new CriterioProveedor();
    private MenorValor menorValor = new MenorValor();

    public TestValidador() {
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
        this.miValidadorParaProbar = new Validador(this.entidadJuridicaA);
    }


}
