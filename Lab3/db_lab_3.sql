SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS Antoniuk_db DEFAULT CHARACTER SET utf8 ;
USE Antoniuk_db ;

DROP TABLE IF EXISTS Antoniuk_db.`owner`;
DROP TABLE IF EXISTS Antoniuk_db.station;
DROP TABLE IF EXISTS Antoniuk_db.owner_has_station;
DROP TABLE IF EXISTS Antoniuk_db.pannel;
DROP TABLE IF EXISTS Antoniuk_db.pannel_data;
DROP TABLE IF EXISTS Antoniuk_db.price;
DROP TABLE IF EXISTS Antoniuk_db.output;
DROP TABLE IF EXISTS Antoniuk_db.household;
DROP TABLE IF EXISTS Antoniuk_db.station_has_household;


CREATE TABLE Antoniuk_db.`owner` (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  PRIMARY KEY (id)
)ENGINE = InnoDB;

CREATE TABLE Antoniuk_db.station (
  id INT NOT NULL AUTO_INCREMENT,
  number_of_pannels INT NULL,
  address VARCHAR(45) NULL,
  time_of_usage INT NULL,
  PRIMARY KEY (id)
)ENGINE = InnoDB;


CREATE TABLE Antoniuk_db.household (
  id INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (id)
)ENGINE = InnoDB;


CREATE TABLE Antoniuk_db.output (
  id INT NOT NULL AUTO_INCREMENT,
  power_per_hour INT NULL,
  time_start DATETIME NULL,
  time_end DATETIME NULL,
  station_id INT NOT NULL,
  price_id INT NOT NULL,
  PRIMARY KEY (id, station_id)
)ENGINE = InnoDB;


CREATE TABLE Antoniuk_db.pannel (
  id INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  carpacity INT NULL,
  station_id INT NOT NULL,
  PRIMARY KEY (id)
)ENGINE = InnoDB;


CREATE TABLE Antoniuk_db.owner_has_station (
  owner_id INT NOT NULL,
  station_id INT NOT NULL,
  PRIMARY KEY (owner_id, station_id)
)ENGINE = InnoDB;


CREATE TABLE Antoniuk_db.station_has_household (
  station_id INT NOT NULL,
  household_id INT NOT NULL,
  PRIMARY KEY (station_id, household_id)
)ENGINE = InnoDB;


CREATE TABLE Antoniuk_db.price (
  id INT NOT NULL AUTO_INCREMENT,
  `value` INT NULL,
  time_of_price_begin TIME NULL,
  time_of_price_end TIME NULL,
  PRIMARY KEY (id)
)ENGINE = InnoDB;


CREATE TABLE Antoniuk_db.pannel_data (
  id INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NULL,
  angel INT NULL,
  power INT NULL,
  charge_level INT NULL,
  pannel_id INT NOT NULL,
  PRIMARY KEY (id, pannel_id)
)ENGINE = InnoDB;

