drop table article;

DROP TABLE board;

--#1. �Խ��� ���̺� ����
CREATE TABLE board(
	board_id NUMBER(2)       NOT NULL,  -- �Խ��� �ĺ���ȣ
    category NUMBER(2)       NOT NULL,  -- �Խ��� ����
	title    VARCHAR2(100)   NOT NULL,  -- �Խ��� �̸�
    description VARCHAR2(200)             -- �Խ��� ����
);


--#2. ���̺� ������� �߰�
ALTER TABLE board
	ADD CONSTRAINT board_id_pk PRIMARY KEY(board_id);


--#3. �Խ��� ���
INSERT INTO board(board_id, category, title, description)
VALUES (1, 1, '�����Խ���', '������ �����Ӱ� ���� ���� �� �ִ� �����Խ����Դϴ�.');

INSERT INTO board(board_id, category, title, description)
VALUES (2, 1, '�����ڷ��', '�ڹ� ���� �ڷᰡ ǳ���� ���� �ڷ���Դϴ�.');

INSERT INTO board(board_id, category, title, description)
VALUES (3, 1, '������ϱ�', 'IT ���� �����̵� ���� ������.');

INSERT INTO board(board_id, category, title, description)
VALUES (4, 2, '����/����', 'IT ���� ����/���� �Խ����Դϴ�.');

COMMIT;

select * from board;

--#4. �Խñ�(�ű�/���) ���̺� ����
CREATE TABLE article(
	article_id    NUMBER(7)        NOT NULL,                   -- �Խñ� �ĺ���ȣ
    board_id      NUMBER(2)        DEFAULT 1 NOT NULL,         -- �Ҽ� �Խ���
    writer        VARCHAR2(20)     NOT NULL,                   -- �ۼ��� ���̵�
    subject       VARCHAR2(200)    NOT NULL,                   -- ������
    content       VARCHAR2(4000)   NOT NULL,                   -- �۳���
    regdate       DATE             DEFAULT SYSDATE NOT NULL,   -- �Խñ� ��ϳ�¥
    hitcount      NUMBER(5)        DEFAULT 0 NOT NULL,         -- ��ȸ��
    ip	          VARCHAR2(20)     NOT NULL,                   -- �ۼ��� ������
    passwd        VARCHAR2(8)      NOT NULL,                   -- �Խñ� ��й�ȣ
    attach_file   VARCHAR2(20),                                -- ÷������
    group_no      NUMBER(7)        NOT NULL,                   -- ������ ������ ���� �׷��ȣ
    step_no       NUMBER(2)        NOT NULL,                   -- ������ ������ ���� �׷쳻 �Խù� ���ܹ�ȣ
    order_no      NUMBER(3)        NOT NULL                    -- ������ ������ ���� �׷쳻 �Խù� ������ȣ
);

--#5. ���̺� ������� �߰�
ALTER TABLE article
	ADD (CONSTRAINT article_id_pk PRIMARY KEY(article_id),
         CONSTRAINT article_boardid_fk FOREIGN KEY(board_id)
            REFERENCES board(board_id),
         CONSTRAINT article_writer_fk  FOREIGN KEY(writer)
            REFERENCES users(id));


--#6. �Խñ� �ĺ���ȣ�� ���� ������ ����
CREATE SEQUENCE article_id_seq
    START WITH   1
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 999999;


-- �ʿ�� �Խñۿ� ���� ��� ���̺� ����
-- CREATE TABLE comment(-----);

--#7. �����Խ��� �űԱ�  ���  �׽�Ʈ
INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', 'ù��° �űԱ��Դϴ�.', '�Խñ� �����Դϴ�..', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'hong', '�ι�° �űԱ��Դϴ�.', '�Խñ� �����Դϴ�..', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', '����° �űԱ��Դϴ�.', '�Խñ� �����Դϴ�..', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY article_id DESC;


