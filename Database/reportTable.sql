CREATE TABLE Report(
	id INT IDENTITY(1,1) PRIMARY KEY,
	submitted_by VARCHAR(20) FOREIGN KEY REFERENCES UserInfo(username),
	refers_to VARCHAR(20) FOREIGN KEY REFERENCES UserInfo(username),
	reason VARCHAR(15) NOT NULL,
	date DATE NOT NULL,
	description VARCHAR(MAX)
);