package notas;

import java.util.Scanner;

public class Alumno {
	
	
	/* 
	  Nota Alumnos
	 */
	public static Scanner stdin = new Scanner(System.in);
	
	// notas de los alumnos
	public static float[] notas;
	
	// inormacion de los alumno
	public static String[] alumnos;

	// Menu principal del programa
	public static int Menu(int opcion) {
		do {
			System.out.println("1 - Registrar un alumno ");
			System.out.println("2 - Consultar un alumno ");
			System.out.println("3 - Modificar notas ");
			System.out.println("4 - Ver clase completa ");
			System.out.println("5 - Salir ");
			System.out.print("Introduce opcion (1..5) --> ");
			opcion = stdin.nextInt();
			if (opcion < 1 || opcion > 5) {
				System.err.println("\tError\nOpcion invalida.Debes elegir 1,2,3,4,5");
			}

		} while (opcion < 1 || opcion > 5);
		return opcion;
	}

	// Main donde se ejecuta cada funcion del menu
	public static void main(String[] args) {
		// datos de los alumnos
		Datos[] listaAlumnos = new Datos[10];

		int opcion = 0;
		int i = 0;
		String calificacion;

		do {
			opcion = Menu(opcion);
			int id;
			switch (opcion) {
			case 1:
				while (i < 2) {
					System.err.println("\n\tAlumno " + (i+1));
					listaAlumnos[i] = new Datos();
					listaAlumnos[i].setIdAlumno(i);
					
					System.out.println("Nombre de alumno");
					listaAlumnos[i].setNombre(stdin.next());
					
					System.out.println("Apellidos de alumno");
					listaAlumnos[i].setApellidos(stdin.next());
					
					System.out.println("Sexo del alumno");
					listaAlumnos[i].setSexo(stdin.next());
					
					System.out.println("Edad del alumno");
					listaAlumnos[i].setEdad(stdin.nextInt());
					
					System.out.println("\tIntroduce las notas del alumno: ");
					listaAlumnos[i].setNotaTrabajos(Trabajos.notaTrabajo());
					listaAlumnos[i].setNotaExamenTest(ExamenTest.pedirNotasTest());
					listaAlumnos[i].setNotaExamenClasico(ExamenClasico.calcularNotaMedia());
					
					double nota = (listaAlumnos[i].getNotaTrabajos() + listaAlumnos[i].getNotaExamenTest() + listaAlumnos[i].getNotaExamenClasico()) / 3;
					if (nota >= 5)
						listaAlumnos[i].setCalificacion("Aprobado");
					else
						listaAlumnos[i].setCalificacion("Suspendido");
					
					System.out.println("\n\tNota " + Math.rint( (nota * 100) / 100) + " --> " + listaAlumnos[i].getCalificacion());
					i++;
				}
				opcion = 0;
				break;
			case 2:
				ConsultarAlumno.consultarAlumno();
				break;
			case 3:
				System.out.println("Introduce la id del alumno a modificar :");
				id = stdin.nextInt();
				if (listaAlumnos.length < id) {
					System.out.println("Hay " + listaAlumnos.length + " alumnos registrados");
				} else {
					System.out.println("Escribe la nueva nota Examenes Clasico");
					listaAlumnos[id].setNotaExamenClasico(stdin.nextDouble());
					
					System.out.println("Escribe la nueva nota Examenes test");
					listaAlumnos[id].setNotaExamenTest(stdin.nextDouble());
					
					System.out.println("Escribe la nueva nota trabajos");
					listaAlumnos[id].setNotaTrabajos(stdin.nextDouble());
					
					double nuevaNota = (listaAlumnos[id].getNotaTrabajos() + listaAlumnos[id].getNotaExamenTest() + listaAlumnos[id].getNotaExamenClasico()) / 3;
					if (nuevaNota >= 5)
						listaAlumnos[i].setCalificacion("Aprobado");
					else
						listaAlumnos[i].setCalificacion("Suspendido");
					}			
				opcion = 0;
				break;
			case 4:
				System.out.println("Alumnos en la clase: \n" + listaAlumnos); 
				opcion = 0;
				break;
			case 5:
				System.out.println("Hasta la proxima evaluacion.");
				break;
			} 
		} while (opcion == 0);

	}

	public static boolean nota_valida(double nota) {
		return (nota <= 10 && nota >= 0) ? false : true;
	}

}