-- #8. ù��° �űԱۿ� ���� ù��° �亯�� ��� �׽�Ʈ
--�亯���� ������ ��� ���� �亯���� order_no�� 1 ������Ų �� �Է��Ͽ��� �Ѵ�
UPDATE article
SET order_no = order_no + 1
WHERE  board_id = 1 AND group_no = 1 AND order_no > 0;

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'hong', '�űԱۿ� ���� ù��° �亯���Դϴ�', '�亯�� �����Դϴ�.', '192.168.0.150', '1111', 1, 1, 1);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#9. ù��° �űԱۿ� ���� �ι�° �亯�� ��� �׽�Ʈ
--�亯���� ������ ��� ���� �亯���� order_no�� 1 ������Ų �� �Է��Ͽ��� �Ѵ�

UPDATE article
SET order_no = order_no + 1
WHERE board_id = 1 AND group_no = 1 AND order_no > 0;

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'hong', '�űԱۿ� ���� �ι�° �亯���Դϴ�', '�亯�� �����Դϴ�.', '192.168.0.150', '1111', 1, 1, 1);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#10. ù��° �亯�ۿ� ���� �Ǵٸ� �亯�� �Է�
--�亯���� ������ ��� ���� �亯���� order_no�� 1 ������Ų �� �Է��Ͽ��� �Ѵ�
UPDATE article
SET order_no = order_no + 1
WHERE board_id = 1 AND group_no = 1 AND order_no > 2;

INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', 'ù��° �亯�ۿ� ���� �亯���Դϴ�.', '�亯�� �����Դϴ�.', '127.0.0.1', '1111', 1, 2, 3);

COMMIT;

SELECT *
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#11. �Խñ� ��ü��� ��ȸ �׽�Ʈ�� ���� �������� �űԱ� ���
INSERT INTO article(article_id, board_id, writer, subject, content, ip, passwd, group_no, step_no, order_no)
VALUES(article_id_seq.NEXTVAL, 1, 'bangry', '�űԱ� �����Դϴ�.', '�űԱ� �����Դϴ�.', '127.0.0.1', '1111', article_id_seq.CURRVAL, 0, 0);

COMMIT;


--#12. ������ �Խ����� ���� ��ü��� ��ȸ
SELECT article_id, subject, writer, regdate, ip, hitcount, group_no, step_no, order_no
FROM article
WHERE board_id = 1
ORDER BY group_no DESC, order_no ASC;


--#13. ��ü��� ����¡ ó���� ���� ��ȸ(�����÷�(rownum)�� �������� Ȱ��)
SELECT request_page, article_id, subject, writer, regdate, ip, hitcount
FROM (SELECT CEIL(rownum / 10) request_page, article_id, subject, writer, TO_CHAR(regdate, 'YYYY-MM-DD') regdate, ip, hitcount
      FROM (SELECT rownum, article_id, subject, writer, regdate, ip, hitcount
            FROM article
            WHERE board_id = 1
            ORDER BY group_no DESC, order_no ASC))
WHERE request_page = 1;


--#14. �˻�Ÿ�Ժ� ��ȸ
SELECT request_page, article_id, subject, writer, regdate, ip, hitcount
FROM (SELECT CEIL(rownum / 10) request_page, article_id, subject, writer, TO_CHAR(regdate, 'YYYY-MM-DD') regdate, ip, hitcount
      FROM (SELECT rownum, article_id, subject, writer, regdate, ip, hitcount
            FROM article
            WHERE board_id = 1 AND subject  LIKE '%�űԱ�%'
            --WHERE board_id = 1 AND content LIKE '%�亯��%'
            --WHERE board_id = 1 AND writer = 'bangry'
            ORDER BY group_no DESC, order_no ASC))
WHERE request_page = 1;


-- #15. �Խñ� �󼼺���
SELECT subject, content, writer, TO_CHAR(regdate, 'yyyy-MM-DD HH24:MM:SS') regdate, ip, hitcount
FROM article
WHERE board_id = 1 AND article_id = 1;


-- #16. �Խñ� �󼼺��� �� ��ȸ�� ����
UPDATE article
SET hitcount = hitcount + 1
WHERE board_id = 1 AND article_id = 1;

COMMIT;