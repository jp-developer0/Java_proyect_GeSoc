package usuario;

public class ValidarContraseña {

    private String contraseña;
    private String expresionRegular = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?!.*[@#$%^&+=])(?=\\S+$).{8,}";

    public void setContraseña(String contraseña) {//esto es por si el usuario escribió una contraseña inválida.
        this.contraseña = contraseña;
    }

    public Boolean validar() {
        return contraseña.matches(expresionRegular);
    }

}
