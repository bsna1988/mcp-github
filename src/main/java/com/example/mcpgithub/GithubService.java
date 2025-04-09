package com.example.mcpgithub;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {
    @Value("${github.token}")
    private String githubToken;

    @Tool(description = "Get information about code repos")
    public String getRepos() {
        // call the Github API to get information about code repos
        String url = "https://api.github.com/user/repos";

        // Create RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Set up headers with authentication token
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + githubToken);

        // Create the request entity
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make the GET request
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Return the response body
        return responseEntity.getBody();
    }

}
