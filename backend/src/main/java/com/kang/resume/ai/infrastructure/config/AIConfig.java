package com.kang.resume.ai.infrastructure.config;

import com.kang.resume.ai.application.ChatAiService;
import com.kang.resume.ai.domain.AiService;
import com.kang.resume.ai.infrastructure.clients.ChatAiClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kanghouchao
 */
@Configuration
class AIConfig {

    @Value("${app.openai.key}")
    private String apiKey;
    @Bean
    ChatModel chatModel() {
        return OpenAiChatModel.builder()
            .openAiApi(OpenAiApi.builder().apiKey(apiKey).build())
            .build();
    }

    @Bean
    AiService aiService(ChatAiClient chatAiClient) {
        return new ChatAiService(chatAiClient);
    }

    @Bean
    ChatAiClient chatAiClient(ChatModel chatModel) {
        return new ChatAiClient(chatModel);
    }
}
