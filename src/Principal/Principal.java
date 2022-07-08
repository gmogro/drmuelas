package Principal;

import java.util.Scanner;

import Clinica.Turno;
import Entidades.Odontologo;
import Entidades.Paciente;
import Utilidades.Conexion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Conexion cnn = new Conexion("drmuelas","root","Navidad$25");
		System.out.println(cnn.conectar());
		
		System.out.println("##############");
		System.out.println("Iniciar Sesion");
		System.out.println("##############");
		//Falta implementar
		
		int opcion;
		do {
			System.out.println("##############");
			System.out.println("SELECCIONE OPCIONES");
			System.out.println("##############");
			System.out.println("1 - PACIENTES");
			System.out.println("2 - ODONTOLOGO");
			System.out.println("3 - TURNOS");
			System.out.println("4 - SECTORES");
			System.out.println("0 - Terminar");
			opcion = sc.nextInt();
			switch (opcion) {
					case 1: 
					{
						System.out.println("##############");
						System.out.println("OPCIONES DE PACIENTES");
						System.out.println("##############");
						System.out.println("1 - CREAR UN PACIENTE");
						System.out.println("2 - ACTUALIZAR UN PACIENTE");
						System.out.println("3 - ELIMINAR UN PACIENTE");
						System.out.println("4 - ACTUALIZAR LA FICHA MEDICA");
						System.out.println("0 - Terminar");
						int opcionPaciente = sc.nextInt();
						switch (opcionPaciente) {
							case 1: {
								Paciente paciente = new Paciente();
								paciente.crearPaciente(cnn.getConnection());
								break;
									}
							case 2: {
								Paciente paciente = new Paciente();
								paciente.actualizarPaciente(cnn.getConnection());
								break;
							}
							case 3: {
								Paciente paciente = new Paciente();
								paciente.eliminarPaciente(cnn.getConnection());
								break;
							}
							case 4: {
								System.out.println("ACA SE ACTUALIZA LA FICHA DE TRATAMIENTO");
								break;
							}
						default:
							throw new IllegalArgumentException("Unexpected value: " + opcionPaciente);
						}
						break;
					}
					case 2: 
					{
						System.out.println("##############");
						System.out.println("OPCIONES DE ODONTOLOGO");
						System.out.println("##############");
						System.out.println("1 - CREAR UN ODONTOLOGO");
						System.out.println("2 - ACTUALIZAR UN ODONTOLOGO");
						System.out.println("3 - ELIMINAR UN ODONTOLOGO");
						System.out.println("0 - Terminar");
						int opcionOdontologo = sc.nextInt();
						switch (opcionOdontologo) {
							case 1: {
								Odontologo odontologo = new Odontologo();
								odontologo.crearOdontologo(cnn.getConnection());
								break;
									}
							case 2: {
								Odontologo odontologo = new Odontologo();
								odontologo.actualizarOdontologo(cnn.getConnection());
								break;
							}
							case 3: {
								Odontologo odontologo = new Odontologo();
								odontologo.eliminarOdontologo(cnn.getConnection());
								break;
							}
						default:
							throw new IllegalArgumentException("Unexpected value: " + opcionOdontologo);
						}
						break;
					}
					case 3: 
					{
						System.out.println("##############");
						System.out.println("OPCIONES DE TURNOS");
						System.out.println("##############");
						System.out.println("1 - CREAR TURNOS");
						System.out.println("2 - MOSTRAR TURNOS");
						System.out.println("3 - ACTUALIZAR TURNO");
						System.out.println("0 - Terminar");
						int opcionturno = sc.nextInt();
						switch (opcionturno) {
							case 1: {
								Turno turno = new Turno();
								turno.crearTurnos(cnn.getConnection());
								break;
							}
							case 2: {
								Turno turno = new Turno();
								turno.reservarTurno(cnn.getConnection());
								break;
							}
							case 3: {
								Turno turno = new Turno();
								//turno.crearTurnos(cnn.getConnection());
								break;
							}
							default:
							throw new IllegalArgumentException("Unexpected value: " + opcionturno);
						}
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + opcion);
					}
		System.out.println("##################");
		System.out.println("¿Cierra el Sistema?");
		System.out.println("0 - SI");
		System.out.println("1 - NO");
		System.out.println("##################");
		}while(opcion!=0);
		System.out.println("TERMINO EL DIA DE TRABAJO");
	}
}
