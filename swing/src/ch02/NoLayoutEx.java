package ch02;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayoutEx extends JFrame {

	ArrayList<JButton> buttons = new ArrayList<JButton>(10);

	String[] aar = { "1", "2", "3" };

	public NoLayoutEx() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("NO Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

		System.out.println(buttons.size());

		for (int i = 0; i < buttons.size(); i++) {
			System.out.println("1111");
		}

//		for (int i = 0; i < buttons.size(); i++) {
//			buttons.add(new JButton("button" + i));
//		}

		buttons.add(new JButton("1"));
		buttons.add(new JButton("2"));
		buttons.add(new JButton("3"));

//		button1 = new JButton("1");
//		button2 = new JButton("2");
//		button3 = new JButton("3");
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setSize(50, 50);
			buttons.get(i).setLocation(50 + (10 * i), (50 + (10 * i)));
			add(buttons.get(i));
		}
	}

	public static void main(String[] args) {
		new NoLayoutEx();
	}

}
