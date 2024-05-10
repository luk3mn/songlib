package com.alura.songlib;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class GptService {
    public static String getInfo(String texto) {
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_APIKEY"));


        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("Tell me about the artist: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        var resposta = service.createCompletion(request);
        return resposta.getChoices().get(0).getText();
    }
}
