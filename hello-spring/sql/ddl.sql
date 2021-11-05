drop table if exists member cascade;
create table member(
    id bigint generated by default as identity ,
    name varchar(255),
    primary key(id);
)

insert into member(name) values('spring2');
insert into member(name) values('spring1');