package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.jgoodies.common.swing.MnemonicUtils;

import controller.Commands;
import controller.Controller;
import general.HandlerLanguage;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PanelOptions extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu optionsMenu, archiveMenu;
	private JMenuBar menuBar;
	private JMenuItem spanishItem, englishItem, addItem, showGraphic;
	
	public PanelOptions(Controller controller) {
		setLayout(new FlowLayout(0, 15, 0));
		setSize(new Dimension(20, 20));
		setBorder(new EmptyBorder(3,0,3,0));
		setBackground(Color.BLUE.darker().darker().darker());
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLUE.darker().darker().darker());
		
		optionsMenu = new JMenu(HandlerLanguage.languageProperties.getProperty(Constants.CHANGE_LANGUAGE));
		optionsMenu.setForeground(Color.WHITE);
		optionsMenu.setFont(Constants.DEFAULT_FONT);
		spanishItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.SPANISH));
		spanishItem.addActionListener(controller);
		spanishItem.setActionCommand(Commands.C_ES_LANGUAGE.name());
		spanishItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		
		englishItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.ENGLISH));
		englishItem.setActionCommand(Commands.C_EN_LANGUAGE.name());
		englishItem.addActionListener(controller);
		englishItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		
		optionsMenu.add(spanishItem);
		optionsMenu.add(englishItem);
		
		archiveMenu = new JMenu(HandlerLanguage.languageProperties.getProperty(Constants.ARCHIVE));
		archiveMenu.setFont(Constants.DEFAULT_FONT);
		archiveMenu.setForeground(Color.WHITE);
		
		addItem = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.ADD_SWIMMER));
		addItem.setActionCommand(Commands.ADDSWIMMER.name());
		addItem.addActionListener(controller);
		addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		archiveMenu.add(addItem);
		
		showGraphic = new JMenuItem(HandlerLanguage.languageProperties.getProperty(Constants.GRAPHIC));
		showGraphic.setActionCommand(Commands.SHOW_GRAPHIC.name());;
		showGraphic.addActionListener(controller);
		showGraphic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		archiveMenu.add(showGraphic);

		menuBar.add(archiveMenu);
		menuBar.add(optionsMenu);

		add(menuBar);
	}

	public void changeLanguage() {
		optionsMenu.setText(HandlerLanguage.languageProperties.getProperty(Constants.CHANGE_LANGUAGE));
		spanishItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.SPANISH));
		englishItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.ENGLISH));
		archiveMenu.setText(HandlerLanguage.languageProperties.getProperty(Constants.ARCHIVE));
		addItem.setText(HandlerLanguage.languageProperties.getProperty(Constants.ADD_SWIMMER));
		showGraphic.setText(HandlerLanguage.languageProperties.getProperty(Constants.GRAPHIC));
	}

}
