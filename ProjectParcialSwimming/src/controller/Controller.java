package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import general.HandlerLanguage;
import models.*;
import views.*;

public class Controller implements ActionListener {

	private Enterprise enterprise;
	private Views views;
	private Files files;
	private Utilities utilities;
	private PrincipalFrame frame;
	private PanelDialogAddSwimmer dialogSwimmer;
	private PanelDialogGraphics dialogGraphics;
	private HandlerLanguage config = null;
	private String languageDefault;
	private static final String NAME_FILE_CONFIG = "config.init";

	public Controller() {
		loadConfiguration();
		enterprise = new Enterprise();
		utilities = new Utilities();
		views = new Views();
		files = new Files();
		initApp();
	}
	
	private void manageChangeLanguage(){
		frame.changeLanguage();		
		dialogSwimmer.changeLanguage();
	}
	
	public String getLanguageDefault(){
		languageDefault = Locale.getDefault().getLanguage();
		switch (languageDefault) {
		case "es":
			return "Spanish";
		case "us":
			return "English";
		}
		return "Spanish";
	}

	public void loadLanguage() throws IOException{
		try {
			config.loadLanguage();
		} catch (Exception e) {			
		}
	}

	public void saveConfig() throws IOException{
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	public void changeToEnglish() throws IOException{
		HandlerLanguage.language = "language/language_english.properties";
		saveConfig();
		loadLanguage();		
	}

	public void changeToSpanish() throws IOException{
		HandlerLanguage.language = "language/language_spanish.properties";
		saveConfig();
		loadLanguage();
	}


	private void loadConfiguration() {
		if(config == null){
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try{
			config.loadLanguage();
		}catch(IOException e){
			System.err.println("file not found : NAME_FILE_CONFIG");
		}
	}

	public void initApp() {
		int option = 0;
		readList();
		while (option != 7) {
			option = views.showMenu();
			switch (option) {
			case 1:
				showSwimmersInfo();
				break;
			case 2:
				showBestSwimming();
				break;
			case 3:
				showDataPanel();
				break;
			case 4:
				System.exit(0);
			}
		}
	}

	private void showDataPanel() {
		Object[][] list = enterprise.toMatrixObject();
		for (int j = 0; j < enterprise.getSizeArrayPersons(); j++) {
			int age = utilities.calculateYears((LocalDate) list[j][1]);
			list[j][5] = age;
		}
		frame = new PrincipalFrame(list, this);
		dialogSwimmer = new PanelDialogAddSwimmer(this);
		dialogGraphics = new PanelDialogGraphics(this);
		frame.setVisible(true);
	}

	private void showBestSwimming() {
		int option = 0;
		while (option != 5) {
			option = views.showMenuStyle();
			switch (option) {
			case 1:
//				calculateBestTimeButterfly();
				break;
			case 2:
				calculateBestTimeFree();
				break;
			case 3:
				calculateBestTimeChest();
				break;
			default:
				calculateBestTimeBack();
				break;
			}
		}
	}

	private void calculateBestTimeBack() {
		int[] totalSeconds = new int[2];
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		@SuppressWarnings("unused")
		Object[] bestMale = new Object[4];
		Object[] bestFemale = new Object[4];
		list = enterprise.toObjectPersons();
		for (int j = 0; j < enterprise.getSizeArrayPersons(); j++) {
			if (list.get(j)[2] == "Femenino") {
				String time = (String) list.get(j)[4];
				int seconds = utilities.convertSeconds(time);
				if (list.get(j)[3] == Style.ESPALDA && totalSeconds[0] == 0) {
					totalSeconds[0] = seconds;
					bestFemale = list.get(j);
				} else if (list.get(j)[3] == Style.ESPALDA && seconds > totalSeconds[0]) {
					bestFemale = list.get(j);
				}
			} else if (list.get(j)[2] == "Masculino") {
				String time = (String) list.get(j)[4];
				int seconds = utilities.convertSeconds(time);
				if (list.get(j)[3] == Style.ESPALDA && totalSeconds[0] == 0) {
					totalSeconds[0] = seconds;
					bestMale = list.get(j);
				} else if (list.get(j)[3] == Style.ESPALDA && seconds > totalSeconds[0]) {
					bestMale = list.get(j);
				}
			}

		}
		views.showBestTime(bestMale, bestFemale);

	}

	private void calculateBestTimeChest() {
		int[] totalSeconds = new int[2];
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		@SuppressWarnings("unused")
		Object[] bestMale = new Object[4];
		Object[] bestFemale = new Object[4];
		list = enterprise.toObjectPersons();
		for (int j = 0; j < enterprise.getSizeArrayPersons(); j++) {
			if (list.get(j)[2] == "Femenino") {
				String time = (String) list.get(j)[4];
				int seconds = utilities.convertSeconds(time);
				if (list.get(j)[3] == Style.PECHO && totalSeconds[0] == 0) {
					totalSeconds[0] = seconds;
					bestFemale = list.get(j);
				} else if (list.get(j)[3] == Style.PECHO && seconds > totalSeconds[0]) {
					bestFemale = list.get(j);
				}
			} else if (list.get(j)[2] == "Masculino") {
				String time = (String) list.get(j)[4];
				int seconds = utilities.convertSeconds(time);
				if (list.get(j)[3] == Style.PECHO && totalSeconds[0] == 0) {
					totalSeconds[0] = seconds;
					bestMale = list.get(j);
				} else if (list.get(j)[3] == Style.PECHO && seconds > totalSeconds[0]) {
					bestMale = list.get(j);
				}
			}

		}
		views.showBestTime(bestMale, bestFemale);

	}

	private void calculateBestTimeFree() {
		int[] totalSeconds = new int[2];
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		@SuppressWarnings("unused")
		Object[] bestMale = new Object[4];
		Object[] bestFemale = new Object[4];
		list = enterprise.toObjectPersons();
		for (int j = 0; j < enterprise.getSizeArrayPersons(); j++) {
			if (list.get(j)[2] == "Femenino") {
				String time = (String) list.get(j)[4];
				int seconds = utilities.convertSeconds(time);
				if (list.get(j)[3] == Style.LIBRE && totalSeconds[0] == 0) {
					totalSeconds[0] = seconds;
					bestFemale = list.get(j);
				} else if (list.get(j)[3] == Style.LIBRE && seconds > totalSeconds[0]) {
					bestFemale = list.get(j);
				}
			} else if (list.get(j)[2] == "Masculino") {
				String time = (String) list.get(j)[4];
				int seconds = utilities.convertSeconds(time);
				if (list.get(j)[3] == Style.LIBRE && totalSeconds[0] == 0) {
					totalSeconds[0] = seconds;
					bestMale = list.get(j);
				} else if (list.get(j)[3] == Style.LIBRE && seconds > totalSeconds[0]) {
					bestMale = list.get(j);
				}
			}

		}
		views.showBestTime(bestMale, bestFemale);
	}

	private void showSwimmersInfo() {
		views.generateHeaderList();
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		list = enterprise.toObjectPersons();
		for (int j = 0; j < enterprise.getSizeArrayPersons(); j++) {
			int age = utilities.calculateYears((LocalDate) list.get(j)[1]);
			list.get(j)[5] = age;
			views.showRunnersList(list.get(j));

		}
	}

	private void readList() {
		manageTokenizeLines(files.read(Views.PATH));

	}

	private void manageTokenizeLines(ArrayList<String> stringList) {
		for (String string : stringList) {
			String[] aux = utilities.splitLine(string);
			enterprise.addSwimmer(new Swimmer(aux[0], utilities.convertLocalDate(aux[1]), utilities.getGender(aux[2]),
					utilities.getStyle(aux[3]), utilities.convertTime(aux[4])));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case ADDSWIMMER:
			dialogSwimmer.clear();
			dialogSwimmer.setVisible(true);
			break;
		case ACCEPT_DIALOG:
			try {
				Object[] data = dialogSwimmer.getData();
				Object[] swimmer = null;
				String date = views.toStringLocalDate((LocalDate) data[1]);
				Swimmer person = new Swimmer((String) data[0], utilities.convertLocalDate(date),
						utilities.getGender((String) data[2]), utilities.getStyle((String) data[3]),
						utilities.convertTime((String) data[4]));
				swimmer = enterprise.toMatrixObject(person);
				int age = utilities.calculateYears((LocalDate) swimmer[1]);
				swimmer[5] = age;
				setChangesList(swimmer);
				dialogSwimmer.setVisible(false);
			} catch (NullPointerException e2) {
				views.showErrorDialogData();
			}

			break;
		case CANCEL_DIALOG:
			dialogSwimmer.setVisible(false);
			;
			break;
		case C_EN_LANGUAGE:
			manageChangeLanguageEN();
			break;
		case C_ES_LANGUAGE:
			manageChangeLanguageES();
			break;
		case SHOW_GRAPHIC:
			dialogGraphics.setVisible(true);
			break;
		default:
			break;
		}

	}

	private void setChangesList(Object[] swimmer) {
		frame.setChangesList(swimmer);
	}

	private void manageChangeLanguageEN(){
		try {
			changeToEnglish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}			
		manageChangeLanguage();
		
	}
	
	private void manageChangeLanguageES(){
		try {
			changeToSpanish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		manageChangeLanguage();
		
	}

}
