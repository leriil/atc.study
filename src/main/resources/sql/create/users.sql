create schema if not exists cms;

drop table if exists cms.users;

create table if not exists cms.users (
   userId bigint,
   userName text(100),
   userBirthday date,
   userActive boolean
);


CREATE SEQUENCE	IF NOT EXISTS userIdSequence;

insert into cms.users (userId, userName, userBirthday, userActive)
values (1, 'John', '1999-04-04', 1);

insert into cms.users (userId, userName, userBirthday, userActive)
values (2, 'Mary', '2000-06-03', 1);

insert into cms.users (userId, userName, userBirthday, userActive)
values (3, 'Anne', '2001-05-12', 1);

insert into cms.users (userId, userName, userBirthday, userActive)
values (4, 'Mark', '1996-09-05', 0);

