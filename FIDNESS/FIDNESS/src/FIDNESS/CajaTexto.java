package FIDNESS;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CajaTexto extends JTextField {

    public CajaTexto(int columns) {
        super(columns);
        setOpaque(false);
        setBorder(new EmptyBorder(8, 14, 8, 14));
        setHorizontalAlignment(JTextField.CENTER);
        setFont(new Font("Arial", Font.PLAIN, 14));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(210, 210, 210));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
    }
}
