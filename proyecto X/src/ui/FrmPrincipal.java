package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionDatabase.ConexionSign_In;
import model.Usuarios;
import utils.Conexion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.peer.FramePeer;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;

public class FrmPrincipal extends JFrame implements ActionListener {

	

	private JPanel box;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnConfiguracn;
	private JMenu mnActualizacin;
	private JMenu mnRegistro;
	private JMenuItem mntmProductos;
	private JMenu mnVenta;
	private JMenuItem mntmProductos_1;
	private JMenu mnConsultas;
	private JMenuItem mntmClientes;
	private JMenuItem mntmNewMenuItem_1;
	private  JDesktopPane conte;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmCliente;
	private JMenuItem mntmSalir;
	private JMenuItem mntmMesa;
	private JMenuItem mntmConfigurarCuentas;
	private JMenu mnGenerarComprobante;
	private JMenuItem mntmBoleta;
	
	
	private JMenuItem menuItem;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	
	public FrmPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/folder.png")));
		menuBar.add(mnArchivo);
		
		mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mntmCerrarSesion.addActionListener(this);
		mntmCerrarSesion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/logout.png")));
		mnArchivo.add(mntmCerrarSesion);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/cerrar.png")));
		mnArchivo.add(mntmSalir);
		
		mnActualizacin = new JMenu("Actualizaci\u00F3n");
		mnActualizacin.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/synchronize.png")));
		menuBar.add(mnActualizacin);
		
		mntmProductos = new JMenuItem("Productos");
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/shop.png")));
		mntmProductos.addActionListener(this);
		
		mntmMesa = new JMenuItem("Mesa");
		mntmMesa.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/mesa.png")));
		mntmMesa.addActionListener(this);
		mnActualizacin.add(mntmMesa);
		mnActualizacin.add(mntmProductos);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/list.png")));
		mnRegistro.addActionListener(this);
		menuBar.add(mnRegistro);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/addUser.png")));
		mntmCliente.addActionListener(this);
		mnRegistro.add(mntmCliente);
		
		mnVenta = new JMenu("Venta");
		mnVenta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/shop.png")));
		menuBar.add(mnVenta);
		
		mntmProductos_1 = new JMenuItem("Productos");
		mntmProductos_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/engineering.png")));
		mntmProductos_1.addActionListener(this);
		mnVenta.add(mntmProductos_1);
		
		mnConfiguracn = new JMenu("Configurac\u00F3n");
		mnConfiguracn.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/settings.png")));
		menuBar.add(mnConfiguracn);
		
		mntmConfigurarCuentas = new JMenuItem("Configurar Cuentas");
		mntmConfigurarCuentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/support.png")));
		mntmConfigurarCuentas.addActionListener(this);
		mnConfiguracn.add(mntmConfigurarCuentas);
		
		mnConsultas = new JMenu("Consultas");
		mnConsultas.setHorizontalAlignment(SwingConstants.LEFT);
		mnConsultas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/questions.png")));
		menuBar.add(mnConsultas);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/manager.png")));
		mntmClientes.addActionListener(this);
		mnConsultas.add(mntmClientes);
		
		mntmNewMenuItem_1 = new JMenuItem("Facturas");
		mntmNewMenuItem_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/boleta o factura.png")));
		mnConsultas.add(mntmNewMenuItem_1);
		
		mnGenerarComprobante = new JMenu("Generar Comprobante");
		menuBar.add(mnGenerarComprobante);
		
		mntmBoleta = new JMenuItem("Boleta");
		mntmBoleta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagen/boleta o factura.png")));
		mnGenerarComprobante.add(mntmBoleta);
	
		
		
		
	
		box = new JPanel();
		box.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(box);
		box.setLayout(null);
		
		conte = new JDesktopPane();
		conte.setEnabled(false);
		conte.setBounds(0, 0, 864, 545);
		box.add(conte);
		
		ConexionSign_In x= new ConexionSign_In();
		System.out.println("USUARIO "+ FrmSign_In.users+ConexionSign_In.usuarioIngre ); 
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmConfigurarCuentas) {
			actionPerformedMntmConfigurarCuentas(e);
		}
		if (e.getSource() == mntmMesa) {
			actionPerformedMntmMesa(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmCerrarSesion) {
			actionPerformedMntmCerrarSesion(e);
		}
		if (e.getSource() == mntmCliente) {
			actionPerformedMntmCliente(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmProductos_1) {
			actionPerformedMntmProductos_1(e);
		}
		
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
	}
	
	protected void actionPerformedMntmProductos(ActionEvent e) {
		
		FrmProductos jdp =new FrmProductos();
		//conte.add(jdp);
		center(jdp);
	
	}
	
	protected void actionPerformedMntmProductos_1(ActionEvent e) {
		FrmVenta jdv= new FrmVenta();
		//conte.add(jdv);
		center(jdv);		
	}
	protected void actionPerformedMntmClientes(ActionEvent e) {
		JIFClientes clientes= new JIFClientes();
		
		center(clientes);	
		
	}
	protected void actionPerformedMntmCliente(ActionEvent e) {
		
		
		FrmRegistroClientes jrc= new FrmRegistroClientes();
		center(jrc);
	}
	void center(JInternalFrame f){
		
		Dimension size = conte.getSize();
		Dimension fSize=f.getSize();
		f.setLocation((size.width-fSize.width)/2,(size.height-fSize.height)/2);
		f.show();
		
		boolean countView=true;
		String nombre = f.getTitle();
		
		
		for (int i = 0; i < conte.getComponentCount(); i++) {
			if (f.getClass().isInstance(conte.getComponent(i))) {
				JOptionPane.showMessageDialog(null,"Cierre la Ventana " +nombre +" e Intentente Nuevamente");
				f.toFront();
				conte.moveToFront(f);
				countView=false;
			}
	
		}
		if (countView && f != null) {
			conte.add(f);
		}
		f.show();
	}
	
	

	
	protected void actionPerformedMntmCerrarSesion(ActionEvent e) {
		this.dispose();
		FrmSign_In signin= new FrmSign_In();
		signin.setLocationRelativeTo(signin);
		signin.setVisible(true);
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmMesa(ActionEvent e) {
		FrmAgregarMesa mesa= new FrmAgregarMesa();
		center(mesa);
	}
	protected void actionPerformedMntmConfigurarCuentas(ActionEvent e) {
		FrmSign_Up signup = new FrmSign_Up();
		signup.setLocationRelativeTo(signup);
		signup.setVisible(true);
	}
}
