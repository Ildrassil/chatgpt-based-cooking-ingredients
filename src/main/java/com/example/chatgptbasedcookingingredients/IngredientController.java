package com.example.chatgptbasedcookingingredients;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    public final ChatGptAPIService chatGptAPIService;
    @PostMapping
    String categorizeIngredient(@RequestBody String ingredient) {


        // TODO: This should return "vegan", "vegetarian" or "regular" depending on the ingredient.


        Map<String, String> ingredientMap = chatGptAPIService.filterIngredients(ingredient);

        return ingredientMap.entrySet().toString();
    }

    @PostMapping("/recipie")
    String buildRecipie(@RequestBody String ingredients){
        return chatGptAPIService.cookingList(ingredients);

    }
}
