-- -----------------------------------------------------
-- Schema antoniuk_1_21
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `antoniuk_1_21` DEFAULT CHARACTER SET utf8 ;
USE `antoniuk_1_21` ;

DROP TABLE IF EXISTS `pharmacy_has_medicines`;
DROP TABLE IF EXISTS `medicines_has_influence_area`;
DROP TABLE IF EXISTS `employees`;
DROP TABLE IF EXISTS `position`;
DROP TABLE IF EXISTS `pharmacy`;
DROP TABLE IF EXISTS `street`;
DROP TABLE IF EXISTS `medicines`;
DROP TABLE IF EXISTS `influence_area`;

-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `midle_name` VARCHAR(45) NULL,
  `identity_number` VARCHAR(45) NULL,
  `passport` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `work_experiance` INT NULL,
  `position_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`position` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`pharmacy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`pharmacy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `number` VARCHAR(45) NULL,
  `web_address` VARCHAR(45) NULL,
  `saturday` BIT NULL,
  `sunday` BIT NULL,
  `work_time` INT NULL,
  `street_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`street` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`medicines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`medicines` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `code` INT NULL,
  `recipe` BIT NULL,
  `drug` BIT NULL,
  `psychotropic` BIT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`influence_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`influence_area` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`pharmacy_has_medicines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`pharmacy_has_medicines` (
  `pharmacy_id` INT NOT NULL,
  `medicines_id` INT NOT NULL,
  PRIMARY KEY (`pharmacy_id`, `medicines_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `antoniuk_1_21`.`medicines_has_influence_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `antoniuk_1_21`.`medicines_has_influence_area` (
  `medicines_id` INT NOT NULL,
  `influence_area_id` INT NOT NULL,
  PRIMARY KEY (`medicines_id`, `influence_area_id`))
ENGINE = InnoDB;

USE antoniuk_1_21;

INSERT INTO `employees` (`name`, `surname`, `midle_name`, identity_number, passport, birthday, work_experiance, position_id)
VALUES
	("Marco", "Barr", "X", "7723968058", "111111", "1985-11-09", 10, 1),
    ("Tyree ", "Padilla", "X", "4303120119", "222222", "1990-10-27", 9, 10),
    ("Maia ", "Cabrera", "X", "6539977120", "333333", "1988-07-14", 8, 10),
    ("Kiana ", "Perez", "X", "9667402973", "444444", "1992-04-24", 10, 2),
    ("Monica ", "Shaw", "X", "9513573572", "555555", "1996-01-05", 9, 9),
    ("Kyle ", "Cantu", "X", "8239556785", "666666", "1981-03-21", 8, 9),
    ("Nyasia ", "Hardin", "X", "9161586770", "777777", "1991-12-19", 9, 1),
    ("Darnell ", "Petersen", "X", "3333875125", "888888", "1998-11-05", 10, 7),
    ("Aubrey ", "Cortez", "X", "9077342635", "999999", "2000-09-24", 10, 4),
    ("Dima", "Antoniuk", "Volodymyrovych", "1010101010", "101010", "2001-04-09", 10, 3);
    
INSERT INTO `influence_area` (`name`)
VALUES
	("head"),
    ("finger"),
    ("arm"),
    ("neck"),
    ("leg"),
    ("ear"),
    ("eye"),
    ("stomach"),
    ("lungs"),
    ("wrist");

INSERT INTO `medicines` (`name`, `code`, recipe, drug, psychotropic)
VALUES
	("Fizz", 2780, 0, 1, 1),
    ("Rock Salt", 6226, 1, 1, 1),
    ("Crush", 1113, 1, 0, 0),
    ("Storm", 5325, 1, 1, 0),
    ("Typhoon", 8470, 1, 0, 1),
    ("Flashbang", 6593, 1, 1, 1),
    ("Aqua", 4726, 1, 0, 0),
    ("Doom", 6797, 0, 1, 0),
    ("Sapphire", 1223, 0, 1, 1),
    ("Lag", 2707, 1, 1, 1);
    
INSERT INTO `medicines_has_influence_area` (medicines_id, influence_area_id)
VALUES
	(1, 1),
    (4, 2),
    (6, 7),
    (5, 3),
    (2, 8),
    (10, 10),
    (7, 1),
    (5, 4),
    (9, 3),
    (10, 1);

INSERT INTO `pharmacy` (`name`, `number`, `web_address`, `saturday`, `sunday`, `work_time`, `street_id`)
VALUES
	("Melrose Pharmacy Inc", 30, "http://www.pharmacy.com", 1, 0, 8, 1),
    ("Freshair Limited Rainbow", 49, "http://www.pharmacy.com", 1, 1, 8, 7),
    ("Stephen Reses Pharmacy Inc", 50, "http://www.pharmacy.com", 1, 0, 8, 9),
    ("Compounding Center", 16, "http://www.pharmacy.com", 1, 0, 24, 10),
    ("Food City Pharmacy", 29, "http://www.pharmacy.com", 1, 0, 8, 2),
    ("Island Hope", 47, "http://www.pharmacy.com", 1, 1, 8, 4),
    ("Bausch+stroebel", 13, "http://www.pharmacy.com", 1, 0, 8, 8),
    ("Sam's Regent Pharmacy", 11, "http://www.pharmacy.com", 1, 0, 24, 6),
    ("Reeves Drug", 27, "http://www.pharmacy.com", 1, 1, 8, 5),
    ("Alpha Group", 15, "http://www.pharmacy.com", 1, 1, 24, 3);
    
INSERT INTO `pharmacy_has_medicines` (`pharmacy_id`, `medicines_id`)
VALUES
	(1, 2),
    (1, 5),
    (1, 7),
    (3, 8),
    (3, 9),
    (3, 10),
    (5, 10),
    (4, 10),
    (4, 4),
    (5, 7);
    
INSERT INTO `position` (`name`)
VALUES
	("Admin"),
    ("Administrative Support Officer"),
    ("Aseptic Operations Manager"),
    ("Assistant Technical Officer"),
    ("Chief Pharmacist"),
    ("Clinical Pharmacist"),
    ("Clinical Pharmacy Services Manager"),
    ("Deputy Quality Controller"),
    ("Dispensary Manager"),
    ("Medicines Information Manager");
    
INSERT INTO `street` (`name`)
VALUES
	("Crofters Sidings"),
    ("Virginia Rowans"),
    ("Spruce Leas"),
    ("Minerva Bottom"),
    ("Spruce Glas"),
    ("West Wood Hill"),
    ("Churchfield"),
    ("Lower Parklands"),
    ("Ramsay Common"),
    ("Rowanwood Gardens");