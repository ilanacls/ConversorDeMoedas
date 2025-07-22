import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversaoDeValor {

  private static final String apiKey = "fa284044c2af07dbd6bbaf79";

  public static String converterMoeda(String moedaOrigem, String moedaDestino, double valor) {
    String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaOrigem;

    try {

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(endereco))
          .build();

      HttpResponse<String> response = client
          .send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body();

      JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
      JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
      double taxa = rates.get(moedaDestino).getAsDouble();
      double valorConvertido = valor * taxa;

      return String.format("O valor: %.2f %s foi convertido para: %.2f %s com taxa de: %.4f", valor, moedaOrigem, valorConvertido, moedaDestino, taxa);
    } catch(Exception e) {
      throw new RuntimeException("Erro ao converter moeda: " + e.getMessage());
    }

  }

}



