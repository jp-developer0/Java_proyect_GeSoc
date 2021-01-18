package direccionPostal;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Direccion extends EntidadPersistente {
    @Column
    private String calle;
    @Column
    private int altura;
    @Column
    private String pisoYDpto;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getPisoYDpto() {
        return pisoYDpto;
    }

    public void setPisoYDpto(String pisoYDpto) {
        this.pisoYDpto = pisoYDpto;
    }

    public Direccion(String calle, int altura, String pisoYDpto){
        this.calle = calle;
        this.altura = altura;
        this.pisoYDpto = pisoYDpto;
    }
    public Direccion(){};

}
