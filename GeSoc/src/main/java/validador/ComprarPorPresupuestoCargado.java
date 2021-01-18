package validador;

import operacionEgreso.OperacionEgreso;
import operacionEgreso.Presupuesto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComprarPorPresupuestoCargado extends Condicion {
    @Override
    public boolean teCumplisCon(OperacionEgreso egreso) {

        List<Presupuesto> presupuestos = egreso.getPresupuestos();
        boolean bool=false;
        for(Presupuesto presupuesto:presupuestos){
            if(presupuesto.equals(egreso.getPresupuestoElegido())){
                bool=true;
                break;
            }
        }

        return bool;
    }
}
