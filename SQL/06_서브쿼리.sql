SELECT *
FROM employees
WHERE job_id = (
	SELECT job_id
  FROM employees
  WHERE last_name = 'Seo'
) AND last_name != 'Seo';


-- IN 연산자 활용
-- 10번 부서에 소속된 사원들의  업무와 동일한 업무를 가지는 사원리스트
SELECT *
FROM employees
WHERE job_id IN (
	SELECT job_id
  FROM employees
  WHERE department_id = 30
);


-- ANY 연산자
-- 30번 부서의 최소급여(950)자 보다 많은 급여를 받는 사원리스트
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

-- ALL 연산자
-- 30번 부서의 최대급여(2850)보다 많은 급여를 받는 사원리스트
SELECT *
FROM employees
WHERE salary > ALL(
	SELECT salary
  FROM employees
  WHERE department_id = 30);

-- EXISTS 연산자
-- 서브쿼리의 결과가 있느냐, 없느냐 판별 시
SELECT *
FROM employees
WHERE EXISTS (
	SELECT *
  FROM departments
  WHERE department_id = 770);

-- 부서별 최소급여 출력
SELECT department_id, employee_id, last_name, salary
FROM employees
WHERE (salary, department_id) IN(
	SELECT min(salary), department_id
  FROM employees
  GROUP BY department_id)
ORDER BY department_id;
