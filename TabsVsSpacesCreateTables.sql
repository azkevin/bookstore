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

INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b001', 'The Little Prince', 'Antoine de Saint-Exupéry', 'Gallimard', 'https://imgur.com/download/nlpSCc4', 20, 'Fiction', 'The Little Prince is a poetic tale, with watercolour illustrations by the author, in which a pilot stranded in the desert meets a young prince visiting Earth from a tiny asteroid. The story is philosophical and includes social criticism of the adult world.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b002','A Brief History of Time', 'Stephen Hawking', 'Bantam Dell Publishing Group', 'https://imgur.com/download/jTeKZhH', 32.45, 'Science', 'A Brief History of Time (1988) is a book written by the scientist and mathematician Stephen Hawking. This book is about physics, or the study of laws that predict how things work in the universe. It is also about cosmology, or how we see the universe and how the universe exists.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b003','The Design of Everyday Things', 'Don Norman', 'Basic Books', 'https://imgur.com/download/bJDQDIR', 17.64, 'Engineering', 'The Design of Everyday Things shows that good, usable design is possible. The rules are simple: make things visible, exploit natural relationships that couple function and control, and make intelligent use of constraints.');

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
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (4, 'b001', 5, 3, 'Not very accurate... Do they still have a prince in France?!');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (5, 'b001', 6, 5, 'I bought The Little Prince to read with my daughter. It is a delightful read. The chapters are short which makes it nice if you do not have much time you can still finish a chapter and if you have more time you will be able to cover more ground. It is a thought provoking book and leads to many discussions and learning opportunities for young children. It cheered me up and would recommend it to anyone who is losing faith in people. It was excellent way to learn french when you are getting tired of textbooks and online learning.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (6, 'b001', 3, 1, 'I am Japanese. I do not speak English and cannot understand this book.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (7, 'b002', 4, 2, 'The book ...is so much overrated... This book looks like a dustbin full of outdated concepts. The reader, please, do not be so fool to read this nonsense. Do not let anyone to blind you and try to open your own eyes. ...');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (8, 'b002', 6, 4, 'A brilliant dissertation, as it has to be expected by Stephen Hawking. In a very detailed and at the same time concise way, the author gives a fascinating explanation of the mysteries of our universe discovered so far by science.In spite of the complexity and difficulty of the subject, Hawking succeeds in making his presentation accessible and understandable to the layman. The reading is fascinating. For the first time I have been able to grasp the meaning of the various scientific theories developed since Einstein Theory of Relativity. There is great clarity and honesty in Hawking approach, specifying which concepts and theories have been already observed and therefore confirmed in their validity and which ones are still, although very probable, at the level of supposition. The books speaks about the origins, the formation and the probable future of our universe, explains the concepts of space and time and speaks of many other happenings among the stars, like black holes, etc.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (9, 'b003', 3, 1, 'This book is a very good waterdown introduction to the issues most designers have to deal with when developing a project. All types of designers should read this book. It is very helpful because even though Mr. Norman often focuses on industrial products, the information he discusses is pivotal to the success of any product during its design stage. This applies to web designers as much as to industrial designers. I was a little disappointed to read reviews about this book from web designers saying that it was not necessarily helpful because it did not talk directly about web design. The reader should be more open and apply the concepts to their specific design field.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (9, 'b003', 3, 1, 'This book is a very good waterdown introduction to the issues most designers have to deal with when developing a project. All types of designers should read this book. It is very helpful because even though Mr. Norman often focuses on industrial products, the information he discusses is pivotal to the success of any product during its design stage. This applies to web designers as much as to industrial designers. I was a little disappointed to read reviews about this book from web designers saying that it was not necessarily helpful because it did not talk directly about web design. The reader should be more open and apply the concepts to their specific design field.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (10, 'b001', 1, 2, 'I am an admin. This is an OKAY book.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (11, 'b002', 1, 5, 'Hi, I am an admin. I love Stephen Hawking.');

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