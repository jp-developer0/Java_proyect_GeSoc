package procesoVinculacion;

import operaciones.OperacionEgreso;
import operaciones.Operaciones;

public interface CondicionObligatoria {
    public boolean cumpleCon(OperacionEgreso oe);
}
