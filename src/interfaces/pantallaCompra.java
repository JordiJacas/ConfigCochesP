package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Impl.LenguageLoader;
import Impl.createFile;
import Impl.readXMLCars;
import model.Modelo;
import model.VariablesLenguageEnum;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.DropMode;
		
public class pantallaCompra extends JFrame {

	private JPanel contentPane;
	private ArrayList<Modelo> aModelo = new ArrayList<Modelo>();
	private int contadorBtn = 0;
	private readXMLCars readCars = new readXMLCars();
	private createFile f = new createFile();
	private Hashtable<VariablesLenguageEnum, String> idioma = LenguageLoader.getLenguageConfig().getIdioma();
	private String[] saveClient = new String[2];
	private ArrayList<String> aSaveClient;
	private boolean isLoad = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//pantallaCompra frame = new pantallaCompra("d");
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
	public pantallaCompra(pantallaCliente frame, String userName) {
		aModelo = readCars.readModelos();
		aSaveClient = new ArrayList<String>();
		aSaveClient = f.getDataSave();
		
		if(aSaveClient.size()>2){
			saveClient = aSaveClient.get(2).split(";");
			isLoad = true;
		}
		
		setResizable(false);
		setTitle("Concesionario ESTEVE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaCompra.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[] {60, 60, 60, 60, 60, 60, 60, 60, 60};
		gbl_contentPane.columnWidths = new int[] {200, 160, 160, 160, 120};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel(idioma.get(VariablesLenguageEnum.compra_lbl_titulo));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		
		JPanel pUser = new JPanel();
		GridBagConstraints gbc_pUser = new GridBagConstraints();
		gbc_pUser.insets = new Insets(0, 0, 5, 0);
		gbc_pUser.gridwidth = 2;
		gbc_pUser.gridx = 3;
		gbc_pUser.gridy = 0;
		contentPane.add(pUser, gbc_pUser);
		
		JLabel lblUsuario = new JLabel(idioma.get(VariablesLenguageEnum.compra_lbl_usuario));
		pUser.add(lblUsuario);
		
		JLabel lblUser = new JLabel(userName);
		pUser.add(lblUser);
		
		JLabel lblId = new JLabel(Integer.toString(aModelo.get(0).getId()));
		
		JLabel lblMostrar = new JLabel();
		lblMostrar.setBackground(Color.WHITE);
		ImageIcon iconolbl = null;
		
		if(isLoad) {
			for (Modelo modelo : aModelo) {
				if(modelo.getId()==Integer.parseInt(saveClient[0])){
					iconolbl = new ImageIcon("src/recursos/imgCoches/" + modelo.getImagen());
					lblId.setText(Integer.toString(modelo.getId()));
				}
			}
		}
		else {
			iconolbl = new ImageIcon("src/recursos/imgCoches/" + aModelo.get(0).getImagen());
			
		}
		
		ImageIcon lblicono = new ImageIcon(iconolbl.getImage().getScaledInstance(480,240,
                java.awt.Image.SCALE_DEFAULT));
		lblMostrar.setIcon(lblicono);
		
		GridBagConstraints gbc_lblMostrar = new GridBagConstraints();
		gbc_lblMostrar.gridheight = 4;
		gbc_lblMostrar.gridwidth = 4;
		gbc_lblMostrar.insets = new Insets(0, 50, 5, 50);
		gbc_lblMostrar.fill = GridBagConstraints.BOTH;
		gbc_lblMostrar.gridx = 1;
		gbc_lblMostrar.gridy = 1;
		contentPane.add(lblMostrar, gbc_lblMostrar);
		
		JTextArea areaDescripcion = new JTextArea(10,1);
		areaDescripcion.setLineWrap(true);
		areaDescripcion.setEditable(false);
		areaDescripcion.setBackground(Color.WHITE);
		
		if(isLoad) {
			for (Modelo modelo : aModelo) {
				if(modelo.getId()==Integer.parseInt(saveClient[0])){
					areaDescripcion.setText(modelo.getDescripcion());
				}
			}
		}
		else {
			areaDescripcion.setText(aModelo.get(0).getDescripcion());
		}

		GridBagConstraints gbc_areaDescripcion = new GridBagConstraints();
		gbc_areaDescripcion.anchor = GridBagConstraints.NORTH;
		gbc_areaDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaDescripcion.gridwidth = 2;
		gbc_areaDescripcion.gridheight = 2;
		gbc_areaDescripcion.insets = new Insets(10, 0, 5, 50);
		gbc_areaDescripcion.gridx = 3;
		gbc_areaDescripcion.gridy = 5;
		contentPane.add(areaDescripcion, gbc_areaDescripcion);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1,0,10));
        
