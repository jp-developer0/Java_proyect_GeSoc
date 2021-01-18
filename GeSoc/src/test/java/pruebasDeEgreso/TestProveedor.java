package pruebasDeEgreso;

import operacionEgreso.Proveedor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestProveedor {
    private Proveedor proveedor;

    public TestProveedor() {
    }

    @Before
    public void init() {
        this.proveedor = new Proveedor("laCasaDeLosMateriales", "CDLM", "Av. Del Pirata 1594");
    }

    @Test
    public void chequeoIdentidad() {
        Assert.assertEquals("laCasaDeLosMateriales", this.proveedor.getNombre());
        Assert.assertEquals("CDLM", this.proveedor.getIdentificador());
        Assert.assertEquals("Av. Del Pirata 1594", this.proveedor.getDireccionPostal());
    }

    @Test
    public void chequeoSETNombre() {
        this.proveedor.setNombre("elFerreteroLoco");
        Assert.assertEquals("elFerreteroLoco", this.proveedor.getNombre());
    }

    @Test
    public void chequeoSETIdentificador() {
        this.proveedor.setIdentificador("EFL");
        Assert.assertEquals("EFL", this.proveedor.getIdentificador());
    }

    @Test
    public void chequeoSETDireccionPostal() {
        this.proveedor.setDireccionPostal("Perla Negra 443");
        Assert.assertEquals("Perla Negra 443", this.proveedor.getDireccionPostal());
    }
}
