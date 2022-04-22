create table employee
(
    id           integer not null auto_increment,
    date_updated datetime(6),
    date_created datetime(6),
    department   varchar(255),
    name         varchar(255),
    salary       integer,
    surname      varchar(255),
    primary key (id)
)
