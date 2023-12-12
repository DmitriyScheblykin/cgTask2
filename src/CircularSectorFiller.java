import java.awt.*;

public class CircularSectorFiller implements CircleSectorFiller {
    private final ColorInterpolator colorInterpolator;

    public CircularSectorFiller(ColorInterpolator colorInterpolator) {
        this.colorInterpolator = colorInterpolator;
    }

    @Override
    public void fillSector(Graphics2D g, int centerX, int centerY, int radius, double startAngle, double endAngle) {
        int diameter = radius * 2;


        Color[] colors = {Color.RED, Color.RED, Color.BLUE, Color.WHITE, Color.WHITE};

        // Создаем массив пикселей и заполняем его интерполированными цветами
        int[][] pixels = new int[diameter][diameter];
        for (int x = 0; x < diameter; x++) {
            for (int y = 0; y < diameter; y++) {
                double distanceToCenter = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
                if (distanceToCenter <= radius) {
                    double angle = Math.toDegrees(Math.atan2(y - radius, x - radius));
                    if (angle < 0) {
                        angle += 360;
                    }
                    if (angle >= startAngle && angle <= endAngle) {
                        double percentage = 1.0 - distanceToCenter / radius;
                        Color interpolatedColor = colorInterpolator.interpolate(colors, percentage);
                        pixels[x][y] = interpolatedColor.getRGB();
                    }
                }
            }
        }

        // Рисуем пиксели на графике
        for (int x = 0; x < diameter; x++) {
            for (int y = 0; y < diameter; y++) {
                if (pixels[x][y] != 0) {
                    g.setColor(new Color(pixels[x][y], true));
                    g.fillRect(centerX - radius + x, centerY - radius + y, 1, 1);
                }
            }
        }
    }
}
