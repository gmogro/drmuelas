package Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Utilidades.Conexion;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion cnn = new Conexion("drmuelas","root","Navidad$25");
		
		System.out.println(cnn.conectar());
		
		try {
			PreparedStatement stmt = cnn.getConnection().prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?,?,?)");
        	stmt.setInt(1,1);
        	stmt.setString(2,"Guillermo");
        	stmt.setString(3,"Mogro");
        	stmt.setString(4,"Juan calle 15");
        	stmt.setString(5,"11111111");
        	stmt.setString(6,"Salta");
        	stmt.setString(7,"4400");
        	stmt.setString(8,"12/10/1994");
        	stmt.setString(9,"telefono");
        	
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se inserto correctamente");
        	}
        	 	
		}catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
		//cnn.desconectar();
	}

}
