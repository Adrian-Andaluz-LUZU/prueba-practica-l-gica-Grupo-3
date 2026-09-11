import java.util.Scanner;

public class CompetenciaProgramacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double reto1, reto2, reto3, tiempo;
        int errores;
        String extra, copias;
        double puntajeBase, penalizacion, bonificacion = 0, puntajeFinal;
        String nivel, observacion = "";

        System.out.print("Puntaje reto 1: ");
        reto1 = sc.nextDouble();
        System.out.print("Puntaje reto 2: ");
        reto2 = sc.nextDouble();
        System.out.print("Puntaje reto 3: ");
        reto3 = sc.nextDouble();
        System.out.print("Numero de errores: ");
        errores = sc.nextInt();
        System.out.print("Tiempo total en minutos: ");
        tiempo = sc.nextDouble();
        System.out.print("Resolvio desafio extra (Si/No): ");
        extra = sc.next();
        System.out.print("Descalificado por copias (Si/No): ");
        copias = sc.next();

        puntajeBase = reto1 + reto2 + reto3;
        penalizacion = errores * 4;

        if (extra.equalsIgnoreCase("Si")) {
            bonificacion += 15;
        }

        if (tiempo < 30) {
            bonificacion += 10;
        }

        puntajeFinal = puntajeBase - penalizacion + bonificacion;

        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        if (puntajeFinal < 30) {
            nivel = "Principiante";
        } else if (puntajeFinal < 50) {
            nivel = "Basico";
        } else if (puntajeFinal < 70) {
            nivel = "Intermedio";
        } else if (puntajeFinal < 90) {
            nivel = "Avanzado";
        } else {
            nivel = "Experto";
        }

        if (copias.equalsIgnoreCase("Si")) {
            nivel = "Descalificado";
        }

        if (errores >= 3 && puntajeFinal >= 70) {
            observacion = "Resultado inconsistente; revisar calidad de resolucion";
        }

        System.out.println("\nPuntaje base: " + puntajeBase);
        System.out.println("Penalizacion: " + penalizacion);
        System.out.println("Bonificacion: " + bonificacion);
        System.out.println("Puntaje final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);
        System.out.println("Observacion: " + observacion);

        sc.close();
    }
}
