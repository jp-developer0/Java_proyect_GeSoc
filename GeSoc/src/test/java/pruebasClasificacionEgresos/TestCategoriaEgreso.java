package pruebasClasificacionEgresos;

import criterioClasificacionEgresos.CategoriaEgreso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCategoriaEgreso {
        private CategoriaEgreso categoriaEgreso;

        public TestCategoriaEgreso() {
        }

        @Before
        public void init() {
            this.categoriaEgreso = new CategoriaEgreso("Esta es una categoria para testing");
        }

        @Test
        public void chequeoEntidad() {
            Assert.assertEquals("Esta es una categoria para testing", this.categoriaEgreso.getDescripcion());
        }
    }

