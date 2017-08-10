
CREATE SCHEMA `springhibernate` ;

--Si son criminales puedo mandarlos a la carcel
--Aduana no le permite ingresar productos externos
--cacheo por drogas, seguridad aeropuertuaria
DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  -- ONE TO MANY UN PASAPORTE TIENE MUCHOS VIAJES

DROP TABLE IF EXISTS `passport`;

CREATE TABLE `passport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nationality` varchar(45) DEFAULT NULL,
  `expeditionDate` date DEFAULT NULL,
  `expirationDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
   	
-- ideas puedo pedir segun el pais, que pidan como EEUU la visa para viajes,
-- restricciones de seguridad para criminales, libre ingreso y salida del pais para otros
  
CREATE TABLE `springhibernate`.`countries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country_code` VARCHAR(2) NOT NULL,
  `country_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

  --MUCHOS VIAJES TIENE UN PASAPORTE MANY TO ONE YYYYYYYYY muchos viajes TIENEn UN PAIS DE DESTINO

DROP TABLE IF EXISTS `travels`;

CREATE TABLE `travels` (
  `idtravel` int(11) NOT NULL AUTO_INCREMENT,
  `idCountry` int(11) NOT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `purpose` varchar(45) DEFAULT NULL,
  `idPassport` int(11) NOT NULL,
  PRIMARY KEY (`idtravel`),
  KEY `idCountry_idx` (`idCountry`),
  KEY `idPassport_idx` (`idPassport`),
  CONSTRAINT `idCountry` FOREIGN KEY (`idCountry`) REFERENCES `countries` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPassport` FOREIGN KEY (`idPassport`) REFERENCES `passport` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






    