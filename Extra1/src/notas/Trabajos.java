package notas;


public class Trabajos extends Alumno {
	private static boolean entregado = false;
	private float suma;
	private double nota;

	// Pedimos al usuario que indique si los trabajos han sido entregados
	public static void trabajoEntregado() {
		System.out.println("¿Han sido entregados todos los trabajos?");
		int opcion = 0;
		do {
			System.out.println("\n1.Si.");
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
	public static double notaTrabajo() {
		trabajoEntregado();
		
		int i = 0;
		double notaTrabajo[];
		
		notaTrabajo = new double[4];
		
		if (entregado) {
			do {
				System.out.print("Ingrese la nota del trabajo " + (i+1) + " --> ");
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
			
			System.out.println("\nMedia de los trabajos: " + mediaTrabajo);
			
			return mediaTrabajo;
		} else { // Si no han sido entregados los trabajos
			System.out.println("NOTA FINAL: 3. \n Directo a Julio.");
			return 3;
		}
	}

}

