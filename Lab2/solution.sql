USE labor_sql;

#1
SELECT maker, type
FROM product
WHERE type="Printer"
ORDER BY maker DESC;

#2
SELECT time_out
FROM trip
WHERE time_out >= '1900-01-01 12:00:00' AND time_out <= '1900-01-01 17:00:00';

#3
SELECT maker, type, laptop.model, speed
FROM product, laptop
WHERE product.type="Laptop" AND speed > 600;

#4
SELECT DISTINCT maker FROM product
WHERE (type="PC" AND maker= ANY(SELECT maker FROM product WHERE type="Laptop"))
		OR (type="Laptop" AND maker= ANY(SELECT maker FROM product WHERE type="PC"));

#5
SELECT name, launched, displacement
FROM ships, classes
WHERE ships.class = classes.class
		AND displacement > 35000
        AND type = "bc";

#6
SELECT concat("code: ", code) AS code, concat("model: ",  model) AS model,
		concat("speed: ", speed) AS speed, concat("ram: ", ram) AS ram,
        concat("hd: ", hd) AS hd, concat("cd: ", cd) AS cd, concat("price: ", price) AS price
FROM pc;

#7
SELECT pit.date, COUNT(pit.date) AS number_of_trips
FROM pass_in_trip pit, trip t
WHERE t.trip_no = pit.trip_no AND t.town_to = "Moscow"
GROUP BY pit.date;

#8
SELECT p.speed, AVG(p.price) AS average_price
FROM pc p
WHERE p.speed > 600
GROUP BY p.speed
ORDER BY p.speed;

 #9
SELECT DISTINCT P.maker, 
CASE 
WHEN (SELECT COUNT(model)FROM printer P1 WHERE P1.model IN (SELECT P2.model FROM product P2 WHERE P2.maker=P.maker ) ) > 0 THEN CONCAT("yes(" , 
		CAST((SELECT COUNT(model)FROM printer WHERE model IN (SELECT P2.model FROM product P2 WHERE P2.maker = P.maker)) AS char) , ")") 
ELSE "no" END AS printer
FROM product P;

#10
SELECT class,
(SELECT COUNT(*)
FROM Ships
WHERE Ships.class=Classes.class
)AS count_of
FROM Classes
WHERE EXISTS(SELECT * FROM Ships WHERE Ships.class=Classes.class)
UNION SELECT class,
(SELECT COUNT(*)
FROM Outcomes
WHERE Classes.class = Outcomes.ship
) AS count_of
FROM Classes
WHERE EXISTS(SELECT * FROM Outcomes WHERE Classes.class = Outcomes.ship)
AND NOT EXISTS(SELECT * FROM Ships WHERE Ships.class=Classes.class)