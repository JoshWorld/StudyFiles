--1. 급여가 5000이상 15000이하 사이에 포함되지 않는 사원의 사원번호, 이름, 급여, 입사일자를 조회하라.--
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE salary NOT BETWEEN 5000 AND 15000;

--2. 부서번호(department_id)가 50이고, 업무(job_id)가 'ST_MAN'이고,
--   입사일이 2004년 7월 18일인 사원의 사원번호, 이름, 업무, 입사일을 조회하라.--
SELECT employee_id, last_name, job_id, hire_date
FROM employees
WHERE department_id = 50
	AND UPPER(job_id) = 'ST_MAN'
  AND hire_date = TO_DATE('2004-07-18', 'YYYY-MM-DD');

--3. 2002년 이후 입사자중에서 재고업무(ST_MAN, ST_CLERK)를 담당하는 사원들의 모든 정보(컬럼)를 조회하라.--
SELECT *
FROM employees
WHERE hire_date >= TO_DATE('2002-01-01', 'YYYY-MM-DD')
	AND job_id IN('ST_MAN', 'ST_CLERK');

--4. 상사(manager_id)가 없는 사원의 모든 정보(컬럼)을 조회하라.--
SELECT *
FROM employees
WHERE manager_id IS NULL;

--5. 급여가 10000 미만인 사원중에서 배송(SH_CLERK)이나 구매(PU_MAN, PU_CLERK)업무를 담당하는 사원들의 모든 정보를 조회하라.--
SELECT *
FROM employees
WHERE salary < 10000
	AND job_id IN('SH_CLERK', 'PU_MAN', 'PU_CLERK');

--6. 사원중 이름(first_name)에 'S'가 포함된 사원의 모든 정보를 출력하라.--
SELECT *
FROM employees
WHERE first_name LIKE '%S%';

--7. 년도별 입사인원수를 조회하라.--
SELECT TO_CHAR(hire_date, 'YYYY') year, COUNT(*) count
FROM employees
GROUP BY hire_date
ORDER BY year;

--8. 사원번호(employee_id)가 홀수인 사원의 모든 정보를 조회하라.--
SELECT *
FROM employees
WHERE MOD(employee_id, 2) = 1;

--9.오늘부터 6개월 후 돌아오는 첫번째 금요일 날짜를 출력하라.
--   (날짜 형식 예: 2002-06-05 15:23:10)--
SELECT TO_CHAR(NEXT_DAY(ADD_MONTHS(SYSDATE , 6), 6), 'YYYY-MM-DD HH24:MI:SS DAY')
FROM dual;

--10.사원번호(employee_id), 사원명(first_name), 상사번호(manager_id)를 출력하되
--   상사번호가 없는(NULL) 경우 상사번호를 '대빵'이라 출력하라.--
SELECT employee_id, first_name, NVL(TO_CHAR(manager_id),'대빵')
FROM employees;

--11.사원들을 3개축구팀으로 분류하기 위해 사번을 3으로 나누어
--   나머지가 0이면 "영화배우팀"
--   나머지가 1이면 "개그맨팀"
--   나머지가 2이면 "가수팀"으로 분류하여 팀이름, 사원번호, 사원명을 출력하라.--
SELECT employee_id, first_name,DECODE(MOD(employee_id, 3), 0, '영화배우팀',
                                                           1, '개그맨팀',
                                                           2, '가수팀') team
FROM employees
ORDER BY team;

--12.사원별 급여그래프를 아래와 같이 출력하라.
--   Steven King     ****************************($5,000) // $100달러당 별 1개추가.
--   Neena Kochhar  *******************($3,000)--    .........
--   XXXX XXXXX    ******(  $17,000)--
SELECT RPAD(first_name || ' ' || last_name, 20, ' ') "이름" , RPAD(' ', (salary / 1000)+1 , '*') || '('||  TO_CHAR(salary, '$99,999') || ')' "급여그래프"
FROM employees
ORDER BY salary DESC;

--13.2002년 3월부터 2003년 2월 기간 동안 입사한 사원을 대상으로 부서별 인원수를 조회하라.
--   결과는 인원수가 많은 순서대로 정렬하여 조회--
SELECT department_id, COUNT(*)
FROM employees
WHERE hire_date BETWEEN TO_DATE('2002-03', 'YYYY-MM') AND TO_DATE('2003-03', 'YYYY-MM')
GROUP BY department_id
ORDER BY COUNT(*) DESC;

--14.업무별 평균 급여를 계산하라. 단, 평균급여가 10000을 초과하는 경우는 제외하고 평균 급여에 대해 내림차순 정렬한다.--
SELECT job_id, AVG(salary) avg
FROM employees
GROUP BY job_id
HAVING AVG(salary) <= 10000
ORDER BY avg;

--15.2002년에 입사한 사원들의 목록으로부터 분기별 입사자의 수를 조회하라.
--분기   사원수
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