CREATE TABLE IF NOT EXISTS ai_services (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    provider VARCHAR(255),
    model VARCHAR(255),
    type VARCHAR(50),
    input_price_per_1k_tokens NUMERIC,
    output_price_per_1k_tokens NUMERIC,
    supports_sql BOOLEAN,
    max_tokens INTEGER,
    context_window VARCHAR(20),
    available BOOLEAN,
    launched_at DATE,
    description TEXT
);

INSERT INTO ai_services (name, provider, model, type, input_price_per_1k_tokens, output_price_per_1k_tokens, supports_sql, max_tokens, context_window, available, launched_at, description)
VALUES
('ChatGPT 4 Turbo', 'OpenAI', 'gpt-4-turbo', 'chat', 0.0100, 0.0300, true, 128000, '128k', true, '2023-11-06', 'High-context GPT-4 Turbo model used for chat and SQL tasks'),
('Claude 3 Opus', 'Anthropic', 'claude-3-opus', 'chat', 0.0150, 0.0750, true, 200000, '200k', true, '2024-03-01', 'Claude 3 Opus with advanced reasoning'),
('Claude 3 Haiku', 'Anthropic', 'claude-3-haiku', 'chat', 0.0003, 0.0013, true, 200000, '200k', true, '2024-03-01', 'Fast and affordable Claude model'),
('Gemini 1.5 Pro', 'Google', 'gemini-1.5-pro', 'chat', 0.0050, 0.0150, true, 1000000, '1M', true, '2024-02-15', 'Massive context model from Google'),
('Mistral 7B Instruct', 'Local', 'mistral-7b-instruct', 'text-gen', 0.0000, 0.0000, false, 32768, '32k', true, '2023-10-01', 'Open source model for local inference'),
('GPT-3.5 Turbo', 'OpenAI', 'gpt-3.5-turbo', 'chat', 0.0005, 0.0015, true, 16000, '16k', true, '2022-11-30', 'Lightweight chat model for fast inference'),
('Claude 3.5 Sonnet', 'Anthropic', 'claude-3-5-sonnet', 'chat', 0.0020, 0.0060, true, 200000, '200k', true, '2024-08-15', 'Improved performance with better reasoning than Claude 3 Opus at a lower price point'),
('Claude 3.7 Sonnet', 'Anthropic', 'claude-3-7-sonnet', 'chat', 0.0030, 0.0090, true, 200000, '200k', true, '2025-02-19', 'Advanced reasoning-focused model with improved accuracy and capabilities'),
('GPT-4o', 'OpenAI', 'gpt-4o', 'chat', 0.0050, 0.0150, true, 128000, '128k', true, '2024-05-13', 'Optimized model balancing speed, quality and cost with multimodal capabilities'),
('GPT-4o mini', 'OpenAI', 'gpt-4o-mini', 'chat', 0.0015, 0.0050, true, 128000, '128k', true, '2024-05-13', 'Smaller and more affordable multimodal model with fast response times'),
('Gemini 1.5 Flash', 'Google', 'gemini-1.5-flash', 'chat', 0.0002, 0.0006, true, 1000000, '1M', true, '2024-04-10', 'Cost-effective variant of Gemini 1.5 with improved performance over previous models'),
('Gemini 1.5 Ultra', 'Google', 'gemini-1.5-ultra', 'chat', 0.0100, 0.0300, true, 2000000, '2M', true, '2024-07-18', 'Google''s most advanced model with expanded context and superior reasoning'),
('Llama 3 70B', 'Meta', 'llama-3-70b', 'text-gen', 0.0000, 0.0000, false, 128000, '128k', true, '2024-04-18', 'Meta''s most powerful open model with strong reasoning capabilities'),
('Mistral Large', 'Mistral AI', 'mistral-large', 'chat', 0.0080, 0.0240, true, 128000, '128k', true, '2024-02-26', 'Advanced model from Mistral with strong reasoning and coding capabilities'),
('Mistral Small', 'Mistral AI', 'mistral-small', 'chat', 0.0020, 0.0060, true, 32000, '32k', true, '2024-02-26', 'Cost-effective Mistral model for general text tasks'),
('Claude 3 Sonnet', 'Anthropic', 'claude-3-sonnet', 'chat', 0.0030, 0.0090, true, 200000, '200k', true, '2024-03-01', 'Balanced Claude model offering strong reasoning at moderate cost'),
('Cohere Command R+', 'Cohere', 'command-r-plus', 'chat', 0.0050, 0.0150, true, 128000, '128k', true, '2024-05-20', 'Advanced reasoning model with superior long-context information retrieval'),
('Anthropic Claude Code', 'Anthropic', 'claude-code', 'code', 0.0050, 0.0150, true, 200000, '200k', true, '2024-09-10', 'Specialized Claude model for software development tasks with improved code reasoning');
