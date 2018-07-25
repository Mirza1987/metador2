package metador.view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new MainFrame();
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		new IndexFrame();
	}
}
