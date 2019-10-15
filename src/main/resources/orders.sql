CREATE DATABASE IF NOT EXISTS e_mall;

USE e_mall;

DROP TABLE IF EXISTS cart;

CREATE TABLE cart(
	id int(11) NOT NULL AUTO_INCREMENT,
	item_id int(11) NOT NULL,
	email VARCHAR(45) NOT NULL,
	quantity int(3),
	order_id VARCHAR(20),
	confirm_message VARCHAR(45) NOT NULL,
	FOREIGN KEY (item_id) REFERENCES item(id),
    PRIMARY KEY (id)
);

INSERT INTO cart VALUES
(1,2,'utk1@gmail.com',50,'ORD151000000','Order Successful'),(2,3,'utk2@gmail.com',70,null,'Not Enough Quantity');