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
	DECLARE employee_surname varchar(45) DEFAULT FALSE;
    DECLARE employee_name varchar(45) DEFAULT FALSE;
	DECLARE pattern nvarchar(255) DEFAULT FALSE;
	DECLARE rand int DEFAULT FALSE;
    DECLARE N int DEFAULT FALSE;

	DECLARE MyCursor CURSOR FOR SELECT `surname`, `name` FROM employees;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
    
	OPEN MyCursor;
    
	MyLoop: LOOP
		FETCH MyCursor INTO employee_surname, employee_name;
		IF done=true THEN LEAVE myLoop;
		END IF;
		SET rand = RAND()*8 + 1;
		SET N = 1;
		SET pattern='CREATE TABLE ['+ employee_surname + employee_name +'] (';
		
		WHILE N<=rand DO
		BEGIN
			SET pattern = pattern + 'Col'+ CAST(N AS nchar(1)) +' int';
			IF N<rand THEN
				SET pattern = pattern + ',';
            END IF;
			SET N = N + 1;
		END;
        END WHILE;

		SET pattern = pattern + ')';

		EXECUTE pattern;
    END LOOP;

	CLOSE MyCursor;
	DEALLOCATE PREPARE MyCursor;
END;
