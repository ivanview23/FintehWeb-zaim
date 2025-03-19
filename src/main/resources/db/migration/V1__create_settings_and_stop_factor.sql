-- 001_create_settings_table.sql
CREATE TABLE settings (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    value FLOAT NOT NULL
);

-- 003_create_stop_factor_table.sql
CREATE TABLE stop_factor (
    id SERIAL PRIMARY KEY,
    value FLOAT NOT NULL,
    calculated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);