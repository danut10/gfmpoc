CREATE TABLE Au (
	id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(30),
	unitType varchar(10),
	price dec(10,2),
	fkPark int(11),
	PRIMARY KEY (id)
);