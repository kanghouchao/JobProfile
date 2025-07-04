package com.kang.resume.ai.infrastructure.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;

/**
 * @author kanghouchao
 */
@RequiredArgsConstructor
public class ChatAiClient {

    private final ChatModel chatModel;

    private final static String RESUME_PROMPT = """
        请扮演一个有关简历生成的专家，我会给你一段关于用户的个人经历的描述，请你根据这些信息生成JSON格式的简历内容。
        请注意，JSON格式的内容必须是有效的JSON格式，不能有任何语法错误。
        另外，我只需要JSON格式的内容，不需要任何其他的文字描述。
        也绝对不要使用markdown格式。直接给我字符串格式的JSON内容。
        请严格按照以下JSON结构生成内容，如果某些字段没有对应信息，请留空字符串或空数组：
        {
          "name": "",
          "furigana": "",
          "birthday": "",
          "gender": "",
          "address": "",
          "phone": "",
          "email": "",
          "history1_period": "",
          "history1_content": "",
          "history2_period": "",
          "history2_content": "",
          "license": "",
          "pr": ""
        }
        现在我需要处理的用户信息是：
        """;

    public String getResumeJSON(String userInfo) {
        final ChatClient client = ChatClient.create(this.chatModel);
        return client.prompt(RESUME_PROMPT + userInfo).call().content();
    }
}
