/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost
 Source Database       : yfyk

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : utf-8

 Date: 06/10/2016 15:52:48 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_house_info_crawl`
-- ----------------------------
CREATE TABLE `t_house_info_ef` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `oid` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mobile` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `community` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `areaSize` float(11,2) DEFAULT NULL,
  `ban` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `floor` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `infoPrice` float(11,0) DEFAULT NULL,
  `readTime` int(11) DEFAULT NULL COMMENT '查看次数',
  `roomNumber` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `salePrice` float(11,2) DEFAULT NULL,
  `saleWay` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  `houseShape` varchar(16) COLLATE utf8_unicode_ci DEFAULT '',
  `priority` int(5) DEFAULT NULL,
  `checkDate` datetime DEFAULT NULL,
  `checkContent` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `operate_id` int(11) DEFAULT NULL,
  `isChannel` int(11) DEFAULT NULL,
  `memberName` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `areaName` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK33FB0F189D7D28C2` (`area_id`),
  KEY `FK33FB0F189CA1E7A2` (`member_id`),
  KEY `FK33FB0F18B2200574` (`member_id`),
  KEY `FK33FB0F184F27C0E5` (`area_id`),
  KEY `index_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
