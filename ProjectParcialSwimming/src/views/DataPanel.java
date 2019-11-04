package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import general.HandlerLanguage;

import java.awt.*;

public class DataPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable dataTable;
	private JScrollPane scroll;
	private DefaultTableModel table;

	public DataPanel(Object[][] list) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(list);
		setVisible(true);
	}

	private void initComponents(Object[][] list) {
		table = new DefaultTableModel(list, generateHeader());
		changeLanguageTable();
		dataTable = new JTable(table);
		dataTable.setVisible(true);
		dataTable.setBackground(Color.GRAY);
		dataTable.setBackground(Color.WHITE);
		dataTable.setFont(Constants.DEFAULT_FONT);
		dataTable.getTableHeader().setFont(Constants.DEFAULT_FONT_MAX);
		dataTable.setEditingRow(500);
		dataTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		dataTable.setRowHeight(25);
		dataTable.setSelectionBackground(Color.BLUE.darker().darker());
		dataTable.setSelectionForeground(Color.WHITE);
		scroll = new JScrollPane(dataTable);
		scroll = new JScrollPane(dataTable);
		dataTable.getTableHeader().setReorderingAllowed(false);
		add(scroll);

	}

	public void changeLanguageTable() {
		String[] headers = { HandlerLanguage.languageProperties.getProperty(Constants.NAME),
				HandlerLanguage.languageProperties.getProperty(Constants.DATE),
				HandlerLanguage.languageProperties.getProperty(Constants.GENDER),
				HandlerLanguage.languageProperties.getProperty(Constants.KIND),
				HandlerLanguage.languageProperties.getProperty(Constants.TIME),
				HandlerLanguage.languageProperties.getProperty(Constants.AGE) };
		table.setColumnIdentifiers(headers);
	}
	
	public String[] generateHeader() {
		String[] HEADERS = { HandlerLanguage.languageProperties.getProperty(Constants.NAME),
				HandlerLanguage.languageProperties.getProperty(Constants.DATE),
				HandlerLanguage.languageProperties.getProperty(Constants.GENDER),
				HandlerLanguage.languageProperties.getProperty(Constants.KIND),
				HandlerLanguage.languageProperties.getProperty(Constants.TIME),
				HandlerLanguage.languageProperties.getProperty(Constants.AGE) };
		return HEADERS;
	}

	public void setChangesList(Object[] swimmer) {
		table.addRow(swimmer);
	}

}
