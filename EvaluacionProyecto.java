import java.util.Scanner;

public class EvaluacionProyecto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nota de analisis: ");
        double n1 = sc.nextDouble();
        System.out.print("Nota de diseno: ");
        double n2 = sc.nextDouble();
        System.out.print("Nota de codificacion: ");
        double n3 = sc.nextDouble();
        System.out.print("Porcentaje de avance real: ");
        double avance = sc.nextDouble();
        System.out.print("Numero de errores: ");
        int errores = sc.nextInt();
        System.out.print("¿Documentacion completa? (S/N): ");
        String doc = sc.next();
        System.out.print("¿Realizo exposicion final? (S/N): ");
        String expo = sc.next();

        double promedio = (n1 + n2 + n3) / 3;
        double ajustes = -(errores * 0.5);

        if (doc.equalsIgnoreCase("S")) ajustes += 0.5;
        if (expo.equalsIgnoreCase("S")) ajustes += 0.5;

        double notaFinal = promedio + ajustes;
        if (notaFinal > 10) notaFinal = 10;
        if (notaFinal < 0) notaFinal = 0;

        String estado;
        if (notaFinal >= 9 && avance < 60) {
            estado = "Aprobado";
        } else if (notaFinal >= 9) {
            estado = "Excelente";
        } else if (notaFinal >= 7) {
            estado = "Aprobado";
        } else if (notaFinal >= 5) {
            estado = "Recuperacion";
        } else {
            estado = "Reprobado";
        }

        String observacion = "Ninguna";
        if (notaFinal >= 8 && doc.equalsIgnoreCase("N")) {
            observacion = "Buen producto, pero mala formalidad";
        }

        System.out.println("Promedio tecnico: " + promedio);
        System.out.println("Ajustes aplicados: " + ajustes);
        System.out.println("Nota final: " + notaFinal);
        System.out.println("Estado: " + estado);
        System.out.println("Observacion: " + observacion);

        sc.close();
    }
}