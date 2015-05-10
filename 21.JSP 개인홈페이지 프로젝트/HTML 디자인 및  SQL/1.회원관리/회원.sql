DROP TABLE users;

-- 사용자(회원) 정보 저장을 위한 테이블
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

-- 테이블에 제약사항 추가
ALTER TABLE users
	ADD CONSTRAINT users_id_pk PRIMARY KEY(id);


INSERT INTO users (id, passwd, name, email, mobile1, mobile2, mobile3, job, path, profile)
VALUES ('bangry', '1111', '김기정', 'bangry313@gmail.com', '010', '1234', '1234', '직장인', '인터넷', '허접한 프로그래밍 강사입니다.');

COMMIT;
