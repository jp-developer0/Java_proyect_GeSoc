package pruebasDeEgreso;
import operacionEgreso.DocumentoComercial;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestDocumentoComercial {
    private DocumentoComercial documentoComercial;

    public TestDocumentoComercial() {
    }

    @Before
    public void init() {
        this.documentoComercial = new DocumentoComercial("factura", 1234, "factura.jpg", "noTenemos");
    }

    @Test
    public void chequeoEntidad() {
        Assert.assertEquals("factura", this.documentoComercial.getTipo());
        Assert.assertEquals(1234L, (long)this.documentoComercial.getNumero());
        Assert.assertEquals("factura.jpg", this.documentoComercial.getAdjunto());
        Assert.assertEquals("noTenemos", this.documentoComercial.getTransaccionesYOtras());
    }

    @Test
    public void chequeoSETTipo() {
        this.documentoComercial.setTipo("tipoDePrueba");
        Assert.assertEquals("tipoDePrueba", this.documentoComercial.getTipo());
    }

    @Test
    public void chequeoSETNumero() {
        this.documentoComercial.setNumero(6789);
        Assert.assertEquals(6789L, (long)this.documentoComercial.getNumero());
    }

    @Test
    public void chequeoSETAdjunto() {
        this.documentoComercial.setAdjunto("fotoDeVacaciones.png");
        Assert.assertEquals("fotoDeVacaciones.png", this.documentoComercial.getAdjunto());
    }

    @Test
    public void chequeoSETTransaccionesYOtras() {
        this.documentoComercial.setTransaccionesYOtras("transaccionDePrueba");
        Assert.assertEquals("transaccionDePrueba", this.documentoComercial.getTransaccionesYOtras());
    }
}
