package util;

import controladores.Inicio;

public class utilidades {

public static long calcularIdUsuario() {
		
		long nuevoId = 0;
		int tamanio = Inicio.listaClientes.size();

		if (tamanio > 0)
		{

		    nuevoId = Inicio.listaClientes.get(tamanio - 1).getIdCliente()+1;

		}
		else
		{

		    nuevoId = 1;

		}

		return nuevoId;

		
	}

public static long calcularIdVenta() {
	
	long nuevoId = 0;
	int tamanio = Inicio.listaVentas.size();

	if (tamanio > 0)
	{

	    nuevoId = Inicio.listaVentas.get(tamanio - 1).getIdVenta()+1;

	}
	else
	{

	    nuevoId = 1;

	}

	return nuevoId;

	
}
}
