import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class weatherApi {
        public static void main(String[] args) throws Exception {
            String url="https://api.weatherbit.io/v2.0/current?city=pune&country=india&state=maharashtra&key=023d416032a7441ba6713f0205554914";

            //Building a request
            HttpRequest request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            //Getting a HttpClient object
            HttpClient client=HttpClient.newBuilder().build();

            HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());



    }
}
