package com.back.shared.post.out;

import com.back.shared.post.dto.PostDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class PostApiClient {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:8080/post/api/v1")
            .build();

    public List<PostDto> getItems() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public PostDto getItem(int id) {
        return restClient.get()
                .uri("/posts/%d".formatted(id))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
