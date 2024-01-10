package com.example.chatgptbasedcookingingredients;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.StreamingHttpOutputMessage;

import java.util.Collections;
import java.util.List;

public record ChatGPTRequest(
        String model,
        List<ChatGPTMessage> messages
)  {
    ChatGPTRequest(String message) {
        this("gpt-3.5-turbo", Collections.singletonList(new ChatGPTMessage("user", message)));
    }
}
