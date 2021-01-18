package operaciones;

import java.util.List;

public class Operaciones {
    private List<OperacionEgreso> egresos;
    private List<OperacionIngreso> ingresos;
    //private Integer criterio;

    public List<OperacionEgreso> getEgresos() {
        return egresos;
    }
    public void setEgresos(List<OperacionEgreso> egresos) {
        this.egresos = egresos;
    }

    public List<OperacionIngreso> getIngresos() {
        return ingresos;
    }
    public void setIngreso(List<OperacionIngreso> ingresos) {
        this.ingresos = ingresos;
    }

    public Operaciones(List<OperacionEgreso> egresos, List<OperacionIngreso> ingresos, Integer criterio) {
        this.egresos = egresos;
        this.ingresos = ingresos;
    }

    public String toString(){
        String egresos;
        return this.getEgresos().toString();
    }
}
