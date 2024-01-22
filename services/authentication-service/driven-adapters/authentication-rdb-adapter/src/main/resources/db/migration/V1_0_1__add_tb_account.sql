CREATE TABLE IF NOT EXISTS account (
    id                      UUID                            DEFAULT uuid_generate_v4(),
    username                VARCHAR(255),
    password                VARCHAR(255),
    salt                    VARCHAR(255),
    status                  VARCHAR(255) DEFAULT 'PENDING',
    created_at              TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP,

    CONSTRAINT pk_account PRIMARY KEY (id),
    CONSTRAINT uq_account_username UNIQUE (username),
    CONSTRAINT uq_account_salt UNIQUE (salt),
    CONSTRAINT valid_status CHECK ( status IN ('PENDING', 'ACTIVE', 'ADMIN', 'PROTECTED', 'SUSPENDED', 'SLEPT', 'REMOVED') )
);