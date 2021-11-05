
-- 2021.11.05
-- function : 데이터를 받아서 처리후 결과를 반환

CREATE OR REPLACE FUNCTION func_Interest(
price NUMBER) RETURN INT
IS
myInterest NUMBER;
BEGIN
/* 가격이 30,000원 이상이면 10%, 30,000원 미만이면 5% */
IF Price >= 30000 THEN myInterest := Price * 0.1;
ELSE myInterest := Price * 0.05;
END IF;
RETURN myInterest;
END;























