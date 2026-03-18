package FIDNESS;

import java.awt.*;
import javax.swing.*;

public class FrmMenu extends JFrame {

    private Usuario usuario;
    private CajaTexto txtOpcion;

    public FrmMenu(Usuario usuario) {
        this.usuario = usuario;

        setTitle("FIDNESS - Menú");
        setSize(300, 310);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(crearPanel());
    }

    private JPanel crearPanel() {
        Panel panel = new Panel(40, new Color(242, 211, 83));
        panel.setLayout(null);

        Boton btnSalir = new Boton("Salir");
        btnSalir.setBounds(95, 270, 100, 32);
        btnSalir.addActionListener(e -> System.exit(0));
        panel.add(btnSalir);

        JLabel lblTitulo = new JLabel("FIDNESS", SwingConstants.CENTER);
        lblTitulo.setBounds(70, 12, 160, 30);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(246, 227, 130));

        JPanel barra = new JPanel();
        barra.setBackground(new Color(36, 18, 190));
        barra.setBounds(0, 42, 300, 24);
        barra.setLayout(new BorderLayout());

        JLabel lblSub = new JLabel("Menu Principal", SwingConstants.CENTER);
        lblSub.setForeground(Color.WHITE);
        lblSub.setFont(new Font("Arial", Font.ITALIC, 15));
        barra.add(lblSub, BorderLayout.CENTER);

        JLabel lbl1 = new JLabel("1.    Ver ejercicios");
        lbl1.setBounds(80, 85, 180, 20);

        JLabel lbl2 = new JLabel("2.    Crear rutina");
        lbl2.setBounds(80, 110, 180, 20);

        JLabel lbl3 = new JLabel("3.    Mis rutinas");
        lbl3.setBounds(80, 135, 180, 20);

        JLabel lbl4 = new JLabel("4.    Cerrar sesión");
        lbl4.setBounds(80, 160, 180, 20);

        JLabel lblDigite = new JLabel("Digite su opcion:");
        lblDigite.setBounds(85, 210, 130, 20);
        lblDigite.setFont(new Font("Arial", Font.BOLD, 14));

        txtOpcion = new CajaTexto(8);
        txtOpcion.setBounds(95, 235, 90, 28);

        txtOpcion.addActionListener(e -> procesarOpcion());

        panel.add(lblTitulo);
        panel.add(barra);
        panel.add(lbl1);
        panel.add(lbl2);
        panel.add(lbl3);
        panel.add(lbl4);
        panel.add(lblDigite);
        panel.add(txtOpcion);

        return panel;
    }

    private void procesarOpcion() {
        String opcion = txtOpcion.getText().trim();

        switch (opcion) {
            case "1":
                new FrmCatalogo(usuario).setVisible(true);
                dispose();
                break;
            case "2":
                if (usuario instanceof Cliente) {
                    new FrmRutina((Cliente) usuario).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Solo los clientes pueden crear rutinas.");
                }
                break;
            case "3":
                JOptionPane.showMessageDialog(this, "Función de mis rutinas en construcción.");
                break;
            case "4":
                new FrmInicio().setVisible(true);
                dispose();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Digite una opción válida.");
        }
    }
}
