create table food(
    fid number(2) constraint food_id_pk primary key,
    fname varchar2(40) not null,
    fprice number(10) not null
    );
    
create sequence food_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 99;
    
insert into Food
values(food_id_seq.nextval, '그린 샐러드', 19000);
insert into Food
values(food_id_seq.nextval, '안심 스테이크', 43000);
insert into Food
values(food_id_seq.nextval, '채끝등심 스테이크', 45000);
insert into Food
values(food_id_seq.nextval, '페퍼로니 피자', 27000);
insert into Food
values(food_id_seq.nextval, '포테이토 피자', 25000);
insert into Food
values(food_id_seq.nextval, '까르보나라', 26000);
insert into Food
values(food_id_seq.nextval, '트러플 파스타', 30000);
insert into Food
values(food_id_seq.nextval, '자몽에이드', 7000);
insert into Food
values(food_id_seq.nextval, '탄산음료', 5000);
insert into Food
values(food_id_seq.nextval,'테라 생맥주', 8000);

select * from food;

--------------------------------------------------------------------

create table orders (
    oid number(6) constraint orders_id_pk primary key,
    tid number(2) not null constraint orders_tid_ck check (tid between 1 and 5),
    fid number(2) not null constraint orders_fid_ck references food(fid),
    ordertime timeStamp default sysdate not null
    );
    
create sequence orders_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;

insert into orders values (ORDERS_ID_SEQ.nextval, 1, 1, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 1, 2, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 1, 3, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 3, 4, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 3, 1, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 3, 8, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 3, 10, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 4, 6, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 4, 7, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 5, 3, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 5, 4, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 5, 9, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 5, 1, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 5, 8, sysdate);

select * from orders;

--------------------------------------------------------------------

create table reservation (
    rid number (6) constraint reservation_id_pk primary key,
    rdate timeStamp not null,
    rname varchar2(20) not null,
    rphone varchar2(20) not null,
    rnum number (1) not null,
    tid number(2) not null constraint reservation_tid_ck check (tid between 1 and 5)
   );
   
create sequence reservation_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;

insert into reservation values (reservation_id_seq.nextval, '21-11-15 18', '김태희', '010-3925-4834', 2, 2);
insert into reservation values (reservation_id_seq.nextval, '21-11-15 19', '원빈', '010-2232-3052', 1, 4);
insert into reservation values (reservation_id_seq.nextval, '21-11-15 20', '한가인', '010-1124-4352', 2, 1);
insert into reservation values (reservation_id_seq.nextval, '21-11-16 18', '송혜교', '010-6653-9493', 3, 5);
insert into reservation values (reservation_id_seq.nextval, '21-11-16 19', '박보검', '010-2350-1782', 4, 3);
insert into reservation values (reservation_id_seq.nextval, '21-11-17 18', '소지섭', '010-9232-7965', 2, 1);

select * from reservation;

--------------------------------------------------------------------

create table members(
    mid number(6) constraint members_id_pk primary key,
    mname varchar2(20) not null,
    mphone varchar2(20) not null unique,
    bonus number(10) default 0 not null
);

create sequence members_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;

insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '지수', '010-4455-4204',550);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '제니', '010-3928-2302',2830);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '로제', '010-1043-9983',1700);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '리사', '010-4577-1102',330);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '카리나', '010-3455-8949',1350);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '윈터', '010-4520-0980',2030);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '지젤', '010-7711-4677',970);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '닝닝', '010-8796-0754',2440);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '임나연', '010-2441-4677',2800);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '유정연', '010-0987-6876',1700);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '모모', '010-1643-0908',5200);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '사나', '010-5733-7545',1300);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '박지효', '010-7796-0908',550);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '미나', '010-3433-2779',9950);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '김다현', '010-6744-9983',1423);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '손채영', '010-7089-0765',3635);
insert into members (mid, mname, mphone, bonus) values (members_id_seq.nextval, '쯔위', '010-3452-6336',976);

select * from members;

--------------------------------------------------------------------

commit;

delete food;
delete orders;
delete reservation;
delete members;

drop table food;
drop table orders;
drop table reservation;
drop table members;

drop sequence food_id_seq;
drop sequence orders_id_seq;
drop sequence reservation_id_seq;
drop sequence members_id_seq;