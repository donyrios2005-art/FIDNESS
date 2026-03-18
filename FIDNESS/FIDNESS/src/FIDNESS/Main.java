package FIDNESS;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        ServidorDatos.inicializarDatos();

        SwingUtilities.invokeLater(() -> {
            new FrmInicio().setVisible(true);
        });
    }
}