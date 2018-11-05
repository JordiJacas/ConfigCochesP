package Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.sun.swing.internal.plaf.metal.resources.metal;

import config.ConfigurationLoader;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class es_lenguage {
	
	private File fResum;
	private FileReader fr;
	private BufferedReader br;
	private ArrayList<String> aFile;
	private String pathLenguage = ConfigurationLoader.getConfig().getLanguage_file_path();
	private String postfix = ConfigurationLoader.getConfig().getPostfix_language_file_name();
	private String language_default = ConfigurationLoader.getConfig().getLanguage_default();
	private Hashtable<String, String> hashtable = new Hashtable<String, String>();
	
	public es_lenguage() {
		aFile = new ArrayList<String>();
		String linea;
		
		
		try {
			fResum = new File(pathLenguage + language_default + postfix);
			fr = new FileReader (fResum);
			br = new BufferedReader(fr);
			
			while((linea=br.readLine())!=null) {
				String[] aLinea = linea.split("=");
				hashtable.put(aLinea[0], aLinea[1]);
			}
			
			fr.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hashtable<String, String> getHashtable() {
		return hashtable;
	}
	
}
