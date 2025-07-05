package com.kang.resume.ai.interfaces.web.response;

import lombok.Data;

@Data
public final class GenerateResumeResponse {
    /**
     * The name of the person.
     */
    private String name;
    /**
     * The furigana (phonetic Japanese reading) of the name.
     */
    private String furigana;
    /**
     * The birthday of the person.
     */
    private String birthday;
    /**
     * The gender of the person.
     */
    private String gender;
    /**
     * The address of the person.
     */
    private String address;
    /**
     * The phone number of the person.
     */
    private String phone;
    /**
     * The email address of the person.
     */
    private String email;
    /**
     * The period of the first history entry.
     */
    private String history1Period;
    /**
     * The content of the first history entry.
     */
    private String history1Content;
    /**
     * The period of the second history entry.
     */
    private String history2Period;
    /**
     * The content of the second history entry.
     */
    private String history2Content;
    /**
     * Licenses or qualifications held by the person.
     */
    private String license;
    /**
     * Public relations or self-promotion text.
     */
    private String pr;
}
