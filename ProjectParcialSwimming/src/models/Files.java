package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Files {

	private static ArrayList<String> list;
	private static BufferedReader bufferedReader;
	private FileWriter fileWriter;

	public ArrayList<String> read(String path) {
		try {
			list = new ArrayList<String>();
			File archivo = new File(path);
			FileReader fileReader = new FileReader(archivo);
			bufferedReader = new BufferedReader(fileReader);
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				list.add(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void write(ArrayList<String> list) {
		try {
			fileWriter = new FileWriter("resources/Datos.txt");
			for (String person : list) {
				fileWriter.write(person.toString());
			}
			fileWriter.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
