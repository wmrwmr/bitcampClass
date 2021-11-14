create table food(
    fid number(2) constraint food_id_pk primary key,
    fname varchar2(20) not null,
    fprice number(10) not null
    );
    
create sequence food_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 99;
    
insert into Food
values(food_id_seq.nextval, '그린 샐러드', 12000);
insert into Food
values(food_id_seq.nextval, '안심 스테이크', 24000);
insert into Food
values(food_id_seq.nextval, '갈릭 스테이크', 28000);
insert into Food
values(food_id_seq.nextval, '페퍼로니 피자', 19000);
insert into Food
values(food_id_seq.nextval, '포테이토 피자', 20000);
insert into Food
values(food_id_seq.nextval, '로제 파스타', 16000);
insert into Food
values(food_id_seq.nextval, '트러플 파스타', 18000);
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
insert into orders values (ORDERS_ID_SEQ.nextval, 3, 3, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 3, 5, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 4, 8, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 4, 9, sysdate);
insert into orders values (ORDERS_ID_SEQ.nextval, 4, 10, sysdate);

select * from orders;

--------------------------------------------------------------------

create table reservation (
    rid number (6) constraint reservation_id_pk primary key,
    rdate timeStamp not null,
    rname varchar2(20) not null,
    rphone varchar2(20) not null unique,
    rnum number (1) not null,
    tid number(2) not null constraint reservation_tid_ck check (tid between 1 and 5)
   );
   
create sequence reservation_id_seq
start with 1
increment by 1
minvalue 1
maxvalue 999999;

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

insert into members (mid, mname, mphone) values (members_id_seq.nextval, '지수', '010-4455-4204');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '제니', '010-3928-2302');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '로제', '010-1043-9983');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '리사', '010-4577-1102');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '카리나', '010-3455-8949');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '윈터', '010-4520-0980');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '지젤', '010-7711-3452');
insert into members (mid, mname, mphone) values (members_id_seq.nextval, '닝닝', '010-8796-0754');

select * from members;

--------------------------------------------------------------------

commit;

drop table food;
drop table orders;
drop table reservation;
drop table members;

drop sequence food_id_seq;
drop sequence orders_id_seq;
drop sequence reservation_id_seq;
drop sequence members_id_seq;