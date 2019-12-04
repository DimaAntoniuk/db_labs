USE antoniuk_1_21;

DROP FUNCTION IF EXISTS FuncEmployeeMINExperience;
DROP FUNCTION IF EXISTS FuncEmployeePharmacy;

DELIMITER //
CREATE FUNCTION FuncEmployeeMINExperience()
RETURNS int
BEGIN
	RETURN (SELECT MIN(work_experiance) FROM employees);
END//

SELECT * FROM employees WHERE work_experiance = FuncEmployeeMINExperience()//

CREATE FUNCTION FuncEmployeePharmacy(id int)
RETURNS LONGTEXT
BEGIN
	RETURN (SELECT CONCAT(`name`,' ',`number`) FROM pharmacy WHERE pharmacy.id=id);
END//
DELIMITER ;

SELECT *, FuncEmployeePharmacy(id) AS pharmacy  FROM employees