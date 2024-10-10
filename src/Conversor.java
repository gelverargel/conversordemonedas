public class Conversor {

    public void convertir(double tasa, double cantidad, String monedaOrigen, String monedaDestino) {
        double resultado = cantidad * tasa;
        System.out.printf("%.2f %s son equivalentes a %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);
        ArchivoHelper.guardarConversion(cantidad, tasa, resultado, monedaOrigen, monedaDestino);
    }
}
