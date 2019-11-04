package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import controller.Controller;

public class PanelDataGraphic extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double x1AxisOne, y1AxisOne, x2AxisOne, y2AxisOne, x1AxisTwo, y1AxisTwo, x2AxisTwo, y2AxisTwo;
	private Controller controller;
	
	public PanelDataGraphic(Controller controller) {
		this.controller = controller;
		setSize(new Dimension(1000, 500));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		x1AxisOne = (short) (getWidth()*0.1);
		y1AxisOne =  (short)(getHeight()*0.1);
		x2AxisOne =  (short)x1AxisOne;
		y2AxisOne =  (short) (getHeight()*0.9);

		x1AxisTwo = x1AxisOne;
		y1AxisTwo = y2AxisOne;
		x2AxisTwo = (short) (getWidth()*0.9);
		y2AxisTwo = y2AxisOne;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		initComponents(controller);
		g2.setStroke(new BasicStroke(2.5f));
		g2.setColor(Color.BLUE.darker().darker().darker());
		g2.draw(new Line2D.Double(x1AxisOne, y1AxisOne, x2AxisOne, y2AxisOne));
		g2.draw(new Line2D.Double(x1AxisTwo, y1AxisTwo, x2AxisTwo, y2AxisTwo));

	}

}
