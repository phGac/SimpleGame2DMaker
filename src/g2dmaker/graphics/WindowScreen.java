package g2dmaker.graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class WindowScreen extends JFrame {

	private static final long serialVersionUID = 3346979276568951809L;
	
	private String title;

	public WindowScreen(String title, DrawSpace drawSpace) {
		this.title = title;
		configureWindow(drawSpace);
	}
	
	private void configureWindow(final DrawSpace drawSpace) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		// setIconImage(image);
		setLayout(new BorderLayout());
		add(drawSpace, BorderLayout.CENTER);
		// setUndecorated(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
