import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoHelper {

    public static void guardarConversion(double cantidad, double tasa, double resultado, String monedaOrigen, String monedaDestino) {
        String conversionJson = String.format(
                "{\"cantidad\": %.2f, \"tasa\": %.4f, \"resultado\": %.2f, \"monedaOrigen\": \"%s\", \"monedaDestino\": \"%s\"}%n",
                cantidad, tasa, resultado, monedaOrigen, monedaDestino
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("conversiones.json", true))) {
            writer.write(conversionJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}