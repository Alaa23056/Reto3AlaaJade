package main;

import java.util.Scanner;

import util.Funciones;

public class Tienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		do {

			System.out.println("1-Mantenimientos: se mostrará el siguiente submenú: ");

			System.out.println("2-Catálogo de productos: se mostrará el siguiente submenú: ");

			System.out.println("3- Pedidos: se mostrará el siguiente submenú: ");

			System.out.println("4-  Informes: se mostrará el siguiente submenú : ");
			System.out.println("0-  salir ");

			opcion = Funciones.dimeEntero("Introduce la opcion que quieras: ", sc);

			switch (opcion) {
			case 1:
				submenu1(sc);
				break;
			case 2:

				break;

			case 3:

				break;
			case 4:

				break;

			case 5:
				System.out.println("salir");
				break;

			}
		} while (opcion > 5);

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

				break;
			case 2:

				break;

			case 3:
				subsubmenu1(sc);
				break;
			case 4:

				break;

			case 5:
				System.out.println("salir");
				break;

			}
		} while (opcion > 4);

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
