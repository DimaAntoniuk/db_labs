USE antoniuk_1_21;

DELIMITER //
CREATE TRIGGER PharmacyFK_ManyToStreetInsert
AFTER INSERT
ON antoniuk_1_21.pharmacy FOR EACH ROW
BEGIN
	IF new.`street_id` NOT IN (SELECT `id` FROM street) THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='FK Insert column street_id';
	END IF;
END//

CREATE TRIGGER PharmacyFK_ManyToStreetUpdate
AFTER UPDATE
ON antoniuk_1_21.pharmacy FOR EACH ROW
BEGIN
	IF new.`street_id` NOT IN (SELECT `id` FROM street) THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='UPDATE Error: FK column street_id';
	END IF;
END//

CREATE TRIGGER PharmacyFK_ManyToStreetDelete
AFTER DELETE
ON antoniuk_1_21.street FOR EACH ROW
BEGIN
	IF old.`id` IN (SELECT `street_id` FROM pharmacy) THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='DELETE Error: FK failure';
	END IF;
END//

CREATE TRIGGER EmployeesFK_ManyToPositionInsert
AFTER INSERT
ON antoniuk_1_21.employees FOR EACH ROW
BEGIN
	IF new.`position_id` NOT IN (SELECT `id` FROM position) THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='INSERT Error: FK column position_id';
	END IF;
END//

CREATE TRIGGER EmployeesFK_ManyToPositionUpdate
AFTER UPDATE
ON antoniuk_1_21.employees FOR EACH ROW
BEGIN
	IF new.`position_id` NOT IN (SELECT `id` FROM position) THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='UPDATE Error: FK column position_id';
	END IF;
END//

CREATE TRIGGER EmployeesFK_ManyToPositionDelete
AFTER DELETE
ON antoniuk_1_21.position FOR EACH ROW
BEGIN
	IF new.`id` IN (SELECT `position_id` FROM employees) THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='DELETE Error: FK failure';
	END IF;
END//

CREATE TRIGGER MedicinesHasInfluenceAreaInsert
AFTER INSERT
ON medicines_has_influence_area FOR EACH ROW
BEGIN
	IF new.medicines_id NOT IN (SELECT id FROM medicines)
    OR new.influence_area_id NOT IN (SELECT id FROM influence_area) THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT="INSERT Error: FK failure";
	END IF;
END//

CREATE TRIGGER MedicinesHasInfluenceAreaUpdate
AFTER UPDATE
ON medicines_has_influence_area FOR EACH ROW
BEGIN
	IF new.medicines_id NOT IN (SELECT id FROM medicines)
    OR new.influence_area_id NOT IN (SELECT id FROM influence_area) THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT="UPDATE Error: FK failure";
	END IF;
END//

CREATE TRIGGER PharmacyHasMedicinesInsert
AFTER INSERT
ON pharmacy_has_medicines FOR EACH ROW
BEGIN
	IF new.medicines_id NOT IN (SELECT id FROM medicines)
    OR new.pharmacy_id NOT IN (SELECT id FROM pharmacy) THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT="INSERT Error: FK failure";
	END IF;
END//

CREATE TRIGGER PharmacyHasMedicinesUpdate
AFTER UPDATE
ON pharmacy_has_medicines FOR EACH ROW
BEGIN
	IF new.medicines_id NOT IN (SELECT id FROM medicines)
    OR new.pharmacy_id NOT IN (SELECT id FROM pharmacy) THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT="UPDATE Error: FK failure";
	END IF;
END//

-- ----------------------------------------------------
CREATE TRIGGER PositionNotUpdate
AFTER UPDATE
ON position FOR EACH ROW
BEGIN
	SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='Not avalible to update position';
END//

CREATE TRIGGER EmployeeCheckInsert
AFTER INSERT
ON employee FOR EACH ROW
BEGIN
	IF new.identity_number LIKE '%00' THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='INSERT Error: FK column identity_number';
    END IF;
END//

CREATE TRIGGER EmployeesCheckUpdate
AFTER UPDATE
ON employees FOR EACH ROW
BEGIN
	IF new.identity_number LIKE '%00' THEN
		SIGNAL SQLSTATE "45000"
		SET MESSAGE_TEXT='UPDATE Error: FK column identity_number';
    END IF;
END//

CREATE TRIGGER MedicinesCheckInsert
AFTER INSERT
ON medicines FOR EACH ROW
BEGIN
	IF new.`code` NOT LIKE '[а-лнор-я][а-лнор-я]-[0-9][0-9][0-9]-[0-9][0-9]' THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT='INSERT column code';
    END IF;
END//

CREATE TRIGGER MedicinesCheckUpdate
AFTER UPDATE
ON medicines FOR EACH ROW
BEGIN
	IF new.`code` NOT LIKE '[а-лнор-я][а-лнор-я]-[0-9][0-9][0-9]-[0-9][0-9]' THEN
		SIGNAL SQLSTATE "45000"
        SET MESSAGE_TEXT='UPDATE column code';
    END IF;
END//