
use FlightReservation;

CREATE TABLE User
(
Id INT NOT NULL auto_increment,
firstName varchar(20),
lastName varchar(20),
eMail varchar(20),
password varchar(20),
PRIMARY KEY (Id),
UNIQUE KEY (eMail)
);

CREATE TABLE Flight
(
Id INT NOT NULL auto_increment,
flightNumber varchar(20) NOT NULL,
operatingAirlines varchar(20) NOT NULL,
departureCity varchar(20) NOT NULL,
arrivalCity varchar(20) NOT NULL,
dateOfDeparture date NOT NULL,
estimateDepartureTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (Id)
);

CREATE TABLE Reservation
(
Id INT NOT NULL auto_increment,
checkedIn tinyint(1),
numberOfBags int,
passengerId int,
flightId int,
created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(Id)
);

CREATE TABLE Passenger
(
Id INT NOT NULL auto_increment,
firstName varchar(100),
lastName varchar(100),
middleName varchar(100),
eMail varchar(50),
phone varchar(20),
PRIMARY KEY (Id)
);




