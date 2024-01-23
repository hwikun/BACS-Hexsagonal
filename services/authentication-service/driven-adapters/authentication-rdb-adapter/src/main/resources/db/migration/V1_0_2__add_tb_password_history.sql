CREATE TABLE IF NOT EXISTS password_history (
    id                      UUID                            DEFAULT uuid_generate_v4(),
    username                VARCHAR(255),
    password                VARCHAR(255),
    created_at              TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP,

    CONSTRAINT pk_password_history PRIMARY KEY (id),
    CONSTRAINT uq_password_history_password UNIQUE (password)
);