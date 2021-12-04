-- user admin (user_status = admin)
INSERT INTO iem_user (id_user, last_name, first_name, email, user_status) VALUES
('1', 'Boulanger', 'Camille', 'c.boulanger@admin-capgemini.com', 'admin'),
('2', 'Dupont', 'Robert', 'r.dupont@admin-capgemini.com', 'admin'),
('3', 'Duval', 'Tiphaine', 'l.marcel@admin-capgemini.com', 'admin');

-- user employee (user_status = employee)
INSERT INTO iem_user (id_user, last_name, first_name, email, user_status) VALUES
('4', 'Doe', 'John', 'j.doe@capgemini.com', 'employee'),
('5', 'Laufeyson', 'Steve', 'r.dupont@capgemini.com', 'employee'),
('6', 'Dubois', 'Martin', 'm.dubois@capgemini.com', 'employee');

-- access admin
INSERT INTO access (id_access,account, password, id_user) VALUES
('1','c.boulanger', 'boulanger', '1'),
('2','r.dupont', 'dupont', '2'),
('3','l.marcel', 'marcel', '3');

-- access employee
INSERT INTO access (id_access,account, password, id_user) VALUES
('4','j.doe', 'doe', '4'),
('5','r.dupont', 'dupont', '5'),
('6','m.dubois', 'dubois', '6');

-- activity (employee)
INSERT INTO activity (id_activity,title, content, date, id_user, period) VALUES
('1','Formation', 'Introduction au C# sur Pluralsight', '2021-10-21', '4', 1),
('2','Mission interne', 'Développement d''un outil de gestion de planning pour le projet Bêta', '2021-10-18', '5', 1),
('3','Mission interne', 'Renfort projet Alpha', '2021-10-11', '6', 2);

-- intermission (employee)
INSERT INTO intermission (id_intermission,start_date, end_date, id_user, id_intermission_status) VALUES
('1','2021-09-12', null, '4', 1),
('2','2021-08-31', '2021-10-12', '5', 2),
('3','2021-07-21', null, '6', 1);

-- form
INSERT INTO form (id_form,id_user, id_form_status) VALUES
('1','4', 1),
('2','5', 2),
('3','6', 1);

-- custom question
INSERT INTO question (id_question,content, generic) VALUES
('7','Serais-tu intéressé par un changement de domaine','false'),
('8','Souhaiterais-tu plus de responsabilités', 'false');

-- answer.
INSERT INTO answer (id_answer,content) VALUES
('1','Réponse à la question 2'),
('2','Réponse à la question 1'),
('3','Réponse à la question 3'),
('4','Réponse à la question 6'),
('5','Réponse à la question 7'),
('6','Réponse à la question 5'),
('7','Réponse à la question 4');

--form_question
INSERT INTO form_question (id_form_question,id_form, id_question, id_answer) VALUES
('1','1','1','2'),
('2','1','2','1'),
('3','1','3','3'),
('4','1','4','7'),
('5','1','5','6'),
('6','2','1','2'),
('7','2','2','1'),
('8','2','3','3'),
('9','2','4','7'),
('10','2','5','6');

-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;

