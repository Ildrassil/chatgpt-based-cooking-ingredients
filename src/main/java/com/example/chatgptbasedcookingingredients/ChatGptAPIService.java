package com.example.chatgptbasedcookingingredients;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGptAPIService {

    private final RestClient restClient;

    public ChatGptAPIService(@Value("${app.chatgpt.api.url}") String url,
                             @Value("${app.chatgpt.api.key}") String key,
                             @Value("${app.chatgpt.api.org}") String org){
        restClient = RestClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer " + key)
                .defaultHeader("OpenAi-Organization",org)
                .build();
    }
    public Map<String,String> filterIngredients(String ingredient){
    Map<String, String> ingredientMap = new HashMap<>();

        ChatGptResponse response = restClient.post()
                .uri("/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ChatGPTRequest("chooseIf" + ingredient +"isVeganVegetarianorRegularOneWord"))
                .retrieve()
                .body(ChatGptResponse.class);
        if(!response.text().isEmpty()){
          ingredientMap.put(ingredient, response.text());}
    return ingredientMap;
    }

    
}
