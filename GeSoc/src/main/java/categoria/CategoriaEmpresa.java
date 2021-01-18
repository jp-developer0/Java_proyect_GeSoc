package categoria;

import persistencia.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria")
public abstract class CategoriaEmpresa extends EntidadPersistente {



}
