-- Crear base de datos
CREATE DATABASE Proyecto;


-- Crear usuario 'usuario_proyecto' si no existe
CREATE USER IF NOT EXISTS 'usuario_proyecto'@'localhost' IDENTIFIED BY 'la_Clave.';

-- Otorgar permisos completos sobre la base de datos Proyecto
GRANT ALL PRIVILEGES ON Proyecto.* TO 'usuario_proyecto'@'localhost';

-- Asegurar que los privilegios sean aplicados
FLUSH PRIVILEGES;

-- Usar la base de datos
USE Proyecto;

-- =========================
-- 1. TABLAS PRINCIPALES
-- =========================

-- Tabla Promociones
CREATE TABLE Promociones
(
    id_promocion INT AUTO_INCREMENT PRIMARY KEY,
    titulo       VARCHAR(255)   NOT NULL,
    descripcion  TEXT,
    precio       DECIMAL(10, 2) NOT NULL
);

-- Insertar promociones
INSERT INTO Promociones (titulo, descripcion, precio)
VALUES ('Descuento 10%', 'Descuento especial del 10% en productos seleccionados', 90.00),
       ('2x1 en Clases', 'Inscríbete en una clase y llévate otra gratis', 50.00),
       ('Black Friday', 'Ofertas especiales por tiempo limitado', 120.00);

-- Tabla Clases
CREATE TABLE Clases
(
    id_clase             INT AUTO_INCREMENT PRIMARY KEY,
    nombre_clase         VARCHAR(255) NOT NULL,
    instructor           VARCHAR(125) NOT NULL,
    dificultad           VARCHAR(35)  NOT NULL,
    tipo                 VARCHAR(35)  NOT NULL,
    usuarios_registrados INT DEFAULT 0,
    capacidad_maxima     INT          NOT NULL,
    horario              DATETIME     NOT NULL
);

-- Insertar clases
INSERT INTO Clases (nombre_clase, instructor, dificultad, tipo, capacidad_maxima, horario)
VALUES ('Yoga Avanzado', 'Ana Martinez', 'Avanzado', 'Presencial', 15, '2024-07-30 08:00:00'),
       ('Pilates Intermedio', 'Luis Fernandez', 'Intermedio', 'Online', 20, '2024-08-01 10:00:00'),
       ('Boxeo para principiantes', 'Pedro Gonzalez', 'Básico', 'Presencial', 10, '2024-08-03 18:00:00');

-- Tabla Productos
CREATE TABLE Productos
(
    id_articulo     INT AUTO_INCREMENT PRIMARY KEY,
    nombre_articulo VARCHAR(255)   NOT NULL,
    descripcion     TEXT           NOT NULL,
    img             VARCHAR(255),
    precio          DECIMAL(10, 2) NOT NULL,
    marca           VARCHAR(50)    NOT NULL,
    sexo            VARCHAR(20)    NOT NULL,
    talla           VARCHAR(5)
);

-- Insertar productos
INSERT INTO Productos (nombre_articulo, descripcion, img, precio, marca, sexo, talla)
VALUES ('Tenis Nike Rojas',
        'Tenis deportivos color rojo, ideales para correr y entrenamientos ligeros.',
        'img/nikeRoja.png',
        89.99,
        'Nike',
        'Unisex',
        '42'),
       ('Tenis Urbanos X',
        'Tenis urbanos de diseño casual con suela antideslizante. Perfectos para uso diario.',
        'img/regularShoes.png',
        59.99,
        'UrbanX',
        'Masculino',
        '43'),
       ('Reloj Deportivo G-Fit',
        'Reloj multifunción con cronómetro, pulsómetro y contador de calorías. Ideal para entrenamientos de gimnasio.',
        'img/reloj.png',
        120.00,
        'G-Fit',
        'Femenino',
        NULL);

-- Tabla Blog
CREATE TABLE Blog
(
    id_articulo_blog INT AUTO_INCREMENT PRIMARY KEY,
    titulo           VARCHAR(255) NOT NULL,
    img              VARCHAR(255), -- Ruta de la imagen
    contenido        TEXT         NOT NULL,
    categoria        VARCHAR(255) NOT NULL
);

-- Insertar artículos del blog
INSERT INTO Blog (titulo, img, contenido, categoria)
VALUES ('Beneficios del yoga', '/img/yoga.jpg', 'El yoga mejora la flexibilidad y reduce el estrés...', 'Salud'),
       ('Rutina de entrenamiento en casa', '/img/entrenamiento.jpg', 'Ejercicios fáciles para hacer sin equipo...',
        'Fitness'),
       ('Consejos para una alimentación saludable', '/img/alimentacion.jpg', 'Come más frutas y verduras...',
        'Nutrición');

-- Tabla Inscripciones
Create TABLE Inscripciones
(
    id_inscripcion INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_usuario     INT                NOT NULL,
    id_clase       INT                NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    FOREIGN KEY (id_clase) REFERENCES Clases (id_clase)
);

