-- 관리자 계정
/*
    데이터베이스 생성과 관리를 담당하는 슈퍼 유저 계정
    오브젝트의 생성, 변경, 삭제 등의 작업이 가능하며
    데이터 베이스에 대한 모든 권한과 책임을 가짐
*/
-- 사용자 계정 (일반 계정)
-- 데이터베이스에 대하여 질의, 갱신, 보고서 작성 등의 작업을 수행할 수 있는 계정
-- 보안을 위해 업무에 필요한 최소한의 권한만 가지는 것을 원칙으로 함

-- 11g CREATE USER KH IDENTIFIED BY KH; 사용가능
-- 12c~ 사용자 명에 C## 접두사가 붙어야지만 생성가능

-- 사용자 명에 붙는 C##을 생략하는 설정
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER SCOTT IDENTIFIED BY SCOTT;

-- 권한 부여
-- GRANT CONNECT TO KH; -- 접속 권한
-- GRANT RESOURCE TO KH; -- 자원 권한
GRANT CONNECT, RESOURCE TO SCOTT;

--ORA-01950: 테이블스페이스 'USER'에 대한 권한이 없습니다.
--12C~ 데이터 저장 공간 설정
ALTER USER SCOTT DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
-- 테이블스페이스 'SYSTEM'에 대한 권한이 없습니다
ALTER USER SCOTT DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;