package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static String url1 ="jdbc:mysql://localhost:3307/tienda";
	private static String user="root";
	private static String password="izquierdo1";
	private static Connection con;
	public static Connection abreConexion() {
	try {
		con = DriverManager.getConnection(url1, user, password);
		return con;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
		

	}
	public static void cierraConexion() {
		try {
			if(con!=null && 
					!con.isClosed())
			con.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
