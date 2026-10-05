CREATE DATABASE IF NOT EXISTS red_social;

USE red_social;

CREATE TABLE IF NOT EXISTS usuarios (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(50) NOT NULL,

    apellido_paterno VARCHAR(50) NOT NULL,

    apellido_materno VARCHAR(50) NOT NULL,

    correo VARCHAR(100) NOT NULL UNIQUE,

    usuario VARCHAR(50) NOT NULL UNIQUE,

    password VARCHAR(100) NOT NULL,

    fecha_nacimiento DATE NOT NULL

    );