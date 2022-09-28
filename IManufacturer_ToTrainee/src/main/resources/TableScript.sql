-- Active: 1662376635324@@localhost@3306@imanufacturer_totrainee
DROP DATABASE IF EXISTS IManufacturer_ToTrainee;

CREATE DATABASE IManufacturer_ToTrainee;

USE IManufacturer_ToTrainee;

CREATE TABLE Employee (
	employee_id INT PRIMARY KEY,
	employee_name VARCHAR(100) NOT NULL,
	email_id VARCHAR(255) UNIQUE NOT NULL,
	dob DATETIME NOT NULL,
	manufacturing_unit VARCHAR(10) NOT NULL
);

INSERT INTO Employee VALUES (2001, 'Jack', 'jack@mail.com', '1988-09-03', 'U001');
INSERT INTO Employee VALUES (2002, 'Jose', 'jose@mail.com', '1987-01-15', 'U002');
INSERT INTO Employee VALUES (2003, 'Jill', 'jill@mail.com', '1990-11-15','U001');
INSERT INTO Employee VALUES (2004, 'Albert', 'albert@mail.com', '1988-12-30','U003');
INSERT INTO Employee VALUES (2005, 'Husee', 'husee@mail.com', '1989-03-22','U001');

COMMIT;

SELECT * FROM Employee;