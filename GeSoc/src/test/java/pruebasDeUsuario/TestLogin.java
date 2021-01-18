package pruebasDeUsuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.Login;

import java.io.ByteArrayInputStream;

public class TestLogin {
    private ByteArrayInputStream textoUsuario;
    private ByteArrayInputStream textoClave;
    private Login login;

    public TestLogin() {
    }

    @Before
    public void init() {
        this.login = new Login();
        this.textoUsuario = new ByteArrayInputStream("Administrador".getBytes());
        this.textoClave = new ByteArrayInputStream("1234".getBytes());
    }

    @Test
    public void chequeoLogin() {
        System.setIn(this.textoUsuario);
        this.login.ingresoUsuario();
        Assert.assertEquals("Ingrese usuario", this.login.getLog());
        System.setIn(this.textoClave);
        this.login.ingresoClave();
        Assert.assertEquals("Logueo exitoso.", this.login.getLog());
    }
}
