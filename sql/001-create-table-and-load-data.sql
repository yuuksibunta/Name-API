DROP TABLE IF EXISTS names;

CREATE TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 age int NOT NULL,
 PRIMARY KEY(id)
);

INSERT INTO names (name, age) VALUES ('yuki', 29);
INSERT INTO names (name, age) VALUES ('ayano', 27);
INSERT INTO names (name, age) VALUES ('bunt', 3);
INSERT INTO names (name, age) VALUES ('arisa', 30);