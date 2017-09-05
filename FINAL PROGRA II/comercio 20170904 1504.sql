﻿--
-- Script was generated by Devart dbForge Studio for MySQL, Version 7.2.78.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 4/9/2017 3:04:54 p. m.
-- Server version: 5.5.5-10.1.25-MariaDB
-- Client version: 4.1
--


-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

-- 
-- Set default database
--
USE comercio;

--
-- Definition for table categoria
--
DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
  codigo INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(40) NOT NULL,
  descripcion LONGTEXT NOT NULL,
  PRIMARY KEY (codigo)
)
ENGINE = INNODB
AUTO_INCREMENT = 15
AVG_ROW_LENGTH = 2048
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table cliente
--
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
  NIT INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(40) NOT NULL,
  apellido VARCHAR(40) NOT NULL,
  telefono VARCHAR(30) NOT NULL,
  ciudad VARCHAR(25) NOT NULL,
  direccion VARCHAR(55) NOT NULL,
  empresa VARCHAR(55) NOT NULL,
  PRIMARY KEY (NIT)
)
ENGINE = INNODB
AUTO_INCREMENT = 692
AVG_ROW_LENGTH = 4096
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table pedidos
--
DROP TABLE IF EXISTS pedidos;
CREATE TABLE pedidos (
  codigo INT(11) NOT NULL AUTO_INCREMENT,
  cliente INT(11) NOT NULL,
  fecha_pedido DATETIME NOT NULL,
  fecha_entrega DATETIME NOT NULL,
  destinatario VARCHAR(55) NOT NULL,
  direccion_destinatario VARCHAR(65) NOT NULL,
  ciudad_destinatario VARCHAR(55) NOT NULL,
  PRIMARY KEY (codigo)
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table proveedores
--
DROP TABLE IF EXISTS proveedores;
CREATE TABLE proveedores (
  codigo INT(11) NOT NULL AUTO_INCREMENT,
  empresa VARCHAR(50) NOT NULL,
  contacto VARCHAR(25) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  ciudad VARCHAR(25) NOT NULL,
  pais VARCHAR(25) NOT NULL,
  telefono VARCHAR(25) NOT NULL,
  fax VARCHAR(25) NOT NULL,
  web LONGTEXT NOT NULL,
  PRIMARY KEY (codigo)
)
ENGINE = INNODB
AUTO_INCREMENT = 6
AVG_ROW_LENGTH = 3276
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table productos
--
DROP TABLE IF EXISTS productos;
CREATE TABLE productos (
  codigo INT(11) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  proveedor INT(11) NOT NULL,
  categoria INT(11) NOT NULL,
  precio DOUBLE NOT NULL,
  fechaVencimiento DATE NOT NULL,
  stock INT(11) NOT NULL,
  stockMinimo INT(11) NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT FK_productos_categoria_codigo FOREIGN KEY (categoria)
    REFERENCES categoria(codigo) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT FK_productos_proveedores_codigo FOREIGN KEY (proveedor)
    REFERENCES proveedores(codigo) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 28
AVG_ROW_LENGTH = 1170
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table venta
--
DROP TABLE IF EXISTS venta;
CREATE TABLE venta (
  codigo INT(11) NOT NULL AUTO_INCREMENT,
  fechaVenta DATE NOT NULL,
  NIT INT(11) NOT NULL,
  cliente VARCHAR(55) NOT NULL,
  codigo_pedidos INT(11) NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT FK_venta_cliente_NIT FOREIGN KEY (NIT)
    REFERENCES cliente(NIT) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_venta_pedidos_codigo FOREIGN KEY (codigo_pedidos)
    REFERENCES pedidos(codigo) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

--
-- Definition for table detalleventa
--
DROP TABLE IF EXISTS detalleventa;
CREATE TABLE detalleventa (
  codigo INT(11) NOT NULL AUTO_INCREMENT,
  codigoProducto INT(11) NOT NULL,
  cantidad INT(11) NOT NULL,
  codigoVenta INT(11) NOT NULL,
  PRIMARY KEY (codigo),
  CONSTRAINT FK_detalleventa_productos_codigo FOREIGN KEY (codigoProducto)
    REFERENCES productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_detalleventa_venta_codigo FOREIGN KEY (codigoVenta)
    REFERENCES venta(codigo) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = INNODB
AUTO_INCREMENT = 1
CHARACTER SET utf8
COLLATE utf8_general_ci;

-- 
-- Dumping data for table categoria
--
INSERT INTO categoria VALUES
(6, 'pintura', 'pintura para paredes'),
(7, 'tiner', 'sustancia controlada'),
(8, 'brochas', 'objeto para pintar'),
(9, 'pintura especial', 'delicada'),
(10, 'pintura para casa', 'paredes'),
(11, 'pinturas automotivas', 'algo delicadas'),
(12, 'pinturas en aerosol', 'en lata'),
(13, 'productos para madera', 'especial para madera'),
(14, 'complementos', 'de todo');

-- 
-- Dumping data for table cliente
--
INSERT INTO cliente VALUES
(123, 'Alex', 'pacoli', '4259880', '', '', ''),
(234, 'Ale', 'rosa', '4259880', 'tarija', '', ''),
(345, 'andrea', 'torrico', '4890039', 'cochabamba', '', ''),
(690, 'julio', 'andrade', '4785203', 'cochabamba', '', ''),
(691, 'andres', 'martes', '4699870', 'Santa Cruz', '', '');

-- 
-- Dumping data for table pedidos
--

-- Table comercio.pedidos does not contain any data (it is empty)

-- 
-- Dumping data for table proveedores
--
INSERT INTO proveedores VALUES
(1, 'coral', '', 'calle Rosas', 'Cochabamba', 'Bolivia', '4258739', '', ''),
(2, 'salsar', '', 'AV.BlancoGalindo', 'Cochabamba', 'Bolivia', '4268743', '', ''),
(3, 'Suarez', '', 'AV.America', 'Cochabamba', 'Bolivia', '4987503', '', ''),
(4, 'American Chemical', '', 'Primer anillo', 'Santa Cruz', 'Bolivia', '4987742', '', ''),
(5, 'Ducryll', '', 'Jordan n° 734', 'Cochabamba', 'Bolivia', '4300157', '', '');

-- 
-- Dumping data for table productos
--
INSERT INTO productos VALUES
(13, 'pintura azul', 1, 6, 30, '2020-10-13', 20, 0),
(14, 'pintura roja', 1, 6, 30, '2020-10-13', 20, 0),
(15, 'pintura verde', 1, 6, 30, '2020-10-13', 20, 0),
(16, 'pintura morada', 1, 6, 30, '2020-10-13', 20, 0),
(17, 'pintura negra', 1, 6, 30, '2020-10-13', 20, 0),
(18, 'pintura rosa', 1, 6, 30, '2020-10-13', 20, 0),
(19, 'pintura rosa', 2, 9, 60, '2020-10-13', 70, 0),
(20, 'pintura dorada', 2, 9, 60, '2020-10-13', 70, 0),
(21, 'pintura bronce', 2, 9, 60, '2020-10-13', 70, 0),
(22, 'pintura plata', 2, 9, 60, '2020-10-13', 70, 0),
(23, 'tiner acrilico', 4, 7, 24, '2080-10-13', 3500, 0),
(24, 'pintura sintetica', 5, 13, 35, '2020-10-13', 100, 0),
(25, 'pintura latex', 3, 10, 25, '2020-10-13', 100, 0),
(26, 'pintura automotiva PU', 5, 11, 490, '2020-10-19', 50, 20),
(27, 'masilla plastica', 5, 14, 25, '2020-11-19', 100, 60);

-- 
-- Dumping data for table venta
--

-- Table comercio.venta does not contain any data (it is empty)

-- 
-- Dumping data for table detalleventa
--

-- Table comercio.detalleventa does not contain any data (it is empty)

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;