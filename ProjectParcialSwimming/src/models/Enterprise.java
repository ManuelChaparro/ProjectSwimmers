package models;

import java.util.ArrayList;

public class Enterprise {

	private ArrayList<Swimmer> persons;
	@SuppressWarnings("unused")
	private int listRunners;

	public Enterprise() {
		persons = new ArrayList<Swimmer>();
		listRunners = 1;
	}

	public ArrayList<Object[]> toObjectPersons() {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		for (int position = 0; position < persons.size(); position++) {
			Object[] person = new Object[7];
			person[0] = persons.get(position).getName();
			person[1] = persons.get(position).getBirthDay();
			person[2] = persons.get(position).getGender();
			person[3] = persons.get(position).getSwimmer();
			person[4] = persons.get(position).getTime();
			person[5] = 0;
			list.add(person);
		}
		return list;
	}

	public Object[][] toMatrixObject() {
		Object[][] list = new Object[persons.size()][7];
		for (int i = 0; i < list.length; i++) {
			list[i][0] = persons.get(i).getName();
			list[i][1] = persons.get(i).getBirthDay();
			list[i][2] = persons.get(i).getGender();
			list[i][3] = persons.get(i).getSwimmer();
			list[i][4] = persons.get(i).getTime();
			list[i][5] = 0;
		}
		return list;
	}

	public Object[] toMatrixObject(Swimmer person) {
		Object[] list = new Object[7];
		list[0] = person.getName();
		list[1] = person.getBirthDay();
		list[2] = person.getGender();
		list[3] = person.getSwimmer();
		list[4] = person.getTime();
		list[5] = 0;
		return list;
	}

	public void addSwimmer(Swimmer person) {
		persons.add(person);
	}

	public void setQuantity(int quantity) {
		listRunners = quantity;
	}

	public int getSizeArrayPersons() {
		return persons.size();
	}

}
