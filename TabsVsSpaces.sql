CREATE TABLE Book (
bid VARCHAR(20) NOT NULL,
title VARCHAR(60) NOT NULL,
price INT NOT NULL,
category VARCHAR(100) NOT NULL,
PRIMARY KEY(bid)
);

INSERT INTO Book (bid, title, price, category) VALUES ('b001', 'Little Prince', 20, 'Fiction');
INSERT INTO Book (bid, title, price, category) VALUES ('b002','Physics', 201, 'Science');
INSERT INTO Book (bid, title, price, category) VALUES ('b003','Mechanics' ,100,'Engineering');

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
id INT NOT NULL,
lname VARCHAR(20) NOT NULL,
fname VARCHAR(20) NOT NULL,
status VARCHAR(100) NOT NULL,
address INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (address) REFERENCES Address (id) ON DELETE CASCADE
);

INSERT INTO PO (id, lname, fname, status, address) VALUES (1, 'John', 'White', 'PROCESSED', 1);
INSERT INTO PO (id, lname, fname, status, address) VALUES (2, 'Peter', 'Black', 'DENIED', 2);
INSERT INTO PO (id, lname, fname, status, address) VALUES (3, 'Andy', 'Green', 'ORDERED', 3);

CREATE TABLE POItem (
id INT NOT NULL,
bid VARCHAR(20) NOT NULL,
price INT NOT NULL,
PRIMARY KEY(id,bid),
FOREIGN KEY(id) REFERENCES PO(id) ON DELETE CASCADE,
FOREIGN KEY(bid) REFERENCES Book(bid) ON DELETE CASCADE
);

INSERT INTO POItem (id, bid, price) VALUES (1, 'b001', 20);
INSERT INTO POItem (id, bid, price) VALUES (2, 'b002', 201);
INSERT INTO POItem (id, bid, price) VALUES (3, 'b003', 100);

CREATE TABLE VisitEvent (
day varchar(8) NOT NULL,
bid varchar(20) not null REFERENCES Book(bid),
eventtype VARCHAR(100) NOT NULL,
FOREIGN KEY(bid) REFERENCES Book(bid)
);

INSERT INTO VisitEvent (day, bid, eventtype) VALUES ('12202015', 'b001', 'VIEW');
INSERT INTO VisitEvent (day, bid, eventtype) VALUES ('12242015', 'b001', 'CART');
INSERT INTO VisitEvent (day, bid, eventtype) VALUES ('12252015', 'b001', 'PURCHASE');