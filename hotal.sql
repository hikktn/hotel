/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : hotal

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-11-04 17:58:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `number` int(20) DEFAULT NULL,
  `width` double(10,2) DEFAULT NULL,
  `bed` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES ('1', '1', '1.20', '单人床');
INSERT INTO `bed` VALUES ('2', '2', '1.20', '双人床');
INSERT INTO `bed` VALUES ('3', '1', '1.50', '双人床');
INSERT INTO `bed` VALUES ('4', '1', '1.80', '双人床');
INSERT INTO `bed` VALUES ('5', '1', '1.80', '单人床');
INSERT INTO `bed` VALUES ('6', '2', '1.20', '单人床');
INSERT INTO `bed` VALUES ('7', '2', '1.20', '标间房');
INSERT INTO `bed` VALUES ('8', '3', '1.90', '单人床');

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', '50022319887255754', '王总');
INSERT INTO `customers` VALUES ('2', '50023215455689', '张总');
INSERT INTO `customers` VALUES ('4', null, '张三');
INSERT INTO `customers` VALUES ('5', null, '李四');
INSERT INTO `customers` VALUES ('6', null, '凯南');
INSERT INTO `customers` VALUES ('7', null, '奎荣');
INSERT INTO `customers` VALUES ('8', null, '欧迪尔');
INSERT INTO `customers` VALUES ('9', null, '卡萨丁');
INSERT INTO `customers` VALUES ('10', null, '萨哈');
INSERT INTO `customers` VALUES ('11', null, '碧兰');
INSERT INTO `customers` VALUES ('12', null, '俞沛玲');
INSERT INTO `customers` VALUES ('13', null, '俞剑雄');
INSERT INTO `customers` VALUES ('14', null, '俞玲');
INSERT INTO `customers` VALUES ('15', null, '贺兰');
INSERT INTO `customers` VALUES ('16', null, '张兰');
INSERT INTO `customers` VALUES ('17', null, '张帅');
INSERT INTO `customers` VALUES ('18', null, '李小璐');
INSERT INTO `customers` VALUES ('19', null, '李小璐');
INSERT INTO `customers` VALUES ('20', null, '李小璐');
INSERT INTO `customers` VALUES ('21', null, '离骚');
INSERT INTO `customers` VALUES ('22', null, '周润发');
INSERT INTO `customers` VALUES ('23', null, '张三丰');
INSERT INTO `customers` VALUES ('24', null, '张二蛋');
INSERT INTO `customers` VALUES ('25', null, '王敏');
INSERT INTO `customers` VALUES ('26', null, '网民');
INSERT INTO `customers` VALUES ('27', null, '张三丰');
INSERT INTO `customers` VALUES ('28', null, '张飞');
INSERT INTO `customers` VALUES ('29', null, '李松');
INSERT INTO `customers` VALUES ('30', null, '李松');
INSERT INTO `customers` VALUES ('31', null, '李松');
INSERT INTO `customers` VALUES ('32', null, '何星');
INSERT INTO `customers` VALUES ('33', null, '何欣');
INSERT INTO `customers` VALUES ('34', null, '核心');
INSERT INTO `customers` VALUES ('35', null, '好的');
INSERT INTO `customers` VALUES ('36', null, '李松');
INSERT INTO `customers` VALUES ('37', null, '李松');
INSERT INTO `customers` VALUES ('38', null, '李松');

