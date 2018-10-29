package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
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

public class pantallaCompra extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public pantallaCompra(pantallaCliente frame) {
		String[] aImg = new String[] {"citroen_cactus.jpg", "ibiza.jpg", "kia_carens.jpg", "mini.jpg"};		
		
		setTitle("Concesionario ESTEVE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaCompra.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblTitulo = new JLabel("SELECCIONAR EL MODELO DEL TITULO");
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
		
		JLabel lblUsuario = new JLabel("Usuario:");
		pUser.add(lblUsuario);
		
		JLabel lblUser = new JLabel("User");
		pUser.add(lblUser);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarAnteriorPantalla(frame);
			}
		});
		
		JButton btnSigiente = new JButton("Sigiente");
		btnSigiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarSiguientePantalla();
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
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.ipady = 10;
		gbc_btnAnterior.ipadx = 60;
		gbc_btnAnterior.weightx = 5.0;
		gbc_btnAnterior.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnterior.gridx = 1;
		gbc_btnAnterior.gridy = 7;
		contentPane.add(btnAnterior, gbc_btnAnterior);
		
		JLabel lblMostrar = new JLabel();
		lblMostrar.setBackground(Color.WHITE);
		ImageIcon iconolbl = new ImageIcon("src/recursos/imgCoches/" + aImg[0]);
		
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
		
		JTextArea areaDescripcion = new JTextArea();
		areaDescripcion.setBackground(Color.WHITE);
		areaDescripcion.setText("Aqui va la descripcion");
		GridBagConstraints gbc_areaDescripcion = new GridBagConstraints();
		gbc_areaDescripcion.gridwidth = 2;
		gbc_areaDescripcion.gridheight = 2;
		gbc_areaDescripcion.insets = new Insets(10, 0, 5, 50);
		gbc_areaDescripcion.fill = GridBagConstraints.BOTH;
		gbc_areaDescripcion.gridx = 3;
		gbc_areaDescripcion.gridy = 5;
		contentPane.add(areaDescripcion, gbc_areaDescripcion);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1,0,10));
		
        for (int i = 0; i < aImg.length; i++) {
        	JButton[] arraybtn = new JButton[aImg.length];
        	ImageIcon iconobtn = new ImageIcon("src/recursos/imgCoches/" + aImg[i]);
        	ImageIcon btnicono = new ImageIcon(iconobtn.getImage().getScaledInstance(130,60,
                    java.awt.Image.SCALE_DEFAULT));
        	arraybtn[i] = new JButton();
        	arraybtn[i].setIcon(btnicono);
        	panel.add(arraybtn[i]);
        	
        	arraybtn[i].addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
				ImageIcon accionicono = new ImageIcon(iconobtn.getImage().getScaledInstance(480,240,
	                    java.awt.Image.SCALE_DEFAULT));
    			 areaDescripcion.setText("Aqui va la descripcion");
    			 lblMostrar.setIcon(accionicono);
    			}
    		});
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
	
		this.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				//Creamos las opciones
				Object [] opciones ={"OK","CANCEL"};
				// Creamos las pregunta de guardar datos
				int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Quiere salir guardando los datos?","Mensaje de Confirmacion",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,opciones,"CANCEL");
				//Si es un no al guardar los datos, hace una segunda pregunta para salir sin guardar
				if (eleccion == JOptionPane.NO_OPTION) {
					int eleccion2 = JOptionPane.showOptionDialog(rootPane,"¿Quieres salir SIN guardar los datos?","Mensaje de Confirmacion",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,null,opciones,"OK");
							if (eleccion2 == JOptionPane.YES_OPTION) {
								System.exit(0);
							}
				} 
				// Aquí el else para guardar los datos en un fichero.
			}
		} ); 
		
	}

	private void pasarAnteriorPantalla(pantallaCliente frame) {
		this.setVisible(false);
		frame.setVisible(true);
	}
	
	private void pasarSiguientePantalla() {
		pantallaSubmodelos ps = new pantallaSubmodelos(this);
		this.setVisible(false);
		ps.setVisible(true);
	}
	
}
