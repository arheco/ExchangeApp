package ing.arturo.exchangeapp.modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Requester {
    private String apiKey = "93a0811d6c7ed1c8189cad54";

    public String getApiKey() {
        return apiKey;
    }

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/"+getApiKey()
                    +"/latest/USD"))
            .build();

    public HttpRequest getRequest() {
        return request;
    }
}
