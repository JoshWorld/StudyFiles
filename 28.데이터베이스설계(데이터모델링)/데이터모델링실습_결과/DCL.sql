-- DBA 계정(sys, system)으로 연결 후 User 생성

CREATE USER woori IDENTIFIED BY woori;

-- 시스템 권한 부여
GRANT CREATE SESSION TO woori;
--  ROLE을 유저에게 부여
GRANT CONNECT, RESOURCE, DBA TO woori;

-- 유저 잠금 및 해제
ALTER USER woori ACCOUNT LOCK;
ALTER USER woori ACCOUNT UNLOCK;


-- 유저 비밀번호 변경
ALTER USER woori IDENTIFIED BY woori;

-- 유저 삭제
DROP USER woori CASCADE;