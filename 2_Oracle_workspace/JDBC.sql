CREATE TABLE MEMBER(
    member_id varchar2(30) primary key,
    memeber_pwd varchar2(30) not null,
    memeber_name varchar2(30) not null,
    gender char(1) check(gender in('M','F')),
    email varchar2(50),
    phone varchar2(30),
    address varchar2(100),
    age number,
    enroll_Date date default sysdate
);
insert into member
values('user01', 'pass01', '홍길동', 'M', 'hong_gd@kh.or.kr', '010-1234-1234', '경기도 남양주시 지금동',
        20, sysdate);
        
insert into member
values('user02', 'pass02', '김유신', 'M', 'kim_ys@kh.or.kr', '010-1234-1234', '경기도 시흥시 정왕동',
        19, sysdate);
        
insert into member
values('user03', 'pass03', '이순신', 'M', 'lee_ss@kh.or.kr', '10-1234-1234', '서울시 강남구 역삼동',
        12, sysdate);
        
insert into member
values('user04', 'pass04', '김영희', 'F', 'kim_yh@kh.or.kr', '010-1234-1234', '서울시 관악구 봉천동',
        27, sysdate);
        
insert into member
values('user05', 'pass05', '박철수', 'M', 'park_sc@kh.or.kr', '010-1234-1234', '경기도 수원시 연무동',
        20, sysdate);
        
insert into member
values('user06', 'pass06', '유미영', 'F', 'yoo_my@kh.or.kr', '010-1234-1234', '서울시 종로구 관철동',
        20, sysdate);
select * from member;
commit;
desc member;
ALTER TABLE MEMBER
RENAME COLUMN MEMEBER_PWD TO MEMBER_PWD;

ALTER TABLE MEMBER
RENAME COLUMN MEMEBER_NAME TO MEMBER_NAME;