package ch00;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame {
	
	public MyFrame() {
		setSize(400, 400);
		setTitle("test");
		setVisible(true);
	}
}

public class MainTest {

	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("입력");

	}

}
