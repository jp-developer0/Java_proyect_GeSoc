package operacionEgreso.criterioProveedor;

import operacionEgreso.Presupuesto;
import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class CriteriosParaProveedores extends EntidadPersistente {
   public abstract Presupuesto aplicarCriterio(List<Presupuesto> presupuestos);
}

