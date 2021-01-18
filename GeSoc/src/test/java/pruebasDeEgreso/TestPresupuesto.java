package pruebasDeEgreso;
import operacionEgreso.DocumentoComercial;
import operacionEgreso.Item;
import operacionEgreso.Presupuesto;
import operacionEgreso.Proveedor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class TestPresupuesto {
    private Presupuesto presupuesto;
    private DocumentoComercial documentoComercialA;
    private DocumentoComercial documentoComercialB;
    private List<Item> items;
    private Item itemA;
    private Item itemB;
    private Proveedor proveedor;

    public TestPresupuesto() {
    }

    @Before
    public void init() {
        this.itemA = new Item("detalle del item A", 1200.4F,1);
        this.itemB = new Item("detalle del item B", 836.9F,1);
        this.items = new ArrayList();
        this.items.add(this.itemA);
        this.documentoComercialA = new DocumentoComercial("facturaA", 1234, "facturaA.jpg", "noTenemos");
        this.documentoComercialB = new DocumentoComercial("facturaB", 4321, "facturaB.jpg", "noTenemosTampoco");
        this.proveedor = new Proveedor("ElQueProvee S.A.", "ID341", "calleFalsa 123");
        this.presupuesto = new Presupuesto("detalle", this.documentoComercialA, this.items, this.proveedor);
    }

    @Test
    public void chequeoEntidad() {
        Assert.assertEquals("detalle", this.presupuesto.getDetalle());
        Assert.assertEquals(654.5D, this.presupuesto.getTotal(), 0.0D);
        Assert.assertEquals(this.documentoComercialA, this.presupuesto.getDocumentoComercial());
        Assert.assertEquals(this.items, this.presupuesto.getItems());
        Assert.assertEquals(this.proveedor, this.presupuesto.getProveedor());
    }
}
