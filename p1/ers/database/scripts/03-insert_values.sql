-- ROLES
insert into ERS_USER_ROLES(USER_ROLE_ID, USER_ROLE)
values (1, 'Employee');

insert into ERS_USER_ROLES(USER_ROLE_ID, USER_ROLE)
values (2, 'Financial Manager');

-- REIMBURSEMENT TYPES
insert into ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
values (1, 'Lodging');

insert into ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
values (2, 'Travel');

insert into ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
values (3, 'Food');

insert into ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID, REIMB_TYPE)
values (4, 'Other');

-- REIMBURSEMENT STATUSES
insert into ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID, REIMB_STATUS)
values (1, 'Pending');

insert into ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID, REIMB_STATUS)
values (2, 'Approved');

insert into ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID, REIMB_STATUS)
values (3, 'Denied');

-- USERS
insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('bart.kluge', 'qgBQJH4M', 'Bart', 'Kluge', 'bart.kluge@revature.com', 2);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('elda.krom', '7O5GoZkx', 'Elda', 'Krom', 'elda.krom@revature.com', 2);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('na.browne', 'gJ2ix8rm', 'Na', 'Browne', 'na.browne@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('laurence.sevin', 'qBQ9N7yi', 'Laurence', 'Sevin', 'laurence.sevin@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('dewitt.stanford', 'UF2auh9r', 'Dewitt', 'Stanford', 'dewitt.stanford@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('rupert.schutz', 'K0SKYrWv', 'Rupert', 'Schutz', 'rupert.schutz@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('tonette.mcnamee', 'W7hmSNX9', 'Tonette', 'Mcnamee', 'tonette.mcnamee@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('prince.dunnington', 'bri8EYqQ', 'Prince', 'Dunnington', 'prince.dunnington@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('nenita.pitman', 'xJG3J1MD', 'Nenita', 'Pitman', 'nenita.pitman@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('sandie.pella', 'Fl1u6bVM', 'Sandie', 'Pella', 'sandie.pella@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('billy.hochman', 'CCWlW61M', 'Billy', 'Hochman', 'billy.hochman@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('herma.blansett', '62K2mTAg', 'Herma', 'Blansett', 'herma.blansett@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('columbus.brogden', 'zm72CyYC', 'Columbus', 'Brogden', 'columbus.brogden@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('karen.blanc', 'aBwL5E9t', 'Karen', 'Blanc', 'karen.blanc@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('margaretta.cuccia', 'k4Om2ALa', 'Margaretta', 'Cuccia', 'margaretta.cuccia@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('tamisha.siple', 'zT3gxSmf', 'Tamisha', 'Siple', 'tamisha.siple@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('celsa.nilles', 'CeJj7KAj', 'Celsa', 'Nilles', 'celsa.nilles@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('jerrell.batalla', '5KxmcD8b', 'Jerrell', 'Batalla', 'jerrell.batalla@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('merna.lasley', '19lZsE6O', 'Merna', 'Lasley', 'merna.lasley@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('jayson.clopton', 'OSNyb68P', 'Jayson', 'Clopton', 'jayson.clopton@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('ellie.stilson', '1cZfpBOD', 'Ellie', 'Stilson', 'ellie.stilson@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('arnold.hotard', 'xKeP0zIr', 'Arnold', 'Hotard', 'arnold.hotard@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('irwin.lobdell', 'q0uVbOsC', 'Irwin', 'Lobdell', 'irwin.lobdell@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('bernard.smith', 'N5spw7ri', 'Bernard', 'Smith', 'bernard.smith@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('naoma.plyler', 'AD5pst4i', 'Naoma', 'Plyler', 'naoma.plyler@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('freddie.maclean', '3KCpcSKn', 'Freddie', 'Maclean', 'freddie.maclean@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('lindsay.augusta', '3t0s8cAj', 'Lindsay', 'Augusta', 'lindsay.augusta@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('viva.gesell', 'SmSV20Q1', 'Viva', 'Gesell', 'viva.gesell@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('philip.vanderploeg', 'EP6FcaDF', 'Philip', 'Vanderploeg', 'philip.vanderploeg@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('yuonne.brumbaugh', 'eLTbL3Ib', 'Yuonne', 'Brumbaugh', 'yuonne.brumbaugh@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('antone.robare', 'Hk6tnJdJ', 'Antone', 'Robare', 'antone.robare@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('nicholas.ishii', 'QhDY9o6v', 'Nicholas', 'Ishii', 'nicholas.ishii@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('leoma.allsup', '6xi8QTXE', 'Leoma', 'Allsup', 'leoma.allsup@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('renita.dorey', 'z0zWTigl', 'Renita', 'Dorey', 'renita.dorey@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('horacio.keating', 'bLY8L4Fi', 'Horacio', 'Keating', 'horacio.keating@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('lionel.eusebio', 'IZCZyr9W', 'Lionel', 'Eusebio', 'lionel.eusebio@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('amberly.ester', 'nJL9Lm6o', 'Amberly', 'Ester', 'amberly.ester@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('lee.line', 'NxMR2Jy3', 'Lee', 'Line', 'lee.line@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('deloise.tuch', '9wyIbE1D', 'Deloise', 'Tuch', 'deloise.tuch@revature.com', 1);

insert into ERS_USERS(USERNAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
values ('alanna.goff', 'RvtQGo0h', 'Alanna', 'Goff', 'alanna.goff@revature.com', 1);

-- REIMBURSEMENTS

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (289.42, 'Rail ticket Washington DC <-> New York, NY', 12, 2, 2, 2); -- approved travel

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (829.48, 'Airplane ticket Washington DC <-> San Francisco, CA', 19, 2, 2, 2); -- approved travel

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (11.74, 'Breakfast during meeting', 13, 2, 2, 3); -- approved food

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (190.31, 'one day stay in a hotel in Ketchikan, AL', 33, 1, 3, 1); -- denied lodging

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (13.96, 'Lunch during meeting', 23, 2, 2, 3); -- approved food

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (849.99, 'TV for presentations', 17, 2, 2, 4); -- approved other

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (35.12, 'Dinner during meeting', 8, 2, 2, 3); -- approved food

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (17.61, 'Bus ticket Washington DC <-> Baltimore, MD', 36, 2, 2, 2); -- approved travel

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (43.51, 'Bagels and coffee for meeting', 11, 1, 2, 1); -- approved food

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (327.80, 'two day stay in a hotel in Los Angeles, CA', 19, 2, 2, 1); -- approved lodging

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (210.96, 'Airbnb for 3 days in Tampa, FL', 22, 2, 2, 1); -- approved lodging

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (24.75, 'Uber cost to the client', 31, 1, 2, 2); -- approved travel

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (312.57, 'Director''s birthday party', 30, 2, 2, 4); -- approved other

insert into ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
values (6290.68, 'four MacBooks for meetings', 18, 2, 3, 4); -- denied other

commit;








