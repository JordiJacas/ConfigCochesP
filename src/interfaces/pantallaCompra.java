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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class pantallaCompra extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaCompra frame = new pantallaCompra();
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
	public pantallaCompra() {
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
			}
		});
		
		JButton btnSigiente = new JButton("Sigiente");
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
		gbc_btnAnterior.anchor = GridBagConstraints.WEST;
		gbc_btnAnterior.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnterior.gridx = 1;
		gbc_btnAnterior.gridy = 7;
		contentPane.add(btnAnterior, gbc_btnAnterior);
		
		JTextArea areaMostrar = new JTextArea();
		GridBagConstraints gbc_areaMostrar = new GridBagConstraints();
		gbc_areaMostrar.gridheight = 4;
		gbc_areaMostrar.gridwidth = 4;
		gbc_areaMostrar.insets = new Insets(0, 50, 5, 50);
		gbc_areaMostrar.fill = GridBagConstraints.BOTH;
		gbc_areaMostrar.gridx = 1;
		gbc_areaMostrar.gridy = 1;
		contentPane.add(areaMostrar, gbc_areaMostrar);
		
		JTextArea areaDescripcion = new JTextArea();
		GridBagConstraints gbc_areaDescripcion = new GridBagConstraints();
		gbc_areaDescripcion.gridwidth = 2;
		gbc_areaDescripcion.gridheight = 2;
		gbc_areaDescripcion.insets = new Insets(10, 50, 5, 50);
		gbc_areaDescripcion.fill = GridBagConstraints.BOTH;
		gbc_areaDescripcion.gridx = 3;
		gbc_areaDescripcion.gridy = 5;
		contentPane.add(areaDescripcion, gbc_areaDescripcion);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,1,0,10));
		
        for (int i = 0; i < 7; i++) {
        	JButton[] arraybtn = new JButton[7];
        	arraybtn[i] = new JButton("Hello-" + i);
        	arraybtn[i].setPreferredSize(new Dimension(30, 50));
        	panel.add(arraybtn[i]);
        }
        
		JScrollPane scrollBar = new JScrollPane(panel);
        scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
	
	}

}
