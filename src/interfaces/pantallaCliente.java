package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import com.sun.glass.events.WindowEvent;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_OVERLAYPeer;
import com.toedter.calendar.JDateChooser;

import Impl.LenguageLoader;
import Impl.createFile;
import jdk.management.resource.internal.inst.DatagramChannelImplRMHooks;
import model.VariablesLenguageEnum;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantallaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textDireccion;
	private JTextField textEmail;
	private boolean isSave = false;
	private String genero = "Campo Vacio";
	private String fecha = "Campo Vacio";
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private ButtonGroup bg = new ButtonGroup();
	private createFile f = new createFile();
	private Hashtable<VariablesLenguageEnum, String> idioma = LenguageLoader.getLenguageConfig().getIdioma();
	private String[] saveClient = new String[6];
	private ArrayList<String> aSaveClient;
	private boolean isLoad = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaCliente frame = new pantallaCliente("user");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public pantallaCliente(String userName) {
		aSaveClient = new ArrayList<String>();
		f.createFileEmployee();
		aSaveClient = f.getDataSave();
		
		if(aSaveClient.size()>1){
			saveClient = aSaveClient.get(1).split(";");
			isLoad = true;
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaCliente.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setTitle("Concesionario ESTEVE");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 480, 400);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {10, 30, 30, 30, 30, 30, 30};
		gbl_contentPane.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 4;
		gbc_dateChooser.insets = new Insets(5, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 9;
		contentPane.add(dateChooser, gbc_dateChooser);
		
		//Insertar fecha guardada en el archivo
		if(isLoad && !fecha.equals(saveClient[6]) && !saveClient[6].isEmpty()) {
			Date date2;
			try {
				dateChooser.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(saveClient[6]));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	
		JButton btnSigiente = new JButton(idioma.get(VariablesLenguageEnum.cliente_btn_next));
		btnSigiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isSave) {
					pasarSiguientePantalla(userName);			
				}
				else {
					pantallaCliente frame = new pantallaCliente(" ");
					JOptionPane.showMessageDialog(frame,
						    VariablesLenguageEnum.pantalla_cliente_pasar_pantalla_sin_datos_guardados,
						    "Guardar Datos",
						    JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnSigiente = new GridBagConstraints();
		gbc_btnSigiente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSigiente.gridwidth = 3;
		gbc_btnSigiente.insets = new Insets(15, 0, 5, 5);
		gbc_btnSigiente.gridx = 3;
		gbc_btnSigiente.gridy = 10;
		contentPane.add(btnSigiente, gbc_btnSigiente);
		
		JLabel lblFecha = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_fecha));
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.WEST;
		gbc_lblFecha.gridwidth = 2;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 9;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		JRadioButton radioButtonOtro = new JRadioButton(idioma.get(VariablesLenguageEnum.cliente_rdbtn_other));
		radioButtonOtro.setActionCommand(idioma.get(VariablesLenguageEnum.cliente_rdbtn_other));
		GridBagConstraints gbc_radioButtonOtro = new GridBagConstraints();
		gbc_radioButtonOtro.gridwidth = 2;
		gbc_radioButtonOtro.insets = new Insets(0, 0, 5, 5);
		gbc_radioButtonOtro.gridx = 4;
		gbc_radioButtonOtro.gridy = 8;
		contentPane.add(radioButtonOtro, gbc_radioButtonOtro);
		
		JRadioButton radioButtonMujer = new JRadioButton(idioma.get(VariablesLenguageEnum.cliente_rdbtn_women));
		radioButtonMujer.setActionCommand(idioma.get(VariablesLenguageEnum.cliente_rdbtn_women));
		GridBagConstraints gbc_radioButtonMujer = new GridBagConstraints();
		gbc_radioButtonMujer.insets = new Insets(0, 0, 5, 5);
		gbc_radioButtonMujer.gridx = 3;
		gbc_radioButtonMujer.gridy = 8;
		contentPane.add(radioButtonMujer, gbc_radioButtonMujer);
		
		JRadioButton rdbtnHombre = new JRadioButton(idioma.get(VariablesLenguageEnum.cliente_rdbtn_men));
		rdbtnHombre.setActionCommand(idioma.get(VariablesLenguageEnum.cliente_rdbtn_men));
		GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
		gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnHombre.gridx = 2;
		gbc_rdbtnHombre.gridy = 8;
		contentPane.add(rdbtnHombre, gbc_rdbtnHombre);
		
		bg.add(radioButtonMujer);
		bg.add(rdbtnHombre);
		bg.add(radioButtonOtro);
		
		//Seleccionamos el radio Button guardado en el fichero
		if(isLoad && !saveClient[5].equals(genero)) {
			if(saveClient[5].toUpperCase().equals("DONA") || saveClient[5].toUpperCase().equals("MUJER") || saveClient[5].toUpperCase().equals("WOMEN")) {
				radioButtonMujer.setSelected(true);
			}
			else if(saveClient[5].toUpperCase().equals("NO DETERMINAT") || saveClient[5].toUpperCase().equals("NO DETERMINADO") || saveClient[5].toUpperCase().equals("OTHER")) {
				System.out.println("h");
				radioButtonOtro.setSelected(true);
			}
			else if(saveClient[5].toUpperCase().equals("HOME") || saveClient[5].toUpperCase().equals("HOMBRE") || saveClient[5].toUpperCase().equals("MAN")) {
				rdbtnHombre.setSelected(true);
			}
		}
		
		JLabel lblGenero = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_genero));
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.WEST;
		gbc_lblGenero.gridwidth = 2;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 8;
		contentPane.add(lblGenero, gbc_lblGenero);
		
		textEmail = new JTextField();
		//Cargamos los datos guardados en el archivo
		if(saveClient!=null) {textEmail.setText(saveClient[4]);}
		textEmail.setColumns(10);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.gridwidth = 4;
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 3;
		gbc_textEmail.gridy = 7;
		contentPane.add(textEmail, gbc_textEmail);
		
		JLabel lblEmail = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_email));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridwidth = 2;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		textDireccion = new JTextField();
		//Cargamos los datos guardados en el archivo
		if(isLoad) {textDireccion.setText(saveClient[3]);}
		textDireccion.setColumns(10);
		GridBagConstraints gbc_textDireccion = new GridBagConstraints();
		gbc_textDireccion.gridwidth = 4;
		gbc_textDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_textDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDireccion.gridx = 3;
		gbc_textDireccion.gridy = 6;
		contentPane.add(textDireccion, gbc_textDireccion);
		
		JLabel lblDireccion = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_direccion));
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.WEST;
		gbc_lblDireccion.gridwidth = 2;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 6;
		contentPane.add(lblDireccion, gbc_lblDireccion);
		
		textApellido2 = new JTextField();
		//Cargamos los datos guardados en el archivo
		if(isLoad) {textApellido2.setText(saveClient[2]);}
		textApellido2.setColumns(10);
		GridBagConstraints gbc_textApellido2 = new GridBagConstraints();
		gbc_textApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido2.gridwidth = 4;
		gbc_textApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_textApellido2.gridx = 3;
		gbc_textApellido2.gridy = 5;
		contentPane.add(textApellido2, gbc_textApellido2);
		
		JLabel lblApellido2 = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_apellido2));
		lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblApellido2 = new GridBagConstraints();
		gbc_lblApellido2.anchor = GridBagConstraints.WEST;
		gbc_lblApellido2.gridwidth = 2;
		gbc_lblApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido2.gridx = 0;
		gbc_lblApellido2.gridy = 5;
		contentPane.add(lblApellido2, gbc_lblApellido2);
		
		textApellido1 = new JTextField();
		//Cargamos los datos guardados en el archivo
		if(isLoad) {textApellido1.setText(saveClient[1]);}
		textApellido1.setColumns(10);
		GridBagConstraints gbc_textApellido1 = new GridBagConstraints();
		gbc_textApellido1.gridwidth = 4;
		gbc_textApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_textApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido1.gridx = 3;
		gbc_textApellido1.gridy = 4;
		contentPane.add(textApellido1, gbc_textApellido1);
		
		JLabel lblApellido1 = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_apellido));
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblApellido1 = new GridBagConstraints();
		gbc_lblApellido1.gridwidth = 2;
		gbc_lblApellido1.anchor = GridBagConstraints.WEST;
		gbc_lblApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido1.gridx = 0;
		gbc_lblApellido1.gridy = 4;
		contentPane.add(lblApellido1, gbc_lblApellido1);
		
		textNombre = new JTextField();
		//Cargamos los datos guardados en el archivo
		if(isLoad) {textNombre.setText(saveClient[0]);}
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 4;
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 3;
		gbc_textNombre.gridy = 3;
		contentPane.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_nombre));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 3;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		JPanel pUser = new JPanel();
		GridBagConstraints gbc_pUser = new GridBagConstraints();
		gbc_pUser.gridwidth = 2;
		gbc_pUser.insets = new Insets(0, 0, 5, 0);
		gbc_pUser.fill = GridBagConstraints.BOTH;
		gbc_pUser.gridx = 5;
		gbc_pUser.gridy = 1;
		contentPane.add(pUser, gbc_pUser);
		
		JLabel lblUsuario = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_usuario));
		pUser.add(lblUsuario);
		
		JLabel lblnUser = new JLabel(userName);
		pUser.add(lblnUser);
		
		JLabel lblTitulo = new JLabel(idioma.get(VariablesLenguageEnum.cliente_lbl_titulo));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 1;
		contentPane.add(lblTitulo, gbc_lblTitulo);		

		
		JButton btnGuardar = new JButton(idioma.get(VariablesLenguageEnum.cliente_btn_guardar));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(bg.getSelection() != null) {
					genero = bg.getSelection().getActionCommand();
				}
				if(dateChooser.getDate() != null) {
					fecha = df.format(dateChooser.getDate());
				}
				

				if(emptyTxt()) {
					
					if(f.incorporateToFile(textNombre.getText() + ";" + textApellido1.getText() + ";"
							+ textApellido2.getText() + ";" + textDireccion.getText() + ";" + textEmail.getText()
							 + ";" + genero + ";" + fecha)) {

						JOptionPane.showMessageDialog(rootPane,
							    VariablesLenguageEnum.guardar_datos_cliente,
							    "Guardar Datos",
							    JOptionPane.INFORMATION_MESSAGE);
						isSave = true;
					}
					

					f.closeFile();

				}
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.ipadx = 60;
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(15, 0, 5, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 10;
		contentPane.add(btnGuardar, gbc_btnGuardar);	
		
		this.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				if(bg.getSelection() != null) {
					genero = bg.getSelection().getActionCommand();
				}
				if(dateChooser.getDate() != null) {
					fecha = df.format(dateChooser.getDate());
				}
				//Creamos las opciones
				Object [] opciones ={"OK","CANCEL"};
				// Creamos las pregunta de guardar datos
				if(!isSave) {
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
					} else {
						//Compravacion de los campos de Genero y fecha de nacimiento
						//para saber si estan vacios
						if(bg.getSelection() != null) {
							genero = bg.getSelection().getActionCommand();
						}
						if(dateChooser.getDate() != null) {
							fecha = df.format(dateChooser.getDate());
						}
						
						//Guardar datos en el fichero
						if(f.incorporateToFile(textNombre.getText() + ";" + textApellido1.getText() + ";"
						+ textApellido2.getText() + ";" + textDireccion.getText() + ";" + textEmail.getText()
						 + ";" + genero + ";" + fecha + ";")) {
							JOptionPane.showMessageDialog(rootPane,
								    VariablesLenguageEnum.guardar_datos_cliente,
								    "Guardar datos",
								    JOptionPane.INFORMATION_MESSAGE);
							f.closeFile();
							System.exit(0);
						};
					}
				}
			}
		} ); 
	}
	
	public boolean emptyTxt() {
		if(textNombre.getText().isEmpty() || textApellido1.getText().isEmpty() ||
			textApellido2.getText().isEmpty() || textDireccion.getText().isEmpty() ||
			(textEmail.getText().isEmpty() && (textEmail.getText().contains("@") && textEmail.getText().contains(".")))) {
			
			pantallaCliente frame = new pantallaCliente(" ");
			JOptionPane.showMessageDialog(frame,
				    VariablesLenguageEnum.pantalla_cliente_campo_obligatorio,
				    "Empty Error",
				    JOptionPane.INFORMATION_MESSAGE);
			return false;
		} 
		if (!(textEmail.getText().contains("@") && textEmail.getText().contains("."))) {
			JOptionPane.showMessageDialog(this,
				    VariablesLenguageEnum.pantalla_cliente_formato_correo_erroneo,
				    "Empty Error",
				    JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void pasarSiguientePantalla(String userName) {
		if(emptyTxt()) {
			pantallaCompra pCliente = new pantallaCompra(this, userName);
			this.setVisible(false);
			pCliente.setVisible(true);
		}
	}
}
