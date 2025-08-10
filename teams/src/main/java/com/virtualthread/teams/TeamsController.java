package com.virtualthread.teams;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@RestController
public class TeamsController {


    private RestClient restClient;

    public TeamsController(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://localhost:8081")
                .build();
    }

    @GetMapping("/teams")
    public List<String> getTeams() {
        log.info("Current Thread: {}", Thread.currentThread().getName() + " is virtual thread : " + Thread.currentThread().isVirtual()) ;

        return restClient.get()
                .uri("/players")
                .retrieve()
                .body(List.class);
    }
}
