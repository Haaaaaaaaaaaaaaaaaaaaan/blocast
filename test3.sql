select * from class

create sequence seq_class
start with 1
increment by 1

select seq_class.NEXTVAL FROM DUAL

INSERT INTO ANSWER values(ANSWER_ID_SEQ.NEXTVAL,sysdate, 'nayoung', 1, '��¼����', 0,null,null,null);

INSERT INTO CLASS values(seq_class.NEXTVAL,'name',sysdate);

select * from USERS;
select * from question;
select * from TAG;
delete from TAG;
delete from TAGLIST;

select * from TAGLIST;
delete from QUESTION;

DROP TABLE QUESTION;
DROP 

INSERT INTO QUESTION values(QUESTION_ID_SEQ.NEXTVAL, '���ü��',SYSDATE);

INSERT INTO QUESTION values(QUESTION_ID_SEQ.NEXTVAL, 'null ������','nayoung',0, SYSDATE, 'JAVA NULLPOINTER ��������Ф�',1,null,null,null,null);
INSERT INTO CLASS values(CLASS_ID_SEQ.NEXTVAL, '������',SYSDATE);
INSERT INTO CLASS values(CLASS_ID_SEQ.NEXTVAL, 'IOT',SYSDATE);

INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'JAVA');
INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'PYTHON');
INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'SPRING');
INSERT INTO TAG values(TAG_ID_SEQ.NEXTVAL, 'IOT');