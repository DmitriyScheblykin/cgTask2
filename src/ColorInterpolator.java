import java.awt.*;

public class ColorInterpolator {
    Color interpolate(Color[] colors, double percentage) {
        int numColors = colors.length - 1;
        double colorIndex = percentage * numColors;
        int index1 = (int) Math.floor(colorIndex);
        int index2 = Math.min(index1 + 1, numColors);
        double weight = colorIndex - index1;

        Color color1 = colors[index1];
        Color color2 = colors[index2];

        int red = (int) (color1.getRed() + weight * (color2.getRed() - color1.getRed()));
        int green = (int) (color1.getGreen() + weight * (color2.getGreen() - color1.getGreen()));
        int blue = (int) (color1.getBlue() + weight * (color2.getBlue() - color1.getBlue()));

        return new Color(red, green, blue);
    }
}
