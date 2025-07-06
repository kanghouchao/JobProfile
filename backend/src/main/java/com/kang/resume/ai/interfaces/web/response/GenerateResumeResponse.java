package com.kang.resume.ai.interfaces.web.response;

public record GenerateResumeResponse(
    /**
     * The name of the person.
     */
    String name,
    /**
     * The furigana (phonetic Japanese reading) of the name.
     */
    String furigana,
    /**
     * The birthday of the person.
     */
    String birthday,
    /**
     * The gender of the person.
     */
    String gender,
    /**
     * The address of the person.
     */
    String address,
    /**
     * The phone number of the person.
     */
    String phone,
    /**
     * The email address of the person.
     */
    String email,
    /**
     * The period of the first history entry.
     */
    String history1Period,
    /**
     * The content of the first history entry.
     */
    String history1Content,
    /**
     * The period of the second history entry.
     */
    String history2Period,
    /**
     * The content of the second history entry.
     */
    String history2Content,
    /**
     * Licenses or qualifications held by the person.
     */
    String license,
    /**
     * Public relations or self-promotion text.
     */
    String pr
) {
}
