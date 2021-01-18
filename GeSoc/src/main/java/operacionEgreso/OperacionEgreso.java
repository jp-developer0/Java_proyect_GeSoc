package operacionEgreso;

import criterioClasificacionEgresos.CategoriaEgreso;
import domain.EntidadJuridica;
import operacionEgreso.CriterioProveedor.CriteriosParaProveedores;
import operacionIngreso.IngresoDTO;
import operacionIngreso.OperacionIngreso;
import persistencia.EntidadPersistente;
import usuario.mensajes.BandejaDeMensajes;
import usuario.Usuario;
import usuario.mensajes.Mensaje;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table
public class OperacionEgreso extends EntidadPersistente {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedioDePago medioDePago;
    @Column(name="fechaOperacion",columnDefinition = "DATE")
    private LocalDate fechaOperacion;
    @Column
    private boolean requierePresupuestos;
    @Column
    private int cantidadPresupuestosRequeridos = 0;

    //@OneToMany(mappedBy = "operacionEgreso",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "presupuesto_id",referencedColumnName = "id",nullable = true)//descomente esto
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Presupuesto> presupuestos =new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",name="presupuesto_id",nullable = true)
    private Presupuesto presupuestoElegido;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CriteriosParaProveedores criterioProveedor;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<CategoriaEgreso> categoriasEgreso=new ArrayList<>();

    @ManyToMany
    private List<Usuario> revisores=new ArrayList<>();;

    //@OneToMany(mappedBy = "egreso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(referencedColumnName = "id", name = "mensaje_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//OneToOne
    @JoinColumn(referencedColumnName = "id",name="mensaje_id")
    private Mensaje mensaje;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id",name="ingreso_id")//agregue para probar
    private OperacionIngreso ingreso;
    @Column
    private float total;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EntidadJuridica entidadJuridica;


    public OperacionEgreso(){}

    public OperacionEgreso(MedioDePago medioDePago, LocalDate fechaOperacion, boolean requierePresupuestos, int cantidadPresupuestosRequeridos, List<Presupuesto> presupuestos,
                           Presupuesto presupuestoElegido, CriteriosParaProveedores criterioProveedor, List<CategoriaEgreso> categoriasEgreso, OperacionIngreso ingreso,
                           float total) {
        this.medioDePago = medioDePago;
        this.fechaOperacion = fechaOperacion;
        this.requierePresupuestos = requierePresupuestos;
        this.cantidadPresupuestosRequeridos = cantidadPresupuestosRequeridos;
        this.presupuestos = presupuestos;
        this.presupuestoElegido = presupuestoElegido;
        this.criterioProveedor = criterioProveedor;
        this.categoriasEgreso = categoriasEgreso;
        this.revisores = revisores;
        this.mensaje = mensaje;
        this.ingreso = ingreso;
        this.total = total;
    }
    public void agregarPresupuesto(Presupuesto presupuesto){

        this.presupuestos.add(presupuesto);
    }
//region settersAndGetters

    public EntidadJuridica getEntidadJuridica() {
        return entidadJuridica;
    }

    public void setEntidadJuridica(EntidadJuridica entidadJuridica) {
        this.entidadJuridica = entidadJuridica;
    }
    public void addCategoria(CategoriaEgreso cat){
        this.categoriasEgreso.add(cat);
    }
    public Float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public OperacionIngreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(OperacionIngreso ingreso) {
        this.ingreso = ingreso;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }
    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }
    public void setFechaOperacion(LocalDate fechaOperacion) {
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
        this.total=presupuestoElegido.getTotal();
    }

    public CriteriosParaProveedores getCriterioProveedor() {
        return criterioProveedor;
    }
    public void setCriterioProveedor(CriteriosParaProveedores criterioProveedor) {
        this.criterioProveedor = criterioProveedor;
    }

    public List<CategoriaEgreso> getCategoriasEgreso() {
        return categoriasEgreso;
    }
    public void setCategoriasEgreso(List<CategoriaEgreso> categoriaEgreso) {
        this.categoriasEgreso = categoriaEgreso;
    }

    public List<Usuario> getRevisores() {
        return revisores;
    }
    public void setRevisores(List<Usuario> revisores) {
        this.revisores = revisores;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }
    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
    //endregion

    public OperacionEgreso( MedioDePago medioPago, LocalDate fechaOperacion, boolean requierePresupuestos, int cantidadPresupuestosRequeridos,
                            List<Presupuesto> presupuestos, CriteriosParaProveedores criterioProveedor, List<Usuario> revisores,float total) {
        this.medioDePago = medioPago;
        this.fechaOperacion = fechaOperacion;
        this.requierePresupuestos = requierePresupuestos;
        this.presupuestos = presupuestos;
        this.criterioProveedor = criterioProveedor;
        this.revisores = revisores;

       // this.presupuestoElegido = null;
        this.categoriasEgreso = null;
        this.mensaje = null;
        this.total=total;
        if (requierePresupuestos) {
            this.cantidadPresupuestosRequeridos = cantidadPresupuestosRequeridos;
        }
    }

    public void agregarRevisor(Usuario revisor) {
        revisores.add(revisor);
    }

    public Mensaje solicitarMensaje(Usuario usuario){
        if (revisores.contains(usuario)) {
            return this.getMensaje();
        }
        return null;
    }
    public EgresoDTO convertirDto(OperacionEgreso o) {
        EgresoDTO e=new EgresoDTO();
        e.setId(o.getId());
        e.setFechaOperacion(o.fechaOperacion);
        e.setMontoTotal((float) o.total);
        return e;
    }
    public String toString(){
        String s;
        s="(#"+this.getId()+" - $"+this.total+") ";
        return s;
    }
}
