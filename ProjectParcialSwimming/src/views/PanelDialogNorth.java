package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import controller.Commands;
import controller.Controller;
import general.HandlerLanguage;

public class PanelDialogNorth extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> gender, kind;
	private JTextField name;
	private JDateChooser date;
	private JLabel infoName, infoBirthday, infoGender, infoStyle, infoTime;
	private PanelGetTime time;
	private JButton accept, cancel;
	private JPanel auxPanel;
	private Views views;
	
	public PanelDialogNorth(Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		views = new Views();
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(400, 400));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		infoName = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.NAME));
		infoName.setForeground(Color.BLUE.darker().darker());
		infoName.setBorder(new EmptyBorder(0, 0, 0, 0));
		infoName.setFont(Constants.DEFAULT_FONT);
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.WHITE);
		auxPanel.setLayout(new FlowLayout(0));
		auxPanel.add(infoName);
		add(auxPanel);
		
		name = new JTextField();
		add(name);
		
		infoBirthday = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.DATE));
		infoBirthday.setForeground(Color.BLUE.darker().darker());
		infoBirthday.setFont(Constants.DEFAULT_FONT);
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.WHITE);
		auxPanel.setLayout(new FlowLayout(0));
		auxPanel.add(infoBirthday);
		add(auxPanel);
		
		date = new JDateChooser();
		add(date);
		
		infoGender = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.GENDER));
		infoGender.setForeground(Color.BLUE.darker().darker());
		infoGender.setFont(Constants.DEFAULT_FONT);
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.WHITE);
		auxPanel.setLayout(new FlowLayout(0));
		auxPanel.add(infoGender);
		add(auxPanel);
		
		gender = new JComboBox<String>();
		gender.addItem(HandlerLanguage.languageProperties.getProperty(Constants.MALE));
		gender.addItem(HandlerLanguage.languageProperties.getProperty(Constants.FEMALE));
		gender.setBackground(Color.WHITE);
		gender.setFont(Constants.DEFAULT_FONT_MIN);
		add(gender);
		
		infoStyle = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.KIND));
		infoStyle.setFont(Constants.DEFAULT_FONT);
		infoStyle.setForeground(Color.BLUE.darker().darker());
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.WHITE);
		auxPanel.setLayout(new FlowLayout(0));
		auxPanel.add(infoStyle);
		add(auxPanel);
		
		kind = new JComboBox<String>();
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.FREE));
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.BACK));		
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.CHEST));
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.BUTTERFLY));
		kind.setBackground(Color.WHITE);
		kind.setBorder(null);
		kind.setFont(Constants.DEFAULT_FONT_MIN);
		add(kind);
		
		infoTime = new JLabel(HandlerLanguage.languageProperties.getProperty(Constants.TIME));
		infoTime.setFont(Constants.DEFAULT_FONT);
		infoTime.setForeground(Color.BLUE.darker().darker());
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.WHITE);
		auxPanel.setLayout(new FlowLayout(0));
		auxPanel.add(infoTime);
		add(auxPanel);
		
		time = new PanelGetTime();
		add(time);	
	
		auxPanel = new JPanel();
		auxPanel.setBackground(Color.WHITE);
		auxPanel.setLayout(new FlowLayout(10, 40, 10));
		add(auxPanel);
		
		accept = new JButton(Constants.ACCEPT);
		accept.setBackground(Color.GREEN.darker());
		accept.setForeground(Color.WHITE);
		accept.setActionCommand(Commands.ACCEPT_DIALOG.name());
		accept.addActionListener(controller);
		auxPanel.add(accept);
		
		cancel = new JButton(Constants.CANCEL);
		cancel.setBackground(Color.RED.darker());
		cancel.setForeground(Color.WHITE);
		cancel.setActionCommand(Commands.CANCEL_DIALOG.name());
		cancel.addActionListener(controller);
		auxPanel.add(cancel);
		}
	
	public Object[] getData() {
		Object[] swimmer = new Object[5];
		String nameAux = name.getText();
		Date dateAux = date.getDate();
		Instant current = dateAux.toInstant();
		LocalDate localDate = LocalDateTime.ofInstant(current, ZoneId.systemDefault()).toLocalDate();
		String genderAux = (String) gender.getSelectedItem();
		String styleAux = (String) kind.getSelectedItem();
		String timeAux = views.getFormatTime(time.getTime());
		swimmer[0] = nameAux;
		swimmer[1] = localDate;
		swimmer[2] = genderAux;
		swimmer[3] = styleAux;
		swimmer[4] = timeAux;
		return swimmer;
	}

	public void clear() {
		name.setText("");
		time.clear();
	}
	
	public void changeLaguage() {
		time.changeLenguage();
		infoName.setText(HandlerLanguage.languageProperties.getProperty(Constants.NAME));
		infoBirthday.setText(HandlerLanguage.languageProperties.getProperty(Constants.DATE));
		infoGender.setText(HandlerLanguage.languageProperties.getProperty(Constants.GENDER));
		infoStyle.setText(HandlerLanguage.languageProperties.getProperty(Constants.KIND));
		infoTime.setText(HandlerLanguage.languageProperties.getProperty(Constants.TIME));
		accept.setText(HandlerLanguage.languageProperties.getProperty(Constants.ACCEPT));
		cancel.setText(HandlerLanguage.languageProperties.getProperty(Constants.CANCEL));
		kind.removeAllItems();
		gender.removeAllItems();
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.FREE));
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.BACK));
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.CHEST));
		kind.addItem(HandlerLanguage.languageProperties.getProperty(Constants.BUTTERFLY));
		gender.addItem(HandlerLanguage.languageProperties.getProperty(Constants.MALE));
		gender.addItem(HandlerLanguage.languageProperties.getProperty(Constants.FEMALE));
	}
	
	

}
