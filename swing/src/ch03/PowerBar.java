package ch03;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class PowerBar extends JPanel implements ActionListener, KeyListener {

	private double x;
	private final double y = 420;
	private double xv = 0;
	private final int width, height;
	private boolean left = false, right = false;
	private Timer t = new Timer(5, this);

	public PowerBar(JPanel j) {
		width = j.getWidth();
		height = j.getHeight();
		x = 180;

		t.start();
		this.addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}

	public void move() {

	}

	public void powerbarPosition() {

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Double(x, y, 100, 15);
		g2.setColor(Color.DARK_GRAY);
		g2.fill(rect);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		x += xv;
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent ev) {
		if (ev.getKeyCode() == KeyEvent.VK_LEFT) {
			left = !left;
			if (left == true) {
				xv = -2;
			} else if (ev.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = !right;
				if (right == true) {
					xv = 2;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent ev) {

	}

	@Override
	public void keyTyped(KeyEvent ke) {

	}
	
	public static void main(String[] args) {
		new PowerBar(null);
	}

}