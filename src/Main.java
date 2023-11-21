import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Закрашивание сектора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        ColorInterpolator colorInterpolator = new ColorInterpolator();
        CircleSectorFiller sectorFiller = new CircularSectorFiller(colorInterpolator);
        CircleSectorPanel panel = new CircleSectorPanel(sectorFiller);

        frame.add(panel);
        frame.setVisible(true);
    }
}