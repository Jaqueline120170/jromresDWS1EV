package dtos;

public class ClienteDto {
	
	long idCliente;
	String nombreCliente;
	String apellidosCliente;
	
	
	public ClienteDto() {
		super();
	}

	public ClienteDto(long idCliente, String nombreCliente, String apellidosCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
	}
	
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidosCliente() {
		return apellidosCliente;
	}
	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	@Override
	public String toString() {
		return "ClienteDto [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellidosCliente="
				+ apellidosCliente + "]";
	}
	
	

}
