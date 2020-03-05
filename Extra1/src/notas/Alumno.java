package notas;

import java.util.Scanner;

public class Alumno {
	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String sexo;
	private int edad;
	private Double notaExamenTest;
	private Double notaExamenClasico;
	private Double notaTrabajos;
	private String calificacion;

	public String getIdAlumno() {
		return nombre;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Double getNotaExamenClasico() {
		return notaExamenClasico;
	}

	public void setNotaExamenClasico(Double notaExamenClasico) {
		this.notaExamenClasico = notaExamenClasico;
	}

	public Double getNotaExamenTest() {
		return notaExamenTest;
	}

	public void setNotaExamenTest(Double notaExamenTest) {
		this.notaExamenTest = notaExamenTest;
	}

	public Double getNotaTrabajos() {
		return notaTrabajos;
	}

	public void setNotaTrabajos(Double notaTrabajos) {
		this.notaTrabajos = notaTrabajos;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public Alumno() {
		this.nombre = "";
		this.apellidos = "";
		this.sexo = "";
		this.edad = 0;
		this.notaExamenTest = 0.0;
		this.notaExamenClasico = 0.0;
		this.notaTrabajos = 0.0;
		this.calificacion = "";
	}

	public String toString() {
		return "ID Alumno: " + idAlumno + "\n\tNombre: " + nombre + "\n\tApellidos: " + apellidos + "\n\tSexo: " + sexo
				+ "\n\tEdad: " + edad + "\n\tNota del examen test: " + notaExamenTest + "\n\tNota de examen clasico: "
				+ notaExamenClasico + "\n\tNota de de los trabajo: " + notaTrabajos + "\n\tNota final:  " + calificacion
				+ "\n";
	}
	
	/*
	 * 
	 * Examen Clasico
	 * 
	 * 
	 * */
	 
	public static double pedirNotasClasico() {
		System.out.println("		Examenes clasicos");
		int i = 0;
		double nota[];
		nota = new double[4];
		do {
			System.out.print("Ingrese la nota del examen " + i + " --> ");
			nota[i] = stdin.nextDouble();

			// Mensaje de error. Si la nota introducida no es valida.
			if (nota_valida(nota[i])) {
				System.err.println("\n			Error!!\n	Ingrese una nota valida (del 1 al 10)\n");
				--i;
			}
			++i;
		} while (nota_valida(nota[i]) || i<=2);
		double listaAlumnos = (nota[0] + nota[1] + nota[2]) / 3;
		
		System.out.println("\nNota del examen Clasico: " + Math.rint(listaAlumnos * 100) / 100);
		return listaAlumnos;
	}


	public static boolean nota_valida(Double nota) {
		return (nota <= 10 && nota >= 0) ? false : true;
	}
	
	/*
	 * 
	 * Examen Test
	 * 
	 * 
	 */
	public static double pedirNotasTest() {
		int preguntas_sin;
		int preguntas_bien;
		int preguntas_mal;
		
		System.out.println("		Examenes test");

		do {
			System.out.print("Cuantas preguntas estan bien? --> ");
			preguntas_bien = stdin.nextInt();

			System.out.print("Cuantas preguntas estan mal? --> ");
			preguntas_mal = stdin.nextInt();

			// calcular cuantas preguntas estan sin responder.
			preguntas_sin = 30 - (preguntas_bien + preguntas_mal);

			int preguntas = preguntas_bien + preguntas_mal + preguntas_sin;

			if (pregunta_valida(preguntas)) {
				System.err
						.println("	-- La suma de las preguntas de test tienen que ser 30!!  no = " + preguntas_sin);
			} else {
				System.out.print("Preguntas sin responder --> " + preguntas_sin);
			}
		} while (preguntas_sin < 0 || preguntas_sin > 30);

		double listaAlumnos = (preguntas_bien - (preguntas_mal / 3)) * 10 / 30;

		System.out.println("\nNota del examen Test: " + Math.rint(listaAlumnos * 100) / 100);
		
		return listaAlumnos;
	}

	// Comprobar si la suma de las preguntas es 30.
	public static boolean pregunta_valida(float nota) {
		return (nota == 30) ? false : true;
	}
	
	/*
	 * 
	 * 
	 * Nota Trabajos
	 * 
	 * 
	 */
	private static boolean entregado = false;
	private float suma;
	private double nota;

	// Pedimos al usuario que indique si los trabajos han sido entregados
	public static void trabajoEntregado() {
		System.out.println("¿Han sido entregados todos los trabajos?");
		int opcion = 0;
		do {
			System.out.println("\n1.Sí.");
			System.out.println("2. No.");
			System.out.print("\n --> ");
			opcion = stdin.nextInt();
			if (opcion < 1 || opcion > 2) {
				System.err.println("Error. Introduce 1 o 2.");
			}
			if (opcion == 1) {
				entregado = true;
			} else {
				entregado = false;
			}

		} while (opcion < 1 || opcion > 2);
	}

	// calcular la nota de los trabajos
	public static double notaTravajo() {
		trabajoEntregado();
		
		int i = 0;
		double notaTrabajo[];
		
		notaTrabajo = new double[4];
		
		if (entregado) {
			do {
				System.out.print("Ingrese la nota del examen " + i + " --> ");
				notaTrabajo[i] = stdin.nextDouble();

				// Mensaje de error. Si la nota introducida no es valida.
				if (nota_valida(notaTrabajo[i])) {
					System.err.println("\n			Error!!\n	Ingrese una nota valida (del 1 al 10)\n");
					--i;
				}
				++i;
			} while (nota_valida(notaTrabajo[i]) || i<=2);
			
			// Calcula la nota media de los trabajos
			double mediaTrabajo = Math.rint( ((notaTrabajo[0] + notaTrabajo[1] + notaTrabajo[2]) / 3) * 100) / 100;
			
			System.out.println("\nNota del examen Test: " + mediaTrabajo);
			
			return mediaTrabajo;
		} else { // Si no han sido entregados los trabajos
			System.out.println("NOTA FINAL: 3. \n Directo a Julio.");
			return 3;
		}
	}
	
	/*
	 * 
	 * 
	 * Nota Alumnos
	 * 
	 * 
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
				System.err.println("\tError\nOpción invalida.Debes elegir 1,2,3,4 ó 5");
			}

		} while (opcion < 1 || opcion > 5);
		return opcion;
	}

	// Main donde se ejecuta cada funcion del menu
	public static void main(String[] args) {
		// datos de los alumnos
		Alumno[] listaAlumnos = new Alumno[2];

		int opcion = 0;
		int i = 0;
		String calificacion;

		do {
			opcion = Menu(opcion);
			switch (opcion) {
			case 1:
				while (i < 2) {
					System.err.println("\n\tAlumno " + (i+1));
					listaAlumnos[i] = new Alumno();
					listaAlumnos[i].setIdAlumno(i);
					System.out.println("Nombre de alumno");
					listaAlumnos[i].setNombre(stdin.next());
					System.out.println("Apellidos de alumno");
					listaAlumnos[i].setApellidos(stdin.next());
					System.out.println("Sexo del alumno");
					listaAlumnos[i].setSexo(stdin.next());
					System.out.println("Edad del alumno");
					listaAlumnos[i].setEdad(stdin.nextInt());
					System.out.println("Nota del alumno");
					listaAlumnos[i].setNotaTrabajos(notaTravajo());
					listaAlumnos[i].setNotaExamenTest(pedirNotasTest());
					listaAlumnos[i].setNotaExamenClasico(pedirNotasClasico());
					
					double nota = (listaAlumnos[i].getNotaTrabajos() + listaAlumnos[i].getNotaExamenTest() + listaAlumnos[i].getNotaExamenClasico()) / 3;
					if (nota >= 5)
						listaAlumnos[i].setCalificacion("Aprobado");
					else
						listaAlumnos[i].setCalificacion("Suspendido");
					
					System.out.println("\n\tnota " + Math.rint( (nota * 100) / 100) + " --> " + listaAlumnos[i].getCalificacion());
					i++;
				}
				opcion = 0;
				break;
			case 2:
				System.out.println("Introduce la id del alumno a consultar :");
				int id = stdin.nextInt();
				for (i = 0; i < notas.length; i++) {
					System.out.println(listaAlumnos[i]);
				}
				if (listaAlumnos.length < id) {
					System.out.println("Hay " + listaAlumnos.length + " alumnos registrados");
				}
				opcion = 0;
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
				System.out.println("Adios");
				break;
			} 
		} while (opcion == 0);

	}

	public static boolean nota_valida(double nota) {
		return (nota <= 10 && nota >= 0) ? false : true;
	}

}

