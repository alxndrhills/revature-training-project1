alter table ERS_REIMBURSEMENT_STATUS add constraint REIMB_STATUS_PK primary key(REIMB_STATUS_ID);

alter table ERS_REIMBURSEMENT_TYPE add constraint REIMB_TYPE_PK primary key(REIMB_TYPE_ID);
 
alter table ERS_USER_ROLES add constraint USER_ROLE_PK primary key(USER_ROLE_ID);
 
alter table ERS_USERS add constraint USER_PK primary key(USER_ID);
 
alter table ERS_REIMBURSEMENT add constraint REIMBURSEMENT_PK primary key(REIMB_ID); 

alter table ERS_USERS add constraint USER_ROLE_FK foreign key(USER_ROLE_ID)
	references ERS_USER_ROLES(USER_ROLE_ID);
 
alter table ERS_REIMBURSEMENT add constraint USERS_FK_AUTH foreign key(REIMB_AUTHOR)
	references ERS_USERS(USER_ID);
 
alter table ERS_REIMBURSEMENT add constraint USERS_FK_RESLVR foreign key(REIMB_RESOLVER)
	references ERS_USERS(USER_ID);
 
alter table ERS_REIMBURSEMENT add constraint REIMBURSEMENT_STATUS_FK foreign key(REIMB_STATUS_ID)
	references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID);
 
alter table ERS_REIMBURSEMENT add constraint REIMBURSEMENT_TYPE_FK foreign key(REIMB_TYPE_ID)
	references ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID);
 
alter table ERS_USERS add constraint ERS_USERS_UQ unique(USERNAME, USER_EMAIL);
 









