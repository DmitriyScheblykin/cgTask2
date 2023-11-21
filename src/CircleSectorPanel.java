import javax.swing.*;
import java.awt.*;

public class CircleSectorPanel extends JPanel {
    private final CircleSectorFiller sectorFiller;
    private final JTextField radiusTextField;
    private final JTextField startAngleTextField;
    private final JTextField endAngleTextField;

    public CircleSectorPanel(CircleSectorFiller sectorFiller) {
        this.sectorFiller = sectorFiller;

        radiusTextField = new JTextField(5);
        radiusTextField.setText("0");

        startAngleTextField = new JTextField(5);
        startAngleTextField.setText("0");

        endAngleTextField = new JTextField(5);
        endAngleTextField.setText("0");

        JButton drawButton = new JButton("Зарисовать");

        add(new JLabel("Радиус:"));
        add(radiusTextField);
        add(new JLabel("Начальный угол:"));
        add(startAngleTextField);
        add(new JLabel("Конечный угол:"));
        add(endAngleTextField);
        add(drawButton);

        drawButton.addActionListener(e -> {
            if (!radiusTextField.getText().isEmpty() && !startAngleTextField.getText().isEmpty()
                    && !endAngleTextField.getText().isEmpty()) {
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Пожалуйста, заполните все поля.", "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int radius;
        double startAngle;
        double endAngle;

        try {
            radius = Integer.parseInt(radiusTextField.getText());
            startAngle = Double.parseDouble(startAngleTextField.getText());
            endAngle = Double.parseDouble(endAngleTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода данных. Пожалуйста, введите корректные числовые значения.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        sectorFiller.fillSector(g2d, centerX, centerY, radius, startAngle, endAngle);
    }
}
