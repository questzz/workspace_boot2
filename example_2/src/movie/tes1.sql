
-- 데이터베이스 생성 및 사용자 생성

-- 사용자 생성 
create user 'bloguser'@'%' identified by 'asd123';
grant all privileges ON *.* TO 'bloguser'@'%';
/*
 @'%' : 어떤 클라이언트에서든 접근 가능하다는 의미이고, @'localhost'는 해당 컴퓨터에서만 접근 가능하다는 의미입니다.
 *.* : * 는 모든 권한을 의미한다. 
*/
 
use mysql;
select user, host from user;
# 기본 권한 조회
select * from user where user = 'bloguser';


# database 생성 
create database blog;

use blog; 

create table user (
	id int primary key auto_increment, 
    username varchar(100) not null unique, 
    password varchar(100) not null, 
    email varchar(100) not null, 
    address varchar(100), 
    userRole varchar(20),
    createDate timestamp
);

create table board(
	id int primary key auto_increment, 
    userId int, 
    title varchar(100) not null, 
    content longtext, 
    readCount int default 0, 
    foreign key (userId) references user(id)
);

create table reply(
	id int primary key auto_increment, 
    userId int, 
    boardId int, 
	content varchar(300) not null, 
    createDate timestamp, 
    foreign key(userId) references user(id) on delete set null, 
    foreign key(boardId) references board(id) on delete cascade
);

-- GUI Tool 에서 \G 오류 오른쪽 마우스 활용 
-- open value in viewer 사용 후 심볼 확인 
-- SHOW CREATE TABLE reply \G; 
SHOW CREATE TABLE reply;










