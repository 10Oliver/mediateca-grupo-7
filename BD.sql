DROP DATABASE mediateca;
CREATE DATABASE mediateca;

use mediateca;

CREATE TABLE editorial (
                           id_editorial INT NOT NULL AUTO_INCREMENT,
                           nombre_editorial VARCHAR(100) NOT NULL,
                           contacto VARCHAR(100) NOT NULL,
                           telefono VARCHAR(20) NOT NULL,
                           PRIMARY KEY (id_editorial),
                           INDEX (nombre_editorial)
);

CREATE TABLE generos (
                         id_genero INT NOT NULL AUTO_INCREMENT,
                         nombre_genero VARCHAR(50) NOT NULL,
                         dvd_or_cd BOOL NOT NULL,
                         PRIMARY KEY (id_genero),
                         INDEX(nombre_genero)
);

CREATE TABLE autor (
                       id_autor INT NOT NULL AUTO_INCREMENT,
                       nombre_autor VARCHAR(100) NOT NULL,
                       nacionalidad VARCHAR(100) NOT NULL,
                       PRIMARY KEY (id_autor),
                       INDEX(nombre_autor)
);

CREATE TABLE artista (
                         id_artista INT NOT NULL AUTO_INCREMENT,
                         nombre_artista VARCHAR(100) NOT NULL,
                         PRIMARY KEY (id_artista),
                         INDEX (nombre_artista)
);

CREATE TABLE libros (
                        id_libro INT NOT NULL AUTO_INCREMENT,
                        codigo_identificacion VARCHAR(20) NOT NULL,
                        titulo VARCHAR(100) NOT NULL,
                        id_autor INT NOT NULL,
                        num_paginas INT NOT NULL,
                        id_editorial INT NOT NULL,
                        ISBN INT NOT NULL,
                        anio_publicacion INT NOT NULL,
                        unidades_disponibles INT NOT NULL,
                        PRIMARY KEY (id_libro),
                        CONSTRAINT fk_libros_editorial
                            FOREIGN KEY (id_editorial)
                                REFERENCES editorial (id_editorial),
                        CONSTRAINT fk_libros_autor
                            FOREIGN KEY (id_autor)
                                REFERENCES autor (id_autor)
                                ON DELETE CASCADE
                                ON UPDATE CASCADE
);

CREATE TABLE revistas (
                          id_revista INT NOT NULL AUTO_INCREMENT,
                          codigo_identificacion VARCHAR(20) NOT NULL,
                          titulo VARCHAR(100) NOT NULL,
                          id_editorial INT NOT NULL,
                          periodicidad VARCHAR(50) NOT NULL,
                          fecha_publicacion VARCHAR(100) NOT NULL,
                          unidades_disponibles INT NOT NULL,
                          PRIMARY KEY (id_revista),
                          CONSTRAINT fk_revistas_editorial
                              FOREIGN KEY (id_editorial)
                                  REFERENCES editorial (id_editorial)
                                  ON DELETE CASCADE
                                  ON UPDATE CASCADE
);

CREATE TABLE cds (
                     id_cd INT NOT NULL AUTO_INCREMENT,
                     codigo_identificacion VARCHAR(20) NOT NULL,
                     titulo VARCHAR(100) NOT NULL,
                     id_artista INT NOT NULL,
                     id_genero INT NOT NULL,
                     duracion VARCHAR(100) NOT NULL,
                     num_canciones INT NOT NULL,
                     unidades_disponibles INT NOT NULL,
                     PRIMARY KEY (id_cd),
                     CONSTRAINT fk_cds_artista
                         FOREIGN KEY (id_artista)
                             REFERENCES artista (id_artista),
                     CONSTRAINT fk_cds_genero
                         FOREIGN KEY (id_genero)
                             REFERENCES generos (id_genero)
                             ON DELETE CASCADE
                             ON UPDATE CASCADE
);

CREATE TABLE dvds (
                      id_dvd INT NOT NULL AUTO_INCREMENT,
                      codigo_identificacion VARCHAR(20) NOT NULL,
                      titulo VARCHAR(100) NOT NULL,
                      director VARCHAR(100) NOT NULL,
                      duracion VARCHAR(100) NOT NULL,
                      id_genero INT NOT NULL,
                      unidades_disponibles INT NOT NULL,
                      PRIMARY KEY (id_dvd),
                      CONSTRAINT fk_dvds_genero
                          FOREIGN KEY (id_genero)
                              REFERENCES generos (id_genero)
                              ON DELETE CASCADE
                              ON UPDATE CASCADE
);


-- Trigger para generar el código de identificación de libros
DELIMITER //
CREATE TRIGGER libros_before_insert_trigger
    BEFORE INSERT ON libros
    FOR EACH ROW
BEGIN
    DECLARE next_id INT;
    SET next_id = (SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='libros');
    SET NEW.codigo_identificacion = CONCAT('LIB', LPAD(next_id, 5, '0'));
END //
DELIMITER ;



