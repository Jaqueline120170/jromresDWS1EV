package servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import controladores.Inicio;

import dtos.ClienteDto;
import dtos.VentaDto;


public class OperativaImplementacion implements OperativaInterfaz {
	
	public void altaCliente()throws IOException {
		
		System.out.println("DAR ALTA CLIENTE");
		
		long idCalculado = util.utilidades.calcularIdUsuario();
		System.out.println("Introduzca su nombre");
		String nombre =Inicio.sc.next();
		System.out.println("Introduzca sus apellidos");
		String apellidos =Inicio.sc.next();
		ClienteDto miembro = new ClienteDto (idCalculado,nombre,apellidos);
		Inicio.listaClientes.add(miembro);
		System.out.println("Cliente ingresado con exito");
		util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "Alta cliente exito");
	}
	
	public void mostrarCalculoTotal()throws IOException {
		
		LocalDate fechaFormateada = solicitarFecha();
		
		double ventasMes = 0.0;
		
		for (VentaDto v : Inicio.listaVentas) {
			
			LocalDate fechaCompra = v.getFechaVenta(); 
																						
			if (fechaCompra.equals(fechaFormateada)) {
				
				ventasMes += v.getImporteVenta();
				
			}
	}
	
	}
	public void agregarCompraCliente()throws IOException {
		System.out.println("AGREGAR COMPRA");
			VentaDto crearVenta = new VentaDto();
			long id;
			System.out.println("Introduzca el id del cliente a quien desea añadir una compra");
			id=Inicio.sc.nextLong();
			boolean idEncontrado = false;
            
            for (ClienteDto buscarID : Inicio.listaClientes)
            {
                if (buscarID.getIdCliente() == id) {
                	long idVenta= util.utilidades.calcularIdVenta();
        			System.out.println("Agrege el importe de la venta");
        			double importeVenta=Inicio.sc.nextDouble();	
        			crearVenta.setImporteVenta(importeVenta);
        			crearVenta.setIdVenta(idVenta);
        			Inicio.listaVentas.add(crearVenta);
        			System.out.println("Venta ingresada");
        			util.GestorFicheros.sobreEscribir(Inicio.fechaYhora +  "compra cliente exito");
                }
                if (!idEncontrado) {
                    System.out.println("El cliente no existe, verifiquelo y vuelva a intentar");
                }
			
		
	}
          
}
	private LocalDate solicitarFecha() {

		LocalDate fechaDate = null;
		boolean esValido = false;
		do {
			try {
				System.out.println("Ingrese fecha (dd-mm-yyyy):");
				String fecha = Inicio.sc.nextLine();

				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				fechaDate = LocalDate.parse(fecha, formato);
				esValido = true;
			} catch (DateTimeParseException e) {
				System.out.println("Formato de fecha no valido.");
			}
		} while (!esValido);
		return fechaDate;
	}
}
