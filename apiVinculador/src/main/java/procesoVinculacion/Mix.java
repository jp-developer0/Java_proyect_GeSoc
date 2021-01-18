package procesoVinculacion;


import operaciones.Operaciones;

import java.util.List;

public class Mix implements EstrategiaCriterioEjecucion {

    private List<EstrategiaCriterioEjecucion> estrategias;
    private int cantidadProcesosAejecutar;

    public List<EstrategiaCriterioEjecucion> getEstrategias() {
        return estrategias;
    }
    public void setEstrategias(List<EstrategiaCriterioEjecucion> estrategias) {
        this.estrategias = estrategias;
    }
    public void addEstrategia(EstrategiaCriterioEjecucion estrategia) { this.estrategias.add(estrategia); }

    public int getCantidadProcesosAejecutar() {
        return cantidadProcesosAejecutar;
    }
    public void setCantidadProcesosAejecutar(int cantidadProcesosAejecutar) {
        this.cantidadProcesosAejecutar = cantidadProcesosAejecutar;
    }

    public Mix(List<EstrategiaCriterioEjecucion> estrategias, int cantidadProcesosAejecutar){
        this.estrategias = estrategias;
        this.cantidadProcesosAejecutar = cantidadProcesosAejecutar;
    }

    @Override
    public Operaciones vincular(Operaciones operaciones) {

        for (int i = 0; i < cantidadProcesosAejecutar; i++) {
            estrategias.get(i).vincular(operaciones);

        }

        return operaciones;
    }
}
