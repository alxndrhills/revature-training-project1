alter session set current_schema = ExpenseReimbursementSystem;
 

if not exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_STATUS]') and type in (N'u'))
then
	create table ERS_REIMBURSEMENT_STATUS (
		reimb_status_id number(5) not null,
		reimb_status varchar2(10) not null
	);
end if;
 

if not exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_TYPE]') and type in (N'u'))
then
	create table ERS_REIMBURSEMENT_TYPE (
		REIMB_TYPE_ID number(5) not null,
		REIMB_TYPE varchar2(10) not null
	);
end if;
 

if not exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_USER_ROLES]') and type in (N'u'))
then
	create table ERS_USER_ROLES (
		ERS_USER_ROLE_ID number(5) not null,
		USER_ROLE varchar2(10) not null
	);
end if;
 

if not exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_USERS]') and type in (N'u'))
then
	create table ERS_USERS (
			ERS_USERS_ID number(10) not null ,
			ERS_USERNAME varchar2(50) not null,
			ERS_PASSWORD varchar2(50) not null,
			USER_FIRST_NAME varchar2(100) not null,
			USER_LAST_NAME varchar2(100) not null,
			USER_EMAIL varchar2(150) not null,
			USER_ROLE_ID number(5) not null
	);

-- Generate ID using sequence and trigger
create sequence ERS_USERS_seq start with 1 increment by 1;

create or replace trigger ERS_USERS_seq_tr
	 before insert on ERS_USERS for each row
	 when (new.ERS_USERS_ID is null)
	begin
 select ERS_USERS_seq.nextval into :new.ERS_USERS_ID from dual;
end;
/
end if;
 

if not exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]') and type in (N'u'))
then
	create table ERS_REIMBURSEMENT (
		REIMB_ID number(10) not null ,
		REIMB_AMOUNT number not null,
		REIMB_SUBMITTED timestamp(3) not null,
		REIMB_RESOLVED timestamp(3) null,
		REIMB_DESCRIPTION varchar2(250) null,
		REIMB_RECEIPT varbinary(max) null,
		REIMB_AUTHOR number(10) not null,
		REIMB_RESOLVER number(10) null,
		REIMB_STATUS_ID number(5) not null,
		REIMB_TYPE_ID number(5) not null
	);

-- Generate ID using sequence and trigger
create sequence ERS_REIMBURSEMENT_seq start with 1 increment by 1;

create or replace trigger ERS_REIMBURSEMENT_seq_tr
	 before insert on ERS_REIMBURSEMENT for each row
	 when (new.REIMB_ID is null)
	begin
 select ERS_REIMBURSEMENT_seq.nextval into :new.REIMB_ID from dual;
end;
/
end if;
 

