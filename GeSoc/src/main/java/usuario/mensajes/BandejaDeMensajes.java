package usuario.mensajes;

import persistencia.EntidadPersistente;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class BandejaDeMensajes extends EntidadPersistente {
    @OneToMany(cascade = CascadeType.ALL)
    private List<Mensaje> bandeja;

    public BandejaDeMensajes() {

    }

    //region settersAndGetters
    public List<Mensaje> getBandeja() {
        return bandeja;
    }
    public void setBandeja(List<Mensaje> bandeja) {
        this.bandeja = bandeja;
    }
    //endregion4

    public void getMensaje(Mensaje mensaje) {
        this.bandeja.add(mensaje);
    }

    public BandejaDeMensajes(List<Mensaje> bandeja) {
        this.bandeja = bandeja;
    }
}
