USE antoniuk_1_21;

DROP PROCEDURE IF EXISTS ParInsertEmployees;
DROP PROCEDURE IF EXISTS InsertMedicinesHasInfluenceArea;
DROP PROCEDURE IF EXISTS EmployeesCreateDB;

DELIMITER //
CREATE PROCEDURE ParInsertEmployees(
IN Name varchar(45),
IN Surname varchar(45),
IN MidleName varchar(45),
IN IdentityNumber varchar(45),
IN Passport varchar(45),
IN Birthday date,
IN WorkExperience INT,
IN PositionId int
)
BEGIN
	INSERT INTO `employees`(`name`, `surname`, `midle_name`, `identity_number`, `passport`, `birthday`, `work_experiance`, `position_id`)  VALUES (Name, Surname, MidleName, IdentityNumber, Passport, Birthday, WorkExperience, PositionId);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertMedicinesHasInfluenceArea
(
IN MedicinesId int,
IN InfluenceAreaId int
)
BEGIN
	IF  EXISTS(SELECT * FROM medicines WHERE medicines.id=MedicinesId)
	AND EXISTS(SELECT * FROM influence_area WHERE influence_area.id=InfluenceAreaId) THEN
		INSERT INTO medicines_has_influence_area(medicines_id, influence_area_id) VALUES (MedicinesId, InfluenceAreaId);
	END IF;
END//
DELIMITER ;


DELIMITER //
CREATE PROCEDURE EmployeesCreateDB()
BEGIN
	DECLARE done int DEFAULT FALSE;
	DECLARE employee_surname LONGTEXT DEFAULT FALSE;
    DECLARE employee_name LONGTEXT DEFAULT FALSE;
	DECLARE pattern LONGTEXT DEFAULT FALSE;
	DECLARE rand int DEFAULT FALSE;
    DECLARE N int DEFAULT FALSE;
    DECLARE myquery LONGTEXT DEFAULT FALSE;

	DECLARE MyCursor CURSOR FOR SELECT `surname` FROM employees;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
    
	OPEN MyCursor;
    
	 WHILE done=false DO
     BEGIN
		FETCH MyCursor INTO employee_surname;
		SET @rand = RAND()*8 + 1;
		SET @N = 1;
		SET @pattern=CONCAT('CREATE TABLE IF NOT EXISTS `', employee_surname, '` ( ');
		WHILE @N<=@rand DO
		BEGIN
			SET @pattern = CONCAT(@pattern, '`', CAST(@N AS NCHAR),'` INT');
			IF @N<@rand-1 THEN
				SET @pattern = CONCAT(@pattern, ',');
            END IF;
			SET @N = @N + 1;
		END;
        END WHILE;
		
		SET @pattern = CONCAT(@pattern, ')');
        SELECT @pattern;
		PREPARE myquery FROM @pattern;
		EXECUTE myquery;
		DEALLOCATE PREPARE myquery;
     END;
     END WHILE;
	CLOSE MyCursor;
END//
DELIMITER ;

CALL EmployeesCreateDB()