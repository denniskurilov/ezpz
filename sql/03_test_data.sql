-- =====================================================================
-- 03_test_data.sql
-- Test data: 50 employees
-- Run as: EZPZ (after 02_tables.sql)
-- ID and CREATED_AT are populated automatically
-- =====================================================================

INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('James',       'Smith',     DATE '1985-03-14');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Mary',        'Johnson',   DATE '1990-07-22');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Robert',      'Williams',  DATE '1978-11-05');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Patricia',    'Brown',     DATE '1982-01-30');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('John',        'Jones',     DATE '1995-09-12');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Jennifer',    'Garcia',    DATE '1988-04-18');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Michael',     'Miller',    DATE '1975-12-02');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Linda',       'Davis',     DATE '1969-06-25');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('David',       'Rodriguez', DATE '1992-02-14');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Elizabeth',   'Martinez',  DATE '1986-08-09');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('William',     'Hernandez', DATE '1979-10-31');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Barbara',     'Lopez',     DATE '1972-05-17');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Richard',     'Gonzalez',  DATE '1998-03-03');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Susan',       'Wilson',    DATE '1984-11-21');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Joseph',      'Anderson',  DATE '1991-01-08');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Jessica',     'Thomas',    DATE '1996-06-14');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Thomas',      'Taylor',    DATE '1970-09-27');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Sarah',       'Moore',     DATE '1993-12-19');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Christopher', 'Jackson',   DATE '1987-07-04');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Karen',       'Martin',    DATE '1976-03-29');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Charles',     'Lee',       DATE '1981-08-15');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Lisa',        'Perez',     DATE '1989-10-10');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Daniel',      'Thompson',  DATE '1994-04-23');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Nancy',       'White',     DATE '1967-02-11');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Matthew',     'Harris',    DATE '1999-05-30');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Betty',       'Sanchez',   DATE '1973-07-07');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Anthony',     'Clark',     DATE '1983-09-16');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Margaret',    'Ramirez',   DATE '1977-12-24');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Mark',        'Lewis',     DATE '1990-01-19');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Sandra',      'Robinson',  DATE '1985-06-02');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Donald',      'Walker',    DATE '1968-10-13');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Ashley',      'Young',     DATE '1997-08-28');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Steven',      'Allen',     DATE '1980-04-06');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Kimberly',    'King',      DATE '1992-11-11');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Paul',        'Wright',    DATE '1974-02-20');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Emily',       'Scott',     DATE '2000-09-05');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Andrew',      'Torres',    DATE '1988-12-01');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Donna',       'Nguyen',    DATE '1971-03-15');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Joshua',      'Hill',      DATE '1995-05-26');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Michelle',    'Flores',    DATE '1986-07-31');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Kenneth',     'Green',     DATE '1966-11-08');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Carol',       'Adams',     DATE '1979-01-27');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Kevin',       'Nelson',    DATE '1993-06-18');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Amanda',      'Baker',     DATE '1998-10-22');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Brian',       'Hall',      DATE '1982-04-09');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Melissa',     'Rivera',    DATE '1991-08-03');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('George',      'Campbell',  DATE '1970-12-12');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Deborah',     'Mitchell',  DATE '1975-05-05');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Edward',      'Carter',    DATE '2001-02-16');
INSERT INTO employee (first_name, last_name, date_of_birth) VALUES ('Stephanie',   'Roberts',   DATE '1996-09-29');

COMMIT;

-- Check: should return 50
SELECT COUNT(*) AS employee_count FROM employee;
