package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utilities {
	
	private static final String FORMAT_DATE = "d/M/yyyy";
	private static final String FORMAT_TIME = "H:m:s";
	
	public String[] splitLine(String list) {
		return list.split("\\#++");
	}
	
	public String[] splitDate(String date) {
		return date.split("/");
	}
	
	public String[] splitTime(String time) {
		return time.split(":");
	}
	
	public static boolean validationBirthday(LocalDate date) {
		if (date.isBefore(LocalDate.of(2008, 6, 20)) && date.isAfter(LocalDate.of(1970, 9, 18))) {
			return true;
		}else {
			return false;
		}
	}
	
	public int calculateYears(LocalDate date) {
		Period period = Period.between(date, LocalDate.now());
		return period.getYears();
	}
	
	public LocalDate convertLocalDate(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(FORMAT_DATE);
		return LocalDate.parse(date, format);
	}
	
	
	public LocalTime convertTime(String time) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(FORMAT_TIME);
		return LocalTime.parse(time, format);
	}
	
	public static boolean validationBirthday(String[] date) {
		boolean validation = false;
		if (Integer.parseInt(date[0])<=1970) {
			validation = LocalDate.of(Integer.parseInt(date[0]),
					Integer.parseInt(date[1]),
					Integer.parseInt(date[2])).isBefore(LocalDate.of(2008, 6, 20));
		}else if(Integer.parseInt(date[0])>=2008){
			validation = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])).isAfter(LocalDate.of(2008, 6, 20));
		}
		return validation;
	} 
	
	public Gender getGender(String gender) {
		switch (gender) {
		case "Femenino":
			return Gender.FEMENINO;
		default:
			return Gender.MASCULINO;

		}
	}
	
	public Style getStyle(String style) {
		switch (style) {
		case "Espalda":
			return Style.ESPALDA;
		case "Libre":
			return Style.LIBRE;
		case "Pecho":
			return Style.PECHO;
		default:
			return Style.MARIPOSA;
		}
	}
	
	public int calculateAverageTime(LocalTime time) {
		int totalTimeInSeconds = 0;
		totalTimeInSeconds += (time.getHour())*3600;
		totalTimeInSeconds += (time.getMinute()*60);
		totalTimeInSeconds += time.getSecond();
		return totalTimeInSeconds;
	}
	
	public int convertSeconds(String partsSeconds) {
		String[] parts = splitTime(partsSeconds);
		int totalSeconds = 0;
		int hours= Integer.parseInt(parts[0])/3600;
		int minutes =(Integer.parseInt(parts[1])-(3600*hours))/60;
		int seconds =Integer.parseInt(parts[2])-((hours*3600)+(minutes*60));
		totalSeconds = hours+minutes+seconds;
		return totalSeconds;
	}
	
	public boolean verifySurname(String surname) {
		if (Character.isUpperCase(surname.charAt(0))) {
			return true;
		}else {
			return false;
		}
	}

}
