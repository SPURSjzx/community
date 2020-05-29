/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.46 : Database - springboot
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springboot` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `springboot`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `commentator` int(11) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `like_count` int(20) DEFAULT '0',
  `content` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `comment` */

insert  into `comment`(`id`,`parent_id`,`type`,`commentator`,`gmt_create`,`gmt_modified`,`like_count`,`content`) values (1,1,1,17,1590735318830,1590735318830,0,NULL);

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `description` text,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modifier` bigint(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `coment_count` int(11) DEFAULT '0',
  `view_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `tag` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

/*Data for the table `question` */

insert  into `question`(`id`,`title`,`description`,`gmt_create`,`gmt_modifier`,`creator`,`coment_count`,`view_count`,`like_count`,`tag`) values (17,'1','1590047981938',1590047981938,1590047981938,17,0,8,0,'1590047981938'),(21,'2','1590047981938',1590047981938,1590047981938,17,0,5,0,'1590047981938fsdfdsfsd'),(22,' sdas','sadas',NULL,NULL,17,0,1,0,'asd'),(23,'fsd','dsfsd',NULL,NULL,17,0,1,0,'sdf'),(24,'fsd','dfsf',NULL,NULL,17,0,1,0,'sdf'),(25,'3','1590047981938',1590047981938,1590047981938,17,0,1,0,'1590047981938'),(26,'4','1590047981938',1590047981938,1590047981938,17,0,1,0,'1590047981938'),(27,'5','1590047981938',1590047981938,1590047981938,17,0,1,0,'1590047981938'),(28,'6','1590047981938',1590047981938,1590047981938,17,0,1,0,'1590047981938'),(29,'fds','dsfsd',NULL,NULL,17,0,1,0,'fds'),(30,'das','asd',NULL,NULL,17,0,1,0,'das'),(31,'2','1590047981938',NULL,NULL,17,0,1,0,'1590047981938fdf'),(32,'1','1590047981938',NULL,NULL,17,0,1,0,'1590047981938fsdfdsfsd'),(33,'2dasda','1590047981938',NULL,NULL,17,0,1,0,'1590047981938'),(34,'2','1590047981938asd',NULL,NULL,17,0,1,0,'1590047981938dsad'),(35,'2fsdf','1590047981938',NULL,NULL,17,0,1,0,'1590047981938sdf'),(36,'2','1590047981938asd',NULL,NULL,17,0,1,0,'1590047981938'),(37,'2','1590047981938adsa',NULL,NULL,17,0,1,0,'1590047981938'),(38,'1','1590047981938',NULL,NULL,17,0,1,0,'1590047981938dasd'),(39,'2','1590047981938 ',NULL,NULL,17,0,1,0,'1590047981938asd'),(40,'2das','1590047981938',NULL,NULL,17,0,1,0,'1590047981938'),(41,'2dasd','1590047981938',NULL,NULL,17,0,1,0,'1590047981938'),(42,'2','1590047981938',NULL,NULL,17,0,1,0,'1590047981938dsf'),(43,'2','1590047981938',NULL,NULL,17,0,1,0,'1590047981938asd'),(44,'2','1590047981938',NULL,NULL,17,0,1,0,'1590047981938das');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `token` char(36) CHARACTER SET utf8 DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `bio` varchar(256) DEFAULT NULL,
  `avatar_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`account_id`,`name`,`token`,`gmt_create`,`gmt_modified`,`bio`,`avatar_url`) values (17,'39519593','小兆子','7c72bbd2-7db1-4b1b-9dba-f4102e2d3086',1590047981938,NULL,NULL,'https://avatars2.githubusercontent.com/u/39519593?v=4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