        for (Modelo modelo : aModelo) {
        	JButton[] arraybtn = new JButton[aModelo.size()];
        	ImageIcon iconobtn = new ImageIcon("src/recursos/imgCoches/" + modelo.getImagen());
        	ImageIcon btnicono = new ImageIcon(iconobtn.getImage().getScaledInstance(130,60,
                    java.awt.Image.SCALE_DEFAULT));
        	arraybtn[contadorBtn] = new JButton();
        	arraybtn[contadorBtn].setIcon(btnicono);
        	panel.add(arraybtn[contadorBtn]);
        	arraybtn[contadorBtn].addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
				ImageIcon accionicono = new ImageIcon(iconobtn.getImage().getScaledInstance(480,240,
	                    java.awt.Image.SCALE_DEFAULT));
    			 areaDescripcion.setText(modelo.getDescripcion());
    			 lblMostrar.setIcon(accionicono);
    			 lblId.setText(Integer.toString(modelo.getId()));
    			}
    		});
        	contadorBtn++;
		}
        
		JScrollPane scrollBar = new JScrollPane(panel);
        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.weightx = 160.0;
		gbc_scrollBar.ipadx = 160;
		gbc_scrollBar.ipady = 420;
		gbc_scrollBar.anchor = GridBagConstraints.WEST;
		gbc_scrollBar.gridheight = 7;
		gbc_scrollBar.insets = new Insets(0, 5, 0, 0);
		gbc_scrollBar.gridx = 0;
		gbc_scrollBar.gridy = 1;
		contentPane.add(scrollBar, gbc_scrollBar);
		
		JButton btnSigiente = new JButton(idioma.get(VariablesLenguageEnum.compra_btn_next));
		btnSigiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Modelo modelo : aModelo) {
					if(modelo.getId() == Integer.parseInt(lblId.getText())) {
						pasarSiguientePantalla(modelo, userName);
					}
				}
			}
		});
		GridBagConstraints gbc_btnSigiente = new GridBagConstraints();
		gbc_btnSigiente.anchor = GridBagConstraints.EAST;
		gbc_btnSigiente.gridwidth = 2;
		gbc_btnSigiente.ipady = 10;
		gbc_btnSigiente.ipadx = 80;
		gbc_btnSigiente.insets = new Insets(0, 0, 5, 50);
		gbc_btnSigiente.gridx = 3;
		gbc_btnSigiente.gridy = 7;
		contentPane.add(btnSigiente, gbc_btnSigiente);
		
		JButton btnAnterior = new JButton(idioma.get(VariablesLenguageEnum.compra_btn_anterior));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarAnteriorPantalla(frame);
			}
		});
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.ipady = 10;
		gbc_btnAnterior.ipadx = 60;
		gbc_btnAnterior.weightx = 5.0;
		gbc_btnAnterior.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnterior.gridx = 1;
		gbc_btnAnterior.gridy = 7;
		contentPane.add(btnAnterior, gbc_btnAnterior);
		
		this.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				//Creamos las opciones
				Object [] opciones ={"OK","CANCEL"};
				// Creamos las pregunta de guardar datos
				int eleccion = JOptionPane.showOptionDialog(rootPane,VariablesLenguageEnum.guardar_datos_al_cerrar,"Mensaje de Confirmacion",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,opciones,"CANCEL");
						//Si es un no al guardar los datos, hace una segunda pregunta para salir sin guardar
						if (eleccion == JOptionPane.NO_OPTION) {
							int eleccion2 = JOptionPane.showOptionDialog(rootPane,VariablesLenguageEnum.guardar_datos_al_cerrar_negativo,"Mensaje de Confirmacion",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE,null,opciones,"OK");
									if (eleccion2 == JOptionPane.YES_OPTION) {
										System.exit(0);
									}
				} else {
					for (Modelo modelo : aModelo) {
						if(modelo.getId() == Integer.parseInt(lblId.getText())) {
							saveFile(modelo.toString());
							System.exit(0);
						}
					}
				}
			}
		}); 
		
	}

	private void pasarAnteriorPantalla(pantallaCliente frame) {
		f.deleteLastLine();
		this.setVisible(false);
		frame.setVisible(true);
	}
	
	private void pasarSiguientePantalla(Modelo modelo, String userName) {
		saveFile(modelo.getId() + ";" + modelo.getNombre());
		pantallaSubmodelos pCompra = new pantallaSubmodelos(this, modelo, userName);
		this.setVisible(false);
		pCompra.setVisible(true);
	}
	
	private void saveFile(String modelo) {
		if(f.incorporateToFile(modelo)) {
			JOptionPane.showMessageDialog(rootPane,
				    VariablesLenguageEnum.guardar_datos_cliente,
				    "Guardar datos",
				    JOptionPane.INFORMATION_MESSAGE);
			f.closeFile();
		};
	}
	
}
