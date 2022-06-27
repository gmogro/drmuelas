package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente {
	private int idpersona;

	public Paciente() {
	}

	public Paciente(int idpersona) {
		this.idpersona = idpersona;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	
	public void crearPaciente(Connection conexion) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("#######################");
		System.out.println("Datos Personales");
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
		System.out.println("#######################");
		System.out.println("FICHA MEDICA");
		System.out.println("#######################");
		
		ArrayList<Tratamiento> listaTratamiento = new ArrayList<Tratamiento>();
		System.out.println("Tiene Tratamientos Realizados");
		System.out.println("1 - SI");
		System.out.println("2 - NO");
		int agregarTratamiento = sc.nextInt();
		sc.nextLine();
		while(agregarTratamiento == 1) 
		{
			System.out.println("Tratamiento");
			String tratamiento = sc.nextLine();
			System.out.println("Fecha");
			String fecha = sc.nextLine();
			Tratamiento Objecttratamiento = new Tratamiento(tratamiento,fecha);
			listaTratamiento.add(Objecttratamiento);
			System.out.println("Desea ingresar mas tratamiento");
			System.out.println("1 - SI");
			System.out.println("2 - NO");
			agregarTratamiento = sc.nextInt();
		}
		try {
			Statement statement = conexion.createStatement();
			String sql = "SELECT idpersona FROM persona order by idPersona DESC LIMIT 1;";
			ResultSet rs = statement.executeQuery(sql);
			int idPersona = 0;
			while(rs.next()) 
			{
				idPersona = rs.getInt("idPersona");
			}
			PreparedStatement stmt = conexion.prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?,?,?)");
        	stmt.setInt(1,idPersona+1);
        	stmt.setString(2,nombre);
        	stmt.setString(3,apellido);
        	stmt.setString(4,domicilio);
        	stmt.setString(5,documento);
        	stmt.setString(6,provincia);
        	stmt.setString(7,codigoPostal);
        	stmt.setString(8,fechaNacimiento);
        	stmt.setString(9,telefono);
        	
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto correctamente");
        	}
        	
        	Statement statementPaciente = conexion.createStatement();
			sql = "SELECT idpaciente FROM paciente order by idpaciente DESC LIMIT 1;";
			rs = statementPaciente.executeQuery(sql);
			int idpaciente = 0;
			while(rs.next()) 
			{
				idpaciente = rs.getInt("idpaciente");
			}
        	PreparedStatement stmtpaciente = conexion.prepareStatement("INSERT INTO paciente VALUES (?,?)");
        	stmtpaciente.setInt(1,idpaciente+1);
        	stmtpaciente.setInt(2,idPersona+1);
        	
        	response = stmtpaciente.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto paciente correctamente");
        	}
        	if(listaTratamiento.size()>0) 
        	{
        		Statement statementFichaMedica = conexion.createStatement();
    			sql = "SELECT idFichaMedica FROM fichamedica order by idFichaMedica DESC LIMIT 1;";
    			rs = statementFichaMedica.executeQuery(sql);
    			int idFichaMedica = 0;
    			while(rs.next()) 
    			{
    				idFichaMedica = rs.getInt("idFichaMedica");
    			}
    			idFichaMedica = idFichaMedica+1;
    			for(int i=0;i<listaTratamiento.size();i++) {
    				PreparedStatement stmtFichaMedica = conexion.prepareStatement("INSERT INTO fichamedica VALUES (?,?,?,?)");
    				stmtFichaMedica.setInt(1,idFichaMedica);
    				stmtFichaMedica.setInt(2,idpaciente+1);
    				stmtFichaMedica.setString(3,listaTratamiento.get(i).getNombre());
    				stmtFichaMedica.setString(4,listaTratamiento.get(i).getFecha());
    	        	response = stmtFichaMedica.executeUpdate();
    	        	if (response > 0) {
    	                System.out.println("Tratamiento Insertado correctamente");
    	        	}
    	        	idFichaMedica = idFichaMedica+1;
    			}
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







