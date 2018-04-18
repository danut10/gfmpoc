CREATE TABLE Booking (
	id int(11) NOT NULL AUTO_INCREMENT,
	cutomerName varchar(30),
	dateFrom date,
	dateTo date,
	fkAu int(11),
	PRIMARY KEY (id)
	);