import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyListener implements ActionListener {
	private MyFrame1 frame;

	// constructor
	public MyListener(MyFrame1 jf) {
		frame = jf;
	}

	// performs an action in response to the event
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==frame.b1) {
			System.out.println("Do Something");
		} else if (e.getSource() == frame.b2) {
			System.out.println("Do Something Else");
		}
	}

	
}