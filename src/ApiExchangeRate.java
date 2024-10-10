import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiExchangeRate {

    private static final String API_KEY = "741b9f3e2930e3415c0d4d98"; // Tu clave API
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double obtenerTasa(String monedaOrigen, String monedaDestino) {
        try {
            URL url = new URL(BASE_URL + API_KEY + "/latest/" + monedaOrigen);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(con.getInputStream());
            Scanner scanner = new Scanner(reader);
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }

            // Parseo manual de la respuesta JSON
            String responseBody = response.toString();
            String conversionRatesKey = "\"conversion_rates\": {";
            int start = responseBody.indexOf(conversionRatesKey) + conversionRatesKey.length();
            int end = responseBody.indexOf("}", start);
            String conversionRates = responseBody.substring(start, end);
            String[] pairs = conversionRates.split(",");

            // Buscamos la tasa de conversión específica
            for (String pair : pairs) {
                if (pair.contains(monedaDestino)) {
                    String[] keyValue = pair.split(":");
                    return Double.parseDouble(keyValue[1].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0; // Si hubo un error al obtener la tasa
    }
}