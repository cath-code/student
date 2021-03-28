-- Creates role that will be used for database configuration
CREATE ROLE piano_user WITH LOGIN PASSWORD 'piano_user';

--Grant privileges
GRANT ALL ON DATABASE piano_lessons TO unicorn;
GRANT CONNECT ON DATABASE piano_lessons TO piano_user;


CREATE TABLE day_of_week
(
	day VARCHAR(9) PRIMARY KEY
);

INSERT INTO day_of_week(day) VALUES
  ('MONDAY'),
  ('TUESDAY'),
  ('WEDNESDAY'),
  ('THURSDAY'),
  ('FRIDAY'),
  ('SATURDAY'),
  ('SUNDAY');

GRANT SELECT ON day_of_week TO piano_user;

CREATE TABLE gender
(
	gender_code CHAR(1) PRIMARY KEY
);

INSERT INTO gender(gender_code) VALUES
  ('M'),
  ('F');

GRANT SELECT ON gender TO piano_user;

CREATE TABLE student (
	student_id SERIAL PRIMARY KEY,
	student_name VARCHAR(200) NOT NULL,
	standard VARCHAR(50),
	date_of_birth  DATE,
	gender_type CHAR(1) REFERENCES gender(gender_code),
	preferred_day VARCHAR(9) REFERENCES day_of_week(day),
	preferred_time TIME,
	preferred_lesson_length INTEGER,
	rate NUMERIC(2),
	notes VARCHAR(1000)
);

GRANT SELECT, UPDATE, INSERT, DELETE ON student TO piano_user;
GRANT SELECT, UPDATE, USAGE ON SEQUENCE student_student_id_seq TO piano_user;

