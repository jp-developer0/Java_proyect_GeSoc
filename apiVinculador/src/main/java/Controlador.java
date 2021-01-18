import com.google.gson.Gson;
import com.google.gson.*;
import operaciones.*;

import org.json.JSONException;
import org.json.JSONObject;
import procesoVinculacion.*;
import spark.Request;
import spark.Response;

import javax.json.Json;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Controlador {

    Gson gson = new Gson();
    LocalDate dateDesde = LocalDate.of(1969, Calendar.FEBRUARY, 07);
    LocalDate dateHasta = LocalDate.of(2021, Calendar.FEBRUARY, 07);

    public LocalDate getDateDesde() {
        return dateDesde;
    }

    public void setDateDesde(LocalDate dateDesde) {
        this.dateDesde = dateDesde;
    }

    public LocalDate getDateHasta() {
        return dateHasta;
    }

    public void setDateHasta(LocalDate dateHasta) {
        this.dateHasta = dateHasta;
    }

    public Object vincular(Request request, Response response) throws JSONException {
        Gson g = new Gson();
        String stringObject = request.params("id");
        Operaciones operetas = g.fromJson(stringObject, Operaciones.class);

        System.out.println(stringObject);

        ProcesoVinculacion pv = new ProcesoVinculacion();
        PeriodoDeAceptabilidad pa = new PeriodoDeAceptabilidad();
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
        System.out.println(jsonOperaciones);

        return jsonOperaciones;

    }

}

