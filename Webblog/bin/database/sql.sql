-- CREATE DATABASE pierixman;
-- CREATE TABLE IF NOT EXISTS postMVP (postid integer PRIMARY KEY, title TEXT NOT NULL);
-- INSERT INTO postMVP (postid, title) VALUES (1, "Start of Projekt Pierixman");
-- SELECT * FROM pierixmanOne;
-- SELECT COUNT(postid) as count_post FROM postMVP;
-- SELECT MAX (postid) FROM postMVP;

CREATE TABLE commentTEST(commentID integer NOT NULL, contents TEXT NOT NULL, postid integer, PRIMARY KEY(commentID), FOREIGN KEY (postid) REFERENCES pierixmanOne(postid));