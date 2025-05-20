package main;

import java.util.List;
import java.util.Scanner;

import DAO.CategoriasDAO;
import DAO.ClientesDAO;
import DAO.ProductosDAO;
import clases.Categorias;
import clases.Clientes;
import clases.Productos;
import util.Funciones;

public class Tienda {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		do {

			System.out.println("1 - Mantenimientos: se mostrará el siguiente submenú: ");

			System.out.println("2 - Catálogo de productos: se mostrará el siguiente submenú: ");

			System.out.println("3 - Pedidos: se mostrará el siguiente submenú: ");

			System.out.println("4 - Informes: se mostrará el siguiente submenú : ");
			System.out.println("0 -  salir ");
			System.out.println("____________________________________________________________");
			opcion = Funciones.dimeEntero("Introduce la opcion que quieras: ", sc);

			switch (opcion) {
			case 1:

				submenu1(sc);
				break;
			case 2:
				submenu2(sc);
				break;

			case 3:
				submenu3(sc);
				break;
			case 4:

				break;

			case 5:
				System.out.println("salir");
				break;

			}
		} while (opcion > 5);

	}

	public static List<Productos> filtrarPorductos(Scanner sc) {

		ProductosDAO.listar();
		// int idproducto, Categorias idcategoria, String nombre, double precio, String
		// descripcion, String color,
		// String talla, int stock

		System.out.println("Introduce nombre producto");

		String nombre = sc.nextLine();
		System.out.println("Introduce color producto");
		String color = sc.nextLine();
		System.out.println("Introduce talla producto");
		String talla = sc.nextLine();
		Productos producto = new Productos(0, null, nombre, 0, "", color, talla, 0);

		producto.setNombre(nombre);
		producto.setColor(color);
		producto.setTalla(talla);

		List<Productos> listaFiltrada = ProductosDAO.buscarPorNombre(producto);

		for (Productos productos : listaFiltrada) {

			System.out.println(productos);

		}

		return listaFiltrada;
	}

	public static void listarProductosPorCategoria(Scanner sc) {
		List<Categorias> listaCategorias = CategoriasDAO.listarCategorias();
		int idCategoria = 0;

		while (true) {

			for (Categorias categorias : listaCategorias) {
				System.out.println(categorias);

			}

			idCategoria = Funciones.dimeEntero("Introduce el id de categoria que quieras ", sc);

			if (estaEnLalistaCategoria(listaCategorias, idCategoria)) {

				// IR AL PASO 4
				break;// salir del while
			} else { // IR ALK PASO 1 }

				System.out.println("El codigo es incorrecto, vuelve a ingresar categoria");
			}
		}

		// 4. con la categoria elegida muestro los productos

		List<Productos> listaProductos = ProductosDAO.listarPorCategoria(idCategoria);

		for (Productos productos : listaProductos) {

			System.out.println(productos);

		}

	}

	public static Boolean estaEnLalistaCategoria(List<Categorias> listaCategorias, int idCategoria) {

		Boolean siEsta = false;
		for (Categorias cate : listaCategorias) {

			if (cate.getIdCategoria() == idCategoria) {

				siEsta = true;
				break;
			}

		}
		return siEsta;
	}

	public static void buscarActualizarCliente(Scanner sc) {
		Clientes cliente = null;

		do {

			int codigoIntro = Funciones.dimeEntero("Introduce codigo del cliente", sc);
			cliente = ClientesDAO.buscarPorCodigo(codigoIntro);

			if (cliente == null) {
				System.out.println("No se ha podido encontrar");
			}

		} while (cliente == null);

		if (cliente != null) {
			System.out.println(cliente);
			String nombre = Funciones.dimeString("Introduce el nombre cliente", sc);
			String direccion = Funciones.dimeString("Introduce direccion", sc);
			int codigo = Funciones.dimeEntero("Introduce codigo cliente", sc);

			cliente.setNombre(nombre);
			cliente.setDireccion(direccion);
			cliente.setCodigo(codigo);

			ClientesDAO.actualizar(cliente);

			System.out.println(cliente.toString());

		}

	}

	public static void listarProductos() {

		List<Productos> listaProductos = ProductosDAO.listar();

		for (Productos productos : listaProductos) {
			System.out.println(productos);

		}
	}

	public static void gestionNuevoCliente(Scanner sc) {
		// (int idcliente, String nombre, String direccion, int codigo

		String nombre = Funciones.dimeString("Introduce nombre cliente", sc);
		String direccion = Funciones.dimeString("Introduce direccion", sc);
		int codigo = Funciones.dimeEntero("Introduce codigo", sc);

		Clientes clienteNuevo = new Clientes(0, nombre, direccion, codigo);

		ClientesDAO.inserta(clienteNuevo);

	}

	public static void mostrarCategoria() {

		List<Categorias> listaCategorias = CategoriasDAO.listarCategorias();

		for (Categorias categorias : listaCategorias) {

			System.out.println(categorias);

		}

	}

	public static void gestionDePorductos(Scanner sc) {

		/*
		 * (int idproducto, Categorias idcategoria, String nombre, double precio, String
		 * descripcion, String color, String talla, int stock
		 */

		String nombre = Funciones.dimeString("Introduce nombre producto", sc);
		double precio = Funciones.dimeDouble("Introduce precio", sc);
		String descripcion = Funciones.dimeString("Introduce descripcion", sc);
		String color = Funciones.dimeString("Introduce color", sc);
		String talla = Funciones.dimeString("Introduce talla producto", sc);
		int stock = Funciones.dimeEntero("Introduce stock", sc);

		mostrarCategoria();

		int codigoCategoria = Funciones.dimeEntero("Introduce codigo categoria", sc);
		Categorias categoria = new Categorias(codigoCategoria, "");

		Productos producto = new Productos(0, categoria, nombre, precio, descripcion, color, talla, stock);

		ProductosDAO.insertarProducto(producto);

	}

	public static void gestionCategorias(Scanner sc) {

		String nombreCategoria = Funciones.dimeString("Introduce categoria nueva: ", sc);
		Categorias categoria = new Categorias(0, nombreCategoria);
		CategoriasDAO.inserta(categoria);

	}

	public static void submenu3(Scanner sc) {

		int opcion = 0;
		do {

			System.out.println("1. Crear pedido:  ");

			System.out.println("2. Ver pedidos:");

			System.out.println("0-  salir ");

			opcion = Funciones.dimeEntero("Introduce la opcion que quieras: ", sc);

			switch (opcion) {
			case 1:

				break;
			case 2:

				break;

			case 0:

				break;

			case 5:
				System.out.println("salir");
				break;

			}
		} while (opcion > 4);

	}

	public static void submenu2(Scanner sc) {

		int opcion = 0;
		do {

			System.out.println("1. Listar productos por categoría: ");

			System.out.println("2. Buscar productos:");

			System.out.println("0-  salir ");

			opcion = Funciones.dimeEntero("Introduce la opcion que quieras: ", sc);

			switch (opcion) {
			case 1:
				listarProductos();
				break;
			case 2:
				filtrarPorductos(sc);
				break;

			case 0:

				break;

			case 5:
				System.out.println("salir");
				break;

			}
		} while (opcion > 4);

	}

	public static void submenu1(Scanner sc) {

		int opcion = 0;
		do {

			System.out.println("1. Gestión de categorías:");

			System.out.println("2. Gestión de productos");

			System.out.println("3. Gestión de clientes: ");

			System.out.println("0-  salir ");

			opcion = Funciones.dimeEntero("Introduce la opcion que quieras: ", sc);

			switch (opcion) {
			case 1:
				// gestion categoarias
				gestionCategorias(sc);
				break;
			case 2:

				// gestion de productos

				gestionDePorductos(sc);
				break;

			case 3:

				buscarActualizarCliente(sc);

				subsubmenu1(sc);
				break;
			case 4:

				break;

			case 0:
				System.out.println("salir");
				break;

			}
		} while (opcion != 0);

	}

	public static void subsubmenu1(Scanner sc) {

		int opcion = 0;
		do {

			System.out.println("1-  Alta de nuevos clientes:");

			System.out.println("2-  Búsqueda por código: ");

			System.out.println("0-  salir ");

			opcion = Funciones.dimeEntero("Introduce la opcion que quieras: ", sc);

			switch (opcion) {
			case 1:

				// alta de nuevos clientes

				break;
			case 2:

				break;

			case 3:

				break;

			case 5:
				System.out.println("salir");
				break;

			}
		} while (opcion > 3);

	}

}
