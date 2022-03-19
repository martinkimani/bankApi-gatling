create table IF NOT EXISTS transactions 
(id int auto_increment PRIMARY KEY, transaction_type varchar (255), reference varchar (255),amount decimal(17,2),
creation_date timestamp default CURRENT_TIMESTAMP);

create table IF NOT EXISTS bank_account(id int auto_increment PRIMARY KEY,balance decimal(17,2));