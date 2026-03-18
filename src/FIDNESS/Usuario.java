package FIDNESS;

public abstract class Usuario {
    protected String nombre;
    protected String username;
    protected String password;

    public Usuario(String nombre, String username, String password) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract String getTipoUsuario();
}
