
create table account_status
(
	id int auto_increment
		primary key,
	created datetime not null,
	modified datetime not null,
	name varchar(32) not null,
	constraint account_status_id_uindex
		unique (id)
)
;

alter table account
	add constraint account_account_status_id_fk
		foreign key (status_id) references heroku_7847d3e246e99bb.account_status (id)
;

create table account_type
(
	id int auto_increment
		primary key,
	created datetime not null,
	modified datetime not null,
	name varchar(32) null,
	constraint account_type_id_uindex
		unique (id)
)
;

alter table account
	add constraint account_account_type_id_fk
		foreign key (type_id) references heroku_7847d3e246e99bb.account_type (id)
;

create table app_config
(
	id int auto_increment
		primary key,
	description varchar(64) not null,
	config_key varchar(128) not null,
	config_value varchar(256) not null,
	status int not null,
	constraint app_config_id_uindex
		unique (id)
)
;

create table bank
(
	id int auto_increment
		primary key,
	created datetime not null,
	modified datetime not null,
	name varchar(32) null,
	description varchar(64) null,
	constraint bank_id_uindex
		unique (id)
)
;

alter table account
	add constraint account_bank_id_fk
		foreign key (bank_id) references heroku_7847d3e246e99bb.bank (id)
;

create table tran_category
(
	id int auto_increment
		primary key,
	created datetime not null,
	modified datetime not null,
	name varchar(32) null,
	constraint tran_category_id_uindex
		unique (id)
)
;

create table tran_status
(
	id int auto_increment
		primary key,
	created datetime not null,
	modified datetime not null,
	name varchar(32) not null,
	constraint tran_status_id_uindex
		unique (id)
)
;

create table tran_type
(
	id int auto_increment
		primary key,
	created datetime not null,
	modified datetime not null,
	name varchar(32) null,
	constraint tran_type_id_uindex
		unique (id)
)
;

create table transaction
(
	id int auto_increment
		primary key,
	created datetime not null,
	modified datetime not null,
	status_id int null,
	type_id int null,
	category_id int null,
	account_id int null,
	tran_num varchar(32) not null,
	tran_ref_num varchar(32) not null,
	tran_date datetime not null,
	tran_post_date datetime not null,
	tran_desc varchar(64) not null,
	tran_amount decimal(12,4) not null,
	constraint transaction_id_uindex
		unique (id),
	constraint transaction_tran_status_id_fk
		foreign key (status_id) references heroku_7847d3e246e99bb.tran_status (id),
	constraint transaction_tran_type_id_fk
		foreign key (type_id) references heroku_7847d3e246e99bb.tran_type (id),
	constraint transaction_tran_category_id_fk
		foreign key (category_id) references heroku_7847d3e246e99bb.tran_category (id),
	constraint transaction_account_id_fk
		foreign key (account_id) references heroku_7847d3e246e99bb.account (id)
)
;

create index transaction_tran_category_id_fk
	on transaction (category_id)
;

create index transaction_tran_status_id_fk
	on transaction (status_id)
;

create index transaction_tran_type_id_fk
	on transaction (type_id)
;

create index transaction_account_id_fk
	on transaction (account_id)
;


create table account
(
	id int auto_increment
		primary key,
	status_id int null,
	bank_id int null,
	type_id int null,
	created datetime not null,
	modified datetime not null,
	acc_num varchar(32) not null,
	acc_name varchar(32) not null,
	acc_description varchar(64) not null,
	acc_balance decimal(12,4) not null,
	constraint account_id_uindex
		unique (id)
)
;

create index account_account_status_id_fk
	on account (status_id)
;

create index account_account_type_id_fk
	on account (type_id)
;

create index account_bank_id_fk
	on account (bank_id)
;

