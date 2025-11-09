package com.pruthvi.sqlAi.service.Impl;

import com.pruthvi.sqlAi.exception.SqlGenerationException;
import com.pruthvi.sqlAi.service.TextToSqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class TextToSqlServiceImpl implements TextToSqlService {

    private static final Logger logger = LoggerFactory.getLogger(TextToSqlServiceImpl.class);

    /**
     * Immutable database schema definition used in prompt.
     */
    private static final String DATABASE_SCHEMA = """
            Tables:
            - ai_services (id: int, name: string, provider: string, model: string, type: string,
              input_price_per_1k_tokens: decimal, output_price_per_1k_tokens: decimal,
              supports_sql: boolean, max_tokens: int, context_window: string,
              available: boolean, launched_at: date, description: text)
            """;

    private final ChatClient chatClient;

    public TextToSqlServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String generateSql(String question) {
        logger.info("Generating SQL for question {}", question);
        String prompt = """
                You are an SQL expert. Convert the natural language question into an SQL query.

                DATABASE SCHEMA:
                %s

                RULES:
                1. Use only the tables and columns from the provided schema.
                2. Return only the SQL query, without explanations.
                3. Use SELECT queries only for safety.
                4. Use clear and meaningful column names in the output.

                QUESTION: %s

                SQL Query:
                """.formatted(DATABASE_SCHEMA, question);

        try {
            var response = chatClient.prompt(prompt).call();
            String content = response.content();
            if (content == null || content.isBlank()) {
                throw new SqlGenerationException("OpenAI returned empty content");
            }
            String sql = content.trim();
            logger.debug("Generated SQL: {}", sql);
            return sql;
        } catch (SqlGenerationException e){
            throw e;
        } catch (Exception e) {
            logger.error("Error generating SQL: {}", e.getMessage(), e);
            throw new SqlGenerationException("Failed to generate SQL: " + e.getMessage(), e);
        }
    }

}
