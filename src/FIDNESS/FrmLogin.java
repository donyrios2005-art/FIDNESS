package FIDNESS;

import java.awt.*;
import javax.swing.*;

public class FrmLogin extends JFrame {

    private CajaTexto txtUsuario;
    private JPasswordField txtContrasena;
    private Boton btnIngresar;
    private Boton btnVolver;

    public FrmLogin() {
        setTitle("FIDNESS - Login");
        setSize(320, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(crearFondo());
    }

    private JPanel crearFondo() {
        Panel panel = new Panel(40, new Color(242, 211, 83));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("FIDNESS", SwingConstants.CENTER);
        lblTitulo.setBounds(50, 18, 200, 40);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(246, 227, 130));

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(40, 90, 70, 20);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));

        txtUsuario = new CajaTexto(10);
        txtUsuario.setBounds(120, 86, 120, 28);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(25, 140, 85, 20);
        lblPass.setFont(new Font("Arial", Font.BOLD, 14));

        txtContrasena = new JPasswordField();
        txtContrasena.setOpaque(false);
        txtContrasena.setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));
        txtContrasena.setHorizontalAlignment(JTextField.CENTER);
        txtContrasena.setBounds(120, 136, 120, 28);

        btnIngresar = new Boton("Ingresar");
        btnIngresar.setBounds(80, 190, 150, 38);

        btnVolver = new Boton("Volver");
        btnVolver.setBounds(100, 240, 110, 34);

        btnIngresar.addActionListener(e -> ingresar());
        btnVolver.addActionListener(e -> {
            new FrmInicio().setVisible(true);
            dispose();
        });

        panel.add(lblTitulo);
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblPass);
        panel.add(txtContrasena);
        panel.add(btnIngresar);
        panel.add(btnVolver);

        return panel;
    }

    private void ingresar() {
        try {
            String usuario = txtUsuario.getText();
            String pass = new String(txtContrasena.getPassword());

            Usuario u = ServidorDatos.autenticar(usuario, pass);

            new FrmMenu(u).setVisible(true);
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
