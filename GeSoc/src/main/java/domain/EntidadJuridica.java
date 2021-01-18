package domain;


import categoria.CategoriaEmpresa;
import criterioClasificacionEgresos.CategoriaEgreso;
import criterioClasificacionEgresos.CriterioEgreso;
import direccionPostal.DireccionPostal;
import operacionEgreso.Presupuesto;
import operacionIngreso.OperacionIngreso;
import persistencia.EntidadPersistente;
import usuario.TipoDeUsuario;
import usuario.Usuario;
import operacionEgreso.OperacionEgreso;
import usuario.mensajes.BandejaDeMensajes;
import usuario.mensajes.Mensaje;
import validador.Validador;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class EntidadJuridica extends EntidadPersistente {

    //region atributos
    @Column
    private String razonSocial;
    @Column
    private String nombreFicticio;
    @Column
    private String cuit;
    @OneToOne
    private DireccionPostal direccionPostal;
    @Column
    private String codigoInscripcion;
    @OneToMany
    private List<EntidadBase> entidadesBase;
    @ManyToOne
    private CategoriaEmpresa categoria;
    @OneToMany
    private List<OperacionEgreso> egresos;
    @OneToMany
    private List<Presupuesto> presupuestos;

    @OneToMany
    private List<OperacionIngreso> ingresos;
    @OneToMany
    private List<Usuario> usuarios;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CriterioEgreso> criteriosEgreso;


    //@OneToOne(cascade = CascadeType.ALL)
    //private BandejaDeMensajes bandejaDeMensajes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Mensaje> bandejaDeMensajes;

    //@OneToOne(cascade = CascadeType.ALL)
    @Transient
    private Validador validador;
    //endregion



    //region settersAndGetters
    public List<Mensaje> getBandejaDeMensajes() {
        return bandejaDeMensajes;
    }
    public void setValidador(Validador validador) {
        this.validador = validador;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreFicticio() {
        return nombreFicticio;
    }
    public void setNombreFicticio(String nombreFicticio) {
        this.nombreFicticio = nombreFicticio;
    }

    public String getCuit() {
        return cuit;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public DireccionPostal getDireccionPostal() {
        return direccionPostal;
    }
    public void setDireccionPostal(DireccionPostal direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public String getCodigoInscripcion() {
        return codigoInscripcion;
    }
    public void setCodigoInscripcion(String codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }

    public List<EntidadBase> getEntidadesBase() {
        return entidadesBase;
    }
    public void setEntidadesBase(List<EntidadBase> entidadesBase) {
        this.entidadesBase = entidadesBase;
    }

    public CategoriaEmpresa getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaEmpresa categoria) {
        this.categoria = categoria;
    }

    public List<OperacionEgreso> getEgresos() {
        return egresos;
    }
    public void setEgresos(List<OperacionEgreso> egresos) {
        this.egresos = egresos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<CriterioEgreso> getCriteriosEgreso() {
        return criteriosEgreso;
    }

    public Validador getValidador() {
        return validador;
    }

    public List<OperacionIngreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<OperacionIngreso> ingresos) {
        this.ingresos = ingresos;
    }
    //endregion

    //region Constructor
    public EntidadJuridica(String razonSocial, String nombreFicticio, String cuit, DireccionPostal direccionPostal,
                           String codigoInscripcion, List<EntidadBase> entidadesBase, CategoriaEmpresa categoria,
                           List<OperacionEgreso> egresos, List<Usuario> usuarios) {
        this.razonSocial = razonSocial;
        this.nombreFicticio = nombreFicticio;
        this.cuit = cuit;
        this.direccionPostal = direccionPostal;
        this.codigoInscripcion = codigoInscripcion;
        this.entidadesBase = entidadesBase;
        this.categoria = categoria;
        this.egresos = egresos;
        this.usuarios = usuarios;
        this.criteriosEgreso = new ArrayList<CriterioEgreso>();
        this.validador = new Validador(this);

    }
    public  EntidadJuridica(){};
    //endregion

    public void crearUsuario(String nombre, String clave) {

       /* TipoDeUsuario tipo = null;
        if (tipoDeUsuario.matches("Administrador")) {
            tipo = new Administrador();
        }
        if (tipoDeUsuario.matches("Estandar")) {
            tipo = new Estandar();
        }*/
        Usuario usuario = new Usuario(nombre, clave);
        usuarios.add(usuario);
    }

    public void registrarEgreso(OperacionEgreso operacionEgreso) {
        this.egresos.add(operacionEgreso);
    }

    public void crearCriterioEgreso(CriterioEgreso criterioPadre, String descripcion) {
        CriterioEgreso criterioNuevo = new CriterioEgreso(criterioPadre, descripcion);
        this.criteriosEgreso.add(criterioNuevo);
    }

    public void crearCategoriaEgreso(String descripcion, CriterioEgreso criterio) {
        CategoriaEgreso categoriaNueva = new CategoriaEgreso(descripcion);
        //criterio.agregarCategoria(categoriaNueva);
    }
}
