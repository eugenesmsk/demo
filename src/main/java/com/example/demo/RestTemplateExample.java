package com.example.demo;

import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateExample {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://jsonplaceholder.typicode.com/posts";
        ResponseEntity<ListEntity[]> response = restTemplate.getForEntity(url, ListEntity[].class);
        System.out.println(response.getStatusCode());
        for (ListEntity entity : response.getBody()) {
            System.out.println(entity.title);
        }
    }

    @Setter
    public static class ListEntity {
        private int userId;
        private int id;
        private String title;
        private String body;
    }

}