-- ----------------------------
-- Table structure for dates
-- ----------------------------
DROP TABLE IF EXISTS `dates`;
CREATE TABLE `dates` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `orderid` int(20) NOT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dates
-- ----------------------------
INSERT INTO `dates` VALUES ('1', '1', '2018-10-21');
INSERT INTO `dates` VALUES ('2', '1', '2018-10-22');
INSERT INTO `dates` VALUES ('3', '1', '2018-10-23');
INSERT INTO `dates` VALUES ('4', '2', '2018-10-23');
INSERT INTO `dates` VALUES ('5', '2', '2018-10-24');
INSERT INTO `dates` VALUES ('6', '2', '2018-10-25');
INSERT INTO `dates` VALUES ('7', '2', '2018-10-26');
INSERT INTO `dates` VALUES ('8', '2', '2018-10-27');
INSERT INTO `dates` VALUES ('13', '4', '2018-10-24');
INSERT INTO `dates` VALUES ('14', '4', '2018-10-25');
INSERT INTO `dates` VALUES ('11', '3', '2018-10-24');
INSERT INTO `dates` VALUES ('12', '3', '2018-10-25');
INSERT INTO `dates` VALUES ('15', '5', '2018-10-25');
INSERT INTO `dates` VALUES ('16', '5', '2018-10-26');
INSERT INTO `dates` VALUES ('17', '6', '2018-10-25');
INSERT INTO `dates` VALUES ('18', '6', '2018-10-26');
INSERT INTO `dates` VALUES ('19', '7', '2018-10-25');
INSERT INTO `dates` VALUES ('20', '7', '2018-10-26');
INSERT INTO `dates` VALUES ('21', '8', '2018-10-25');
INSERT INTO `dates` VALUES ('22', '8', '2018-10-26');
INSERT INTO `dates` VALUES ('23', '9', '2018-10-25');
INSERT INTO `dates` VALUES ('24', '9', '2018-10-26');
INSERT INTO `dates` VALUES ('25', '10', '2018-10-25');
INSERT INTO `dates` VALUES ('26', '10', '2018-10-26');
INSERT INTO `dates` VALUES ('27', '11', '2018-10-25');
INSERT INTO `dates` VALUES ('28', '11', '2018-10-26');
INSERT INTO `dates` VALUES ('29', '12', '2018-10-25');
INSERT INTO `dates` VALUES ('30', '12', '2018-10-26');
INSERT INTO `dates` VALUES ('31', '13', '2018-10-25');
INSERT INTO `dates` VALUES ('32', '13', '2018-10-26');
INSERT INTO `dates` VALUES ('33', '14', '2018-10-26');
INSERT INTO `dates` VALUES ('34', '14', '2018-10-27');
INSERT INTO `dates` VALUES ('35', '15', '2018-10-26');
INSERT INTO `dates` VALUES ('36', '15', '2018-10-27');
INSERT INTO `dates` VALUES ('37', '16', '2018-10-26');
INSERT INTO `dates` VALUES ('38', '16', '2018-10-27');
INSERT INTO `dates` VALUES ('39', '17', '2018-10-26');
INSERT INTO `dates` VALUES ('40', '17', '2018-10-27');
INSERT INTO `dates` VALUES ('41', '18', '2018-10-26');
INSERT INTO `dates` VALUES ('42', '18', '2018-10-27');
INSERT INTO `dates` VALUES ('43', '19', '2018-10-26');
INSERT INTO `dates` VALUES ('44', '19', '2018-10-27');
INSERT INTO `dates` VALUES ('45', '20', '2018-10-26');
INSERT INTO `dates` VALUES ('46', '20', '2018-10-27');
INSERT INTO `dates` VALUES ('47', '21', '2018-10-26');
INSERT INTO `dates` VALUES ('48', '21', '2018-10-27');
INSERT INTO `dates` VALUES ('49', '22', '2018-10-26');
INSERT INTO `dates` VALUES ('50', '22', '2018-10-27');
INSERT INTO `dates` VALUES ('51', '23', '2018-10-26');
INSERT INTO `dates` VALUES ('52', '23', '2018-10-27');
INSERT INTO `dates` VALUES ('53', '24', '2018-10-27');
INSERT INTO `dates` VALUES ('54', '24', '2018-10-28');
INSERT INTO `dates` VALUES ('55', '25', '2018-10-27');
INSERT INTO `dates` VALUES ('56', '25', '2018-10-28');
INSERT INTO `dates` VALUES ('57', '26', '2018-10-27');
INSERT INTO `dates` VALUES ('58', '26', '2018-10-28');
INSERT INTO `dates` VALUES ('59', '27', '2018-10-27');
INSERT INTO `dates` VALUES ('60', '27', '2018-10-28');
INSERT INTO `dates` VALUES ('61', '28', '2018-11-15');
INSERT INTO `dates` VALUES ('62', '28', '2018-11-16');
INSERT INTO `dates` VALUES ('63', '28', '2018-11-18');
INSERT INTO `dates` VALUES ('64', '28', '2018-11-01');
INSERT INTO `dates` VALUES ('65', '28', '2018-11-02');
INSERT INTO `dates` VALUES ('66', '29', '2018-11-01');
INSERT INTO `dates` VALUES ('67', '29', '2018-11-02');
INSERT INTO `dates` VALUES ('68', '29', '2018-11-04');
INSERT INTO `dates` VALUES ('69', '29', '2018-11-07');
INSERT INTO `dates` VALUES ('70', '29', '2018-11-11');
INSERT INTO `dates` VALUES ('71', '29', '2018-11-16');
INSERT INTO `dates` VALUES ('72', '29', '2018-11-22');
INSERT INTO `dates` VALUES ('73', '29', '2018-11-29');
INSERT INTO `dates` VALUES ('74', '30', '2018-11-01');
INSERT INTO `dates` VALUES ('75', '30', '2018-11-02');
INSERT INTO `dates` VALUES ('76', '31', '2018-11-01');
INSERT INTO `dates` VALUES ('77', '31', '2018-11-02');
INSERT INTO `dates` VALUES ('78', '32', '2018-11-02');
INSERT INTO `dates` VALUES ('79', '32', '2018-11-03');
INSERT INTO `dates` VALUES ('80', '33', '2018-11-02');
INSERT INTO `dates` VALUES ('81', '33', '2018-11-03');
INSERT INTO `dates` VALUES ('82', '34', '2018-11-02');
INSERT INTO `dates` VALUES ('83', '34', '2018-11-03');
INSERT INTO `dates` VALUES ('84', '35', '2018-11-02');
INSERT INTO `dates` VALUES ('85', '35', '2018-11-03');
INSERT INTO `dates` VALUES ('86', '36', '2018-11-02');
INSERT INTO `dates` VALUES ('87', '36', '2018-11-03');

