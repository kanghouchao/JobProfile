package com.kang.resume.ai.infrastructure.config;

import com.kang.resume.ai.application.ChatAiService;
import com.kang.resume.ai.domain.AiService;
import com.kang.resume.ai.infrastructure.clients.ChatAiClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

/**
 * @author kanghouchao
 */
@Configuration
class AIConfig {

    /**
     * OpenAI API key, loaded from application properties.
     */
    @Value("${app.openai.key}")
    private String apiKey;

    /**
     * Provides an ObjectMapper bean for JSON processing.
     *
     * @return The configured ObjectMapper.
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    /**
     * Provides a ChatModel bean for OpenAI chat interactions.
     *
     * @return The configured ChatModel.
     */
    @Bean
    ChatModel chatModel() {
        return OpenAiChatModel.builder()
            .openAiApi(OpenAiApi.builder().apiKey(apiKey).build())
            .build();
    }

    /**
     * Provides an AiService bean.
     *
     * @param chatAiClient The ChatAiClient dependency.
     * @param objectMapper The ObjectMapper dependency.
     * @return The configured AiService.
     */
    @Bean
    AiService aiService(final ChatAiClient chatAiClient,
                        final ObjectMapper objectMapper) {
        return new ChatAiService(chatAiClient, objectMapper);
    }

    /**
     * Provides a ChatAiClient bean.
     *
     * @param chatModel The ChatModel dependency.
     * @return The configured ChatAiClient.
     */
    @Bean
    ChatAiClient chatAiClient(final ChatModel chatModel) {
        return new ChatAiClient(chatModel);
    }
}
