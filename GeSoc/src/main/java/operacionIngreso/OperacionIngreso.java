package operacionIngreso;

import domain.EntidadJuridica;
import operacionEgreso.EgresoDTO;
import operacionEgreso.OperacionEgreso;
import operacionEgreso.Presupuesto;
import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
public class OperacionIngreso extends EntidadPersistente {
    @Column
    private String descripcion;
    @Column
    private float montoTotal;
    @Column(name="fechaOperacion",columnDefinition = "DATE")
    private LocalDate fechaOperacion;

    @Column(name="fechaLimiteAceptabilidad",columnDefinition = "DATE")
    private LocalDate fechaLimiteAceptabilidadEgresos;//Marcos
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EntidadJuridica entidadJuridica;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",name = "operacion_ingreso_id")
    private List<OperacionEgreso> operacionesEgreso=new ArrayList<>();
    @Column
    private float saldoRemanente;




    public OperacionIngreso() {

    }

    //region settersAndGetters

    public String getEgreso() {
        String re="";
        for(OperacionEgreso e:this.getOperacionesEgreso())
        {
            re+=e.toString();
        }
        return re;
    }
    public EntidadJuridica getEntidadJuridica() {
        return entidadJuridica;
    }

    public void setEntidadJuridica(EntidadJuridica entidadJuridica) {
        this.entidadJuridica = entidadJuridica;
    }

    public float getSaldoRemanente() {
        return saldoRemanente;
    }

    public void setSaldoRemanente(float saldoRemanente) {
        this.saldoRemanente = saldoRemanente;
    }


    public List<OperacionEgreso> getOperacionesEgreso() {

        return operacionesEgreso;
    }

    public void setOperacionesEgreso(List<OperacionEgreso> operacionesEgreso) {
        this.operacionesEgreso = operacionesEgreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getDetalle() {return descripcion;}
    public void setDetalle(String detalle) {this.descripcion = detalle;}

    public float getTotal() {return montoTotal;}
    public void setTotal(float total) {this.montoTotal = total;}
    //endregion4

    public OperacionIngreso(String descripcion, float montoTotal, LocalDate fecha, LocalDate fechaLimiteAceptabilidadEgresos) {
        this.descripcion = descripcion;
        this.montoTotal = montoTotal;
        this.fechaOperacion=fecha;
        this.fechaLimiteAceptabilidadEgresos=fechaLimiteAceptabilidadEgresos;
        this.saldoRemanente = montoTotal;
    }

    public IngresoDTO convertirDto(OperacionIngreso o) {
        IngresoDTO e=new IngresoDTO();
        e.setId(o.getId());
        e.setFechaOperacion(o.fechaOperacion);
        e.setMontoTotal(o.montoTotal);
        e.setSaldoRemanente(o.saldoRemanente);

        List<OperacionEgreso> egresosFiltrados = o.getOperacionesEgreso().stream().filter(eg->!eg.getTotal().equals(null)).collect(Collectors.toList());
        List<Float> montosEgresos = egresosFiltrados.stream().map(t->t.getTotal()).collect(Collectors.toList());
        //List<Float> montosEgresos =o.getOperacionesEgreso().stream().map(t->t.getTotal()).collect(Collectors.toList());
        float saldoEgresos=0;
        for(float f:montosEgresos){
            saldoEgresos+=f;
        }
        //e.setSaldoRemanente(montoTotal-saldoEgresos); // esto hay qe verlo OJT
        return e;
    }
    public LocalDate getFechaLimiteAceptabilidadEgresos() {
        return fechaLimiteAceptabilidadEgresos;
    }

    public void setFechaLimiteAceptabilidadEgresos(LocalDate fechaLimiteAceptabilidadEgresos) {
        this.fechaLimiteAceptabilidadEgresos = fechaLimiteAceptabilidadEgresos;
    }

}
