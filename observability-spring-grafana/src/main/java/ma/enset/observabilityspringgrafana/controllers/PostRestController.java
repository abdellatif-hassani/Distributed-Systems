package ma.enset.observabilityspringgrafana.controllers;

import lombok.AllArgsConstructor;
import ma.enset.observabilityspringgrafana.model.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
    private RestClient restClient;

    public PostRestController(RestClient.Builder restClient) {
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @GetMapping({"/", ""})
    public List<Post> posts() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {
                });
    }
}
