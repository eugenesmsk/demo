package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final RestTemplate restTemplate;
    @Value("${posts.url}")
    private String postsUrl;

    public ListEntity[] getPosts() {
        ResponseEntity<ListEntity[]> response = restTemplate.getForEntity(postsUrl, ListEntity[].class);
        return response.getBody();
    }

    @Setter
    public static class ListEntity {
        private int userId;
        private int id;
        private String title;
        private String body;
    }

}
