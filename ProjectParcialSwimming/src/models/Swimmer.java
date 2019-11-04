package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Swimmer {
	
	private String name;
	private LocalDate birthDay;
	private Gender gender;
	private Style style;
	private LocalTime time;	
	
	public Swimmer(String name, LocalDate birthDay, Gender gender, Style style, LocalTime time) {
		this.name = name;
		this.birthDay = birthDay;
		this.gender = gender;
		this.style = style;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}

	public Gender getGender() {
		return gender;
	}
	public Style getSwimmer() {
		return style;
	}
	public LocalTime getTime() {
		return time;
	}
	
	public Object[] toObject() {
		return new Object[] {name, birthDay, gender, style, time};
	}
	
	public int calculateYears(LocalDate date) {
		Period period = Period.between(date, LocalDate.now());
		return period.getYears();
	}

}
