package operacionEgreso;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class DocumentoComercial extends EntidadPersistente {

    @Column
    private String tipo;
    @Column
    private int numero;
    @Column
    private String adjunto;
    @Column
    private String transaccionesYOtras;

    public DocumentoComercial() {

    }

    //region settersAndGetters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public String getTransaccionesYOtras() {
        return transaccionesYOtras;
    }

    public void setTransaccionesYOtras(String transaccionesYOtras) {
        this.transaccionesYOtras = transaccionesYOtras;
    }
    //endregion

    public DocumentoComercial(String tipo, int numero, String adjunto, String transaccionesYOtras) {
        this.tipo = tipo;
        this.numero = numero;
        this.adjunto = adjunto;
        this.transaccionesYOtras = transaccionesYOtras;
    }
}
