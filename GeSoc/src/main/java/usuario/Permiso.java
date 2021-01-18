package usuario;

import persistencia.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "nombre")
public abstract class Permiso extends EntidadPersistente {

}
