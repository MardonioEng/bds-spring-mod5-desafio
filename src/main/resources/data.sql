INSERT INTO tb_user (name, email, password) VALUES ('Bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Action');
INSERT INTO tb_genre (name) VALUES ('Comedy');

INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Top Gun', 'Maverick', 2022, 'https://image.tmdb.org/t/p/w300/62HCnUTziyWcpDaBO2i1DX17ljH.jpg', 'After more than 30 years of service as one of the Navy’s top aviators, Pete ‘Maverick’ Mitchell is back, pushing the limits as a courageous test pilot. In the contemporary world of tech wars, Maverick takes on drones and proves that the human factor is still essential.', 1);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Thor', 'Love and Thunder', 2022, 'https://image.tmdb.org/t/p/w300/6OEBp0Gqv6DsOgi8diPUslT2kbA.jpg', 'The film finds Thor (Chris Hemsworth) on a journey unlike anything he’s ever faced — a quest for inner peace. But his retirement is interrupted by a galactic killer known as Gorr the God Butcher (Christian Bale), who seeks the extinction of the gods. To combat the threat, Thor enlists the help of King Valkyrie (Tessa Thompson), Korg (Taika Waititi), and ex-girlfriend Jane Foster (Natalie Portman), who — to Thor’s surprise — inexplicably wields his magical hammer, Mjolnir, as the Mighty Thor. Together, they embark upon a harrowing cosmic adventure to uncover the mystery of the God Butcher’s vengeance and stop him before it’s too late.', 1);
INSERT INTO tb_movie (title, sub_Title, year, img_Url, synopsis, genre_id) VALUES ('Minions', 'The Rise of Gru', 2022, 'https://image.tmdb.org/t/p/w300/tzFAboMUGJKoPQEtlxfxbbYsSWa.jpg', 'The continuation of the Minions adventures, always in search of a tyrannical leader. This time, they help a Gru as a child, figuring out how to be a villain.', 2);

INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Incompatible. One of the best action movies Ive ever seen', 2, 1);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('it is an amazing movie.', 2, 2);
INSERT INTO tb_review (text, user_id, movie_id) VALUES ('Nice movie', 1, 2);