package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Clientes;
import util.Conexion;

public class ClientesDAO {
	
	public static Clientes actualizar(Clientes cliente) {
		// (int idcliente, String nombre, String direccion, int codigo)
		String sql = "update clientes \r\n" + "set nombre = ?, direccion = ?,codigo =?\r\n" + "where idcliente =?";

		try {

			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getDireccion());
			pst.setInt(3, cliente.getCodigo());
			pst.setInt(4, cliente.getIdcliente());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Error: No se pudo actualizar cliente.");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return cliente;
	}
	

	

	public static Clientes buscarPorCodigo( int codigo) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = Conexion.abreConexion();
			if (con != null) {

				pst = con.prepareStatement(

						"SELECT idcliente, nombre, direccion,codigo FROM clientes where  codigo=?");
				pst.setInt(1, codigo);

				rs = pst.executeQuery();

				while (rs.next()) {

					int idCliente = rs.getInt("idcliente");

					String nombre = rs.getString("nombre");
					String direccion = rs.getString("direccion");
					int codigoCliente = rs.getInt("codigo");

					Clientes cliente = new Clientes(idCliente, nombre, direccion, codigoCliente);
					return cliente;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				Conexion.cierraConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	return null;
	}

	public static Clientes inserta(Clientes cliente) {
		// (int idcliente, String nombre, String direccion, int codigo)
		String sql = "INSERT INTO cliente (nombre,direccion,codigo) " + "VALUES ( ?, ?, ?)";

		try {

			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, cliente.getNombre()); // Asumiendo que Albaran tiene un método getIdMecanico()
			pst.setString(2, cliente.getDireccion());

			pst.setInt(3, cliente.getCodigo());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Error: No se pudo insertar el partido.");
			}

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				cliente.setIdcliente(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return cliente;
	}

	public static List<Clientes> listaClientes() {
		List<Clientes> listaClientes = new ArrayList<Clientes>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = Conexion.abreConexion();
			if (con != null) {

				pst = con.prepareStatement(

						"SELECT idcliente, nombre, direccion,codigo FROM cliente");
				rs = pst.executeQuery();
				// (int idcliente, String nombre, String direccion, int codigo)
				while (rs.next()) {

					int idCliente = rs.getInt("idcliente");

					String nombre = rs.getString("nombre");
					String direccion = rs.getString("direccion");
					int codigoCliente = rs.getInt("codigo");

					Clientes cliente = new Clientes(idCliente, nombre, direccion, codigoCliente);
					listaClientes.add(cliente);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				Conexion.cierraConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaClientes;
	}
}
