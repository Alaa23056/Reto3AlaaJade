package clases;

public class Pedidos {
	
	/*idpedido int(11) PK 
	idcliente int(11) 
	precioTotal decimal(10,2) 
	direccionEnvio varchar(300) 
	fecha date*/
	
	private int idpedido;
	private Clientes idcliente;
	private double precioTotal;
	private int codigo;
	public Pedidos(int idpedido, Clientes idcliente, double precioTotal, int codigo) {
		super();
		this.idpedido = idpedido;
		this.idcliente = idcliente;
		this.precioTotal = precioTotal;
		this.codigo = codigo;
	}
	public Pedidos() {
		super();
	}
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public Clientes getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Clientes idcliente) {
		this.idcliente = idcliente;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return "Pedidos [idpedido=" + idpedido + ", idcliente=" + idcliente + ", precioTotal=" + precioTotal
				+ ", codigo=" + codigo + "]";
	}
	
	
	

}
