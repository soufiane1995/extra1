/**
 * <h1>Clase Examen Test</h1>
 * 
 * @author Alvaro y Soufiane
 * @version 1.3
 * 
 */

package notas;

import java.util.Scanner;

public class ExamenTest {
	public static Scanner stdin = new Scanner(System.in);

	private int preguntas_test;
	private int preguntas_bien;
	private int preguntas_mal;

	public ExamenTest() {
		setPreguntas_bien(0);
		setPreguntas_mal(0);
		setPreguntas_test(0);
	}

	public int getPreguntas_test() {
		return preguntas_test;
	}

	public void setPreguntas_test(int preguntas_test) {
		this.preguntas_test = preguntas_test;
	}

	public int getPreguntas_bien() {
		return preguntas_bien;
	}

	public void setPreguntas_bien(int preguntas_bien) {
		this.preguntas_bien = preguntas_bien;
	}

	public int getPreguntas_mal() {
		return preguntas_mal;
	}

	public void setPreguntas_mal(int preguntas_mal) {
		this.preguntas_mal = preguntas_mal;
	}

	public void examenTest() {
		System.out.println("		Exámenes de test");
		for (int i = 3; i <= 4; i++) {
			//examen_test(i);
		}
	}

	/*public void examen_test(int examen_test) {

		float nota_test;

		do {

			System.out.println("\nExamen " + (examen_test + 1));

			pedirnotas();

			setPreguntas_test(getPreguntas_bien() + getPreguntas_mal() + Preguntas_sin());

			if (getPreguntas_test() > 30 && getPreguntas_test() < 0) {
				System.out.println("	-- La suma de las preguntas de test tienen que ser 30!! --");
			}

			nota_test = getPreguntas_bien() - (((float) getPreguntas_mal()) / ((float) 3));
			// nota = 20 - 3/3

			if (nota_test < 0) {
				nota_test = 0;
			}

			System.out.println();
		} while (getPreguntas_test() != 30);

		float nota_examen_test = 0;

		nota_examen_test = nota_test * 30 / 100;

		System.out.println("	--> Nota del examen " + (examen_test + 1) + " : " + nota_examen_test);
		// nota_examen_test = (notas[3]*25/100)+(notas[4]*25/100);
	}
	
	// pedir las notas al usuario.
	public void pedirnotas() {
		int Preguntas_sin = 0;
		
		do {
			System.out.print("Cuantas preguntas estan bien? --> ");
			setPreguntas_bien(stdin.nextInt());

			System.out.print("Cuantas preguntas estan mal? --> ");
			setPreguntas_mal(stdin.nextInt());
			
			// calcular cuantas preguntas estan sin responder.
			/*Preguntas_sin(30 - (getPreguntas_bien() + getPreguntas_mal()));

			if (Preguntas_sin() < 0 || Preguntas_sin() > 30) {
				System.err.println(
						"	-- La suma de las preguntas de test tienen que ser 30!!  no = " + getPreguntas_sin());
			} else {
				System.out.print("Preguntas sin responder --> " + Preguntas_sin());
			}
		} while (Preguntas_sin() < 0 || Preguntas_sin() > 30);*/
	/*}*/

	public void Preguntas_sin() {
		
	}

}
