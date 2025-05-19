package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categorias;
import clases.Productos;
import util.Conexion;

public class ProductosDAO {
	
	
	public static List<Productos> listarPorCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		List<Productos> lista = new ArrayList<Productos>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = Conexion.abreConexion();
			pst = con.prepareStatement(
					"SELECT idproducto, c.idcategoria ,c.nombre categoria , p.nombre nombreproducto, precio, descripcion, color, talla, stock FROM productos p\r\n"
							+ "inner join categorias c\r\n" + "on c.idcategoria =p.idcategoria where p.idcategoria =?");
			
			pst.setInt(1, idCategoria);
			rs = pst.executeQuery();

			while (rs.next())

			{
				Categorias categoria = new Categorias(rs.getInt("idcategoria"), rs.getString("categoria"));

				Productos producto = new Productos(
						/*
						 * (int idproducto, Categorias idcategoria, String nombre, double precio, String
						 * descripcion, String color, String talla, int stock
						 */

						rs.getInt("idproducto"), categoria, rs.getString("nombreproducto"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock"));
				lista.add(producto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				Conexion.cierraConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return lista;
		}
		

	public static void insertarProducto(Productos producto) {
		String sql = "insert into productos (idcategoria ,nombre,precio,descripcion,color,talla,stock)   "
				+ "VALUES (?,?,?,?,?,?,?)";

		try {

			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1, producto.getIdcategoria().getIdCategoria());
			pst.setString(2, producto.getNombre());
			pst.setDouble(3, producto.getPrecio());
			pst.setString(4, producto.getDescripcion());
			pst.setString(5, producto.getColor());
			pst.setString(6, producto.getTalla());
			pst.setInt(7, producto.getStock());
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Error:");
			}

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				producto.setIdproducto(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}

	}

	public static List<Productos> listar() {
		List<Productos> lista = new ArrayList<Productos>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = Conexion.abreConexion();
			pst = con.prepareStatement(
					"SELECT idproducto, c.idcategoria ,c.nombre categoria , p.nombre nombreproducto, precio, descripcion, color, talla, stock FROM productos p\r\n"
							+ "inner join categorias c\r\n" + "on c.idcategoria =p.idcategoria");
			rs = pst.executeQuery();

			while (rs.next())

			{
				Categorias categoria = new Categorias(rs.getInt("idcategoria"), rs.getString("categoria"));

				Productos producto = new Productos(
						/*
						 * (int idproducto, Categorias idcategoria, String nombre, double precio, String
						 * descripcion, String color, String talla, int stock
						 */

						rs.getInt("idproducto"), categoria, rs.getString("nombreproducto"), rs.getDouble("precio"),
						rs.getString("descripcion"), rs.getString("color"), rs.getString("talla"), rs.getInt("stock"));
				lista.add(producto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				Conexion.cierraConexion();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return lista;
	}
}