-- =========================
-- 2. SEGURIDAD Y USUARIOS
-- =========================

-- Crear usuario y otorgarle permisos
CREATE USER 'usuario_proyecto'@'localhost' IDENTIFIED BY 'la_Clave.';
GRANT ALL PRIVILEGES ON Proyecto.* TO 'usuario_proyecto'@'localhost';
FLUSH PRIVILEGES;

-- =========================
-- 3. TABLAS DE SEGURIDAD
-- =========================

-- Tabla de usuarios
CREATE TABLE usuario
(
    id_usuario INT          NOT NULL AUTO_INCREMENT,
    username   VARCHAR(20)  NOT NULL,
    password   VARCHAR(512) NOT NULL,
    nombre     VARCHAR(20)  NOT NULL,
    apellidos  VARCHAR(30)  NOT NULL,
    correo     VARCHAR(75),
    PRIMARY KEY (id_usuario)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- Tabla de roles
CREATE TABLE role
(
    rol VARCHAR(20),
    PRIMARY KEY (rol)
);

-- Tabla de relación entre usuario y rol
CREATE TABLE rol
(
    id_rol     INT NOT NULL AUTO_INCREMENT,
    nombre     VARCHAR(20),
    id_usuario INT,
    PRIMARY KEY (id_rol),
    FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- Tabla de rutas protegidas
CREATE TABLE ruta
(
    id_ruta  INT AUTO_INCREMENT NOT NULL,
    patron   VARCHAR(255)       NOT NULL,
    rol_name VARCHAR(50)        NOT NULL,
    PRIMARY KEY (id_ruta)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- Tabla de rutas permitidas
CREATE TABLE ruta_permit
(
    id_ruta INT AUTO_INCREMENT NOT NULL,
    patron  VARCHAR(255)       NOT NULL,
    PRIMARY KEY (id_ruta)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- Tabla de constantes
CREATE TABLE constante
(
    id_constante INT AUTO_INCREMENT NOT NULL,
    atributo     VARCHAR(25)        NOT NULL,
    valor        VARCHAR(150)       NOT NULL,
    PRIMARY KEY (id_constante)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4;

-- =========================
-- 4. DATOS DE SEGURIDAD Y ROLES
-- =========================

-- Insertar usuarios
INSERT INTO usuario (id_usuario, username, password, nombre, apellidos, correo)
VALUES (1, 'sebastian123', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'Sebastián',
        'Mendez Artavia', 'seb.vargas@gmail.com'),
       (2, 'fio', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Fiorella', 'Jaen Artavia',
        'fiorella.rj@hotmail.com'),
       (3, 'magnusx', '$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO', 'Magnus', 'Mendez Artavia',
        'magnus.alvarado@gmail.com');

-- Insertar roles base
INSERT INTO role (rol)
VALUES ('ADMIN'),
       ('VENDEDOR'),
       ('USER');

-- Relación usuario - roles
INSERT INTO rol (id_rol, nombre, id_usuario)
VALUES (1, 'ROLE_ADMIN', 1),
       (2, 'ROLE_VENDEDOR', 2),
       (3, 'ROLE_USER', 3),
       (4, 'ROLE_VENDEDOR', 2),
       (5, 'ROLE_USER', 2),
       (6, 'ROLE_USER', 3);

-- Rutas protegidas
INSERT INTO ruta (patron, rol_name)
VALUES ('/public/**', 'USER'),
       ('/public/**', 'ADMIN'),
       ('/private/**', 'ADMIN'),
       ('/private/blog/**', 'USER'),
       ('/private/clases/**', 'USER'),
       ('/private/perfil/**', 'USER'),
       ('/private/ServiciosAd/**', 'USER'),
       ('/private/ajustes/**', 'USER'),
       ('/private/home/**', 'USER'),
       ('/private/pago/**', 'USER');

-- Rutas públicas
INSERT INTO ruta_permit (patron)
VALUES ('/'),
       ('/index'),
       ('/errores/'),
       ('/public/**'),
       ('/registro/'),
       ('/js/'),
       ('/webjars/');

-- Constantes
INSERT INTO constante (atributo, valor)
VALUES ('dominio', 'localhost'),
       ('certificado', 'c:/cert'),
       ('dolar', '520.75'),
       ('paypal.client-id', 'AUjOjw5Q1I0QLTYjbvRS0j4Amd8xrUU2yL9UYyb3TOTcrazzd3G3lYRc6o7g9rOyZkfWEj2wxxDi0aRz'),
       ('paypal.client-secret', 'EMdb08VRlo8Vusd_f4aAHRdTE14ujnV9mCYPovSmXCquLjzWd_EbTrRrNdYrF1-C4D4o-57wvua3YD2u'),
       ('paypal.mode', 'sandbox'),
       ('urlPaypalCancel', 'http://localhost/payment/cancel'),
       ('urlPaypalSuccess', 'http://localhost/payment/success');
