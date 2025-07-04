package com.kang.resume.ai.domain;

/**
 * @author kanghouchao
 */
import com.kang.resume.ai.interfaces.web.response.GenerateResumeResponse;

/**
 * @author kanghouchao
 */
public interface AiService {

    GenerateResumeResponse generateResponse(String userInfo);

}
