if not exists (select name from sys.databases where name = N'ExpenseReimbursementSystem')
then
	create database ExpenseReimbursementSystem
end if;