-- Trigger para generar el código de identificación de revistas
DELIMITER //
CREATE TRIGGER revistas_before_insert_trigger
    BEFORE INSERT ON revistas
    FOR EACH ROW
BEGIN
    DECLARE id INT;
    SET id = (SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='revistas');
    SET NEW.codigo_identificacion = CONCAT('REV', LPAD(id, 5, '0'));
END //
DELIMITER ;

-- Trigger para generar el código de identificación de CDs
DELIMITER //
CREATE TRIGGER cds_before_insert_trigger
    BEFORE INSERT ON cds
    FOR EACH ROW
BEGIN
    DECLARE id INT;
    SET id = (SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='cds');
    SET NEW.codigo_identificacion = CONCAT('CDA', LPAD(id, 5, '0'));
END //
DELIMITER ;

-- Trigger para generar el código de identificación de DVDs
DELIMITER //
CREATE TRIGGER dvds_before_insert_trigger
    BEFORE INSERT ON dvds
    FOR EACH ROW
BEGIN
    DECLARE id INT;
    SET id = (SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='dvds');
    SET NEW.codigo_identificacion = CONCAT('DVD', LPAD(id, 5, '0'));
END //
DELIMITER ;

INSERT INTO editorial (nombre_editorial, contacto, telefono) VALUES ('Editorial Name', 'Contact Name', '123-456-7890');
INSERT INTO generos (nombre_genero, dvd_or_cd) VALUES ('Genre Name', 1);
INSERT INTO autor (nombre_autor, nacionalidad) VALUES ('Author Name', 'Nationality');
INSERT INTO artista (nombre_artista) VALUES ('Artist Name');

INSERT INTO libros (titulo, id_autor, num_paginas, id_editorial, ISBN, anio_publicacion, unidades_disponibles)
VALUES ('Example Title', 1, 250, 1, 1234567, 2023, 10);
INSERT INTO libros (titulo, id_autor, num_paginas, id_editorial, ISBN, anio_publicacion, unidades_disponibles)
VALUES ('Example Title', 1, 250, 1, 1234567, 2023, 10);
INSERT INTO libros (titulo, id_autor, num_paginas, id_editorial, ISBN, anio_publicacion, unidades_disponibles)
VALUES ('Example Title', 1, 250, 1, 1234567, 2023, 10);
INSERT INTO libros (titulo, id_autor, num_paginas, id_editorial, ISBN, anio_publicacion, unidades_disponibles)
VALUES ('Example Title', 1, 250, 1, 1234567, 2023, 10);
INSERT INTO libros (titulo, id_autor, num_paginas, id_editorial, ISBN, anio_publicacion, unidades_disponibles)
VALUES ('Example Title', 1, 250, 1, 1234567, 2023, 10);

INSERT INTO revistas (titulo, id_editorial, periodicidad, fecha_publicacion, unidades_disponibles)
VALUES ('Title of Magazine', 1, 'Monthly', '2023-10-01', 100);
INSERT INTO revistas (titulo, id_editorial, periodicidad, fecha_publicacion, unidades_disponibles)
VALUES ('Title of Magazine', 1, 'Monthly', '2023-10-01', 100);
INSERT INTO revistas (titulo, id_editorial, periodicidad, fecha_publicacion, unidades_disponibles)
VALUES ('Title of Magazine', 1, 'Monthly', '2023-10-01', 100);
INSERT INTO revistas (titulo, id_editorial, periodicidad, fecha_publicacion, unidades_disponibles)
VALUES ('Title of Magazine', 1, 'Monthly', '2023-10-01', 100);


INSERT INTO cds (titulo, id_artista, id_genero, duracion, num_canciones, unidades_disponibles)
VALUES ('Title of CD', 1, 1, '60 mins', 12, 50);
INSERT INTO cds (titulo, id_artista, id_genero, duracion, num_canciones, unidades_disponibles)
VALUES ('Title of CD', 1, 1, '60 mins', 12, 50);
INSERT INTO cds (titulo, id_artista, id_genero, duracion, num_canciones, unidades_disponibles)
VALUES ('Title of CD', 1, 1, '60 mins', 12, 50);
INSERT INTO cds (titulo, id_artista, id_genero, duracion, num_canciones, unidades_disponibles)
VALUES ('Title of CD', 1, 1, '60 mins', 12, 50);

INSERT INTO dvds (titulo, director, duracion, id_genero, unidades_disponibles)
VALUES ('Title of DVD', 'Director Name', '120 mins', 1, 30);
INSERT INTO dvds (titulo, director, duracion, id_genero, unidades_disponibles)
VALUES ('Title of DVD', 'Director Name', '120 mins', 1, 30);
INSERT INTO dvds (titulo, director, duracion, id_genero, unidades_disponibles)
VALUES ('Title of DVD', 'Director Name', '120 mins', 1, 30);
INSERT INTO dvds (titulo, director, duracion, id_genero, unidades_disponibles)
VALUES ('Title of DVD', 'Director Name', '120 mins', 1, 30);



SELECT * FROM libros;
SELECT * FROM revistas;
SELECT * FROM dvds;
SELECT * FROM cds;