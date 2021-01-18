package usuario;


import categoria.CategoriaEmpresa;
import criterioClasificacionEgresos.CriterioEgreso;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "jerarquizarCriterios")
public class JerarquizadorCriterios extends Permiso{

    public void jerarquizar(CriterioEgreso padre, CriterioEgreso hijo){
        hijo.setCriterioPadre(padre);
    }
}