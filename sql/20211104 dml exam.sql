-- SELECT, UPDATE, DELETE, INSERT


------------------------------
select * from phoneInfo_basic;
drop table phoneInfo_basic;
drop table phoneInfo_univ;
drop table phoneInfo_com;
drop sequence pib_idx_seq;
drop sequence piu_idx_seq;
drop sequence pic_idx_seq;
--------------------------
-- sequence 삽입
insert into phoneInfo_basic
values (pib_idx_seq.nextval, '홍길동', '010-1111-1111', '홍길동@gmail.com', '서울', sysdate)
;

insert into phoneInfo_univ
values (piu_idx_seq.nextval, '전자', '3', pib_idx_seq.currval)
;

insert into phoneInfo_basic
values (pib_idx_seq.nextval, '장길산', '010-2222-2222', '장길산@gmail.com', '인천', sysdate)
;

insert into phoneinfo_com
values (pic_idx_seq.nextval, '오성전자', pib_idx_seq.currval)
;

-- 삽입
insert into phoneInfo_basic
values (pib_idx_seq.nextval, '홍길동', '010-1111-1111', '홍길동@gmail.com', '서울', sysdate)
;
insert into phoneInfo_basic
values (pib_idx_seq.nextval, '장길산', '010-2222-2222', '장길산@gmail.com', '인천', sysdate)
;
insert into phoneInfo_basic
values (pib_idx_seq.nextval, '임꺽정', '010-3333-3333', '임꺽정@gmail.com', '대전', sysdate)
;
insert into phoneInfo_basic
values (pib_idx_seq.nextval, '김춘향', '010-5555-5555', '김춘향@gmail.com', '대구', sysdate)
;
insert into phoneInfo_basic
values (pib_idx_seq.nextval, '이몽룡', '010-6666-6666', '이몽룡@gmail.com', '부산', sysdate)
;

-- 전화번호 업데이트
update phoneinfo_basic
set fr_phonenumber = '010-4444-4444'
where idx=3
;

-- 전화번호, 주소 업데이트
update phoneinfo_basic
set (fr_phonenumber, fr_address) = (select fr_phonenumber, fr_address from phoneinfo_basic where idx = 2)
where idx = 1
;

-- 이름으로 검색
select * 
from phoneinfo_basic 
where fr_name like '%길%'
;

-- 전화번호로 검색
select * 
from phoneinfo_basic 
where fr_phonenumber like '%1111%'
;

-- pk로 검색
select * 
from phoneinfo_basic 
where idx=1
;

-- 1번 삭제
delete 
from phoneinfo_basic
where idx = 1
;

-----------------------------
select * from phoneInfo_univ;

-- 삽입
insert into phoneInfo_univ
values (piu_idx_seq.nextval, '전자', '3', pib_idx_seq.currval)
;
insert into phoneInfo_univ
values (piu_idx_seq.nextval, '정치', '1', pib_idx_seq.currval)
;

-- 업데이트
update phoneInfo_univ
set fr_u_major = '화학', fr_u_year = 2
where idx = 1
;

-- equi join
select * 
from phoneInfo_basic b, phoneInfo_univ u
where b.idx=u.fr_ref
;

-- 전체 삭제
delete from phoneInfo_univ;



-----------------------------
select * from phoneInfo_com;

-- 삽입
insert into phoneinfo_com
values (pic_idx_seq.nextval, '오성전자', pib_idx_seq.currval)
;
insert into phoneinfo_com
values (pic_idx_seq.nextval, '태광물산', pib_idx_seq.currval)
;

-- 업데이트
update phoneInfo_com
set fr_c_company = '오성전자'
;

-- equi join
select b.fr_name, b.fr_phonenumber, b.fr_email,
nvl (c.fr_c_company, '입력 데이터 없음') company
from phoneInfo_basic b, phoneInfo_com c
where b.idx=c.fr_ref(+)
;

-- 2번 삭제
delete 
from phoneInfo_com
where idx = 2
;


------------------------------
-- 전체 데이터 리스트 출력: 테이블 세개 join
select b.fr_name as 이름, b.fr_phonenumber as 전화번호, nvl(u.fr_u_major, '입력 데이터 없음') as 전공 , nvl(c.fr_c_company, '입력 데이터 없음') as 회사
from phoneinfo_basic b, phoneinfo_univ u, phoneinfo_com c
where b.idx=u.fr_ref(+) and b.idx=c.fr_ref(+)
order by b.idx
;






