-- CREATE DATABASE pierixman;
-- CREATE TABLE IF NOT EXISTS postMVP (postid integer PRIMARY KEY, title TEXT NOT NULL);
-- INSERT INTO postMVP (postid, title) VALUES (1, "Start of Projekt Pierixman");
--SELECT * FROM postMVP;
-- SELECT COUNT(postid) as count_post FROM postMVP;
-- SELECT MAX (postID) as postID FROM postMVP;

-- CREATE TABLE IF NOT EXISTS pierixmanOne (postid integer PRIMARY KEY, title TEXT NOT NULL, author TEXT NOT NULL, contents TEXT NOT NULL, date TEXT NOT NULL);
-- INSERT INTO pierixmanOne (postid, title, author, contents, date) VALUES (4, "Dicke Datteln am Strand", "Felix C. S.", "irgend ein TExt", "Datum" );
SELECT * FROM commentTest2;
-- DROP TABLE commentTest2;

-- DELETE FROM pierixmanOne WHERE postid = 1;
-- CREATE TABLE IF NOT EXISTS commentTest2 (commentID integer PRIMARY KEY, author TEXT NOT NULL, contents TEXT NOT NULL, date TEXT NOT NULL, postid integer NOT NULL);
-- INSERT INTO commentTest2 (commentID, author, contents, date, postid) VALUES (1, "Felix Schultes", "Fährt Felix in Flossen Fahrrad?", "anno domini", 6 );
