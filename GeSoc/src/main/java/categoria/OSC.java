package categoria;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@DiscriminatorValue("OSC")
public class OSC extends CategoriaEmpresa {

}
