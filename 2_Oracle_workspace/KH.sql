-- SELECT : 데이터 조회
-- RESULT SET : SELRCT 구문으로 데이터를 조회한 결과물(반환된 행들의 집합)
-- SELECT절 : 조회하고 싶은 컬럼명 기술
-- FROM절 : 조회 컬림 속한 테이블명 기술

-- 사번, 이름, 급여 조회
SELCET EMP_ID, EMP NAME, SALARY
FROM EMPLOYEE;

-- EMPLOYEE 테이블의 모든 컬럼 조회
SELECT SALARY,  EMP_NAME, EMP_ID, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODES, SAL_LEVEL,
         BONUS,MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN

FROME EMPLOYEE

SELECT *
FORM EMPLOYEE;


-- JOB테이블의 모든 정보 조회
SELECT JOB_NAME, JOB_CODE
FROM JOB;

-- JOB테이블의 직급 이름 조회
SELECT JOB_NAME
FROM JOB;

-- DEPARTMENT테이블의 모든 정보 조회
SELECT DEPT__ID, DEPT_TITLE, LOCATION_ID
FORM DEPARTMENT;

-- EMPLOYEE테이블의 직원명, 이메일, 전화번호, 고용일 조회
SELECT * EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

-- EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회
SELECT HIRE_DATE, EMP_NAME, SALARY
FORM EMPLOYEE;

-- 컬럼 연산
-- EMPLOYEE테이블에서 직원 명, 연봉(=급여*12) 조회
SELECT EMP_NAME, SALARY*12
FROM EMPLOYEE;


-- EMPLOYEE테이블에서 직원명, 연봉, 보너스를 추가한 연봉 조회
SELECT EMP_NAME, SALARY*12, (SALARY+SALARY*BONUS)*12
FROM EMPLOYEE;

SELECT EMP_NAME, SALARY*12, SALARY*(1+BONUS)*12
FROM EMPLOYEE;

-- EMPLOYEE테이블에서 이름, 고용일, 근무일수(오늘날짜(=SYSDATE)-고용일) 조회
SELECT EMP_NAME, HIRE_DATE, SYSDATE-HIRE_DATE
FROM EMPLOYEE;

-- 별칭부여
-- 컬럼명 AS 별칭/ 컬럼명 "별칭"/ 컬럼명 별칭/ 컬럼명 AS "별칭"
-- 별칭에 특수문자가 포함되거나 숫자로 시작할 때는""를 써야만 함
-- EMPLOYEE테이블에서 직원 명, 연봉(=급여*12) 조회
SELECT EMP_NAME, SALARY*12 AS 연봉
FROM EMPLOYEE;


-- EMPLOYEE테이블에서 직원명, 연봉, 보너스를 추가한 연봉 조회
SELECT EMP_NAME "사원 명", SALARY*12, 연봉, (SALARY+SALARY*BONUS)*12 AS"보너스를 추가한 연봉"
FROM EMPLOYEE;

SELECT EMP_NAME AS "이름", SALARY*12 AS 연봉, SALARY*(1+BONUS)*12 "보너스 연봉"
FROM EMPLOYEE;

-- EMPLOYEE테이블에서 이름, 고용일, 근무일수(오늘날짜(=SYSDATE)-고용일) 조회
SELECT EMP_NAME 이름, HIRE_DATE 고용일, SYSDATE-HIRE_DATE 근무일수
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY, '원입니다' 단위 -- 리터럴
FROM EMPLOYEE;

-- "" 별칭에선만 사용(글자수 상관X) 
-- '' 모든 리터럴에 사용(글자수 상관X)

-- DISTINCT : 중복된 값을 한 번씩만 표시
SELECT JOB_CODE FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE FROM EMPLOYEE;
--SELECT DISTINCT DEPT_CODE, DISTINCT JOB_CODE FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE, JOB_CODE FROM EMPLOYEE;

-- WHERE절 : 조회할 테이블에서 조건이 맞는 값을 골라냄 (FROM절 아래)
-- 같냐 =, 같지 않냐 != ^= <>
-- 크냐 > , 작냐 <, 크거나 같냐, >= 작거나 같냐 <=
-- EMPLOYEE테이블에서 부서코드가 D9인 직원의 이름, 부서코드 조회
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE;
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE테이블에서 급여가 4000000 이상인 직원의 이름, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= '4000000';

-- EMPLOYEE테이블에서 부서코드가 D9가 아닌 사원의 사번, 이름, 부서코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE 
FROM EMPLOYEE
WHERE DEPT_CODE != 'D9';

-- EMPLOYEE테이블에서 퇴사 여부가 N인 직원의 사번, 이름, 고용일, 근무여부 조회
-- 근무 여부는 재직중으로 표시
SELECT EMP_ID, EMP_NAME, HIRE_DATE, '재직중' 근무여부
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- EMPLOYEE테이블에서 연봉이 45000000 초과인 사원의 이름, 월급, 연봉 조회
SELECT  EMP_NAME, SALARY, SALARY*12 
FROM EMPLOYEE
WHERE SALARY*12 > '45000000';

