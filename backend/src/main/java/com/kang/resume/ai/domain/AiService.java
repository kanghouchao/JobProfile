package com.kang.resume.ai.domain;

import com.kang.resume.ai.interfaces.web.response.GenerateResumeResponse;

/**
 * Service interface for AI-related operations.
 */
public interface AiService {

    /**
     * Generates a resume response based on user information.
     *
     * @param userInfo User's personal experience description.
     * @return Generated resume data.
     */
    GenerateResumeResponse generateResponse(String userInfo);

}
