package ch03;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyJFrameEX extends JFrame {
	
	String[][] d = { { "Sam", "29", "Twinkle House" }, { "Anna Sam", "27", "Happy Villa" },
			{ "Iza Norah", "4", "HAppy House" } };

	String[] cn = { "name", "Age", "House Address" };

	public MyJFrameEX() {
		initData();
		setInitLayout();
	}

	private void initData() {
		JTable jTable = new JTable(d, cn);
		jTable.setBounds(30, 40, 200, 300);
		JScrollPane jsp = new JScrollPane(jTable);
		add(jsp);
		setTitle("JTable 연습");
		setSize(500, 200);
	}

	private void setInitLayout() {
		setVisible(true);

	}

	public static void main(String[] args) {
		new MyJFrameEX();
	}
}
