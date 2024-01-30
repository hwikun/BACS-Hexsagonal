CREATE TABLE IF NOT EXISTS option (
    id                      UUID                            DEFAULT uuid_generate_v4(),
    menu_id                 VARCHAR(255),
    option_name             VARCHAR(255),
    option_value            VARCHAR(255),
    option_price            INT                             DEFAULT 0,
    option_desc               VARCHAR(255)                    DEFAULT '',
    created_at              TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP,

    CONSTRAINT pk_option PRIMARY KEY (id),
    CONSTRAINT uq_menu_and_option_name_and_value UNIQUE (menu_id, option_name, option_value)
);