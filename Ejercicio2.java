import java.util.Scanner;
//Mateo Salazar//
public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double analisis, diseno, codificacion;
        double avance, promedio, ajustes, notaFinal;
        int errores;
        String documentacion, exposicion;
        String estado, observacion;

        System.out.print("Nota de analisis: ");
        analisis = sc.nextDouble();

        System.out.print("Nota de diseno: ");
        diseno = sc.nextDouble();

        System.out.print("Nota de codificacion: ");
        codificacion = sc.nextDouble();

        System.out.print("Porcentaje de avance real: ");
        avance = sc.nextDouble();

        System.out.print("Numero de errores: ");
        errores = sc.nextInt();

        System.out.print("¿Documentacion completa? (Si/No): ");
        documentacion = sc.next();

        System.out.print("¿Realizo exposicion final? (Si/No): ");
        exposicion = sc.next();

        promedio = (analisis + diseno + codificacion) / 3;

        ajustes = errores * -0.5;

        if (documentacion.equalsIgnoreCase("Si")) {
            ajustes += 0.5;
        }

        if (exposicion.equalsIgnoreCase("Si")) {
            ajustes += 0.5;
        }

        notaFinal = promedio + ajustes;

        if (notaFinal > 10) {
            notaFinal = 10;
        }

        if (notaFinal < 0) {
            notaFinal = 0;
        }

        if (notaFinal >= 9) {
            estado = "Excelente";
        } else if (notaFinal >= 7) {
            estado = "Aprobado";
        } else if (notaFinal >= 5) {
            estado = "Recuperacion";
        } else {
            estado = "Reprobado";
        }

        if (avance < 60) {
            estado = "Revision";
        }

        if (notaFinal >= 7 && documentacion.equalsIgnoreCase("No")) {
            observacion = "Buen producto, pero mala formalidad.";
        } else {
            observacion = "Resultado normal.";
        }

        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Promedio tecnico: " + promedio);
        System.out.println("Ajustes aplicados: " + ajustes);
        System.out.println("Nota final: " + notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observacion: " + observacion);

        sc.close();
    }
}
