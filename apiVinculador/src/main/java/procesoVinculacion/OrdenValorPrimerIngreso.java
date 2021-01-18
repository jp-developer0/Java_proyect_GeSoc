package procesoVinculacion;

import operaciones.OperacionEgreso;
import operaciones.OperacionIngreso;
import operaciones.Operaciones;

import java.util.Comparator;
import java.util.List;

public class OrdenValorPrimerIngreso implements EstrategiaCriterioEjecucion {
    @Override
    public Operaciones vincular(Operaciones operaciones){
        int i = 0, j = 0;
        List<OperacionEgreso> egresos = operaciones.getEgresos();
        egresos.sort(Comparator.comparing(OperacionEgreso::getTotal));
        List<OperacionIngreso> ingresos = operaciones.getIngresos();
        ingresos.sort(Comparator.comparing(OperacionIngreso::getMontoTotal));
        while(egresos.size() > i){
            while(ingresos.size() > j){
                if((egresos.get(i).getIngresos() == null) && puedoAgregarEgreso(egresos.get(i), ingresos.get(j))){
                    ingresos.get(j).addEgreso(egresos.get(i).getId());
                    egresos.get(i).setIngresos(ingresos.get(j).getId());
                    ingresos.get(j).setMontoRestante(ingresos.get(j).getMontoRestante() - egresos.get(i).getTotal());
                }
                j++;
            }
            j = 0;
            i++;
        }
        operaciones.setEgresos(egresos);
        operaciones.setIngreso(ingresos);
        return operaciones;
    }

    private boolean puedoAgregarEgreso(OperacionEgreso egreso, OperacionIngreso ingreso){
        if(egreso.getTotal() <= ingreso.getMontoRestante()){ return true; }
        return false;
    }
}
