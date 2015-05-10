-- DBA ����(sys, system)���� ���� �� User ����

CREATE USER woori IDENTIFIED BY woori;

-- �ý��� ���� �ο�
GRANT CREATE SESSION TO woori;
--  ROLE�� �������� �ο�
GRANT CONNECT, RESOURCE, DBA TO woori;

-- ���� ��� �� ����
ALTER USER woori ACCOUNT LOCK;
ALTER USER woori ACCOUNT UNLOCK;


-- ���� ��й�ȣ ����
ALTER USER woori IDENTIFIED BY woori;

-- ���� ����
DROP USER woori CASCADE;