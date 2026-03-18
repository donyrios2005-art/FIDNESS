package FIDNESS;

import java.awt.*;
import javax.swing.*;

public class FrmInicio extends JFrame {

    public FrmInicio() {
        setTitle("FIDNESS - Inicio");
        setSize(320, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(crearPanel());
    }

    private JPanel crearPanel() {
        Panel panel = new Panel(40, new Color(242, 211, 83));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("FIDNESS", SwingConstants.CENTER);
        lblTitulo.setBounds(60, 20, 200, 35);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(246, 227, 130));

        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(36, 18, 190));
        barra.setBounds(0, 65, 320, 28);

        JLabel lblSub = new JLabel("Menu inicial", SwingConstants.CENTER);
        lblSub.setForeground(Color.WHITE);
        lblSub.setFont(new Font("Arial", Font.ITALIC, 16));
        barra.add(lblSub, BorderLayout.CENTER);

        Boton btnCrearUsuario = new Boton("Crear usuario");
        btnCrearUsuario.setBounds(80, 120, 160, 38);

        Boton btnIniciarSesion = new Boton("Iniciar sesión");
        btnIniciarSesion.setBounds(80, 170, 160, 38);

        Boton btnSalir = new Boton("Salir");
        btnSalir.setBounds(100, 225, 120, 38);

        btnCrearUsuario.addActionListener(e -> {
            new FrmCrearUsuario().setVisible(true);
            dispose();
        });

        btnIniciarSesion.addActionListener(e -> {
            new FrmLogin().setVisible(true);
            dispose();
        });

        btnSalir.addActionListener(e -> System.exit(0));

        panel.add(lblTitulo);
        panel.add(barra);
        panel.add(btnCrearUsuario);
        panel.add(btnIniciarSesion);
        panel.add(btnSalir);

        return panel;
    }
}
