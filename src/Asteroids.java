
/*
CLASS: AsteroidsGame
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
 */
import java.awt.*;
import javax.swing.SwingUtilities;

public class Asteroids extends Game {
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	static int counter = 0;
	private final Asteroid asteroid;

	public Asteroids() {
		super("Asteroids!", SCREEN_WIDTH, SCREEN_HEIGHT);
		setFocusable(true);
		requestFocusInWindow();

		Point[] triangle = new Point[] {
			new Point(0, 0),
			new Point(60, 0),
			new Point(30, 50)
		};
		asteroid = new Asteroid(triangle, new Point(200, 200));
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		brush.setColor(Color.white);
		brush.drawString("Counter is " + counter,10,10);
		asteroid.paint(brush, Color.lightGray);
	}

	public static void main (String[] args) {
		SwingUtilities.invokeLater(Asteroids::new);
	}
}
