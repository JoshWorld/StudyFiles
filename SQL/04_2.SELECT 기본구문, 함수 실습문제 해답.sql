--1. �޿��� 5000�̻� 15000���� ���̿� ���Ե��� �ʴ� ����� �����ȣ, �̸�, �޿�, �Ի����ڸ� ��ȸ�϶�.--
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE salary NOT BETWEEN 5000 AND 15000;

--2. �μ���ȣ(department_id)�� 50�̰�, ����(job_id)�� 'ST_MAN'�̰�,
--   �Ի����� 2004�� 7�� 18���� ����� �����ȣ, �̸�, ����, �Ի����� ��ȸ�϶�.--
SELECT employee_id, last_name, job_id, hire_date
FROM employees
WHERE department_id = 50
	AND UPPER(job_id) = 'ST_MAN'
  AND hire_date = TO_DATE('2004-07-18', 'YYYY-MM-DD');

--3. 2002�� ���� �Ի����߿��� ������(ST_MAN, ST_CLERK)�� ����ϴ� ������� ��� ����(�÷�)�� ��ȸ�϶�.--
SELECT *
FROM employees
WHERE hire_date >= TO_DATE('2002-01-01', 'YYYY-MM-DD')
	AND job_id IN('ST_MAN', 'ST_CLERK');

--4. ���(manager_id)�� ���� ����� ��� ����(�÷�)�� ��ȸ�϶�.--
SELECT *
FROM employees
WHERE manager_id IS NULL;

--5. �޿��� 10000 �̸��� ����߿��� ���(SH_CLERK)�̳� ����(PU_MAN, PU_CLERK)������ ����ϴ� ������� ��� ������ ��ȸ�϶�.--
SELECT *
FROM employees
WHERE salary < 10000
	AND job_id IN('SH_CLERK', 'PU_MAN', 'PU_CLERK');

--6. ����� �̸�(first_name)�� 'S'�� ���Ե� ����� ��� ������ ����϶�.--
SELECT *
FROM employees
WHERE first_name LIKE '%S%';

--7. �⵵�� �Ի��ο����� ��ȸ�϶�.--
SELECT TO_CHAR(hire_date, 'YYYY') year, COUNT(*) count
FROM employees
GROUP BY hire_date
ORDER BY year;

--8. �����ȣ(employee_id)�� Ȧ���� ����� ��� ������ ��ȸ�϶�.--
SELECT *
FROM employees
WHERE MOD(employee_id, 2) = 1;

--9.���ú��� 6���� �� ���ƿ��� ù��° �ݿ��� ��¥�� ����϶�.
--   (��¥ ���� ��: 2002-06-05 15:23:10)--
SELECT TO_CHAR(NEXT_DAY(ADD_MONTHS(SYSDATE , 6), 6), 'YYYY-MM-DD HH24:MI:SS DAY')
FROM dual;

--10.�����ȣ(employee_id), �����(first_name), ����ȣ(manager_id)�� ����ϵ�
--   ����ȣ�� ����(NULL) ��� ����ȣ�� '�뻧'�̶� ����϶�.--
SELECT employee_id, first_name, NVL(TO_CHAR(manager_id),'�뻧')
FROM employees;

--11.������� 3���౸������ �з��ϱ� ���� ����� 3���� ������
--   �������� 0�̸� "��ȭ�����"
--   �������� 1�̸� "���׸���"
--   �������� 2�̸� "������"���� �з��Ͽ� ���̸�, �����ȣ, ������� ����϶�.--
SELECT employee_id, first_name,DECODE(MOD(employee_id, 3), 0, '��ȭ�����',
                                                           1, '���׸���',
                                                           2, '������') team
FROM employees
ORDER BY team;

--12.����� �޿��׷����� �Ʒ��� ���� ����϶�.
--   Steven King     ****************************($5,000) // $100�޷��� �� 1���߰�.
--   Neena Kochhar  *******************($3,000)--    .........
--   XXXX XXXXX    ******(  $17,000)--
SELECT RPAD(first_name || ' ' || last_name, 20, ' ') "�̸�" , RPAD(' ', (salary / 1000)+1 , '*') || '('||  TO_CHAR(salary, '$99,999') || ')' "�޿��׷���"
FROM employees
ORDER BY salary DESC;

--13.2002�� 3������ 2003�� 2�� �Ⱓ ���� �Ի��� ����� ������� �μ��� �ο����� ��ȸ�϶�.
--   ����� �ο����� ���� ������� �����Ͽ� ��ȸ--
SELECT department_id, COUNT(*)
FROM employees
WHERE hire_date BETWEEN TO_DATE('2002-03', 'YYYY-MM') AND TO_DATE('2003-03', 'YYYY-MM')
GROUP BY department_id
ORDER BY COUNT(*) DESC;

--14.������ ��� �޿��� ����϶�. ��, ��ձ޿��� 10000�� �ʰ��ϴ� ���� �����ϰ� ��� �޿��� ���� �������� �����Ѵ�.--
SELECT job_id, AVG(salary) avg
FROM employees
GROUP BY job_id
HAVING AVG(salary) <= 10000
ORDER BY avg;

--15.2002�⿡ �Ի��� ������� ������κ��� �б⺰ �Ի����� ���� ��ȸ�϶�.
--�б�   �����
-----------------
--1      3
--2      1
--3      2
--4      0
SELECT TO_CHAR(hire_date, 'Q') quarter, COUNT(employee_id) count
FROM EMPLOYEES
WHERE TO_CHAR(hire_date, 'YYYY') = '2002'
GROUP BY TO_CHAR(hire_date, 'Q')
ORDER BY quarter;