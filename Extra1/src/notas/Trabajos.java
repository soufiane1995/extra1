package notas;

package notas;

public class Trabajos extends NotasAlumnos {

	private static boolean entregado = false;
	private static float suma, nota ;

	public static void entrega() {
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
		trabajoEntregado();
	}

	public static void trabajoEntregado() {
			
		if (entregado) {
			for (int i = 0; i < 3 ; i++) {
				System.out.print("Nota Trabajo " + (i + 1) + ": ");
				nota = stdin.nextInt();
				suma += nota;
			}
		} else {
			System.out.println("NOTA FINAL: 3. \n Directo a Julio.");
		}
	}
	
	public static void notaMediaTrabajos() {
		float notaMedia = 0;
		notaMedia = suma/3;
	}

	public static void main(String[] args) {
		entrega();
	}
}

