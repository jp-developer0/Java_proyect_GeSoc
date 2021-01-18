package operacionIngreso;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class OperacionIngreso extends EntidadPersistente {
    @Column
    private String descripcion;
    @Column
    private float montoTotal;

    //region settersAndGetters
    public String getDetalle() {return descripcion;}
    public void setDetalle(String detalle) {this.descripcion = detalle;}

    public float getTotal() {return montoTotal;}
    public void setTotal(float total) {this.montoTotal = total;}
    //endregion4

    public OperacionIngreso(String descripcion, float montoTotal) {
        this.descripcion = descripcion;
        this.montoTotal = montoTotal;
    }
}
