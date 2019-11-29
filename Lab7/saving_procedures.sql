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

CALL ParInsertEmployees("Tyree ", "Padilla", "X", "4303120119", "222222", "1990-10-27", 9, 10);

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

CALL InsertMedicinesHasInfluenceArea(1, 4);

/*
DELIMITER //
CREATE PROCEDURE EmployeeCreateDB()
BEGIN
	DECLARE Surname varchar(45) DEFAULT FALSE;
    DECLARE Name varchar(45) DEFAULT FALSE;
	DECLARE SQLString nvarchar(255) DEFAULT FALSE;
	DECLARE rand int DEFAULT FALSE;
    DECLARE N int DEFAULT FALSE;

	DECLARE MyCursor CURSOR FOR SELECT Surname, Name FROM employee;

	OPEN MyCursor;
	
	FETCH NEXT FROM MyCursor INTO Name, Surname; 

	WHILE @@FETCH_STATUS=0 DO
    BEGIN
		SET rand = RAND()*8 + 1;
		SET N = 1;
		SET SQLString='CREATE TABLE ['+Surname+Name+'] (';
		
		WHILE N<=rand DO
		BEGIN
			SET SQLString = SQLString + 'Col'+CAST(N AS nchar(1))+' int';
			IF N<rand THEN
				SET SQLString = SQLString + ',';
            END IF;
			SET N = N + 1;
		END

		SET SQLString = SQLString+ ')';

		EXECUTE SQLString;
		FETCH NEXT FROM MyCursor INTO Name, Surname;
	END

	CLOSE MyCursor;
	DEALLOCATE PREPARE MyCursor;
END;
END WHILE;

*/