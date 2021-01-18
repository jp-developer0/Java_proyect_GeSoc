package pruebasDeEgreso;
import operacionEgreso.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestItem {
    private Item item;

    public TestItem() {
    }

    @Before
    public void init() {
        this.item = new Item("detalle", 1200.4F,1);
    }

    @Test
    public void chequeoEntidad() {
        Assert.assertEquals("detalle", this.item.getDetalle());
        Assert.assertEquals(1200.45F, this.item.getValor(), 0.1F);
    }

    @Test
    public void chequeoSETDetalle() {
        this.item.setDetalle("detalleDePrueba");
        Assert.assertEquals("detalleDePrueba", this.item.getDetalle());
    }

    @Test
    public void chequeoSETValor() {
        this.item.setValor(6789.0F);
        Assert.assertEquals(6789.0F, this.item.getValor(), 0.1F);
    }
}
