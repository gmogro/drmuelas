package Test;

import Entidades.Paciente;
import Utilidades.Conexion;

public class TestPaciente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion cnn = new Conexion("drmuelas","root","Navidad$25");
		
		System.out.println(cnn.conectar());
		
		Paciente paciente = new Paciente();
		
		paciente.crearPaciente(cnn.getConnection());
	}

}
