DROP TABLE IF EXISTS ITEMS;
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS BASKETS;

CREATE TABLE BASKETS (
  ID INTEGER NOT NULL AUTO_INCREMENT,

  PRIMARY KEY (ID)
);

CREATE TABLE USERS(
  ID INTEGER NOT NULL AUTO_INCREMENT,
  LOGIN   VARCHAR(50),
  PASSWORD  VARCHAR(50),

  BASKET_ID INTEGER,

  PRIMARY KEY (ID),
  FOREIGN KEY (BASKET_ID) REFERENCES BASKETS (ID)
);

CREATE TABLE ORDERS (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  ADRESS VARCHAR (50),
  COMPLETED  BIT DEFAULT '0',

  CLIENT_ID INTEGER,

  PRIMARY KEY (ID),
  FOREIGN KEY (CLIENT_ID) REFERENCES USERS(ID)
);

CREATE TABLE ITEMS (
  ID INTEGER NOT NULL AUTO_INCREMENT,
  NAME   VARCHAR(50),
  PRICE         INTEGER,

  BASKET_ID INTEGER ,
  ORD_ID INTEGER ,

  PRIMARY KEY (ID),
  FOREIGN KEY (ORD_ID) REFERENCES ORDERS (ID),
  FOREIGN KEY (BASKET_ID) REFERENCES BASKETS (ID)
);

INSERT INTO BASKETS()VALUES ();

INSERT INTO USERS(LOGIN, PASSWORD, BASKET_ID)VALUES ('user','user',1);
INSERT INTO USERS(LOGIN, PASSWORD)VALUES ('admin','admin');

INSERT INTO ITEMS(NAME, PRICE)VALUES ('toy','235');
INSERT INTO ITEMS(NAME, PRICE)VALUES ('sweet','35');
INSERT INTO ITEMS(NAME, PRICE)VALUES ('candy','25');
INSERT INTO ITEMS(NAME, PRICE)VALUES ('rose','23');
INSERT INTO ITEMS(NAME, PRICE)VALUES ('lego','735');

