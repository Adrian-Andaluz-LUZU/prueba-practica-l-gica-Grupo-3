import java.util.Scanner;
//Mateo Salazar//
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int reto1, reto2, reto3;
        int errores, tiempo;
        int puntajeBase, penalizacion, bonificacion, puntajeFinal;
        String extra, copia;
        String nivel, observacion;

        // Datos de entrada
        System.out.print("Ingrese puntaje del reto 1: ");
        reto1 = sc.nextInt();

        System.out.print("Ingrese puntaje del reto 2: ");
        reto2 = sc.nextInt();

        System.out.print("Ingrese puntaje del reto 3: ");
        reto3 = sc.nextInt();

        System.out.print("Ingrese numero de errores: ");
        errores = sc.nextInt();

        System.out.print("Ingrese tiempo total en minutos: ");
        tiempo = sc.nextInt();

        System.out.print("¿Resolvio el desafio extra? (Si/No): ");
        extra = sc.next();

        System.out.print("¿Fue descalificado por copia? (Si/No): ");
        copia = sc.next();

        // Puntaje base
        puntajeBase = reto1 + reto2 + reto3;

        // Penalizacion
        penalizacion = errores * 4;

        // Bonificacion
        bonificacion = 0;

        if (extra.equalsIgnoreCase("Si")) {
            bonificacion = bonificacion + 15;
        }

        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        // Puntaje final
        puntajeFinal = puntajeBase - penalizacion + bonificacion;

        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // Determinar nivel
        if (copia.equalsIgnoreCase("Si")) {
            nivel = "Descalificado";
        } else if (puntajeFinal <= 29) {
            nivel = "Principiante";
        } else if (puntajeFinal <= 49) {
            nivel = "Basico";
        } else if (puntajeFinal <= 69) {
            nivel = "Intermedio";
        } else if (puntajeFinal <= 89) {
            nivel = "Avanzado";
        } else {
            nivel = "Experto";
        }

        // Determinar observacion
        if (copia.equalsIgnoreCase("Si")) {
            observacion = "Participante descalificado por copia.";
        } else if (puntajeFinal >= 70 && errores >= 5) {
            observacion = "Resultado inconsistente: revisar calidad de resolucion.";
        } else {
            observacion = "Resultado valido.";
        }

        // Mostrar resultados
        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Puntaje base: " + puntajeBase);
        System.out.println("Penalizacion: " + penalizacion);
        System.out.println("Bonificacion: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observacion: " + observacion);

        sc.close();
    }
}
