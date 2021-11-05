
-- 함수 호출 후 출력

select orderid, custid, bookid, saleprice, func_interest(saleprice)
from orders
;