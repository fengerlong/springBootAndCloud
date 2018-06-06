/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : eia

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-04 09:16:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `materials`
-- ----------------------------
DROP TABLE IF EXISTS `materials`;
CREATE TABLE `materials` (
  `id_` varchar(255) NOT NULL,
  `relevance_id_` varchar(255) DEFAULT NULL,
  `materials_address_` varchar(1000) DEFAULT NULL,
  `materials_name_` varchar(255) DEFAULT NULL,
  `materials_type_` int(11) DEFAULT NULL,
  `upload_person_id_` varchar(255) DEFAULT NULL,
  `upload_person_name_` varchar(255) NOT NULL,
  `create_time_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `edit_time_` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `version_` int(11) DEFAULT NULL,
  `is_del_` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `person_information`
-- ----------------------------
DROP TABLE IF EXISTS `person_information`;
CREATE TABLE `person_information` (
  `id_` varchar(255) NOT NULL,
  `project_id_` varchar(255) DEFAULT NULL,
  `project_name_` varchar(255) NOT NULL,
  `organization_id_` varchar(255) DEFAULT NULL,
  `organization_name_` varchar(255) NOT NULL,
  `person_id_` varchar(255) DEFAULT NULL,
  `person_name_` varchar(255) NOT NULL,
  `role_id_` varchar(255) DEFAULT NULL,
  `role_name_` varchar(255) NOT NULL,
  `title_id_` varchar(255) DEFAULT NULL,
  `title_name_` varchar(255) NOT NULL,
  `create_time_` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `edit_time_` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `version_` int(11) DEFAULT NULL,
  `is_del_` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `process_information`
-- ----------------------------
DROP TABLE IF EXISTS `process_information`;
CREATE TABLE `process_information` (
  `id_` varchar(255) NOT NULL,
  `project_id_` varchar(255) DEFAULT NULL,
  `project_name_` varchar(255) NOT NULL,
  `message_theme_` varchar(255) DEFAULT NULL,
  `type_id_` varchar(255) DEFAULT NULL,
  `type_name` varchar(255) NOT NULL,
  `state_id` varchar(255) DEFAULT NULL,
  `state_name` varchar(255) NOT NULL,
  `content_` varchar(5000) DEFAULT NULL,
  `submitter_id_` varchar(255) DEFAULT NULL,
  `submitter_name_` varchar(255) NOT NULL,
  `create_time_` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `edit_time_` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `version_` int(11) NOT NULL,
  `is_del_` int(11) NOT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
