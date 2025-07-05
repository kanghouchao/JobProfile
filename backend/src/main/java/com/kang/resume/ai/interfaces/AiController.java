package com.kang.resume.ai.interfaces;

import com.kang.resume.ai.domain.AiService;
import com.kang.resume.ai.interfaces.web.request.GenerateResumeRequest;
import com.kang.resume.ai.interfaces.web.response.GenerateResumeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kanghouchao
 */
@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public final class AiController {

    /**
     * Service for AI operations.
     */
    private final AiService aiService;

    /**
     * Generates a resume response based on the provided request.
     *
     * @param request The request containing personal experience description.
     * @return The generated resume response.
     */
    @PostMapping("/generate")
    public GenerateResumeResponse generateResponse(@RequestBody final GenerateResumeRequest request) {
        return aiService.generateResponse(request.personalExperienceDescription());
    }
}
