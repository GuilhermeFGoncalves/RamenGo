package ramenGo.com.demo.web.adapters;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RedVenturesAdapter {

    public static String getOrderId() throws Exception{
        try {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.tech.redventures.com.br/orders/generate-id"))
                .POST(HttpRequest.BodyPublishers.ofString("")) // Empty body for POST
                .header("x-api-key", "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());

        return jsonObject.getString("orderId");
        } catch (Exception e){
            throw new Exception("could not place order");
        }
    }
}
