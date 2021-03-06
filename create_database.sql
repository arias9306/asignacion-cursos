-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- begin attached script 'script'

-- end attached script 'script'
-- -----------------------------------------------------
-- Schema ASIGNACION_SALON
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ASIGNACION_SALON
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ASIGNACION_SALON` DEFAULT CHARACTER SET utf8 ;
USE `ASIGNACION_SALON` ;

-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`ROL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`ROL` (
  `ID_ROL` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(30) NULL,
  PRIMARY KEY (`ID_ROL`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`PROGRAMA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`PROGRAMA` (
  `ID_PROGRAMA` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `FACULTAD` VARCHAR(45) NOT NULL,
  `CODIGO` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID_PROGRAMA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`USUARIO` (
  `ID_USUARIO` INT NOT NULL AUTO_INCREMENT,
  `PRIMER_NOMBRE` VARCHAR(45) NOT NULL,
  `SEGUNDO_NOMBRE` VARCHAR(45) NULL,
  `PRIMER_APELLIDO` VARCHAR(45) NOT NULL,
  `SEGUNDO_APELLIDO` VARCHAR(45) NULL,
  `CORREO` VARCHAR(100) NOT NULL,
  `CODIGO` INT NOT NULL,
  `NRO_IDENTIFICACION` INT NOT NULL,
  `TELEFONO` VARCHAR(15) NOT NULL,
  `PASSWORD` VARCHAR(100) NOT NULL,
  `CAMBIO_PASSWORD` BIT NULL,
  `ESTADO` VARCHAR(45) NOT NULL,
  `ID_ROL` INT NOT NULL,
  `ID_PROGRAMA` INT NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  CONSTRAINT `fk_USUARIO_ROL`
    FOREIGN KEY (`ID_ROL`)
    REFERENCES `ASIGNACION_SALON`.`ROL` (`ID_ROL`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USUARIO_PROGRAMA`
    FOREIGN KEY (`ID_PROGRAMA`)
    REFERENCES `ASIGNACION_SALON`.`PROGRAMA` (`ID_PROGRAMA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_USUARIO_ROL_idx` ON `ASIGNACION_SALON`.`USUARIO` (`ID_ROL` ASC) ;

CREATE INDEX `fk_USUARIO_PROGRAMA_idx` ON `ASIGNACION_SALON`.`USUARIO` (`ID_PROGRAMA` ASC) ;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`ESTADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`ESTADO` (
  `ID_ESTADO` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_ESTADO`))
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`SALON`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`SALON` (
  `ID_SALON` INT NOT NULL AUTO_INCREMENT,
  `CODIGO` INT NOT NULL,
  `ESTADO` BIT NOT NULL,
  `BLOQUE` INT NULL,
  `TIPO` VARCHAR(45) NOT NULL,
  `DESCRIPCION` VARCHAR(45) NULL,
  PRIMARY KEY (`ID_SALON`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`PETICION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`PETICION` (
  `ID_PETICION` INT NOT NULL AUTO_INCREMENT,
  `FECHA_INICIO` DATETIME NOT NULL,
  `FECHA_FINAL` DATETIME NOT NULL,
  `OBSERVACION` TEXT NULL,
  `ID_ESTADO` INT NOT NULL,
  `ID_SALON` INT NOT NULL,
  `ID_USUARIO` INT NOT NULL,
  PRIMARY KEY (`ID_PETICION`),
  CONSTRAINT `fk_PETICION_ESTADO`
    FOREIGN KEY (`ID_ESTADO`)
    REFERENCES `ASIGNACION_SALON`.`ESTADO` (`ID_ESTADO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PETICION_USUARIO`
    FOREIGN KEY (`ID_USUARIO`)
    REFERENCES `ASIGNACION_SALON`.`USUARIO` (`ID_USUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PETICION_SALON`
    FOREIGN KEY (`ID_SALON`)
    REFERENCES `ASIGNACION_SALON`.`SALON` (`ID_SALON`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PETICION_ESTADO_idx` ON `ASIGNACION_SALON`.`PETICION` (`ID_ESTADO` ASC) ;

CREATE INDEX `fk_PETICION_USUARIO_idx` ON `ASIGNACION_SALON`.`PETICION` (`ID_USUARIO` ASC) ;

CREATE INDEX `fk_PETICION_SALON_idx` ON `ASIGNACION_SALON`.`PETICION` (`ID_SALON` ASC) ;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`AGENDADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`AGENDADO` (
  `ID_AGENDADO` INT NOT NULL AUTO_INCREMENT,
  `FECHA` DATE NOT NULL,
  `HORA` TIME NOT NULL,
  `ID_PETICION` INT NOT NULL,
  PRIMARY KEY (`ID_AGENDADO`),
  CONSTRAINT `fk_AGENDADO_PETICION`
    FOREIGN KEY (`ID_PETICION`)
    REFERENCES `ASIGNACION_SALON`.`PETICION` (`ID_PETICION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '						';

CREATE INDEX `fk_AGENDADO_PETICION_idx` ON `ASIGNACION_SALON`.`AGENDADO` (`ID_PETICION` ASC) ;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`IMPLEMENTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`IMPLEMENTO` (
  `ID_IMPLEMENTO` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `CANTIDAD` INT NOT NULL,
  `ACTIVO` BIT NOT NULL,
  PRIMARY KEY (`ID_IMPLEMENTO`))
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`IMPLEMENTOS_X_PETICION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`IMPLEMENTOS_X_PETICION` (
  `ID_IMPLEMENTOS_X_PETICION` INT NOT NULL AUTO_INCREMENT,
  `CANTIDAD` INT NOT NULL,
  `ID_IMPLEMENTO` INT NOT NULL,
  `ID_PETICION` INT NOT NULL,
  PRIMARY KEY (`ID_IMPLEMENTOS_X_PETICION`),
  CONSTRAINT `fk_IMPLEMENTOS_PETICION_IMPLEMENTO1`
    FOREIGN KEY (`ID_IMPLEMENTO`)
    REFERENCES `ASIGNACION_SALON`.`IMPLEMENTO` (`ID_IMPLEMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IMPLEMENTOS_X_PETICION_PETICION1`
    FOREIGN KEY (`ID_PETICION`)
    REFERENCES `ASIGNACION_SALON`.`PETICION` (`ID_PETICION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_IMPLEMENTOS_PETICION_IMPLEMENTO1_idx` ON `ASIGNACION_SALON`.`IMPLEMENTOS_X_PETICION` (`ID_IMPLEMENTO` ASC) ;

CREATE INDEX `fk_IMPLEMENTOS_X_PETICION_PETICION1_idx` ON `ASIGNACION_SALON`.`IMPLEMENTOS_X_PETICION` (`ID_PETICION` ASC) ;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`CARACTERISTICA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`CARACTERISTICA` (
  `ID_CARACTERISTICA` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `ESTADO` BIT NOT NULL,
  PRIMARY KEY (`ID_CARACTERISTICA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`CARACTERISTICAS_X_PETICION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`CARACTERISTICAS_X_PETICION` (
  `ID_CARACTERISTICAS_X_PETICION` INT NOT NULL AUTO_INCREMENT,
  `VALOR` VARCHAR(45) NOT NULL,
  `ID_PETICION` INT NOT NULL,
  `ID_CARACTERISTICAS` INT NOT NULL,
  PRIMARY KEY (`ID_CARACTERISTICAS_X_PETICION`),
  CONSTRAINT `fk_CARACTERISTICAS_X_PETICION_PETICION`
    FOREIGN KEY (`ID_PETICION`)
    REFERENCES `ASIGNACION_SALON`.`PETICION` (`ID_PETICION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CARACTERISTICAS_X_PETICION_CARACTERISTICA`
    FOREIGN KEY (`ID_CARACTERISTICAS`)
    REFERENCES `ASIGNACION_SALON`.`CARACTERISTICA` (`ID_CARACTERISTICA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CARACTERISTICAS_X_PETICION_PETICION_idx` ON `ASIGNACION_SALON`.`CARACTERISTICAS_X_PETICION` (`ID_PETICION` ASC) ;

CREATE INDEX `fk_CARACTERISTICAS_X_PETICION_CARACTERISTICA_idx` ON `ASIGNACION_SALON`.`CARACTERISTICAS_X_PETICION` (`ID_CARACTERISTICAS` ASC) ;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`CARACTERISTICAS_X_SALON`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`CARACTERISTICAS_X_SALON` (
  `ID_CARACTERISTICAS_X_SALON` INT NOT NULL AUTO_INCREMENT,
  `VALOR` VARCHAR(45) NOT NULL,
  `ID_SALON` INT NOT NULL,
  `ID_CARACTERISTICAS` INT NOT NULL,
  PRIMARY KEY (`ID_CARACTERISTICAS_X_SALON`),
  CONSTRAINT `fk_CARACTERISTICAS_X_SALON_SALON`
    FOREIGN KEY (`ID_SALON`)
    REFERENCES `ASIGNACION_SALON`.`SALON` (`ID_SALON`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CARACTERISTICAS_X_SALON_CARACTERISTICA`
    FOREIGN KEY (`ID_CARACTERISTICAS`)
    REFERENCES `ASIGNACION_SALON`.`CARACTERISTICA` (`ID_CARACTERISTICA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CARACTERISTICAS_X_SALON_SALON_idx` ON `ASIGNACION_SALON`.`CARACTERISTICAS_X_SALON` (`ID_SALON` ASC) ;

CREATE INDEX `fk_CARACTERISTICAS_X_SALON_CARACTERISTICA_idx` ON `ASIGNACION_SALON`.`CARACTERISTICAS_X_SALON` (`ID_CARACTERISTICAS` ASC) ;


-- -----------------------------------------------------
-- Table `ASIGNACION_SALON`.`AUDITORIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ASIGNACION_SALON`.`AUDITORIA` (
  `ID_AUDITORIA` INT NOT NULL AUTO_INCREMENT,
  `ID_USUARIO` VARCHAR(45) NOT NULL,
  `ACCION` VARCHAR(45) NOT NULL,
  `TABLA` VARCHAR(45) NOT NULL,
  `ANTIGUO_VALOR` TEXT NULL,
  `NUEVO_VALOR` TEXT NOT NULL,
  `FECHA_MODIFICACION` DATETIME NULL,
  PRIMARY KEY (`ID_AUDITORIA`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
