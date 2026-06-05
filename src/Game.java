
/*
CLASS: Game
DESCRIPTION: A painted canvas in its own window, updated every tenth second.
USAGE: Extended by Asteroids.
NOTE: You don't need to understand the details here, no fiddling neccessary.
Original code by Dan Leyzberg and Art Simon
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public abstract class Game extends JPanel {
	protected boolean on = true;
	protected int width, height;
	protected BufferedImage buffer;

	public Game(String name, int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));

		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		new Timer(100, e -> {
			if (on) repaint();
		}).start();
	}

	// 'paint' will be called every tenth of a second that the game is on.
	abstract public void paint(Graphics brush);

	@Override
	protected void paintComponent(Graphics g) {
		Graphics bg = buffer.getGraphics();
		try {
			paint(bg);
		} finally {
			bg.dispose();
		}
		g.drawImage(buffer, 0, 0, this);
	}
}
