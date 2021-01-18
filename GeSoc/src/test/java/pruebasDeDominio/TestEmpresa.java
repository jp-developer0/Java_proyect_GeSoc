package pruebasDeDominio;

import categoria.Clasificador;
import categoria.Empresa;
import categoria.tipoDeEmpresa.TipoEmpresa;
import categoria.tipoDeEmpresa.actividad.Actividad;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
public class TestEmpresa {
    private Actividad actividad;
    private TipoEmpresa microCons;
    private TipoEmpresa pequeCons;
    private TipoEmpresa med1Cons;
    private TipoEmpresa med2Cons;
    private Empresa empresa;

    public TestEmpresa() {
    }

    @Before
    public void init() {
        this.microCons = new TipoEmpresa("Micro-cons", 1.523E7F, 12.0F);
        this.pequeCons = new TipoEmpresa("Peque-cons", 9.031E7F, 45.0F);
        this.med1Cons = new TipoEmpresa("Med1-cons", 5.0388E8F, 200.0F);
        this.med2Cons = new TipoEmpresa("Med2-cons", 7.5574003E8F, 590.0F);
        ArrayList<TipoEmpresa> tipos = new ArrayList();
        tipos.add(this.microCons);
        tipos.add(this.pequeCons);
        tipos.add(this.med1Cons);
        tipos.add(this.med2Cons);
        this.actividad = new Actividad("Construccion", tipos);
    }

    @Test
    public void MicroStandar() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(10, 10000.0F, this.actividad);
        Assert.assertEquals("Micro-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void PequeStandar() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(40, 1.623E7F, this.actividad);
        Assert.assertEquals("Peque-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void PequeGanaPersonal() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(40, 2000.0F, this.actividad);
        Assert.assertEquals("Peque-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void PequeGanaVentas() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(10, 8.031E7F, this.actividad);
        Assert.assertEquals("Peque-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void Med1Standar() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(60, 9.931E7F, this.actividad);
        Assert.assertEquals("Med1-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void Med1GanaPersonal() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(60, 2000.0F, this.actividad);
        Assert.assertEquals("Med1-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void Med1GanaVentas() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(10, 9.931E7F, this.actividad);
        Assert.assertEquals("Med1-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void Med2Standar() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(300, 5.9388E8F, this.actividad);
        Assert.assertEquals("Med2-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void Med2GanaPersonal() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(300, 2000.0F, this.actividad);
        Assert.assertEquals("Med2-cons", this.empresa.getNombreTipoEmpresa());
    }

    @Test
    public void Med2GanaVentas() {
        Clasificador clasificador = Clasificador.getInstance();
        this.empresa = new Empresa(100, 5.9388E8F, this.actividad);
        Assert.assertEquals("Med2-cons", this.empresa.getNombreTipoEmpresa());
    }
}
