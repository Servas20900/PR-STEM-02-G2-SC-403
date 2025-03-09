CREATE DATABASE Proyecto;

-- Usar la base de datos
USE Proyecto;
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);


-- Crear usuario y otorgarle permisos
CREATE USER 'usuario_proyecto'@'localhost' IDENTIFIED BY 'la_Clave.';
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_proyecto'@'localhost';
FLUSH PRIVILEGES;