-- oracle 함수
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;

SELECT INITCAP('kim ki jung')
FROM dual;

SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james';

SELECT LPAD('DataBase', 10, '*')
FROM dual;

SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE('Jack and Jue', 'J', 'Bl')
FROM dual;

SELECT INSTR('DataBase', 'B')
--SELECT INSTR('DataBase', 'a', 1, 2)
FROM dual;

SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

SELECT TRIM('x' FROM 'xJava Developerx')
FROM dual;

SELECT LTRIM(RTRIM('xJava Developerx', 'x'), 'x')
FROM dual;

SELECT  ROUND(45.923), ROUND(45.923, 0), ROUND(45.923, 2), ROUND(45.923, -1)
FROM dual;

SELECT commission_pct, ROUND(commission_pct, 1)
FROM employees
WHERE commission_pct IS NOT NULL;

SELECT  TRUNC(45.923), TRUNC(45.923, 0), TRUNC(45.923, 2), TRUNC(45.923, -1)
FROM dual;

SELECT  MOD(123456, 2)
FROM dual;

SELECT  CEIL(123.123)
FROM dual;

SELECT  FLOOR(123.123)
FROM dual;

SELECT  POWER(5, 2), SQRT(5)
FROM dual;

SELECT SYSDATE
FROM dual;

SELECT SYSDATE - 1, SYSDATE, SYSDATE + 1
FROM dual;

-- 사원별 근무 일수 검색
SELECT first_name,  hire_date, SYSDATE, CEIL(SYSDATE - hire_date)
FROM employees;

-- 사원별 근무 개월수 검색
SELECT first_name, CEIL(MONTHS_BETWEEN(SYSDATE, hire_date))  "근무개월수"
FROM employees;

-- 특정개월수를 더한 날짜 반환
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) "오늘부터 2개월 후"
FROM dual;

-- 이번주 토요일 날짜
SELECT SYSDATE, NEXT_DAY(SYSDATE, 7)
FROM dual;

-- 이번달 마지막 날짜
SELECT SYSDATE,LAST_DAY(SYSDATE)
FROM dual;

SELECT hire_date, ROUND(hire_date, 'YEAR'), ROUND(hire_date, 'MONTH')
FROM employees;

SELECT SYSDATE, ROUND(SYSDATE, 'month')
FROM dual;

SELECT hire_date, TRUNC(hire_date, 'YEAR'), TRUNC(hire_date, 'MONTH')
FROM employees;


SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE salary NOT BETWEEN 5000 AND 15000;

-- 형변환함수
SELECT TO_DATE('2011/12/31 18:45:23', 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE('2002-01-03', 'YYYY-MM-DD');

SELECT first_name, hire_date
FROM employees
WHERE hire_date = TO_DATE(19900103, 'YYYY-MM-DD');

SELECT TO_NUMBER('12345')
FROM dual;

SELECT TO_NUMBER('12,345', '00,000')
FROM dual;

SELECT TO_NUMBER('1000') + TO_NUMBER('2,000', '0,000')
FROM dual;

SELECT TO_CHAR(12345), TO_CHAR(12345.67)
FROM dual;

SELECT TO_CHAR(12345, '999,999'), TO_CHAR(12345.67, '999,999.99')
FROM dual;

SELECT TO_CHAR(12345, '000,000'), TO_CHAR(12345.67, '000,000.00')
FROM dual;

SELECT TO_CHAR(150, '$9999'), TO_CHAR(150, '$0000')
FROM dual;

SELECT TO_CHAR(150, 'S9999'), TO_CHAR(150, 'S0000')
FROM dual;

SELECT TO_CHAR(150, '9999MI'), TO_CHAR(-150, '9999MI')
FROM dual;

SELECT TO_CHAR(150, '9999EEEE'), TO_CHAR(150, '99999B')
FROM dual;

SELECT TO_CHAR(150, 'RN'), TO_CHAR(150, 'rn')
FROM dual;

SELECT TO_CHAR(10, 'X'), TO_CHAR(10, 'x'), TO_CHAR(15, 'X')
FROM dual;

SELECT SYSDATE
FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY')
FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY', 'NLS_DATE_LANGUAGE=KOREAN')
FROM dual;

-- 출력형식 초기 파라메터 목록 검색
SELECT  * FROM  nls_session_parameters;

SELECT TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일"')
FROM dual;

SELECT first_name, TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI')
FROM employees;


--2002
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date, 'MM') = '01';

-- 일반함수
SELECT 10 * NULL, 10* NVL(NULL, 1)
FROM dual;

SELECT first_name, salary, commission_pct, (salary + (salary*commission_pct)) *12
FROM employees;

SELECT first_name, salary, commission_pct,
	(salary + (salary * NVL(commission_pct, 0))) *12
FROM employees;

SELECT first_name, job_id, salary "급여", dec-- 조건함수
ode(job_id, 'IT_PROG',  salary * 1.5,
  	                                              'AC_MRG', salary * 1.3,
                                                  'AC_ASST', salary * 1.1,
                                                  salary) "인상된급여"
FROM employees;


SELECT first_name, department_id, CASE
                                   WHEN  department_id=10    THEN  '영업부'
                                   WHEN  department_id=20    THEN  '총무부'
                                   WHEN  department_id=30    THEN  '인사부'
                                   ELSE  '인사발령'
                                   END  "부서명"
FROM employees
ORDER BY department_id ASC;

-- 다중행(그룹)함수
-- 커미션을 받는 사원의 수(NULL은 개수에 포함하지 않음)
SELECT COUNT(commission_pct)
FROM employees;

-- NULL값을 개수에 포함
SELECT COUNT(*) "전체사원수", COUNT(commission_pct) "커미션사원수"
FROM employees;

-- 급여 총액(NULL은 무시)
SELECT SUM(salary), SUM(commission_pct)
FROM employees;

-- 급여 평균(NULL은 무시)
SELECT round(AVG(salary))
FROM employees;

SELECT AVG(commission_pct), AVG(NVL(commission_pct, 0))
FROM employees;

-- 최대값, 최소값
SELECT MAX(salary), MAX(commission_pct)
FROM employees;

SELECT MAX(hire_date), MIN(hire_date), MAX(hire_date) - MIN(hire_date) "짬밥차"
FROM employees;

-- 분산--
SELECT VARIANCE(salary)
from employees;

-- 표준편차--
SELECT STDDEV(salary)
FROM employees;


-- GROUP BY 절(특정 컬럼을 기준으로 그룹핑)
SELECT department_id
FROM employees
GROUP BY department_id;

-- 부서별 급여총액, 평균 --
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
order by department_id;

-- HAVING 절(그룹에 대한 조건)
SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING department_id = 10;

SELECT department_id, SUM(salary), AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) >= 3000;


SELECT department_id, MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) > 20000;

SELECT  hire_date, COUNT (*)
FROM employees
GROUP BY hire_date
ORDER BY hire_date;