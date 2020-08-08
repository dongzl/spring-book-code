create database user_info;
create database order_info;

use user_info;

CREATE TABLE `user_info` (
	`user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`user_name` varchar(10) DEFAULT NULL COMMENT '用户名称',
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

use order_info;

CREATE TABLE `order_info` (
	`order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`user_id` bigint(10) NOT NULL COMMENT '用户id',
	PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';