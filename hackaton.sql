-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2017 a las 19:21:40
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hackaton`
--
CREATE DATABASE IF NOT EXISTS `hackaton` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hackaton`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `galeria`
--

DROP TABLE IF EXISTS `galeria`;
CREATE TABLE `galeria` (
  `id_galeria` int(11) NOT NULL,
  `imagen1` varchar(50) DEFAULT NULL,
  `imagen2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `galeria`
--

TRUNCATE TABLE `galeria`;
--
-- Volcado de datos para la tabla `galeria`
--

INSERT INTO `galeria` (`id_galeria`, `imagen1`, `imagen2`) VALUES
(1, 'perro1.jpg', 'perro2.jpg'),
(2, 'perro3.jpg', 'carro.jpg'),
(3, 'golf.jpg', 'perro1.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

DROP TABLE IF EXISTS `mascota`;
CREATE TABLE `mascota` (
  `id_mascota` int(11) NOT NULL,
  `nombreM` varchar(100) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `genero` tinyint(1) NOT NULL,
  `peso` float NOT NULL,
  `color` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `raza` int(11) NOT NULL,
  `id_galeria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `mascota`
--

TRUNCATE TABLE `mascota`;
--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`id_mascota`, `nombreM`, `tipo`, `fecha_nacimiento`, `genero`, `peso`, `color`, `estado`, `descripcion`, `fecha_ingreso`, `raza`, `id_galeria`) VALUES
(1, 'robin', 0, '2017-05-13', 0, 4.8, 'gris', 'sano', 'Esta bonito', '2017-05-26', 1, 2),
(2, 'Solovino', 1, '2013-09-18', 0, 15, 'Cafe', 'Vivito y Coliando', 'Es un perro tamaño medio, come mucho.', '2017-05-25', 1, 2),
(3, 'oso', 1, '2017-05-10', 0, 13, 'Negro con blanco', 'Digamos que esta bien', 'Se encuentra muy bien', '2017-05-24', 1, 2),
(4, 'snooki', 1, '2017-05-03', 1, 13, 'Negro con blanco y cafe', 'Digamos que esta bien', 'Se encuentra muy bien', '2017-05-02', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prospecto`
--

DROP TABLE IF EXISTS `prospecto`;
CREATE TABLE `prospecto` (
  `id_prospecto` int(11) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_mascota` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `prospecto`
--

TRUNCATE TABLE `prospecto`;
--
-- Volcado de datos para la tabla `prospecto`
--

INSERT INTO `prospecto` (`id_prospecto`, `fecha`, `id_mascota`, `status`, `id_usuario`) VALUES
(1, '2017-05-26 17:32:34', 1, 0, 2),
(2, '2017-05-26 23:44:22', 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `razas`
--

DROP TABLE IF EXISTS `razas`;
CREATE TABLE `razas` (
  `id_raza` int(11) NOT NULL,
  `descripcionRaza` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `razas`
--

TRUNCATE TABLE `razas`;
--
-- Volcado de datos para la tabla `razas`
--

INSERT INTO `razas` (`id_raza`, `descripcionRaza`) VALUES
(1, 'Pastor Aleman'),
(2, 'Chihuaha'),
(3, 'Criollo'),
(4, 'Siames'),
(5, 'Angora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

DROP TABLE IF EXISTS `reporte`;
CREATE TABLE `reporte` (
  `id_reporte` int(11) NOT NULL,
  `latitud` float NOT NULL,
  `longitud` float NOT NULL,
  `ruta_foto` text NOT NULL,
  `descripcion` text NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `reporte`
--

TRUNCATE TABLE `reporte`;
--
-- Volcado de datos para la tabla `reporte`
--

INSERT INTO `reporte` (`id_reporte`, `latitud`, `longitud`, `ruta_foto`, `descripcion`, `fecha`) VALUES
(1, 70, 45, 'perro1.jpg', 'Encontre perro en el parque creo esta perdido, no tiene hogar.', '2017-04-26 00:00:00'),
(2, 126, 130, '/perro2.jpg', 'Se perdio este perro!!!!!!!!!!!!!!!!!!', '2017-05-28 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombreU` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `colonia` varchar(60) NOT NULL,
  `calle` varchar(60) NOT NULL,
  `numero` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncar tablas antes de insertar `usuario`
--

TRUNCATE TABLE `usuario`;
--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombreU`, `apellido`, `edad`, `correo`, `estado`, `ciudad`, `colonia`, `calle`, `numero`) VALUES
(1, 'Rodrigo', 'Romero Montoya', 21, 'rodrigo@gmail.com', 'Michoacan', 'Morelia', 'Costituyentes de Apatzingan', 'Calle 1', '34'),
(2, 'Jaisne Ivan', 'Larralde Ortiz', 22, 'jaisen.95@gmail.com', 'Michoacan', 'Morelia', 'Rector Hidalgo', 'Jesus Diaz Barriga', '129');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `galeria`
--
ALTER TABLE `galeria`
  ADD PRIMARY KEY (`id_galeria`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`id_mascota`),
  ADD KEY `raza` (`raza`),
  ADD KEY `id_galeria` (`id_galeria`);

--
-- Indices de la tabla `prospecto`
--
ALTER TABLE `prospecto`
  ADD PRIMARY KEY (`id_prospecto`),
  ADD KEY `id_mascota` (`id_mascota`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `razas`
--
ALTER TABLE `razas`
  ADD PRIMARY KEY (`id_raza`);

--
-- Indices de la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`id_reporte`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `galeria`
--
ALTER TABLE `galeria`
  MODIFY `id_galeria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `id_mascota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `prospecto`
--
ALTER TABLE `prospecto`
  MODIFY `id_prospecto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `razas`
--
ALTER TABLE `razas`
  MODIFY `id_raza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `reporte`
--
ALTER TABLE `reporte`
  MODIFY `id_reporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_2` FOREIGN KEY (`raza`) REFERENCES `razas` (`id_raza`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `mascota_ibfk_3` FOREIGN KEY (`id_galeria`) REFERENCES `galeria` (`id_galeria`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `prospecto`
--
ALTER TABLE `prospecto`
  ADD CONSTRAINT `prospecto_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `prospecto_ibfk_2` FOREIGN KEY (`id_mascota`) REFERENCES `mascota` (`id_mascota`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
