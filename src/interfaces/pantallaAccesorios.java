package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Accesorio;

import java.awt.GridBagLayout;
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
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class pantallaAccesorios extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAccesorios;
	private JTextField textFieldModelo;
	private JTextField textFieldTotal;
	private ArrayList<Accesorio> aAccesorios = new ArrayList<Accesorio>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaAccesorios frame = new pantallaAccesorios("Seat Alhambra 1.4 Tsi S&s Reference | 150CV | 5 puertas | Gasolina | 25484", 25484);
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
	public pantallaAccesorios(String submodelo, int pSubmodelo) {
		aAccesorios.add(new Accesorio(1,"USB","descripcion","imagen",15));
		aAccesorios.add(new Accesorio(2,"Aparcamiento","descripcion","imagen",800));
		aAccesorios.add(new Accesorio(3,"Radio","descripcion","imagen",150));
		aAccesorios.add(new Accesorio(4,"Amortiguacion","descripcion","imagen",400));
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaAccesorios.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setTitle("Concesionario ESTEVE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblSubmodelo = new JLabel(submodelo);
		lblSubmodelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblSubmodelo = new GridBagConstraints();
		gbc_lblSubmodelo.anchor = GridBagConstraints.WEST;
		gbc_lblSubmodelo.gridwidth = 2;
		gbc_lblSubmodelo.insets = new Insets(0, 25, 5, 5);
		gbc_lblSubmodelo.gridx = 0;
		gbc_lblSubmodelo.gridy = 2;
		contentPane.add(lblSubmodelo, gbc_lblSubmodelo);
		
		JLabel lblTitulo = new JLabel("Compra de Accesorios");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 150);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 1;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setText(Integer.toString(pSubmodelo));
		textFieldTotal.setEnabled(false);
		textFieldTotal.setEditable(false);
		textFieldTotal.setColumns(10);
		GridBagConstraints gbc_textFieldTotal = new GridBagConstraints();
		gbc_textFieldTotal.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotal.gridx = 1;
		gbc_textFieldTotal.gridy = 9;
		contentPane.add(textFieldTotal, gbc_textFieldTotal);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setText(Integer.toString(pSubmodelo));
		textFieldModelo.setEnabled(false);
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
		textFieldAccesorios.setEnabled(false);
		textFieldAccesorios.setEditable(false);
		GridBagConstraints gbc_textFieldAccesorios = new GridBagConstraints();
		gbc_textFieldAccesorios.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAccesorios.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldAccesorios.gridx = 1;
		gbc_textFieldAccesorios.gridy = 7;
		contentPane.add(textFieldAccesorios, gbc_textFieldAccesorios);
		textFieldAccesorios.setColumns(10);
		
		JLabel lblTotalPrecio = new JLabel("Precio total");
		lblTotalPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTotalPrecio = new GridBagConstraints();
		gbc_lblTotalPrecio.anchor = GridBagConstraints.WEST;
		gbc_lblTotalPrecio.insets = new Insets(0, 85, 5, 5);
		gbc_lblTotalPrecio.gridx = 0;
		gbc_lblTotalPrecio.gridy = 9;
		contentPane.add(lblTotalPrecio, gbc_lblTotalPrecio);
		
		JLabel lblCoche = new JLabel("Precio del modelo");
		lblCoche.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCoche = new GridBagConstraints();
		gbc_lblCoche.anchor = GridBagConstraints.WEST;
		gbc_lblCoche.insets = new Insets(0, 85, 5, 5);
		gbc_lblCoche.gridx = 0;
		gbc_lblCoche.gridy = 8;
		contentPane.add(lblCoche, gbc_lblCoche);
		
		JLabel lblAccesorios = new JLabel("Augmento en el precio");
		lblAccesorios.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAccesorios = new GridBagConstraints();
		gbc_lblAccesorios.anchor = GridBagConstraints.WEST;
		gbc_lblAccesorios.insets = new Insets(0, 85, 5, 5);
		gbc_lblAccesorios.gridx = 0;
		gbc_lblAccesorios.gridy = 7;
		contentPane.add(lblAccesorios, gbc_lblAccesorios);
		
		JPanel panel = new JPanel();
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
			check.setPreferredSize(new Dimension(200,20));
			check.setFont(new Font("Tahoma", Font.PLAIN, 15));
			check.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent chck) {
					
					int pAccesorio = accesorio.getPrecio();
					int pAccesorios = Integer.parseInt(textFieldAccesorios.getText());
					int pTotal = Integer.parseInt(textFieldModelo.getText());
					
					if(chck.getStateChange() == ItemEvent.SELECTED) {
						pAccesorios = pAccesorios + pAccesorio;
						pTotal = pTotal + pAccesorio;
						
					}
					else if(chck.getStateChange() == ItemEvent.DESELECTED) {
						pAccesorios = pAccesorios - pAccesorio;
						pTotal = pTotal - pAccesorio;
					}
					
					textFieldAccesorios.setText(Integer.toString(pAccesorios));
					textFieldTotal.setText(Integer.toString(pTotal));
				}
			});
			panel.add(check);
		}
		
		JButton btnFinalizar = new JButton("Finalizar");
		GridBagConstraints gbc_btnFinalizar = new GridBagConstraints();
		gbc_btnFinalizar.ipadx = 50;
		gbc_btnFinalizar.insets = new Insets(0, 0, 50, 0);
		gbc_btnFinalizar.gridx = 1;
		gbc_btnFinalizar.gridy = 10;
		contentPane.add(btnFinalizar, gbc_btnFinalizar);
		
		JButton btnAnterior = new JButton("Anterior");
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.ipadx = 50;
		gbc_btnAnterior.insets = new Insets(0, 0, 50, 5);
		gbc_btnAnterior.gridx = 0;
		gbc_btnAnterior.gridy = 10;
		contentPane.add(btnAnterior, gbc_btnAnterior);
	}

}
