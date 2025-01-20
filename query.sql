-- database: example.db

-- Select all from students
SELECT * FROM students;
SELECT * FROM courses;

-- Select courses taught by "Dr. Smith"
SELECT * FROM courses WHERE instructor = 'Dr. Smith';

-- Join students and enrollments
SELECT students.name, courses.name 
FROM enrollments
INNER JOIN students ON students.id = enrollments.student_id
INNER JOIN courses ON courses.id = enrollments.course_id;

SELECT DISTINCT instructor, name
FROM courses;

SELECT DISTINCT TRIM(instructor) AS instructor, TRIM(name) AS name
FROM courses
ORDER BY instructor ASC, name ASC;

SELECT * FROM courses
WHERE instructor IN ('Dr. Smith', 'Prof. Johnson');

SELECT * FROM students
WHERE age > 20
ORDER BY name ASC;

select DISTINCT name from courses;

SELECT distinct instructor FROM courses
WHERE name LIKE '%Art%' OR name LIKE '%Math%'
ORDER BY instructor DESC;

select * from courses GROUP BY name;

SELECT a1, a2, b1, b2
FROM A
INNER JOIN B on B.f = A.f;

CREATE TABLE [IF NOT EXISTS] [schema_name].table_name (
	column_1 data_type PRIMARY KEY,
   	column_2 data_type NOT NULL,
	column_3 data_type DEFAULT 0,
	table_constraints
) [WITHOUT ROWID];

CREATE TABLE contacts (
	contact_id INTEGER PRIMARY KEY,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	email TEXT NOT NULL UNIQUE,
	phone TEXT NOT NULL UNIQUE
);

CREATE TABLE worker(
   id INT PRIMARY KEY NOT NULL,
   name TEXT NOT NULL,
   age INT NOT NULL,
   address CHAR(50),
   salary REAL CHECK(SALARY > 0)
);

CREATE TABLE company(
   id INT PRIMARY KEY     NOT NULL,
   _name           TEXT    NOT NULL,
   AGE            INT     NOT NULL UNIQUE,
   ADDRESS        CHAR(50),
   SALARY         REAL    DEFAULT 50000.00
);

INSERT INTO devices (name, model, serial)
VALUES('HP ZBook 17 G3 Mobile Workstation','ZBook','SN-2015');

ALTER TABLE devices
RENAME TO equipment;

ALTER TABLE table_name
ADD COLUMN column_definition;

SELECT * FROM courses;
