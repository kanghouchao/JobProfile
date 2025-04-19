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
        请扮演一个有关简历生成的专家，我会给你一段关于用户的基本信息、学历和工作经历的描述，请你根据这些信息生成JSON格式的简历内容
        例如：
        我现在给一个关于名叫张三的用户的信息，他25岁，学历是本科，工作经验3年，技能包括Java、Spring和MySQL，
        他参与过一个项目，项目名称是项目1，时间是2020年1月到2020年12月，角色是开发，负责的工作包括需求分析、
        设计数据库和开发功能模块。
        现在请你根据这些信息生成一段关于张三的简历的JSON格式的内容，我希望你能给我一个完整的JSON格式的简历内容，包含以下字段：
        {
            "name": "张三",
            "age": 25,
            "education": "本科",
            "workExperience": "3年",
            "skills": ["Java", "Spring", "MySQL"],
            "projects": [
                {
                    "name": "项目1",
                    "duration": "2020.01-2020.12",
                    "role": "开发",
                    "responsibilities": ["负责需求分析", "设计数据库", "开发功能模块"]
                }
            ]
        }
        请注意，JSON格式的内容必须是有效的JSON格式，不能有任何语法错误。
        另外，我只需要JSON格式的内容，不需要任何其他的文字描述。
        也绝对不要使用markdown格式。直接给我字符串格式的JSON内容。
        现在我需要处理的用户信息是：
        """;

    public String getResumeJSON(String userInfo) {
        final ChatClient client = ChatClient.create(this.chatModel);
        return client.prompt(RESUME_PROMPT + userInfo).call().content();
    }
}
