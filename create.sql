--- copy tables to backup schema

select bdr.bdr_replicate_ddl_command('create schema IF NOT EXISTS acq_settlement_backup AUTHORIZATION netswitch_test;');

select bdr.bdr_replicate_ddl_command('
create table if not exists acq_settlement_backup.transaction_extract_archive (
    record_id bigserial not null,
    uuid varchar(255) not null,
    insert_date_request timestamp null,
    insert_date_response timestamp null,
    insert_date_reversal timestamp null,
    period_request integer null,
    period_response integer null,
    period_reversal integer null,
    period_settled_atm integer null,
    period_settled_issuer integer null,
    de2_pan varchar(100) not null,
    de3_proc_code varchar(6) null,
    de4_amt_tran varchar(16) null,
    de11_stan varchar(10) null,
    de12_time_local_tran varchar(10) null,
    de13_date_local_tran varchar(10) null,
    de15_date_settle varchar(10) null,
    de37_rrn varchar(20) null,
    de38_auth_code varchar(6) null,
    de39_resp_code varchar(6) null,
    de41_catid varchar(20) null,
    de43_can varchar(50) null,
    channel_name varchar(10) not null,
    advice_code varchar(6) null,
    transaction_type varchar(6) not null,
    client_usn varchar(20) null,
    merchant_usn varchar(20) not null,
    card_balance varchar(16) null,
    batch varchar(6) null,
    sequence integer null,
    issuer_switch integer null,
    de127_private_data varchar(50) null,
    primary key (uuid,transaction_type),
    unique (record_id)
);');

insert into acq_settlement_backup.transaction_extract_archive 
(select * from acq_settlement_test.transaction_extract_archive);

select bdr.bdr_replicate_ddl_command('
create table if not exists acq_settlement_backup.transaction_extract (
    record_id bigserial not null,
    uuid varchar(255) not null,
    insert_date_request timestamp null,
    insert_date_response timestamp null,
    insert_date_reversal timestamp null,
    period_request integer null,
    period_response integer null,
    period_reversal integer null,
    period_settled_atm integer null,
    period_settled_issuer integer null,
    de2_pan varchar(100) not null,
    de3_proc_code varchar(6) null,
    de4_amt_tran varchar(16) null,
    de11_stan varchar(10) null,
    de12_time_local_tran varchar(10) null,
    de13_date_local_tran varchar(10) null,
    de15_date_settle varchar(10) null,
    de37_rrn varchar(20) null,
    de38_auth_code varchar(6) null,
    de39_resp_code varchar(6) null,
    de41_catid varchar(20) null,
    de43_can varchar(50) null,
    channel_name varchar(10) not null,
    advice_code varchar(6) null,
    transaction_type varchar(6) not null,
    client_usn varchar(20) null,
    merchant_usn varchar(20) not null,
    card_balance varchar(16) null,
    batch varchar(6) null,
    sequence integer null,
    issuer_switch integer null,
    de127_private_data varchar(50) null,
    primary key (uuid,transaction_type),
    unique (record_id)
);');

insert into acq_settlement_backup.transaction_extract 
(select * from acq_settlement_test.transaction_extract);

select bdr.bdr_replicate_ddl_command('create table acq_settlement_backup.issuer_clearing_detail (
    period_imported integer null,
    period_settled_issuer integer null,
    online_transaction_ref bigint null,
    settlement_date_request date null,
    period_file integer null,
    file_record_id integer null,
    de2_pan varchar(100) not null,
    de3_proc_code varchar(6) null,
    de37_rrn varchar(20) null,
    de38_auth_code varchar(6) null,
    de39_resp_code varchar(6) null,
    advice_code varchar(6) null,
    transaction_type varchar(6) not null,
    de4_amt_tran varchar(16) null,
    completion_amt_tran varchar(16) null,
    de12_time_local_tran varchar(10) null,
    de13_date_local_tran varchar(10) null,
    de41_catid varchar(20) null,
    client_usn varchar(20) null,
    merchant_usn varchar(20) not null,
    card_balance varchar(16) null,
    batch varchar(6) null,
    sequence integer null,
    issuer_switch integer null,
    de43_can varchar(50) null,
    credit_merchant varchar(20) not null,
    primary key (file_record_id, de2_pan, de37_rrn, merchant_usn, batch, transaction_type),
    unique(online_transaction_ref)
);');

insert into acq_settlement_backup.issuer_clearing_detail
(select * from acq_settlement_test.issuer_clearing_detail);

select bdr.bdr_replicate_ddl_command('create table acq_settlement_backup.issuer_clearing_detail_archive (
    period_imported integer null,
    period_settled_issuer integer null,
    online_transaction_ref bigint null,
    settlement_date_request date null,
    period_file integer null,
    file_record_id integer null,
    de2_pan varchar(100) not null,
    de3_proc_code varchar(6) null,
    de37_rrn varchar(20) null,
    de38_auth_code varchar(6) null,
    de39_resp_code varchar(6) null,
    advice_code varchar(6) null,
    transaction_type varchar(6) not null,
    de4_amt_tran varchar(16) null,
    completion_amt_tran varchar(16) null,
    de12_time_local_tran varchar(10) null,
    de13_date_local_tran varchar(10) null,
    de41_catid varchar(20) null,
    client_usn varchar(20) null,
    merchant_usn varchar(20) not null,
    card_balance varchar(16) null,
    batch varchar(6) null,
    sequence integer null,
    issuer_switch integer null,
    de43_can varchar(50) null,
    credit_merchant varchar(20) not null,
    primary key (file_record_id, de2_pan, de37_rrn, merchant_usn, batch, transaction_type),
    unique(online_transaction_ref)
);');


insert into acq_settlement_backup.issuer_clearing_detail_archive
 (select * from acq_settlement_test.issuer_clearing_detail_archive);

 
select bdr.bdr_replicate_ddl_command('create table acq_settlement_backup.issuer_clearing_fee (
    period_imported integer not null,
    period_settled_issuer integer null,
    period_file integer null,
    file_record_id integer null,
    issuer_switch integer null,
    transaction_type varchar(6) null, 
    fee_type varchar(6) not null, 
    amount varchar(16) null,
    primary key (period_file, file_record_id, fee_type, issuer_switch, transaction_type)
);');

insert into acq_settlement_backup.issuer_clearing_fee

(select * from acq_settlement_test.issuer_clearing_fee);

select bdr.bdr_replicate_ddl_command('create table acq_settlement_backup.settlement_log (
    period integer not null,
    task_id smallint not null,
    date_start timestamp not null,
    date_end timestamp null,
    description varchar(100) not null,
    primary key (period, task_id)
);');

insert into acq_settlement_backup.settlement_log

(select * from acq_settlement_test.settlement_log);

