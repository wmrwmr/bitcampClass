아래 DDL은 책 정보를 저장하는 테이블입니다. 이 테이블을 기준으로 아래 문제를 해결하시오.
CREATE TABLE Book (
  bookid      NUMBER(2) PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);

CREATE TABLE  Customer (
  custid      NUMBER(2) PRIMARY KEY,  
  name        VARCHAR2(40),
  address     VARCHAR2(50),
  phone       VARCHAR2(20)
);


CREATE TABLE Orders (
  orderid NUMBER(2) PRIMARY KEY,
  custid  NUMBER(2) REFERENCES Customer(custid),
  bookid  NUMBER(2) REFERENCES Book(bookid),
  saleprice NUMBER(8) ,
  orderdate DATE
);
-- Book, Customer, Orders 데이터 생성
INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO Book VALUES(2, '축구아는 여자', '나무수', 13000);
INSERT INTO Book VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO Book VALUES(4, '골프 바이블', '대한미디어', 35000);
INSERT INTO Book VALUES(5, '피겨 교본', '굿스포츠', 8000);
INSERT INTO Book VALUES(6, '역도 단계별기술', '굿스포츠', 6000);
INSERT INTO Book VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO Book VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book VALUES(9, '올림픽 이야기', '삼성당', 7500);
INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

INSERT INTO Customer VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001');
INSERT INTO Customer VALUES (2, '김연아', '대한민국 서울', '000-6000-0001');  
INSERT INTO Customer VALUES (3, '장미란', '대한민국 강원도', '000-7000-0001');
INSERT INTO Customer VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001');
INSERT INTO Customer VALUES (5, '박세리', '대한민국 대전',  NULL);

-- 주문(Orders) 테이블의 책값은 할인 판매를 가정함
INSERT INTO Orders VALUES (1, 1, 1, 6000, TO_DATE('2014-07-01','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (2, 1, 3, 21000, TO_DATE('2014-07-03','yyyy-mm-dd'));
INSERT INTO Orders VALUES (3, 2, 5, 8000, TO_DATE('2014-07-03','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (4, 3, 6, 6000, TO_DATE('2014-07-04','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (5, 4, 7, 20000, TO_DATE('2014-07-05','yyyy-mm-dd'));
INSERT INTO Orders VALUES (6, 1, 2, 12000, TO_DATE('2014-07-07','yyyy-mm-dd'));
INSERT INTO Orders VALUES (7, 4, 8, 13000, TO_DATE( '2014-07-07','yyyy-mm-dd'));
INSERT INTO Orders VALUES (8, 3, 10, 12000, TO_DATE('2014-07-08','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (9, 2, 10, 7000, TO_DATE('2014-07-09','yyyy-mm-dd')); 
INSERT INTO Orders VALUES (10, 3, 8, 13000, TO_DATE('2014-07-10','yyyy-mm-dd'));

COMMIT;

CREATE TABLE Book_log(
	bookid_l NUMBER,
	bookname_l VARCHAR2(40),
	publisher_l VARCHAR2(40),
	price_l NUMBER
);


1．동일한 도서가 있는지 점검한 후 삽입하는 프로시저(BookInsertOrUpdate)를 작성하시오.
create or replace procedure BookInsertOrUdpate(

    myBookId number,
    myBookName varchar2,
    myPublisher varchar2,
    myPrice number    
)
as

    mycount number;
begin

    select count(*) into mycount from book where bookname like myBookName;

    if mycount != 0 then

        update book set price = myPrice where bookname like myBookname;
    else

        insert into book values (myBookId, myBookName, myPublisher, myPrice);
    end if;
end
;

2．판매된 도서에 대한 이익을 계산하는 함수(fnc_Icom)를 작성하시오.
（이익금 계산 조건 :　가격이 30,000원 이상이면 10%, 30,000원 미만이면 5% ）
create or replace procedure fnc_Icom
as
myInterest numeric;
Price numericC;
cursor InterestCursor is select saleprice from Orders;
begin
myInterest := 0.0;
open InterestCursor;
loop
fetch InterestCursor into Price;
exit when InterestCursor%NOTFOUND;
if Price >= 30000 then
myInterest := myInterest + Price * 0.1;
else
myInterest := myInterest + Price * 0.05;
end if;
end loop;
close InterestCursor;
DBMS_OUTPUT.PUT_LINE(' 전체 이익 금액 = ' || myInterest);
end;



3．새로운 도서를 삽입한 후 자동으로 Book_log 테이블에 삽입한 내용을 기록하는 트리거를 작성하시오.

create or replace trigger afterInsertBook
after insert on book for each row
declare

    average number;
begin
    insert into book_log
    values (:new.bookid, :new.bookname, :new.publisher, :new.price);
end
;



