import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaración de variables
        double reto1, reto2, reto3, errores, tiempo;
        String desafio, copia, nivel;
        double puntajeBase, penalizacion, bonificacion, puntajeFinal;

        // Entrada de datos con validación para evitar números negativos
        reto1 = leerNumeroValido(scanner, "Ingrese puntaje del reto 1: ");
        reto2 = leerNumeroValido(scanner, "Ingrese puntaje del reto 2: ");
        reto3 = leerNumeroValido(scanner, "Ingrese puntaje del reto 3: ");
        errores = leerNumeroValido(scanner, "Ingrese número de errores: ");
        tiempo = leerNumeroValido(scanner, "Ingrese tiempo total en minutos: ");

        System.out.print("Resolvió desafío extra (SI/NO): ");
        desafio = scanner.next().trim();

        System.out.print("Descalificado por copia (SI/NO): ");
        copia = scanner.next().trim();

        // Procesos y Cálculos
        puntajeBase = reto1 + reto2 + reto3;
        penalizacion = errores * 4;
        bonificacion = 0;

        if (desafio.equalsIgnoreCase("SI")) {
            bonificacion = bonificacion + 15;
        }

        if (tiempo < 30) {
            bonificacion = bonificacion + 10;
        }

        puntajeFinal = puntajeBase - penalizacion + bonificacion;

        if (puntajeFinal < 0) {
            puntajeFinal = 0;
        }

        // Estructura condicional anidada para determinar el nivel
        if (puntajeFinal <= 29) {
            nivel = "Principiante";
        } else {
            if (puntajeFinal <= 49) {
                nivel = "Básico";
            } else {
                if (puntajeFinal <= 69) {
                    nivel = "Intermedio";
                } else {
                    if (puntajeFinal <= 89) {
                        nivel = "Avanzado";
                    } else {
                        nivel = "Experto";
                    }
                }
            }
        }

        if (copia.equalsIgnoreCase("SI")) {
            nivel = "Descalificado";
        }

        // Salidas
        System.out.println("----------------------------------");
        System.out.println("Puntaje Base: " + puntajeBase);
        System.out.println("Penalización: " + penalizacion);
        System.out.println("Bonificación: " + bonificacion);
        System.out.println("Puntaje Final: " + puntajeFinal);
        System.out.println("Nivel: " + nivel);

        if (puntajeFinal >= 70 && errores >= 5) {
            System.out.println("Observación: Resultado inconsistente: revisar calidad de resolución");
        }

        scanner.close();
    }

    // Método auxiliar para validar datos numéricos
    private static double leerNumeroValido(Scanner sc, String mensaje) {
        double valor;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()) {
                System.out.println("Error: Ingrese un valor numérico válido.");
                sc.next();
                System.out.print(mensaje);
            }
            valor = sc.nextDouble();
            if (valor < 0) {
                System.out.println("Error: El valor no puede ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }
}