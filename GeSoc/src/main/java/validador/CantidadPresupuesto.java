package validador;

import operacionEgreso.OperacionEgreso;

public class CantidadPresupuesto extends Condicion {

    @Override
    public boolean teCumplisCon(OperacionEgreso egreso) {
        int cantPresupuestos = egreso.getPresupuestos().size();
        int cantPresupuestosObligatorios = egreso.getCantidadPresupuestosRequeridos();
        return cantPresupuestosObligatorios == cantPresupuestos;
    }
}
