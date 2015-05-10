-- 방명록 테이블 생성
CREATE TABLE guestbook (
	guestbook_id NUMBER,
	writer       VARCHAR2(20)   NOT NULL,
  content      VARCHAR2(4000) NOT NULL,
  regdate      DATE           DEFAULT SYSDATE NOT NULL
);

-- 테이블에 제약사항 추가
ALTER TABLE guestbook
	ADD ( CONSTRAINT guestbook_id_pk PRIMARY KEY(guestbook_id),
        CONSTRAINT guestbook_writer_fk FOREIGN KEY(writer)
        	REFERENCES users(id));

-- 시퀀스 생성
CREATE SEQUENCE guestbook_seq
	START WITH 1
  NOCYCLE;

-- 테스트 입력 및 검색
INSERT INTO guestbook(guestbook_id, writer, content)
VALUES (GUESTBOOK_SEQ.NEXTVAL, 'bangry', '좋은 내용 감사합니다.');

COMMIT;

SELECT guestbook_id, writer, content, TO_CHAR(regdate, 'YYYY.MM.DD HH24:MI') regdagte
FROM guestbook
ORDER BY guestbook_id desc;




