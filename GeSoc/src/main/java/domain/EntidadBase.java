package domain;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class EntidadBase extends EntidadPersistente {
    @Column
    private String nombreFicticio;
    @Column
    private String descripcion;

    public EntidadBase() {

    }

    public String getNombreFicticio() {
        return nombreFicticio;
    }

    public void setNombreFicticio(String nombreFicticio) {
        this.nombreFicticio = nombreFicticio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EntidadBase(String nombreFicticio, String descripcion) {
        this.nombreFicticio = nombreFicticio;
        this.descripcion = descripcion;
    }

}
