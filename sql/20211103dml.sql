
-- 2021.11.03
-- DML: 입력, 수정, 삭제




-- 테스트 테이블 생성
drop table dept01;
create table dept01 (
    deptno number(2),
    dname varchar2(20),
    loc varchar2(20) default '서울'
);

-- 데이터의 입력
-- insert into {테이블명} (컬럼명, ...) values (data, ...);
-- 입력하고자 하는 컬럼의 개수와 입력데이터의 개수는 일치해야 한다.
-- 컬럼의 도메인과 입력데이터의 타입이 일치해야 한다.

insert into dept01 (deptno, dname, loc) values (20, 'DEV', 'SEOUL');
                    
-- 모든 컬럼의 데이터를 입력한 경우 컬럼을 기술하는 것을 생략 가능
insert into dept01 values (30, 'ACCOUNTING', null);
insert into dept01 values (30, 'ACCOUNTING', '');
insert into dept01 values (deptno, dname) (20, 'DEV');

select * from dept01;

-----------------------------------
-- 서브쿼리를 이용한 삽입

drop table dept02;

create table dept02
as
select * from dept where 1=2;
select * from dept02;

insert into dept02 select * from dept;












