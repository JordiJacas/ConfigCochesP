package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Impl.readXMLCars;
import model.Modelo;
import model.SubModelo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantallaSubmodelos extends JFrame {

	private JPanel contentPane;
	private ArrayList<SubModelo> aSubmodelos = new ArrayList<SubModelo>();
	private readXMLCars readSubModelos = new readXMLCars();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//pantallaSubmodelos frame = new pantallaSubmodelos();
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
	public pantallaSubmodelos(pantallaCompra frame, Modelo modelo) {
		aSubmodelos = readSubModelos.readSubModelos();
		
		setResizable(false);
		setTitle("Concecionario ESTEVE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaSubmodelos.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[] {30, 125, 125, 125};
		gbl_contentPane.columnWidths = new int[] {150, 150, 150, 150};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("Selecci\u00F3n de caracter\u00EDticas del modelo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);

		DefaultListModel<String> modelDatos = new DefaultListModel();
		for (SubModelo submodelo : aSubmodelos) {
				if(modelo.getId() == submodelo.getModelo()) {
					modelDatos.addElement(submodelo.toString());
				}			
		}
		
		JList listSubmodelos = new JList();
		GridBagConstraints gbc_listSubmodelos = new GridBagConstraints();
		gbc_listSubmodelos.gridwidth = 4;
		gbc_listSubmodelos.insets = new Insets(0, 15, 5, 15);
		gbc_listSubmodelos.fill = GridBagConstraints.BOTH;
		gbc_listSubmodelos.gridx = 0;
		gbc_listSubmodelos.gridy = 1;
		contentPane.add(listSubmodelos, gbc_listSubmodelos);
		listSubmodelos.setModel(modelDatos);
		listSubmodelos.setVisible(true);
		
		JButton btnSigiente = new JButton("Sigiente");
		btnSigiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<String> submodelo = listSubmodelos.getSelectedValuesList();
				Iterator it = submodelo.iterator();
				String elemento="";
				elemento = (String) it.next();
				String [] aElemento = elemento.split(" | ");
				for(SubModelo subModelo:aSubmodelos) {
					if(subModelo.toString() == elemento) {
						pasarSiguientePantalla(subModelo);
					}
				}	
			}
		});
		GridBagConstraints gbc_btnSigiente = new GridBagConstraints();
		gbc_btnSigiente.ipadx = 30;
		gbc_btnSigiente.gridwidth = 2;
		gbc_btnSigiente.gridx = 2;
		gbc_btnSigiente.gridy = 3;
		contentPane.add(btnSigiente, gbc_btnSigiente);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarAnteriorPantalla(frame);
			}
		});
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.ipadx = 30;
		gbc_btnAnterior.gridwidth = 2;
		gbc_btnAnterior.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnterior.gridx = 0;
		gbc_btnAnterior.gridy = 3;
		contentPane.add(btnAnterior, gbc_btnAnterior);
	}

	private void pasarAnteriorPantalla(pantallaCompra frame) {
		this.setVisible(false);
		frame.setVisible(true);
	}
	
	private void pasarSiguientePantalla(SubModelo subModelo) {
		pantallaAccesorios pCompra = new pantallaAccesorios(subModelo, this);
		this.setVisible(false);
		pCompra.setVisible(true);
	}
	
}
