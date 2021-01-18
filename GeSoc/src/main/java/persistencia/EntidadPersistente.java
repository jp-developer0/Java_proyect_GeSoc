package persistencia;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //extends EntidadPersistente
public class EntidadPersistente {
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }
}
