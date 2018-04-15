/** 
* Run the following query to obtain all foreign keys for the table
*/

SELECT
  ft.tablename,
  fc.constraintname
FROM sys.sysconstraints fc
JOIN sys.sysforeignkeys f ON f.constraintid = fc.constraintid
JOIN sys.sysconglomerates fg ON fg.conglomerateid = f.conglomerateid
JOIN sys.systables ft ON ft.tableid = fg.tableid
JOIN sys.sysschemas fs ON ft.schemaid = fs.schemaid
JOIN sys.sysconstraints pc ON pc.constraintid = f.keyconstraintid
JOIN sys.sysschemas ps ON pc.schemaid = ps.schemaid
WHERE fc.type = 'F'

/** 
* build the corresponding ALTER TABLE DROP CONSTRAINT statement.
*/

ALTER TABLE POITEM DROP CONSTRAINT SQL180415010931912;
ALTER TABLE REVIEW DROP CONSTRAINT SQL180415010936061;
ALTER TABLE VISITEVENT DROP CONSTRAINT SQL180415010940220;
ALTER TABLE VISITEVENT DROP CONSTRAINT SQL180415010940222;
ALTER TABLE PO DROP CONSTRAINT SQL180415010927761;
ALTER TABLE REVIEW DROP CONSTRAINT SQL180415010936062;
ALTER TABLE PO DROP CONSTRAINT SQL180415010927762;
ALTER TABLE POITEM DROP CONSTRAINT SQL180415010931911;


/** 
* Drop all tables
*/

DROP TABLE Address;
DROP TABLE Book;
DROP TABLE PO;
DROP TABLE POItem;
DROP TABLE Review;
DROP TABLE Users;
DROP TABLE VisitEvent;
