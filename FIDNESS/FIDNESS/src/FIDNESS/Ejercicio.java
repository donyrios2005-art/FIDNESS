package FIDNESS;

public class Ejercicio {
    private String nombre;
    private String tipo;
    private String nivel;
    private String descripcion;

    public Ejercicio(String nombre, String tipo, String nivel, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
