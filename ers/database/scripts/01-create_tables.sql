drop table ERS_REIMBURSEMENT_STATUS CASCADE CONSTRAINTS;
drop table ERS_REIMBURSEMENT_TYPE  CASCADE CONSTRAINTS;
drop table ERS_USER_ROLES CASCADE CONSTRAINTS;
drop table ERS_USERS CASCADE CONSTRAINTS;
drop table ERS_REIMBURSEMENT CASCADE CONSTRAINTS;

create table ERS_REIMBURSEMENT_STATUS (
	REIMB_STATUS_ID number(5) not null,
	REIMB_STATUS varchar2(20) not null
);
	
create table ERS_REIMBURSEMENT_TYPE (
	REIMB_TYPE_ID number(5) not null,
	REIMB_TYPE varchar2(20) not null
);

create table ERS_USER_ROLES (
	USER_ROLE_ID number(5) not null,
	USER_ROLE varchar2(20) not null
);

create table ERS_USERS (
	USER_ID number(10) not null,
	USERNAME varchar2(50) not null,
	PASSWORD varchar2(250) not null,
	USER_FIRST_NAME varchar2(100) not null,
	USER_LAST_NAME varchar2(100) not null,
	USER_EMAIL varchar2(150) not null,
	USER_ROLE_ID number(5) not null
);

create sequence USER_SEQ start with 1 increment by 1;

create or replace trigger USER_TR
	 before insert on ERS_USERS for each row
	 when (new.USER_ID is null)
	begin
 select USER_SEQ.nextval into :new.USER_ID from dual;
end;
/

create table ERS_REIMBURSEMENT (
	REIMB_ID number(10) not null,
	REIMB_AMOUNT number(19, 4) not null,
	REIMB_SUBMITTED timestamp(3) default SYSTIMESTAMP,
	REIMB_RESOLVED timestamp(3) null,
	REIMB_DESCRIPTION varchar2(250) null,
	REIMB_RECEIPT blob null,
	REIMB_AUTHOR number(10) not null,
	REIMB_RESOLVER number(10) null,
	REIMB_STATUS_ID number(5) not null,
	REIMB_TYPE_ID number(5) not null
);

create sequence REIMBURSEMENT_SEQ start with 1 increment by 1;

create or replace trigger REIMBURSEMENT_TR
	 before insert on ERS_REIMBURSEMENT for each row
	 when (new.REIMB_ID is null)
	begin
 select REIMBURSEMENT_SEQ.nextval into :new.REIMB_ID from dual;
end;
/
