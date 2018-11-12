package idao;

import java.util.ArrayList;

import model.Accesorio;
import model.Modelo;
import model.SubModelo;

public interface IConfig {
	ArrayList<Modelo> readModelos();
	ArrayList<SubModelo> readSubModelos();
	ArrayList<Accesorio> readAccesorios();
	
}
