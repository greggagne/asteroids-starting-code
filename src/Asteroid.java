import java.awt.Color;
import java.awt.Graphics;

public class Asteroid extends Polygon {

	public Asteroid(Point[] shape, Point position) {
		super(shape, position, 0);
	}

	@Override
	public void paint(Graphics brush, Color color) {
		Point[] points = getPoints();
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			xPoints[i] = (int) points[i].x;
			yPoints[i] = (int) points[i].y;
		}

		brush.setColor(color);
		brush.drawPolygon(xPoints, yPoints, points.length);
	}

	@Override
	public void move() {
	}
}