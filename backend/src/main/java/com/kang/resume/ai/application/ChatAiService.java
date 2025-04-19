package com.kang.resume.ai.application;

import com.kang.resume.ai.domain.AiService;
import com.kang.resume.ai.infrastructure.clients.ChatAiClient;
import lombok.RequiredArgsConstructor;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class ChatAiService implements AiService {

    private final ChatAiClient chatAiClient;

    @Override
    public String generateResponse(String userInfo) {
        return this.chatAiClient.getResumeJSON(userInfo);
    }
}
