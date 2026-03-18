package FIDNESS;

import java.util.ArrayList;

public class Rutina {
    private String nombre;
    private Cliente cliente;
    private ArrayList<RutinaItem> items;

    public Rutina(String nombre, Cliente cliente) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe escribir el nombre de la rutina.");
        }

        this.nombre = nombre;
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<RutinaItem> getItems() {
        return items;
    }

    public void agregarItem(RutinaItem item) {
        items.add(item);
    }
}
