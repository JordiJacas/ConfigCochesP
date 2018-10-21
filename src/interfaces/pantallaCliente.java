package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

public class pantallaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textDireccion;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaCliente frame = new pantallaCliente();
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
	public pantallaCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaCliente.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setTitle("Concesionario ESTEVE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 0, 30, 30, 30, 30, 30, 30};
		gbl_contentPane.rowHeights = new int[] {0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.WEST;
		gbc_lblGenero.gridwidth = 2;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 9;
		contentPane.add(lblGenero, gbc_lblGenero);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.gridwidth = 4;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 3;
		gbc_textEmail.gridy = 8;
		contentPane.add(textEmail, gbc_textEmail);
		
		JLabel lblEmail = new JLabel("Correo electr\u00F3nico*");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.gridwidth = 2;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		GridBagConstraints gbc_textDireccion = new GridBagConstraints();
		gbc_textDireccion.gridwidth = 4;
		gbc_textDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_textDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDireccion.gridx = 3;
		gbc_textDireccion.gridy = 7;
		contentPane.add(textDireccion, gbc_textDireccion);
		
		JLabel lblDireccion = new JLabel("Direccion*");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.WEST;
		gbc_lblDireccion.gridwidth = 2;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 7;
		contentPane.add(lblDireccion, gbc_lblDireccion);
		
		textApellido2 = new JTextField();
		textApellido2.setColumns(10);
		GridBagConstraints gbc_textApellido2 = new GridBagConstraints();
		gbc_textApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido2.gridwidth = 4;
		gbc_textApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_textApellido2.gridx = 3;
		gbc_textApellido2.gridy = 6;
		contentPane.add(textApellido2, gbc_textApellido2);
		
		JLabel lblApellido2 = new JLabel("Segundo Apellido*");
		lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblApellido2 = new GridBagConstraints();
		gbc_lblApellido2.anchor = GridBagConstraints.WEST;
		gbc_lblApellido2.gridwidth = 2;
		gbc_lblApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido2.gridx = 0;
		gbc_lblApellido2.gridy = 6;
		contentPane.add(lblApellido2, gbc_lblApellido2);
		
		textApellido1 = new JTextField();
		textApellido1.setColumns(10);
		GridBagConstraints gbc_textApellido1 = new GridBagConstraints();
		gbc_textApellido1.gridwidth = 4;
		gbc_textApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_textApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido1.gridx = 3;
		gbc_textApellido1.gridy = 5;
		contentPane.add(textApellido1, gbc_textApellido1);
		
		JLabel lblApellido1 = new JLabel("Primer Apellido*");
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblApellido1 = new GridBagConstraints();
		gbc_lblApellido1.gridwidth = 2;
		gbc_lblApellido1.anchor = GridBagConstraints.WEST;
		gbc_lblApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido1.gridx = 0;
		gbc_lblApellido1.gridy = 5;
		contentPane.add(lblApellido1, gbc_lblApellido1);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 4;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 3;
		gbc_textNombre.gridy = 4;
		contentPane.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		JPanel pUser = new JPanel();
		GridBagConstraints gbc_pUser = new GridBagConstraints();
		gbc_pUser.gridwidth = 2;
		gbc_pUser.insets = new Insets(0, 0, 5, 5);
		gbc_pUser.fill = GridBagConstraints.BOTH;
		gbc_pUser.gridx = 5;
		gbc_pUser.gridy = 1;
		contentPane.add(pUser, gbc_pUser);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		pUser.add(lblUsuario);
		
		JLabel lblnUser = new JLabel("user");
		pUser.add(lblnUser);
		
		JLabel lblTitulo = new JLabel("DATOS DEL CLIENTE");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.gridx = 1;
		gbc_lblTitulo.gridy = 1;
		contentPane.add(lblTitulo, gbc_lblTitulo);
	}

}
