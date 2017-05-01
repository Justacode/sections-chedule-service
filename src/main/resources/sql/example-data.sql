INSERT INTO cities (id, name) VALUES (100,'Казань');
INSERT INTO cities (id, name) VALUES (200,'Москва');
INSERT INTO cities (id, name) VALUES (300,'Санкт-Петербург');

INSERT  INTO sports_clubs (id, name, city_id) VALUES (100, 'MAXIMUS', 100);
INSERT  INTO sports_clubs (id, name, city_id) VALUES (200,'DYNAMITE GYM', 200 );
INSERT  INTO sports_clubs (id, name, city_id) VALUES (300,'Brilliant GYM', 300 );
INSERT  INTO sports_clubs (id, name, city_id) VALUES (400,'Alex Fitness', 100 );

INSERT INTO sections (id, name) VALUES (100, 'Воллейбол');
INSERT INTO sections (id, name) VALUES (200, 'Бокс');
INSERT INTO sections (id, name) VALUES (400, 'Настольный теннис');
INSERT INTO sections (id, name) VALUES (700, 'Тяжелая атлетика');

INSERT INTO teachers (id, age, full_name, phone_number, regalia, work_experience, section_id, sports_club_id)
    VALUES (100, 27, 'Алексеев Антон', '78432734636', 'Чемпион республики Корелия по боксу', 4, 200, 300);

INSERT INTO trainings (id, day, time, teacher_id) VALUES  (100, 2, '12:00', 100);
INSERT INTO trainings (id, day, time, teacher_id) VALUES  (200, 2, '12:00', 100);
INSERT INTO trainings (id, day, time, teacher_id) VALUES  (300, 4, '14:00', 100);
INSERT INTO trainings (id, day, time, teacher_id) VALUES  (400, 2, '16:00', 100);
INSERT INTO trainings (id, day, time, teacher_id) VALUES  (500, 3, '10:00', 100);
INSERT INTO trainings (id, day, time, teacher_id) VALUES  (600, 5, '18:00', 100);
INSERT INTO trainings (id, day, time, teacher_id) VALUES  (700, 1, '14:00', 100);

INSERT INTO users (id, login, password, role) VALUES (1, 'vasya', '123','ROLE_USER');
INSERT INTO users (id, login, password, role) VALUES (2, 'admin', 'admin', 'ROLE_ADMIN');