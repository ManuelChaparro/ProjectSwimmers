package views;

import javax.swing.*;

import controller.Controller;

import java.awt.*;

public class PanelDialogAddSwimmer extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelDialogNorth north;
	
	public PanelDialogAddSwimmer(Controller controller) {
		setTitle(Constants.TITLE_DIALOG);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setMinimumSize(new Dimension(300, 400));
		initComponents(controller);
		setVisible(false);
	}

	private void initComponents(Controller controller) {
		north = new PanelDialogNorth(controller);
		add(north, BorderLayout.CENTER);	
	}
	
	public Object[] getData() {
		return north.getData();
	}

	public void clear() {
		north.clear();
	}

	public void changeLanguage() {
		north.changeLaguage();
		
	}

}
