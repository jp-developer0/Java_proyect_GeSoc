package operaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperacionIngreso {
    private Integer id;
    private LocalDate fechaOperacion;
    //private LocalDate fechaLimiteAceptabilidadEgresos;
    private float montoTotal;
    private float saldoRemanente;
    private List<Integer> egresos = new ArrayList<>();

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

    public float getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public float getMontoRestante() {
        return saldoRemanente;
    }
    public void setMontoRestante(float montoRestante) {
        this.saldoRemanente = montoRestante;
    }

    public List<Integer> getEgresos() {
        return egresos;
    }
    public void setEgresos(List<Integer> egresos) {
        this.egresos = egresos;
    }
/*
    public LocalDate getFechaLimiteAceptabilidadEgresos() {
        return fechaLimiteAceptabilidadEgresos;
    }

    public void setFechaLimiteAceptabilidadEgresos(LocalDate fechaLimiteAceptabilidadEgresos) {
        this.fechaLimiteAceptabilidadEgresos = fechaLimiteAceptabilidadEgresos;
    }

 */
    public void addEgreso(Integer egreso) { egresos.add(egreso); }
}
