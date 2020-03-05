/**
 * <h1>Clase Examen Test</h1>
 * 
 * @author Alvaro y Soufiane
 * @version 1.3
 * 
 */

package notas;

import java.util.Iterator;

public class ExamenTest extends Alumno{
	private static final int NUM_PREGUNTAS = 30;
	public static double nota[];

	public static double pedirNotasTest() {
		int preguntas_sin[];
		int preguntas_bien[];
		int preguntas_mal[];
		
		double listaAlumnos = 0;
		
		System.out.println("		Examenes test");
		nota = new double[2];
		preguntas_sin = new int[2];
		preguntas_bien = new int[2];
		preguntas_mal = new int[2];
		int i=0;
		do {
			System.out.println("\nIngrese la nota del examen " + (i+1) + " --> ");
			System.out.print("Cuantas preguntas estan bien? --> ");
			preguntas_bien[i] = stdin.nextInt();

			System.out.print("Cuantas preguntas estan mal? --> ");
			preguntas_mal[i] = stdin.nextInt();

			// calcular cuantas preguntas estan sin responder.
			preguntas_sin[i] = 30 - (preguntas_bien[i] + preguntas_mal[i]);

			int preguntas = preguntas_bien[i] + preguntas_mal[i] + preguntas_sin[i];
			
			//No completo en todos los casos de error
			if (preguntas != 30 ) {
				System.err.println("	-- La suma de las preguntas de test tienen que ser 30!!  no = " + preguntas_sin[i]);
				i--;
			} else {
				System.out.print("Preguntas sin responder --> " + preguntas_sin[i]);
			}
			i++;
		} while (i < 2);
		
		for (int j = 0; j < 2; j++) {
			listaAlumnos = ((preguntas_bien[j] - (preguntas_mal[j] / 3)) * 10) / NUM_PREGUNTAS;
			listaAlumnos++;
			System.out.println("\nNota del examen Test " + (j+1) + ": " + Math.rint(listaAlumnos * 100) / 100);
		}

		System.out.println("\nNota media de los test: " + Math.rint(listaAlumnos / 2 * 100) / 100);
		
		return listaAlumnos;
	}

	// Comprobar si la suma de las preguntas es 30.
	public static boolean pregunta_valida(float nota) {
		return (nota == 30) ? true: false  ;
	}
	
}
