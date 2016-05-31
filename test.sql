/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.28 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`name`) values (1,'Java技术部');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(40) NOT NULL COMMENT '姓名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `age` int(4) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`age`) values (1,'宋江0','songjiang',39),(2,'宋江1','songjiang',39),(3,'宋江2','songjiang',39),(4,'宋江3','songjiang',39),(6,'宋江4','songjiang',39),(7,'宋江5','songjiang',39),(8,'宋江6','songjiang',39),(9,'宋江7','songjiang',39),(13,'宋江8','songjiang',39),(14,'宋江9','songjiang',39),(15,'宋江10','songjiang',39),(16,'宋江11','songjiang',39),(17,'宋江12','songjiang',39),(18,'宋江13','songjiang',39),(19,'宋江14','songjiang',39),(20,'宋江15','songjiang',39),(28,'宋江16','songjiang',39),(29,'宋江17','songjiang',39),(30,'宋江18','songjiang',39),(31,'宋江19','songjiang',39),(32,'宋江20','songjiang',39),(33,'宋江21','songjiang',39),(34,'宋江22','songjiang',39),(35,'宋江23','songjiang',39),(36,'宋江24','songjiang',39),(37,'宋江25','songjiang',39),(38,'宋江26','songjiang',39),(39,'宋江27','songjiang',39),(40,'宋江28','songjiang',39),(41,'宋江29','songjiang',39),(42,'宋江30','songjiang',39),(43,'宋江31','songjiang',39);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
