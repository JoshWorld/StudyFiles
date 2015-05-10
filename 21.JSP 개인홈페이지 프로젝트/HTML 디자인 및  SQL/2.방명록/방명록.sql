-- ���� ���̺� ����
CREATE TABLE guestbook (
	guestbook_id NUMBER,
	writer       VARCHAR2(20)   NOT NULL,
  content      VARCHAR2(4000) NOT NULL,
  regdate      DATE           DEFAULT SYSDATE NOT NULL
);

-- ���̺� ������� �߰�
ALTER TABLE guestbook
	ADD ( CONSTRAINT guestbook_id_pk PRIMARY KEY(guestbook_id),
        CONSTRAINT guestbook_writer_fk FOREIGN KEY(writer)
        	REFERENCES users(id));

-- ������ ����
CREATE SEQUENCE guestbook_seq
	START WITH 1
  NOCYCLE;

-- �׽�Ʈ �Է� �� �˻�
INSERT INTO guestbook(guestbook_id, writer, content)
VALUES (GUESTBOOK_SEQ.NEXTVAL, 'bangry', '���� ���� �����մϴ�.');

COMMIT;

SELECT guestbook_id, writer, content, TO_CHAR(regdate, 'YYYY.MM.DD HH24:MI') regdagte
FROM guestbook
ORDER BY guestbook_id desc;




