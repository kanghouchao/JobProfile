package com.kang.resume.ai.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kang.resume.ai.domain.AiService;
import com.kang.resume.ai.infrastructure.clients.ChatAiClient;
import com.kang.resume.ai.interfaces.web.response.GenerateResumeResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class ChatAiService implements AiService {

    private static final Logger log = LoggerFactory.getLogger(ChatAiService.class);

    private final ChatAiClient chatAiClient;
    private final ObjectMapper objectMapper;

    @Override
    public GenerateResumeResponse generateResponse(String userInfo) {
        final String jsonResponse = this.chatAiClient.getResumeJSON(userInfo);
        try {
            return objectMapper.readValue(jsonResponse, GenerateResumeResponse.class);
        } catch (final JsonProcessingException e) {
                                    log.error("Error processing JSON from AI: {}", jsonResponse, e);
            return new GenerateResumeResponse("", "", "", "", "", "", "", "", "", "", "", "", ""); // Return an empty response with default values
        }
    }
}
