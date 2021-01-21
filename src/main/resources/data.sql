DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    career     VARCHAR(250) DEFAULT NULL
);

INSERT INTO user (first_name, last_name)
VALUES ('Aliko', 'Dangote'),
       ('Bill', 'Gates'),
       ('Folrunsho', 'Alakija');
