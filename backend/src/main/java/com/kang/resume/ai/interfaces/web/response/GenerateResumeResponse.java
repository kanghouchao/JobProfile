package com.kang.resume.ai.interfaces.web.response;

import lombok.Data;

@Data
public class GenerateResumeResponse {
    private String name;
    private String furigana;
    private String birthday;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String history1_period;
    private String history1_content;
    private String history2_period;
    private String history2_content;
    private String license;
    private String pr;
}
