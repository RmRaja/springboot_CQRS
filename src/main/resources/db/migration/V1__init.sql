CREATE TABLE users_my
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    name     VARCHAR(20)  NOT NULL,
    email    VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    , UNIQUE UK_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;