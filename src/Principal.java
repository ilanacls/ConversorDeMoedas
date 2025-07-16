import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
  public static void main(String[] args) throws IOException, InterruptedException {

    String apiKey = "fa284044c2af07dbd6bbaf79";
    var moedaBase = "USD";
    var moedaAlvo = "BRL";
    String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaBase + "/" + moedaAlvo;

    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build();

    HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());

    String json = response.body();
    System.out.println(json);

    Gson gson = new Gson();
    MoedasExchange minhaMoeda = gson.fromJson(json, MoedasExchange.class);
    System.out.println(minhaMoeda);

  }
}
