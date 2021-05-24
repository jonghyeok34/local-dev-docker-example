# Oracle 구동하기 

# start

```
docker run -d --name oracle -p 1521:1521 sandersliu/docker-oracle-xe-10g
```
# 정보 

```
1. 접속 계정
SYSTEM/ORACLE 

2. 계정생성 
CREATE USER FINONET IDENTIFIED BY FINONET00;

3. 권한 주기. 
GRANT RESOURCE, CONNECT TO FINONET;
```


```
-- 테이블 스페이스 생성
CREATE TABLESPACE TS_SSANIJARO_SHINHAN  datafile '/u01/app/oracle/oradata/XE/TS_SSANIJARO_SHINHAN.dbf' SIZE 512M AUTOEXTEND on next 100M;
-- 임시 테이블스페이스 생성
CREATE TEMPORARY TABLESPACE TS_SSANIJARO_SHINHAN_TEMP  TEMPFILE  '/u01/app/oracle/oradata/XE/TS_SSANIJARO_SHINHAN_TEMP.dbf' SIZE 100M AUTOEXTEND on next 10M;

-- 계정생성
CREATE USER SSANIJARO_SHINHAN  IDENTIFIED BY  "SSANIJARO_SHINHAN00"
DEFAULT TABLESPACE TS_SSANIJARO_SHINHAN
TEMPORARY TABLESPACE TS_SSANIJARO_SHINHAN_TEMP
QUOTA UNLIMITED ON TS_SSANIJARO_SHINHAN;

-- 접속 권한주기
GRANT RESOURCE, CONNECT to SSANIJARO_SHINHAN;
-- 테이블스페이스 사용권한
GRANT UNLIMITED TABLESPACE TO SSANIJARO_SHINHAN;


CREATE USER oracle_admin 
    IDENTIFIED BY "Finotek1004!";
GRANT ALL PRIVILEGES TO oracle_admin;

CREATE SCHEMA AUTHORIZATION oracle_admin
CREATE TABLE user_info(
    user_id VARCHAR2(100) NOT NULL PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    rrn VARCHAR2(13) NOT NULL,
    phone_number VARCHAR2(50) NOT NULL,
    carrier VARCHAR2(50),
    birthdate VARCHAR2(6),
    CONSTRAINT user_unique UNIQUE( rrn)
);

CREATE TABLE loan_process(
    loan_process_id VARCHAR2(100) NOT NULL PRIMARY KEY,
    user_id VARCHAR2(100) NOT NULL,
    reg_dt DATE NOT NULL,
    last_update_dt DATE,
    process_code VARCHAR2(10),
    status_code VARCHAR2(10)
);

CREATE TABLE agreement_history(
    agreehist_id VARCHAR2(100) PRIMARY KEY,
    user_id VARCHAR2(100) NOT NULL,
    policy_type VARCHAR2(100) NOT NULL,
    version VARCHAR2(100) NOT NULL,
    reg_dt DATE NOT NULL
);


CREATE TABLE TEMP_FILES(
    temp_files_id VARCHAR2(100) PRIMARY KEY,
    user_id VARCHAR2(100) NOT NULL,
    file_name VARCHAR2(100) NOT NULL,
    content BLOB NOT NULL,
    reg_dt DATE NOT NULL
);


CREATE SEQUENCE USER_INFO_SEQ
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE LOAN_PROCESS_SEQ
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE TEMP_FILES_SEQ
    START WITH 1
    INCREMENT BY 1;
```