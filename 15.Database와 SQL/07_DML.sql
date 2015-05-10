
-- ����� NULL �Է�
INSERT INTO departments(department_id, department_name, manager_id, location_id)
VALUES (283, 'Education', NULL, NULL);

-- ������ NULL �Է�
INSERT INTO departments(department_id, department_name)
VALUES (282, 'Education');

--�������� Ȱ��
INSERT INTO departments(department_id, department_name, manager_id, location_id)
VALUES ((
	SELECT MAX(department_id)+1
	FROM departments
), 'Education', NULL, NULL);

SELECT *
FROM DEPARTMENTS;

-- ���������� �̿��� ���̺� ����(������)
CREATE TABLE dept
AS
SELECT *
FROM DEPARTMENTS
WHERE 1 = 0;

DESC dept;

INSERT INTO dept
SELECT *
FROM departments;

SELECT *
FROM dept;

UPDATE dept
SET department_name = '������'
WHERE department_name = 'Education';

UPDATE dept
SET manager_id = 100
WHERE manager_id IS NULL ;


DELETE FROM dept
WHERE department_name = '������';

DELETE FROM emp
WHERE salary > (
	SELECT AVG(salary)
  FROM EMP
);

SELECT *
FROM EMP;

ROLLBACK;

SELECT *
FROM dept;

INSERT INTO dept(department_id, department_name)
VALUES (300, 'ABC');

UPDATE dept
SET department_name = 'Hul';

COMMIT;

SELECT *
FROM departments;

INSERT INTO departments
VALUES (400, 'KOSTA', NULL, NULL);

COMMIT ;

SAVEPOINT sp1;

INSERT INTO dept(department_id, department_name)
VALUES (900, 'ABCD');

SAVEPOINT sp2;

UPDATE dept
SET department_name = 'KOST';

ROLLBACK TO SAVEPOINT sp2;

COMMIT;
