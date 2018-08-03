DROP TABLE IF EXISTS QUESTION_THUMBSUP;
DROP TABLE IF EXISTS ANSWER_THUMBSUP;
DROP TABLE IF EXISTS ANSWER;
DROP TABLE IF EXISTS TAGLIST;
DROP TABLE IF EXISTS TAG;
DROP TABLE IF EXISTS QUESTION;
DROP TABLE IF EXISTS FILES;
DROP TABLE IF EXISTS FOLDERS;
DROP TABLE IF EXISTS CLASS;
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS(
		ID                            		VARCHAR(20)		 NOT NULL		 PRIMARY KEY,
		PWD                           		VARCHAR(20)		 NOT NULL,
		NAME                          		VARCHAR(20)		 NOT NULL,
		GENDER                        		VARCHAR(10)		 NOT NULL,
		EMAIL                         		VARCHAR(20)		 NOT NULL,
		REGDATE                       		DATE		 NOT NULL,
		ADMIN                         		VARCHAR(20)		 NULL 
);

CREATE TABLE CLASS(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		NAME                          		VARCHAR(20)		 NOT NULL,
		REGDATE                       		DATE		 NOT NULL
);

CREATE TABLE FOLDERS(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		CLASS_ID                      		MEDIUMINT(20)		 NOT NULL,
		NAME                          		VARCHAR(20)		 NOT NULL,
  FOREIGN KEY (CLASS_ID) REFERENCES CLASS (ID)
);

CREATE TABLE FILES(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		FOLDER_ID                     		MEDIUMINT(20)		 NOT NULL,
		NAME                          		VARCHAR(20)		 NOT NULL,
  FOREIGN KEY (FOLDER_ID) REFERENCES FOLDERS (ID)
);

CREATE TABLE QUESTION(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		TITLE                         		VARCHAR(200)		 NOT NULL,
		AUTHOR                        		VARCHAR(20)		 NOT NULL,
		THUMBSUP                      		MEDIUMINT(10)		 DEFAULT 0		 NOT NULL,
		REGDATE                       		DATE		 NOT NULL,
		CONTENTS                      		MEDIUMINT		 NOT NULL,
		CLASS_ID                      		MEDIUMINT(20)		 NOT NULL,
		STATE                         		VARCHAR(20)		 NOT NULL,
		IMGNAME1                      		VARCHAR(20)		 NULL ,
		IMGNAME2                      		VARCHAR(20)		 NULL ,
		IMGNAME3                      		VARCHAR(20)		 NULL ,
  FOREIGN KEY (AUTHOR) REFERENCES USERS (ID),
  FOREIGN KEY (CLASS_ID) REFERENCES CLASS (ID)
);

CREATE TABLE TAG(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		NAME                          		VARCHAR(20)		 NOT NULL
);

CREATE TABLE TAGLIST(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		QUESTION_ID                   		MEDIUMINT(20)		 NOT NULL,
		TAG_ID                        		MEDIUMINT(20)		 NOT NULL,
  FOREIGN KEY (TAG_ID) REFERENCES TAG (ID),
  FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION (ID)
);

CREATE TABLE ANSWER(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		REGDATE                       		DATE		 NOT NULL,
		AUTHOR                        		VARCHAR(20)		 NOT NULL,
		QUESTION_ID                   		MEDIUMINT(20)		 NOT NULL,
		CONTENT                       		MEDIUMINT		 NOT NULL,
		THUMBSUP                      		MEDIUMINT(10)		 DEFAULT 0		 NOT NULL,
		IMGNAME1                      		VARCHAR(20)		 NULL ,
		IMGNAME2                      		VARCHAR(20)		 NULL ,
		IMGNAME3                      		VARCHAR(20)		 NULL ,
  FOREIGN KEY (AUTHOR) REFERENCES USERS (ID),
  FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION (ID)
);

CREATE TABLE ANSWER_THUMBSUP(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		ANSWER_ID                     		MEDIUMINT(20)		 NOT NULL,
		USER_ID                       		VARCHAR(20)		 NOT NULL,
  FOREIGN KEY (ANSWER_ID) REFERENCES ANSWER (ID),
  FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);

CREATE TABLE QUESTION_THUMBSUP(
		ID                            		MEDIUMINT(20)		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		QUESTION_ID                   		MEDIUMINT(20)		 NOT NULL,
		USER_ID                       		VARCHAR(20)		 NOT NULL,
  FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION (ID),
  FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);

