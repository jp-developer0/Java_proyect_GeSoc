package usuario.mensajes;

import com.sun.org.apache.xpath.internal.operations.Bool;
import operacionEgreso.OperacionEgreso;
import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Mensaje extends EntidadPersistente {
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "egreso_id",referencedColumnName = "id")
    private OperacionEgreso egreso;
    @Column
    private boolean proveedorElegidoXCriterio;
    @Column
    private boolean cantPresupuestos;
    @Column
    private boolean compraPresupuestoCargado;
    @Column
    private int presupuestos;

    private LocalDate fecha;

    private String validacion;

    public String getEgreso(){return String.valueOf(this.egreso.getId());}

    public String getProveedorElegidoXCriterio(){return proveedorElegidoXCriterio==true?"Si":"No"; }

    public String getCantPresupuestos(){return cantPresupuestos==true?"Si":"No";}

    public String getCompraPresupuestoCargado(){return compraPresupuestoCargado==true?"Si":"No";}

    public LocalDate getFecha(){return egreso.getFechaOperacion();}

    public String getValidacion(){return proveedorElegidoXCriterio==true&&cantPresupuestos==true&&compraPresupuestoCargado==true?"Correcto":"Incorrecto";}
//    public int getPresupuestos() {
//        return (this.presupuestos);
//    }

    public void setPresupuestos(int presupuestos) {
        this.presupuestos = presupuestos;
    }




    public Mensaje() {

    }

    //region settersAndGetters
//    public boolean isProveedorElegidoXCriterio() {
//        return proveedorElegidoXCriterio;
//    }

    public void setProveedorElegidoXCriterio(boolean proveedorElegidoXCriterio) {
        this.proveedorElegidoXCriterio = proveedorElegidoXCriterio;
    }

//    public boolean isCantPresupuestos() {
//        return cantPresupuestos;
//    }
//
    public void setCantPresupuestos(boolean cantPresupuestos) {
        this.cantPresupuestos = cantPresupuestos;
    }

//    public boolean isCompraPresupuestoCargado() {
//        return compraPresupuestoCargado;
//    }

    public void setCompraPresupuestoCargado(boolean compraPresupuestoCargado) {
        this.compraPresupuestoCargado = compraPresupuestoCargado;
    }
    //endregion4

    public Mensaje(boolean proveedorElegidoXCriterio, boolean cantPresupuestos, boolean compraPresupuestoCargado,int p, OperacionEgreso egreso) {
        this.proveedorElegidoXCriterio = proveedorElegidoXCriterio;
        this.cantPresupuestos = cantPresupuestos;
        this.compraPresupuestoCargado = compraPresupuestoCargado;
        this.presupuestos=p;
        this.egreso=egreso;
        this.fecha=egreso.getFechaOperacion();
    }


}
