package categoria.tipoDeEmpresa.actividad;

import categoria.tipoDeEmpresa.TipoEmpresa;
import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Actividad extends EntidadPersistente {

    @Column
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="tipoEmpresa_id", nullable = false)
    private List<TipoEmpresa> tiposEmpresa;

    public List<TipoEmpresa> getTiposEmpresa() {
        return this.tiposEmpresa;
    }

    public Actividad(){}
    public Actividad(String nombre, List<TipoEmpresa> tiposEmpresa) {
        this.nombre = nombre;
        this.tiposEmpresa = tiposEmpresa;
    }

}
