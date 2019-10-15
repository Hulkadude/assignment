CREATE DATABASE IF NOT EXISTS e_mall;

USE e_mall;

DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS item;

CREATE TABLE item (
	id int(11) NOT NULL AUTO_INCREMENT,
	item_name VARCHAR(45) NOT NULL,
	quantity int(3),
	PRIMARY KEY (id)
);

INSERT INTO item VALUES
(1,'surf excel',100),(2,'Rim',50),(3,'Frooti',30);