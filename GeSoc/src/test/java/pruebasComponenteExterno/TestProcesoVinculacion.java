package pruebasComponenteExterno;

import java.io.IOException;
import apiRest.ApiComponenteExterno;
import categoria.tipoDeEmpresa.TipoEmpresa;
import com.google.gson.*;
import com.google.gson.Gson;
import apiRest.ApiComponenteExterno;
import apiRest.ApiMercadoLibre;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import db.EntityManagerHelper;
import operacionEgreso.EgresoDTO;
import operacionEgreso.OperacionEgreso;
import operacionEgreso.VinculadorOperaciones;
import operacionIngreso.IngresoDTO;
import operacionIngreso.OperacionIngreso;
import org.hsqldb.error.Error;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestProcesoVinculacion {


    public static void main(String[] args) throws IOException {



        VinculadorOperaciones vin= new VinculadorOperaciones();
        //vin.cargarListas();
        Gson g = new Gson();
        String jsonOperaciones = g.toJson(vin);
        System.out.println(jsonOperaciones);

        ApiComponenteExterno apiComponenteExterno = ApiComponenteExterno.instancia();
        Response response = null;
        try {

            response = apiComponenteExterno.enviarJson(jsonOperaciones);

            VinculadorOperaciones vo = (VinculadorOperaciones) response.body();

            for (IngresoDTO oidto : vo.getIngresos()){
                OperacionIngreso oii = (OperacionIngreso) EntityManagerHelper.createQuery("from OperacionIngreso where id = " + oidto.getId()).getSingleResult();
                for(Integer oedto : oidto.getEgresos()){
                    OperacionEgreso oee = (OperacionEgreso) EntityManagerHelper.createQuery("from OperacionEgreso where id = " + oedto).getSingleResult();
                    oii.getOperacionesEgreso().add(oee);
                    oii.setSaldoRemanente(oii.getSaldoRemanente()-oee.getTotal());
                }

                EntityManagerHelper.beginTransaction();
                EntityManagerHelper.entityManager().merge(oii);
                EntityManagerHelper.commit();
            }

            System.out.println(response.body());










        } catch (Exception e) {
            e.printStackTrace();
        }

        //sql



//      Lo que hizo jp
//        String json1 = "meMandaronDesdeGsoc";
//
//        ApiComponenteExterno apiComponenteExterno = ApiComponenteExterno.instancia();
//        Response<String> response = null;
//        try {
//            response = apiComponenteExterno.enviarJson(json1);
//            System.out.println(response.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



//        List<OperacionIngreso> oe =( List<OperacionIngreso>) EntityManagerHelper
//               .createQuery("select o.id, o.montoTotal, o.fechaOperacion from OperacionIngreso as o ").getResultList();
//
//        String jso = g.toJson(oe);
//        System.out.println(jso);

        // System.out.println(g.toJson(vin));

//        Gson gson;
//        Gson gson2;
//        String jsonEgresos = "[";
//        String jsonIngresos = "[";
//        String aux = "";
//
//        List<OperacionEgreso> loe = (List<OperacionEgreso>) EntityManagerHelper
//                .createQuery("from OperacionEgreso where ingreso_id IS NULL").getResultList();
//
//        Boolean first = true;
//        for (OperacionEgreso oe : loe) {
//            if (!first)
//                jsonEgresos = jsonEgresos + ",";
//            else
//                first = false;
//            gson = new Gson();
//            aux = gson.toJson(oe);
//            jsonEgresos = jsonEgresos + aux ;
//        }
//        jsonEgresos = jsonEgresos + "]";
//        System.out.println(jsonEgresos);
//
//        List<OperacionIngreso> loi = (List<OperacionIngreso>) EntityManagerHelper
//                .createQuery("from OperacionIngreso oi " +
//                        " where oi.id IN " +
//                        " (select oe.ingreso.id from OperacionEgreso oe " +
//                        " WHERE oe.ingreso.id = oi.id " +
//                        " GROUP BY oe.ingreso.id " +
//                        " HAVING SUM(coalesce(oe.total, 0)) < oi.montoTotal " +
//                        ")" +
//                        "").getResultList();
//
//        Boolean fifirst = true;
//        for (OperacionIngreso oi : loi) {
//            if (!fifirst)
//                jsonIngresos = jsonIngresos + ",";
//            else
//                fifirst = false;
//            gson2 = new Gson();
//            aux = gson2.toJson(oi);
//            jsonIngresos = jsonIngresos + aux ;
//        }
//        jsonIngresos = jsonIngresos + "]";
//        System.out.println(jsonIngresos);
//
//        //ApiComponenteExterno apiComponenteExterno = ApiComponenteExterno.instancia();
//        //JsonObject gsonObj = apiComponenteExterno.getHandShake();
//        //String name = gsonObj.get("name").getAsString();
//
//

            //Prueba saldo remanente
  //        List<OperacionIngreso> oe = (List<OperacionIngreso>) EntityManagerHelper
//                .createQuery("from " + OperacionIngreso.class.getName()).getResultList();
//        List<IngresoDTO> ingresos = (List<IngresoDTO>) oe.stream().map(t->t.convertirDto(t)).collect(Collectors.toList());
//        for(IngresoDTO i:ingresos){
//            System.out.println(i.getSaldoRemanente());
//        }

        //      Prueba de listas de ingresos y egresos por separado
//        List<OperacionIngreso> oe = (List<OperacionIngreso>) EntityManagerHelper
//                .createQuery("from "+ OperacionIngreso.class.getName()).getResultList();
//        List<IngresoDTO> ingresos = (List<IngresoDTO>) oe.stream().map(t->t.convertirDto(t)).collect(Collectors.toList());
//        Gson j = new Gson();
//        String son = j.toJson(ingresos);
//        System.out.println(son);
//        for(IngresoDTO e:ingresos){
//            System.out.println(e.getId());
//        }
//        List<OperacionEgreso> e = (List<OperacionEgreso>) EntityManagerHelper
//                .createQuery("from "+ OperacionEgreso.class.getName()).getResultList();
//        List<EgresoDTO> egresos = (List<EgresoDTO>) e.stream().map(t->t.convertirDto(t)).collect(Collectors.toList());
//        Gson jj = new Gson();
//        String sonn = jj.toJson(egresos);
//        System.out.println(sonn);

    }
}
