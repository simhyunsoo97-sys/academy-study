-- SUBQUERY : 하나의 SQL문 안에 포함된 또다른 SQL문(보조)


-- 노옹철 사원과 부서코드가 같은 소속의 직원 명단 조회
-- 1) 노옹철 사원의 부서코드
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; -- D9

-- 2) D9 부서코드에 속하 직원 명단 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) 1+2
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '노옹철');
-- 서브쿼리는 무조건 소괄호로 감싸야 함

-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여 조회
-- 1) 전직원의 평균 급여
SELECT AVG(SALARY) FROM EMPLOYEE; -- 3047662.60869565217391304347826086956522

-- 2) 3047662.60869565217391304347826086956522보다 많이 받는 사원 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3047662.60869565217391304347826086956522;

-- 3) 1+2
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 1. 단일행 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 1개인 경우
-- 일반적으로 단일행 서브쿼리 앞에는 일반 연산자 사용
-- 노옹철 사원의 급여보다 많이 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여 조회
-- 1) 노옹철 사원의 급여
SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; -- 3700000

-- 2) 3700000 보다 많이  받는 직원 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3700000;

--3) 1+2
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SLAARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철');

-- 부서 별 급여 합계 중 가장 큰 부서의 부서 명, 급여 합계 조회
-- 1) 부서 별 급여 합계 중 가장 큰 합계
SELECT MAX (SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE; -- 17700000

-- 2) 급여 합계가 17700000인 부서의 이름, 급여 합계 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000; 

-- 3) 1+2
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX (SUM(SALARY))
                      FROM EMPLOYEE
                      GROUP BY DEPT_CODE);
                      

-- 다중행 서브쿼리 : 서브 쿼리의 조회 결과 값의 개수가 여러개일때
-- 다중행 서브쿼리는 개수가 여러개라 일반 비교 연산자 사용 불가능
-- IN / NOT IN : 여러 개의 결과 값 중에서 한 개라도  일치하는 값이 있다면/없다면
-- > ANY, < ANY : 여러 개의 결과 값 중에서 한 개라도 큰/작은 경우 = 가장 큰 값보다 작냐/가장 작은 값보다 크냐
-- > ALL, < ALL : 여러 개의 결과 값들보다 가장 큰/작은 경우 = 가장 큰 값보다 크냐/가장 작은 값보다 작으냐

-- 부서 별 최고 급여를 받는 직원의 이름, 직급코드, 부서코드, 급여 조회
-- 1) 부서 별 최고 급여
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) 최고 급여를 받는 직원 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN(SELECT MAX(SALARY)
                FROM EMPLOYEE
                GROUP BY DEPT_CODE);

-- 관리자와 일반 직원에 해당하는 사원 정보 추출 : 사번, 이름, 부서 명, 직급, 구분(관리자/직원)
-- 1)관리자 사번
SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 2) 관리자 사원 정보
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '관리자' 구분
FROM EMPLOYEE
     LEFT JOIN USING(JOB_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL);
                
-- 3)일반 사원 정보
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '관리자' 구분
FROM EMPLOYEE
     LEFT JOIN USING(JOB_CODE)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL);

--2번과 3번 결과 합치기 : UNION
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '관리자' 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL)
UNION

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' 구분
FROM EMPLOYEE
     LEFT JOIN  DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE
                WHERE MANAGER_ID IS NOT NULL);
                
                
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
        CASE WHEN EMP_ID IN (SELECT DISTINCT MANAGER_ID
                              FROM EMPLOYEE
                              WHERE MANAGER_ID IS NOT NULL) THEN '관리자'
            ELSE'직원'
        END AS 구분 
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);
     
-- 대리 직급의 직원들 중 과장 직급의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
-- 1) 과장 직급의 최소 급여
SELECT MIN(SALARY)
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

-- 2) 2200000보다 많이 받는 대리 직급 직원 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE SALARY > 2200000
      AND JOB_NAME = '대리';
      
--3)1+2
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE SALARY > (SELECT MIN(SALARY)
                FROM EMPLOYEE
                     JOIN JOB USING(JOB_CODE)
                     WHERE JOB_NAME = '과장') -- 2200000
      AND JOB_NAME = '대리';
      
-- 차장 직급의 급여의 가장 큰 값보다 많이 받는 과장 직급의 사번, 이름, 급여, 급여 조회
-- 1) 차장 직급 중 가장 큰 급여
SELECT MAX(SALARY)
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '차장'; -- 2800000

-- 2) 2800000보다 많이 받는 과장 정보
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
      AND SALARY > 2800000;
      
-- 3) 1+2
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
      AND SALARY > (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                         JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '차장');
                    
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
      AND SALARY > ALL(SELECT MAX(SALARY)
                    FROM EMPLOYEE
                         JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '차장');
                    
-- 다중 열 서브쿼리 : 서브쿼리 SELECT절에 나열된 항목수가 여러개일 때
-- 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 사원의 이름, 직급 코드, 부서코드, 입사일 조회
-- 1) 퇴사한 여직원의 부서, 직급
SELECT DEPR_CODE, JOB_CODE
FROM EMPLOYEE
WHERE ENT_YN = 'Y'
      AND SUBSTR(EMP_NOO, 8, 1) = 2; -- D8, J6
      
-- 2)      
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                               FROM EMPLOYEE
                               WHERE ENT_YN = 'Y'
                                     AND SUBSTR(EMP_NO, 8, 1) = 2);
                                     
                                     
-- 다중행 다중열 서브쿼리
-- 자기 직급의 평균 급여를 받고 있는 직원의 사번, 이름, 직급 코드, 급여 조회
-- 급여 평균은 십만원 단위로 계산 :  TRUNC(컬럼명, -5)
-- 1) 직급별 평균 급여
SELECT JOB_CODE, TRUNC(AVG(SALARY), -5)
FROM EMPLOYEE
GROUP BY JOB_CODE;


-- 2)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, TRUNC(AVG(SALARY), -5)
                          FROM EMPLOYEE
                          GROUP BY JOB_CODE);
                          
-- 인라인 뷰 : FROM절에 서브쿼리 사용
-- 사원 명, 급여 : 급여를 많이 받는 순 정렬
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;
-- ROWNUM : 행 번호, FROM절이 정해지고 나서 번호 붙여짐

-- 급여를 많이 받는 다섯 명만 조회
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;
-- FORM절에 EMPLOYEE가 결정되면 그거에 맞춰 ROWNUM이 붙음
-- 데이터 상위 5개만 추출하여 그 안에서만 급여 내림차순을 하기 때문에 원하는 결과가 나오지 못 함

SELECT ROWNUM, EMP_NAME, 급여
FROM (SELECT EMP_NAME, EMP_NO, SALARY 급여
        FROM EMPLOYEE
        ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

-- RANK() OVER : 동일한 순위 이후의 등수를 동일 인원 수만큼 건너 뛰고 순위 계산
-- DENSE_RANK() OVER : 중복되는 순위 이후의 등수를 이후 등수로 처리
SELECT RANK() OVER(ORDER BY SALARY DESC) 순위1, DENSE_RANK() OVER(ORDER BY SALARY DESC) 순위2,
        EMP_NAME, SALARY
FROM EMPLOYEE;



                                     
      

      
                     
     
                

                
                


