CREATE TABLE IF NOT EXISTS menu (
    id                      UUID                            DEFAULT uuid_generate_v4(),
    category_id             VARCHAR(255),
    menu_name               VARCHAR(255),
    menu_price              INT                             DEFAULT 0,
    menu_desc               VARCHAR(255)                    DEFAULT '',
    menu_img                VARCHAR(255)                    DEFAULT '',
    created_at              TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP,

    CONSTRAINT pk_menu PRIMARY KEY (id),
    CONSTRAINT uq_category_and_menu UNIQUE (category_id, menu_name)
);