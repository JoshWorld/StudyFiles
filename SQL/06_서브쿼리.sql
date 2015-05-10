SELECT *
FROM employees
WHERE job_id = (
	SELECT job_id
  FROM employees
  WHERE last_name = 'Seo'
) AND last_name != 'Seo';


-- IN ������ Ȱ��
-- 10�� �μ��� �Ҽӵ� �������  ������ ������ ������ ������ �������Ʈ
SELECT *
FROM employees
WHERE job_id IN (
	SELECT job_id
  FROM employees
  WHERE department_id = 30
);


-- ANY ������
-- 30�� �μ��� �ּұ޿�(950)�� ���� ���� �޿��� �޴� �������Ʈ
SELECT *
FROM employees
WHERE salary > ANY(
	SELECT salary
  FROM employees
  WHERE department_id = 30);

SELECT *
FROM employees
WHERE salary > (
	SELECT MIN(salary)
  FROM employees
  WHERE department_id = 30);

-- ALL ������
-- 30�� �μ��� �ִ�޿�(2850)���� ���� �޿��� �޴� �������Ʈ
SELECT *
FROM employees
WHERE salary > ALL(
	SELECT salary
  FROM employees
  WHERE department_id = 30);

-- EXISTS ������
-- ���������� ����� �ִ���, ������ �Ǻ� ��
SELECT *
FROM employees
WHERE EXISTS (
	SELECT *
  FROM departments
  WHERE department_id = 770);

-- �μ��� �ּұ޿� ���
SELECT department_id, employee_id, last_name, salary
FROM employees
WHERE (salary, department_id) IN(
	SELECT min(salary), department_id
  FROM employees
  GROUP BY department_id)
ORDER BY department_id;
