package operaciones;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class OperacionEgreso {
    private Integer id;
    private LocalDate fechaOperacion;
    private float montoTotal;
    private Integer ingresoID;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }
    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public float getTotal() {
        return montoTotal;
    }
    public void setTotal(float total) {
        this.montoTotal = total;
    }

    public Integer getIngresos() {
        return ingresoID;
    }
    public void setIngresos(Integer ingresoID) {
        this.ingresoID = ingresoID;
    }
}
