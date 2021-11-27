-- user admin (status = 1)
INSERT INTO iem_user (id_user, last_name, first_name, email, id_user_status) VALUES
(1, 'Boulanger', 'Camille', 'c.boulanger@admin-capgemini.com', 1),
(2, 'Dupont', 'Robert', 'r.dupont@admin-capgemini.com', 1),
(3, 'Duval', 'Tiphaine', 'l.marcel@admin-capgemini.com', 1);

-- user employee (status = 2)
INSERT INTO iem_user (id_user, last_name, first_name, email, id_user_status) VALUES
(4, 'Doe', 'John', 'j.doe@capgemini.com', 2),
(5, 'Laufeyson', 'Steve', 'r.dupont@capgemini.com', 2),
(6, 'Dubois', 'Martin', 'm.dubois@capgemini.com', 2);

-- access admin
INSERT INTO access (account, password, id_user) VALUES
('c.boulanger', 'boulanger', 1),
('r.dupont', 'dupont', 2),
('l.marcel', 'marcel', 3);

-- access employee
INSERT INTO access (account, password, id_user) VALUES
('j.doe', 'doe', 4),
('r.dupont', 'dupont', 5),
('m.dubois', 'dubois', 6);

-- activity (employee)
INSERT INTO activity (activity_title, activity_content, activity_date, id_user, id_period) VALUES
('Formation', 'Introduction au C# sur Pluralsight', '2021-10-21', 4, 1),
('Mission interne', "Développement d'un outil de gestion de planning pour le projet Bêta", '2021-10-18', 5, 1),
('Mission interne', 'Renfort projet Alpha', '2021-10-11', 6, 2);

-- intermission (employee)
INSERT INTO intermission (start_date, end_date, id_user, id_intermission_status) VALUES
('2021-09-12', null, 4, 1),
('2021-08-31', '2021-10-12', 5, 2),
('2021-07-21', null, 6, 1);

-- form
INSERT INTO form (id_user, id_form_status) VALUES
(4, 1),
(5, 2),
(6, 3);

-- custom question
INSERT INTO question (content) VALUES
('Serais-tu intéressé par un changement de domaine'),
('Souhaiterais-tu plus de responsabilités');

--form_question
INSERT INTO form_question (id_form, id_question) VALUES
(1, 2),
(1, 1),
(1, 5),
(1, 6),
(2, 7),
(2, 5),
(3, 5),
(3, 2),
(3, 4);

-- answer
INSERT INTO answer (content, id_form_question) VALUES
('Réponse à la question 2', 1),
('Réponse à la question 1', 2),
('Réponse à la question 5', 3),
('Réponse à la question 6', 4),
('Réponse à la question 7', 5),
('Réponse à la question 8', 6),
('Réponse à la question 5', 7);