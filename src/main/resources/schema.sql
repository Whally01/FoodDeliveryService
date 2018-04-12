drop table if exists role cascade
drop table if exists user cascade;
drop table if exists users_roles cascade;


CREATE TABLE `role` (
  `is` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);