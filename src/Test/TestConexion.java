package Test;

import Utilidades.Conexion;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conexion cnn = new Conexion("drmuelas","root","Navidad$25");
		
		System.out.println(cnn.conectar());
		cnn.desconectar();
	}

}
