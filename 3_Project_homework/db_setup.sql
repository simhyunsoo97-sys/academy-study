-- =====================================================================
-- DB setup for 3_Project_homework (login homework)
-- Open in SQL Developer and run with "Run Script" (F5), not Ctrl+Enter.
--
-- The program connects with:  localhost:1521:xe  /  user SCOTT  /  password SCOTT
-- Test login after setup:     EMPNO 7369  /  PWD 1234
-- =====================================================================


-- =====================================================================
-- [CASE 1] SCOTT account and EMP table already exist  (most common)
--   Connect as SCOTT and run only this part.
--   If you see "ORA-01430: column being added already exists", that is OK.
-- =====================================================================
ALTER TABLE EMP ADD (PWD VARCHAR2(20));
UPDATE EMP SET PWD = '1234';
COMMIT;

SELECT EMPNO, ENAME, PWD FROM EMP;


-- =====================================================================
-- [CASE 2] There is NO SCOTT account
--   Remove the comment marks (/* and */) and run it in two steps.
-- =====================================================================
/*
-- Step 2-1 : connect as SYSTEM and run this.
-- (Oracle 18c/21c needs the first line. On 11g it gives an error - ignore it.)
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER SCOTT IDENTIFIED BY SCOTT DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
GRANT CONNECT, RESOURCE TO SCOTT;

-- Step 2-2 : make a new connection as SCOTT / SCOTT and run this.
CREATE TABLE EMP (
    EMPNO NUMBER(4) PRIMARY KEY,
    ENAME VARCHAR2(10),
    PWD   VARCHAR2(20)
);
INSERT INTO EMP (EMPNO, ENAME, PWD) VALUES (7369, 'SMITH', '1234');
INSERT INTO EMP (EMPNO, ENAME, PWD) VALUES (7499, 'ALLEN', '1234');
COMMIT;

SELECT EMPNO, ENAME, PWD FROM EMP;
*/
