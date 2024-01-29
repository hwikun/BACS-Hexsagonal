CREATE TABLE IF NOT EXISTS category (
    id                      UUID                            DEFAULT uuid_generate_v4(),
    store_id                VARCHAR(255),
    category_name           VARCHAR(255),
    created_at              TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP,

    CONSTRAINT pk_category PRIMARY KEY (id),
    CONSTRAINT uq_store_and_category UNIQUE (store_id, category_name)
);