USE antoniuk_1_21;


DELIMITER //
CREATE FUNCTION FuncEmployeeMINExperience()
RETURNS int
BEGIN
	RETURN (SELECT MIN(work_experience) FROM employees);
END//

SELECT * FROM employee WHERE work_experience = dbo.FuncEmployeeMINExperience()//

CREATE FUNCTION FuncEmployeePharmacy(id int)
RETURNS nvarchar(25)
BEGIN
	RETURN (SELECT `name` + ' ' + `number` FROM pharmacy WHERE pharmacy.id=id);
END//
DELIMITER ;

SELECT *, dbo.FuncEmployeeIDPharmacy(id) AS pharmacy  FROM employee