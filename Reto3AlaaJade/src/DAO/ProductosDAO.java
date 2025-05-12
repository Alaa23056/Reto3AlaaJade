import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;
import clases.Productos;

public class ProductosDAO {

    public static List<Productos> listar() 
    {
        List<Productos> lista = new ArrayList<Productos>();
        Connection con =null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = Conexion.abreConexion();
            pst = con.prepareStatement("SELECT idproducto, idcategoria, nombre, precio, descripcion, color, talla, stock FROM productos");
            rs = pst.executeQuery();

            while (rs.next()) 
            
            {
                Productos p = new Productos(
                		
                		//creo objeto asignaturaanio y lo añado a la lista
                    rs.getInt("idproducto"),
                    rs.getInt("idcategoria"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getString("descripcion"),
                    rs.getString("color"),
                    rs.getString("talla"),
                    rs.getInt("stock")
                );
                lista.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                Conexion.cierraConexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}