package Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class createFile {
	
	private FileWriter f;
	private ArrayList<String> aFile;
	private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
	private Date dateToday = new Date();
	private DateFormat format = new SimpleDateFormat("ddMMyyyy_HH.mm.ss", Locale.ENGLISH);
	public createFile() {
		
	}
	
	public boolean createFileEmployee() {
		try {
			f = new FileWriter("src\\files_temp\\fs_employee.txt");
			f.write("Datos temporales" + System.lineSeparator());
			closeFile();
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean incorporateToFile(String line) {
		try {
			f = new FileWriter("src\\files_temp\\fs_employee.txt", true);
			f.write(line + System.lineSeparator());
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean closeFile() {
		try {
			f.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteLastLine() {
		aFile = new ArrayList<String>();
		
        try {
        	//Leemos el archivo entero y añadimos cada linea en una arraylist
        	archivo = new File ("src\\files_temp\\fs_employee.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea=br.readLine())!=null) {
					aFile.add(linea);	
			}
			fr.close();
			
			//Creamos el fichero tfs_employee.txt de nuevo y 
			//copiamos las lineas de la array dentro
			f = new FileWriter("src\\files_temp\\fs_employee.txt");
			for (int i = 0; i < (aFile.size()-1); i++) {
				f.write(aFile.get(i) + System.lineSeparator());
			}
			f.close();
			
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return false;
	}
	
	public void renameFile() {
		aFile = new ArrayList<String>();
        try {
        	//Leemos el archivo entero y añadimos cada linea en una arraylist
        	archivo = new File ("src\\files_temp\\fs_employee.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea=br.readLine())!=null) {
					aFile.add(linea);
			}
			fr.close();
			
			
			//Creamos el fichero tfs_employee.txt de nuevo y 
			//copiamos las lineas de la array dentro
			f = new FileWriter("src\\files_temp\\fs_employee.txt");
			for (int i = 1; i < (aFile.size()); i++) {
				f.write(aFile.get(i) + System.lineSeparator());
			}
			f.close();
			
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		archivo = new File("src\\files_temp\\fs_employee.txt");
		archivo.renameTo(new File("src\\historial\\fs_employee_" + format.format(dateToday) + ".txt"));
		
		archivo = new File("src\\files_temp\\fs_employee.xml");
		archivo.renameTo(new File("src\\historial\\fs_employee_" + format.format(dateToday) + ".xml"));
	}
}
