package com.example.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {DemoApplication.class} ,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
@ActiveProfiles("test")
public class SpringBootExampleTest {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PostsService postsService;

    @Test
    public void testGetUsers() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8083/user/all", String.class);
        assertEquals("[{\"name\":\"petya\"}]", response.getBody());
    }

    @Test
    public void testMockedPosts() {
        String response = "[\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }]";

        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();

        WireMock.stubFor(WireMock.get("/posts").willReturn(ok()
                .withHeader("content-type", "application/json")
                .withBody(response)));

        PostsService.ListEntity[] result = postsService.getPosts();
        assertEquals(1, result.length);
    }

}
