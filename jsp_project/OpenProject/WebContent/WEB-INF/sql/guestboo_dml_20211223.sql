SELECT * FROM project.guestbook;

# insert
INSERT INTO guestbook (subject, content, memberidx) VALUES (?,?,?)
;


# select List
select 
	g.idx as idx , 
    g.subject as subject, 
    g.content as content, 
    m.username as username, 
    g.regdate as regdate,
    m.photo as photo 
from project.guestbook g join project.member m
on g.memberidx=m.idx
order by regdate desc
limit 0, 2
;
select g.idx as idx , g.subject as subject, g.content as content, g.regdate as regdate, m.username as username, m.photo as photo from project.guestbook g join project.member m on g.memberidx=m.idx order by regdate desc
limit 0, 2
;


# select idx
select 
	g.idx as idx , 
    g.subject as subject, 
    g.content as content, 
    m.username as username, 
    g.regdate as regdate,
    m.photo as photo ,
    m.idx as memberidx,
    m.userid as userid
from project.guestbook g join project.member m
on g.memberidx=m.idx
where g.idx=3
;
select g.idx as idx, g.subject as subject, g.content as content, m.username as username, g.regdate as regdate, m.photo as photo, m.idx as memberidx, m.userid as userid from project.guestbook g join project.member m on g.memberidx=m.idx where g.idx=3
;

select g.idx as idx, g.subject as subject, g.content as content, m.username as username, g.regdate as regdate, m.photo as photo, m.idx as memberidx, m.userid as userid from project.guestbook g join project.member m on g.memberidx=m.idx where g.idx=?
;



-- 아이디 중복 체크 sql
select count(*) from project.member where userid='test@gmail.com';
select count(*) from member where userid=?
;

select * from project.member;

select * from project.guestbook;

select * from project.reply;





# reply insert
INSERT INTO project.reply (content, memberidx, guestbookidx) VALUES ( 'test', 11, 7);
INSERT INTO project.reply (content, memberidx, guestbookidx) VALUES (?, ?, ?);


# replyListItem
select r.idx, r.content, r.regdate, r.memberidx, r.guestbookidx, m.username, m.photo
from project.member m join project.reply r
on m.idx=r.memberidx
where r.guestbookidx=8
;

select r.idx, r.content, r.regdate, r.memberidx, r.guestbookidx, m.username, m.photo from member m join reply r on m.idx=r.memberidx where r.guestbookidx=?
;

select * from project.reply;

# Reply  Delete
delete from project.reply where idx=3;

delete from reply where idx=?
;