-- ----------------------------
-- Table structure for date_orders
-- ----------------------------
DROP TABLE IF EXISTS `date_orders`;
CREATE TABLE `date_orders` (
  `orderid` varchar(255) NOT NULL,
  `timeid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of date_orders
-- ----------------------------
INSERT INTO `date_orders` VALUES ('20181022111', '1');
INSERT INTO `date_orders` VALUES ('20181021111', '2');
INSERT INTO `date_orders` VALUES ('201810241656393', '3');
INSERT INTO `date_orders` VALUES ('20181024165955653', '4');
INSERT INTO `date_orders` VALUES ('20181025175114402', '5');
INSERT INTO `date_orders` VALUES ('20181025175339684', '6');
INSERT INTO `date_orders` VALUES ('20181025175604426', '7');
INSERT INTO `date_orders` VALUES ('20181025191601119', '8');
INSERT INTO `date_orders` VALUES ('20181025191830751', '9');
INSERT INTO `date_orders` VALUES ('20181025192057429', '10');
INSERT INTO `date_orders` VALUES ('20181025192538053', '11');
INSERT INTO `date_orders` VALUES ('20181025193212504', '12');
INSERT INTO `date_orders` VALUES ('20181025225225120', '13');
INSERT INTO `date_orders` VALUES ('20181026115035174', '14');
INSERT INTO `date_orders` VALUES ('20181026141015210', '15');
INSERT INTO `date_orders` VALUES ('20181026142435505', '16');
INSERT INTO `date_orders` VALUES ('20181026150059425', '17');
INSERT INTO `date_orders` VALUES ('20181026150101143', '18');
INSERT INTO `date_orders` VALUES ('20181026150102305', '19');
INSERT INTO `date_orders` VALUES ('20181026171305164', '20');
INSERT INTO `date_orders` VALUES ('20181026222524691', '21');
INSERT INTO `date_orders` VALUES ('20181026224132712', '22');
INSERT INTO `date_orders` VALUES ('20181026225543083', '23');
INSERT INTO `date_orders` VALUES ('20181027152739858', '24');
INSERT INTO `date_orders` VALUES ('20181027152826366', '25');
INSERT INTO `date_orders` VALUES ('20181027165048448', '26');
INSERT INTO `date_orders` VALUES ('20181027170524786', '27');
INSERT INTO `date_orders` VALUES ('20181101175200880', '28');
INSERT INTO `date_orders` VALUES ('20181101175336182', '28');
INSERT INTO `date_orders` VALUES ('20181101175749751', '28');
INSERT INTO `date_orders` VALUES ('20181101175855392', '28');
INSERT INTO `date_orders` VALUES ('20181101180333967', '28');
INSERT INTO `date_orders` VALUES ('20181101180354103', '28');
INSERT INTO `date_orders` VALUES ('20181101184119107', '29');
INSERT INTO `date_orders` VALUES ('20181101191302771', '29');
INSERT INTO `date_orders` VALUES ('20181101191525429', '29');
INSERT INTO `date_orders` VALUES ('20181101192138894', '30');
INSERT INTO `date_orders` VALUES ('20181101192825777', '31');
INSERT INTO `date_orders` VALUES ('20181102110648918', '32');
INSERT INTO `date_orders` VALUES ('20181102111259029', '33');
INSERT INTO `date_orders` VALUES ('20181102111659790', '34');
INSERT INTO `date_orders` VALUES ('20181102115642191', '35');
INSERT INTO `date_orders` VALUES ('20181102130400845', '36');

-- ----------------------------
-- Table structure for easy
-- ----------------------------
DROP TABLE IF EXISTS `easy`;
CREATE TABLE `easy` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `facilities` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easy
-- ----------------------------
INSERT INTO `easy` VALUES ('1', '220V电压插座');
INSERT INTO `easy` VALUES ('2', '空调');
INSERT INTO `easy` VALUES ('3', '手动窗帘');
INSERT INTO `easy` VALUES ('4', '床具');
INSERT INTO `easy` VALUES ('5', '书桌');
INSERT INTO `easy` VALUES ('6', '24小时热水');
INSERT INTO `easy` VALUES ('7', '吹风机');
INSERT INTO `easy` VALUES ('8', '卫星频道');
INSERT INTO `easy` VALUES ('9', '液晶电视机');
INSERT INTO `easy` VALUES ('10', '免费洗漱用品（6样以内）');

-- ----------------------------
-- Table structure for facilities
-- ----------------------------
DROP TABLE IF EXISTS `facilities`;
CREATE TABLE `facilities` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `facilitate` int(20) DEFAULT NULL,
  `media` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of facilities
-- ----------------------------
INSERT INTO `facilities` VALUES ('20', '3', '3');
INSERT INTO `facilities` VALUES ('21', '4', '4');
INSERT INTO `facilities` VALUES ('22', '5', '5');
INSERT INTO `facilities` VALUES ('23', '6', '6');
INSERT INTO `facilities` VALUES ('31', '7', '7');
INSERT INTO `facilities` VALUES ('32', '8', '8');
INSERT INTO `facilities` VALUES ('33', '9', '9');
INSERT INTO `facilities` VALUES ('34', '10', '10');
INSERT INTO `facilities` VALUES ('35', '11', '11');
INSERT INTO `facilities` VALUES ('36', '12', '12');
INSERT INTO `facilities` VALUES ('37', '13', '13');
INSERT INTO `facilities` VALUES ('18', '1', '1');
INSERT INTO `facilities` VALUES ('19', '2', '2');

-- ----------------------------
-- Table structure for hotel_locals
-- ----------------------------
DROP TABLE IF EXISTS `hotel_locals`;
CREATE TABLE `hotel_locals` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `local` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_locals
-- ----------------------------
INSERT INTO `hotel_locals` VALUES ('1', '安静');
INSERT INTO `hotel_locals` VALUES ('2', '可退订');
INSERT INTO `hotel_locals` VALUES ('3', '风景好');
INSERT INTO `hotel_locals` VALUES ('4', '采光好');
INSERT INTO `hotel_locals` VALUES ('5', '通风');
INSERT INTO `hotel_locals` VALUES ('6', '可撸猫');
INSERT INTO `hotel_locals` VALUES ('7', '好好好');
INSERT INTO `hotel_locals` VALUES ('8', '简约');

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `imagepath` varchar(255) DEFAULT NULL,
  `roomid` int(20) DEFAULT NULL,
  `publics` varchar(255) DEFAULT NULL,
  `oldimg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('2', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', '102', '是', 'wallhaven-694679.jpg');
INSERT INTO `images` VALUES ('3', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-692572.jpg', '103', '是', 'wallhaven-692572.jpg');
INSERT INTO `images` VALUES ('4', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694993.png', '104', '是', 'wallhaven-694993.png');
INSERT INTO `images` VALUES ('5', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', '105', '是', 'wallhaven-694679.jpg');
INSERT INTO `images` VALUES ('1', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', '101', '是', 'wallhaven-694679.jpg');
INSERT INTO `images` VALUES ('6', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', '106', '是', 'wallhaven-694679.jpg');
INSERT INTO `images` VALUES ('8', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images/0a4e28968406f27e8d110c433313454a.jpg', '1033', '是', '0a4e28968406f27e8d110c433313454a.jpg');
INSERT INTO `images` VALUES ('7', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', '107', '是', 'wallhaven-694679.jpg');
INSERT INTO `images` VALUES ('9', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images/t019116cc5f40220542.jpg', '4566', '是', 't019116cc5f40220542.jpg');

-- ----------------------------
-- Table structure for locals
-- ----------------------------
DROP TABLE IF EXISTS `locals`;
CREATE TABLE `locals` (
  `localid` int(20) NOT NULL AUTO_INCREMENT,
  `localcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`localid`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of locals
-- ----------------------------
INSERT INTO `locals` VALUES ('1', '单人间');
INSERT INTO `locals` VALUES ('2', '标准间');
INSERT INTO `locals` VALUES ('3', '房');
INSERT INTO `locals` VALUES ('4', '主题房');
INSERT INTO `locals` VALUES ('5', '森林');
INSERT INTO `locals` VALUES ('6', '双人房');
INSERT INTO `locals` VALUES ('7', '套房');
INSERT INTO `locals` VALUES ('8', '豪华套房');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', 'admin', '123');
INSERT INTO `login` VALUES ('2', 'user', '123');

-- ----------------------------
-- Table structure for media
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `facilities` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media
-- ----------------------------
INSERT INTO `media` VALUES ('1', '电视机');
INSERT INTO `media` VALUES ('2', 'KTV');
INSERT INTO `media` VALUES ('3', '电话');
INSERT INTO `media` VALUES ('4', '有线频道');
INSERT INTO `media` VALUES ('5', '智能冰箱');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(20) NOT NULL,
  `orderid` varchar(255) DEFAULT NULL,
  `customers` int(11) NOT NULL AUTO_INCREMENT,
  `roomid` int(20) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int(20) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `shop` datetime DEFAULT NULL,
  `nowtime` datetime DEFAULT NULL,
  PRIMARY KEY (`customers`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '20181022111', '1', '101', '15232423443', '4', '12.00', '2018-10-22 14:00:00', '2018-10-30 16:54:18');
INSERT INTO `orders` VALUES ('1', '20181021111', '2', '102', '18232455467', '4', '18888.00', '2018-10-21 10:00:00', '2018-10-30 16:54:21');
INSERT INTO `orders` VALUES ('1', '201810241656393', '4', '101', '15245485439', '4', '12.00', '2018-10-24 17:00:00', '2018-10-30 16:54:27');
INSERT INTO `orders` VALUES ('1', '20181024165955653', '5', '101', '18975845698', '4', '12.00', '2018-10-24 17:00:00', '2018-10-30 16:54:25');
INSERT INTO `orders` VALUES ('1', '20181025175114402', '6', '101', '15223245439', '4', '12.00', '2018-10-25 21:00:00', '2018-10-30 16:54:30');
INSERT INTO `orders` VALUES ('1', '20181025175339684', '7', '101', '13104278561', '4', '12.00', '2018-10-25 18:00:00', '2018-10-30 16:54:32');
INSERT INTO `orders` VALUES ('1', '20181025175604426', '8', '101', '18902156869', '4', '12.00', '2018-10-25 18:00:00', '2018-10-30 16:54:35');
INSERT INTO `orders` VALUES ('1', '20181025191601119', '9', '101', '18567892546', '4', '12.00', '2018-10-25 20:00:00', '2018-10-30 16:54:38');
INSERT INTO `orders` VALUES ('1', '20181025191830751', '10', '101', '18223245439', '4', '12.00', '2018-10-25 20:00:00', '2018-10-30 16:54:42');
INSERT INTO `orders` VALUES ('1', '20181025192057429', '11', '101', '18565465391', '4', '12.00', '2018-10-25 20:00:00', '2018-10-30 16:54:44');
INSERT INTO `orders` VALUES ('1', '20181025192538053', '12', '101', '15239394543', '4', '12.00', '2018-10-25 20:00:00', '2018-10-30 16:54:48');
INSERT INTO `orders` VALUES ('1', '20181025193212504', '13', '101', '18984554869', '4', '12.00', '2018-10-25 20:00:00', '2018-10-30 16:55:03');
INSERT INTO `orders` VALUES ('1', '20181025225225120', '14', '101', '13245439871', '4', '12.00', '2018-10-25 23:00:00', '2018-10-30 16:55:06');
INSERT INTO `orders` VALUES ('1', '20181026115035174', '15', '101', '13124589848', '4', '12.00', '2018-10-26 12:00:00', '2018-10-30 16:55:08');
INSERT INTO `orders` VALUES ('1', '20181026141015210', '16', '103', '18223245439', '4', '499.00', '2018-10-26 15:00:00', '2018-10-30 16:55:11');
INSERT INTO `orders` VALUES ('1', '20181026142435505', '17', '105', '15223245439', '4', '12.00', '2018-10-26 15:00:00', '2018-10-30 16:55:13');
INSERT INTO `orders` VALUES ('1', '20181026150059425', '18', '102', '15223245439', '3', '18888.00', '2018-10-26 16:00:00', '2018-10-30 16:55:19');
INSERT INTO `orders` VALUES ('1', '20181026150101143', '19', '102', '15223245439', '4', '12.00', '2018-10-26 16:00:00', '2018-10-30 16:55:22');
INSERT INTO `orders` VALUES ('1', '20181026150102305', '20', '102', '15223245439', '4', '12.00', '2018-10-26 16:00:00', '2018-10-30 16:55:25');
INSERT INTO `orders` VALUES ('1', '20181026171305164', '21', '105', '13112198864', '4', '12.00', '2018-10-26 18:00:00', '2018-10-30 16:55:29');
INSERT INTO `orders` VALUES ('1', '20181026222524691', '22', '104', '13145452891', '4', '150.00', '2018-10-26 23:00:00', '2018-10-30 16:55:32');
INSERT INTO `orders` VALUES ('1', '20181026224132712', '23', '104', '18986577881', '4', '150.00', '2018-10-26 23:00:00', '2018-10-30 16:55:34');
INSERT INTO `orders` VALUES ('1', '20181026225543083', '24', '104', '13152445684', '4', '150.00', '2018-10-26 23:00:00', '2018-10-30 16:55:00');
INSERT INTO `orders` VALUES ('1', '20181027152739858', '25', '104', '15523587473', '4', '150.00', '2018-10-27 16:00:00', '2018-10-30 16:54:56');
INSERT INTO `orders` VALUES ('1', '20181027152826366', '26', '104', '15523587473', '1', '12.00', '2018-10-27 16:00:00', '2018-10-30 16:54:58');
INSERT INTO `orders` VALUES ('1', '20181027165048448', '27', '105', '15234543985', '4', '12.00', '2018-10-27 17:00:00', '2018-10-30 16:54:53');
INSERT INTO `orders` VALUES ('1', '20181027170524786', '28', '105', '15245439854', '1', '12.00', '2018-10-27 18:00:00', '2018-10-30 16:54:51');
INSERT INTO `orders` VALUES ('1', '20181101180354103', '29', '4566', '15223245439', '4', '200.00', '2018-11-01 19:00:00', '2018-11-01 18:03:54');
INSERT INTO `orders` VALUES ('6', '20181101191525429', '30', '101', '15223245439', '4', '84.00', '2018-11-01 20:00:00', '2018-11-01 19:15:25');
INSERT INTO `orders` VALUES ('7', '20181101192138894', '31', '103', '17323991340', '4', '499.00', '2018-11-01 23:01:00', '2018-11-01 19:21:42');
INSERT INTO `orders` VALUES ('7', '20181101192825777', '32', '101', '17323991340', '1', '12.00', '2018-11-01 20:00:00', '2018-11-01 19:28:29');
INSERT INTO `orders` VALUES ('10', '20181102110648918', '33', '103', '17323991340', '4', '499.00', '2018-11-02 12:00:00', '2018-11-02 11:06:52');
INSERT INTO `orders` VALUES ('10', '20181102111259029', '34', '102', '13551787176', '1', '2888.00', '2018-11-02 12:00:00', '2018-11-02 11:13:02');
INSERT INTO `orders` VALUES ('11', '20181102111659790', '35', '103', '15223245439', '1', '499.00', '2018-11-02 12:00:00', '2018-11-02 11:16:59');
INSERT INTO `orders` VALUES ('13', '20181102115642191', '36', '106', '15223245439', '1', '150.00', '2018-11-02 12:00:00', '2018-11-02 11:56:42');
INSERT INTO `orders` VALUES ('11', '20181102130400845', '37', '4566', '15223245439', '1', '200.00', '2018-11-02 14:00:00', '2018-11-02 13:03:55');

-- ----------------------------
-- Table structure for order_takers
-- ----------------------------
DROP TABLE IF EXISTS `order_takers`;
CREATE TABLE `order_takers` (
  `order` int(11) NOT NULL AUTO_INCREMENT,
  `taker` int(20) DEFAULT NULL,
  PRIMARY KEY (`order`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_takers
-- ----------------------------
INSERT INTO `order_takers` VALUES ('1', '1');
INSERT INTO `order_takers` VALUES ('2', '2');
INSERT INTO `order_takers` VALUES ('4', '4');
INSERT INTO `order_takers` VALUES ('5', '5');
INSERT INTO `order_takers` VALUES ('6', '6');
INSERT INTO `order_takers` VALUES ('7', '7');
INSERT INTO `order_takers` VALUES ('8', '8');
INSERT INTO `order_takers` VALUES ('9', '9');
INSERT INTO `order_takers` VALUES ('10', '10');
INSERT INTO `order_takers` VALUES ('11', '11');
INSERT INTO `order_takers` VALUES ('12', '12');
INSERT INTO `order_takers` VALUES ('13', '13');
INSERT INTO `order_takers` VALUES ('14', '14');
INSERT INTO `order_takers` VALUES ('15', '15');
INSERT INTO `order_takers` VALUES ('16', '16');
INSERT INTO `order_takers` VALUES ('17', '17');
INSERT INTO `order_takers` VALUES ('18', '18');
INSERT INTO `order_takers` VALUES ('19', '19');
INSERT INTO `order_takers` VALUES ('20', '20');
INSERT INTO `order_takers` VALUES ('21', '21');
INSERT INTO `order_takers` VALUES ('22', '22');
INSERT INTO `order_takers` VALUES ('23', '23');
INSERT INTO `order_takers` VALUES ('24', '24');
INSERT INTO `order_takers` VALUES ('25', '25');
INSERT INTO `order_takers` VALUES ('26', '26');
INSERT INTO `order_takers` VALUES ('27', '27');
INSERT INTO `order_takers` VALUES ('28', '28');
INSERT INTO `order_takers` VALUES ('29', '29');
INSERT INTO `order_takers` VALUES ('30', '30');
INSERT INTO `order_takers` VALUES ('31', '31');
INSERT INTO `order_takers` VALUES ('32', '32');
INSERT INTO `order_takers` VALUES ('33', '33');
INSERT INTO `order_takers` VALUES ('34', '34');
INSERT INTO `order_takers` VALUES ('35', '35');
INSERT INTO `order_takers` VALUES ('36', '36');
INSERT INTO `order_takers` VALUES ('37', '37');
INSERT INTO `order_takers` VALUES ('38', '38');

-- ----------------------------
-- Table structure for preview
-- ----------------------------
DROP TABLE IF EXISTS `preview`;
CREATE TABLE `preview` (
  `imgesid` int(20) DEFAULT NULL,
  `newimg` varchar(255) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `oldimg` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of preview
-- ----------------------------
INSERT INTO `preview` VALUES ('2', '', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', 'wallhaven-694679.jpg');
INSERT INTO `preview` VALUES ('3', '', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694993.png', 'wallhaven-694993.png');
INSERT INTO `preview` VALUES ('1', '', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', 'wallhaven-694679.jpg');
INSERT INTO `preview` VALUES ('4', '', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', 'wallhaven-694679.jpg');
INSERT INTO `preview` VALUES ('4', '', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694993.png', 'wallhaven-694993.png');
INSERT INTO `preview` VALUES ('4', null, 'E:\\apache-tomcat-9.0.12-windows-x64apache-tomcat-9.0.12webappshotelSystemimages/wallhaven-37242.jpg', 'wallhaven-37242.jpg');
INSERT INTO `preview` VALUES ('5', '', 'E:\\apache-tomcat-9.0.12-windows-x64\\apache-tomcat-9.0.12\\webapps\\hotelSystem\\images/wallhaven-694679.jpg', 'wallhaven-694679.jpg');
INSERT INTO `preview` VALUES ('7', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//wallhaven-694679.jpg', 'wallhaven-694679.jpg');
INSERT INTO `preview` VALUES ('8', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//0a4e28968406f27e8d110c433313454a.jpg', '/0a4e28968406f27e8d110c433313454a.jpg');
INSERT INTO `preview` VALUES ('8', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//0a4e28968406f27e8d110c433313454a.jpg', '/0a4e28968406f27e8d110c433313454a.jpg');
INSERT INTO `preview` VALUES ('8', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//0a4e28968406f27e8d110c433313454a.jpg', '/0a4e28968406f27e8d110c433313454a.jpg');
INSERT INTO `preview` VALUES ('9', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//t019116cc5f40220542.jpg', '/t019116cc5f40220542.jpg');
INSERT INTO `preview` VALUES ('10', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//t019116cc5f40220542.jpg', '/t019116cc5f40220542.jpg');
INSERT INTO `preview` VALUES ('10', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//t019116cc5f40220542.jpg', '/t019116cc5f40220542.jpg');
INSERT INTO `preview` VALUES ('10', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//t019116cc5f40220542.jpg', '/t019116cc5f40220542.jpg');
INSERT INTO `preview` VALUES ('10', '', 'E://apache-tomcat-9.0.12-windows-x64//apache-tomcat-9.0.12//images//t019116cc5f40220542.jpg', '/t019116cc5f40220542.jpg');

-- ----------------------------
-- Table structure for roomarea
-- ----------------------------
DROP TABLE IF EXISTS `roomarea`;
CREATE TABLE `roomarea` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `area` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomarea
-- ----------------------------
INSERT INTO `roomarea` VALUES ('1', '12.00');
INSERT INTO `roomarea` VALUES ('2', '75.00');
INSERT INTO `roomarea` VALUES ('3', '20.00');
INSERT INTO `roomarea` VALUES ('4', '20.00');
INSERT INTO `roomarea` VALUES ('7', '120.00');
INSERT INTO `roomarea` VALUES ('5', '12.00');
INSERT INTO `roomarea` VALUES ('6', '20.00');
INSERT INTO `roomarea` VALUES ('8', '55.00');
INSERT INTO `roomarea` VALUES ('9', '100.00');
INSERT INTO `roomarea` VALUES ('10', '100.00');

-- ----------------------------
-- Table structure for roomlevel
-- ----------------------------
DROP TABLE IF EXISTS `roomlevel`;
CREATE TABLE `roomlevel` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomlevel
-- ----------------------------
INSERT INTO `roomlevel` VALUES ('1', '商务');
INSERT INTO `roomlevel` VALUES ('2', '豪华');
INSERT INTO `roomlevel` VALUES ('3', '行政');
INSERT INTO `roomlevel` VALUES ('4', '总统');
INSERT INTO `roomlevel` VALUES ('5', '标准');
INSERT INTO `roomlevel` VALUES ('6', '单人');
INSERT INTO `roomlevel` VALUES ('7', '双人');
INSERT INTO `roomlevel` VALUES ('8', '情侣');

-- ----------------------------
-- Table structure for rooms
-- ----------------------------
DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms` (
  `id` int(20) NOT NULL,
  `level` int(20) DEFAULT NULL,
  `window` int(20) DEFAULT NULL,
  `area` int(20) DEFAULT NULL,
  `bed` int(20) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `describe` int(20) DEFAULT NULL,
  `images` int(20) DEFAULT NULL,
  `facilities` int(20) DEFAULT NULL,
  `hotel_local` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rooms
-- ----------------------------
INSERT INTO `rooms` VALUES ('107', '1', '1', '7', '1', '1200.00', '7', '7', '31', '7');
INSERT INTO `rooms` VALUES ('1033', '1', '1', '8', '1', '555.00', '8', '8', '32', '8');
INSERT INTO `rooms` VALUES ('4566', '8', '3', '9', '5', '200.00', '9', '9', '33', '9');
INSERT INTO `rooms` VALUES ('102', '2', '4', '2', '4', '2888.00', '2', '2', '19', '2');
INSERT INTO `rooms` VALUES ('104', '1', '1', '4', '1', '150.00', '4', '4', '21', '4');
INSERT INTO `rooms` VALUES ('105', '1', '1', '5', '1', '12.00', '5', '5', '22', '5');
INSERT INTO `rooms` VALUES ('106', '1', '1', '6', '1', '150.00', '6', '6', '23', '6');
INSERT INTO `rooms` VALUES ('103', '7', '4', '3', '3', '499.00', '3', '3', '20', '3');
INSERT INTO `rooms` VALUES ('101', '2', '1', '1', '1', '12.00', '1', '1', '18', '1');

-- ----------------------------
-- Table structure for roomtitle
-- ----------------------------
DROP TABLE IF EXISTS `roomtitle`;
CREATE TABLE `roomtitle` (
  `id` int(20) NOT NULL,
  `level` int(20) DEFAULT NULL,
  `local` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomtitle
-- ----------------------------
INSERT INTO `roomtitle` VALUES ('1', '1', '2');
INSERT INTO `roomtitle` VALUES ('2', '2', '4');
INSERT INTO `roomtitle` VALUES ('3', '7', '4');
INSERT INTO `roomtitle` VALUES ('4', '1', '1');
INSERT INTO `roomtitle` VALUES ('5', '1', '1');
INSERT INTO `roomtitle` VALUES ('6', '1', '1');
INSERT INTO `roomtitle` VALUES ('7', '1', '1');
INSERT INTO `roomtitle` VALUES ('10', '8', '8');
INSERT INTO `roomtitle` VALUES ('8', '1', '1');
INSERT INTO `roomtitle` VALUES ('9', '8', '8');

-- ----------------------------
-- Table structure for room_easy
-- ----------------------------
DROP TABLE IF EXISTS `room_easy`;
CREATE TABLE `room_easy` (
  `facilitiesid` int(20) NOT NULL,
  `easyid` int(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_easy
-- ----------------------------
INSERT INTO `room_easy` VALUES ('5', '1');
INSERT INTO `room_easy` VALUES ('2', '10');
INSERT INTO `room_easy` VALUES ('2', '9');
INSERT INTO `room_easy` VALUES ('2', '4');
INSERT INTO `room_easy` VALUES ('3', '4');
INSERT INTO `room_easy` VALUES ('3', '3');
INSERT INTO `room_easy` VALUES ('9', '2');
INSERT INTO `room_easy` VALUES ('4', '10');
INSERT INTO `room_easy` VALUES ('6', '1');
INSERT INTO `room_easy` VALUES ('9', '8');
INSERT INTO `room_easy` VALUES ('9', '3');
INSERT INTO `room_easy` VALUES ('9', '1');
INSERT INTO `room_easy` VALUES ('8', '2');
INSERT INTO `room_easy` VALUES ('8', '1');
INSERT INTO `room_easy` VALUES ('1', '7');
INSERT INTO `room_easy` VALUES ('1', '2');
INSERT INTO `room_easy` VALUES ('1', '1');
INSERT INTO `room_easy` VALUES ('7', '1');
INSERT INTO `room_easy` VALUES ('10', '1');
INSERT INTO `room_easy` VALUES ('10', '2');
INSERT INTO `room_easy` VALUES ('10', '3');
INSERT INTO `room_easy` VALUES ('10', '8');
INSERT INTO `room_easy` VALUES ('11', '1');
INSERT INTO `room_easy` VALUES ('11', '2');
INSERT INTO `room_easy` VALUES ('11', '3');
INSERT INTO `room_easy` VALUES ('11', '8');
INSERT INTO `room_easy` VALUES ('12', '1');
INSERT INTO `room_easy` VALUES ('12', '2');
INSERT INTO `room_easy` VALUES ('12', '3');
INSERT INTO `room_easy` VALUES ('12', '8');
INSERT INTO `room_easy` VALUES ('13', '1');
INSERT INTO `room_easy` VALUES ('13', '2');
INSERT INTO `room_easy` VALUES ('13', '3');
INSERT INTO `room_easy` VALUES ('13', '8');
INSERT INTO `room_easy` VALUES ('1', '8');
INSERT INTO `room_easy` VALUES ('1', '9');

-- ----------------------------
-- Table structure for room_hotel_local
-- ----------------------------
DROP TABLE IF EXISTS `room_hotel_local`;
CREATE TABLE `room_hotel_local` (
  `room_local` int(20) DEFAULT NULL,
  `hotel_local` int(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_hotel_local
-- ----------------------------
INSERT INTO `room_hotel_local` VALUES ('5', '6');
INSERT INTO `room_hotel_local` VALUES ('6', '2');
INSERT INTO `room_hotel_local` VALUES ('2', '4');
INSERT INTO `room_hotel_local` VALUES ('5', '4');
INSERT INTO `room_hotel_local` VALUES ('3', '4');
INSERT INTO `room_hotel_local` VALUES ('9', '1');
INSERT INTO `room_hotel_local` VALUES ('4', '2');
INSERT INTO `room_hotel_local` VALUES ('5', '3');
INSERT INTO `room_hotel_local` VALUES ('7', '5');
INSERT INTO `room_hotel_local` VALUES ('3', '3');
INSERT INTO `room_hotel_local` VALUES ('5', '1');
INSERT INTO `room_hotel_local` VALUES ('1', '4');
INSERT INTO `room_hotel_local` VALUES ('8', '1');
INSERT INTO `room_hotel_local` VALUES ('1', '3');
INSERT INTO `room_hotel_local` VALUES ('1', '2');
INSERT INTO `room_hotel_local` VALUES ('1', '1');
INSERT INTO `room_hotel_local` VALUES ('2', '1');
INSERT INTO `room_hotel_local` VALUES ('8', '2');
INSERT INTO `room_hotel_local` VALUES ('9', '2');
INSERT INTO `room_hotel_local` VALUES ('9', '3');
INSERT INTO `room_hotel_local` VALUES ('9', '8');
INSERT INTO `room_hotel_local` VALUES ('10', '1');
INSERT INTO `room_hotel_local` VALUES ('10', '2');
INSERT INTO `room_hotel_local` VALUES ('10', '3');
INSERT INTO `room_hotel_local` VALUES ('10', '8');
INSERT INTO `room_hotel_local` VALUES ('10', '1');
INSERT INTO `room_hotel_local` VALUES ('10', '2');
INSERT INTO `room_hotel_local` VALUES ('10', '3');
INSERT INTO `room_hotel_local` VALUES ('10', '8');
INSERT INTO `room_hotel_local` VALUES ('10', '1');
INSERT INTO `room_hotel_local` VALUES ('10', '2');
INSERT INTO `room_hotel_local` VALUES ('10', '3');
INSERT INTO `room_hotel_local` VALUES ('10', '8');
INSERT INTO `room_hotel_local` VALUES ('10', '1');
INSERT INTO `room_hotel_local` VALUES ('10', '2');
INSERT INTO `room_hotel_local` VALUES ('10', '3');
INSERT INTO `room_hotel_local` VALUES ('10', '8');
INSERT INTO `room_hotel_local` VALUES ('1', '6');

-- ----------------------------
-- Table structure for room_media
-- ----------------------------
DROP TABLE IF EXISTS `room_media`;
CREATE TABLE `room_media` (
  `facilitiesid` int(20) NOT NULL,
  `mediaid` int(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_media
-- ----------------------------
INSERT INTO `room_media` VALUES ('1', '3');
INSERT INTO `room_media` VALUES ('8', '1');
INSERT INTO `room_media` VALUES ('6', '1');
INSERT INTO `room_media` VALUES ('5', '1');
INSERT INTO `room_media` VALUES ('8', '2');
INSERT INTO `room_media` VALUES ('4', '3');
INSERT INTO `room_media` VALUES ('3', '2');
INSERT INTO `room_media` VALUES ('4', '2');
INSERT INTO `room_media` VALUES ('4', '1');
INSERT INTO `room_media` VALUES ('2', '4');
INSERT INTO `room_media` VALUES ('1', '2');
INSERT INTO `room_media` VALUES ('1', '1');
INSERT INTO `room_media` VALUES ('9', '8');
INSERT INTO `room_media` VALUES ('9', '3');
INSERT INTO `room_media` VALUES ('9', '2');
INSERT INTO `room_media` VALUES ('9', '1');
INSERT INTO `room_media` VALUES ('7', '1');
INSERT INTO `room_media` VALUES ('10', '1');
INSERT INTO `room_media` VALUES ('10', '2');
INSERT INTO `room_media` VALUES ('10', '3');
INSERT INTO `room_media` VALUES ('10', '8');
INSERT INTO `room_media` VALUES ('11', '1');
INSERT INTO `room_media` VALUES ('11', '2');
INSERT INTO `room_media` VALUES ('11', '3');
INSERT INTO `room_media` VALUES ('11', '8');
INSERT INTO `room_media` VALUES ('12', '1');
INSERT INTO `room_media` VALUES ('12', '2');
INSERT INTO `room_media` VALUES ('12', '3');
INSERT INTO `room_media` VALUES ('12', '8');
INSERT INTO `room_media` VALUES ('13', '1');
INSERT INTO `room_media` VALUES ('13', '2');
INSERT INTO `room_media` VALUES ('13', '3');
INSERT INTO `room_media` VALUES ('13', '8');
INSERT INTO `room_media` VALUES ('1', '4');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `headpath` varchar(255) DEFAULT NULL,
  `reserve` double(10,2) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('11', '1213457107@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83erDQNic0xFtjcOU3Rh8siczkBSvACJicgDwibtJhPpGXUdmiagSX2LgA0ub5fRHMScNAcgqwGzGrTyhA4Q/132', '100.00', 'o-Ibz1Cjwo7mEla4mltmD5PIPQpE');
INSERT INTO `users` VALUES ('10', '1114897759@qq.com', null, '0.00', null);
INSERT INTO `users` VALUES ('12', '1332356188@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/MMpknQcdth0CGo43UZOxDdAYHn9y4nuHjzE3OKEDXNqrAwu8IYIGUypDx0UClgKcmIfAvI1hbFa11Fpj1L0Psg/132', '0.00', 'o-Ibz1OhYag5SkisBNrP7hC5bFlQ');
INSERT INTO `users` VALUES ('13', '2997887868@qq.com', '', '300.00', '');

-- ----------------------------
-- Table structure for windows
-- ----------------------------
DROP TABLE IF EXISTS `windows`;
CREATE TABLE `windows` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `window` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of windows
-- ----------------------------
INSERT INTO `windows` VALUES ('1', '有窗');
INSERT INTO `windows` VALUES ('2', '无窗');
INSERT INTO `windows` VALUES ('3', '豪华精窗');
INSERT INTO `windows` VALUES ('4', '部分有窗');
INSERT INTO `windows` VALUES ('5', '花窗');
INSERT INTO `windows` VALUES ('6', '内窗');
