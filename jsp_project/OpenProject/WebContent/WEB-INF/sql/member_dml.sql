-- select
select * from project.member;
select * from member where userid=? and password=?
;
select * from project.member where userid='test@gmail.com' and password='12341';

-- limit index, count
select * from project.member limit 0, 2; -- 1p
select * from project.member limit 2, 2; -- 2p

select * from member order by regdate desc limit ?, ?;

-- index : (page-1)*count


select count(*) from project.member;

select count(*) from member;

select * from project.member where idx=1;
select * from member where idx=?
;


-- insert
INSERT INTO member ( userid, password, username ) VALUES (?,?,?)
;


-- update
update project.member
set password='999', username='손흥민', photo='min1.jpg'
where idx=11
;

update member set password=?, username=?, photo=? where idx=?
;

-- delete
DELETE FROM `project`.`member` WHERE idx=7;
DELETE FROM member WHERE idx=?;




-- update
update project.guestbook 
set regdate=CURRENT_TIMESTAMP, CONTENT=? WHERE IDX=2;



select * from project.guestbook;
select * from project.member;
