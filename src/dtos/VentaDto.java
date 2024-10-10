package dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VentaDto {

	long idVenta;
	double importeVenta;
	LocalDate fechaVenta=LocalDate.now();
	
	
	
	public VentaDto() {
		super();
	}
	public VentaDto(long idVenta, double importeVenta, LocalDate fechaVenta) {
		super();
		this.idVenta = idVenta;
		this.importeVenta = importeVenta;
		this.fechaVenta = fechaVenta;
	}
	public long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}
	public double getImporteVenta() {
		return importeVenta;
	}
	public void setImporteVenta(double importeVenta) {
		this.importeVenta = importeVenta;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
}
