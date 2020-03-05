/**
 * <h1>Clase Examen Clasico</h1>
 * 
 * @author Alvaro y Soufiane
 * @version 1.6
 * 
 */
package notas;

/**
 * @author Mati
 *
 */
public class ExamenClasico extends Alumno {
	
	public static int i = 0;
	public static double nota[];

	public static void pedirNotasClasico() {

		System.out.println("		Examenes clasicos");

		nota = new double[4];
		do {
			System.out.print("Ingrese la nota del examen " + (i+1) + " --> ");
			nota[i] = stdin.nextDouble();

			// Mensaje de error. Si la nota introducida no es valida.
			if (nota_valida(nota[i])) {
				System.err.println("\n			Error!!\n	Ingrese una nota valida (del 1 al 10)\n");
				--i;
			}
			++i;
		} while (nota_valida(nota[i]) || i <= 2);

	}
	//Calcula la nota media de los examenes clasicos

	public static double calcularNotaMedia() {
		pedirNotasClasico();
		double listaAlumnos = (nota[0] + nota[1] + nota[2]) / 3;

		System.out.println("\nNota del examen Clasico: " + Math.rint(listaAlumnos * 100) / 100);
		return listaAlumnos;

	}

    public static boolean nota_valida(Double nota) {
		return (nota <= 10 && nota >= 0) ? false : true;
	}

}
