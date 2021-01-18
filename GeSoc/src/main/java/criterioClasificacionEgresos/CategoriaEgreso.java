package criterioClasificacionEgresos;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table

public class CategoriaEgreso extends EntidadPersistente {
    @Column
    private String descripcion;

    public CategoriaEgreso() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public CategoriaEgreso(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
