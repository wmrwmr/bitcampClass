DROP TABLE IF EXISTS `project`.`GuestBook` RESTRICT;

-- 방명록
CREATE TABLE `project`.`GuestBook` (
	`idx`       INT         NOT NULL, -- 게시물고유번호
	`subject`   VARCHAR(50) NOT NULL, -- 제목
	`content`   TEXT        NOT NULL, -- 내용
	`regdate`   TIMESTAMP   NULL,     -- 작성일시
	`memberidx` INT         NOT NULL  -- 회원고유번호
);

-- 방명록
ALTER TABLE `project`.`GuestBook`
	ADD CONSTRAINT `PK_GuestBook` -- 방명록 기본키
		PRIMARY KEY (
			`idx` -- 게시물고유번호
		);

-- 방명록
ALTER TABLE `project`.`GuestBook`
	ADD CONSTRAINT `FK_Member_TO_GuestBook` -- 회원 -> 방명록
		FOREIGN KEY (
			`memberidx` -- 회원고유번호
		)
		REFERENCES `project`.`Member` ( -- 회원
			`idx` -- 회원고유번호
		);


-----------------------------------------------------------------------------------

-- 댓글
ALTER TABLE `project`.`reply`
	DROP FOREIGN KEY `FK_Member_TO_reply`; -- 회원 -> 댓글

-- 댓글
ALTER TABLE `project`.`reply`
	DROP FOREIGN KEY `FK_GuestBook_TO_reply`; -- 방명록 -> 댓글

-- 댓글
ALTER TABLE `project`.`reply`
	DROP PRIMARY KEY; -- 댓글 기본키

-- 댓글
DROP TABLE IF EXISTS `project`.`reply` RESTRICT;

-- 댓글
CREATE TABLE `project`.`reply` (
	`idx`          INT       NOT NULL, -- 댓글고유번호
	`content`      TEXT      NOT NULL, -- 내용
	`regdate`      TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP, -- 작성일시
	`memberidx`    INT       NOT NULL, -- 회원고유번호
	`guestbookidx` INT       NOT NULL  -- 게시물고유번호
);

-- 댓글
ALTER TABLE `project`.`reply`
	ADD CONSTRAINT `PK_reply` -- 댓글 기본키
		PRIMARY KEY (
			`idx` -- 댓글고유번호
		);

ALTER TABLE `project`.`reply`
	MODIFY COLUMN `idx` INT NOT NULL AUTO_INCREMENT;

-- 댓글
ALTER TABLE `project`.`reply`
	ADD CONSTRAINT `FK_Member_TO_reply` -- 회원 -> 댓글
		FOREIGN KEY (
			`memberidx` -- 회원고유번호
		)
		REFERENCES `project`.`Member` ( -- 회원
			`idx` -- 회원고유번호
		);

-- 댓글
ALTER TABLE `project`.`reply`
	ADD CONSTRAINT `FK_GuestBook_TO_reply` -- 방명록 -> 댓글
		FOREIGN KEY (
			`guestbookidx` -- 게시물고유번호
		)
		REFERENCES `project`.`GuestBook` ( -- 방명록
			`idx` -- 게시물고유번호
		);
ALTER TABLE `project`.`reply`
	ADD CONSTRAINT `FK_GuestBook_TO_reply` -- 방명록 -> 댓글
		FOREIGN KEY (
			`guestbookidx` -- 게시물고유번호
		)
		REFERENCES `project`.`GuestBook` ( -- 방명록
			`idx` -- 게시물고유번호
		);