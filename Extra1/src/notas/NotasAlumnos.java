package notas;

import java.util.Scanner;

/**
 * <h1>Clase notas de alumnos</h1>
 * 
 * @author Alvaro y Soufiane
 * @version 1.0
 * 
 */

public class NotasAlumnos {
	public static Scanner stdin = new Scanner(System.in);
	public static float prom;
	public static float[] notas;
	
    public static int Menu ()
    {
        int opcion;
        do {
        	System.out.println("\n1. Añadir nota trabajos.");
            System.out.println ("2. Añadir notas examenes clasicos.");
            System.out.println ("3. Añadir notas examenes test.");
            System.out.println ("4. Calcular promedio.");
            System.out.println ("5. Get out.");
            System.out.print ("Introduce opcion (1..4) --> ");
            opcion = stdin.nextInt();
            if (opcion == 5) {
				System.out.println("by");
			}
            
        }while (opcion < 1 || opcion > 5);
        return opcion;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    	NotasAlumnos notas = new NotasAlumnos();
        int    opcion;

         while ((opcion = Menu ()) != 5)
            switch (opcion)
            {
                 case 1: 
                         break;
                 case 2: 
                         break;
                 case 3: 
                    break;
                 case 4: 
                    break;

           }


    }
		

	public static boolean nota_valeda(float nota) {
		return (nota <= 10 && nota >= 0) ? false : true;
	}

}