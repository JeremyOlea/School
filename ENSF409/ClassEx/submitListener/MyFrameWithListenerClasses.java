import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//The only responsibility of this class
//is to draw the GUI
//It also assigns the listeners to the
//GUI components 
public class MyFrameWithListenerClasses extends JFrame {
	JButton b1, b2;
	SubmitListener subLinstener;
	CancelListener canListener;

	public MyFrameWithListenerClasses(String s) {
		super(s);
		subLinstener = new SubmitListener();
		canListener = new CancelListener ();
		setLayout(new BorderLayout());
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		b1.addActionListener(subLinstener);
		b2.addActionListener(canListener);
		add("North", b1);
		add("Center", b2);
	}

	public static void main(String args[]) {
		// Create the frame
		MyFrameWithListenerClasses frame = new MyFrameWithListenerClasses("Frame 1");
		frame.pack();
		frame.setVisible(true);
	}
}

