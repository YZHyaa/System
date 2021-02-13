/*
Navicat MySQL Data Transfer

Source Server         : localhost-5.1
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : ezhao

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2020-12-13 22:21:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `col_id` int(10) NOT NULL AUTO_INCREMENT,
  `note_id` int(10) DEFAULT NULL,
  `u_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`col_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `com_id` int(10) NOT NULL AUTO_INCREMENT,
  `com_content` varchar(1000) DEFAULT NULL,
  `com_date` datetime DEFAULT NULL,
  `to_note_id` int(10) DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `fol_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT NULL,
  `fans_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`fol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `info_id` int(10) NOT NULL AUTO_INCREMENT,
  `info_name` varchar(100) DEFAULT NULL,
  `info_gender` varchar(10) DEFAULT NULL,
  `info_school` varchar(100) DEFAULT NULL,
  `info_cid` varchar(20) DEFAULT NULL,
  `info_profession` varchar(100) DEFAULT NULL,
  `info_phone` varchar(11) DEFAULT NULL,
  `u_name` varchar(100) DEFAULT NULL,
  `u_id` int(10) NOT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `lab_id` int(10) NOT NULL AUTO_INCREMENT,
  `lab_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `msg_id` int(10) NOT NULL AUTO_INCREMENT,
  `from_id` int(10) DEFAULT NULL,
  `to_id` int(10) DEFAULT NULL,
  `msg_content` varchar(500) DEFAULT NULL,
  `msg_date` datetime DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` int(10) NOT NULL AUTO_INCREMENT,
  `news_content` varchar(10000) DEFAULT NULL,
  `news_title` varchar(100) DEFAULT NULL,
  `news_date` datetime DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  `news_school` varchar(100) DEFAULT NULL,
  `lab_id` int(10) DEFAULT NULL,
  `pic_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `note_id` int(10) NOT NULL AUTO_INCREMENT,
  `note_title` varchar(100) DEFAULT NULL,
  `note_content` varchar(10000) DEFAULT NULL,
  `lab_id` int(100) DEFAULT NULL,
  `note_date` datetime DEFAULT NULL,
  `author_id` int(10) DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  `pic_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rep_id` int(10) NOT NULL AUTO_INCREMENT,
  `rep_content` varchar(1000) DEFAULT NULL,
  `rep_date` datetime DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  `to_com_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`rep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `res_id` int(10) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(100) DEFAULT NULL,
  `res_profession` varchar(10) DEFAULT NULL,
  `res_school` varchar(100) DEFAULT NULL,
  `res_phone` varchar(11) DEFAULT NULL,
  `res_address` varchar(100) DEFAULT NULL,
  `res_introduce` varchar(10000) DEFAULT NULL,
  `u_id` int(10) NOT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(100) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
