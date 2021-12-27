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













