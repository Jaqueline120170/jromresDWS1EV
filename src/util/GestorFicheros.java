package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;
import dtos.ClienteDto;
import dtos.VentaDto;

public class GestorFicheros {
	
	public static String nombreFichero() 
	 {
	        LocalDate fechaActual = LocalDate.now();
	        String diasFecha = DateTimeFormatter.ofPattern("dd").format(fechaActual);
	        String mesFecha = DateTimeFormatter.ofPattern("MM").format(fechaActual);
	        String anioFecha = DateTimeFormatter.ofPattern("yy").format(fechaActual);
	        String fechaCompleta = diasFecha + mesFecha + anioFecha;
	        String rutaArchivo = "C:\\Users\\PC\\eclipse-workspace\\jromresDWS1Evaluacion\\auditoria" + fechaCompleta + ".txt";
	        return rutaArchivo;
	    }

	    public static void sobreEscribir(String accion)
	    {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero(), true)))
	        {
	            writer.write(accion + "\n");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void creaFichero()
	    {
	        try {
	            FileWriter fw = new FileWriter(nombreFichero());
	            fw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public static void accesoAFicheros(String rutaFicheroGeneral)
		{
	        File archivo = new File(rutaFicheroGeneral);
	        if (archivo.exists()) 
	        {
	            try {
	                String[] contenidoFichero = Files.readAllLines(Paths.get(rutaFicheroGeneral)).toArray(new String[0]);

	                for (String fichero : contenidoFichero) 
	                {
	                    String[] lineasContenido = fichero.split(";");
	                    VentaDto venta = new VentaDto(Long.parseLong(lineasContenido[0]),Double.parseDouble(lineasContenido[1]),LocalDate.parse(lineasContenido[2]));
	                    Inicio.listaVentas.add(venta);
	                }

	                System.out.println("Lista de ventas");
	                for (String line : contenidoFichero)
	                {
	                    System.out.println(line);
	                }
	            } catch (IOException e) 
	            {
	                System.out.println("Error al leer el archivo: " + e.getMessage());
	            }
	        } else 
	        {
	            System.out.println("No existen ventas");
	        }
	}
	    public static void altaCliente(String ficheroClientes) 
		{
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(ficheroClientes));
	            String[] contenidoFicheroClientes = Files.readAllLines(Paths.get(ficheroClientes)).toArray(new String[0]);
	            String linea;
	            while ((linea = reader.readLine()) != null) 
	            {
	                String[] partesDeLaLinea = linea.split(";");
	                ClienteDto cliente = new ClienteDto(Long.parseLong(partesDeLaLinea[0]), partesDeLaLinea[1],
	                        (partesDeLaLinea[2]));
	              Inicio.listaClientes.add(cliente);
	            }
	            System.out.println("Lista de clientes dados de alta");
	            for (String line : contenidoFicheroClientes) 
	            {
	                System.out.println(line);
	            }
	            reader.close();
	        } catch (IOException e) 
	        {
	            System.out.println("Error al leer el archivo: " + e.getMessage());
	        }
	    }

}
