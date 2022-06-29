package Clinica;

public class Turno {
	private String fecha;
	private int idpaciente;
	private int idodontologo;
	
	public Turno() {
	}
	public Turno(String fecha, int idpaciente, int idodontologo) {
		this.fecha = fecha;
		this.idpaciente = idpaciente;
		this.idodontologo = idodontologo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	public int getIdodontologo() {
		return idodontologo;
	}
	public void setIdodontologo(int idodontologo) {
		this.idodontologo = idodontologo;
	}
	
	
	
}
