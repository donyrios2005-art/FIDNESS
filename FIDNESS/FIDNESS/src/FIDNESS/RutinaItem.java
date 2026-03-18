package FIDNESS;

public class RutinaItem {
    private Ejercicio ejercicio;
    private int series;
    private int repeticiones;
    private int descanso;

    public RutinaItem(Ejercicio ejercicio, int series, int repeticiones, int descanso) {
        if (series <= 0 || repeticiones <= 0 || descanso < 0) {
            throw new IllegalArgumentException("Los datos del ejercicio no son válidos.");
        }

        this.ejercicio = ejercicio;
        this.series = series;
        this.repeticiones = repeticiones;
        this.descanso = descanso;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getDescanso() {
        return descanso;
    }

    @Override
    public String toString() {
        return "•" + ejercicio.getNombre() + " " + series + "x" + repeticiones + " descanso " + descanso + "s";
    }
}
