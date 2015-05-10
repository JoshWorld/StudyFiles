/* 시퀀스(sequence) */
CREATE TABLE list(
	  no   NUMBER CONSTRAINT list_no_pk PRIMARY KEY,
    name VARCHAR2(10) NOT NULL
);-- Auto Commit


CREATE SEQUENCE list_seq;
	--START WITH 1
    --INCREMENT BY 1
    --NOMAXVALUE
    --NOCYCLE
    --CACHE 20;

SELECT list_seq.CURRVAL,  list_seq.NEXTVAL
FROM dual;

INSERT INTO list
VALUES(list_seq.NEXTVAL, '김기정');

COMMIT;

SELECT * FROM LIST;

-- 시퀀스 수정
ALTER SEQUENCE list_seq
	INCREMENT  BY 2;

-- 시퀀스 삭제
DROP SEQUENCE  list_seq;

-- 딕셔너리 시퀀스 조회
SELECT *  FROM user_sequences;


/* 뷰(view) */
-- 직급별 뷰
CREATE OR REPLACE VIEW employees_sajang_view
	AS SELECT *
       FROM EMPLOYEES;

CREATE OR REPLACE VIEW employees_bujang_view
	AS SELECT employee_id, first_name, salary
       FROM EMPLOYEES;


SELECT *
FROM employees_sajang_view;

SELECT *
FROM employees_bujang_view;



-- 복잡한 SQL
CREATE OR REPLACE VIEW employees_by_departments
AS
SELECT e.first_name, d.department_name
FROM employees e JOIN (SELECT department_id, department_name
                                 FROM departments
                                 WHERE department_id = 30) d
ON e.department_id = d.department_id;


-- 뷰를 통해 직급별 데이터 조회
SELECT  * FROM employees_sajang_view;

SELECT  * FROM employees_bujang_view;

SELECT  * FROM employees_by_departments;


-- 딕셔너리로부터 뷰 조회
SELECT * FROM user_views;

SELECT * FROM EMP_DETAILS_VIEW;

SELECT ROWID
FROM employees;

SELECT *
FROM user_indexes
WHERE table_name = 'EMPLOYEES';

SELECT *
FROM user_ind_columns
WHERE table_name = 'EMPLOYEES';


CREATE INDEX emp_lastname_idx
ON employees(last_name);

SELECT *
FROM employees
WHERE last_name = 'Seo';

/* 인덱스(index) */
-- 가상컬럼
SELECT rowid, ROWNUM, employee_id, first_name
FROM employees;

-- 자동인덱스 조회
SELECT * FROM user_indexes
WHERE table_name='EMPLOYEES';

-- 가상컬럼
SELECT ROWID,ROWNUM, employee_id
FROM EMPLOYEES;

DESC EMPLOYEES;

-- 사용자 정의 인덱스 생성
CREATE INDEX emp_first_idx
ON EMPLOYEES(first_name);

SELECT *
FROM EMPLOYEES
WHERE first_name='James';

/*
 * 오라클 rownum(Pseudo Column : 가상 컬럼)은
 * 물리적으로 저장되어 있는 컬럼이 아닌
 * 모든 SQL 문에사용할 수 있는 가상 컬럼
 * SQL이 실행되는 과정에서 생성되는 일련번호(1, 2, 3..)
 * 수행시 마다 같은 행이라도 서로 다른 rownum을 가질 수 있다.
 * rownum은 행이 Fetch된 후에 순차적으로 다음 값으로 증가
 */
SELECT ROWNUM, employee_id
FROM EMPLOYEES;

SELECT ROWNUM, employee_id
FROM EMPLOYEES
ORDER BY employee_id DESC;

SELECT *
FROM EMPLOYEES
WHERE ROWNUM > 1;
 -- 첫번째 행의 rownum이 1이므로
 -- 1>1은 false가 되어 rownum은 더이상 증가하지 않음
 -- 하나의 행도 반환되지 않음

SELECT *
FROM EMPLOYEES
WHERE ROWNUM >= 10;
 -- 첫번째 행의 rownum이 1이므로
 -- 1<=10은 true가 되어 첫번째 행에 1이 할당되고 rownum은 2로 증가
 -- 10개의 행 반환됨

SELECT *
FROM EMPLOYEES
WHERE ROWNUM = 1;

/*
 * 어느 특정 컬럼으로 정렬하여 상위 5개를 가져오고자 한다면
 * 인라인뷰(서브쿼리)에서 순서가 명시되어야 함
 */
 -- 전체 사원의 급여순으로 5명 가져오기
 -- X
SELECT ROWNUM, first_name, salary
FROM EMPLOYEES
WHERE ROWNUM <=5
ORDER BY salary DESC;
-- 전체 급여 순위가 아닌 저장된 순서안에서 5명안에서의 급여순위가 됨


-- 인라인뷰(서브쿼리) 사용해야 한다
SELECT  ROWNUM, first_name, salary
FROM ( SELECT  ROWNUM, first_name, salary
             FROM EMPLOYEES
             ORDER BY salary desc)
WHERE ROWNUM >=11 AND ROWNUM<=20;

-- 11 ~ 20 사이
SELECT page, employee_id, first_name, salary
FROM ( SELECT ROWNUM, CEIL(ROWNUM/10) page, employee_id, first_name, salary
            FROM ( SELECT employee_id, first_name, salary
                         FROM EMPLOYEES
                         ORDER BY salary DESC ) )
--WHERE page = 1; -- 1~ 10
WHERE page = 2; -- 11~ 20


/* 시노님(synonym) */
CREATE SYNONYM emp_synonym
FOR HR.EMPLOYEES;

SELECT * FROM emp_synonym;

DROP SYNONYM emp_synonym;










