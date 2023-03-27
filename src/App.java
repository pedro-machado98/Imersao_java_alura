import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App{
    public static void main (String[] args) throws IOException, InterruptedException{
        
        //fazer conexao HTTP e retornar produtos
        // String url = "https://dummyjson.com/products";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requisicao =  HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> envia = client.send(requisicao, BodyHandlers.ofString());
        String body = envia.body();

        // System.out.println(body);

        //extrair os dados que me interessam (id, title, preço);

        JsonParser parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);
 
        for ( Map <String, String> filme : listaDeFilmes) { 
            System.out.println(filme.get("title "));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

        
    }

}