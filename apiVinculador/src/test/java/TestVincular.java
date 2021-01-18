import com.google.gson.Gson;
import operaciones.OperacionEgreso;
import operaciones.OperacionIngreso;
import operaciones.Operaciones;
import procesoVinculacion.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class TestVincular {

    public static void main(String[] args) throws IOException {
        Gson g = new Gson();
        String stringObject = "{'egresos':[{'id':1,'fechaOperacion':'Jan 17, 2020 12:00:00 AM','montoTotal':500.0},{'id':2,'fechaOperacion':'Jan 18, 2020 12:00:00 AM','montoTotal':200.0},{'id':3,'fechaOperacion':'Jan 19, 2020 12:00:00 AM','montoTotal':0.33}],'ingresos':[{'id':1,'fechaOperacion':'Feb 7, 2020 12:00:00 AM','montoTotal':200.33,'saldoRemanente':200.33}]}";
        Operaciones operetas = g.fromJson(stringObject,Operaciones.class);

        ProcesoVinculacion pv = new ProcesoVinculacion();
        PeriodoDeAceptabilidad pa = new PeriodoDeAceptabilidad();
        LocalDate dateDesde = LocalDate.of(2019, Calendar.FEBRUARY, 07);
        LocalDate dateHasta = LocalDate.of(2021, Calendar.FEBRUARY, 07);
        pa.setFechaDesde(dateDesde);
        pa.setFechaHasta(dateHasta);

        pv.setCondicion(pa);

        Operaciones aceptadas = pv.aceptarOperaciones(operetas);

        EstrategiaCriterioEjecucion ece1 = new Fecha();
        EstrategiaCriterioEjecucion ece2 = new OrdenValorPrimerEgreso();
        EstrategiaCriterioEjecucion ece3 = new OrdenValorPrimerIngreso();
        List<EstrategiaCriterioEjecucion> listaEstrategias = new ArrayList<>();
        listaEstrategias.add(ece1);
        listaEstrategias.add(ece2);
        listaEstrategias.add(ece3);

        EstrategiaCriterioEjecucion ece = new Mix(listaEstrategias, 3);


        Operaciones asignadas;
        asignadas = ece.vincular(aceptadas);

        String jsonOperaciones = g.toJson(asignadas);

//      return "asignadas";
    }


}
