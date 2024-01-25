CREATE TABLE IF NOT EXISTS store (
    id                      UUID                            DEFAULT uuid_generate_v4(),
    username                VARCHAR(255),
    store_name              VARCHAR(255),
    address                 VARCHAR(255),
    store_digit             VARCHAR(255),
    status                  VARCHAR(255) DEFAULT 'ACTIVE',
    created_at              TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP,

    CONSTRAINT pk_store PRIMARY KEY (id),
    CONSTRAINT uq_store_username UNIQUE (username),
    CONSTRAINT valid_status CHECK ( status IN ('ACTIVE','PROTECTED', 'SUSPENDED', 'REMOVED') )
);