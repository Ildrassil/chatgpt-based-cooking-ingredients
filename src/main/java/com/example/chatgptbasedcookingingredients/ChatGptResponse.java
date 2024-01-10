package com.example.chatgptbasedcookingingredients;

import java.util.List;

public record ChatGptResponse(
        List<ChatGPTChoice> choices
) {
    public String text() {
        return choices.get(0).message().content();
    }
}

