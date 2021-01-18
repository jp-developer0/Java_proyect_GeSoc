package pruebasClasificacionEgresos;
import criterioClasificacionEgresos.CategoriaEgreso;
import criterioClasificacionEgresos.CriterioEgreso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCriterioEgreso {
    private CriterioEgreso criterio;
    private CriterioEgreso criterioPadre;
    private CategoriaEgreso categoriaA;
    private CategoriaEgreso categoriaB;
    private List<CategoriaEgreso> categorias;
    private List<CategoriaEgreso> categoriasParaProbar;

    public TestCriterioEgreso() {
    }

    @Before
    public void init() {
        this.criterio = new CriterioEgreso((CriterioEgreso)null, "Descripcion");
        this.criterioPadre = new CriterioEgreso((CriterioEgreso)null, "ElDaddy");
        this.categoriaA = new CategoriaEgreso("CategoriaEgresoA");
        this.categoriaB = new CategoriaEgreso("CategoriaEgresoB");
        this.categorias = new ArrayList();
        this.categoriasParaProbar = new ArrayList();
        this.categorias.add(this.categoriaA);
        this.categorias.add(this.categoriaB);
        this.categoriasParaProbar.add(this.categoriaA);
        this.categoriasParaProbar.add(this.categoriaB);
    }

    @Test
    public void chequeoEntidad() {
        Assert.assertEquals((Object)null, this.criterio.getCriterioPadre());
        Assert.assertEquals("Descripcion", this.criterio.getDescripcion());
    }

    @Test
    public void chequeoSETCriterioPadre() {
        this.criterio.setCriterioPadre(this.criterioPadre);
        Assert.assertEquals(this.criterioPadre, this.criterio.getCriterioPadre());
    }

    @Test
    public void chequeoSETCategoriasEgreso() {
        this.criterio.setCategoriasEgreso(this.categorias);
        Assert.assertEquals(this.categorias, this.criterio.getCategoriasEgreso());
    }

    @Test
    public void chequeoSETDescripcion() {
        this.criterio.setDescripcion("CambioDeDescripcion");
        Assert.assertEquals("CambioDeDescripcion", this.criterio.getDescripcion());
    }

    @Test
    public void agregarCategoria() {
        CategoriaEgreso categoriaC = new CategoriaEgreso("CategoriaEgresoC");
        this.criterio.setCategoriasEgreso(this.categorias);
        this.criterio.agregarCategoria(categoriaC);
        this.categoriasParaProbar.add(categoriaC);
        Assert.assertEquals(this.categoriasParaProbar, this.criterio.getCategoriasEgreso());
    }

    @Test
    public void borrarCategoria() {
        this.criterio.setCategoriasEgreso(this.categorias);
        this.criterio.borrarCategoria(this.categoriaA);
        this.categoriasParaProbar.remove(this.categoriaA);
        Assert.assertEquals(this.categoriasParaProbar, this.criterio.getCategoriasEgreso());
    }
}
