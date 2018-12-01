package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionDatabase.ConexionLogin;
import ConexionDatabase.ConexionSign_In;
import model.Encrypt;
import model.Usuarios;
import utils.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.Color;

import java.awt.Component;

import javax.swing.border.MatteBorder;


public class FrmSign_In extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4684207075054385919L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUser;
	private JLabel lblContrasea;
	private JPasswordField txtPassword;
	private JButton btnIngresar;

	private int login;
	public final static int SIGNIN = 0;
	public final static int NOTSIGNIN = 1;
	private JLabel lblNewLabel;
	private JButton btnClose;
	private JLabel label;
	private JLabel label_1;
	ConexionSign_In SignIn=new ConexionSign_In();
	
	
	
	
	public static String users="";
	public static boolean configuracion;
	public static boolean actualizacion;
	public static boolean consulta;
	public static String usuarioIngre="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSign_In frame = new FrmSign_In();
					frame.setLocationRelativeTo(frame);
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
	public FrmSign_In() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 431);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblUsuario.setBounds(585, 196, 130, 14);
		contentPane.add(lblUsuario);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("");
		txtUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 140, 0)));
		
		
		txtUser.setMargin(new Insets(2, 5, 2, 2));
		txtUser.setFont(new Font("Consolas", Font.BOLD, 16));
		txtUser.setBounds(535, 221, 200, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblContrasea.setBounds(569, 252, 160, 33);
		contentPane.add(lblContrasea);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 140, 0)));
		txtPassword.setMargin(new Insets(2, 5, 2, 2));
		txtPassword.setFont(new Font("Consolas", Font.BOLD, 16));
		txtPassword.setBounds(535, 296, 200, 26);
		contentPane.add(txtPassword);
		
		
		btnIngresar = new JButton("Ingresar");
		
		btnIngresar.setBackground(new Color(255, 255, 255));
		btnIngresar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnIngresar.setFocusPainted(false);
		btnIngresar.setFocusTraversalKeysEnabled(false);

		

		//btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		btnIngresar.setIcon(new ImageIcon(FrmSign_In.class.getResource("/imagen/ok.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(574, 353, 130, 33);
		contentPane.add(btnIngresar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmSign_In.class.getResource("/imagen/user.png")));
		lblNewLabel.setBounds(555, 30, 150, 160);
		contentPane.add(lblNewLabel);
		
		btnClose = new JButton("");
		btnClose.setFocusable(false);
		btnClose.setFocusTraversalKeysEnabled(false);
		btnClose.setFocusPainted(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setAlignmentY(Component.TOP_ALIGNMENT);
		btnClose.addActionListener(this);
		btnClose.setBorder(null);
		btnClose.setBackground(Color.WHITE);
		btnClose.setIcon(new ImageIcon(FrmSign_In.class.getResource("/imagen/cerrar.png")));
		btnClose.setBounds(795, 11, 34, 33);
		contentPane.add(btnClose);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmSign_In.class.getResource("/imagen/fo.PNG")));
		label.setBounds(0, 0, 430, 430);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(760, 264, 46, 14);
		contentPane.add(label_1);
		
		
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnClose) {
			actionPerformedBtnClose(arg0);
		}
		
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		//users=leerUser();
		
		Usuarios xu=new Usuarios(leerUser(), leerPwd());
		//SignIn.Sign_In(leerUser(), leerPwd())
		if(SignIn.Sign_in(xu)) {
			
			this.dispose();
			System.out.println("ingresando al sistema");
			
			JOptionPane.showMessageDialog(null, "Acceso permitido :\n"+leerUser());
			
			FrmPrincipal prin= new FrmPrincipal();
			prin.setLocationRelativeTo(prin);
			prin.setVisible(true);
			
			
			
		}
		else{
			System.out.println("erro de ingreso");
			JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
			        + "Por favor ingrese un usuario y/o contrase�a correctos", "Acceso denegado",
			        JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	void enableButon(boolean yes){
		if(login==SIGNIN){
			btnIngresar.setEnabled(!yes);
		}
		if (login==NOTSIGNIN) {
			btnIngresar.setEnabled(yes);
		}
	}
	String leerUser() {
		return txtUser.getText();
	}
	String leerPwd(){
		String pwd = new String(txtPassword.getPassword());
		return pwd;
	}
	
	protected void actionPerformedBtnClose(ActionEvent arg0) {
		System.exit(0);
	}
	public boolean Sign_in(Usuarios usr) {
		Connection con= null;
		CallableStatement sp= null;
		ResultSet rs= null;
		
		boolean xd=false;
		
		try {
			con=new Conexion().getConexion();
			String S_P="{ call verificar_user(?,?) }";
			sp=con.prepareCall(S_P);
			sp.setString(1, usr.getUsuario());
			sp.setString(2,usr.getPassword());
			rs=sp.executeQuery();
			while(rs.next()){
				usuarioIngre=rs.getString(2);
				configuracion=rs.getBoolean(10);
				actualizacion=rs.getBoolean(11);
				consulta=rs.getBoolean(12);
				return xd=true;
				
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage()+e1.getSQLState()+e1.getErrorCode()+e1.getLocalizedMessage());
			}
			System.out.println(e.getMessage()+e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			JOptionPane.showMessageDialog(null, "Usuario y /o Contrase�a incorrecto !", "Error de Inicio de Sesi�n!", 0);
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+e.getSQLState()+e.getErrorCode()+e.getLocalizedMessage());
			}
		}
		
		return xd;
	}
	

}