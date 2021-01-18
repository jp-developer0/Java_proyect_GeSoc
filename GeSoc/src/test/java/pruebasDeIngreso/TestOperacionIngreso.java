package pruebasDeIngreso;

import operacionIngreso.OperacionIngreso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class TestOperacionIngreso {
    private OperacionIngreso ingreso;

    public TestOperacionIngreso() {
    }

    @Before
    public void init() {
        LocalDate d=LocalDate.now();
        this.ingreso = new OperacionIngreso("descripcion del ingreso", 556.8F,d,d);
    }

    @Test
    public void chequeoIdentidad() {
        Assert.assertEquals("descripcion del ingreso", this.ingreso.getDetalle());
        Assert.assertEquals(556.8F, this.ingreso.getTotal(), 0.0F);
    }

    @Test
    public void chequeoSETDetalle() {
        this.ingreso.setDetalle("el detalle cambia por la prueba");
        Assert.assertEquals("el detalle cambia por la prueba", this.ingreso.getDetalle());
    }

    @Test
    public void chequeoSETTotal() {
        this.ingreso.setTotal(443.0F);
        Assert.assertEquals(443.0F, this.ingreso.getTotal(), 0.0F);
    }
}
