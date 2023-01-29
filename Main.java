import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
String url="https://jsonplaceholder.typicode.com/albums";

    //Building a request
        HttpRequest request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

    //Getting a HttpClient object
        HttpClient client=HttpClient.newBuilder().build();

        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());


    }
}