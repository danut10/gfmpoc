CREATE TABLE Park (
	id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(50),
	city varchar(60),
	lastUpdate timestamp DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
	);
