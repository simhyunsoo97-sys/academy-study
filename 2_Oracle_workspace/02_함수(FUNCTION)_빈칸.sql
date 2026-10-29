
-- 1. 문자 관련 함수 : LENGTH, LENGTHB, SUBSTR, INSTR, LOWER, ...

-- *** LENGTH / LENGTHB ***
-- LENGTH(컬럼명 | '문자열값') : 
-- LENGTHB(컬럼명 | '문자열값') : 
-- 한글의 경우 ?바이트로 인식
SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL; 
-- DUAL : 

SELECT LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;

SELECT EMP_NAME, LENGTH(EMP_NAME), EMAIL, LENGTH(EMP_NAME)
FROM EMPLOYEE;

SELECT EMP_NAME, LENGTHB(EMP_NAME), EMAIL, LENGTHB(EMAIL)
FROM EMPLOYEE;


-- *** INSTR *** : 
--> INSTR('문자열' | 컬럼명, '문자', _______ 시작값, [순번])

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'A') FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'Z') FROM DUAL; 

SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'B', 7) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'A', -3) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'C', -1) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'B', -1, 2) FROM DUAL; 
SELECT INSTR('AABAACAABBAA', 'C', 1, 2) FROM DUAL; 

-- (실습) EMPLOYEE테이블에서 이메일의 @ 위치 반환


-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** LPAD / RPAD ***
--> ('문자열' | 컬럼명, 반환할 문자의 길이(바이트), [덧붙이려는 문자열])
-- __________________________________________________________________ 반환
--> _____________________ 위해 자주 사용
SELECT LPAD(EMAIL, 20) 
FROM EMPLOYEE;
-- __________________________

SELECT LENGTH(EMAIL), LPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

SELECT LENGTH(EMAIL), RPAD(EMAIL, 20, '#')
FROM EMPLOYEE; 

-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** LTRIM / RTRIM *** 
--> ('문자열' | 컬럼명, [제거하려는 문자열])
-- 
SELECT EMP_NAME, LTRIM(PHONE, '010'), RTRIM(EMAIL, '@kh.or.kr')
FROM EMPLOYEE;

SELECT LTRIM('  KH') FROM DUAL; 
SELECT LTRIM('  KH', ' ') FROM DUAL; 
SELECT LTRIM('000123456', '0') FROM DUAL; 
SELECT LTRIM('123123KH', '123') FROM DUAL; 
SELECT LTRIM('123123KH123', '123') FROM DUAL;  
SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL; 
SELECT LTRIM('5782KH', '0123456789') FROM DUAL; 

SELECT RTRIM('KH  ') FROM DUAL;
SELECT RTRIM('KH  ', ' ') FROM DUAL;
SELECT RTRIM('123456000', '0') FROM DUAL;
SELECT RTRIM('KH123123', '123') FROM DUAL;
SELECT RTRIM('KHACABACC', 'ABC') FROM DUAL;
SELECT RTRIM('KH5782', '0123456789') FROM DUAL;


