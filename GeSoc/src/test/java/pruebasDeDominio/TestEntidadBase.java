package pruebasDeDominio;

import domain.EntidadBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEntidadBase {
    private EntidadBase entidadBase;

    public TestEntidadBase() {
    }

    @Before
    public void init() {
        this.entidadBase = new EntidadBase("Entidad Base de Prueba", "Esta es una entidad base que utilizamos para testing");
    }

    @Test
    public void chequeoEntidad() {
        Assert.assertEquals("Entidad Base de Prueba", this.entidadBase.getNombreFicticio());
        Assert.assertEquals("Esta es una entidad base que utilizamos para testing", this.entidadBase.getDescripcion());
    }

    @Test
    public void chequeoSETNombreFicticio() {
        this.entidadBase.setNombreFicticio("El nombre fue cambiado");
        Assert.assertEquals("El nombre fue cambiado", this.entidadBase.getNombreFicticio());
    }

    @Test
    public void chequeoSETDescripcion() {
        this.entidadBase.setDescripcion("La descripcion fue cambiada");
        Assert.assertEquals("La descripcion fue cambiada", this.entidadBase.getDescripcion());
    }
}
