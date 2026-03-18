package FIDNESS;

import java.util.ArrayList;

public class ServidorDatos {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Ejercicio> ejercicios = new ArrayList<>();
    private static ArrayList<Rutina> rutinas = new ArrayList<>();

    public static void inicializarDatos() {
        usuarios.clear();
        ejercicios.clear();
        rutinas.clear();

        usuarios.add(new Administrador("Admin General", "admin", "123"));
        usuarios.add(new Cliente("Monica", "monica", "123"));
        usuarios.add(new Cliente("Juan", "juan", "123"));

        ejercicios.add(new Ejercicio("Sentadilla", "PIERNA", "Principiante", "Ejercicio para fortalecer piernas."));
        ejercicios.add(new Ejercicio("Prensa", "PIERNA", "Intermedio", "Ejercicio de fuerza para piernas."));
        ejercicios.add(new Ejercicio("Peso muerto", "PIERNA", "Avanzado", "Ejercicio compuesto para tren inferior."));

        ejercicios.add(new Ejercicio("Curl de bíceps", "BRAZO", "Principiante", "Ejercicio para bíceps."));
        ejercicios.add(new Ejercicio("Fondos", "BRAZO", "Intermedio", "Ejercicio para tríceps."));
        ejercicios.add(new Ejercicio("Press francés", "BRAZO", "Avanzado", "Ejercicio enfocado en tríceps."));

        ejercicios.add(new Ejercicio("Press militar", "HOMBRO", "Intermedio", "Ejercicio para hombros."));
        ejercicios.add(new Ejercicio("Elevaciones laterales", "HOMBRO", "Principiante", "Ejercicio para hombro medio."));

        ejercicios.add(new Ejercicio("Plancha", "ABDOMEN", "Principiante", "Ejercicio para abdomen y core."));
        ejercicios.add(new Ejercicio("Crunch", "ABDOMEN", "Principiante", "Ejercicio básico para abdomen."));
    }

    public static void registrarUsuario(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("El usuario no es válido.");
        }

        for (Usuario u : usuarios) {
            if (u.getUsername().equalsIgnoreCase(usuario.getUsername())) {
                throw new Exception("Ese nombre de usuario ya existe.");
            }
        }

        usuarios.add(usuario);
    }

    public static Usuario autenticar(String usuario, String contrasena) throws Exception {
        if (usuario == null || usuario.trim().isEmpty() ||
            contrasena == null || contrasena.trim().isEmpty()) {
            throw new Exception("Debe completar todos los campos.");
        }

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(usuario) && u.getPassword().equals(contrasena)) {
                return u;
            }
        }

        throw new Exception("Usuario o contraseña incorrectos.");
    }

    public static ArrayList<Ejercicio> filtrarPorTipo(String tipo) {
        ArrayList<Ejercicio> lista = new ArrayList<>();

        for (Ejercicio e : ejercicios) {
            if (e.getTipo().equalsIgnoreCase(tipo)) {
                lista.add(e);
            }
        }

        return lista;
    }

    public static ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public static ArrayList<Rutina> getRutinas() {
        return rutinas;
    }

    public static void guardarRutina(Rutina rutina) {
        rutinas.add(rutina);
    }
}
