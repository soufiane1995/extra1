package notas;

public class ExamenClasico extends NotasAlumnos {

	public static void examenClasico() {
		System.out.println("		Exámenes clasicos");
		for (int i = 0; i < 3; i++) {
				System.out.print("Ingrese la nota del exámen " + (i + 1) + " : ");
				notas[i] = stdin.nextFloat();

			if (nota_valeda(notas[i])) {
				System.err.println("\n			Error!!\n	Ingrese una nota válida (del 1 al 10)\n");
				--i;
			}
		}
	}
	
	public static float examen_clasico() {
		float nota_examen_clasico = 0;
		nota_examen_clasico = (notas[0] * 10 / 100) + (notas[1] * 20 / 100) + (notas[2] * 20 / 100);
		return nota_examen_clasico;
	}
}
