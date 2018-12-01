package ConexionDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Usuarios;
import utils.Conexion;

public class ConexionSign_In extends Conexion {

	
	
	
	
	public static boolean configuracion;
	public static boolean actualizacion;
	public static boolean consulta;
	public static String usuarioIngre="";
	
	
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
			JOptionPane.showMessageDialog(null, "Usuario y /o Contraseña incorrecto !", "Error de Inicio de Sesión!", 0);
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



