package FIDNESS;

public class Cliente extends Usuario {

    public Cliente(String nombre, String username, String password) {
        super(nombre, username, password);
    }

    @Override
    public String getTipoUsuario() {
        return "Cliente";
    }
}