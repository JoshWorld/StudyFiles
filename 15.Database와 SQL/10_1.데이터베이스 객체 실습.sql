/* ������(sequence) */
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
VALUES(list_seq.NEXTVAL, '�����');

COMMIT;

SELECT * FROM LIST;

-- ������ ����
ALTER SEQUENCE list_seq
	INCREMENT  BY 2;

-- ������ ����
DROP SEQUENCE  list_seq;

-- ��ųʸ� ������ ��ȸ
SELECT *  FROM user_sequences;


/* ��(view) */
-- ���޺� ��
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



-- ������ SQL
CREATE OR REPLACE VIEW employees_by_departments
AS
SELECT e.first_name, d.department_name
FROM employees e JOIN (SELECT department_id, department_name
                                 FROM departments
                                 WHERE department_id = 30) d
ON e.department_id = d.department_id;


-- �並 ���� ���޺� ������ ��ȸ
SELECT  * FROM employees_sajang_view;

SELECT  * FROM employees_bujang_view;

SELECT  * FROM employees_by_departments;


-- ��ųʸ��κ��� �� ��ȸ
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

/* �ε���(index) */
-- �����÷�
SELECT rowid, ROWNUM, employee_id, first_name
FROM employees;

-- �ڵ��ε��� ��ȸ
SELECT * FROM user_indexes
WHERE table_name='EMPLOYEES';

-- �����÷�
SELECT ROWID,ROWNUM, employee_id
FROM EMPLOYEES;

DESC EMPLOYEES;

-- ����� ���� �ε��� ����
CREATE INDEX emp_first_idx
ON EMPLOYEES(first_name);

SELECT *
FROM EMPLOYEES
WHERE first_name='James';

/*
 * ����Ŭ rownum(Pseudo Column : ���� �÷�)��
 * ���������� ����Ǿ� �ִ� �÷��� �ƴ�
 * ��� SQL ��������� �� �ִ� ���� �÷�
 * SQL�� ����Ǵ� �������� �����Ǵ� �Ϸù�ȣ(1, 2, 3..)
 * ����� ���� ���� ���̶� ���� �ٸ� rownum�� ���� �� �ִ�.
 * rownum�� ���� Fetch�� �Ŀ� ���������� ���� ������ ����
 */
SELECT ROWNUM, employee_id
FROM EMPLOYEES;

SELECT ROWNUM, employee_id
FROM EMPLOYEES
ORDER BY employee_id DESC;

SELECT *
FROM EMPLOYEES
WHERE ROWNUM > 1;
 -- ù��° ���� rownum�� 1�̹Ƿ�
 -- 1>1�� false�� �Ǿ� rownum�� ���̻� �������� ����
 -- �ϳ��� �൵ ��ȯ���� ����

SELECT *
FROM EMPLOYEES
WHERE ROWNUM >= 10;
 -- ù��° ���� rownum�� 1�̹Ƿ�
 -- 1<=10�� true�� �Ǿ� ù��° �࿡ 1�� �Ҵ�ǰ� rownum�� 2�� ����
 -- 10���� �� ��ȯ��

SELECT *
FROM EMPLOYEES
WHERE ROWNUM = 1;

/*
 * ��� Ư�� �÷����� �����Ͽ� ���� 5���� ���������� �Ѵٸ�
 * �ζ��κ�(��������)���� ������ ��õǾ�� ��
 */
 -- ��ü ����� �޿������� 5�� ��������
 -- X
SELECT ROWNUM, first_name, salary
FROM EMPLOYEES
WHERE ROWNUM <=5
ORDER BY salary DESC;
-- ��ü �޿� ������ �ƴ� ����� �����ȿ��� 5��ȿ����� �޿������� ��


-- �ζ��κ�(��������) ����ؾ� �Ѵ�
SELECT  ROWNUM, first_name, salary
FROM ( SELECT  ROWNUM, first_name, salary
             FROM EMPLOYEES
             ORDER BY salary desc)
WHERE ROWNUM >=11 AND ROWNUM<=20;

-- 11 ~ 20 ����
SELECT page, employee_id, first_name, salary
FROM ( SELECT ROWNUM, CEIL(ROWNUM/10) page, employee_id, first_name, salary
            FROM ( SELECT employee_id, first_name, salary
                         FROM EMPLOYEES
                         ORDER BY salary DESC ) )
--WHERE page = 1; -- 1~ 10
WHERE page = 2; -- 11~ 20


/* �ó��(synonym) */
CREATE SYNONYM emp_synonym
FOR HR.EMPLOYEES;

SELECT * FROM emp_synonym;

DROP SYNONYM emp_synonym;










