package FIDNESS;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class FrmRutina extends JFrame {

    private Cliente cliente;
    private CajaTexto txtNombreRutina;
    private JTextArea txtEjercicios;
    private Rutina rutinaActual;

    private JCheckBox chkSentadilla;
    private JCheckBox chkPrensa;
    private JCheckBox chkPesoMuerto;
    private JCheckBox chkCurlBiceps;
    private JCheckBox chkPressMilitar;
    private JCheckBox chkPlancha;

    private Boton btnListo;
    private Boton btnExportar;
    private Boton btnVolver;

    public FrmRutina(Cliente cliente) {
        this.cliente = cliente;

        setTitle("FIDNESS - Rutina");
        setSize(470, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(crearPanel());
    }

    private JPanel crearPanel() {
        Panel panel = new Panel(40, new Color(242, 211, 83));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("FIDNESS", SwingConstants.CENTER);
        lblTitulo.setBounds(120, 12, 200, 35);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 30));
        lblTitulo.setForeground(new Color(246, 227, 130));

        JPanel barra1 = new JPanel(new BorderLayout());
        barra1.setBackground(new Color(36, 18, 190));
        barra1.setBounds(0, 52, 470, 28);

        JLabel lblSub1 = new JLabel("Creacion de rutina", SwingConstants.CENTER);
        lblSub1.setForeground(Color.WHITE);
        lblSub1.setFont(new Font("Arial", Font.ITALIC, 18));
        barra1.add(lblSub1, BorderLayout.CENTER);

        JLabel lblNombre = new JLabel("Nombre de Rutina:");
        lblNombre.setBounds(35, 100, 150, 25);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));

        txtNombreRutina = new CajaTexto(15);
        txtNombreRutina.setBounds(190, 98, 140, 35);

        JLabel lblOpciones = new JLabel("Seleccione ejercicios:");
        lblOpciones.setBounds(35, 150, 170, 25);
        lblOpciones.setFont(new Font("Arial", Font.BOLD, 15));

        chkSentadilla = crearCheckBox("Sentadilla");
        chkSentadilla.setBounds(50, 185, 150, 25);

        chkPrensa = crearCheckBox("Prensa");
        chkPrensa.setBounds(50, 215, 150, 25);

        chkPesoMuerto = crearCheckBox("Peso muerto");
        chkPesoMuerto.setBounds(50, 245, 150, 25);

        chkCurlBiceps = crearCheckBox("Curl de bíceps");
        chkCurlBiceps.setBounds(250, 185, 150, 25);

        chkPressMilitar = crearCheckBox("Press militar");
        chkPressMilitar.setBounds(250, 215, 150, 25);

        chkPlancha = crearCheckBox("Plancha");
        chkPlancha.setBounds(250, 245, 150, 25);

        btnListo = new Boton("Listo");
        btnListo.setBounds(170, 285, 120, 36);

        JPanel barra2 = new JPanel(new BorderLayout());
        barra2.setBackground(new Color(140, 75, 255));
        barra2.setBounds(0, 340, 470, 32);

        JLabel lblSub2 = new JLabel("Ejercicios agregados", SwingConstants.CENTER);
        lblSub2.setForeground(Color.WHITE);
        lblSub2.setFont(new Font("Arial", Font.ITALIC, 18));
        barra2.add(lblSub2, BorderLayout.CENTER);

        txtEjercicios = new JTextArea();
        txtEjercicios.setBounds(25, 385, 410, 70);
        txtEjercicios.setOpaque(false);
        txtEjercicios.setEditable(false);
        txtEjercicios.setFont(new Font("Arial", Font.BOLD, 14));

        btnExportar = new Boton("Exportar");
        btnExportar.setBounds(90, 475, 120, 38);

        btnVolver = new Boton("Volver");
        btnVolver.setBounds(245, 475, 110, 38);

        btnListo.addActionListener(e -> cargarSeleccionados());
        btnExportar.addActionListener(e -> exportarRutina());
        btnVolver.addActionListener(e -> {
            new FrmMenu(cliente).setVisible(true);
            dispose();
        });

        panel.add(lblTitulo);
        panel.add(barra1);
        panel.add(lblNombre);
        panel.add(txtNombreRutina);
        panel.add(lblOpciones);
        panel.add(chkSentadilla);
        panel.add(chkPrensa);
        panel.add(chkPesoMuerto);
        panel.add(chkCurlBiceps);
        panel.add(chkPressMilitar);
        panel.add(chkPlancha);
        panel.add(btnListo);
        panel.add(barra2);
        panel.add(txtEjercicios);
        panel.add(btnExportar);
        panel.add(btnVolver);

        return panel;
    }

    private JCheckBox crearCheckBox(String texto) {
        JCheckBox chk = new JCheckBox(texto);
        chk.setOpaque(false);
        chk.setFont(new Font("Arial", Font.BOLD, 13));
        chk.setFocusPainted(false);
        return chk;
    }

    private void cargarSeleccionados() {
        try {
            String nombreRutina = txtNombreRutina.getText().trim();

            if (nombreRutina.isEmpty()) {
                throw new Exception("Debe escribir el nombre de la rutina.");
            }

            rutinaActual = new Rutina(nombreRutina, cliente);

            ArrayList<String> seleccionados = new ArrayList<>();

            if (chkSentadilla.isSelected()) {
                Ejercicio e = buscarEjercicioPorNombre("Sentadilla");
                rutinaActual.agregarItem(new RutinaItem(e, 4, 10, 60));
                seleccionados.add("•Sentadilla 4x10 descanso 60s");
            }

            if (chkPrensa.isSelected()) {
                Ejercicio e = buscarEjercicioPorNombre("Prensa");
                rutinaActual.agregarItem(new RutinaItem(e, 3, 12, 60));
                seleccionados.add("•Prensa 3x12 descanso 60s");
            }

            if (chkPesoMuerto.isSelected()) {
                Ejercicio e = buscarEjercicioPorNombre("Peso muerto");
                rutinaActual.agregarItem(new RutinaItem(e, 4, 8, 90));
                seleccionados.add("•Peso muerto 4x8 descanso 90s");
            }

            if (chkCurlBiceps.isSelected()) {
                Ejercicio e = buscarEjercicioPorNombre("Curl de bíceps");
                rutinaActual.agregarItem(new RutinaItem(e, 3, 12, 45));
                seleccionados.add("•Curl de bíceps 3x12 descanso 45s");
            }

            if (chkPressMilitar.isSelected()) {
                Ejercicio e = buscarEjercicioPorNombre("Press militar");
                rutinaActual.agregarItem(new RutinaItem(e, 4, 10, 60));
                seleccionados.add("•Press militar 4x10 descanso 60s");
            }

            if (chkPlancha.isSelected()) {
                Ejercicio e = buscarEjercicioPorNombre("Plancha");
                rutinaActual.agregarItem(new RutinaItem(e, 3, 30, 30));
                seleccionados.add("•Plancha 3x30s descanso 30s");
            }

            if (seleccionados.isEmpty()) {
                throw new Exception("Debe seleccionar al menos un ejercicio.");
            }

            StringBuilder sb = new StringBuilder();
            for (String item : seleccionados) {
                sb.append(item).append("\n");
            }

            txtEjercicios.setText(sb.toString());

            JOptionPane.showMessageDialog(this, "Ejercicios agregados correctamente.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private Ejercicio buscarEjercicioPorNombre(String nombre) throws Exception {
        for (Ejercicio e : ServidorDatos.getEjercicios()) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        throw new Exception("No se encontró el ejercicio: " + nombre);
    }

    private void exportarRutina() {
        try {
            if (rutinaActual == null) {
                throw new Exception("Primero debe seleccionar ejercicios y presionar Listo.");
            }

            if (rutinaActual.getItems().isEmpty()) {
                throw new Exception("No hay ejercicios agregados para exportar.");
            }

            ServidorDatos.guardarRutina(rutinaActual);

            JOptionPane.showMessageDialog(this,
                    "Rutina exportada correctamente para " + cliente.getNombre());

            new FrmMenu(cliente).setVisible(true);
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
