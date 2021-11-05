

-- 프로시저 호출: 실행 요청
-- exec 프로시저이름(매개변수 값,....);
exec insertbook(13, '스포츠과학', '마당과학서적', 25000);
select * from book;

--  같은 이름의 책을 등록해보고, 다른 이름의 책을 입력
-- 같은 이름의 책 등록
exec bookInsertOrUdpate(15, '스포츠과학', '마당과학서적', 40000);
select * from book;

-- 평균 값 구하기
/* 프로시저 AveragePrice를 테스트하는 부분 */
SET SERVEROUTPUT ON ;
DECLARE
AverageVal NUMBER;
BEGIN
AveragePrice(AverageVal);
DBMS_OUTPUT.PUT_LINE('책값 평균: '|| AverageVal);
END;


---------------------
set serveroutput on;
exec interset;

-------------------
-- 트리거 실행 테스트
insert into book values (20, '스포츠 과학2', '이상미디어', 60000);

select * from book;
select * from book_log;





