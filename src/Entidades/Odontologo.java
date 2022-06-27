package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Odontologo extends Persona{
	private int id;
	private int consultorio;
	private String sector;
	
	public Odontologo() {
	}

	public Odontologo(int id, int consultorio, String sector) {
		this.id = id;
		this.consultorio = consultorio;
		this.sector = sector;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(int consultorio) {
		this.consultorio = consultorio;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public void crearPaciente(Connection conexion) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("#######################");
		System.out.println("Datos del Odontologo");
		System.out.println("#######################");
		System.out.println("Apellido :");
		String apellido = sc.nextLine(); 
		System.out.println("Nombre :");
		String nombre = sc.nextLine();
		System.out.println("Domicilio :");
		String domicilio = sc.nextLine();
		System.out.println("Documento :");
		String documento = sc.nextLine();
		System.out.println("Provincia :");
		String provincia = sc.nextLine();
		System.out.println("Codigo Postal :");
		String codigoPostal = sc.nextLine();
		System.out.println("Fecha de Nacimiento : ");
		String fechaNacimiento = sc.nextLine();
		System.out.println("Telefono : ");
		String telefono = sc.nextLine();
		
		try {
			Statement statement = conexion.createStatement();
			String sql = "SELECT idpersona FROM persona order by idPersona DESC LIMIT 1;";
			ResultSet rs = statement.executeQuery(sql);
			int idpersona = 0;
			while(rs.next()) 
			{
				idpersona = rs.getInt("idPersona");
			}
			PreparedStatement stmt = conexion.prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?,?,?)");
        	stmt.setInt(1,idpersona+1);
        	stmt.setString(2,nombre);
        	stmt.setString(3,apellido);
        	stmt.setString(4,domicilio);
        	stmt.setString(5,documento);
        	stmt.setString(6,provincia);
        	stmt.setString(7,codigoPostal);
        	stmt.setString(8,fechaNacimiento);
        	stmt.setString(9,telefono);
        	
        	System.out.println("##############");
        	System.out.println("DATOS DEL PARTICULARES DEL ODONTOLOGO");
        	System.out.println("##############");
        	System.out.println("Numero de Consultorio");
        	int consultorio = sc.nextInt();
        	sc.nextLine();
        	System.out.println("Sector donde Trabaja de la Clinica");
        	String sector = sc.nextLine();
        	
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto persona correctamente");
        	}
        	
        	Statement statementOdontologo = conexion.createStatement();
			sql = "SELECT idodontologo FROM paciente order by idodontologo DESC LIMIT 1;";
			rs = statementOdontologo.executeQuery(sql);
			int idodontologo = 0;
			while(rs.next()) 
			{
				idodontologo = rs.getInt("idodontologo");
			}
        	PreparedStatement stmtodontologo = conexion.prepareStatement("INSERT INTO paciente VALUES (?,?,?,?)");
        	stmtodontologo.setInt(1,idodontologo+1);
        	stmtodontologo.setInt(2,idpersona+1);
        	stmtodontologo.setInt(3,consultorio);
        	stmtodontologo.setString(4,sector);
        	
        	response = stmtodontologo.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto paciente correctamente");
        	}
        	
		}catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
	}
}
