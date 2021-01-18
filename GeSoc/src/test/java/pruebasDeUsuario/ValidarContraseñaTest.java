package pruebasDeUsuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.ValidarContraseña;

public class ValidarContraseñaTest {
    private ValidarContraseña validarContraseña;

    public ValidarContraseñaTest() {
    }

    @Before
    public void init() {
        this.validarContraseña = new ValidarContraseña();
    }

    @Test
    public void claveValida() {
        this.validarContraseña.setContraseña("PruebaDeContraseñaValida1");
        Assert.assertTrue(this.validarContraseña.validar());
    }

    @Test
    public void claveInvalida() {
        this.validarContraseña.setContraseña("PruebaDeContraseñaValida1@");
        Assert.assertFalse(this.validarContraseña.validar());
    }

    @Test
    public void claveInvalidaCorta() {
        this.validarContraseña.setContraseña("@1mM");
        Assert.assertFalse(this.validarContraseña.validar());
    }

    @Test
    public void claveValidaConEspacios() {
        this.validarContraseña.setContraseña("PruebaDe ContraseñaValida1");
        Assert.assertFalse(this.validarContraseña.validar());
    }

    @Test
    public void claveSinDigitos() {
        this.validarContraseña.setContraseña("PruebaDeContraseñaValida");
        Assert.assertFalse(this.validarContraseña.validar());
    }

    @Test
    public void claveSinMayusculas() {
        this.validarContraseña.setContraseña("pruebadecontraseña1");
        Assert.assertFalse(this.validarContraseña.validar());
    }

    @Test
    public void claveSinMinusculas() {
        this.validarContraseña.setContraseña("PRUEBADECONTRASEÑA1");
        Assert.assertFalse(this.validarContraseña.validar());
    }
}
