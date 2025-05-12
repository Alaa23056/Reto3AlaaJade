package clases;

public class PedidoProducto {

	/*
	 * idpedidoproducto int(11) PK idpedido int(11) idproducto int(11) unidades
	 * int(11) precio decimal(10,2)
	 */

	private Pedidos idPedido;
	private int idPedidoProducto;// albaran
    private int idProducto;
	private int unidades;
	private double precioProducto;
	public PedidoProducto(Pedidos idPedido, int idPedidoProducto, int idProducto, int unidades, double precioProducto) {
		super();
		this.idPedido = idPedido;
		this.idPedidoProducto = idPedidoProducto;
		this.idProducto = idProducto;
		this.unidades = unidades;
		this.precioProducto = precioProducto;
	}
	public PedidoProducto() {
		super();
	}
	public Pedidos getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Pedidos idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdPedidoProducto() {
		return idPedidoProducto;
	}
	public void setIdPedidoProducto(int idPedidoProducto) {
		this.idPedidoProducto = idPedidoProducto;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	@Override
	public String toString() {
		return "PedidoProducto [idPedido=" + idPedido + ", idPedidoProducto=" + idPedidoProducto + ", idProducto="
				+ idProducto + ", unidades=" + unidades + ", precioProducto=" + precioProducto + "]";
	}
	
	
	
	
}
