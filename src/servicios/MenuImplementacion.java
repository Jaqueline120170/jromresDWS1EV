package servicios;

import java.io.IOException;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz {
	OperativaInterfaz oi = new OperativaImplementacion();


	public int menuPrincipal() {
		util.GestorFicheros.sobreEscribir(Inicio.fechaYhora + "Acceso menu principal");
	
		int opcionPrincipal;
		System.out.println("ACCESO APLICACION");
		System.out.println("------------------");
		System.out.println("0. Cerrar Menu");
		System.out.println("1. Acceder como Empleado");
		System.out.println("2. Acceder como Gerente");
		System.out.println("Seleccione una opcion");
		opcionPrincipal= Inicio.sc. nextInt();
		return opcionPrincipal;
	
	}
public void seleccionMenuEmpleado()throws IOException {
		
		int opcion =menuEmpleado();
		switch(opcion) {
		case 0 :
			util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "0  Acceso a menu principal de empleados");
			break;
		case 1:
			util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "Seleccion: calculo de ventas total");
			oi.mostrarCalculoTotal ();
			break;
		case 2:
			util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  " Seleccion: Agregar compra cliente");
			oi.agregarCompraCliente();
			break;
		default:
			System.out.println("Introduzca una opcion valida");
			break;
		}
}
	
	private int menuEmpleado(){
		int opcionEmpleado;
		System.out.println("ACCESO MENU EMPLEADO");
		System.out.println("------------------");
		System.out.println("0. Volver al menu principal");
		System.out.println("1. Calcular total de ventas");
		System.out.println("2. Añadir compra");
		System.out.println("Seleccione una opcion");
		opcionEmpleado= Inicio.sc. nextInt();
		return opcionEmpleado;
	}
	
public void seleccionMenuGerencia()throws IOException {
		
		int opcion =menuGerencia();
		switch(opcion) {
		case 0 :
			break;
		case 1:
			util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "Seleccion: Dar alta un cliente");
			oi.altaCliente();
			break;
		default:
			System.out.println("Introduzca una opcion valida");
			break;
		}
}


private int menuGerencia(){
	int opcionEmpleado;
	System.out.println("ACCESO MENU GERENCIA");
	System.out.println("------------------");
	System.out.println("0. Volver al menu principal");
	System.out.println("1. Dar alta cliente");
	System.out.println("Seleccione una opcion");
	opcionEmpleado= Inicio.sc. nextInt();
	return opcionEmpleado;
}
	
}

