package operacionEgreso;


import persistencia.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table
public class Presupuesto extends EntidadPersistente {
    @Column
    private String detalle;
    @Column
    private float total;

    //region settersAndGetters
    public String getDetalle() {
        return detalle;
    }

    public float getTotal() {
        return total;
    }
    //endregion

    public Presupuesto(String detalle, float total){

            this.detalle = detalle;
            this.total = total;
        }
    }
