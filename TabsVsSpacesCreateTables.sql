CREATE TABLE Book (
	bid VARCHAR(20) NOT NULL,
	title VARCHAR(60) NOT NULL,
	author VARCHAR(100) NOT NULL,
	publisher VARCHAR(100) NOT NULL,
	coverart VARCHAR(1000) NOT NULL,
	price FLOAT NOT NULL,
	category VARCHAR(100) NOT NULL,
	description VARCHAR(2000) NOT NULL,
	PRIMARY KEY(bid)
);

INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b001', 'Little Prince', 'Antoine de Saint-Exupéry', 'Gallimard', 'https://imgur.com/nlpSCc4', 20, 'Fiction', 'The Little Prince is a poetic tale, with watercolour illustrations by the author, in which a pilot stranded in the desert meets a young prince visiting Earth from a tiny asteroid. The story is philosophical and includes social criticism of the adult world.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b002','A Brief History of Time', 'Stephen Hawking', 'Bantam Dell Publishing Group', 'https://imgur.com/jTeKZhH', 32.45, 'Science', 'A Brief History of Time (1988) is a book written by the scientist and mathematician Stephen Hawking. This book is about physics, or the study of laws that predict how things work in the universe. It is also about cosmology, or how we see the universe and how the universe exists.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b003','The Design of Everyday Things', 'Don Norman', 'Basic Books', 'https://imgur.com/bJDQDIR', 17.64, 'Engineering', 'The Design of Everyday Things shows that good, usable design is possible. The rules are simple: make things visible, exploit natural relationships that couple function and control, and make intelligent use of constraints.');

CREATE TABLE Users (
	userid INT NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    type VARCHAR(20) NOT NULL,
    PRIMARY KEY(userid)
);

INSERT INTO Users (userid, username, password, email, firstname, lastname, type) VALUES (1, 'admin', 'admin', 'admin@gmail.com', 'admin', 'admin', 'admin');
INSERT INTO Users (userid, username, password, email, firstname, lastname, type) VALUES (2, 'partner', 'partner', 'partner@gmail.com', 'partner', 'partner', 'partner');
INSERT INTO Users (userid, username, password, email, firstname, lastname, type) VALUES (3, 'hsasaki', 'touka123', 'hsasaki@gmail.com', 'Haise', 'Sasaki', 'customer');
INSERT INTO Users (userid, username, password, email, firstname, lastname, type) VALUES (4, 'jwhite', 'jwhite123', 'jwhite@gmail.com', 'John', 'White', 'customer');
INSERT INTO Users (userid, username, password, email, firstname, lastname, type) VALUES (5, 'pblack', 'pblack123', 'pblack@gmail.com', 'Peter', 'Black', 'customer');
INSERT INTO Users (userid, username, password, email, firstname, lastname, type) VALUES (6, 'agreen', 'agreen123', 'agreen@gmail.com', 'Andy', 'Green', 'customer');


CREATE TABLE Address (
	id INT NOT NULL,
	street VARCHAR(100) NOT NULL,
	province VARCHAR(20) NOT NULL,
	country VARCHAR(20) NOT NULL,
	zip VARCHAR(20) NOT NULL,
	phone VARCHAR(20),
	PRIMARY KEY(id)
);

INSERT INTO Address (id, street, province, country, zip, phone) VALUES (1, '123 Yonge St', 'ON',
'Canada', 'K1E 6T5' ,'647-123-4567');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (2, '445 Avenue rd', 'ON',
'Canada', 'M1C 6K5' ,'416-123-8569');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (3, '789 Keele St.', 'ON',
'Canada', 'K3C 9T5' ,'416-123-9568');

CREATE TABLE PO (
	poid INT NOT NULL,
	userid INT NOT NULL,
	addressid INT NOT NULL,
	status VARCHAR(100) NOT NULL,
	PRIMARY KEY(poid),
	FOREIGN KEY (userid) REFERENCES Users (userid) ON DELETE CASCADE,
	FOREIGN KEY (addressid) REFERENCES Address (id) ON DELETE CASCADE
);

INSERT INTO PO (poid, userid, addressid, status) VALUES (1, 4, 1, 'PROCESSED');
INSERT INTO PO (poid, userid, addressid, status) VALUES (2, 5, 2, 'DENIED');
INSERT INTO PO (poid, userid, addressid, status) VALUES (3, 6, 3, 'ORDERED');

CREATE TABLE POItem (
	poitemid INT NOT NULL,
	bid VARCHAR(20) NOT NULL,
	price FLOAT NOT NULL,
	PRIMARY KEY(poitemid,bid),
	FOREIGN KEY(poitemid) REFERENCES PO(poid) ON DELETE CASCADE,
	FOREIGN KEY(bid) REFERENCES Book(bid) ON DELETE CASCADE
);

INSERT INTO POItem (poitemid, bid, price) VALUES (1, 'b001', 20);
INSERT INTO POItem (poitemid, bid, price) VALUES (2, 'b002', 32.45);
INSERT INTO POItem (poitemid, bid, price) VALUES (3, 'b003', 17.64);

CREATE TABLE Review (
    reviewid INT NOT NULL,
    bid VARCHAR(20) NOT NULL,
    userid INT NOT NULL,
    rating INT NOT NULL,
    reviewdesc VARCHAR(2000) NOT NULL,
    PRIMARY KEY(reviewid),
    FOREIGN KEY(bid) REFERENCES Book(bid) ON DELETE CASCADE,
    FOREIGN KEY(userid) REFERENCES Users(userid) ON DELETE CASCADE
);

INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (1, 'b001', 4, 5, 'Reminds me of my childhood!');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (2, 'b002', 5, 4, 'A great book done by a great physicist. RIP Steven Hawking.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (3, 'b003', 6, 1, 'What is design? Im just a computer science student.');

CREATE TABLE VisitEvent (
	visiteventid INT NOT NULL,
	day varchar(8) NOT NULL,
	bid varchar(20) not null REFERENCES Book(bid),
	eventtype VARCHAR(100) NOT NULL,
    PRIMARY KEY(visiteventid),
	FOREIGN KEY(bid) REFERENCES Book(bid)
);

INSERT INTO VisitEvent (visiteventid, day, bid, eventtype) VALUES (1, '12202015', 'b001', 'VIEW');
INSERT INTO VisitEvent (visiteventid, day, bid, eventtype) VALUES (2, '12242015', 'b001', 'CART');
INSERT INTO VisitEvent (visiteventid, day, bid, eventtype) VALUES (3, '12252015', 'b001', 'PURCHASE');