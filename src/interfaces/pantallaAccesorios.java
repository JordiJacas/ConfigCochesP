package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Impl.LenguageLoader;
import Impl.createFile;
import Impl.readXMLCars;
import model.Accesorio;
import model.SubModelo;
import model.VariablesLenguageEnum;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ItemEvent;

public class pantallaAccesorios extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAccesorios;
	private JTextField textFieldModelo;
	private JTextField textFieldTotal;
	private ArrayList<Accesorio> aAccesorios = new ArrayList<Accesorio>();
	private ArrayList<SubModelo> aSubModelo = new ArrayList<SubModelo>();
	private ArrayList<String> aCheckSelected = new ArrayList<String>();
	private readXMLCars readAccesorios = new readXMLCars();
	private createFile f = new createFile();
	private Hashtable<VariablesLenguageEnum, String> idioma = LenguageLoader.getLenguageConfig().getIdioma();
	private String[] saveClient;
	private ArrayList<String> aSaveClient;
	private boolean isLoad = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//pantallaAccesorios frame = new pantallaAccesorios("Seat Alhambra 1.4 Tsi S&s Reference | 150CV | 5 puertas | Gasolina | 25484", 25484);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pantallaAccesorios(SubModelo subModelo, pantallaSubmodelos frame, String userName) {
		aAccesorios = readAccesorios.readAccesorios();
		aSubModelo = readAccesorios.readSubModelos();
		
		aSaveClient = new ArrayList<String>();
		aSaveClient = f.getDataSave();
		
		if(aSaveClient.size()>4){
			saveClient = aSaveClient.get(4).split(";");
			
			isLoad = true;
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaAccesorios.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setTitle("Concesionario ESTEVE");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {300, 300};
		gbl_contentPane.rowHeights = new int[] {45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSubmodelo = new JLabel(subModelo.toString());
		lblSubmodelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSubmodelo = new GridBagConstraints();
		gbc_lblSubmodelo.anchor = GridBagConstraints.WEST;
		gbc_lblSubmodelo.gridwidth = 2;
		gbc_lblSubmodelo.insets = new Insets(0, 25, 5, 5);
		gbc_lblSubmodelo.gridx = 0;
		gbc_lblSubmodelo.gridy = 2;
		contentPane.add(lblSubmodelo, gbc_lblSubmodelo);
		
		JLabel lblTitulo = new JLabel(idioma.get(VariablesLenguageEnum.accesorios_lbl_titulo));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 150);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 1;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setText(Integer.toString(subModelo.getPrecio()));
		textFieldTotal.setEditable(false);
		textFieldTotal.setColumns(10);
		GridBagConstraints gbc_textFieldTotal = new GridBagConstraints();
		gbc_textFieldTotal.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotal.gridx = 1;
		gbc_textFieldTotal.gridy = 9;
		contentPane.add(textFieldTotal, gbc_textFieldTotal);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setText(Integer.toString(subModelo.getPrecio()));
		textFieldModelo.setEditable(false);
		textFieldModelo.setColumns(10);
		GridBagConstraints gbc_textFieldModelo = new GridBagConstraints();
		gbc_textFieldModelo.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldModelo.gridx = 1;
		gbc_textFieldModelo.gridy = 8;
		contentPane.add(textFieldModelo, gbc_textFieldModelo);
		
		textFieldAccesorios = new JTextField();
		textFieldAccesorios.setText("0");
		textFieldAccesorios.setEditable(false);
		GridBagConstraints gbc_textFieldAccesorios = new GridBagConstraints();
		gbc_textFieldAccesorios.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAccesorios.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldAccesorios.gridx = 1;
		gbc_textFieldAccesorios.gridy = 7;
		contentPane.add(textFieldAccesorios, gbc_textFieldAccesorios);
		textFieldAccesorios.setColumns(10);
		
		JLabel lblTotalPrecio = new JLabel(idioma.get(VariablesLenguageEnum.accesorios_lbl_total));
		lblTotalPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTotalPrecio = new GridBagConstraints();
		gbc_lblTotalPrecio.anchor = GridBagConstraints.WEST;
		gbc_lblTotalPrecio.insets = new Insets(0, 85, 5, 5);
		gbc_lblTotalPrecio.gridx = 0;
		gbc_lblTotalPrecio.gridy = 9;
		contentPane.add(lblTotalPrecio, gbc_lblTotalPrecio);
		
		JLabel lblCoche = new JLabel(idioma.get(VariablesLenguageEnum.accesorios_lbl_coche));
		lblCoche.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCoche = new GridBagConstraints();
		gbc_lblCoche.anchor = GridBagConstraints.WEST;
		gbc_lblCoche.insets = new Insets(0, 85, 5, 5);
		gbc_lblCoche.gridx = 0;
		gbc_lblCoche.gridy = 8;
		contentPane.add(lblCoche, gbc_lblCoche);
		
		JLabel lblAccesorios = new JLabel(idioma.get(VariablesLenguageEnum.accesorios_lbl_accesorios));
		lblAccesorios.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAccesorios = new GridBagConstraints();
		gbc_lblAccesorios.anchor = GridBagConstraints.WEST;
		gbc_lblAccesorios.insets = new Insets(0, 85, 5, 5);
		gbc_lblAccesorios.gridx = 0;
		gbc_lblAccesorios.gridy = 7;
		contentPane.add(lblAccesorios, gbc_lblAccesorios);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,0,10));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 50, 5, 50);
		gbc_panel.gridheight = 4;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		
		for (Accesorio accesorio : aAccesorios) {
			
			JCheckBox check = new JCheckBox(accesorio.getNombre());
			if(isLoad) {
				for (int i = 3; i < saveClient.length; i++) {
					String[] aTemp = saveClient[i].split(":");
					if(accesorio.getNombre().equals(aTemp[0])) {
						check.setSelected(true);
					}
				}
			}
			
			check.setPreferredSize(new Dimension(200,20));
			check.setFont(new Font("Tahoma", Font.PLAIN, 15));
			if(subModelo.getType().equals(accesorio.getType())) {
				check.setEnabled(true);
			}
			else {
				String ToolTip ="";
				for (SubModelo submodelo : aSubModelo) {
					if(submodelo.getType().equals(accesorio.getType())) {
						ToolTip = ToolTip + submodelo.toString() +  ", ";
					}
				}
				check.setEnabled(false);
				check.setToolTipText(ToolTip);
			}
			check.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent chck) {
					
					int pAccesorio = accesorio.getPrecio();
					int pAccesorios = Integer.parseInt(textFieldAccesorios.getText());
					int pTotal = Integer.parseInt(textFieldTotal.getText());
					
					if(chck.getStateChange() == ItemEvent.SELECTED) {
						pAccesorios = pAccesorios + pAccesorio;
						pTotal = pTotal + pAccesorio;
						aCheckSelected.add(accesorio.getNombre() + ": " + pAccesorio);
					}
					else if(chck.getStateChange() == ItemEvent.DESELECTED) {
						pAccesorios = pAccesorios - pAccesorio;
						pTotal = pTotal - pAccesorio;
						aCheckSelected.remove(accesorio.getNombre() + ": " + pAccesorio);
					}
					
					textFieldAccesorios.setText(Integer.toString(pAccesorios));
					textFieldTotal.setText(Integer.toString(pTotal));
				}
			});
			panel.add(check);
			
			//Cargar lbl del precio con la infmarcion del fichero temp.
			if(isLoad) {
				textFieldAccesorios.setText(saveClient[1]);
				textFieldTotal.setText(saveClient[2]);
			}
		}
		
		JButton btnFinalizar = new JButton(idioma.get(VariablesLenguageEnum.accesorios_btn_finalizar));
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarSiguientePantalla(aCheckSelected, textFieldTotal.getText(), textFieldAccesorios.getText(), textFieldModelo.getText(), userName);
			}
		});
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.ipadx = 50;
		gbc_btnFinalizar.insets = new Insets(0, 0, 50, 0);
		gbc_btnFinalizar.gridx = 1;
		gbc_btnFinalizar.gridy = 10;
		contentPane.add(btnFinalizar, gbc_btnFinalizar);
		
		JButton btnAnterior = new JButton(idioma.get(VariablesLenguageEnum.accesorios_btn_anterior));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarAnteriorPantalla(frame);
			}
		});
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.ipadx = 50;
		gbc_btnAnterior.insets = new Insets(0, 0, 50, 5);
		gbc_btnAnterior.gridx = 0;
		gbc_btnAnterior.gridy = 10;
		contentPane.add(btnAnterior, gbc_btnAnterior);
		
		this.addWindowListener( new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				///Creamos las opciones
				Object [] opciones ={"OK","CANCEL"};
				// Creamos las pregunta de guardar datos
				int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Quieres guardar los datos antes de salir?","Mensaje de Confirmacion",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,opciones,"CANCEL");
						//Si es un no al guardar los datos, hace una segunda pregunta para salir sin guardar
						if (eleccion == JOptionPane.NO_OPTION) {
							int eleccion2 = JOptionPane.showOptionDialog(rootPane,"¿Estas seguro que quieres salir?","Mensaje de Confirmacion",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE,null,opciones,"OK");
									if (eleccion2 == JOptionPane.YES_OPTION) {
										System.exit(0);
									}
				} 
				else {
					String lChecks = "";
					for (String check : aCheckSelected) {
						lChecks = lChecks + check + ";";
					}
					saveFile(textFieldModelo.getText()+ ";" + textFieldAccesorios.getText() + ";" + textFieldTotal.getText() + ";" + lChecks);
					System.exit(0);
				}
			}
		});
	}
	
	private void pasarAnteriorPantalla(pantallaSubmodelos frame) {
		f.deleteLastLine();
		this.setVisible(false);
		frame.setVisible(true);
	}
	
	private void pasarSiguientePantalla(ArrayList<String> checks, String pTotal, String pAccesorios, String pModelo, String userName) {
		String lChecks = "";
		for (String check : checks) {
			lChecks = lChecks + check + ";";
		}
		saveFile(pModelo + ";" + pAccesorios + ";" + pTotal + ";" + lChecks);
		pantallaResumen pResumen = new pantallaResumen(this, userName);
		this.setVisible(false);
		pResumen.setVisible(true);
		
	}
	
	private void saveFile(String modelo) {
		if(f.incorporateToFile(modelo)) {
			JOptionPane.showMessageDialog(rootPane,
				    "Datos guardados correctamente",
				    "Guardar datos",
				    JOptionPane.INFORMATION_MESSAGE);
			f.closeFile();
		};
	}

}
