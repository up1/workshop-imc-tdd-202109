package com.example.myapi.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PostGateway {

    @Autowired
    private RestTemplate restTemplate;

    // https://jsonplaceholder.typicode.com/posts/1
    public Optional<PostResponse> getPostById(int id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        try {
            PostResponse response =
                    restTemplate.getForObject(url, PostResponse.class);
            return Optional.ofNullable(response);
        }catch (RestClientException e) {
            return Optional.empty();
        }
    }

}

// RestTemplate, Feign/ OpenFeign, Retrofit
