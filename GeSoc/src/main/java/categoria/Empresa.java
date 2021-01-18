package categoria;

import categoria.tipoDeEmpresa.TipoEmpresa;
import categoria.tipoDeEmpresa.actividad.Actividad;

import javax.persistence.*;

@Entity
@Table
@DiscriminatorValue("empresa")
public class Empresa extends CategoriaEmpresa  {

     @Column
    private int cantidadDePersonal;
    @Column
    private float promedioVentasAnuales;

    @ManyToOne(cascade = CascadeType.ALL)
    private TipoEmpresa tipoEmpresa;
    @ManyToOne(cascade = CascadeType.ALL)
    private Actividad actividad;


    //region gettersAndSetters
    public int getCantidadDePersonal() {
        return cantidadDePersonal;
    }
    public void setCantidadDePersonal(int cantidadDePersonal) {
        this.cantidadDePersonal = cantidadDePersonal;
    }

    public Actividad getActividad() {
        return actividad;
    }
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public float getPromedioVentasAnuales() {
        return promedioVentasAnuales;
    }
    public void setPromedioVentasAnuales(float promedioVentasAnuales) {
        this.promedioVentasAnuales = promedioVentasAnuales;
    }

    public String getNombreTipoEmpresa() {
        return tipoEmpresa.getNombre();
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }
    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }
    //endregion

    public void asignarTipoEmpresa(TipoEmpresa tipo) {
        this.setTipoEmpresa(tipo);
    }

    public String queTipo() {
        return this.tipoEmpresa.getNombre();
    }

    public Empresa(){}
    public Empresa(int cantidadDePersonal, float promedioVentasAnuales, Actividad actividad) {
        this.cantidadDePersonal = cantidadDePersonal;
        this.promedioVentasAnuales = promedioVentasAnuales;
        this.actividad = actividad;
        //Clasificador clasificador= Clasificador.getInstance();
        //clasificador.clasificar(this);
    }
}
