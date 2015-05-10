--1. employees(사원정보), departments(부서정보), locations(지역정보) 테이블에서
--   지역이 'London'에 위치한 부서의 사원번호(employee_id), 사원이름(first_name), 부서명(department_name), 부서위치(city)를 출력하라.
SELECT e.employee_id, e.first_name, d.department_name, l.city, c.country_name
FROM employees e JOIN departments d
  ON e.department_id = d.department_id
  JOIN locations l
  ON d.location_id = l.location_id
  JOIN countries c
  ON l.country_id = c.country_id
WHERE l.city = 'London';


--2. 사원이름(first_name)에 'A'가 포함된 사원의 이름과 부서명을 출력하라.
SELECT e.first_name, d.department_name
FROM employees e JOIN departments d
  ON e.department_id = d.department_id
WHERE e.first_name LIKE '%A%';

--3. 급여(salary)가 3000에서 5000 사이인 사원의 번호, 이름, 급여, 부서명을 출력하라.
SELECT e.employee_id, e.first_name, e.salary, d.department_name
FROM employees e JOIN departments d
  ON e.department_id = d.department_id
WHERE e.salary BETWEEN 3000 AND 5000;


--4. 'Accounting' 부서에 근무하는 사원의 이름과 입사일을 출력하라.
SELECT e.first_name, e.hire_date
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE UPPER(d.department_name) = 'ACCOUNTING';

--5. 'James(first_name)'와 동일 부서에 근무하는 사원의 모든 모든 정보를 출력하라
 --   (단. Lee는 제외)
SELECT e.*
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IN (
  SELECT department_id
  FROM employees
  WHERE first_name = 'James'
)
AND e.last_name != 'James';

--6. 'Lee(last_name)'보다 늦게 입사한 사원의 이름과 입사일 출력하라.
SELECT first_name, hire_date
FROM employees
WHERE hire_date > (
  SELECT hire_date
  FROM employees
  WHERE last_name = 'Lee'
);

--7. 'Lee(last_name)'보다 많은 급여를 받는 사원의 이름과 급여을 출력하라.
SELECT first_name, salary
FROM employees
WHERE salary > (
  SELECT salary
  FROM employees
  WHERE last_name = 'Lee'
);

--8. 50번 부서의 사원들과 같은 급여를 받는 사원의 이름과 급여를 출력하라.
SELECT first_name, salary
FROM EMPLOYEES
WHERE salary IN (
  SELECT salary
	FROM EMPLOYEES
  WHERE department_id = '50'
);

--9. 모든 사원의 평균급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여를 출력하라.
SELECT employee_id, first_name, salary
FROM EMPLOYEES
WHERE salary > (
  SELECT AVG(salary)
	FROM EMPLOYEES
);

--10. 이름에 'T'가 포함되어 있는 사원과 동일한 부서에 근무하는 사원의 번호,
  --    이름을 출력하라.
SELECT department_id, first_name
FROM EMPLOYEES
WHERE department_id IN (
  SELECT department_id
	FROM EMPLOYEES
  WHERE first_name LIKE '%T%'
);

--11.10번 부서 최대급여자자와 동일한 급여를 받는 사원의 번호, 이름, 급여를 출력하라.
SELECT employee_id, first_name, salary
FROM EMPLOYEES
WHERE salary = (
  SELECT MAX(SALARY)
  FROM EMPLOYEES
  WHERE department_id = 10
);

--12. 10번부서에 근무하는 사원의 이름과 부서명 출력
SELECT e.FIRST_NAME, d.department_name
FROM EMPLOYEES e JOIN DEPARTMENTS d
  ON e.DEPARTMENT_ID = d.department_id
WHERE e.DEPARTMENT_ID = 10;


--13. 부서별 최대 급여를 받는 사원 정보(부서이름, 사원이름, 급여)를 출력하라.
SELECT d.department_name, e.employee_id, e.last_name, e.salary
FROM EMPLOYEES e JOIN departments d
  ON e.department_id = d.department_id
WHERE (e.department_id, e.salary) IN (
  SELECT department_id, MAX(salary)
	FROM EMPLOYEES
  GROUP BY department_id
)
ORDER BY d.department_name;

--14. 업무가 'IT_PROG'인 사원의 최대 급여보다 많은 급여를 받는 사원 정보(부서번호, 사원번호, 이름, 급여)를 출력하라.
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE salary > (
  SELECT max(salary)
  FROM employees
  WHERE UPPER(job_id) = 'IT_PROG'
);

--15. 부서별 평균급여보다 높은 급여를 받는 사원정보(부서번호, 사원번호, 사원이름, 급여)를 부서별로 출력하라
SELECT e1.department_id, e1.employee_id, e1.first_name, e1.salary
FROM EMPLOYEES e1 JOIN (
  SELECT department_id, AVG(salary) avg_sal
  FROM EMPLOYEES
  GROUP BY department_id
) e2
  ON e1.department_id = e2.department_id
WHERE e1.salary > e2.avg_sal
ORDER BY e1.department_id;
