package Impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createFile {
	
	private FileWriter f;
	
	public createFile() {
		
	}
	
	public void createFileEmployee() {
		try {
			f = new FileWriter("fs_employee.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void incorporateToFile(String line) {
		try {
			f.write(line + System.lineSeparator());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeFile() {
		try {
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
