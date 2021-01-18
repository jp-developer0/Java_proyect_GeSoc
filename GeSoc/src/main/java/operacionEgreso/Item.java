package operacionEgreso;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Item extends EntidadPersistente {
     @Column
    private String detalle;
    @Column
    private float valor;
    @Column
    private int cantidad;

    public Item() {

    }
     
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Item(String detalle, float valor, int c) {
        this.detalle = detalle;
        this.valor = valor;
         this.cantidad = c;
    }
}
