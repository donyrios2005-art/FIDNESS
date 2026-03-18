package FIDNESS;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class FrmCatalogo extends JFrame {

    private Usuario usuario;
    private JComboBox<String> cbFiltro;
    private JTextArea txtLista;

    public FrmCatalogo(Usuario usuario) {
        this.usuario = usuario;

        setTitle("FIDNESS - Catálogo");
        setSize(320, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(crearPanel());
    }

    private JPanel crearPanel() {
        Panel panel = new Panel(40, new Color(242, 211, 83));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("FIDNESS", SwingConstants.CENTER);
        lblTitulo.setBounds(70, 10, 160, 30);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(246, 227, 130));

        JPanel barra1 = new JPanel(new BorderLayout());
        barra1.setBackground(new Color(36, 18, 190));
        barra1.setBounds(0, 40, 320, 24);

        JLabel lblSub1 = new JLabel("Catalogo de ejercicios", SwingConstants.CENTER);
        lblSub1.setForeground(Color.WHITE);
        lblSub1.setFont(new Font("Arial", Font.ITALIC, 14));
        barra1.add(lblSub1, BorderLayout.CENTER);

        JLabel lblFiltro = new JLabel("Filtro por tipo:");
        lblFiltro.setBounds(28, 86, 95, 20);
        lblFiltro.setFont(new Font("Arial", Font.BOLD, 13));

        cbFiltro = new JComboBox<>(new String[]{"PIERNA", "BRAZO", "HOMBRO", "ABDOMEN"});
        cbFiltro.setBounds(130, 82, 110, 30);

        JPanel barra2 = new JPanel(new BorderLayout());
        barra2.setBackground(new Color(36, 18, 190));
        barra2.setBounds(0, 128, 320, 24);

        JLabel lblSub2 = new JLabel("Lista de ejercicios", SwingConstants.CENTER);
        lblSub2.setForeground(Color.WHITE);
        lblSub2.setFont(new Font("Arial", Font.ITALIC, 14));
        barra2.add(lblSub2, BorderLayout.CENTER);

        txtLista = new JTextArea();
        txtLista.setBounds(15, 165, 270, 75);
        txtLista.setEditable(false);
        txtLista.setOpaque(false);
        txtLista.setFont(new Font("Arial", Font.BOLD, 13));

        Boton btnDetalle = new Boton("Ver detalle");
        btnDetalle.setBounds(45, 265, 110, 35);

        Boton btnVolver = new Boton("Volver");
        btnVolver.setBounds(170, 265, 100, 35);

        cbFiltro.addActionListener(e -> cargarEjercicios());
        btnDetalle.addActionListener(e -> verDetalle());
        btnVolver.addActionListener(e -> {
            new FrmMenu(usuario).setVisible(true);
            dispose();
        });

        panel.add(lblTitulo);
        panel.add(barra1);
        panel.add(lblFiltro);
        panel.add(cbFiltro);
        panel.add(barra2);
        panel.add(txtLista);
        panel.add(btnDetalle);
        panel.add(btnVolver);

        cargarEjercicios();

        return panel;
    }

    private void cargarEjercicios() {
        String tipoSeleccionado = cbFiltro.getSelectedItem().toString();
        ArrayList<Ejercicio> lista = ServidorDatos.filtrarPorTipo(tipoSeleccionado);

        StringBuilder sb = new StringBuilder();
        for (Ejercicio e : lista) {
            sb.append("•").append(e.getNombre()).append("\n");
        }

        if (lista.isEmpty()) {
            sb.append("No hay ejercicios para esa opción.");
        }

        txtLista.setText(sb.toString());
    }

    private void verDetalle() {
        String tipoSeleccionado = cbFiltro.getSelectedItem().toString();
        ArrayList<Ejercicio> lista = ServidorDatos.filtrarPorTipo(tipoSeleccionado);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ejercicios para mostrar.");
            return;
        }

        StringBuilder detalle = new StringBuilder();
        for (Ejercicio e : lista) {
            detalle.append("Nombre: ").append(e.getNombre())
                    .append("\nNivel: ").append(e.getNivel())
                    .append("\nDescripción: ").append(e.getDescripcion())
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(this, detalle.toString());
    }
}
