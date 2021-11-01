-- 2021-11-01

-- JOIN

-- Cross Join: 단순히 테이블을 붙이는 조인
-- 컬럼을 붙이고, 행(데이터)는 집합의 합 연(카티즌 곱) -> 전체 행은 ==> R1의 행의 개수 곱하기 R2의 행의 개수
-- emp 테이블과 dept 테이블의 join -> 14 * 4 = 56개 행

-- Cross Join 문
-- select * from 테이블 명, 테이블 명, ...
select *
from emp, dept
;

select *
from emp cross join dept
;

-- Equi Join
-- 특정 컬럼의 같은 값을 비교해서 같은 결과 행만 추출

select *
from emp, dept
where emp.deptno = dept.deptno
;

-- SCOTT 사원의 부서 이름을 출력
select ename, emp.deptno, dept.dname -- dname
from emp, dept
where emp.deptno = dept.deptno
      and ename = 'SCOTT'
;

-- 테이블의 별칭 이용
select *
from emp e, dept d
where e.deptno = d.deptno
;

select *
from salgrade
;

select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal > s.losal and e.sal<=s.hisal
order by e.empno
;

-- Self Join
-- 나 자신을 참조해서 붙이는 조인
select e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno
order by e.mgr
;


-- Outer Join

select e.ename as ename, nvl(m.ename, '관리자 없음') as manager
from emp e, emp m
where e.mgr = m.empno(+)
order by e.mgr
;

-- Inner Join
-- select * 
-- from t1 inner join t2
-- on 컬럼의 비교 조건(Join의 비교)

-- SCOTT 사원의 사원 정보와 부서 정보를 inner join을 이용해서 출력
select *
from emp inner join dept
on emp.deptno = dept.deptno
where emp.ename = 'SCOTT'
;

select *
from emp join dept
on emp.deptno = dept.deptno
where emp.ename = 'SCOTT'
;

select *
from emp e join dept d
using (deptno)
;

select *
-- from emp inner join dept
-- on emp.deptno = dept.deptno
from emp NATURAL join dept
;

-- ANSI outter Join
-- from R1 [LEFT | RIGHT | FULL] outer join R2
-- 사원 이름과 상관의 이름을 출력
select e.ename, m.ename
from emp e left OUTER JOIN emp m
on e.mgr = m.empno
;

-- 테이블 세개 조인: 주문 내역 (고객정보, 책의 정보, 구매 정보)
-- 주문 고객의 이름과 책의 이름 구매 날짜와 구매 금액을 출력
select c.name, b.bookname, o.orderdate, o.saleprice
from book b, customer c, orders o
where o.custid = c.custid and o.bookid=b.bookid
;

--2021.11.01

-- 서브 쿼리(부속 질의)
-- select 구문 안에 또 다른 select 구문을 이용하는 sql문

-- SCPTT 사원의 부서 이름을 출력
select dname, emp.deptno 
from emp, dept
where emp.deptno = dept.deptno and ename = 'SCOTT'
;

select dname 
from dept 
where deptno=(select emp.deptno 
                from emp
                where ename = 'SCOTT')
;

-- SCOTT 사원의 부서 이름
-- 1. 내부 쿼리를 먼저 작성: SCOTT 사원의 부서 번호
-- 2. 외부 쿼리 작성: 부서 번호로 부서 이름을 검색


-- 마당 서점의 고객별 판매액을 보이시오(결과는 고객이름과 고객별 판매액을 출력)
select o.custid, c.name, sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
group by o.custid, c.name
;

-- 사원의 이름과 부서 이름을 출력
select ename, deptno,
        (select dname from dept where emp.deptno = dept.deptno)
from emp
;

-- 인라인 뷰: from 뒤에 오는 서브 쿼리 -> select의 결과를 테이블로 사용
--  고객번호가 2 이하인 고객의 판매액을 보이시오 (결과는 고객이름과 고객별 판매액 출력)

select o.custid, sum(saleprice)
from orders o,
        (select custid, name from customer where custid <=2) c
where o.custid = c.custid
group by o.custid
;

-- 간단한 버전

select custid, sum(saleprice)
from orders
where custid <=2
group by custid
;



-- 30번 부서의 인라인 뷰를 만들어서 사용
select *
from(select * from emp where deptno = 30)
;













