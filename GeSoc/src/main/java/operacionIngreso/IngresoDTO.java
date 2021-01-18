package operacionIngreso;

import operacionEgreso.EgresoDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class IngresoDTO {
    private int id;
    private LocalDate fechaOperacion;
    private float montoTotal;
    private float saldoRemanente;
    private List<Integer> egresos;

    public List<Integer> getEgresos() {
        return egresos;
    }

    public void setEgresos(List<Integer> egresos) {
        this.egresos = egresos;
    }

    public float getSaldoRemanente() {
        return saldoRemanente;
    }

    public void setSaldoRemanente(float saldoRemanente) {
        this.saldoRemanente = saldoRemanente;
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

    public IngresoDTO() {
    }
}
