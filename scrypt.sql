CREATE DATABASE Proyecto;

-- Usar la base de datos
USE Proyecto;
-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    rol ENUM('Visitante', 'Miembro', 'Administrador') NOT NULL,
    telefono VARCHAR(20),
    direccion TEXT
);

-- Tabla Promociones
CREATE TABLE Promociones (
    id_promocion INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL
);

-- Tabla Clases
CREATE TABLE Clases (
    id_clase INT AUTO_INCREMENT PRIMARY KEY,
    nombre_clase VARCHAR(255) NOT NULL,
    descripcion TEXT,
    instructor VARCHAR(255) NOT NULL,
);

-- Tabla Servicios Adicionales
CREATE TABLE Servicios_Adicionales (
    id_articulo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_articulo VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    img VARCHAR(255) -- Ruta de la imagen
);

-- Tabla Blog
CREATE TABLE Blog (
    id_articulo_blog INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    img VARCHAR(255), -- Ruta de la imagen
    contenido TEXT NOT NULL,
    categoria VARCHAR(255)  NOT NULL

);

-- Crear usuario y otorgarle permisos
CREATE USER 'usuario_proyecto'@'localhost' IDENTIFIED BY 'la_Clave.';
GRANT ALL PRIVILEGES ON Proyecto.* TO 'usuario_proyecto'@'localhost';
FLUSH PRIVILEGES;