package views;

import java.awt.*;
import javax.swing.*;
import controller.Controller;
public class PrincipalFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataPanel dataPanel;
	private PanelOptions options;

	public PrincipalFrame(Object[][] list, Controller controller) {
		setTitle(Constants.TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(true);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(700, 500));
		initComponents(list, controller);
		setVisible(false);
	}

	private void initComponents(Object[][] list, Controller controller) {
		options = new PanelOptions(controller);
		add(options, BorderLayout.NORTH);

		dataPanel = new DataPanel(list);
		add(dataPanel, BorderLayout.CENTER);

	}

	public void setData(Object[] data) {

	}

	public void changeLanguage() {
		options.changeLanguage();
		dataPanel.changeLanguageTable();
	}

	public void setChangesList(Object[] swimmer) {
		dataPanel.setChangesList(swimmer);
		
	}

}
