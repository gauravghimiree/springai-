package com.gaurav.springai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {


  @Autowired
 private ChatClient chatClient;


  @GetMapping("/api/{message}")
  public String getAnswer(@PathVariable String message) {
    ChatResponse chatResponse = chatClient
            .prompt(message)
            .call()
            .chatResponse();
    System.out.println(chatResponse.getMetadata().getModel());
    String response = chatResponse
            .getResult()
            .getOutput()
            .getText();
    return  response;

  }
}
