import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Entrada de datos
        System.out.print("Ingrese las 3 notas (Análisis, Diseño, Codificación): ");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double n3 = sc.nextDouble();

        System.out.print("Ingrese el % de avance y el número de errores: ");
        double avance = sc.nextDouble();
        int errores = sc.nextInt();

        System.out.print("¿Presentó documentación completa? (SI/NO): ");
        String doc = sc.next().trim();

        System.out.print("¿Realizó exposición final? (SI/NO): ");
        String expo = sc.next().trim();

        // 2. Cálculos
        double prom = (n1 + n2 + n3) / 3.0;
        double ajustes = -(errores * 0.5);

        if (doc.equalsIgnoreCase("SI")) {
            ajustes += 0.5;
        }
        if (expo.equalsIgnoreCase("SI")) {
            ajustes += 0.5;
        }

        double notaFinal = prom + ajustes;
        if (notaFinal > 10) notaFinal = 10;
        if (notaFinal < 0) notaFinal = 0;

        // 3. Determinar Estado
        String estado;
        if (notaFinal >= 9) {
            estado = "Excelente";
        } else if (notaFinal >= 7) {
            estado = "Aprobado";
        } else if (notaFinal >= 5) {
            estado = "Recuperación";
        } else {
            estado = "Reprobado";
        }

        // Restricción por avance
        if (avance < 60 && estado.equals("Excelente")) {
            estado = "Aprobado";
        }

        // 4. Salida de resultados
        System.out.println("\n----------------------------------");
        System.out.println("Promedio técnico: " + prom);
        System.out.println("Ajustes aplicados: " + ajustes);
        System.out.println("Nota final: " + notaFinal);
        System.out.println("Estado: " + estado);

        if (notaFinal >= 7 && doc.equalsIgnoreCase("NO")) {
            System.out.println("Observación: Buen producto, pero mala formalidad");
        }

        sc.close();
    }
}