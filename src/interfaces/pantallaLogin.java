package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import Impl.LenguageLoader;
import config.ConfigurationLoader;
import model.VariablesLenguageEnum;

import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

public class pantallaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textPassword;
	private JButton btnEntrar;
	private boolean employeeVersion;
	private boolean isError = false;
	private Hashtable<VariablesLenguageEnum, String> idioma = LenguageLoader.getLenguageConfig().getIdioma();

	/**
	 * Create the frame.
	 */
	public pantallaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(pantallaLogin.class.getResource("/recursos/iconoEsteveTerradas.png")));
		setTitle("Concesionario ESTEVE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 210);
		setResizable(false);
		
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[] {30, 30, 30, 30};
		gbl_contentPane.columnWidths = new int[] {30, 30, 30, 30};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		btnEntrar = new JButton(idioma.get(VariablesLenguageEnum.login_btn_entrar));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compareLoginPassword();
			}
		});
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.weightx = 5.0;
		gbc_btnEntrar.fill = GridBagConstraints.BOTH;
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEntrar.gridx = 2;
		gbc_btnEntrar.gridy = 4;
		contentPane.add(btnEntrar, gbc_btnEntrar);
		
		textPassword = new JPasswordField();
		textPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					compareLoginPassword();
				}
			}
		});
		textPassword.setColumns(10);
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.weightx = 5.0;
		gbc_textPassword.insets = new Insets(0, 0, 5, 0);
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.gridx = 2;
		gbc_textPassword.gridy = 2;
		contentPane.add(textPassword, gbc_textPassword);
		
		JLabel lblPassword = new JLabel(idioma.get(VariablesLenguageEnum.login_lbl_password));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		textLogin = new JTextField();
		GridBagConstraints gbc_textLogin = new GridBagConstraints();
		gbc_textLogin.weightx = 5.0;
		gbc_textLogin.insets = new Insets(0, 0, 5, 0);
		gbc_textLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLogin.gridx = 2;
		gbc_textLogin.gridy = 1;
		contentPane.add(textLogin, gbc_textLogin);
		textLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel(idioma.get(VariablesLenguageEnum.login_lbl_user));
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.WEST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 1;
		contentPane.add(lblLogin, gbc_lblLogin);
	}
	
	public void compareLoginPassword() {
		String[] employees = ConfigurationLoader.getConfig().getEmployeeList();
		String [] passwords = ConfigurationLoader.getConfig().getEmployeePassword();
		boolean [] eVersions = ConfigurationLoader.getConfig().getEmployeeVersion();
		
		if(emptyTxt()) {
			for (int i = 0; i < employees.length; i++) {
				if(textLogin.getText().equals(employees[i]) && textPassword.getText().equals(passwords[i])) {
					isError = false;
					employeeVersion = eVersions[i];
					pantallaCliente pC = new pantallaCliente(employees[i]);
					pC.setVisible(true);
					this.dispose();
					break;
				}
				else {
					isError = true;
				}
			}
		}
		
		if(isError) {
			pantallaLogin frame = new pantallaLogin();
			JOptionPane.showMessageDialog(frame,
				    "Incorrect username or password.",
				    "Login error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean emptyTxt() {
		if(textLogin.getText().isEmpty() || textPassword.getText().isEmpty()) {
			pantallaLogin frame = new pantallaLogin();
			JOptionPane.showMessageDialog(frame,
				    "Los campos con * son obligatorios.",
				    "Empty Error",
				    JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		return true;
	}

	public boolean isEmployeeVersion() {
		return employeeVersion;
	}
	
	
}
