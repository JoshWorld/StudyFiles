drop table article;

DROP TABLE board;

--#1. 게시판 테이블 생성
CREATE TABLE board(
	board_id NUMBER(2)       NOT NULL,  -- 게시판 식별번호
    category NUMBER(2)       NOT NULL,  -- 게시판 범주
	title    VARCHAR2(100)   NOT NULL,  -- 게시판 이름
    description VARCHAR2(200)             -- 게시판 설명
);


--#2. 테이블에 제약사항 추가
ALTER TABLE board
	ADD CONSTRAINT board_id_pk PRIMARY KEY(board_id);


--#3. 게시판 등록
INSERT INTO board(board_id, category, title, description)
VALUES (1, 1, '자유게시판', '누구나 자유롭게 글을 쓰실 수 있는 자유게시판입니다.');

INSERT INTO board(board_id, category, title, description)
VALUES (2, 1, '만땅자료실', '자바 관련 자료가 풍부한 만땅 자료실입니다.');

INSERT INTO board(board_id, category, title, description)
VALUES (3, 1, '묻고답하기', 'IT 관련 무엇이든 물어 보세요.');

INSERT INTO board(board_id, category, title, description)
VALUES (4, 2, '구인/구직', 'IT 관련 구인/구직 게시판입니다.');

COMMIT;

select * from board;

--#4. 게시글(신규/답글) 테이블 생성
CREATE TABLE article(
	article_id    NUMBER(7)        NOT NULL,                   -- 게시글 식별번호
    board_id      NUMBER(2)        DEFAULT 1 NOT NULL,         -- 소속 게시판
    writer        VARCHAR2(20)     NOT NULL,                   -- 작성자 아이디
    subject       VARCHAR2(200)    NOT NULL,                   -- 글제목
    content       VARCHAR2(4000)   NOT NULL,                   -- 글내용
    regdate       DATE             DEFAULT SYSDATE NOT NULL,   -- 게시글 등록날짜
    hitcount      NUMBER(5)        DEFAULT 0 NOT NULL,         -- 조회수
    ip	          VARCHAR2(20)     NOT NULL,                   -- 작성자 아이피
    passwd        VARCHAR2(8)      NOT NULL,                   -- 게시글 비밀번호
    attach_file   VARCHAR2(20),                                -- 첨부파일
    group_no      NUMBER(7)        NOT NULL,                   -- 계층형 구조를 위한 그룹번호
    step_no       NUMBER(2)        NOT NULL,                   -- 계층형 구조를 위한 그룹내 게시물 스텝번호
    order_no      NUMBER(3)        NOT NULL                    -- 계층형 구조를 위한 그룹내 게시물 순서번호
);

--#5. 테이블에 제약사항 추가
ALTER TABLE article
	ADD (CONSTRAINT article_id_pk PRIMARY KEY(article_id),
         CONSTRAINT article_boardid_fk FOREIGN KEY(board_id)
            REFERENCES board(board_id),
         CONSTRAINT article_writer_fk  FOREIGN KEY(writer)
            REFERENCES users(id));


--#6. 게시글 식별번호를 위한 시퀀스 생성
CREATE SEQUENCE article_id_seq
    START WITH   1
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 999999;


-- 필요시 게시글에 대한 댓글 테이블 생성
-- CREATE TABLE comment(-----);

--#7. 자유게시판 신규글  등록  테스트
INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', '첫번째 신규글입니다.', '게시글 내용입니다..', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'hong', '두번째 신규글입니다.', '게시글 내용입니다..', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', '세번째 신규글입니다.', '게시글 내용입니다..', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY article_id DESC;


-- #8. 첫번째 신규글에 대한 첫번째 답변글 등록 테스트
--답변글이 존재할 경우 기존 답변글의 order_no을 1 증가시킨 후 입력하여야 한다
UPDATE article
SET order_no = order_no + 1
WHERE  board_id = 1 AND group_no = 1 AND order_no > 0;

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'hong', '신규글에 대한 첫번째 답변글입니다', '답변글 내용입니다.', '192.168.0.150', '1111', 1, 1, 1);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#9. 첫번째 신규글에 대한 두번째 답변글 등록 테스트
--답변글이 존재할 경우 기존 답변글의 order_no을 1 증가시킨 후 입력하여야 한다

UPDATE article
SET order_no = order_no + 1
WHERE board_id = 1 AND group_no = 1 AND order_no > 0;

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'hong', '신규글에 대한 두번째 답변글입니다', '답변글 내용입니다.', '192.168.0.150', '1111', 1, 1, 1);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#10. 첫번째 답변글에 대한 또다른 답변글 입력
--답변글이 존재할 경우 기존 답변글의 order_no을 1 증가시킨 후 입력하여야 한다
UPDATE article
SET order_no = order_no + 1
WHERE board_id = 1 AND group_no = 1 AND order_no > 2;

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', '첫번째 답변글에 대한 답변글입니다.', '답변글 내용입니다.', '127.0.0.1', '1111', 1, 2, 3);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#11. 게시글 전체목록 조회 테스트를 위한 여러개의 신규글 등록
INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', '신규글 연습입니다.', '신규글 내용입니다.', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

COMMIT;


--#12. 계층형 게시판을 위한 전체목록 조회
SELECT article_id, subject, writer, regdate, ip, hitcount, group_no, step_no, order_no
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#13. 전체목록 페이징 처리를 위한 조회(가상컬럼(rownum)과 서브쿼리 활용)
SELECT request_page, article_id, subject, writer, regdate, ip, hitcount
FROM (SELECT CEIL(rownum / 10) request_page, article_id, subject, writer, TO_CHAR(regdate, 'YYYY-MM-DD') regdate, ip, hitcount
      FROM (SELECT rownum, article_id, subject, writer, regdate, ip, hitcount
            FROM article
            WHERE board_id = 1
            ORDER BY group_no DESC, order_no ASC))
WHERE request_page = 1;


--#14. 검색타입별 조회
SELECT request_page, article_id, subject, writer, regdate, ip, hitcount
FROM (SELECT CEIL(rownum / 10) request_page, article_id, subject, writer, TO_CHAR(regdate, 'YYYY-MM-DD') regdate, ip, hitcount
      FROM (SELECT rownum, article_id, subject, writer, regdate, ip, hitcount
            FROM article
            WHERE board_id = 1 AND subject  LIKE '%신규글%'
            --WHERE board_id = 1 AND content LIKE '%답변글%'
            --WHERE board_id = 1 AND writer = 'bangry'
            ORDER BY group_no DESC, order_no ASC))
WHERE request_page = 1;


-- #15. 게시글 상세보기
SELECT subject, content, writer, TO_CHAR(regdate, 'yyyy-MM-DD HH24:MM:SS') regdate, ip, hitcount
FROM article
WHERE board_id = 1 AND article_id = 1;


-- #16. 게시글 상세보기 시 조회수 증가
UPDATE article
SET hitcount = hitcount + 1
WHERE board_id = 1 AND article_id = 1;

COMMIT;