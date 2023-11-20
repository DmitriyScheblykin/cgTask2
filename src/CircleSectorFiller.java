import java.awt.*;

public interface CircleSectorFiller {
    void fillSector(Graphics2D g, int centerX, int centerY, int radius, double startAngle, double endAngle);
}
