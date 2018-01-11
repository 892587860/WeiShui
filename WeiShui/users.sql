/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : voucher

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-09 20:31:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) NOT NULL,
  `campus_id` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `headimg_url` varchar(255) DEFAULT NULL,
  `language` varchar(10) DEFAULT NULL,
  `province` varchar(10) DEFAULT NULL,
  `groupid` varchar(5) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `sex` smallint(1) DEFAULT NULL,
  `remark` varchar(10) DEFAULT NULL,
  `total_amount` float(6,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
