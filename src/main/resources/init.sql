CREATE TABLE games
(
    id            INT         NOT NULL AUTO_INCREMENT,
    name          VARCHAR(50) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    release_date  DATE        NOT NULL,
    rating        FLOAT       NULL DEFAULT NULL,
    cost          FLOAT       NOT NULL,
    description   TEXT        NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    type          VARCHAR(30) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    creation_date DATETIME    NOT NULL DEFAULT (now()),
    PRIMARY KEY (id) USING BTREE
);

INSERT INTO games (name, release_date, rating, cost, description, type)
VALUES ('Ferma', '2009-12-12', 7.3, 30.0, 'good game', 'adventure'),
       ('Sudoku', '2009-10-14', 8.9, 20.50, 'very good game', 'educational');