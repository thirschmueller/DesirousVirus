package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class DataStorage {
	private final String saveDataPath, fileName;
	
	public DataStorage(final String saveDataPath, final String fileName) {
		this.saveDataPath = saveDataPath;
		this.fileName = fileName;
	}
	
	/* Methode speichert Daten in erstellten File rein*/
	public void createSaveData() {
		try {
			File file = new File(saveDataPath, fileName);

			FileWriter output = new FileWriter(file); // neues File erstellen
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("0");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* Methode laedt den hoechsten Highscore*/
	public Object load() {	
		Object data = null;
		try {
			File f = new File(saveDataPath, fileName);
			if (!f.isFile()) { // wenn kein File vorhanden ist, wird ein neues erstellt
			createSaveData();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			data = reader.readLine();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}
		
	/*Methode legt den Highscore fest*/
	public void set(final String data) {
		FileWriter output;

		try {
			File f = new File(saveDataPath, fileName);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(data);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
