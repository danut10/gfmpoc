CREATE TABLE Booking (
	id int(11) NOT NULL AUTO_INCREMENT,
	cutomerName varchar(30),
	dateFrom date,
	dateTo date,
	auId int(11),
	lastUpdate timestamp DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
	);