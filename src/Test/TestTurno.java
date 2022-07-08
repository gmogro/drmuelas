package Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Clinica.Turno;
import Utilidades.Conexion;

public class TestTurno {
	public static void main(String[] args) {
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date date = new Date();
		System.out.println(date.);
		String fecha = sdf.format(date); 
		System.out.println(fecha);*/
		
		/*Calendar calendar = Calendar.getInstance();
		Date date = new Date(22,6,2,8,0);
		calendar.setTime(date);
		calendar.add(Calendar.YEAR,100);
		date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String fecha = sdf.format(date); 
		System.out.println(fecha);
		calendar.setTime(date); //tuFechaBase es un Date;
		calendar.add(Calendar.MINUTE, 30); //minutosASumar es int.
		calendar.add(Calendar.YEAR,100); //horasASumar es int.
		date = calendar.getTime(); //Y ya tienes la fecha sumada.
		sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		fecha = sdf.format(date);
		System.out.println(fecha);*/
		
		/*ArrayList<Turno> listaTurno = new ArrayList<Turno>();
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(22,6,2,15,0);
		calendar.setTime(date);
		calendar.add(Calendar.YEAR,100);
		date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String fecha = sdf.format(date);
		Turno t = new Turno(fecha,1);
		listaTurno.add(t);
		for(int i=0;i<10;i++) 
		{
			calendar.setTime(date); //tuFechaBase es un Date;
			calendar.add(Calendar.MINUTE, 30); //minutosASumar es int.
			//calendar.add(Calendar.YEAR,100); //horasASumar es int.
			date = calendar.getTime(); //Y ya tienes la fecha sumada.
			sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			fecha = sdf.format(date);
			t = new Turno(fecha,1);
			listaTurno.add(t);
		};
		
		for(int i=0;i<listaTurno.size();i++) 
		{
			System.out.println("Turno: " + listaTurno.get(i).getFecha());
		};*/
		
		/*Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = sdf.format(date);
		System.out.println(date);
		System.out.println(fecha);*/
		
		
		Conexion cnn = new Conexion("drmuelas","root","Navidad$25");
		
		System.out.println(cnn.conectar());
		
		Turno turno = new Turno();
		//turno.crearTurnos(cnn.getConnection());
		turno.reservarTurno(cnn.getConnection());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}