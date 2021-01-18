package usuario;

import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public abstract class TipoDeUsuario extends EntidadPersistente {
    @Column
    private String tipo;

    @ManyToMany
    private List<Permiso> permisos;

}
