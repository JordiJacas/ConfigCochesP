package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Impl.LenguageLoader;
import Impl.createFile;
import Impl.createXMLFactura;
import model.VariablesLenguageEnum;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantallaResumen extends JFrame {

	private JPanel contentPane;
	private File fResum;
	private FileReader fr;
	private BufferedReader br;
	private ArrayList<String> aFile;
	private createFile cFile;
	private createXMLFactura xmlFile;
	private createFile f = new createFile();
	private Hashtable<VariablesLenguageEnum, String> idioma = LenguageLoader.getLenguageConfig().getIdioma();
	private ArrayList<String> adescuento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//pantallaResumen frame = new pantallaResumen();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public pantallaResumen(pantallaAccesorios frame, String userName) {
		/*
		 * Configuraciones JFrame
		 */
		setResizable(false);
		setTitle("Concesionario ESTEVE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaResumen.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		// Ejectutamos la funcion que lee el fichero temporal
		// donde esta toda la informacion de la compra
		readFileResum();
		
		// Transformamos todos los Strings de aFile a String[] 
		String[] infoCliente = StringToAstring(aFile.get(1)); 
		String[] infoModelo = StringToAstring(aFile.get(3));
		String[] infoAccesorios = StringToAstring(aFile.get(4));
		adescuento = new ArrayList<String>();
		
		adescuento = aplicarDescuento(Integer.parseInt(infoAccesorios[2]));
		infoAccesorios[2] = adescuento.get(0);
		
		/*
		 * Elementos graficos del Jframe
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {300, 300};
		gbl_contentPane.rowHeights = new int[] {50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblResumen = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_titulo));
		lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblResumen = new GridBagConstraints();
		gbc_lblResumen.insets = new Insets(0, 0, 5, 5);
		gbc_lblResumen.gridx = 0;
		gbc_lblResumen.gridy = 0;
		contentPane.add(lblResumen, gbc_lblResumen);
		
		JButton btnFinalizar = new JButton(idioma.get(VariablesLenguageEnum.resumen_btn_finalizar));
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Crear factura
				xmlFile = new createXMLFactura();
				xmlFile.crearFactura();
				
				//Renombrar archivo temp y factura xml
				cFile = new createFile();
				cFile.renameFile();
				
				pasarSiguientePantalla(userName);
			}
		});
		
		JButton btnAnterior = new JButton(idioma.get(VariablesLenguageEnum.resumen_btn_anterior));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarAnteriorPantalla(frame);
			}
		});
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.anchor = GridBagConstraints.WEST;
		gbc_btnAnterior.insets = new Insets(0, 50, 0, 0);
		gbc_btnAnterior.gridx = 1;
		gbc_btnAnterior.gridy = 8;
		contentPane.add(btnAnterior, gbc_btnAnterior);
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.anchor = GridBagConstraints.EAST;
		gbc_btnFinalizar.insets = new Insets(0, 0, 0, 50);
		gbc_btnFinalizar.gridx = 1;
		gbc_btnFinalizar.gridy = 8;
		contentPane.add(btnFinalizar, gbc_btnFinalizar);
		
		JLabel lblPrecioAccesorios = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_paccesorios) + infoAccesorios[1] + " €");
		lblPrecioAccesorios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioAccesorios = new GridBagConstraints();
		gbc_lblPrecioAccesorios.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblPrecioAccesorios.insets = new Insets(0, 0, 5, 100);
		gbc_lblPrecioAccesorios.gridx = 1;
		gbc_lblPrecioAccesorios.gridy = 6;
		contentPane.add(lblPrecioAccesorios, gbc_lblPrecioAccesorios);
		
		// Creamos el Jpanel que contendra los accesorios selecionado
		// por el cliente
		JPanel panelAccesorios = new JPanel();
		panelAccesorios.setLayout(new GridLayout(0,2,10,10));
		GridBagConstraints gbc_panelAccesorios = new GridBagConstraints();
		gbc_panelAccesorios.gridheight = 2;
		gbc_panelAccesorios.gridwidth = 0;
		gbc_panelAccesorios.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelAccesorios.insets = new Insets(0, 50, 5, 0);
		gbc_panelAccesorios.gridx = 0;
		gbc_panelAccesorios.gridy = 6;
		contentPane.add(panelAccesorios, gbc_panelAccesorios);
		
		// Hacemos un for para recorrer la Array de infoAccesorios
		// desde la posicion 3 que el principio deonde se encuentran 
		// los accesorios guardados en el  fichero fs_employee.txt
		for (int i = 3; i < infoAccesorios.length; i++) {
			JLabel lblAccesorios = new JLabel(infoAccesorios[i] + " €");
			lblAccesorios.setFont(new Font("Tahoma", Font.PLAIN, 11));
			panelAccesorios.add(lblAccesorios);
		}
		
		JLabel lblPrecioModelo = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_pmodelo) + infoAccesorios[0] + " €");
		lblPrecioModelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioModelo = new GridBagConstraints();
		gbc_lblPrecioModelo.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblPrecioModelo.insets = new Insets(0, 0, 5, 100);
		gbc_lblPrecioModelo.gridx = 1;
		gbc_lblPrecioModelo.gridy = 4;
		contentPane.add(lblPrecioModelo, gbc_lblPrecioModelo);
		
		//Creamos el Jpane que contendra la informacio del submodelo
		JPanel panelSubmodelo = new JPanel();
		panelSubmodelo.setLayout(new GridLayout(0,3,20,10));
		GridBagConstraints gbc_panelSubmodelo = new GridBagConstraints();
		gbc_panelSubmodelo.gridwidth = 2;
		gbc_panelSubmodelo.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelSubmodelo.insets = new Insets(0, 50, 5, 0);
		gbc_panelSubmodelo.gridx = 0;
		gbc_panelSubmodelo.gridy = 4;
		contentPane.add(panelSubmodelo, gbc_panelSubmodelo);
		
		// Creamos los label de cada campo del submodelo con su informacio
		// y la añadimos al panel
		JLabel lblNombreModel = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_nombreModelo) + infoModelo[0]);
		lblNombreModel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSubmodelo.add(lblNombreModel);
		
		JLabel lblCVModel = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_CV) + infoModelo[1]);
		lblCVModel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSubmodelo.add(lblCVModel);
		
		JLabel lblpuertasModel = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_puertas) + infoModelo[2]);
		lblpuertasModel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSubmodelo.add(lblpuertasModel);
		
		JLabel lblMotorModel = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_motor) + infoModelo[3]);
		lblMotorModel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSubmodelo.add(lblMotorModel);
		
		// Cramos el panle que contrendara la informacion del cliente
		JPanel panelCliente = new JPanel();
		panelCliente.setLayout(new GridLayout(0,3,20,10));
		GridBagConstraints gbc_panelCliente = new GridBagConstraints();
		gbc_panelCliente.gridwidth = 2;
		gbc_panelCliente.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelCliente.insets = new Insets(0, 50, 5, 0);
		gbc_panelCliente.gridx = 0;
		gbc_panelCliente.gridy = 2;
		contentPane.add(panelCliente, gbc_panelCliente);
		
		// Creamos los label de cada campo del usuario con su informacio
		// y la añadimos al panel
		JLabel lblNombreCliente = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_nombrecliente) + infoCliente[0] + " " + infoCliente[1] + " " + infoCliente[2]);
		lblNombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelCliente.add(lblNombreCliente);
		
		JLabel lblDireccionCliente = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_direccion) + infoCliente[3]);
		lblDireccionCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelCliente.add(lblDireccionCliente);
		
		JLabel lblEmailCliente = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_email) + infoCliente[4]);
		lblEmailCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelCliente.add(lblEmailCliente);
		
		JLabel lblGeneroCliente = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_genero) + infoCliente[5]);
		lblGeneroCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelCliente.add(lblGeneroCliente);
		
		JLabel lblNacimientoCliente = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_nacimiento) + infoCliente[6]);
		lblNacimientoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelCliente.add(lblNacimientoCliente);
		
		JLabel lblPrecioTotal = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_ptotal) + adescuento.get(1) + ": " + infoAccesorios[2] + " €");
		lblPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPrecioTotal = new GridBagConstraints();
		gbc_lblPrecioTotal.gridwidth = 2;
		gbc_lblPrecioTotal.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblPrecioTotal.insets = new Insets(0, 0, 5, 100);
		gbc_lblPrecioTotal.gridx = 0;
		gbc_lblPrecioTotal.gridy = 7;
		contentPane.add(lblPrecioTotal, gbc_lblPrecioTotal);
		
		JLabel lblAccesorios = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_accesorios));
		lblAccesorios.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblAccesorios = new GridBagConstraints();
		gbc_lblAccesorios.anchor = GridBagConstraints.WEST;
		gbc_lblAccesorios.gridwidth = 2;
		gbc_lblAccesorios.insets = new Insets(0, 50, 5, 0);
		gbc_lblAccesorios.gridx = 0;
		gbc_lblAccesorios.gridy = 5;
		contentPane.add(lblAccesorios, gbc_lblAccesorios);
		
		JLabel lblModelo = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_modelo));
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.gridwidth = 2;
		gbc_lblModelo.anchor = GridBagConstraints.WEST;
		gbc_lblModelo.insets = new Insets(0, 50, 5, 0);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 3;
		contentPane.add(lblModelo, gbc_lblModelo);
		
		JLabel lblInformacionCliente = new JLabel(idioma.get(VariablesLenguageEnum.resumen_lbl_infocliente));
		lblInformacionCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblInformacionCliente = new GridBagConstraints();
		gbc_lblInformacionCliente.gridwidth = 2;
		gbc_lblInformacionCliente.insets = new Insets(0, 50, 5, 0);
		gbc_lblInformacionCliente.anchor = GridBagConstraints.WEST;
		gbc_lblInformacionCliente.gridx = 0;
		gbc_lblInformacionCliente.gridy = 1;
		contentPane.add(lblInformacionCliente, gbc_lblInformacionCliente);
	}
	
	/*
	 * Metodos
	 */
	private void pasarAnteriorPantalla(pantallaAccesorios frame) {
		f.deleteLastLine();
		this.setVisible(false);
		frame.setVisible(true);
	}
	
	private void pasarSiguientePantalla(String userName) {
			pantallaCliente pCliente = new pantallaCliente(userName);
			this.setVisible(false);
			pCliente.setVisible(true);
	}	
	
	public ArrayList<String> aplicarDescuento(int precioTotal) {
		ArrayList<String> array = new ArrayList<String>();
		int descuento = 0;
		//Creamos las opciones
		Object [] opciones ={"OK","CANCEL"};
		// Creamos las pregunta de guardar datos
		int eleccion = JOptionPane.showOptionDialog(rootPane,idioma.get(VariablesLenguageEnum.resumen_aplicar_descuento),"Mensaje de Confirmacion",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,opciones,"OK");
				//Si es un sí, abre una ventana para aplicar el descuento
				if (eleccion == JOptionPane.YES_OPTION) {
					while (true) {
						descuento = Integer.parseInt(JOptionPane.showInputDialog(rootPane,idioma.get(VariablesLenguageEnum.resumen_var_descuento)));
						if((descuento < 21 && descuento > 0)) {
							break;
						}else {
							JOptionPane.showMessageDialog(rootPane,idioma.get(VariablesLenguageEnum.resumen_error_descuento),"Mensaje de Confirmacion",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}	 
				}
		
		precioTotal = precioTotal - (precioTotal*descuento/100);
		
		array.add(Integer.toString(precioTotal));
		array.add(descuento+"%");
		return array;
	}
	
	public void readFileResum() {
		aFile = new ArrayList<String>();
		String linea;
		
		try {
			fResum = new File("src\\files_temp\\fs_employee.txt");
			fr = new FileReader (fResum);
			br = new BufferedReader(fr);
			

			while((linea=br.readLine())!=null) {
				aFile.add(linea);
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
	
	public String[] StringToAstring(String string) {
		String[] aString = string.split(";");
		return aString;
	}
}
