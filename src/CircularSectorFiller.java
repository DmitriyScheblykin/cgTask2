import java.awt.*;

public class CircularSectorFiller implements CircleSectorFiller {
    private final ColorInterpolator colorInterpolator;

    public CircularSectorFiller(ColorInterpolator colorInterpolator) {
        this.colorInterpolator = colorInterpolator;
    }

    @Override
    public void fillSector(Graphics2D g, int centerX, int centerY, int radius, double startAngle, double endAngle) {
        int diameter = radius * 2;


        g.setColor(Color.BLACK);
        g.drawArc(centerX - radius, centerY - radius, diameter, diameter, 0, 360);


        Color[] colors = {Color.RED, Color.RED, Color.BLUE, Color.WHITE, Color.WHITE};

        for (int r = radius; r > 0; r--) {
            double percentage = 1.0 - (double) (radius - r) / radius;
            Color interpolatedColor = colorInterpolator.interpolate(colors, percentage);
            g.setColor(interpolatedColor);

            int x = centerX - r;
            int y = centerY - r;
            int width = r * 2;
            int height = r * 2;

            g.fillArc(x, y, width, height, (int) startAngle, (int) (endAngle - startAngle));
        }
    }
}