ALTER TABLE output
	ADD INDEX fk_output_station1_idx (`station_id` ASC) VISIBLE,
  ADD INDEX fk_output_price1_idx (price_id ASC) VISIBLE,
  ADD CONSTRAINT fk_output_station1
    FOREIGN KEY (station_id)
    REFERENCES Antoniuk_db.station (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_output_price1
    FOREIGN KEY (price_id)
    REFERENCES Antoniuk_db.price (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE pannel
	ADD INDEX fk_pannel_station1_idx (station_id ASC) VISIBLE,
  ADD CONSTRAINT fk_pannel_station1
    FOREIGN KEY (station_id)
    REFERENCES Antoniuk_db.station (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    
ALTER TABLE owner_has_station
	ADD INDEX fk_owner_has_station_station1_idx (station_id ASC) VISIBLE,
  ADD INDEX fk_owner_has_station_owner_idx (owner_id ASC) VISIBLE,
  ADD CONSTRAINT fk_owner_has_station_owner
    FOREIGN KEY (owner_id)
    REFERENCES Antoniuk_db.`owner` (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_owner_has_station_station1
    FOREIGN KEY (station_id)
    REFERENCES Antoniuk_db.station (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE station_has_household
	ADD INDEX fk_station_has_household_household1_idx (household_id ASC) VISIBLE,
  ADD INDEX fk_station_has_household_station1_idx (station_id ASC) VISIBLE,
  ADD CONSTRAINT fk_station_has_household_station1
    FOREIGN KEY (station_id)
    REFERENCES Antoniuk_db.station (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  ADD CONSTRAINT fk_station_has_household_household1
    FOREIGN KEY (household_id)
    REFERENCES Antoniuk_db.household (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE pannel_data
	ADD INDEX fk_pannel_data_pannel1_idx (pannel_id ASC) VISIBLE,
  ADD CONSTRAINT fk_pannel_data_pannel1
    FOREIGN KEY (pannel_id)
    REFERENCES Antoniuk_db.pannel (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- INSERTION
START TRANSACTION;
USE Antoniuk_db;

INSERT INTO `owner` (first_name, last_name)
VALUES
	("Marco", "Barr"), ("Tyree ", "Padilla"), ("Maia ", "Cabrera"),
    ("Kiana ", "Perez"), ("Monica ", "Shaw"), ("Kyle ", "Cantu"),
    ("Nyasia ", "Hardin"), ("Darnell ", "Petersen"), ("Aubrey ", "Cortez");


INSERT INTO station (number_of_pannels, address, time_of_usage)
VALUES
	(1, "2594 Apple Lane", 10), ("2", "2982 Twin Willow Lane", 12), 
    (3, "1626 Pearcy Avenue", 12);


INSERT INTO household (`name`)
VALUES
	("Lesey"), ("Mordell"), ("Rainway"), ("Loching"), ("Moonbow");


INSERT INTO station_has_household (station_id, household_id)
VALUES
	(1, 1), (2, 2), (2, 3), (3, 3), (3, 4), (3, 5);


INSERT INTO pannel (`type`, carpacity, station_id)
VALUES
	("LEAD ACID", 1000, 1), ("LEAD ACID", 1070, 2), ("LITHIUM", 2000, 2),
    ("NICAD", 500, 3), ("LITHIUM", 2300, 3), ("LEAD ACID", 1120, 3);


INSERT INTO owner_has_station (owner_id, station_id)
VALUES
	(1, 2), (1, 3), (2, 3), (3, 3), (4, 3), (5, 2), (6, 2), (7, 1), (8, 2), (9, 3);


INSERT INTO pannel_data (`date`, angel, power, charge_level, pannel_id)
VALUES
	("2019-09-10 06:00:00", 60, 7, 10, 1), ("2019-09-10 09:00:00", 30, 7, 27, 1), ("2019-09-10 12:00:00", 10, 9, 100, 1),
    ("2019-09-10 15:00:00", -10, 8, 100, 1), ("2019-09-10 18:00:00", -30, 7, 100, 1), ("2019-09-10 21:00:00", -60, 7, 100, 1),
    ("2019-09-10 06:00:00", 70, 6, 20, 2), ("2019-09-10 09:00:00", 45, 8, 80, 2), ("2019-09-10 12:00:00", 20, 10, 100, 2),
    ("2019-09-10 15:00:00", -10, 10, 90, 2), ("2019-09-10 18:00:00", -45, 8, 70, 2), ("2019-09-10 21:00:00", -70, 6, 50, 2),
    ("2019-09-10 06:00:00", 70, 6, 20, 3), ("2019-09-10 09:00:00", 45, 8, 80, 3), ("2019-09-10 12:00:00", 20, 10, 100, 3),
    ("2019-09-10 15:00:00", -10, 10, 90, 3), ("2019-09-10 18:00:00", -45, 8, 70, 3), ("2019-09-10 21:00:00", -70, 6, 50, 3),
    ("2019-09-10 06:00:00", 30, 10, 30, 4), ("2019-09-10 09:00:00", 15, 12, 75, 4), ("2019-09-10 12:00:00", 0, 12, 100, 4),
    ("2019-09-10 15:00:00", 5, 12, 90, 4), ("2019-09-10 18:00:00", -15, 12, 65, 4), ("2019-09-10 21:00:00", -30, 10, 60, 4),
    ("2019-09-10 06:00:00", 30, 10, 30, 5), ("2019-09-10 09:00:00", 15, 12, 75, 5), ("2019-09-10 12:00:00", 0, 12, 100, 5),
    ("2019-09-10 15:00:00", 5, 12, 90, 5), ("2019-09-10 18:00:00", -15, 12, 65, 5), ("2019-09-10 21:00:00", -30, 10, 60, 5),
    ("2019-09-10 06:00:00", 30, 10, 30, 6), ("2019-09-10 09:00:00", 15, 12, 75, 6), ("2019-09-10 12:00:00", 0, 12, 100, 6),
    ("2019-09-10 15:00:00", 5, 12, 90, 6), ("2019-09-10 18:00:00", -15, 12, 65, 6), ("2019-09-10 21:00:00", -30, 10, 60, 6);


INSERT INTO price (`value`, time_of_price_begin, time_of_price_end)
VALUES
	(50, "00:00:00", "06:00:00"),
    (100, "06:00:00", "12:00:00"),
    (68, "12:00:00", "15:00:00"),
    (130, "15:00:00", "23:59:59");


INSERT INTO output (power_per_hour, time_start, time_end, station_id, price_id)
VALUES
	(7, "2019-09-10 06:00:00", "2019-09-10 12:00:00", 1, 2),
    (9, "2019-09-10 12:00:00", "2019-09-10 15:00:00", 1, 3),
    (7, "2019-09-10 15:00:00", "2019-09-10 21:00:00", 1, 4),
    (7, "2019-09-10 06:00:00", "2019-09-10 12:00:00", 2, 2),
    (10, "2019-09-10 12:00:00", "2019-09-10 15:00:00", 2, 3),
    (7, "2019-09-10 15:00:00", "2019-09-10 21:00:00", 2, 4),
    (11, "2019-09-10 06:00:00", "2019-09-10 12:00:00", 3, 2),
    (12, "2019-09-10 12:00:00", "2019-09-10 15:00:00", 3, 3),
    (11, "2019-09-10 15:00:00", "2019-09-10 21:00:00", 3, 4);
    
COMMIT;