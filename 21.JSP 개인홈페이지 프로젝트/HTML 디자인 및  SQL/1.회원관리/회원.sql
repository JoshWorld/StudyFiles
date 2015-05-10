DROP TABLE users;

-- �����(ȸ��) ���� ������ ���� ���̺�
CREATE TABLE users(
  id       VARCHAR2(8)  NOT NULL,
  passwd   VARCHAR2(8)  NOT NULL,
  name     VARCHAR2(20) NOT NULL,
  email    VARCHAR2(50) NOT NULL,
  mobile1  VARCHAR2(3),
  mobile2  VARCHAR2(4),
  mobile3  VARCHAR2(4),
  job      VARCHAR2(20),
  path     VARCHAR2(20),
  profile  VARCHAR2(1000),
  regdate  DATE DEFAULT SYSDATE,
  point    NUMBER(5) DEFAULT 100
);

-- ���̺� ������� �߰�
ALTER TABLE users
	ADD CONSTRAINT users_id_pk PRIMARY KEY(id);


INSERT INTO users (id, passwd, name, email, mobile1, mobile2, mobile3, job, path, profile)
VALUES ('bangry', '1111', '�����', 'bangry313@gmail.com', '010', '1234', '1234', '������', '���ͳ�', '������ ���α׷��� �����Դϴ�.');

COMMIT;
