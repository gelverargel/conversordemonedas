import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorDeMoneda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        ApiExchangeRate api = new ApiExchangeRate();

        System.out.println("*******************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileño");
        System.out.println("4) Real brasileño =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Salir =>>");

        int opcion = obtenerOpcion(scanner);

        while (opcion != 7) {
            double cantidad = 0;
            boolean cantidadValida = false;

            while (!cantidadValida) {
                try {
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese la cantidad en Dólares: ");
                            cantidad = scanner.nextDouble();
                            cantidadValida = true;
                            conversor.convertir(api.obtenerTasa("USD", "ARS"), cantidad, "Dólar", "Peso argentino");
                            break;
                        case 2:
                            System.out.print("Ingrese la cantidad en Pesos argentinos: ");
                            cantidad = scanner.nextDouble();
                            cantidadValida = true;
                            conversor.convertir(api.obtenerTasa("ARS", "USD"), cantidad, "Peso argentino", "Dólar");
                            break;
                        case 3:
                            System.out.print("Ingrese la cantidad en Dólares: ");
                            cantidad = scanner.nextDouble();
                            cantidadValida = true;
                            conversor.convertir(api.obtenerTasa("USD", "BRL"), cantidad, "Dólar", "Real brasileño");
                            break;
                        case 4:
                            System.out.print("Ingrese la cantidad en Reales brasileños: ");
                            cantidad = scanner.nextDouble();
                            cantidadValida = true;
                            conversor.convertir(api.obtenerTasa("BRL", "USD"), cantidad, "Real brasileño", "Dólar");
                            break;
                        case 5:
                            System.out.print("Ingrese la cantidad en Dólares: ");
                            cantidad = scanner.nextDouble();
                            cantidadValida = true;
                            conversor.convertir(api.obtenerTasa("USD", "COP"), cantidad, "Dólar", "Peso colombiano");
                            break;
                        case 6:
                            System.out.print("Ingrese la cantidad en Pesos colombianos: ");
                            cantidad = scanner.nextDouble();
                            cantidadValida = true;
                            conversor.convertir(api.obtenerTasa("COP", "USD"), cantidad, "Peso colombiano", "Dólar");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); // Limpiar entrada
                }
            }

            System.out.println("*******************************************************");
            System.out.println("Elija una opción válida:");
            opcion = obtenerOpcion(scanner);
        }

        System.out.println("¡Gracias por usar el Conversor de Moneda!");
        scanner.close();
    }

    private static int obtenerOpcion(Scanner scanner) {
        int opcion = 0;
        boolean opcionValida = false;

        while (!opcionValida) {
            try {
                System.out.print("Elija una opción válida: ");
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 7) {
                    opcionValida = true;
                } else {
                    System.out.println("Opción inválida. Por favor, elija entre 1 y 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar entrada
            }
        }

        return opcion;
    }
}