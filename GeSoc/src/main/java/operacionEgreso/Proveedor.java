package operacionEgreso;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Proveedor extends EntidadPersistente {
    @Column
    private String nombre;
    @Column
    private String identificador;
    @Column
    private String direccionPostal;

    public Proveedor() {

    }

    //region settersAndGetters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }
    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    //endregion
    public Proveedor(String nombre, String identificador, String direccionPostal) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.direccionPostal = direccionPostal;
    }
}
