-- CREATE DATABASE pierixman;
-- CREATE TABLE IF NOT EXISTS postMVP (postid integer PRIMARY KEY, title TEXT NOT NULL);
-- INSERT INTO postMVP (postid, title) VALUES (1, "Start of Projekt Pierixman");
--SELECT * FROM postMVP;
-- SELECT COUNT(postid) as count_post FROM postMVP;
-- SELECT MAX (postID) as postID FROM postMVP;

-- CREATE TABLE IF NOT EXISTS pierixmanOne (postid integer PRIMARY KEY, title TEXT NOT NULL, author TEXT NOT NULL, contents TEXT NOT NULL, date TEXT NOT NULL);
-- INSERT INTO pierixmanOne (postid, title, author, contents, date) VALUES (3, "Eine Cubanische Cigarre wird erwachsen", "Felix C. S.", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed dia", "Gestern");
SELECT * FROM pierixmanOne;
-- DROP TABLE IF EXISTS pierifmanOne;

-- DELETE FROM pierixmanOne WHERE postid = 1;