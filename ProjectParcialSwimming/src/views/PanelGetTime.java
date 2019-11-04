package views;

import javax.swing.*;

import general.HandlerLanguage;

import java.awt.*;

public class PanelGetTime extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel textHour, textMinutes, textSeconds;
	private JSpinner hours, minutes, seconds;
	private SpinnerNumberModel modelHour, modelMinutes, modelSeconds;

	public PanelGetTime() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(0, 30));
		initComponents();
	}

	private void initComponents() {
		textHour = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.HOURS));
		add(textHour);
		
		hours = new JSpinner();
		modelHour = new SpinnerNumberModel();
		modelHour.setMaximum(24);
		modelHour.setMinimum(0);
		hours.setModel(modelHour);
		add(hours);
		
		textMinutes = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.MINUTES));
		add(textMinutes);
		
		minutes = new JSpinner();
		modelMinutes = new SpinnerNumberModel();
		modelMinutes.setMaximum(60);
		modelMinutes.setMinimum(0);
		minutes.setModel(modelMinutes);
		add(minutes);
		
		textSeconds = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.SECONDS));
		add(textSeconds);

		seconds = new JSpinner();
		modelSeconds = new SpinnerNumberModel();
		modelSeconds.setMaximum(60);
		modelSeconds.setMinimum(0);
		seconds.setModel(modelSeconds);
		add(seconds);
	}
	
	public int[] getTime() {
		int[] data = new int[3];
		int hoursAux = (int) hours.getValue();
		int minutesAux = (int) minutes.getValue();
		int secondsAux = (int) seconds.getValue();
		data[0] = hoursAux;
		data[1] = minutesAux;
		data[2] = secondsAux;
		return data;
	}

	public void clear() {
		hours.setValue(0);
		minutes.setValue(0);
		seconds.setValue(0);
	}

	public void changeLenguage() {
		textHour.setText(HandlerLanguage.languageProperties.getProperty(Constants.HOURS));
		textMinutes.setText(HandlerLanguage.languageProperties.getProperty(Constants.MINUTES));
		textSeconds.setText(HandlerLanguage.languageProperties.getProperty(Constants.SECONDS));
		
	}

}
