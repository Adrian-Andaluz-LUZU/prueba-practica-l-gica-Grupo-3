import java.util.Scanner;

public class EvaluacionProyecto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double analisis, diseno, codificacion, avance;
        int errores;
        String documentacion, exposicion;
        double promedio, ajustes, notaFinal;
        String estado, observacion = "";

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

        System.out.print("Presento documentacion completa (Si/No): ");
        documentacion = sc.next();

        System.out.print("Realizo exposicion final (Si/No): ");
        exposicion = sc.next();

        if (analisis < 0 || analisis > 10 ||
            diseno < 0 || diseno > 10 ||
            codificacion < 0 || codificacion > 10) {

            System.out.println("ERROR: Las notas deben estar entre 0 y 10");

        } else {
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

            if (avance < 60 && estado.equals("Excelente")) {
                estado = "Aprobado";
            }

            if (notaFinal >= 7 && documentacion.equalsIgnoreCase("No")) {
                observacion = "Buen producto, pero mala formalidad";
            }

            System.out.println("\nPromedio tecnico: " + promedio);
            System.out.println("Ajustes aplicados: " + ajustes);
            System.out.println("Nota final: " + notaFinal);
            System.out.println("Estado: " + estado);
            System.out.println("Observacion: " + observacion);
        }

        sc.close();
    }
}
