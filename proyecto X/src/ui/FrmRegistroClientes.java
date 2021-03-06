package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ConexionDatabase.ConexionCliente;
import ConexionDatabase.ConexionMesa;
import model.Cliente;
import model.Mesa;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.awt.event.FocusEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class FrmRegistroClientes extends JInternalFrame implements ActionListener {
	private JLabel lblNCodigo;
	private JTextField txtCodigoCliente;
	private JLabel lblNombre;
	private JTextField txtNombreCliente;
	private JLabel lblDni;
	private JTextField txtDniCliente;
	private JLabel lblApellido;
	private JTextField txtApellidoCliente;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JButton btnBuscar;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private DefaultTableModel modelo;

	private int tipOperacion;
	
	public final static int ADICIONAR = 0;
	public final static int MODIFICAR = 1;
	public final static int ELIMINAR= 2;
	public final static int VOLVER=3;
	public final static int BUSCAR=4;
	public final static int ACEPTAR=5;

	private JScrollPane scrollPane;
	private JTable tblClientes;
	private JButton btnCerrar;
	
	ConexionCliente conCli= new ConexionCliente();
	ConexionMesa conMesa= new ConexionMesa();
	
	private JLabel label;
	private JTextField txtNumeroDeSillas;
	private JComboBox cboEstado;
	private JComboBox cboNumMesa;
	private JLabel lblEstado;
	public static int codCli;
	private JLabel lblSillas;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroClientes frame = new FrmRegistroClientes();
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
	public FrmRegistroClientes() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Registro de Clientes");
		setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		setBounds(100, 100, 860, 539);
		getContentPane().setLayout(null);
		
		lblNCodigo = new JLabel("N\u00B0 Codigo:");
		lblNCodigo.setBounds(26, 24, 68, 14);
		getContentPane().add(lblNCodigo);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setEnabled(false);
		txtCodigoCliente.setBounds(99, 21, 100, 20);
		getContentPane().add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setText("C"+"0"+generadorCodigo()+2);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 60, 68, 14);
		getContentPane().add(lblNombre);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setEnabled(false);
		txtNombreCliente.setBounds(99, 57, 297, 20);
		getContentPane().add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(225, 24, 46, 14);
		getContentPane().add(lblDni);
		
		txtDniCliente = new JTextField();
		txtDniCliente.setEnabled(false);
		txtDniCliente.setBounds(271, 21, 125, 20);
		getContentPane().add(txtDniCliente);
		txtDniCliente.setColumns(10);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(26, 98, 46, 14);
		getContentPane().add(lblApellido);
		
		txtApellidoCliente = new JTextField();
		txtApellidoCliente.setEnabled(false);
		txtApellidoCliente.setBounds(99, 95, 297, 20);
		getContentPane().add(txtApellidoCliente);
		txtApellidoCliente.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(26, 136, 46, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(99, 133, 110, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setFocusable(false);
		btnBuscar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnBuscar.addActionListener(this);
		btnBuscar.setVisible(false);
		btnBuscar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/search.png")));
		btnBuscar.setBounds(482, 15, 116, 33);
		getContentPane().add(btnBuscar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setFocusable(false);
		btnAceptar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnAceptar.addActionListener(this);
		btnAceptar.setVisible(false);
		btnAceptar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/ok.png")));
		btnAceptar.setBounds(608, 60, 116, 33);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setFocusable(false);
		btnVolver.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnVolver.setVisible(false);
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/previous.png")));
		btnVolver.setBounds(608, 103, 116, 33);
		getContentPane().add(btnVolver);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setFocusable(false);
		btnAdicionar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/plus.png")));
		btnAdicionar.setBounds(608, 15, 116, 33);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setFocusable(false);
		btnModificar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/engineering.png")));
		btnModificar.setBounds(734, 15, 116, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setFocusable(false);
		btnEliminar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/delete_database.png")));
		btnEliminar.setBounds(734, 60, 116, 33);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(26, 190, 802, 311);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		tblClientes.setFillsViewportHeight(true);
		tblClientes.setGridColor(new Color(30, 144, 255));
		tblClientes.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(tblClientes);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(Color.WHITE);
		btnCerrar.setFocusable(false);
		btnCerrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(205, 133, 63)));
		btnCerrar.setIcon(new ImageIcon(FrmRegistroClientes.class.getResource("/imagen/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(734, 103, 116, 33);
		getContentPane().add(btnCerrar);
		
		label = new JLabel("Mesa");
		label.setBounds(225, 136, 46, 14);
		getContentPane().add(label);
		
		txtNumeroDeSillas = new JTextField();
		txtNumeroDeSillas.setEditable(false);
		txtNumeroDeSillas.setColumns(10);
		txtNumeroDeSillas.setBounds(366, 133, 37, 20);
		getContentPane().add(txtNumeroDeSillas);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		
		cboEstado.setBounds(482, 133, 91, 20);
		getContentPane().add(cboEstado);
		
		cboNumMesa = new JComboBox();
		cboNumMesa.setEnabled(false);
		
		cboNumMesa.setBounds(256, 133, 57, 20);
		getContentPane().add(cboNumMesa);
		cboNumMesa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//conMesa.numero_de_Mesa(txtNumeroDeSillas, cboNumMesa.getSelectedIndex());
				try {
					Mesa x=new Mesa(mesa());
					conMesa.xSilla(x, txtNumeroDeSillas);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
			}
		});
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(432, 136, 46, 14);
		getContentPane().add(lblEstado);
		
		lblSillas = new JLabel("Sillas:");
		lblSillas.setBounds(333, 136, 46, 14);
		getContentPane().add(lblSillas);

		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		tipOperacion=VOLVER;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	void habilitarBoton(Boolean not){
		if(tipOperacion==ADICIONAR){
			btnAceptar.setVisible(!not);	
			btnAdicionar.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnVolver.setVisible(!not);
			btnCerrar.setEnabled(not);
		}
		if(tipOperacion==VOLVER){
			btnAceptar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
			btnAdicionar.setEnabled(not);
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnCerrar.setEnabled(not);
			
		}if(tipOperacion==MODIFICAR){
			btnModificar.setEnabled(not);
			btnEliminar.setEnabled(not);
			btnAdicionar.setEnabled(not);
			btnAceptar.setVisible(!not);
			btnVolver.setVisible(!not);
			btnBuscar.setVisible(!not);
			btnCerrar.setEnabled(not);
		}if(tipOperacion==ELIMINAR){
			btnEliminar.setEnabled(!not);
			btnModificar.setEnabled(!not);
			btnAdicionar.setEnabled(!not);
			btnVolver.setVisible(not);
			btnBuscar.setVisible(not);
			btnAceptar.setVisible(not);
			btnCerrar.setEnabled(!not);
		}
	}
	void habilitarEntrada(Boolean not){
		if(tipOperacion==ADICIONAR){
			txtNombreCliente.setEnabled(!not);
			txtApellidoCliente.setEnabled(!not);
			txtDniCliente.requestFocus();
			txtDniCliente.setEnabled(!not);
			txtTelefono.setEnabled(!not);
			cboEstado.setEnabled(!not);
			cboNumMesa.setEnabled(!not);
			listar();
			txtCodigoCliente.setEnabled(!not);
			
		}
		if(tipOperacion==MODIFICAR){
			txtNombreCliente.setEnabled(!not);
			txtApellidoCliente.setEnabled(!not);
			txtCodigoCliente.setEnabled(!not);
			txtDniCliente.setEnabled(!not);
			txtDniCliente.requestFocus();
			txtTelefono.setEnabled(!not);
		}
		if(tipOperacion==VOLVER){
			txtNombreCliente.setEnabled(!not);
			txtApellidoCliente.setEnabled(!not);
			txtCodigoCliente.setEnabled(!not);
			txtDniCliente.setEnabled(!not);
			txtTelefono.setEnabled(!not);
			limpiar();
		}
		if(tipOperacion==ELIMINAR){
			txtDniCliente.setEnabled(!not);
			txtNombreCliente.setEnabled(!not);
			txtApellidoCliente.setEnabled(!not);
			txtCodigoCliente.setEnabled(!not);
			txtTelefono.setEnabled(!not);
			txtCodigoCliente.requestFocus();
			cboEstado.setEnabled(!not);
			cboNumMesa.setEnabled(!not);
			txtCodigoCliente.setEnabled(not);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipOperacion=ADICIONAR;
		habilitarBoton(false);
		habilitarEntrada(false);
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		tipOperacion=MODIFICAR;
		habilitarBoton(false);
		habilitarEntrada(false);
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipOperacion=ELIMINAR;
		habilitarBoton(true);
		habilitarEntrada(true);
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch (tipOperacion){
		case ADICIONAR:
			agregarCliente();
			break;
		case MODIFICAR:
			modificarCliente();
			break;
		case ELIMINAR:
			eliminarCliente();
		}
		/*Cliente newCli= new Cliente(0,codigo(), dni(), nombre(), apellido(), telefono());
		int valor=conCli.addCliente(newCli);
		if(valor==1){
			System.out.println("Cliente Registrado");
		}else{
			System.out.println("no esta registrado");
		}*/
		
	}
	String codigo(){return txtCodigoCliente.getText();}
	int dni(){return Integer.parseInt(txtDniCliente.getText());}
	String nombre(){return txtNombreCliente.getText();}
	String apellido(){return txtApellidoCliente.getText();}
	int telefono(){return Integer.parseInt(txtTelefono.getText());}
	int mesa(){
		String n = cboNumMesa.getSelectedItem().toString().trim();
		return Integer.parseInt(n);}
	int estado(){
		return cboEstado.getSelectedIndex();
	}
	void limpiar(){
		txtDniCliente.setText(null);
		txtNombreCliente.setText(null);
		txtApellidoCliente.setText(null);
		txtTelefono.setText(null);
		txtDniCliente.requestFocus();
	}
	void agregarCliente(){
		System.out.println("Agregando Cliente");
		try {
			int dni=dni();
			String d=txtDniCliente.getText();
			if (d.length()==0||d.length()<8){
				error("Ingrese Correctamente el DNI.", txtDniCliente);
			}else{
				String n=nombre();
				if (n.length()<4) {
					error("Ingrese como minimo 3 carateres ", txtNombreCliente);
				}else{
					String s=apellido();
					if (s.length()<4) {
						error("ingrese como minimo 4 caracteres", txtApellidoCliente);
					}else{
						try {
							int t=telefono();
							String f=txtTelefono.getText();
							if (f.length()<9||f.length()>9) {
								mensaje("Ingrese correctamente el numero de telefono");
							}else{
								Cliente xCli = new Cliente(codigo(), dni(), nombre(), apellido(), telefono(), mesa(),estado());								
								conCli.add_cliente(xCli);
								listar();
								limpiar();
							}
						} catch (NumberFormatException e) {
							// TODO: handle exception
							error("ingrese Correctamente los datos requeridos", txtTelefono);
						}
						
					}
					
				}
				
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			error("Ingrese un numero de DNI valido !!", txtDniCliente);
		}
		
		
	}
	void listar(){
		conCli.Listar(tblClientes);
		conMesa.numeroMesa(cboNumMesa);
		conMesa.EstadoMesa(cboEstado);
	}
	void modificarCliente(){
		System.out.println("modificar cliente");
		try {
			int dni=dni();
			String d=txtDniCliente.getText();
			if (d.length()==0||d.length()<8){
				error("Ingrese Correctamente el DNI.", txtDniCliente);
			}else{
				String n=nombre();
				if (n.length()<4) {
					error("Ingrese como minimo 3 carateres ", txtNombreCliente);
				}else{
					String s=apellido();
					if (s.length()<4) {
						error("ingrese como minimo 4 caracteres", txtApellidoCliente);
					}else{
						try {
							int t=telefono();
							String f=txtTelefono.getText();
							if (f.length()<9||f.length()>9) {
								mensaje("Ingrese correctamente el numero de telefono");
							}else{
								Cliente nCli = new Cliente(codigo(), dni(), nombre(), apellido(), telefono(), mesa(),estado());								
								conCli.update_cliente(nCli);
								listar();
								limpiar();
							}
						} catch (NumberFormatException e) {
							// TODO: handle exception
							error("ingrese Correctamente los datos requeridos", txtTelefono);
						}
						
					}
					
				}
				
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			error("Ingrese un numero de DNI valido !!", txtDniCliente);
		}
	}
	void eliminarCliente(){
		System.out.println("eliminar cliente");
		Cliente x= new Cliente(codigo());
		if(conCli.delete_cliente(x)){
			System.out.println("Eliminado correcto.......");
		}else{
			System.out.println("CODIGO NO EXISTE");
		}
		
		listar();
	}
	int generadorCodigo(){
		if(codCli==0){
			return 0001;
		}else{
			return codCli++;
		}
	}
	void error(String s,JTextField txt){mensaje(s);txt.setText("");txt.requestFocus();}
	void mensaje(String s) {JOptionPane.showMessageDialog(this, s,"Error de Formato",0);}
}
