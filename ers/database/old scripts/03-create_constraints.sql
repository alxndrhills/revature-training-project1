alter session set current_schema = ExpenseReimbursementSystem;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_STATUS]') and type in (N'u')) and
	not exists (select * from sys.indexes where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_STATUS]') and name = N'REIMB_STATUS_PK')
then
	alter table ERS_REIMBURSEMENT_STATUS add constraint REIMB_STATUS_PK primary key(REIMB_STATUS_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_TYPE]') and type in (N'u')) and
	not exists (select * from sys.indexes where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_TYPE]') and name = N'REIMB_TYPE_PK')
then
	alter table ERS_REIMBURSEMENT_TYPE add constraint REIMB_TYPE_PK primary key(REIMB_TYPE_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_USER_ROLES]') and type in (N'u')) and
	not exists (select * from sys.indexes where object_id = object_id(N'[dbo].[ERS_USER_ROLES]') and name = N'ERS_USER_ROLES_PK')
then
	alter table ERS_USER_ROLES add constraint ERS_USER_ROLES_PK primary key(ERS_USER_ROLE_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_USERS]') and type in (N'u')) and
	not exists (select * from sys.indexes where object_id = object_id(N'[dbo].[ERS_USERS]') and name = N'ERS_USERS_PK')
then
	alter table ERS_USERS add constraint ERS_USERS_PK primary key(ERS_USERS_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]') and type in (N'u')) and
	not exists (select * from sys.indexes where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]') and name = N'ERS_REIMBURSEMENT_PK')
then
	alter table ERS_REIMBURSEMENT add constraint ERS_REIMBURSEMENT_PK primary key(REIMB_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_USERS]') and type in (N'u')) and
	not exists (select * from sys.foreign_keys where object_id = object_id(N'[dbo].[USER_ROLES_FK]') and parent_object_id = object_id(N'[dbo].[ERS_USERS]'))
then
	alter table ERS_USERS add constraint USER_ROLES_FK foreign key(USER_ROLE_ID)
		references ERS_USER_ROLES(ERS_USER_ROLE_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]') and type in (N'u')) and
	not exists (select * from sys.foreign_keys where object_id = object_id(N'[dbo].[ERS_USERS_FK_AUTH]') and parent_object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]'))
then
	alter table ERS_REIMBURSEMENT add constraint ERS_USERS_FK_AUTH foreign key(REIMB_AUTHOR)
		references ERS_USERS(ERS_USERS_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]') and type in (N'u')) and
	not exists (select * from sys.foreign_keys where object_id = object_id(N'[dbo].[ERS_USERS_FK_RESLVR]') and parent_object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]'))
then
	alter table ERS_REIMBURSEMENT add constraint ERS_USERS_FK_RESLVR foreign key(REIMB_RESOLVER)
		references ERS_USERS(ERS_USERS_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]') and type in (N'u')) and
	not exists (select * from sys.foreign_keys where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_STATUS_FK]') and parent_object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]'))
then
	alter table ERS_REIMBURSEMENT add constraint ERS_REIMBURSEMENT_STATUS_FK foreign key(REIMB_STATUS_ID)
		references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]') and type in (N'u')) and
	not exists (select * from sys.foreign_keys where object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT_TYPE_FK]') and parent_object_id = object_id(N'[dbo].[ERS_REIMBURSEMENT]'))
then
	alter table ERS_REIMBURSEMENT add constraint ERS_REIMBURSEMENT_TYPE_FK foreign key(REIMB_TYPE_ID)
		references ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID);
end if;
 

if exists (select * from sys.objects where object_id = object_id(N'[dbo].[ERS_USERS]') and type in (N'u')) and
	not exists (select * from sys.indexes where object_id = object_id(N'[dbo].[ERS_USERS]') and name = N'ERS_USERS_UQ')
then
	alter table ERS_USERS add constraint ERS_USERS_UQ unique(ERS_USERNAME, USER_EMAIL);
end if;
 









