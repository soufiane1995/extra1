/**
 * <h1>Clase Examen Clasico</h1>
 * 
 * @author Alvaro y Soufiane
 * @version 1.6
 * 
 */
package notas;

import java.util.Scanner;

public class ExamenClasico {
	public static float[] notas;
	public static Scanner stdin = new Scanner(System.in);

	public static void notasExamenClasico() {
		System.out.println("		Exámenes clasicos");
		for (int i = 0; i < 3; i++) {
			// pedir la nota al usuario.
			System.out.print("Ingrese la nota del exámen " + (i + 1) + " : ");
			notas[i] = stdin.nextFloat();

			// mensaje de error. si la nota introducida es valida.
			if (nota_valeda(notas[i])) {
				System.err.println("\n			Error!!\n	Ingrese una nota válida (del 1 al 10)\n");
				--i;
			}
		}
	}

	// Clcular la nota media.
	public static float mediaExamenClasico() {
		float nota_examen_clasico = 0;
		nota_examen_clasico = ((notas[1] + notas[2]) * 20 + notas[0] * 10) / 100;
		// (notas[0] * 10 / 100) + (notas[1] * 20 / 100) + (notas[2] * 20 / 100);
		return nota_examen_clasico;
	}

	// valicar la nota, Comprovar si la nota esta entre 0 y 10.
	public static boolean nota_valeda(float nota) {
		return (nota <= 10 && nota >= 0) ? false : true;
	}
}
