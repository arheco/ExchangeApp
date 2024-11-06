package ing.arturo.exchangeapp.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requester {

    private String apiKey = "93a0811d6c7ed1c8189cad54";

    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey
                    + "/latest/XXX"))
            .build();
    private HttpResponse<String> response;

    {
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

}





