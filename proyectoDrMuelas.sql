-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema drmuelas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema drmuelas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `drmuelas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `drmuelas` ;

-- -----------------------------------------------------
-- Table `drmuelas`.`fichamedica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drmuelas`.`fichamedica` (
  `idtratamiento` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idpaciente` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Fecha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtratamiento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drmuelas`.`odontologo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drmuelas`.`odontologo` (
  `idodontologo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idpersona` INT NOT NULL,
  `Consultorio` INT NOT NULL DEFAULT '0',
  `Sector` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idodontologo`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drmuelas`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drmuelas`.`paciente` (
  `idpaciente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `idpersona` INT NOT NULL,
  PRIMARY KEY (`idpaciente`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drmuelas`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drmuelas`.`persona` (
  `idpersona` INT NOT NULL,
  `Nombre` VARCHAR(50) NOT NULL,
  `Apellido` VARCHAR(50) NOT NULL,
  `Domicilio` VARCHAR(100) NOT NULL,
  `Documento` VARCHAR(20) NOT NULL,
  `Provincia` VARCHAR(25) NOT NULL,
  `CodigoPostal` VARCHAR(10) NULL DEFAULT NULL,
  `FechaNacimiento` VARCHAR(30) NOT NULL,
  `Telefono` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`idpersona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `drmuelas`.`turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `drmuelas`.`turno` (
  `idturno` INT NOT NULL,
  `Fecha` VARCHAR(100) NOT NULL,
  `idodontologo` INT NOT NULL,
  `idpaciente` INT NULL DEFAULT NULL,
  `Estado` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`idturno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
