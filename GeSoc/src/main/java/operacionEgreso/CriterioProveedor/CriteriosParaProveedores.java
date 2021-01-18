package operacionEgreso.CriterioProveedor;

import operacionEgreso.OperacionEgreso;
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
   public abstract String getDescripcion();
}

