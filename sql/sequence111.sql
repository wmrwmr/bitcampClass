DROP SEQUENCE ORDERS_ID_seq;


select * from orders;
insert into orders (OID,tid, fid) values (ORDERS_ID_seq.nextval, 1, 6);



select sum(fprice) from food natural join orders where tid = 1;

