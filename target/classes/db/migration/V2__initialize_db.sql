-- intermission status
INSERT INTO intermission_status (id_intermission_status, status) VALUES
(1, 'true'),
(2, 'false');

-- form status
INSERT INTO form_status (id_form_status, form_status) VALUES
(1, 'true'),
(2, 'false');

-- generic question
INSERT INTO question (id_question,content, generic) VALUES
('1','Si tu devais faire un bilan de ta dernière mission', 'true'),
 ('2','Tes souhaits pour ton prochain poste', 'true'),
 ('3','Les centres de service que tu souhaites rejoindre/éviter', 'true'),
 ('4','Un projet que tu souhaites rejoindre/éviter', 'true'),
 ('5','Souhaites-tu te former et si oui sur quel sujet', 'true');

 -- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;