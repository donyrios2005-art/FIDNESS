package FIDNESS;

public class Administrador extends Usuario {

    public Administrador(String nombre, String username, String password) {
        super(nombre, username, password);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}