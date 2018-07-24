select * from class

create sequence seq_class
start with 1
increment by 1

select seq_class.NEXTVAL FROM DUAL

INSERT INTO CLASS values(seq_class.NEXTVAL,'name',sysdate);

select * from USERS;
select * from question;
select * from TAG;
delete from TAG;
delete from TAGLIST;
delete from QUESTION;

DROP 

INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'JAVA');
INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'PYTHON');
INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'SPRING');
INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'IOT');