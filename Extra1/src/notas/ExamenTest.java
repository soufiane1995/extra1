package notas;

public class ExamenTest extends NotasAlumnos {
	
	private static int preguntas_test, preguntas_bien, preguntas_mal, preguntas_sin;

	public static void examenTest() {
		System.out.println("		Exámenes de test");
		for (int i = 3; i <= 4; i++) {
			examen_test(i);
		}
	}
	
	public static void examen_test(int examen_test) {
		
		float nota_test;

		do {

			System.out.println("\nExamen " + (examen_test + 1));
			
			pedirnotas();

			preguntas_test = preguntas_bien + preguntas_mal + preguntas_sin;

			if (preguntas_test > 30 && preguntas_test < 0) {
				System.out.println("	-- La suma de las preguntas de test tienen que ser 30!! --");
			}
			
			nota_test = preguntas_bien - (((float)preguntas_mal)/((float)3));
			// nota = 20 - 3/3
			
			if (nota_test < 0) {
				nota_test = 0;
			}
			
			System.out.println();
		} while (preguntas_test != 30);
		
		float nota_examen_test = 0;

		nota_examen_test = nota_test * 30 / 100;

		System.out.println("	--> Nota del examen " + (examen_test + 1) + " : " + nota_examen_test);
		// nota_examen_test = (notas[3]*25/100)+(notas[4]*25/100);
	}

	public static void pedirnotas() {
		do {
			System.out.print("Cuantas preguntas estan bien? --> ");
			preguntas_bien = stdin.nextInt();

			System.out.print("Cuantas preguntas estan mal? --> ");
			preguntas_mal = stdin.nextInt();

			preguntas_sin = 30 - (preguntas_bien + preguntas_mal);

			if (preguntas_sin < 0 || preguntas_sin > 30) {
				System.err.println(
						"	-- La suma de las preguntas de test tienen que ser 30!!  no = " + preguntas_sin);
			} else {
				System.out.print("Preguntas sin responder --> " + preguntas_sin);
			}
		} while (preguntas_sin < 0 || preguntas_sin > 30);
		
	}
}

