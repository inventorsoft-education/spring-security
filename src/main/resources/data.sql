DROP SCHEMA IF EXISTS `emails`;
CREATE SCHEMA IF NOT EXISTS `emails` DEFAULT CHARACTER SET utf8 ;
USE `emails` ;

CREATE TABLE IF NOT EXISTS `emails`.`email` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `sender` VARCHAR(50) NOT NULL,
                                                 `receiver` VARCHAR(50) NOT NULL,
                                                 `theme` VARCHAR(200) NOT NULL,
                                                 `content` VARCHAR(2000) NOT NULL,
                                                 `sent` TINYINT(1) NOT NULL,
                                                 `date` DATETIME NOT NULL,
                                                 PRIMARY KEY (`id`));

insert into email(id, sender, receiver, theme, content, sent, `date`) values (1, 'user1@gmail.com', 'user11@gmail.com', 'theme1', 'content1', 1, '2020-01-01 11:11:11');
insert into email(id, sender, receiver, theme, content, sent, `date`) values (2, 'user1@gmail.com', 'user22@gmail.com', 'theme2', 'content2', 1, '2022-02-02 12:22:22');
insert into email(id, sender, receiver, theme, content, sent, `date`) values (3, 'user1@gmail.com', 'user33@gmail.com', 'theme3', 'content3', 1, '2022-03-03 13:33:33');
insert into email(id, sender, receiver, theme, content, sent, `date`) values (4, 'user1@gmail.com', 'user44@gmail.com', 'theme4', 'content4', 1, '2022-04-04 14:44:44');
