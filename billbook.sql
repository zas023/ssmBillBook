/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : billbook

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-03-20 15:25:50
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
  `payId` int(8) DEFAULT NULL,
  `sortId` int(8) NOT NULL,
  `crDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `income` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_bill_user` (`userId`),
  KEY `fk_bill_sort` (`sortId`) USING BTREE,
  KEY `fk_bill_pay` (`payId`),
  CONSTRAINT `fk_bill_pay` FOREIGN KEY (`payId`) REFERENCES `bb_pay` (`id`),
  CONSTRAINT `fk_bill_sort` FOREIGN KEY (`sortId`) REFERENCES `bb_sort` (`id`),
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`userId`) REFERENCES `bb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb_bill
-- ----------------------------
INSERT INTO `bb_bill` VALUES ('2', '100.00', null, '1', '1', '39', '2017-12-06 20:58:27', '1');
INSERT INTO `bb_bill` VALUES ('4', '100.00', null, '1', '1', '1', '2017-12-05 13:13:23', '0');
INSERT INTO `bb_bill` VALUES ('5', '100.00', null, '1', '1', '2', '2017-12-06 20:48:08', '0');
INSERT INTO `bb_bill` VALUES ('57', '50.00', 'null', '1', '1', '1', '2017-12-05 13:13:26', '0');
INSERT INTO `bb_bill` VALUES ('58', '250.00', 'null', '1', '1', '3', '2017-12-06 20:48:12', '0');
INSERT INTO `bb_bill` VALUES ('59', '200.00', 'null', '1', '1', '1', '2017-12-05 13:13:27', '0');
INSERT INTO `bb_bill` VALUES ('71', '100.00', 'test', '1', '1', '41', '2017-12-06 20:58:38', '1');
INSERT INTO `bb_bill` VALUES ('72', '100.00', 'test', '1', '1', '1', '2017-12-05 13:13:29', '0');
INSERT INTO `bb_bill` VALUES ('73', '100.00', 'test', '1', '1', '1', '2017-12-05 13:13:32', '0');
INSERT INTO `bb_bill` VALUES ('74', '100.00', 'test', '1', '5', '41', '2017-12-06 20:58:41', '1');
INSERT INTO `bb_bill` VALUES ('75', '100.00', 'test', '1', '5', '40', '2017-12-06 20:58:45', '1');

-- ----------------------------
-- Table structure for bb_pay
-- ----------------------------
DROP TABLE IF EXISTS `bb_pay`;
CREATE TABLE `bb_pay` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) DEFAULT NULL,
  `pay_name` varchar(32) DEFAULT NULL,
  `pay_img` varchar(255) DEFAULT NULL,
  `pay_num` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb_pay
-- ----------------------------
INSERT INTO `bb_pay` VALUES ('1', '0', '现金', 'cash@2x.png', null);
INSERT INTO `bb_pay` VALUES ('2', '0', '支付宝', 'account@2x.png', null);
INSERT INTO `bb_pay` VALUES ('3', '0', '微信', 'account@2x.png', null);
INSERT INTO `bb_pay` VALUES ('4', '1', '银行卡', 'bank@2x.png', '尾号5467');
INSERT INTO `bb_pay` VALUES ('5', '1', '银行卡', 'bank@2x.png', '尾号4563');

-- ----------------------------
-- Table structure for bb_sort
-- ----------------------------
DROP TABLE IF EXISTS `bb_sort`;
CREATE TABLE `bb_sort` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) unsigned zerofill DEFAULT NULL,
  `sort_name` varchar(255) DEFAULT NULL,
  `sort_img` varchar(255) DEFAULT NULL,
  `priority` int(3) DEFAULT NULL,
  `income` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb_sort
-- ----------------------------
INSERT INTO `bb_sort` VALUES ('1', '00000000', '偿还费用', 'changhuanfeiyong@2x.png', '0', '0');
INSERT INTO `bb_sort` VALUES ('2', '00000000', '手续费', 'shouxufei@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('3', '00000000', '商城消费', 'shangchengxiaofei@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('4', '00000000', '违约金', 'weiyuejin@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('5', '00000000', '住房', 'zhufang@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('6', '00000000', '办公', 'bangong@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('7', '00000000', '餐饮', 'canyin@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('8', '00000000', '医疗', 'yiliao@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('9', '00000010', '通讯', 'tongxun@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('10', '00000000', '运动', 'yundong@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('11', '00000000', '娱乐', 'yule@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('12', '00000000', '居家', 'jujia@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('13', '00000000', '宠物', 'chongwu@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('14', '00000000', '数码', 'shuma@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('15', '00000000', '捐赠', 'juanzeng@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('16', '00000000', '零食', 'lingshi@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('17', '00000000', '孩子', 'haizi@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('18', '00000000', '长辈', 'zhangbei@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('19', '00000000', '礼物', 'liwu@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('20', '00000000', '学习', 'xuexi@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('21', '00000000', '水果', 'shuiguo@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('22', '00000000', '美容', 'meirong@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('23', '00000000', '维修', 'weixiu@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('24', '00000000', '旅行', 'lvxing@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('25', '00000000', '交通', 'jiaotong@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('26', '00000000', '饮料', 'jiushuiyinliao@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('27', '00000000', '礼金', 'lijin@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('28', '00000001', '吃啊', 'tianjiade@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('29', '00000001', 'xxx', 'tianjiade@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('30', '00000001', '爱情', 'tianjiade@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('31', '00000001', '新年快乐', 'tianjiade@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('32', '00000001', '阿卡丽', 'tianjiade@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('33', '00000000', '添加', 'tianjia@2x.png', null, '0');
INSERT INTO `bb_sort` VALUES ('34', '00000000', '礼金', 'lijin@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('35', '00000000', '加息', 'jiaxi@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('36', '00000000', '佣金奖励', 'yongjinjiangli@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('37', '00000000', '额外收益', 'ewaishouyi@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('38', '00000000', '资金补偿', 'zijinbuchang@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('39', '00000000', '利息', 'lixi@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('40', '00000000', '返现', 'fanxian@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('41', '00000000', '兼职', 'jianzhi@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('42', '00000001', '其他', 'tianjiade@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('43', '00000001', '添加3', 'tianjiade@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('44', '00000001', '吃饭', 'tianjiade@2x.png', null, '1');
INSERT INTO `bb_sort` VALUES ('45', '00000000', '添加', 'tianjia@2x.png', null, '1');

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
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bb_user
-- ----------------------------
INSERT INTO `bb_user` VALUES ('1', 'admin', '3E3E6B0E5C1C68644FC5CE3CF060211D', 'M', '15922646438', '375027533@qq.com', '0', null, null, null);
INSERT INTO `bb_user` VALUES ('7', 'user02', 'C1898DE4A655382952DC4A93688E211D', null, null, '375027533@qq.com', '1', 'ecbd72af2fc24585926627ec71354684c11da4bacde64b9796568ecdd99e79bc', null, null);
INSERT INTO `bb_user` VALUES ('8', 'user01', '338CCCC24975FA0F6FF93D2AFA80AFF7', null, null, '375027533@qq.com', '0', 'b77e29beb86c4eb0a5137cd227b86f985af1cdd2106d487588f188544050e91f', null, null);
INSERT INTO `bb_user` VALUES ('9', 'admin1', '3E3E6B0E5C1C68644FC5CE3CF060211D', null, null, '375027533@qq.com', '1', '7153b931e95240338c3000cf7a3ce1035ba80eced47f47bfbdc1f61c0df40db5', null, null);
INSERT INTO `bb_user` VALUES ('10', 'admin2', '3E3E6B0E5C1C68644FC5CE3CF060211D', null, null, '375027533@qq.com', '0', '639ebd7bf2164c67b4e6168ff3f7f3828a56ca0691194a02b7a5cff61e871ab3', null, null);
INSERT INTO `bb_user` VALUES ('11', 'admin3', '3E3E6B0E5C1C68644FC5CE3CF060211D', null, null, '375027533@qq.com', '0', '6d77b7c476be479b890027af2d45a09f1ab6bee475f1419ca9c08e9fb8477fec', null, null);
