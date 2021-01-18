package operacionEgreso.CriterioProveedor;

import categoria.Clasificador;
import operacionEgreso.Presupuesto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("MenorValor")
public class MenorValor extends CriteriosParaProveedores {
    private String descripcion;

    @Override
    public String getDescripcion() {
        return "Menor Valor";
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Declaración de Singleton
    //private static final MenorValor menorValor = new MenorValor();
    //public static MenorValor getInstance() {
     //   return menorValor;
    //}

    public Presupuesto aplicarCriterio(List<Presupuesto> presupuestos) {
        //List<Float> totales = new ArrayList<Float>();
        Presupuesto menor;
        menor = presupuestos.get(0);

        for (int i = 1; i < presupuestos.size(); i++) {
            if (menor.getTotal() > presupuestos.get(i).getTotal())
                menor = presupuestos.get(i);
        }

        return menor;
    }

    public boolean comparador(Presupuesto p1, Presupuesto p2){
        return p1.getTotal()<p2.getTotal();
    }

}