DROP DATABASE IF EXISTS cinemar;
CREATE DATABASE cinemar;
USE cinemar;

CREATE TABLE pelicula (
                id_pelicula INT AUTO_INCREMENT NOT NULL,
                titulo_pelicula VARCHAR(30) NOT NULL,
                genero_pelicula INT NOT NULL,
                tipo_pelicula INT NOT NULL,
                resumen_pelicula VARCHAR(250) NOT NULL,
                duracion_pelicula TIME NOT NULL,
                horario_pelicula TIME NOT NULL,
                estado_pelicula BOOLEAN NOT NULL,
                butacas_pelicula INT NOT NULL,
                PRIMARY KEY (id_pelicula)
);


CREATE TABLE sala (
                id_sala INT AUTO_INCREMENT NOT NULL,
                id_pelicula INT,
                tipo_sala BOOLEAN NOT NULL,
                nombre_sala VARCHAR(10) NOT NULL,
                estado_sala BOOLEAN NOT NULL,
                PRIMARY KEY (id_sala)
);


CREATE TABLE usuario (
                id_usuario INT AUTO_INCREMENT NOT NULL,
                nombre_usuario VARCHAR(15) NOT NULL,
                apellido_usuario VARCHAR(15) NOT NULL,
                email_usuario VARCHAR(40) NOT NULL,
                password_usuario VARCHAR(12) NOT NULL,
                tipo_usuario INT NOT NULL,
                tarjeta_usuario BOOLEAN NOT NULL,
                estado_usuario BOOLEAN NOT NULL,
                PRIMARY KEY (id_usuario)
);


CREATE TABLE reserva (
                id_reserva INT AUTO_INCREMENT NOT NULL,
                id_sala INT NOT NULL,
                id_pelicula INT,
                id_usuario INT,
                cant_butacas INT NOT NULL,
                PRIMARY KEY (id_reserva)
);


CREATE TABLE descuento (
                id_descuento INT AUTO_INCREMENT NOT NULL,
                id_reserva INT,
                porcentaje_descuento INT NOT NULL,
                PRIMARY KEY (id_descuento)
);


ALTER TABLE sala ADD CONSTRAINT pelicula_sala_fk
FOREIGN KEY (id_pelicula)
REFERENCES pelicula (id_pelicula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE reserva ADD CONSTRAINT pelicula_reserva_fk
FOREIGN KEY (id_pelicula)
REFERENCES pelicula (id_pelicula)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE reserva ADD CONSTRAINT sala_reserva_fk
FOREIGN KEY (id_sala)
REFERENCES sala (id_sala)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE reserva ADD CONSTRAINT usuario_reserva_fk
FOREIGN KEY (id_usuario)
REFERENCES usuario (id_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE descuento ADD CONSTRAINT reserva_descuento_fk
FOREIGN KEY (id_reserva)
REFERENCES reserva (id_reserva)
ON DELETE NO ACTION
ON UPDATE NO ACTION;