
-- 동일한 도서가 있는지 점건한 후 삽입하는 프로시저 (BookInsertOrUpdate)


create or replace procedure bookInsertOrUdpate(
    --매개변수
    myBookId number,
    myBookName varchar2,
    myPublisher varchar2,
    myPrice number    
)
as
 -- 변수 선언
    mycount number;
begin
    -- 입력받은 책 이름으로 같은 이름의 책을 보유했는지 그 여부를 확인하기 위한 숫자
    select count(*) into mycount from book where bookname like myBookName;
    -- 책의 개수로 분기: 수정 또는 입력
    if mycount != 0 then
        -- 가격 수정
        update book set price = myPrice where bookname like myBookname;
    else
        -- 데이터(행) 입력
        insert into book values (myBookId, myBookName, myPublisher, myPrice);
    end if;
end
;












