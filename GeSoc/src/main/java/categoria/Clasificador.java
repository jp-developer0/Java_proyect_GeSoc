package categoria;

import categoria.tipoDeEmpresa.TipoEmpresa;
import categoria.tipoDeEmpresa.actividad.Actividad;

import java.util.ArrayList;
import java.util.List;

public final class Clasificador {
//Utilice un singleton para que sea un WKO y que se instancie una sola vez ya que su funcion es una sola, clasificar.

    private static final Clasificador clasificador = new Clasificador();

    public static Clasificador getInstance() {
        return clasificador;
    }

    public void clasificar(Empresa empresa) {
        Actividad actividad = empresa.getActividad();
        List<TipoEmpresa> tipos = actividad.getTiposEmpresa();
        empresa.asignarTipoEmpresa(tipos.stream().filter(t -> t.cumpleConTipo(empresa.getCantidadDePersonal(),
                empresa.getPromedioVentasAnuales())).findFirst().get());

        /*
        for(TipoEmpresa tipo: tipos)
        {
            if(tipo.cumpleConTipo(empresa.getCantidadDePersonal(),empresa.getPromedioVentasAnuales()))
            {
                empresa.asignarTipoEmpresa(tipo);
            }
        }*/
    }

}
