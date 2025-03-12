CREATE DATABASE Proyecto;

-- Usar la base de datos
USE Proyecto;
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    tipo_plan VARCHAR(50) NOT NULL,
    fecha_expiracion_plan DATE NOT NULL
);

INSERT INTO usuarios (nombre, email, fecha_nacimiento, tipo_plan, fecha_expiracion_plan)  
VALUES ('El_señor de la noche', 'batimail@example.com', '1990-05-15', 'Premium', '2025-04-10');

-- Crear usuario y otorgarle permisos
CREATE USER 'usuario_proyecto'@'localhost' IDENTIFIED BY 'la_Clave.';
GRANT ALL PRIVILEGES ON Proyecto.* TO 'usuario_proyecto'@'localhost';
FLUSH PRIVILEGES;