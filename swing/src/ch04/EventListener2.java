package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListener2 extends JFrame implements ActionListener {
	
	private JButton button1; 
	private JButton button2;
	
	public EventListener2() {
		initData();
		setInitLayout();
		addEventListener();
	}
	private void initData() {
		setTitle("이벤트 리스너 연습2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
	}
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(button1);
		add(button2);
	}
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 첫번째 방법 
		// 버튼1, 버튼2 눌러 졌을 때 구분을 해야.. 
//		System.out.println(e.getActionCommand() + " 버튼이 클릭 되었습니다.");
//		if(e.getActionCommand().equals(button1.getText())) {
//			System.out.println("버튼 1이 클릭 !!!");
//		} else {
//			System.out.println("버튼 2이 클릭 !!!");
//		}
		
		// 두번째 방법 
		// Object obj = e.getSource();
		// 하지만 우리는 Object ---> JButton (파악 가능)  
		JButton selectedBtn = (JButton)e.getSource();
		if(selectedBtn.getText().equals(this.button1.getText())) {
			System.out.println(button1.getText() + " 가 클릭 되었습니다");
		} else {
			System.out.println(button2.getText() + " 가 클릭 되었습니다");
		}

	}
	
}