-- *** TRIM ***
-- 
SELECT TRIM('  KH  ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM('0123456789' FROM '324KH0923') FROM DUAL; 
SELECT TRIM('3' FROM '324KH0923') FROM DUAL;

-- TRIM할 CHAR의 위치 지정, ____(LEADING)/____(TRAILING)/____(BOTH) 지정 가능(기본 값 양쪽)
SELECT TRIM(LEADING 'Z' FROM 'ZZZ123456ZZZ') FROM DUAL;
SELECT TRIM(TRAILING '3' FROM 'KH333333') FROM DUAL;
SELECT TRIM(BOTH '3' FROM '333KH333333') FROM DUAL;


-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** SUBSTR ***
-- 
--> SUBSTR( STRING, POSITION, [LENGTH] )
-- STRING : 
-- POSITION : 
-- LENGTH : 

SELECT SUBSTR('HELLOMYGOODFRIENDS', 7) FROM DUAL; 
SELECT SUBSTR('HELLOMYGOODFRIENDS', 5, 2) FROM DUAL; 
SELECT SUBSTR('HELLOMYGOODFRIENDS', 5, 0) FROM DUAL; 
SELECT SUBSTR('HELLOMYGOODFRIENDS', 1, 6) FROM DUAL; 
SELECT SUBSTR('HELLOMYGOODFRIENDS', -8, 3) FROM DUAL;
SELECT SUBSTR('HELLOMYGOODFRIENDS', -10, 2) FROM DUAL;
SELECT SUBSTR('헬로 마이 굿 프렌즈', 2, 5) FROM DUAL; 

-- (실습) EMPLOYEE 테이블의 이름, 이메일, @이후를 제외한 아이디 조회


-- (실습) 주민 등록 번호로 이용하여 남 / 녀 판단(주민번호에서 성별을 나타내는 부분만 잘라보기)
-- EMPLOYEE테이블에서 이름과 주민번호에서 성별을 나타내는 부분 조회


-- (실습)EMPLOYEE테이블에서 남자만 조회(사원 명, '남')


-- (실습)EMPLOYEE테이블에서 여자만 조회(사원 명, '여')


-- (실습)EMPLOYEE테이블에서 직원들의 주민번호를 이용하여 사원명, 생년, 생월, 생일 조회



-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** LOWER / UPPER / INITCAP ***

-- LOWER(문자열 | 컬럼) : 
SELECT LOWER('Welcome To My World') FROM DUAL;
-- UPPER(문자열 | 컬럼) : 
SELECT UPPER('Welcome To My World') FROM DUAL;
-- INITCAP(문자열 | 컬럼) : 
SELECT INITCAP('welcome to my world') FROM DUAL;

-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** CONCAT ***  
-- 
-- CONCAT(STRING, STRING)
-- STRING : 문자 타입 컬럼 또는 문자열
SELECT CONCAT('가나다라','ABCD') FROM DUAL; 


-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** REPLACE ***
-- 
-- REPLACE(STRING, STR1, STR2)
/* STRING : 문자 타입 컬럼 또는 문자열
* STR1 : 변경하려고 하는 문자 혹은 문자열
* STR2 : 변경하고자 하는 문자 혹은 문자열*/

SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') 
FROM DUAL;
SELECT REPLACE('빨간사과는 세상에서 제일 맛있습니다.', '사과', '딸기') 
FROM DUAL;  -- 붙어있는 단어라도 상관 없음
SELECT REPLACE('박신우강사님은 502강의장 강사님입니다.', '강사님', '선생님') 
FROM DUAL; -- 여러 개도 상관 없음

-- (실습)EMPLOYEE테이블에서 이메일의 도메인을 gmail.com으로 변경하기



-- (실습)EMPLOYEE 테이블에서 사원명, 주민번호 조회
-- 단, 주민번호는 생년월일만 보이게 하고, '-'다음 값은 '*'로 바꿔라






-------------------------------------------------------------------------------------------------------------------------------------------------

-- 2. 숫자 관련 함수
--  ABS, MOD, ROUND, FLOOR, TRUNC, CEIL

-- *** ABS ***
-- (숫자 | 숫자로 된 컬럼명) : 
SELECT ABS(10.9) FROM DUAL;
SELECT ABS(-10.9) FROM DUAL;
SELECT ABS(10) FROM DUAL;
SELECT ABS(-10) FROM DUAL;

-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** MOD ***
-- (숫자 | 숫자로 된 컬럼명, 숫자 | 숫자로 된 컬럼명) : 
-- 
-- 처음 인자는 _____________ 수, 두번째 인자는 ___________ 수
SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(-10, 3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;
SELECT MOD(-10.9, 3) FROM DUAL;


-- 번외)
SELECT MOD(10, -3) FROM DUAL; 
SELECT MOD(-10, -3) FROM DUAL;

-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** ROUND ***
-- (숫자 | 숫자로 된 컬럼명, [위치]) : 
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.678, 0) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL;
SELECT ROUND(123.456, 2) FROM DUAL;
SELECT ROUND(123.456, -2) FROM DUAL;

-- 번외)
SELECT ROUND(-10.61) FROM DUAL; 

-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** FLOOR *** 
-- (숫자 | 숫자로 된 컬럼명) : 
SELECT FLOOR(123.456) FROM DUAL;
SELECT FLOOR(123.678) FROM DUAL;

-------------------------------------------------------------------------------------------------------------------------------------------------

