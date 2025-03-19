-- Создание таблицы для хранения JSON данных заявок
CREATE TABLE request_content (
    id SERIAL PRIMARY KEY,
    reg_person JSONB NOT NULL,
    credit_bureau JSONB NOT NULL
);
