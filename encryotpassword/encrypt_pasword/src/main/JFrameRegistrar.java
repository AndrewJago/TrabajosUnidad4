package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import dao.Conectar;
import entities.Account;
import entities.CryptPassword;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Window.Type;

public class JFrameRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtNomCompleto;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameRegistrar frame = new JFrameRegistrar();
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
	public JFrameRegistrar() {
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Cuenta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 35, 414, 215);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		panel.add(lblNewLabel, "2, 2");
		
		txtUsuario = new JTextField();
		panel.add(txtUsuario, "6, 2, fill, default");
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		panel.add(lblNewLabel_1, "2, 6");
		
		txtPassword = new JTextField();
		txtPassword.setText("");
		panel.add(txtPassword, "6, 6, fill, default");
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Completo");
		panel.add(lblNewLabel_2, "2, 8");
		
		txtNomCompleto = new JTextField();
		panel.add(txtNomCompleto, "6, 8, fill, default");
		txtNomCompleto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Correo");
		panel.add(lblNewLabel_3, "2, 10");
		
		txtCorreo = new JTextField();
		panel.add(txtCorreo, "6, 10, fill, default");
		txtCorreo.setColumns(10);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
									
					Account account = new Account();
					Conectar conexion = new  Conectar();
					
					account.setCorreo(txtCorreo.getText());
					account.setNomCompleto(txtNomCompleto.getText());
					account.setPassword(CryptPassword.cryptWithMD5(txtPassword.getText()));
					account.setUsuario(txtUsuario.getText());
					
					try {
						conexion.obtenCampos(account);
					} catch (SQLException e) {
						e.printStackTrace();
					}

			}
		});
		panel.add(btnSave, "6, 14");
	}
}
