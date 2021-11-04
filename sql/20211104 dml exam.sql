-- SELECT, UPDATE, DELETE, INSERT


------------------------------
select * from phoneInfo_basic;

insert into phoneInfo_basic
values (1, '홍길동', '010-1111-1111', '홍길동@gmail.com', '서울', sysdate)
;
insert into phoneInfo_basic
values (2, '장길산', '010-2222-2222', '장길산@gmail.com', '인천', sysdate)
;
insert into phoneInfo_basic
values (3, '임꺽정', '010-3333-3333', '임꺽정@gmail.com', '대전', sysdate)
;
insert into phoneInfo_basic
values (4, '김춘향', '010-5555-5555', '김춘향@gmail.com', '대구', sysdate)
;
insert into phoneInfo_basic
values (5, '이몽룡', '010-6666-6666', '이몽룡@gmail.com', '부산', sysdate)
;

update phoneinfo_basic
set fr_phonenumber = '010-4444-4444'
where idx=3
;

update phoneinfo_basic
set (fr_phonenumber, fr_address) = (select fr_phonenumber, fr_address from phoneinfo_basic where idx = 2)
where idx = 1
;

delete 
from phoneinfo_basic
where idx = 1
;

-----------------------------
select * from phoneInfo_univ;

insert into phoneInfo_univ
values (1, '전자', '3', 2)
;

insert into phoneInfo_univ
values (2, '정치', '1', 3)
;

update phoneInfo_univ
set fr_u_major = '화학', fr_u_year = 2
where idx = 1
;

delete from phoneInfo_univ;

-----------------------------
select * from phoneInfo_com;

insert into phoneinfo_com
values (1, '오성전자', 4)
;

insert into phoneinfo_com
values (2, '태광물산', 5)
;

update phoneInfo_com
set fr_c_company = '오성전자'
;

delete 
from phoneInfo_com
where idx = 2
;






