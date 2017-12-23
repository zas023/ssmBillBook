/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : billbook

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-10 18:22:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bb_bill
-- ----------------------------
DROP TABLE IF EXISTS `bb_bill`;
CREATE TABLE `bb_bill` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cost` float(10,2) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `userId` int(8) NOT NULL,
  `typeId` int(8) NOT NULL,
  `crDate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `income` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_bill_type` (`typeId`),
  KEY `fk_bill_user` (`userId`),
  CONSTRAINT `fk_bill_type` FOREIGN KEY (`typeId`) REFERENCES `bb_type` (`id`),
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`userId`) REFERENCES `bb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb_bill
-- ----------------------------
INSERT INTO `bb_bill` VALUES ('1', '100.00', null, '1', '1', '2017-10-18 20:59:59', '1');
INSERT INTO `bb_bill` VALUES ('2', '100.00', null, '1', '1', '2017-10-18 22:08:31', '1');
INSERT INTO `bb_bill` VALUES ('3', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('4', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('5', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('6', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('7', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('8', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('9', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('10', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('11', '100.00', null, '1', '1', '2017-10-18 22:23:26', '0');
INSERT INTO `bb_bill` VALUES ('12', '100.00', null, '1', '1', '2017-10-18 22:23:58', '0');
INSERT INTO `bb_bill` VALUES ('13', '100.00', null, '1', '1', '2017-10-18 22:24:01', '0');
INSERT INTO `bb_bill` VALUES ('14', '100.00', null, '1', '1', '2017-10-18 22:23:55', '0');
INSERT INTO `bb_bill` VALUES ('15', '100.00', null, '1', '1', '2017-10-18 22:24:04', '0');
INSERT INTO `bb_bill` VALUES ('16', '100.00', null, '1', '1', '2017-10-18 22:24:06', '0');
INSERT INTO `bb_bill` VALUES ('17', '100.00', null, '1', '1', '2017-10-18 22:24:14', '0');
INSERT INTO `bb_bill` VALUES ('18', '100.00', null, '1', '1', '2017-10-18 22:24:16', '0');
INSERT INTO `bb_bill` VALUES ('19', '100.00', null, '1', '1', '2017-10-18 22:24:10', '0');
INSERT INTO `bb_bill` VALUES ('20', '100.00', null, '1', '1', '2017-10-18 22:24:19', '0');
INSERT INTO `bb_bill` VALUES ('21', '100.00', null, '1', '1', '2017-10-18 22:24:08', '0');
INSERT INTO `bb_bill` VALUES ('22', '100.00', null, '1', '1', '2017-10-18 22:25:33', '0');
INSERT INTO `bb_bill` VALUES ('23', '100.00', null, '1', '1', '2017-10-18 22:27:30', '1');
INSERT INTO `bb_bill` VALUES ('24', '100.00', null, '7', '1', '2017-10-18 22:25:59', '0');
INSERT INTO `bb_bill` VALUES ('25', '100.00', null, '7', '1', '2017-10-18 22:26:03', '0');
INSERT INTO `bb_bill` VALUES ('26', '100.00', null, '1', '1', '2017-10-18 22:25:44', '0');
INSERT INTO `bb_bill` VALUES ('27', '100.00', null, '1', '1', '2017-10-18 22:25:46', '0');
INSERT INTO `bb_bill` VALUES ('28', '100.00', null, '8', '1', '2017-10-18 22:26:15', '0');
INSERT INTO `bb_bill` VALUES ('29', '100.00', null, '1', '1', '2017-10-18 22:24:43', '0');
INSERT INTO `bb_bill` VALUES ('30', '100.00', null, '1', '1', '2017-10-18 22:25:29', '0');
INSERT INTO `bb_bill` VALUES ('31', '100.00', null, '1', '1', '2017-10-18 22:27:21', '1');
INSERT INTO `bb_bill` VALUES ('32', '100.00', null, '8', '1', '2017-10-18 22:27:26', '1');
INSERT INTO `bb_bill` VALUES ('33', '100.00', null, '1', '1', '2017-10-18 22:25:22', '0');
INSERT INTO `bb_bill` VALUES ('34', '100.00', null, '1', '1', '2017-10-18 22:25:19', '0');
INSERT INTO `bb_bill` VALUES ('35', '100.00', null, '1', '1', '2017-10-18 22:25:17', '0');
INSERT INTO `bb_bill` VALUES ('36', '100.00', null, '8', '1', '2017-10-18 22:26:07', '0');
INSERT INTO `bb_bill` VALUES ('37', '100.00', null, '1', '1', '2017-10-18 22:25:11', '0');
INSERT INTO `bb_bill` VALUES ('38', '100.00', null, '1', '1', '2017-10-18 22:25:08', '0');
INSERT INTO `bb_bill` VALUES ('39', '100.00', null, '1', '1', '2017-10-18 22:25:05', '0');
INSERT INTO `bb_bill` VALUES ('40', '100.00', null, '1', '1', '2017-10-18 22:25:03', '0');
INSERT INTO `bb_bill` VALUES ('41', '100.00', null, '1', '1', '2017-09-21 22:25:00', '0');
INSERT INTO `bb_bill` VALUES ('42', '100.00', null, '1', '1', '2017-10-18 22:24:53', '0');
INSERT INTO `bb_bill` VALUES ('43', '100.00', null, '1', '1', '2017-10-18 22:24:57', '0');
INSERT INTO `bb_bill` VALUES ('44', '100.00', null, '7', '1', '2017-10-18 22:26:20', '0');
INSERT INTO `bb_bill` VALUES ('45', '100.00', null, '1', '1', '2017-10-18 22:27:09', '1');
INSERT INTO `bb_bill` VALUES ('46', '100.00', null, '1', '1', '2017-10-18 22:27:19', '1');
INSERT INTO `bb_bill` VALUES ('47', '100.00', null, '1', '1', '2017-09-22 22:24:51', '0');
INSERT INTO `bb_bill` VALUES ('48', '100.00', null, '1', '1', '2017-09-22 22:24:51', '0');
INSERT INTO `bb_bill` VALUES ('49', '100.00', null, '1', '1', '2017-10-18 22:24:48', '0');
INSERT INTO `bb_bill` VALUES ('50', '100.00', null, '7', '1', '2017-09-18 22:26:24', '0');
INSERT INTO `bb_bill` VALUES ('51', '100.00', null, '7', '1', '2017-10-18 22:26:25', '0');
INSERT INTO `bb_bill` VALUES ('52', '100.00', null, '1', '1', '2017-10-18 22:27:49', '1');

-- ----------------------------
-- Table structure for bb_type
-- ----------------------------
DROP TABLE IF EXISTS `bb_type`;
CREATE TABLE `bb_type` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `typename` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb_type
-- ----------------------------
INSERT INTO `bb_type` VALUES ('1', '一般');

-- ----------------------------
-- Table structure for bb_user
-- ----------------------------
DROP TABLE IF EXISTS `bb_user`;
CREATE TABLE `bb_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) NOT NULL,
  `password` varchar(32) NOT NULL,
  `gender` char(1) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `mail` varchar(32) DEFAULT NULL,
  `state` int(1) unsigned zerofill DEFAULT '0',
  `mailcode` varchar(64) DEFAULT NULL,
  `phonecode` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb_user
-- ----------------------------
INSERT INTO `bb_user` VALUES ('1', 'admin', '3E3E6B0E5C1C68644FC5CE3CF060211D', 'M', '15922646438', '375027533@qq.com', '0', null, null);
INSERT INTO `bb_user` VALUES ('7', 'user02', 'C1898DE4A655382952DC4A93688E211D', null, null, '375027533@qq.com', '1', 'ecbd72af2fc24585926627ec71354684c11da4bacde64b9796568ecdd99e79bc', null);
INSERT INTO `bb_user` VALUES ('8', 'user01', '338CCCC24975FA0F6FF93D2AFA80AFF7', null, null, '375027533@qq.com', '0', 'b77e29beb86c4eb0a5137cd227b86f985af1cdd2106d487588f188544050e91f', null);
