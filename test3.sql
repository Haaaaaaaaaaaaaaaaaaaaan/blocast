select * from class

create sequence seq_class
start with 1
increment by 1

select seq_class.NEXTVAL FROM DUAL

INSERT INTO CLASS values(seq_class.NEXTVAL,'name',sysdate);

select * from class