-- *** TRUNC *** 
-- (숫자 | 숫자로 된 컬럼명, [위치]) : 
SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.678) FROM DUAL;
SELECT TRUNC(123.456, 0) FROM DUAL;
SELECT TRUNC(123.456, 1) FROM DUAL;
SELECT TRUNC(123.456, 2) FROM DUAL;
SELECT TRUNC(123.456, -1) FROM DUAL;

-- FLOOR와 TRUNC의 차이 
SELECT FLOOR(-1.1), TRUNC(-1.1) FROM DUAL;

-------------------------------------------------------------------------------------------------------------------------------------------------

--  *** CEIL ***
-- (숫자 | 숫자로 된 컬럼명) : 
SELECT CEIL(123.456) FROM DUAL;
SELECT CEIL(123.678) FROM DUAL;

SELECT ROUND(123.456),
       FLOOR(123.456),
       TRUNC(123.456),
       CEIL(123.456)
FROM DUAL;


------------------------------------------------------------------------------------------------------------------------------------------

-- 3. 날짜 관련 함수
-- SYSDATE, MONTHS_BETWEEN, ADD_MONTHS, NEXT_DAY, LAST_DAY, EXTRACT

-- SYSDATE : 
SELECT SYSDATE FROM DUAL;


-- MONTHS_BETWEEN(날짜, 날짜) : 
-- EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무 개월 수를 조회
SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
FROM EMPLOYEE;


-- ADD_MONTHS(날짜, 숫자) : 
SELECT ADD_MONTHS(SYSDATE, 2) FROM DUAL;
SELECT ADD_MONTHS(SYSDATE, 8) FROM DUAL; 

-- (실습)EMPLOYEE 테이블에서 사원의 이름, 입사일, 입사 후 6개월이 된 날짜 조회


-- NEXT_DAY(기준 날짜, 요일(문자 | 숫자)) --> 숫자의 경우 
-- 
SELECT SYSDATE, NEXT_DAY(SYSDATE, '목요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 5) FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '목') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, '수박주스는 이디야') FROM DUAL; 
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THURSDAY') FROM DUAL;


ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THURSDAY') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THU') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE, 'MONEY') FROM DUAL; 

SELECT SYSDATE, NEXT_DAY(SYSDATE, '목요일') FROM DUAL; 
ALTER SESSION SET NLS_LANGUAGE = KOREAN;


-- LAST_DAY(날짜) : 
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;


------------- 실습문제----------------------------
-- 1. EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
-- 단, 별칭은 근무일수1, 근무일수2로 하고
-- 모두 정수처리(내림), 양수가 되도록 처리


-- 2. EMPLOYEE 테이블에서 근무 년수가 20년 이상인 직원 정보 조회



-- 3. EMPLOYEE 테이블에서 사원명, 입사일, 입사한 월의 근무일수를 조회


------------------------------------------------------------------------------------------------------


-- EXTRACT : 
-- EXTRACT(YEAR FROM 날짜) : 
-- EXTRACT(MONTH FROM 날짜) : 
-- EXTRACT(DAY FROM 날짜) : 

-- EMPLOYEE테이블에서 사원의 이름, 입사 년, 입사 월, 입사 일 조회
SELECT EMP_NAME 사원이름,
       EXTRACT(YEAR FROM HIRE_DATE) "입사 년도",
       EXTRACT(MONTH FROM HIRE_DATE) 입사월,
       EXTRACT(DAY FROM HIRE_DATE) 입사일
FROM EMPLOYEE;

-- (실습)EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무년수 조회
-- 단 근무년수는 (현재년도 - 입사년도)로 조회하세요


-- (실습)MONTHS_BETWEEN으로 근무년수를 조회





-----------------------------------------------------------------------------------------------------------------------------------------


