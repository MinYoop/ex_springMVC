DROP TABLE TB_CUSTOMER;

CREATE TABLE TB_CUSTOMER(
ID VARCHAR2(100) PRIMARY KEY,
PASSWORD VARCHAR2(100) NOT NULL,
NAME VARCHAR2(100) NOT NULL
);
INSERT INTO TB_CUSTOMER VALUES('admin','admin1234','관리자');

SELECT * FROM TB_CUSTOMER;
