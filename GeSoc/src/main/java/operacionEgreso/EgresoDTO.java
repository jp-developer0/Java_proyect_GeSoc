package operacionEgreso;

import operacionIngreso.IngresoDTO;
import persistencia.EntidadPersistente;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EgresoDTO {
    private int id;
    private LocalDate fechaOperacion;
    private float montoTotal;
    private Integer ingreso;

    public Integer getIngreso() {
        return ingreso;
    }

    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public EgresoDTO() {
    }
}
