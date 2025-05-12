package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
import clases.Productos;

import util.Conexion;

public class CategoriasDAO {

	List<Productos> lista = new ArrayList<>();
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	
	//insertar
	
	
	public static void insertar(Categoria categoria ) {
		String sql = "INSERT INTO categoria (nombre)  "
				+ "VALUES (?)";

		try {

			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, categoria.getNombreCategoria());
			

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Error:");
			}

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				categoria.setIdCategoria(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}

	}
	
		
	//mostrar 
	public static List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<>();
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement("SELECT idCategoria, nombreCategoria FROM categoria");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				lista.add(new Categoria(rs.getInt("idCategoria"), rs.getString("nombreCategoria")));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return lista;
	}

}