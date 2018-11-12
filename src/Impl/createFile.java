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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.VariablesLenguageEnum;

public class createFile extends JFrame{
	
	private FileWriter f;
	private ArrayList<String> aFile;
	private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
	private Date dateToday = new Date();
	private DateFormat format = new SimpleDateFormat("ddMMyyyy_HH.mm.ss", Locale.ENGLISH);
	private int numLineas;
	private static ArrayList<String> dataSave;
	
	public createFile() {
		
	}
	
	public void createFileEmployee() {
		numLineas = 0;
		dataSave = new ArrayList<String>();
		try {
			archivo = new File("src\\files_temp\\fs_employee.txt");			

			if(archivo.exists()){
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);
				String linea;
				while((linea=br.readLine())!=null) {
						numLineas++;
						dataSave.add(linea);
				}
				fr.close();
				
				if(numLineas>1) {
					//Creamos las opciones
					Object [] opciones ={"OK","CANCEL"};
					// Creamos las pregunta de guardar datos
					int eleccion = JOptionPane.showOptionDialog(rootPane,VariablesLenguageEnum.carga_fichero_temp,"Mensaje de Confirmacion",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,null,opciones,"CANCEL");
							//Si es un no al guardar los datos, hace una segunda pregunta para salir sin guardar
							if (eleccion == JOptionPane.NO_OPTION) {
								dataSave = null;
							}
				}
			}
			f = new FileWriter("src\\files_temp\\fs_employee.txt");			
			f.write("Datos temporales" + System.lineSeparator());
			closeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getDataSave() {
		return dataSave;
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
	
	public static void main(String[] args) {
		createFile c = new createFile();
		c.createFileEmployee();
		System.out.println(c.getDataSave());
	}
}
