1.User表：
```mysql
create table if not exists `user`(
    `user_id` int unsigned auto_increment,
    `username` varchar(30) not null ,
    `password` varchar(30) not null ,
    `user_type` tinyint not null ,
    `name` varchar(10) default null,
    `cardtype` char(5) default '0',
    `cardnum` char(15) default null ,
    `phone` char(11) default null ,
    `user_level` tinyint default 1,
    `content` varchar(100) default null,
    `address` char(5) default null,
    `register_time` DATE ,
    `modify_time` DATE,
    primary key (user_id)
)ENGINE=Innodb DEFAULT CHARSET=utf8;
```
2.召集令类
3.召集令请求类