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

-- Insertar usuarios
INSERT INTO Usuarios (nombre, correo, contraseña, rol, telefono, direccion) VALUES
('Juan Perez', 'juan.perez@email.com', 'clave123', 'Administrador', '555-1234', 'Calle Falsa 123'),
('Maria Lopez', 'maria.lopez@email.com', 'clave456', 'Miembro', '555-5678', 'Av. Siempre Viva 742'),
('Carlos Gomez', 'carlos.gomez@email.com', 'clave789', 'Visitante', '555-9876', 'Boulevard Central 55');

-- Tabla Promociones
CREATE TABLE Promociones (
    id_promocion INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL
);

-- Insertar promociones
INSERT INTO Promociones (titulo, descripcion, precio) VALUES
('Descuento 10%', 'Descuento especial del 10% en productos seleccionados', 90.00),
('2x1 en Clases', 'Inscríbete en una clase y llévate otra gratis', 50.00),
('Black Friday', 'Ofertas especiales por tiempo limitado', 120.00);


-- Tabla Clases
CREATE TABLE Clases (
    id_clase INT AUTO_INCREMENT PRIMARY KEY,
    nombre_clase VARCHAR(255) NOT NULL,
    instructor VARCHAR(125) NOT NULL,
    dificultad VARCHAR(35) NOT NULL,
    tipo VARCHAR(35) NOT NULL,
    horario DATETIME NOT NULL
);

-- Insertar clases
INSERT INTO Clases (nombre_clase, instructor, dificultad, tipo, horario) VALUES
('Yoga Avanzado', 'Ana Martinez', 'Avanzado', 'Presencial', '2024-07-30 08:00:00'),
('Pilates Intermedio', 'Luis Fernandez', 'Intermedio', 'Online', '2024-08-01 10:00:00'),
('Boxeo para principiantes', 'Pedro Gonzalez', 'Básico', 'Presencial', '2024-08-03 18:00:00');

CREATE TABLE Asistencia_Clases(
	id_asistencia INT AUTO_INCREMENT PRIMARY KEY,
    id_clase INT NOT NULL,
    capacidad_maxima INT NOT NULL,
    usuarios_registrados INT NOT NULL,
    FOREIGN KEY(id_clase) REFERENCES Clases(id_clase)
);


-- Insertar asistencia a clases
INSERT INTO Asistencia_Clases (id_clase, capacidad_maxima, usuarios_registrados) VALUES
(1, 20, 10),
(2, 15, 8),
(3, 12, 5);

-- Tabla Productos
CREATE TABLE Productos (
    id_articulo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_articulo VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    img VARCHAR(255), -- Ruta de la imagen
	precio DECIMAL(10, 2) NOT NULL,
	marca VARCHAR(50) NOT NULL,
    sexo VARCHAR(20) NOT NULL,
    talla VARCHAR(5),
    categoria VARCHAR(55) NOT NULL
);
	
-- Tabla Blog
CREATE TABLE Blog (
    id_articulo_blog INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    img VARCHAR(255), -- Ruta de la imagen
    contenido TEXT NOT NULL,
    categoria VARCHAR(255)  NOT NULL
);


INSERT INTO Blog (titulo, img, contenido, categoria) VALUES
('Beneficios del yoga', '/img/yoga.jpg', 'El yoga mejora la flexibilidad y reduce el estrés...', 'Salud'),
('Rutina de entrenamiento en casa', '/img/entrenamiento.jpg', 'Ejercicios fáciles para hacer sin equipo...', 'Fitness'),
('Consejos para una alimentación saludable', '/img/alimentacion.jpg', 'Come más frutas y verduras...', 'Nutrición');    

-- Crear usuario y otorgarle permisos
CREATE USER 'usuario_proyecto'@'localhost' IDENTIFIED BY 'la_Clave.';
GRANT ALL PRIVILEGES ON Proyecto.* TO 'usuario_proyecto'@'localhost';
FLUSH PRIVILEGES;
