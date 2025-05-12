package clases;

public class Clientes {

	/*
	 * CREATE TABLE clientes (
	 * 
	 * idcliente INT PRIMARY KEY, nombre NVARCHAR(100) NOT NULL, direccion
	 * NVARCHAR(300) NOT NULL, codigo INT NOT NULL );
	 */

	private int idcliente;
	private String nombre;
	private String direccion;
	private int codigo;

	public Clientes(int idcliente, String nombre, String direccion, int codigo) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}

	public Clientes() {
		super();
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Clientes [idcliente=" + idcliente + ", nombre=" + nombre + ", direccion=" + direccion + ", codigo="
				+ codigo + "]";
	}

}
