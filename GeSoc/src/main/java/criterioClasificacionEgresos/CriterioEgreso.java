package criterioClasificacionEgresos;

import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table
public class CriterioEgreso extends EntidadPersistente {
    @OneToOne
    private CriterioEgreso criterioPadre;
    @Column
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="id")
    private List<CategoriaEgreso> categoriasEgreso;

    public CriterioEgreso() {
        this.categoriasEgreso=new ArrayList<CategoriaEgreso>();
    }

    public CriterioEgreso getCriterioPadre() {
        return criterioPadre;
    }
    public void setCriterioPadre(CriterioEgreso criterioPadre) {
        this.criterioPadre = criterioPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void addCategoria(CategoriaEgreso cat){
        this.categoriasEgreso.add(cat);
    }
    public List<CategoriaEgreso> getCategoriasEgreso() {
        return categoriasEgreso;
    }
    public void setCategoriasEgreso(List<CategoriaEgreso> categoriasEgreso) {
        this.categoriasEgreso = categoriasEgreso;
    }

    public CriterioEgreso(CriterioEgreso criterioPadre, String descripcion) {
        this.criterioPadre = criterioPadre;
        this.descripcion = descripcion;
        this.categoriasEgreso = new ArrayList<CategoriaEgreso>();
    }

    public void agregarCategoria(CategoriaEgreso categoria){
        this.categoriasEgreso.add(categoria);
    }

    public void borrarCategoria(CategoriaEgreso categoria){
        this.categoriasEgreso.remove(categoria);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriterioEgreso that = (CriterioEgreso) o;
        return Objects.equals(criterioPadre, that.criterioPadre) &&
                Objects.equals(descripcion, that.descripcion);
    }
}
