create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table pelicula (
	id INT(11) NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	autor VARCHAR(100) NOT NULL,
	descripcion VARCHAR(100) NOT NULL,
	esta_reservada CHAR(1) NOT NULL DEFAULT 'F',
	PRIMARY KEY (id)
);

create table reserva (
	id INT(11) NOT NULL AUTO_INCREMENT,
	valor DOUBLE NOT NULL,
	fecha_reserva DATETIME NOT NULL,
	fecha_devolucion DATETIME NOT NULL,
	tipo_reserva VARCHAR(15) NOT NULL,
	pelicula_id INT(11) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_pelicula_id FOREIGN KEY (pelicula_id) REFERENCES pelicula(id)
);