-- 4. 형변환 함수
-- TO_CHAR(날짜[, 포맷]) : 
-- TO_CHAR(숫자[, 포맷]) : 
SELECT TO_CHAR(1234) FROM DUAL; 
SELECT TO_CHAR(1234) + 4321 FROM DUAL; 
SELECT TO_CHAR(1234, '99999') FROM DUAL; 
SELECT TO_CHAR(1234, '00000') FROM DUAL; 
SELECT TO_CHAR(1234, 'L99999') FROM DUAL; 
SELECT TO_CHAR(1234, 'FML99999') FROM DUAL; 
SELECT TO_CHAR(1234, '$99999') FROM DUAL;
SELECT TO_CHAR(1234, 'FM$99999') FROM DUAL;
SELECT TO_CHAR(1234, '99,999') FROM DUAL; 
SELECT TO_CHAR(1234, 'FM99,999') FROM DUAL;
SELECT TO_CHAR(1234, '00,000') FROM DUAL;
SELECT TO_CHAR(1234, '999') FROM DUAL;

-- (실습)EMPLOYEE 테이블에서 사원명, 급여 조회
-- 급여는 '\9,000,000' 형식으로 표시


-- 날짜 데이터 포맷 적용시에도 TO_CHAR함수 사용
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL; 
SELECT TO_CHAR(SYSDATE, 'YYYY-FMMM-DD DAY') FROM DUAL; 
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY-MM-DD')
FROM EMPLOYEE;
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY-MM-FMDD') 
FROM EMPLOYEE;



SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') 입사일
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE 기존입사일,
       TO_CHAR(HIRE_DATE, 'YYYY/MM/DD HH24:MI:SS') 상세입사일
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE = '90/02/06';
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE = '90-02-06'; -- 위와 같은 뜻

-- (실습)오늘 날짜에 대해 년도 4자리, 년도 2자리, 년도 이름으로 출력



-- 오늘 날짜에서 월만 출력 처리(MM/MONTH/MON/RM)
-- RM : 로마 숫자
SELECT TO_CHAR(SYSDATE, 'MM'), -- 02
       TO_CHAR(SYSDATE, 'MONTH'), -- 2월
       TO_CHAR(SYSDATE, 'MON'), -- 2월
       TO_CHAR(SYSDATE, 'RM') -- II
FROM DUAL;

-- 오늘 날짜에서 일만 출력(DDD/DD/D)
SELECT TO_CHAR(SYSDATE, '"1년기준" DDD "일째"'),
       TO_CHAR(SYSDATE, '"달 기준" DD "일째"'),
       TO_CHAR(SYSDATE, '"주 기준" D "일째"') -- 일요일이 1
FROM DUAL;

-- 오늘 날짜에서 분기와 요일을 출력
SELECT TO_CHAR(SYSDATE, 'Q "분기"'),
       TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

-- (실습)EMPLOYEE 테이블에서 이름, 입사일 조회
-- 입사일은 포맷 적용함 '2017년 12월 06일 (수)' 형식으로 출력


-- TO_DATE : 
-- TO_DATE(문자형 데이터, [포맷]) : 
-- TO_DATE(숫자형 데이터, [포맷]) : 
SELECT TO_DATE('20100101', 'YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20100101, 'YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20220818) FROM DUAL; 
SELECT TO_CHAR(TO_DATE('20100101', 'YYYYMMDD'), 'YYYY, MON') FROM DUAL; 
SELECT TO_CHAR(TO_DATE('041030 143000', 'YYMMDD HH24MISS'),'DD-MON-YY HH:MI:SS PM') FROM DUAL;
SELECT TO_CHAR(TO_DATE('041030 143000', 'YYMMDD HH24MISS'),'YY-MM-DD PM HH:MI:SS DY') FROM DUAL;  

