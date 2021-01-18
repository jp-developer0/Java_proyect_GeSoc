package validador;

import operacionEgreso.CriterioProveedor.MenorValor;
import operacionEgreso.OperacionEgreso;
import operacionEgreso.Presupuesto;

public class CriterioProveedor extends Condicion {
    @Override
    public boolean teCumplisCon(OperacionEgreso egreso) {
        MenorValor menorValor = new MenorValor();
        Presupuesto presupuestoSegunCriterio, presupuestoElegido;
        //egreso.setCriterioProveedor(menorValor);
        //presupuestoSegunCriterio = egreso.getCriterioProveedor().aplicarCriterio(egreso.getPresupuestos());
        presupuestoSegunCriterio = menorValor.aplicarCriterio(egreso.getPresupuestos());
        presupuestoElegido = egreso.getPresupuestoElegido();

        return presupuestoSegunCriterio.equals(presupuestoElegido);
    }
}