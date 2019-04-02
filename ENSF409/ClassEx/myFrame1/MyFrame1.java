import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame1 extends JFrame {
	JButton b1, b2;
	MyListener linstener;

	public MyFrame1(String s) {
		super(s);
		linstener = new MyListener(this);
		setLayout(new BorderLayout());
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		b1.addActionListener(linstener);
		b2.addActionListener(linstener);
		add("North", b1);
		add("Center", b2);
	}

	public static void main(String args[]) {
		// Create the frame
		MyFrame1 frame = new MyFrame1("Frame 1");
		frame.pack();
		frame.setVisible(true);
	}
}

