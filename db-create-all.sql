create table customer (
  id                            bigint auto_increment not null,
  name                          varchar(255) not null,
  start_date                    date,
  comments                      clob,
  version                       bigint not null,
  constraint pk_customer primary key (id)
);

