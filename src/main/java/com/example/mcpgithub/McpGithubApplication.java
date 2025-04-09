package com.example.mcpgithub;

import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpGithubApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpGithubApplication.class, args);
    }

    @Bean
    public MethodToolCallbackProvider weatherTools(GithubService githubService) {
        return MethodToolCallbackProvider.builder().toolObjects(githubService).build();
    }


}
