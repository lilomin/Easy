drop table if exists user;
create table user(
  user_id varchar(32) not null,
  username varchar(32) not null,
  password varchar(64) null,
  email varchar(64) not null,
  nickname varchar(32) null,
  create_time timestamp not null,
  update_time timestamp null,
  primary key (user_id, username)
);

