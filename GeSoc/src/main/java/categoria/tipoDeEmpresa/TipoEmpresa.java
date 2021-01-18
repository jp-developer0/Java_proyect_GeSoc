package categoria.tipoDeEmpresa;

import persistencia.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class TipoEmpresa extends EntidadPersistente {
    @Column
    private String nombre;
    @Column
    private float ventasTope;
    @Column
    private float personalTope;

    public boolean cumpleConTipo(int personal, float ventas) {
        return this.cumpleConPersonal(personal) && this.cumpleConVentas(ventas);
    }

    private boolean cumpleConPersonal(int personal) {
        return personal < this.personalTope;
    }

    private boolean cumpleConVentas(float ventas) {
        return ventas < this.ventasTope;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoEmpresa(){}
    public TipoEmpresa(String nombre, float ventasTope, float personalTope) {
        this.nombre = nombre;
        this.ventasTope = ventasTope;
        this.personalTope = personalTope;
    }
}
