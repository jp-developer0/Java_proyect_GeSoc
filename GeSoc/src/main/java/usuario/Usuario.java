package usuario;

import domain.EntidadJuridica;
import operacionEgreso.OperacionEgreso;
import persistencia.EntidadPersistente;
import usuario.mensajes.Mensaje;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table
public class Usuario extends EntidadPersistente {
    @Column
    private String usuario;
    @Column
    private String password;
    //@ManyToOne
    //private TipoDeUsuario tipoDeUsuario;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EntidadJuridica entidadJuridica;



    public EntidadJuridica getEntidadJuridica() {
        return entidadJuridica;
    }

    public void setEntidadJuridica(EntidadJuridica entidadJuridica) {
        this.entidadJuridica = entidadJuridica;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int contador = 1;

    public Usuario() {

    }

    public int tiempoEspera() {
        return contador * 30;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        ValidarContraseña validarContraseña = new ValidarContraseña();
        validarContraseña.setContraseña(password);
        boolean claveValida = validarContraseña.validar();
        if (claveValida) {
            this.password = password;
        } else {
            System.out.println("La clave es inválida, no se puede crear el usuario.");
        }
        //this.tipoDeUsuario = tipoDeUsuario;
    }

    //public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        //this.tipoDeUsuario = tipoDeUsuario;
    //}

    private void serRevisor(OperacionEgreso opeEgreso){
        opeEgreso.agregarRevisor(this);
    }

    public Mensaje verMensaje(OperacionEgreso opeEgreso) {
        return opeEgreso.solicitarMensaje(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(usuario, usuario1.usuario) &&
                Objects.equals(password, usuario1.password);
    }
}