-- RR과 YY의 차이
-- 년도 바꿀 때 (TO_DATE 사용시, TO_CHAR는 적용 안 됨) Y를 적용하면 ____________
-- 
SELECT TO_CHAR(TO_DATE('980630', 'YYMMDD'), 'YYYYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('140918', 'YYMMDD'), 'YYYYMMDD') FROM DUAL;

SELECT TO_CHAR(TO_DATE('980630', 'RRMMDD'), 'YYYYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('140918', 'RRMMDD'), 'YYYYMMDD') FROM DUAL;


-- TO_NUMBER(문자데이터, [포맷]) : 
SELECT TO_NUMBER('123456789') FROM DUAL;

SELECT '123' + '456' FROM DUAL; 
SELECT '123' + '456A' FROM DUAL; 

SELECT '1,000,000' + '550,000' FROM DUAL; -- 에러발생

SELECT TO_NUMBER('1,000,000', '99,999,999') FROM DUAL;
SELECT TO_NUMBER('1,000,000', '9,999,999') + TO_NUMBER('550,000','999,999') FROM DUAL;


-----------------------------------------------------------------------------------------------------------------------------------------


-- 5. NULL 처리 함수
-- NVL(컬럼명, 컬럼값이 NULL일때 바꿀 값)
-- 
SELECT EMP_NAME, BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

SELECT EMP_NAME, DEPT_CODE, NVL(DEPT_CODE, '없습니다')
FROM EMPLOYEE;

-----------------------------------------------------------------------------------------------------------------------------------------


-- 6. 선택함수
-- 여러 가지 경우에 선택을 할 수 있는 기능을 제공한다

-- DECODE(계산식 | 컬럼명, 조건값1, 선택값1, 조건값2, 선택값2.....)
-- 
SELECT EMP_ID, EMP_NAME, EMP_NO,
    DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여')
FROM EMPLOYEE;


-- (실습)
-- 직원의 급여를 인상하고자 한다
-- 직급코드가 J7인 직원은 급여의 10%를 인상하고
-- 직급코드가 J6인 직원은 급여의 15%를 인상하고
-- 직급코드가 J5인 직원은 급여의 20%를 인상하며
-- 그 외 직급의 직원은 급여의 5%만 인상한다.
-- 직원 테이블에서 직원명, 직급코드, 급여, 인상급여(위 조건)을 조회하세요




-- CASE WHEN 조건식 THEN 결과값
--      WHEN 조건식 THEN 결과값
--      ELSE 결과값
-- END
-- 
SELECT EMP_ID, EMP_NAME, EMP_NO,
       CASE WHEN SUBSTR(EMP_NO, 8 , 1) = 1 THEN '남'
            ELSE '여'
       END 성별
FROM EMPLOYEE;


SELECT EMP_ID, EMP_NAME, BONUS,
        CASE BONUS*100 WHEN 30 THEN '30퍼' 
                                  ELSE '30퍼아님'
        END 보너스
FROM EMPLOYEE;

-- (실습) 위의 직급에 따른 보너스 예제


-- (실습)사번, 사원 명, 급여, 등급 조회
-- 등급 조건 : 급여가 500만보다 크면 1등급, 350만보다 크면 2등급, 200만보다 크면 3등급, 나머지는 4등급




-----------------------------------------------------------------------------------------------------------------------------


-- < 그룹함수 > --> SUM, AVG, MAX, MIN, COUNT
-- 

-- SUM(숫자가 기록된 컬럼명) : 

-- EMPLOYEE 테이블에서 전 사원의 급여 총합 조회
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- (실습)EMPLOYEE테이블에서 남자 사원의 급여 총합 조회


-- (실습)EMPLOYEE테이블에서 부서코드가 D5인 직원의 보너스 포함 연봉 합계 조회



-- AVG(숫자가 기록된 컬럼명) : 

-- EMPLOYEE 테이블에서 전 사원의 급여 평균 조회
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- (실습)EMPLOYEE테이블에서 전 사원의 보너스 평균 조회




-- MIN(컬럼명) : 
-- EMPLOYEE테이블에서 가장 적은 급여 조회
SELECT MIN(SALARY)
FROM EMPLOYEE;

-- (실습)EMPLOYEE 테이블에서 알파벳 순서가 가장 빠른 이메일, 가장 빠른 입사일 조회




-- MAX(컬럼명) : 

-- EMPLOYEE테이블에서 가장 많은 급여 조회
SELECT MAX(SALARY)
FROM EMPLOYEE;

-- (실습)EMPLOYEE 테이블에서 알파벳 순서가 가장 늦은 이메일, 가장 최근 입사일 조회


-- COUNT(* | 컬럼명) : 
-- COUNT([DISTINCT] 컬럼명) : 
-- COUNT(*) : 
-- COUNT(컬럼명) : 

-- EMPLOYEE 테이블에서 전체 사원 수, 부서 코드가 있는 사원 수, 사원들이 속해있는 부서의 수 조회
SELECT COUNT(*), COUNT(DEPT_CODE), COUNT(DISTINCT DEPT_CODE) 
FROM EMPLOYEE;