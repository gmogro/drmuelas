package Clinica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

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
	public Turno(String fecha, int idodontologo) {
		this.fecha = fecha;
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
	
	public void crearTurnos(Connection conexion) 
	{
		Scanner sc = new Scanner(System.in);
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		Statement statementTurno = null;
		int odontologo = 0;
		int turno = 0 ;
		try {
			statement = conexion.createStatement();
			sql = "SELECT idodontologo,Nombre,Apellido,Documento "
					+ "FROM odontologo AS odo INNER JOIN persona AS per ON odo.idpersona = per.idpersona "
					+ "order by idodontologo;";
			rs = statement.executeQuery(sql);
			System.out.println("Seleccione Odontologo");
			while(rs.next()) 
			{
				int idodontologo = rs.getInt("idodontologo");
				String apellido = rs.getString("Apellido");
				String nombre = rs.getString("Nombre");
				String documento = rs.getString("Documento");
				System.out.println(idodontologo + " - " + apellido + " " + nombre + " " + documento);
			}
			System.out.println("0 - CANCELAR");
			odontologo = sc.nextInt();
			sc.nextLine();
			System.out.println("##############################");
			//System.out.println("Ingrese Fecha para crear Turno");
			//String fecha = sc.nextLine();
			System.out.println("Ingrese Horario de Atencion");
			System.out.println("1 - MAÑANA 8 a 13");
			System.out.println("2 - TARDE 15 a 20");
			turno = sc.nextInt();
			sc.nextLine();
		}catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
		
		switch (turno) {
				case 1: {
							System.out.println("Ingrese Mes");
							int mes = sc.nextInt();
							sc.nextLine();
							System.out.println("Ingrese Dia");
							int dia = sc.nextInt();
							sc.nextLine();
							/*System.out.println("Ingrese Año");
							int anio = sc.nextInt();
							sc.nextLine();*/
							ArrayList<Turno> listaTurno = new ArrayList<Turno>();
							Calendar calendar = Calendar.getInstance();
							Date date = new Date(22,mes-1,dia,8,0);
							calendar.setTime(date);
							calendar.add(Calendar.YEAR,100);
							date = calendar.getTime();
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
							String fecha = sdf.format(date);
							Turno t = new Turno(fecha,odontologo);
							listaTurno.add(t);
							for(int i=0;i<10;i++) 
							{
								calendar.setTime(date); //tuFechaBase es un Date;
								calendar.add(Calendar.MINUTE, 30); //minutosASumar es int.
								date = calendar.getTime(); //Y ya tienes la fecha sumada.
								sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
								fecha = sdf.format(date);
								t = new Turno(fecha,1);
								listaTurno.add(t);
							};
							System.out.println("Insertando Turno");
							try {
								statementTurno = conexion.createStatement();
				    			sql = "SELECT idturno FROM turno order by idturno DESC LIMIT 1;";
				    			rs = statementTurno.executeQuery(sql);
				    			int idturno = 0;
				    			while(rs.next()) 
				    			{
				    				idturno = rs.getInt("idturno");
				    			}
				    			//idturno = idturno + 1;
				    			int response = 0;
				    			PreparedStatement stmtTurno = null;
								for(int i=0;i<listaTurno.size();i++) 
								{
									System.out.println("##########");
									System.out.println(idturno);
									System.out.println(odontologo);
									System.out.println(listaTurno.get(i).fecha);
									stmtTurno = conexion.prepareStatement("INSERT IGNORE INTO turno (idturno,Fecha,idodontologo) VALUES (?,?,?)");
									stmtTurno.setInt(1,idturno + 1);
									stmtTurno.setString(2,listaTurno.get(i).fecha);
									stmtTurno.setInt(3,odontologo);									
				    	        	response = stmtTurno.executeUpdate();
				    	        	if (response > 0) {
				    	                System.out.println("Turno Insertado correctamente");
				    	        	}
				    	        	idturno = idturno + 1;
								};
							}catch (SQLException sqle){
					            System.out.println("SQLState: "+ sqle.getSQLState());
					            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
					            sqle.printStackTrace();
					        }catch (Exception e){
					            e.printStackTrace();
					        }
							break;
						}
				case 2: {
					System.out.println("Ingrese Mes");
					int mes = sc.nextInt();
					sc.nextLine();
					System.out.println("Ingrese Dia");
					int dia = sc.nextInt();
					sc.nextLine();
					/*System.out.println("Ingrese Año");
					int anio = sc.nextInt();
					sc.nextLine();*/
					ArrayList<Turno> listaTurno = new ArrayList<Turno>();
					Calendar calendar = Calendar.getInstance();
					Date date = new Date(22,mes-1,dia,15,0);
					calendar.setTime(date);
					calendar.add(Calendar.YEAR,100);
					date = calendar.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					String fecha = sdf.format(date);
					Turno t = new Turno(fecha,odontologo);
					listaTurno.add(t);
					for(int i=0;i<10;i++) 
					{
						calendar.setTime(date); //tuFechaBase es un Date;
						calendar.add(Calendar.MINUTE, 30); //minutosASumar es int.
						date = calendar.getTime(); //Y ya tienes la fecha sumada.
						sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
						fecha = sdf.format(date);
						t = new Turno(fecha,1);
						listaTurno.add(t);
					};
					try {
						statementTurno = conexion.createStatement();
		    			sql = "SELECT idturno FROM turno order by idturno DESC LIMIT 1;";
		    			rs = statementTurno.executeQuery(sql);
		    			int idturno = 0;
		    			while(rs.next()) 
		    			{
		    				idturno = rs.getInt("idturno");
		    			}
		    			idturno = idturno +1;
		    			int response = 0;
						for(int i=0;i<listaTurno.size();i++) 
						{
							PreparedStatement stmtFichaMedica = conexion.prepareStatement("INSERT INTO turno VALUES (?,?,?,?)");
		    				stmtFichaMedica.setInt(1,idturno);
		    				stmtFichaMedica.setInt(2,odontologo);
		    				stmtFichaMedica.setString(3,listaTurno.get(i).fecha);
		    	        	response = stmtFichaMedica.executeUpdate();
		    	        	if (response > 0) {
		    	                System.out.println("Tratamiento Insertado correctamente");
		    	        	}
		    	        	idturno = idturno+1;
						};
					}catch (SQLException sqle){
			            System.out.println("SQLState: "+ sqle.getSQLState());
			            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
			            sqle.printStackTrace();
			        }catch (Exception e){
			            e.printStackTrace();
			        }
					break;
				}
		default:
			throw new IllegalArgumentException("Unexpected value: " + turno);
		}
	}
	
	public void reservarTurno(Connection conexion) 
	{	
		Scanner sc = new Scanner(System.in);
		Statement statement = null;
		String sql;
		ResultSet rs;
		PreparedStatement stmt;
		try {
			System.out.println("#################");
			System.out.println("TURNO DISPONIBLES");
			System.out.println("#################");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    String today = dtf.format(LocalDateTime.now());
		    
			statement = conexion.createStatement();
			sql = "SELECT idturno,Nombre,Apellido"
					+ "FROM turno AS t INNER JOIN odontologo AS odo ON t.idodontologo = odo.id "
					+ "INNER JOIN persona ON odo.idpersona = per.idpersona"
					+ "WHERE t.fecha like '"+today+"%' AND t.estado = 1";
			rs = statement.executeQuery(sql);
			int idturno = 0;
			while(rs.next()) 
			{
				idturno = rs.getInt("idturno");
				String apellido = rs.getString("Apellido");
				String nombre = rs.getString("Nombre");
				System.out.println(idturno + " - " + apellido + " " + nombre + " ");
			}
			
			System.out.println("Reserva de Turno");
			System.out.println("Ingrese el numero de documento del Paciente");
			String documento = sc.nextLine();
			statement = conexion.createStatement();
			sql = "SELECT idpaciente,Nombre,Apellido"
					+ "Documento FROM paciente AS odo INNER JOIN persona AS per ON odo.idpersona = per.idpersona"
					+ "WHERE documento = "+documento;
			rs = statement.executeQuery(sql);
			int idpaciente = 0;
			while(rs.next()) 
			{
				idpaciente = rs.getInt("idpaciente");
				String apellido = rs.getString("Apellido");
				String nombre = rs.getString("Nombre");
				System.out.println(idpaciente + " - " + apellido + " " + nombre + " ");
			}
			
			stmt = conexion.prepareStatement("UPDATE turno SET "
					+ "idpersona=?"
					+ "WHERE turno =?");
        	stmt.setInt(1,idpaciente);
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se actualizo odotonlogo correctamente");
        	}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
