package views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Views {
	
	private String TITLE = "-------------------------LISTA DE NADADORES-------------------------";
	private String SEPARATOR = "----------------------------------------------------------------------------------------------------------------------";
	private String HEADERS_LIST[] = {"NOMBRE", "NACIMIENTO", "GENERO", "ESTILO", "TIEMPO", "EDAD"};
	private String HEADERS_BEST[] = {"NOMBRE", "NACIMIENTO", "GENERO", "ESTILO", "TIEMPO"};
	private String FORMAT_LIST= "%1$-20s %2$-7s %3$-10s %4$-10s %5$-15s %6$-4s";
	private String FORMAT_BEST= "%1$-20s %2$-7s %3$-10s %4$-10s";
	
	public static final String PATH = "resource/Swimmers.swimming";
	
	private static final String WRITE_ID = "Digite el id a modificar";
	private static final String WRITE_ID_DELETE = "Digite el id que desea eliminar";
	private static final String WRITE_SURNAME = "Escriba el Apellido:";
	private static final String WRITE_BIRTHDAY = "Escriba el Año de nacimiento:";
	private static final String WRITE_MONTH = "Escriba el Mes: (En numero)";
	private static final String WRITE_DAY = "Escriba el Dia:";
	private static final String WRITE_HOURS = "Digite la hora del tiempo recorrido:";
	private static final String WRITE_MINUTES = "Digite los minutos :";
	private static final String WRITE_SECONDS = "Digite los segundos:";
	private static final String WRITE_SECOND_NAME = "Escriba el segundo nombre: (Recuerde digitarlo con la primera letra en mayuscula, o sera descalificado)";
	private static final String WRITE_NAME = "Escriba el Nombre:";
	
	private static final String SHOW_ERROR_BIRTHDAY = "Datos de nacimiento incorrectos.";
	private static final String SHOW_ERROR_NAME = "Formato de nombre incumplido.";
	private static final String SHOW_ERROR_TIME = "Formato de hora incorrecta.";
	private static final String SHOW_ERROR_RUNNER = "Algunos de los datos ingresados estan incorrectos.";
	
	
	private static final String CHOOSE_GENDER = "Elija el genero:\n 1) Masculino. \n 2) Femenino.";
	private static final String CHOOSE_TEAM = "Elija el equipo: \n 1) MOVISTAR.\n 2) TINKOFF. \n 3) KATUSHA.\n"
			+ " 4) SKY.\n 5) I AM CYCLING.\n 6) BMC.";
	
	public static final String MODIFY_DATA = "Que desea modificar?\n 1) Nombre.\n 2) 2do Nombre.\n 3) Apellido. \n 4) Fecha.\n 5) Genero."
			+ "\n 6) Equipo. \n 7) Tiempo";
	
	private Scanner scanner;
	
	public Views() {
		scanner = new Scanner(System.in);
	}
	
	public int showMenu() {
		System.out.println(TITLE+"\n 1) Ver lista cargada.\n 2) Ver mejores tiempos. \n 3) Mostrar datos en JTable. \n 4) Salir.");
		return scanner.nextInt();
	}
	
	public int searchId() {
		System.out.println(WRITE_ID);
		return scanner.nextInt();
	}
	
	public int delete() {
		System.out.println(WRITE_ID_DELETE);
		return scanner.nextInt();
	}
	
	public String writeSurname() {
		System.out.println(WRITE_SURNAME);
		return scanner.next();
	}
	
	public int writeYear() {
		System.out.println(WRITE_BIRTHDAY);
		return scanner.nextInt();
	}
	
	public int writeMonth() {
		System.out.println(WRITE_MONTH);
		return scanner.nextInt();
	}
	
	public int writeDay() {
		System.out.println(WRITE_DAY);
		return scanner.nextInt();
	}
	
	public int writeGender() {
		System.out.println(CHOOSE_GENDER);
		return scanner.nextInt();
	}
	
	public int writeTeam() {
		System.out.println(CHOOSE_TEAM);
		return scanner.nextInt();
	}
	
	public int writeHours() {
		System.out.println(WRITE_HOURS);
		return scanner.nextInt();
	}
	
	public int writeMinutes() {
		System.out.println(WRITE_MINUTES);
		return scanner.nextInt();
	}
	
	public int writeSeconds() {
		System.out.println(WRITE_SECONDS);
		return scanner.nextInt();
	}
	
	public String writeSecondName() {
		System.out.println(WRITE_SECOND_NAME);
		return scanner.next();
	}
	
	public String writeName() {
		System.out.println(WRITE_NAME);
		return scanner.next();
	}
	
	public void showListArray(ArrayList<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	public int modifyData() {
		System.out.println(MODIFY_DATA);
		return scanner.nextInt();
	}
	
	public void generateHeaderList() {
		System.out.println(String.format(FORMAT_LIST, HEADERS_LIST));
	}
	
	public void generateHeaderBest() {
		System.out.println(String.format(FORMAT_BEST, HEADERS_BEST));
	}
		
	
	public void showRunnersList(Object[] person) {
		System.out.println(String.format(FORMAT_LIST, person));
		System.out.println(SEPARATOR);			
	}
	
	public void showAverageTime(String[] list) {
		System.out.println("Promedio Equipo Movistar: "+list[0]);
		System.out.println("Promedio Equipo BMC: "+list[1]);
		System.out.println("Promedio Equipo I AM CYCLING: "+list[2]);
		System.out.println("Promedio Equipo KATUSHA: "+list[3]);
		System.out.println("Promedio Equipo SKY: "+list[4]);
		System.out.println("Promedio Equipo TINKOFF: "+list[5]);
	}

	public void showErrorRunner() {
		System.out.println(SHOW_ERROR_RUNNER);
	}

	public void showErrorBirthday() {
		System.out.println(SHOW_ERROR_BIRTHDAY);
	}
	
	public void showErrorDialogData() {
		JOptionPane.showMessageDialog(null, "Faltan Datos");
	}

	public void showErrorTime() {
		System.out.println(SHOW_ERROR_TIME);
		
	}

	public void showErrorName() {
		System.out.println(SHOW_ERROR_NAME);
		
	}

	public int showMenuStyle() {
		System.out.println(TITLE+"\nVer hombre y mujer con mejores tiempos del estilo:"+"\n 1) Mariposa .\n 2) Libre. \n 3) Pecho.\n 4) Espalda.");
		return scanner.nextInt();
	}

	public void showBestTime(Object[] bestMale, Object[] bestFemale) {
		System.out.println(bestFemale[0]);
		System.out.println("Mejor chica:");
		System.out.println(String.format(FORMAT_BEST, bestFemale));
		System.out.println("Mejor chico:");
		System.out.println(String.format(FORMAT_BEST, bestMale));
	}

	public int showOptionsShowPanel() {
		System.out.println("1) Cargar todos los datos.\n 2) Agregar nadador nuevo \n 3) Salir");
		return scanner.nextInt();
	}
	
	public String getFormatTime(int[] data) {
		String time = data[0]+":"+data[1]+":"+data[2];
		return time;
	}
	
	public String toStringLocalDate(LocalDate date) {
		return date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
	}
}
