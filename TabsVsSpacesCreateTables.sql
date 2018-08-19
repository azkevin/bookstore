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
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b004','Cracking the Coding Interview', 'Gayle Laakmann McDowell', 'CreateSpace', 'https://imgur.com/download/qldagDR', 42.22, 'Engineering', 'Learn how to uncover the hints and hidden details in a question, discover how to break down a problem into manageable chunks, develop techniques to unstick yourself when stuck, learn core computer science concepts, and practice on 189 interview questions and solutions.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b005','The Pragmatic Programmer', 'Andy Hunt and Dave Thomas', 'Addison-Wesley', 'https://imgur.com/download/qJudZPm', 46.68, 'Engineering', 'The Pragmatic Programmer: From Journeyman to Master is a book about software engineering by Andrew Hunt and David Thomas, published in October 1999, first in a series of books under the label The Pragmatic Bookshelf.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b006','The Great Bridge', 'David McCullough', 'Simon and Schuster', 'https://imgur.com/download/dT6keeT', 22.15, 'Engineering', 'A classic account of one of the greatest engineering feats of all time, the building of the Brooklyn Bridge. This monumental audiobook which presents extended unabridged passages from the book brings back a heroic vision of the America we once had.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b007','Tokyo Ghoul:re Vol. 1', 'Sui Ishida', 'Viz Media', 'https://imgur.com/download/RmwpsAx', 11.66, 'Fiction', 'Shy Ken Kaneki is thrilled to go on a date with the beautiful Rize. But it turns out that she’s only interested in his body—eating it, that is. When a morally questionable rescue transforms him into the first half-human half-Ghoul hybrid, Ken is drawn into the dark and violent world of Ghouls, which exists alongside our own.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b008','Harry Potter and the Deathly Hallows', 'J. K. Rowling', 'Bloomsbury', 'https://imgur.com/download/jxvRgiy', 12.99, 'Fiction', 'Harry Potter and the Deathly Hallows is a fantasy book written by British author J. K. Rowling and the seventh and final novel of the Harry Potter series.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b009','To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', 'https://imgur.com/download/FnI5EtL', 9.99, 'Fiction', 'To Kill a Mockingbird is a novel by Harper Lee published in 1960. It was immediately successful, winning the Pulitzer Prize, and has become a classic of modern American literature.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b010','Fahrenheit 451', 'Ray Bradbury', 'Ballantine Books', 'https://imgur.com/download/DcyGgOK', 10.78, 'Fiction', 'Fahrenheit 451 is a dystopian novel by American writer Ray Bradbury, published in 1953. It is regarded as one of his best works. The novel presents a future American society where books are outlawed and firemen burn any that are found.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b011','The Diary of a Young Girl', 'Anne Frank', 'Contact Publishing', 'https://imgur.com/download/X6YFjsP', 12.92, 'History', 'A book of the writings from the Dutch language diary kept by Anne Frank while she was in hiding for two years with her family during the Nazi occupation of the Netherlands.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b012','Guns, Germs, and Steel', 'Jared Diamond', 'W. W. Norton', 'https://imgur.com/download/slz6qFl', 29.99, 'History', 'The book attempts to explain why Eurasian and North African civilizations have survived and conquered others, while arguing against the idea that Eurasian hegemony is due to any form of Eurasian intellectual, moral, or inherent genetic superiority.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b013','The Communist Manifesto', 'Karl Marx and Friedrich Engels', 'Communist League', 'https://imgur.com/download/7TBiItS', 20.69, 'History', 'The Communist Manifesto summarises Marx and Engels theories concerning the nature of society and politics, that in their own words, The history of all hitherto existing society is the history of class struggles. It also briefly features their ideas for how the capitalist society of the time would eventually be replaced by socialism.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b014','The History of Love', 'Nicole Krauss', 'Norton & Company', 'https://imgur.com/download/BvRNKdG', 17.78, 'Romance', 'Approximately 70 years before the present, the 10-year-old Polish-Jewish Leopold Gursky falls in love with his neighbor Alma Mereminski. The two begin a relationship that develops over the course of 10 years. In this time, Leo writes three books that he gives to Alma, since she is the only person he deeply cares about. Leo promises he will never love anyone but her.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b015','Koe no Katachi Vol. 1', 'Naoko Yamada', 'Kodansha', 'https://imgur.com/download/Nke0ti2', 7.89, 'Romance', 'When a grade school student with impaired hearing is bullied mercilessly, she transfers to another school. Years later, one of her former tormentors sets out to make amends.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b016','The Fault in Our Stars', 'John Green', 'Dutton Books', 'https://imgur.com/download/dac2i9S', 24.99, 'Romance', 'The story is narrated by Hazel Grace Lancaster, a 16-year-old girl with cancer. Hazel is forced by her parents to attend a support group where she subsequently meets and falls in love with 17-year-old Augustus Waters, an ex-basketball player and amputee.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b017','Wuthering Heights', 'Emily Bronte', 'Thomas Cautley Newby', 'https://imgur.com/download/KEXOUvF', 22.21, 'Romance', 'Wuthering Heights, Emily Brontes only novel, was published in 1847 under the pseudonym "Ellis Bell". She died the following year, aged 30. It was written between October 1845 and June 1846, Wuthering Heights and Anne Brontes Agnes Grey were accepted by publisher Thomas Newby before the success of their sister Charlottes novel Jane Eyre.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b018','Cosmos', 'Carl Sagan', 'Random House', 'https://imgur.com/download/lXNW0H1', 1.23, 'Science', 'Cosmos is a 1980 popular science book by astronomer and Pulitzer Prize-winning author Carl Sagan. Its 13 illustrated chapters, corresponding to the 13 episodes of the Cosmos TV series, which the book was co-developed with and intended to complement, explore the mutual development of science and civilization.');
INSERT INTO Book (bid, title, author, publisher, coverart, price, category, description) VALUES ('b019','Hidden Figures', 'Margot Lee Shetterly', 'William Morrow and Company', 'https://imgur.com/download/OMUCAHW', 30.00, 'Science', 'Hidden Figures tells the story of African-American women who worked as computers to solve problems for engineers and others at NASA. For the first years of their careers, the workplace was segregated and women were kept in the background as human computers.');

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
INSERT INTO Users (userid, username, password, email, firstname, lastname, type) VALUES (7, 'tstark', 'tstark123', 'tstark@gmail.com', 'Tony', 'Stark', 'customer');

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
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (4, '123 Yonge St', 'ON',
'Canada', 'K1E 6T5' ,'647-123-4567');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (5, '445 Avenue rd', 'ON',
'Canada', 'M1C 6K5' ,'416-123-8569');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (6, '789 Keele St.', 'ON',
'Canada', 'K3C 9T5' ,'416-123-9568');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES (7, '789 Keele St.', 'ON', 'Canada', 'K3C 9T5' ,'416-123-9568');

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
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (12, 'b004', 3, 5, 'Book came in good condition and as described, Nothing to complain about. Book is a must read to tackle professional software dev position interviews. It really does live up to its expectation and hype.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (13, 'b004', 4, 4, 'Essential for anyone who is serious about getting a software engineering and computer science job and wants to know how to stand out from the competition.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (14, 'b005', 5, 3, 'I recommend this to someone who has done some programming and understands the syntax and fundamentals but has not gotten into programming larger pieces of software. I think that if you have programmed anything significant you will not find much new in here.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (15, 'b006', 6, 5, 'Even though I was npt able to quite understand all the technical explanations on how the Great Bridge was built, it does not matter much to me. The human side of the story is quite interesting to say the least.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (16, 'b006', 1, 2, 'This is a long, hard read. The bridge was a longer, harder act. At times I felt like I was going to take as long to read the book as it took to build the bridge.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (17, 'b007', 1, 5, 'This manga follows a boy who, in a turn of events, has what is above happen to him. This manga has some good action, but it is really about a boy with strong morals trying to cope with what he has become, and also trying to survive in the world he has been thrown into. The pacing is truly great.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (18, 'b008', 5, 1, 'I do not understand what all the hype is about! Quite frankly, they are good stories, but it seemed to me like they were completely predictable. There is no depth to them at all.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (19, 'b008', 4, 2, 'I cannot see why any adult past the age of 20 would want to read the whole series. Two were more than enough for me. I had no sense of wonder when reading this book, and that was disappointing.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (20, 'b009', 3, 3, 'One of the greatest books of the twentieth century? Not even close. One of the most well-loved? Definitely. Few hate it, but for those who dive deep into literature: it does not live up to the hype.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (21, 'b010', 6, 4, 'When I got this book, I did not know what I was getting myself into. I knew the book was about a guy who worked as a fireman but that was about it. When I finally started reading the book, it far exceeded my expectations.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (22, 'b010', 2, 5, 'Eye opening book. Mistakes has been made in the past and the point of history is to not repeat those mistakes.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (23, 'b011', 2, 4, 'I think everyone should read this book! I purchased it for a young girl who is Annes age and will be reading it and contemplating it over the next two years. I am hopeful that it will encourage many thoughtful discussions between her and her parents, leading to a deeper understanding of self and offer an wonderful communicative relationship with her parents. This is real life in a fallen world. We are much poorer if we do not let it teach us!');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (24, 'b012', 3, 2, 'The winner of a Pulitzer Prize usually recommends a book all by itself. Sadly however, this is not the case with Guns, Germs, and Steel. Making no effort to lure the casual or lay reader to the history and anthropology within, this scholarly work is inaccessible to anyone not already intimately interested in the subject matter.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (25, 'b012', 4, 1, 'History is determined by far more than geography, plants, and animals. Culture, religion, individuals, politics, and timing all play important roles. My dear fellow readers, please think before blindly accepting Diamonds grossly incomplete view of history.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (26, 'b013', 5, 5, 'A must for the overall understanding of the roots of communism, socialism and the influences over the past century.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (27, 'b014', 6, 4, 'A beautifully haunting tale of love, friendship, survival and finding ones place in the world. Deeply creative in tone, The History Of Love draws the transfer in like the scent of hot apple cider on a winters evening.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (28, 'b014', 1, 5, 'I love all the literary references and the convoluted plot.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (29, 'b015', 2, 5, 'A different take on manga stories. At first, I found the bullying to be extreme and disturbing, including the reaction of the classmates to the boy who was originally doing the bullying: they returned it ten-fold. Not sure that it is the right way to deal with a problem like that... However, this is a book from a talented writer and artist, and I was drawn in, it hooked me. And I will be reading the second instalment on the series to see where it evolves.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (30, 'b016', 3, 5, 'The Fault in our Stars is a short and bittersweet story of two teens coming of age, uncertain whether they will ever actually see themselves come of age. I can see what all the hype is about and why people are falling in love with this everywhere.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (31, 'b016', 4, 1, 'I was very disappointed with this book. It had been referred to be by a friend but I did not enjoy it one bit. The only good use I got out of it was starting a camp fire with it.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (32, 'b017', 5, 4, 'I think it would be too presumptuous on my part to write a rewiew of this classic of English literature, about which several volumes have already been written by scholars. It holds its right place among the most renown novels of the nineteenth century, and it is a masterpiece of the Romantic Age, with its beautiful captivating story of the consuming passion between the famous characters of Catherine and Heathcliff, against the haunting somber background of the Yorkshire moors, in those times so vast and desolate. I enjoyed reading the beautiful English in which is written, and the picture of the society of those days.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (33, 'b018', 6, 5, 'This book is amazing. It should be on everyones reading list. This book not only transports you into the grandeur of the cosmos but it also makes you think about how small we are in the grand scheme of things. It explains times long past and science in such a way that is understandable by any reader.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (34, 'b019', 1, 3, 'I find the stories about the women mathematicians interesting but there is a lot of technical information that was hard to get through. I usually find the book more interesting then the movie but in this case the movie might be easier to digest. In short there is too much detailed scientific information which for me makes the reading harder.');
INSERT INTO Review (reviewid, bid, userid, rating, reviewdesc) VALUES (35, 'b019', 2, 3, 'An interesting and worthwhile story, but one maybe better told on film. It jumped around a bit too much to be a good, coherent tale. I kept forgetting who the different people were.');

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

CREATE TABLE Cart (
	cartid INT NOT NULL,
	userid INT NOT NULL,
	bid VARCHAR(20) NOT NULL,
	PRIMARY KEY(cartid),
	FOREIGN KEY (userid) REFERENCES Users (userid) ON DELETE CASCADE,
	FOREIGN KEY(bid) REFERENCES Book(bid) ON DELETE CASCADE
);

INSERT INTO Cart (cartid, userid, bid) VALUES (1, 1, 'b001');
INSERT INTO Cart (cartid, userid, bid) VALUES (2, 1, 'b002');
INSERT INTO Cart (cartid, userid, bid) VALUES (3, 1, 'b003');
INSERT INTO Cart (cartid, userid, bid) VALUES (4, 1, 'b004');
INSERT INTO Cart (cartid, userid, bid) VALUES (5, 1, 'b005');

CREATE TABLE CreditCard (
	ccid INT NOT NULL,
	type VARCHAR(20) NOT NULL,
	num VARCHAR(10) NOT NULL,
	cvv VARCHAR(3) NOT NULL,
	month VARCHAR(3) NOT NULL,
	yr VARCHAR(4),
	PRIMARY KEY(ccid)
);

INSERT INTO CreditCard (ccid, type, num, cvv, month, yr) VALUES (1, 'visa', '0123456789', '123', 'jan', '2019');
INSERT INTO CreditCard (ccid, type, num, cvv, month, yr) VALUES (2, 'mastercard', '0123456789', '123', 'dec', '2019');
INSERT INTO CreditCard (ccid, type, num, cvv, month, yr) VALUES (3, 'visa', '0123456789', '123', 'jan', '2019');
INSERT INTO CreditCard (ccid, type, num, cvv, month, yr) VALUES (4, 'mastercard', '9876543210', '321', 'dec', '2020');
INSERT INTO CreditCard (ccid, type, num, cvv, month, yr) VALUES (5, 'visa', '9876543210', '321', 'dec', '2020');
INSERT INTO CreditCard (ccid, type, num, cvv, month, yr) VALUES (6, 'mastercard', '9876543210', '321', 'dec', '2020');
INSERT INTO CreditCard (ccid, type, num, cvv, month, yr) VALUES (7, 'visa', '0123456789', '123', 'jan', '2019');