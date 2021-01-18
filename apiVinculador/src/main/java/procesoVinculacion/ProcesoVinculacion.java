package procesoVinculacion;

import operaciones.OperacionEgreso;
import operaciones.OperacionIngreso;
import operaciones.Operaciones;

import java.util.ArrayList;
import java.util.List;

public class ProcesoVinculacion {
    EstrategiaCriterioEjecucion estrategia;
    CondicionObligatoria condicion;


    public Operaciones aceptarOperaciones(Operaciones operaciones) {

        List<OperacionEgreso> aux = new ArrayList<>();
        for (OperacionEgreso oe:operaciones.getEgresos()) {
          if(condicion.cumpleCon(oe))
              aux.add(oe);
        }
        operaciones.setEgresos(aux);

        return operaciones;
    }


    public EstrategiaCriterioEjecucion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaCriterioEjecucion estrategia) {
        this.estrategia = estrategia;
    }

    public CondicionObligatoria getCondicion() {
        return condicion;
    }

    public void setCondicion(CondicionObligatoria condicion) {
        this.condicion = condicion;
    }
}

