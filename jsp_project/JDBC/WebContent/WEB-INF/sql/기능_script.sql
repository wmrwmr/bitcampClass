
-- 부서의 전체 리스트 출력
select * from project.dept;

-- 부서 데이터 입력 sql
-- INSERT INTO `project`.`dept` (`deptno`, `dname`, `loc`) VALUES (<{deptno: }>, <{dname: }>, <{loc: }>);

INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?);

select * from project.dept where deptno=?;

-- 수정

UPDATE dept SET dname=?, loc=? WHERE deptno=?;





