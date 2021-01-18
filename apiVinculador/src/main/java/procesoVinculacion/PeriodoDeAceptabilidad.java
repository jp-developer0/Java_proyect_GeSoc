package procesoVinculacion;

import operaciones.OperacionEgreso;
import operaciones.OperacionIngreso;
import operaciones.Operaciones;

import java.time.LocalDate;
import java.util.Date;

public class PeriodoDeAceptabilidad implements CondicionObligatoria {

    private LocalDate fechaDesde;
    private LocalDate fechaHasta;

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaLimite) {
        this.fechaHasta = fechaLimite;
    }

    @Override
    public boolean cumpleCon(OperacionEgreso unEgreso) {//ver si incluye el dia porque no hay after before equal

        return fechaDesde.isBefore(unEgreso.getFechaOperacion()) && fechaHasta.isAfter(unEgreso.getFechaOperacion());
    }
}
