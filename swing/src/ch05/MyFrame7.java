package ch05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyFrame7 extends JFrame implements KeyListener {

	private JTextArea textArea;

	public MyFrame7() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("키 이벤트 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea();
	}

	private void setInitLayout() {
		setVisible(true);
		add(textArea);
	}

	private void addEventListener() {
		textArea.addKeyListener(this);
	}

	// 문자 키에만 반응 합니다.
	@Override
	public void keyTyped(KeyEvent e) {

	}

	// 키보드를 눌렀을 때 반응
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			System.out.println("왼쪽");
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			System.out.println("오른쪽");
		} else if (keyCode == KeyEvent.VK_DOWN) {
			System.out.println("아래");
		} else if (keyCode == KeyEvent.VK_UP) {
			System.out.println("위");
		}

	}

	// 키보드를 눌렀다가 뗏을 때 반응
	@Override
	public void keyReleased(KeyEvent e) {

	}

	public static void main(String[] args) {
		new MyFrame7();
	}

}