/*
    [SELECT문]
    (최소)  
        SELECT
        FROM
    (전체)
        5 SELECT
        1 FROM
        2 WHERE
        3 GROUP BY
        4 HAVING
        6 ORDER BY
*/           

-- 논리연산자 AND, OR
-- EMPLOYEE테이블에서 부서코드가 D6이고 급여를 3000000보다 많이 받는 직원의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND SALARY >= 3000000;

-- EMPLOYEE테이블에서 부서코드가 D6이거나 급여를 3000000보다 많이 받는 직원의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY DEPT_CODE = 'D6' AND SALARY >= 3000000;

-- EMPLOYEE테이블에서 급여를 3500000이상 6000000이하를 받는 직원의 사번, 이름, 급여, 부서코드, 직급코드 조회
SELECT EMP_ID, EMP_NAME, SALARY,DEPT_CODE, JOB_CODE
FROM EMPLOYEE
--ERE SALARY >= 3500000 AND SALARY <= 6000000;
WHERE SALARY BETWEEN 3500000 AND 6000000;
-- BETWEEN A AND B : A이상 B이하

-- (반대) 3500000 미만이거나 6000000초과
SELECT EMP_ID, EMP_NAME, SALARY,DEPT_CODE, JOB_CODE
FROM EMPLOYEE
--WHERE SALARY < 3500000 OR SALARY > 600000;
--WHERE SALARY BETWEEN AND 3500000 AND 6000000;
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE테이블에 고용일이 '90/01/01~01/01/01/인 사원의 전체 내용 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';


-- EMPLOYEE테이블에 DEPT_CODERK D9이거나 D5인 사원 중
-- 고용일이 02년 1월 1일보다 빠른 사원의 이름, 부서코드, 고용일 조회
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') AND HIRE_DATE < '02/01/01';

-- LIKE : 비교하려는 값이 특정 패턴을 만족하는지 검사
-- %(0글자 이상) _ (한 글자)
-- '글자%' -> 글자벌레, 글자가 없어요, 글자
-- '%글자' -> 한글자, 세글자, 자글자글자, 글자
-- '%글자%' -> 글자벌레, 자글자글자, 한글자리, 글자
-- '글%자' -> 글을 쓰자, 글자글자글자, 글자
-- '_' -> 공, 너, 담, 류, 목, 배, 
-- '__' -> 점심,시간, 조퇴, 하원
-- '___' -> 오라클, 쉬어요, 하하하

-- EMPLOYEE테이블에서 성이 전씨인 사원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE테이블에서 이름에'하'가 포함된 직원의 이름, 주민번호, 부서코드 조회
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- EMPLOYEE에서 전화번호 4번째 자리가 9로 시작하는 사원의 사번, 이름, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE'___9%';

-- EMPLOYEE테이블에서 이메일 중 _의 앞글자가 3자리인 이메일 주소를 가진 사원의 사번, 이름, 이메일 주소 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';

-- ESCAPE OPTION 
-- 데이터로 처리할 기호 앞에 임의의 문자를 사용하고 ESCAPE OPTION으로 등록
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___!_%' ESCAPE '!';

-- EMPLOYEE테이블에서 김씨 성이 아닌 직원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '김%';

-- EMPLOYEE테이블에서 이름 끝이 연으로 끝난는 사원의 이름 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

-- EMPLOYEE테이블에서 전화번호 처음 세자리가 010이 아닌 사원의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE'010%';

-- EMPLOYEE테이블에서 이메일 주소_의 앞이 4자리이면서 DEPT_CODE D9 또는 D6이고
-- 고용일이 90/01/01!00/12/01이고, 급여가 2700000이상인 사원의 전체 내용 조회
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____$_%' ESCAPE '$'
      AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6')
      AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
      AND SALARY >= 2700000;

-- IS NULL       
-- EMPLOYEE테이블에서 보너스를 받지 않는 사원의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- 보너스를 받는 사람
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
-- WHERE BONUS != NULL;
WHERE BONUS IS NOT NULL; -- = NOT BONUS IS NULL

-- EMPLOYEE테이블에서 부서 배치를 받지 않았지만 보너스를 지급받는 직원의 이름, 보너스, 부서코드 조회
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-- IN : 비교하려는 목록에 일치하는 값이 있으면 TRUE 반환
-- D6 부서와 D9 부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D9';
WHERE DEPT_CODE IN ('D6', 'D9');

-- 직급코드가 J1, J2, J3, J4인 사람들의 이름, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
--WHERE JOB_CODE'J1' OR JOB_CODE = 'J2' OR JOB_CODE = 'J3' OR JOB_CODE = 'J4';
WHERE JOB_CODE IN ('J1', 'J2', 'J3', 'J4');
-- WHERE JOB_CODE BETWEEN 'J1' AND 'J4';
-- WHERE JOB_CODE NOT IN ('J1', 'J2', 'J3', 'J4');


-- || 연결 연산잔
-- EMPLOYEE테이블에서 사번, 이름, 급여를 연결하여 조회
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, SALARY || '원'
FROM EMPLOYEE;

