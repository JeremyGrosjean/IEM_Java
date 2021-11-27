-- Create table ACTIVITY **
CREATE TABLE activity(
	id_activity serial PRIMARY KEY,
	title varchar,
	content varchar,
	date date,
	id_user integer,
	period varchar
);

---- Create table PERIOD **
--CREATE TABLE period(
--	id_period serial PRIMARY KEY,
--	period varchar
--);

-- Create table Iem_USER **
CREATE TABLE iem_user(
	id_user serial PRIMARY KEY,
	last_name varchar,
	first_name varchar,
	email varchar,
    account varchar,
    password varchar,
	id_user_status integer
);

-- Create table USER_STATUS **
CREATE TABLE user_status(
	id_user_status serial PRIMARY KEY,
	user_status varchar
);

-- Create table ACCESS **
CREATE TABLE access(
	id_access serial PRIMARY KEY,
	account varchar,
	password varchar,
	id_user integer
);

-- Create table INTERMISSION **
CREATE TABLE intermission(
	id_intermission serial PRIMARY KEY,
	start_date date,
	end_date date,
	id_user integer,
	id_intermission_status integer
);

-- Create table INTERMISSION_STATUS **
CREATE TABLE intermission_status(
	id_intermission_status serial PRIMARY KEY,
	status boolean
);

-- Create table FORM **
CREATE TABLE form(
	id_form serial PRIMARY KEY,
	id_user integer,
	id_form_status integer
);

-- Create table FORM_STATUS **
CREATE TABLE form_status(
	id_form_status serial PRIMARY KEY,
	form_status boolean
);

-- Create table FORM_QUESTION
CREATE TABLE form_question(
	id_form_question serial PRIMARY KEY,
	id_form integer,
	id_question integer
);

-- Create table ANSWER
CREATE TABLE answer(
	id_answer serial PRIMARY KEY,
	content varchar,
	id_form_question integer
);

-- Create table QUESTION **
CREATE TABLE question(
	id_question serial PRIMARY KEY,
	content varchar,
	generic boolean,
    id_answer integer,
	id_form integer
);


-- Create foreign keys for table ACTIVITY : id_user et id_period
ALTER TABLE activity ADD CONSTRAINT fk_id_user FOREIGN KEY (id_user) REFERENCES iem_user(id_user);
--ALTER TABLE activity ADD CONSTRAINT fk_id_period FOREIGN KEY (id_period) REFERENCES period(id_period);

-- Create foreign keys for table IEM_USER : id_user_status
ALTER TABLE iem_user ADD CONSTRAINT fk_id_user_status FOREIGN KEY (id_user_status) REFERENCES user_status(id_user_status);

-- Create foreign keys for table ACCESS : id_user
ALTER TABLE access ADD CONSTRAINT fk_id_user FOREIGN KEY (id_user) REFERENCES iem_user(id_user);

-- CCreate foreign keys for table FORM : id_user et id_form_status
ALTER TABLE form ADD CONSTRAINT fk_id_user FOREIGN KEY (id_user) REFERENCES iem_user(id_user);
ALTER TABLE form ADD CONSTRAINT fk_id_form_status FOREIGN KEY (id_form_status) REFERENCES form_status(id_form_status);

-- Create foreign keys for table INTERMISSION : id_user et id_intermission_status
ALTER TABLE intermission ADD CONSTRAINT fk_id_user FOREIGN KEY (id_user) REFERENCES iem_user(id_user);
ALTER TABLE intermission ADD CONSTRAINT fk_id_intermission_status FOREIGN KEY (id_intermission_status) REFERENCES intermission_status(id_intermission_status);

-- Create foreign keys for table FORM_QUESTION : id_question et id_form
ALTER TABLE form_question ADD CONSTRAINT fk_id_question FOREIGN KEY (id_question) REFERENCES question(id_question);
ALTER TABLE form_question ADD CONSTRAINT fk_id_form FOREIGN KEY (id_form) REFERENCES form(id_form);

-- Create foreign keys for table ANSWER : id_form_question
ALTER TABLE answer ADD CONSTRAINT fk_id_form_question FOREIGN KEY (id_form_question) REFERENCES form_question(id_form_question);





















