package operacionEgreso;


import criterioClasificacionEgresos.CategoriaEgreso;
import domain.EntidadJuridica;
import persistencia.EntidadPersistente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table
public class Presupuesto extends EntidadPersistente {
    @Column(name="fecha",columnDefinition = "DATE")
    private LocalDate fecha;
    @Column
    private String detalle;
    @Column
    private float total;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DocumentoComercial documentoComercial;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name ="item_id",referencedColumnName = "id")
    private List<Item> items;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Proveedor proveedor;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<CategoriaEgreso> categoriasEgreso;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JoinColumn(referencedColumnName = "id",name = "operacionEgreso_id")
    private OperacionEgreso operacionEgreso;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EntidadJuridica entidadJuridica;

    public Presupuesto() {
    this.items=new ArrayList<>();
    }

    public void setDocumentoComercial(DocumentoComercial documentoComercial) {
        this.documentoComercial = documentoComercial;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public OperacionEgreso getOperacionEgreso() {
        return operacionEgreso;
    }

    public void setOperacionEgreso(OperacionEgreso operacionEgreso) {
        this.operacionEgreso = operacionEgreso;
    }
    public List<CategoriaEgreso> getCategoriasEgreso() {
        return categoriasEgreso;
    }

    public void setCategoriasEgreso(List<CategoriaEgreso> categoriasEgreso) {
        this.categoriasEgreso = categoriasEgreso;
    }
    public EntidadJuridica getEntidadJuridica() {
        return entidadJuridica;
    }

    public void setEntidadJuridica(EntidadJuridica entidadJuridica) {
        this.entidadJuridica = entidadJuridica;
    }

    //region settersAndGetters
    public String getDetalle() {
        return detalle;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public DocumentoComercial getDocumentoComercial() {
        return documentoComercial;
    }

    public List<Item> getItems() {
        return items;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    //endregion

    public Presupuesto(String detalle, DocumentoComercial documentoComercial, List < Item > items,Proveedor proveedor){

            this.detalle = detalle;
            //this.obtenerTotal();
            this.documentoComercial = documentoComercial;
            this.items = items;
            this.proveedor=proveedor;
            //this.categoriasEgreso=operacionEgreso.getCategoriasEgreso();//esta linea me rompe cuando quiero asociar las categorias del egreso al presupuesto
            //this.fecha=fecha;
        }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void obtenerTotal(){
        float total=0;

        for (Item item:items){
            total+=item.getValor()*item.getCantidad();
        }

        this.setTotal(total);
    }
}
