package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class DataStorage {
	private String saveDataPath, fileName;
	
	public DataStorage(final String saveDataPath, final String fileName) {
		this.saveDataPath = saveDataPath;
		this.fileName = fileName;
	}
	
	public void createSaveData() {
		try {
			File file = new File(saveDataPath, fileName);

			FileWriter output = new FileWriter(file); // neues File erstellen
			BufferedWriter writer = new BufferedWriter(output);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object load() {	//object = allgemeinte Klasse --> jede Klasse erbt davon und jede ist ein Object (int/double nicht)
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

	public void set(final String data) {
		FileWriter output = null;

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
