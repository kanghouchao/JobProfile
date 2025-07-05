package com.kang.resume.ai.interfaces.web.request;

import lombok.Data;

@Data
public final class GenerateResumeRequest {
    /**
     * Description of personal experience for resume generation.
     */
    private String personalExperienceDescription;
}
