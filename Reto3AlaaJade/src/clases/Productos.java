package clases;

public class Productos {
	/*
	 * idproducto int(11) PK idcategoria int(11) nombre varchar(100) precio
	 * decimal(10,2) descripcion text color varchar(50) talla varchar(10) stock
	 * int(11)
	 */

	private int idproducto;
	private Categoria idcategoria;
	private String nombre;
	private double precio;
	private String descripcion;
	private String color;

	private String talla;
	private int stock;

	public Productos(int idproducto, Categoria idcategoria, String nombre, double precio, String descripcion, String color,
			String talla, int stock) {
		super();
		this.idproducto = idproducto;
		this.idcategoria = idcategoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	public Productos() {
		super();
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Productos [idproducto=" + idproducto + ", idcategoria=" + idcategoria + ", nombre=" + nombre
				+ ", precio=" + precio + ", descripcion=" + descripcion + ", color=" + color + ", talla=" + talla
				+ ", stock=" + stock + "]";
	}

}
