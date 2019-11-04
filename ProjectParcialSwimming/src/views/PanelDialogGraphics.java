package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;

import controller.Controller;

public class PanelDialogGraphics extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelDataGraphic graphic;
	
	public PanelDialogGraphics(Controller controller) {
		setBackground(Color.WHITE);
		setMinimumSize(new Dimension(500, 500));
		setSize(new Dimension(1000, 500));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		graphic = new PanelDataGraphic(controller);
		add(graphic, BorderLayout.CENTER);
	}

}
