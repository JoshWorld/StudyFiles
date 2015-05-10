--1. employees(�������), departments(�μ�����), locations(��������) ���̺���
--   ������ 'London'�� ��ġ�� �μ��� �����ȣ(employee_id), ����̸�(first_name), �μ���(department_name), �μ���ġ(city)�� ����϶�.
SELECT e.employee_id, e.first_name, d.department_name, l.city, c.country_name
FROM employees e JOIN departments d
  ON e.department_id = d.department_id
  JOIN locations l
  ON d.location_id = l.location_id
  JOIN countries c
  ON l.country_id = c.country_id
WHERE l.city = 'London';


--2. ����̸�(first_name)�� 'A'�� ���Ե� ����� �̸��� �μ����� ����϶�.
SELECT e.first_name, d.department_name
FROM employees e JOIN departments d
  ON e.department_id = d.department_id
WHERE e.first_name LIKE '%A%';

--3. �޿�(salary)�� 3000���� 5000 ������ ����� ��ȣ, �̸�, �޿�, �μ����� ����϶�.
SELECT e.employee_id, e.first_name, e.salary, d.department_name
FROM employees e JOIN departments d
  ON e.department_id = d.department_id
WHERE e.salary BETWEEN 3000 AND 5000;


--4. 'Accounting' �μ��� �ٹ��ϴ� ����� �̸��� �Ի����� ����϶�.
SELECT e.first_name, e.hire_date
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE UPPER(d.department_name) = 'ACCOUNTING';

--5. 'James(first_name)'�� ���� �μ��� �ٹ��ϴ� ����� ��� ��� ������ ����϶�
 --   (��. Lee�� ����)
SELECT e.*
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IN (
  SELECT department_id
  FROM employees
  WHERE first_name = 'James'
)
AND e.last_name != 'James';

--6. 'Lee(last_name)'���� �ʰ� �Ի��� ����� �̸��� �Ի��� ����϶�.
SELECT first_name, hire_date
FROM employees
WHERE hire_date > (
  SELECT hire_date
  FROM employees
  WHERE last_name = 'Lee'
);

--7. 'Lee(last_name)'���� ���� �޿��� �޴� ����� �̸��� �޿��� ����϶�.
SELECT first_name, salary
FROM employees
WHERE salary > (
  SELECT salary
  FROM employees
  WHERE last_name = 'Lee'
);

--8. 50�� �μ��� ������ ���� �޿��� �޴� ����� �̸��� �޿��� ����϶�.
SELECT first_name, salary
FROM EMPLOYEES
WHERE salary IN (
  SELECT salary
	FROM EMPLOYEES
  WHERE department_id = '50'
);

--9. ��� ����� ��ձ޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿��� ����϶�.
SELECT employee_id, first_name, salary
FROM EMPLOYEES
WHERE salary > (
  SELECT AVG(salary)
	FROM EMPLOYEES
);

--10. �̸��� 'T'�� ���ԵǾ� �ִ� ����� ������ �μ��� �ٹ��ϴ� ����� ��ȣ,
  --    �̸��� ����϶�.
SELECT department_id, first_name
FROM EMPLOYEES
WHERE department_id IN (
  SELECT department_id
	FROM EMPLOYEES
  WHERE first_name LIKE '%T%'
);

--11.10�� �μ� �ִ�޿����ڿ� ������ �޿��� �޴� ����� ��ȣ, �̸�, �޿��� ����϶�.
SELECT employee_id, first_name, salary
FROM EMPLOYEES
WHERE salary = (
  SELECT MAX(SALARY)
  FROM EMPLOYEES
  WHERE department_id = 10
);

--12. 10���μ��� �ٹ��ϴ� ����� �̸��� �μ��� ���
SELECT e.FIRST_NAME, d.department_name
FROM EMPLOYEES e JOIN DEPARTMENTS d
  ON e.DEPARTMENT_ID = d.department_id
WHERE e.DEPARTMENT_ID = 10;


--13. �μ��� �ִ� �޿��� �޴� ��� ����(�μ��̸�, ����̸�, �޿�)�� ����϶�.
SELECT d.department_name, e.employee_id, e.last_name, e.salary
FROM EMPLOYEES e JOIN departments d
  ON e.department_id = d.department_id
WHERE (e.department_id, e.salary) IN (
  SELECT department_id, MAX(salary)
	FROM EMPLOYEES
  GROUP BY department_id
)
ORDER BY d.department_name;

--14. ������ 'IT_PROG'�� ����� �ִ� �޿����� ���� �޿��� �޴� ��� ����(�μ���ȣ, �����ȣ, �̸�, �޿�)�� ����϶�.
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE salary > (
  SELECT max(salary)
  FROM employees
  WHERE UPPER(job_id) = 'IT_PROG'
);

--15. �μ��� ��ձ޿����� ���� �޿��� �޴� �������(�μ���ȣ, �����ȣ, ����̸�, �޿�)�� �μ����� ����϶�
SELECT e1.department_id, e1.employee_id, e1.first_name, e1.salary
FROM EMPLOYEES e1 JOIN (
  SELECT department_id, AVG(salary) avg_sal
  FROM EMPLOYEES
  GROUP BY department_id
) e2
  ON e1.department_id = e2.department_id
WHERE e1.salary > e2.avg_sal
ORDER BY e1.department_id;
