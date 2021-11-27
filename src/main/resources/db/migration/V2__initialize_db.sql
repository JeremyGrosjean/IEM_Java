-- user status
INSERT INTO user_status (id_user_status, user_status) VALUES
(1, 'admin'),
(2, 'employee');

-- intermission status
INSERT INTO intermission_status (id_intermission_status, status) VALUES
(1, 'true'),
(2, 'false');

-- form status
INSERT INTO form_status (id_form_status, form_status) VALUES
(1, 'true'),
(2, 'false');

-- generic question
INSERT INTO question (content, generic) VALUES
('Si tu devais faire un bilan de ta dernière mission', 'true'),
 ('Tes souhaits pour ton prochain poste', 'true'),
 ('Les centres de service que tu souhaites rejoindre/éviter', 'true'),
 ('Un projet que tu souhaites rejoindre/éviter', 'true'),
 ('Souhaites-tu te former et si oui sur quel sujet', 'true');