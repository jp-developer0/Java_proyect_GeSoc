package direccionPostal;


import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class DireccionPostal extends EntidadPersistente {
    @Column
    private String ciudad;
    @Column
    private String provincia;
    @Column
    private String pais;
    @OneToOne
    private Direccion direccion;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public DireccionPostal(String ciudad, String provincia, String pais, Direccion direccion){
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.direccion = direccion;
    }  //La logica de build se realizará en la parte gráfica con comboBox limitando las opciones que se pueden elegir según la API de MeLi

    public DireccionPostal(){};
}
