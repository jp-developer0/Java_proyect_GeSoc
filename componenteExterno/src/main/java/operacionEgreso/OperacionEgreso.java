package operacionEgreso;

import operacionIngreso.OperacionIngreso;
import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class OperacionEgreso extends EntidadPersistente {
    @Column(columnDefinition = "DATE")
    private Date fechaOperacion;
    @Column
    private boolean requierePresupuestos;
    @Column
    private int cantidadPresupuestosRequeridos = 0;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "operacion_egreso_id")
    private List<Presupuesto> presupuestos;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Presupuesto presupuestoElegido;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<OperacionIngreso> ingresos;


    //region settersAndGetters

    public List<OperacionIngreso> getIngresos() {
        return ingresos;
    }
    public void setIngresos(List<OperacionIngreso> ingresos) {
        this.ingresos = ingresos;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }
    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public boolean getRequierePresupuestos() {
        return requierePresupuestos;
    }
    public void setRequierePresupuestos(boolean requierePresupuestos) {
        this.requierePresupuestos = requierePresupuestos;
    }

    public int getCantidadPresupuestosRequeridos() {
        return cantidadPresupuestosRequeridos;
    }
    public void setCantidadPresupuestosRequeridos(int cantidadPresupuestosRequeridos) {
        this.cantidadPresupuestosRequeridos = cantidadPresupuestosRequeridos;
    }

    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }
    public void setPresupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

    public Presupuesto getPresupuestoElegido() {
        return presupuestoElegido;
    }
    public void setPresupuestoElegido(Presupuesto presupuestoElegido) {
        this.presupuestoElegido = presupuestoElegido;
    }

    //endregion

    public OperacionEgreso () {

    }

}
