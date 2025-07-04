package com.kang.resume.ai.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kang.resume.ai.domain.AiService;
import com.kang.resume.ai.infrastructure.clients.ChatAiClient;
import com.kang.resume.ai.interfaces.web.response.GenerateResumeResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class ChatAiService implements AiService {

    private final ChatAiClient chatAiClient;
    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public GenerateResumeResponse generateResponse(String userInfo) {
        String jsonResponse = this.chatAiClient.getResumeJSON(userInfo);
        return objectMapper.readValue(jsonResponse, GenerateResumeResponse.class);
    }
}
