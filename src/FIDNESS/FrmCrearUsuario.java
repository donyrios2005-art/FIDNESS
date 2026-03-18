package FIDNESS;

import java.awt.*;
import javax.swing.*;

public class FrmCrearUsuario extends JFrame {

    private CajaTexto txtNombre;
    private CajaTexto txtUsuario;
    private JPasswordField txtContrasena;
    private JComboBox<String> cbTipo;

    public FrmCrearUsuario() {
        setTitle("FIDNESS - Crear Usuario");
        setSize(360, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(crearPanel());
    }

    private JPanel crearPanel() {
        Panel panel = new Panel(40, new Color(242, 211, 83));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("FIDNESS", SwingConstants.CENTER);
        lblTitulo.setBounds(70, 15, 200, 35);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(246, 227, 130));

        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(new Color(36, 18, 190));
        barra.setBounds(0, 60, 360, 28);

        JLabel lblSub = new JLabel("Crear usuario", SwingConstants.CENTER);
        lblSub.setForeground(Color.WHITE);
        lblSub.setFont(new Font("Arial", Font.ITALIC, 16));
        barra.add(lblSub, BorderLayout.CENTER);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(45, 110, 80, 20);
        txtNombre = new CajaTexto(12);
        txtNombre.setBounds(140, 106, 140, 30);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(45, 150, 80, 20);
        txtUsuario = new CajaTexto(12);
        txtUsuario.setBounds(140, 146, 140, 30);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(45, 190, 90, 20);

        txtContrasena = new JPasswordField();
        txtContrasena.setOpaque(false);
        txtContrasena.setBorder(BorderFactory.createEmptyBorder(8, 14, 8, 14));
        txtContrasena.setHorizontalAlignment(JTextField.CENTER);
        txtContrasena.setBounds(140, 186, 140, 30);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(45, 230, 80, 20);

        cbTipo = new JComboBox<>(new String[]{"Cliente", "Administrador"});
        cbTipo.setBounds(140, 226, 140, 30);

        Boton btnGuardar = new Boton("Guardar");
        btnGuardar.setBounds(60, 285, 110, 38);

        Boton btnVolver = new Boton("Volver");
        btnVolver.setBounds(190, 285, 110, 38);

        btnGuardar.addActionListener(e -> guardarUsuario());
        btnVolver.addActionListener(e -> {
            new FrmInicio().setVisible(true);
            dispose();
        });

        panel.add(lblTitulo);
        panel.add(barra);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblPass);
        panel.add(txtContrasena);
        panel.add(lblTipo);
        panel.add(cbTipo);
        panel.add(btnGuardar);
        panel.add(btnVolver);

        return panel;
    }

    private void guardarUsuario() {
        try {
            String nombre = txtNombre.getText().trim();
            String usuario = txtUsuario.getText().trim();
            String pass = new String(txtContrasena.getPassword()).trim();
            String tipo = cbTipo.getSelectedItem().toString();

            if (nombre.isEmpty() || usuario.isEmpty() || pass.isEmpty()) {
                throw new Exception("Debe completar todos los campos.");
            }

            Usuario nuevo;
            if (tipo.equalsIgnoreCase("Administrador")) {
                nuevo = new Administrador(nombre, usuario, pass);
            } else {
                nuevo = new Cliente(nombre, usuario, pass);
            }

            ServidorDatos.registrarUsuario(nuevo);

            JOptionPane.showMessageDialog(this, "Usuario creado correctamente.");

            new FrmInicio().setVisible(true);
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
