/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hk-rest-ms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-22 14:40:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hk_book_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_book_info_t`;
CREATE TABLE `hk_book_info_t` (
  `BOOK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '预约ID',
  `BOOK_NAME` varchar(16) NOT NULL COMMENT '预约人',
  `BOOK_PHONE` bigint(11) NOT NULL COMMENT '预约电话',
  `BOOK_TIME` datetime NOT NULL COMMENT '预约时间',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  `TABLE_ID` bigint(20) NOT NULL COMMENT '桌子编号',
  `CREATER` varchar(16) NOT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) NOT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime NOT NULL COMMENT '修改时间',
  `STATUS` int(1) NOT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`BOOK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_book_info_t
-- ----------------------------
INSERT INTO `hk_book_info_t` VALUES ('1', '12123123', '13478824245', '2017-07-25 10:34:38', '10011', '100022', 'lidl', '2017-07-18 09:22:28', 'lidongliang', '2017-07-25 10:34:38', '0');
INSERT INTO `hk_book_info_t` VALUES ('5', 'xiaomingdingdan', '13478824245', '2017-07-24 20:25:10', '10011', '100022', 'lidl', '2017-07-24 20:25:10', 'lidongliang', '2017-07-24 20:25:10', '0');
INSERT INTO `hk_book_info_t` VALUES ('6', 'xiaomingdingdan', '13478824245', '2017-07-24 20:25:30', '10011', '100022', 'lidl', '2017-07-24 20:25:29', 'lidongliang', '2017-07-24 20:25:29', '0');
INSERT INTO `hk_book_info_t` VALUES ('7', 'xiaomingdingdan', '13478824245', '2017-07-24 20:27:45', '10011', '100022', 'lidl', '2017-07-24 20:27:44', 'lidongliang', '2017-07-24 20:27:44', '0');
INSERT INTO `hk_book_info_t` VALUES ('8', 'xiaomingdingdan', '13478824245', '2017-07-24 20:32:51', '10011', '100022', 'lidl', '2017-07-24 20:32:50', 'lidongliang', '2017-07-24 20:32:50', '0');
INSERT INTO `hk_book_info_t` VALUES ('9', 'xiaomingdingdan', '13478824245', '2017-07-24 20:57:25', '10011', '100022', 'lidl', '2017-07-24 20:57:24', 'lidongliang', '2017-07-24 20:57:24', '0');
INSERT INTO `hk_book_info_t` VALUES ('10', 'xiaomingdingdan', '13478824245', '2017-07-25 10:34:39', '10011', '100022', 'lidl', '2017-07-25 10:34:38', 'lidongliang', '2017-07-25 10:34:38', '0');

-- ----------------------------
-- Table structure for `hk_menu_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_menu_info_t`;
CREATE TABLE `hk_menu_info_t` (
  `DISHES_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜肴编号',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  `DISHES_NAME` varchar(50) NOT NULL COMMENT '菜肴名称',
  `DISHES_PRICE` float(5,2) NOT NULL COMMENT '菜肴价钱',
  `DISHES_DISCOUNT_PRICE` varchar(4) DEFAULT NULL COMMENT '菜肴折扣',
  `DISHES_DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '菜肴介绍',
  `DISHES_CATEGORY` int(3) DEFAULT NULL COMMENT '菜系分类(00：热菜、01：冷饮、02：特色、03：其他)',
  `DISHES_IMG` bigint(200) DEFAULT NULL COMMENT '菜肴图片',
  `DISHES_WATER_STATUS` int(3) DEFAULT NULL COMMENT '饮品（00：不加冰，01：加冰，02：加糖，03：不加糖，等等）',
  `IS_VEGETARIAN` int(3) DEFAULT NULL COMMENT '素食（00：否，01：是）',
  `STOCK` int(5) DEFAULT NULL COMMENT '库存',
  `OVERPLUS_STOCK` int(5) DEFAULT NULL COMMENT '剩余库存',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`DISHES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_menu_info_t
-- ----------------------------
INSERT INTO `hk_menu_info_t` VALUES ('2', '2', '10002', '水煮肉1', '111.00', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-18 11:17:26', 'lidongliang', '2017-08-15 11:49:37', '0');
INSERT INTO `hk_menu_info_t` VALUES ('5', '10001', '10002', '水煮肉1111', '22.00', '0.8', '鱼水肉', '2', '333', '1', '1', '1', '1', 'lidl', '2017-07-19 21:04:09', 'lidongliang', '2017-08-15 11:52:35', '0');
INSERT INTO `hk_menu_info_t` VALUES ('6', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:25:10', 'lidongliang', '2017-07-24 20:25:10', '0');
INSERT INTO `hk_menu_info_t` VALUES ('7', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '2', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:25:30', 'lidongliang', '2017-07-24 20:25:30', '0');
INSERT INTO `hk_menu_info_t` VALUES ('8', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:27:45', 'lidongliang', '2017-07-24 20:27:45', '0');
INSERT INTO `hk_menu_info_t` VALUES ('9', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:32:51', 'lidongliang', '2017-07-24 20:32:51', '0');
INSERT INTO `hk_menu_info_t` VALUES ('10', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:57:25', 'lidongliang', '2017-07-24 20:57:25', '0');
INSERT INTO `hk_menu_info_t` VALUES ('11', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-25 10:34:39', 'lidongliang', '2017-07-25 10:34:39', '0');

-- ----------------------------
-- Table structure for `hk_order_dish_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_order_dish_info_t`;
CREATE TABLE `hk_order_dish_info_t` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ORDER_ID` bigint(20) NOT NULL COMMENT '订单ID',
  `DISHES_ID` bigint(20) NOT NULL COMMENT '菜肴ID',
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单ID',
  `DISHES_NAME` varchar(32) NOT NULL COMMENT '菜肴名',
  `DISHES_PRICE` float(5,2) NOT NULL COMMENT '菜肴价钱',
  `DISHES_DISCOUNT_PRICE` varchar(3) DEFAULT NULL COMMENT '菜肴折扣',
  `AMOUNT` int(2) NOT NULL COMMENT '数量',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_order_dish_info_t
-- ----------------------------
INSERT INTO `hk_order_dish_info_t` VALUES ('22', '12', '1234', '11', '大虾', '10.00', '10%', '2', '李栋梁', '2017-07-18 11:04:33', '2017-07-25 10:34:40', null, '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('23', '12', '1013', '1001', '水煮鱼1', '98.00', '18%', '1', '李栋梁', '2017-07-18 11:04:33', '2017-07-18 11:04:33', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('24', '12', '1014', '1001', '大鲍鱼', '98.00', '18%', '1', '李栋梁', '2017-07-18 11:04:33', '2017-07-18 11:04:33', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('25', '13', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:25:10', '2017-07-24 20:25:10', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('26', '13', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:25:10', '2017-07-24 20:25:10', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('27', '13', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:25:10', '2017-07-24 20:25:10', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('28', '14', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:25:30', '2017-07-24 20:25:30', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('29', '14', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:25:30', '2017-07-24 20:25:30', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('30', '14', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:25:30', '2017-07-24 20:25:30', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('31', '15', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:27:45', '2017-07-24 20:27:45', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('32', '15', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:27:45', '2017-07-24 20:27:45', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('33', '15', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:27:45', '2017-07-24 20:27:45', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('34', '16', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:32:51', '2017-07-24 20:32:51', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('35', '16', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:32:51', '2017-07-24 20:32:51', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('36', '16', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:32:51', '2017-07-24 20:32:51', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('37', '17', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:57:25', '2017-07-24 20:57:25', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('38', '17', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:57:25', '2017-07-24 20:57:25', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('39', '17', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:57:25', '2017-07-24 20:57:25', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('40', '18', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-25 10:34:40', '2017-07-25 10:34:40', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('41', '18', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-25 10:34:40', '2017-07-25 10:34:40', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('42', '18', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-25 10:34:40', '2017-07-25 10:34:40', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('43', '19', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-25 11:25:05', '2017-07-25 11:25:05', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('44', '19', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-25 11:25:05', '2017-07-25 11:25:05', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('45', '19', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-25 11:25:05', '2017-07-25 11:25:05', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('46', '20', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-25 11:44:26', '2017-07-25 11:44:26', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('47', '20', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-25 11:44:26', '2017-07-25 11:44:26', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('48', '20', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-25 11:44:26', '2017-07-25 11:44:26', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('49', '21', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-25 11:46:02', '2017-07-25 11:46:02', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('50', '21', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-25 11:46:02', '2017-07-25 11:46:02', '李栋梁', '0');
INSERT INTO `hk_order_dish_info_t` VALUES ('51', '21', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-25 11:46:02', '2017-07-25 11:46:02', '李栋梁', '0');

-- ----------------------------
-- Table structure for `hk_order_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_order_info_t`;
CREATE TABLE `hk_order_info_t` (
  `ORDER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  `TABLE_ID` bigint(20) NOT NULL COMMENT '桌位编号',
  `ORDER_STATUS` int(2) NOT NULL COMMENT '订单状态',
  `START_DATE_TIME` datetime NOT NULL COMMENT '下单时间',
  `ORDER_AMOUNT` float(5,2) NOT NULL COMMENT '订单金额',
  `ORDER_CREATER` varchar(16) NOT NULL COMMENT '订单创建人',
  `MEMBER` int(3) DEFAULT NULL COMMENT '用餐人数',
  `COMMENT` varchar(200) DEFAULT NULL COMMENT '备注',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_order_info_t
-- ----------------------------
INSERT INTO `hk_order_info_t` VALUES ('12', '9', '9', '9', '2017-07-18 11:04:33', '9.00', '李栋梁', '9', 'XXXX', '李栋梁', '2017-07-18 11:04:33', '天天向上', '2017-07-18 11:12:50', '0');
INSERT INTO `hk_order_info_t` VALUES ('13', '9', '9', '9', '2017-07-24 20:25:10', '9.00', '李栋梁', '9', 'XXXX', '李栋梁', '2017-07-24 20:25:10', '天天向上', '2017-07-25 10:34:40', '0');
INSERT INTO `hk_order_info_t` VALUES ('14', '5002', '99', '1', '2017-07-24 20:25:30', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-24 20:25:30', '李栋梁', '2017-07-24 20:25:30', '0');
INSERT INTO `hk_order_info_t` VALUES ('15', '5002', '99', '1', '2017-07-24 20:27:45', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-24 20:27:45', '李栋梁', '2017-07-24 20:27:45', '0');
INSERT INTO `hk_order_info_t` VALUES ('16', '5002', '99', '1', '2017-07-24 20:32:51', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-24 20:32:51', '李栋梁', '2017-07-24 20:32:51', '0');
INSERT INTO `hk_order_info_t` VALUES ('17', '5002', '99', '1', '2017-07-24 20:57:25', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-24 20:57:25', '李栋梁', '2017-07-24 20:57:25', '0');
INSERT INTO `hk_order_info_t` VALUES ('18', '5002', '99', '1', '2017-07-25 10:34:40', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-25 10:34:40', '李栋梁', '2017-07-25 10:34:40', '0');
INSERT INTO `hk_order_info_t` VALUES ('19', '5002', '99', '1', '2017-07-25 11:25:04', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-25 11:25:04', '李栋梁', '2017-07-25 11:25:04', '0');
INSERT INTO `hk_order_info_t` VALUES ('20', '5002', '99', '1', '2017-07-25 11:44:26', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-25 11:44:26', '李栋梁', '2017-07-25 11:44:26', '0');
INSERT INTO `hk_order_info_t` VALUES ('21', '5002', '99', '1', '2017-07-25 11:46:02', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-25 11:46:02', '李栋梁', '2017-07-25 11:46:02', '0');

-- ----------------------------
-- Table structure for `hk_store_img_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_store_img_t`;
CREATE TABLE `hk_store_img_t` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `STORE_ID` bigint(20) DEFAULT NULL COMMENT '餐厅编号',
  `IMG_URL` varchar(500) DEFAULT NULL COMMENT '餐厅相片',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_store_img_t
-- ----------------------------
INSERT INTO `hk_store_img_t` VALUES ('27', '39', 'api/store/storeImgDown/1502782282170/img.jpg');

-- ----------------------------
-- Table structure for `hk_store_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_store_info_t`;
CREATE TABLE `hk_store_info_t` (
  `STORE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '餐厅编号',
  `STORE_NAME` varchar(32) NOT NULL COMMENT '餐厅名称',
  `STORE_PHONE` bigint(11) DEFAULT NULL COMMENT '订餐电话',
  `STORE_ADDRESS` varchar(100) DEFAULT NULL COMMENT '餐厅地址',
  `STORE_ADMIN` varchar(16) DEFAULT NULL COMMENT '餐厅负责人',
  `STORE_DESCRIPTION` varchar(200) DEFAULT NULL COMMENT '餐厅描述',
  `STORE_STATUS` int(3) DEFAULT NULL COMMENT '餐厅状态（00：营业，01:未营业）',
  `STORE_LOGO` varchar(100) DEFAULT NULL COMMENT '餐厅LOGO（路径）',
  `STORE_NOTICE` varchar(100) DEFAULT NULL COMMENT '餐厅公告',
  `STORE_TYPE` int(20) DEFAULT NULL COMMENT '餐厅类型（00：日料，01:韩国，等）',
  `SEAT_COST` float(5,2) DEFAULT NULL COMMENT '茶位费',
  `SERVICE_COST` varchar(3) DEFAULT NULL COMMENT '服务费',
  `STORE_BUSINESS_AM_START_HOURS` varchar(10) DEFAULT NULL COMMENT '餐厅营业上午营业开始时间',
  `STORE_BUSINESS_AM_END_HOURS` varchar(10) DEFAULT NULL COMMENT '餐厅营业上午闭店结束时间',
  `STORE_BUSINESS_PM_START_HOURS` varchar(10) DEFAULT NULL COMMENT '餐厅营业下午营业开始时间',
  `STORE_BUSINESS_PM_END_HOURS` varchar(10) DEFAULT NULL COMMENT '餐厅营业下午闭店结束时间',
  `STORE_BUSINESS_DAY` varchar(30) DEFAULT NULL COMMENT '餐厅营业日',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`STORE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_store_info_t
-- ----------------------------
INSERT INTO `hk_store_info_t` VALUES ('39', '老板娘烤肉店', null, null, '王凡', null, '0', '1502782242697/img.jpg', '测试', '0', '10.00', '0.1', '06:30', '07:00', '12:00', '20:30', null, null, '2017-08-15 15:31:23', null, '2017-08-15 16:19:34', '0');

-- ----------------------------
-- Table structure for `hk_sys_dictionary_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_sys_dictionary_info_t`;
CREATE TABLE `hk_sys_dictionary_info_t` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `TYPE_ID` bigint(20) NOT NULL COMMENT '类型',
  `TYPE_NAME` varchar(30) DEFAULT NULL COMMENT '类型名字',
  `VALUE` varchar(30) NOT NULL COMMENT 'value',
  `NAME` varchar(50) DEFAULT NULL COMMENT 'name',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_sys_dictionary_info_t
-- ----------------------------
INSERT INTO `hk_sys_dictionary_info_t` VALUES ('12', '9001', '菜肴种类', '1', '特色菜', 'lidongliang', '2017-07-24 20:57:26', 'lidongliang', '2017-07-24 20:57:26', '0');
INSERT INTO `hk_sys_dictionary_info_t` VALUES ('13', '9001', '菜肴种类', '3', '凉菜', 'lidongliang', '2017-07-25 10:34:41', 'lidongliang', '2017-07-25 10:34:41', '0');
INSERT INTO `hk_sys_dictionary_info_t` VALUES ('14', '9001', '菜肴种类', '2', '热菜', 'lidongliang', '2017-08-22 13:47:10', 'lidongliang', '2017-08-22 13:47:16', '0');

-- ----------------------------
-- Table structure for `hk_sys_menu_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_sys_menu_info_t`;
CREATE TABLE `hk_sys_menu_info_t` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `NAME` varchar(200) DEFAULT NULL COMMENT '菜单名',
  `PATH` varchar(50) DEFAULT NULL,
  `COMPONENT` varchar(50) DEFAULT NULL,
  `REDIRECT` varchar(50) DEFAULT NULL,
  `ICON` varchar(50) DEFAULT NULL,
  `TYPE` int(2) DEFAULT NULL,
  `ROLE` varchar(30) DEFAULT NULL,
  `PARENT` bigint(20) DEFAULT NULL,
  `CREATER` varchar(16) DEFAULT NULL,
  `CREATE_DATE_TIME` datetime DEFAULT NULL,
  `MODIFY` varchar(16) DEFAULT NULL,
  `UPDATE_DATE_TIME` datetime DEFAULT NULL,
  `STATUS` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1042 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_sys_menu_info_t
-- ----------------------------
INSERT INTO `hk_sys_menu_info_t` VALUES ('1001', '系统管理', 'system', 'layout/Layout', '', 'zujian', '1', 'admin,boss', null, 'admin', '2017-07-16 16:26:48', 'admin', '2017-08-08 14:51:38', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1003', '用户管理', 'user', 'system/user', '', '', '1', 'admin,boss', '1001', 'admin', '2017-07-16 16:26:48', 'admin', '2017-08-08 14:51:56', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1004', '菜单管理', 'menu', 'system/menu', '', '', '1', 'admin', '1001', 'admin', '2017-07-16 16:26:48', '', '2017-07-19 15:03:34', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1007', '门店管理', 'store', 'layout/Layout', '', 'zonghe', '1', 'admin,boss,user', null, '', '2017-07-19 15:08:00', 'admin', '2017-08-08 14:58:42', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1009', '综合实例', 'example', 'layout/Layout', '', 'zujian', '1', 'develop', null, 'admin', '2017-07-19 15:56:15', 'admin', '2017-08-08 14:50:40', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1010', '表格样例', 'table', 'example/table/table', null, null, '1', 'develop', '1009', 'admin', '2017-07-19 15:57:28', 'admin', '2017-08-08 14:50:34', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1020', '门店管理', 'store', 'store/store', null, null, '1', 'boss,admin', '1007', 'admin', '2017-07-24 21:04:46', 'admin', '2017-08-08 17:37:10', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1021', '菜品管理', 'menuInfo', 'store/menu', null, null, '0', 'admin,boss', '1007', 'admin', '2017-07-24 21:35:46', 'admin', '2017-08-08 17:32:35', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1023', '组件', 'components', 'layout/Layout', null, 'zujian', '1', 'develop', null, 'admin', '2017-07-26 10:02:47', 'admin', '2017-08-08 14:51:16', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1024', '头像上传', 'avatarupload', 'components/avatarUpload', null, null, '1', 'develop', '1023', 'admin', '2017-07-26 10:03:49', 'admin', '2017-08-08 14:51:10', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1025', 'Dropzone', 'dropzone', 'components/dropzone', null, null, '1', 'develop', '1023', 'admin', '2017-07-26 10:05:01', 'admin', '2017-08-08 14:51:05', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1026', 'Sticky', 'sticky', 'components/sticky', null, null, '1', 'develop', '1023', 'admin', '2017-07-26 10:07:34', 'admin', '2017-08-08 14:50:59', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1027', 'CountTo', 'countTo', 'components/countTo', null, null, '1', 'develop', '1023', 'admin', '2017-07-26 10:08:14', 'admin', '2017-08-08 14:50:52', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1028', '小组件', 'mixin', 'components/mixin', null, null, '1', 'develop', '1023', 'admin', '2017-07-26 10:09:02', 'admin', '2017-08-08 14:50:46', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1030', '创建Form', 'form/create', 'example/form', null, null, '1', 'develop', '1009', 'admin', '2017-07-26 10:14:47', 'admin', '2017-08-08 14:49:03', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1031', 'Tab页签', 'tab/index', 'example/tab/index', null, null, '1', 'develop', '1009', 'admin', '2017-07-26 10:15:43', 'admin', '2017-08-08 14:48:56', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1032', '编辑门店', 'storeInfo/:storeId', 'store/storeInfo', null, null, '0', 'admin,boss', '1007', 'admin', '2017-07-28 10:33:02', 'admin', '2017-08-08 18:48:36', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1033', '门店信息', 'storeInfo', 'store/storeInfo', null, null, '1', 'user', '1007', 'admin', '2017-08-08 15:05:31', 'admin', '2017-08-08 15:05:31', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1035', '创建门店', 'storeInfo', 'store/storeInfo', null, null, '0', 'boss', '1007', 'admin', '2017-08-08 18:48:08', 'admin', '2017-08-09 11:21:06', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1036', '菜品管理', 'storeMenu/:storeId', 'store/menu', null, null, '0', 'admin,boss', '1007', 'admin', '2017-08-09 18:03:23', 'admin', '2017-08-15 10:08:16', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1037', '菜品管理', 'storemMenu', 'store/menu', null, null, '1', 'user', '1007', 'admin', '2017-08-09 18:04:04', 'admin', '2017-08-15 10:07:55', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1038', '餐桌管理', 'tableInfo/:storeId', 'store/table', null, null, '0', 'admin,boss', '1007', 'admin', '2017-08-10 15:25:02', 'admin', '2017-08-10 15:25:02', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1039', '餐桌管理', 'tableInfo', 'store/table', null, null, '1', 'user', '1007', 'admin', '2017-08-10 15:25:43', 'admin', '2017-08-14 20:01:19', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1040', '编辑菜品', 'storeMenuInfo/:storeId/:menuId', 'store/menuInfo', null, null, '0', 'admin,boss,user', '1007', 'admin', '2017-08-15 10:10:05', 'admin', '2017-08-15 10:49:24', '0');
INSERT INTO `hk_sys_menu_info_t` VALUES ('1041', '创建菜品', 'storeMenuInfo/:storeId', 'store/menuInfo', null, null, '0', 'user,boss', '1007', 'admin', '2017-08-15 10:40:20', 'admin', '2017-08-15 10:49:36', '0');

-- ----------------------------
-- Table structure for `hk_sys_user_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_sys_user_info_t`;
CREATE TABLE `hk_sys_user_info_t` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `USER_NAME` varchar(16) DEFAULT NULL COMMENT '用户名字',
  `USER_PASSWORD` varchar(16) DEFAULT NULL COMMENT '用户密码',
  `USER_ROLE` varchar(30) DEFAULT NULL COMMENT '用户角色',
  `USER_PHONE` bigint(11) DEFAULT NULL COMMENT '用户电话',
  `USER_SEX` int(1) DEFAULT NULL COMMENT '用户性别',
  `USER_ADDRESS` varchar(50) DEFAULT NULL COMMENT '用户地址',
  `USER_TYPE` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `PARENT_ID` bigint(30) DEFAULT NULL COMMENT '所属关系',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_sys_user_info_t
-- ----------------------------
INSERT INTO `hk_sys_user_info_t` VALUES ('1', 'admin', '123456', 'admin,develop', null, '1', null, '0', null, 'admin', '2017-08-08 14:41:30', 'admin', '2017-08-08 14:41:30', '0');
INSERT INTO `hk_sys_user_info_t` VALUES ('2', 'boss1', '123456', 'boss', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `hk_sys_user_info_t` VALUES ('44', 'boss', '123456', 'boss', '123456789', '1', '大连', '1', '1', 'admin', '2017-08-15 11:06:21', 'admin', '2017-08-15 11:06:21', '0');
INSERT INTO `hk_sys_user_info_t` VALUES ('49', 'user', '123456', 'user', '12345', '1', null, '2', '44', 'boss', '2017-08-15 15:31:57', 'boss', '2017-08-15 15:53:26', '0');
INSERT INTO `hk_sys_user_info_t` VALUES ('50', '1223', '123', 'boss', null, '0', null, '1', '1', 'admin', '2017-08-16 11:41:26', 'admin', '2017-08-16 11:41:26', '0');

-- ----------------------------
-- Table structure for `hk_table_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_table_info_t`;
CREATE TABLE `hk_table_info_t` (
  `TABLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '桌子编号（二维码）',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  `TABLE_STATUS` int(2) NOT NULL COMMENT '桌子状态（0：空闲，1：满，2：预约）',
  `TABLE_DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '桌子描述',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`TABLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_table_info_t
-- ----------------------------
INSERT INTO `hk_table_info_t` VALUES ('1', '2', '0', 'a123eaa', null, '2017-07-18 13:24:34', 'xiaomin1g', '2017-07-25 10:34:42', '0');
INSERT INTO `hk_table_info_t` VALUES ('13', '17', '0', null, 'boss1', '2017-08-14 18:00:59', 'boss1', '2017-08-14 18:00:59', '0');
INSERT INTO `hk_table_info_t` VALUES ('14', '17', '0', null, 'boss1', '2017-08-14 18:01:22', 'boss1', '2017-08-14 18:01:22', '0');
INSERT INTO `hk_table_info_t` VALUES ('15', '17', '0', null, 'boss1', '2017-08-14 18:12:24', 'boss1', '2017-08-14 18:12:24', '0');
INSERT INTO `hk_table_info_t` VALUES ('16', '17', '0', null, 'boss1', '2017-08-14 18:13:52', 'boss1', '2017-08-14 18:13:52', '0');
INSERT INTO `hk_table_info_t` VALUES ('17', '17', '0', null, 'boss1', '2017-08-14 18:15:27', 'boss1', '2017-08-14 18:15:27', '0');
INSERT INTO `hk_table_info_t` VALUES ('18', '17', '0', null, 'boss1', '2017-08-14 18:16:42', 'boss1', '2017-08-14 18:16:42', '0');
INSERT INTO `hk_table_info_t` VALUES ('19', '17', '0', null, 'boss1', '2017-08-14 18:16:54', 'boss1', '2017-08-14 18:16:54', '0');
INSERT INTO `hk_table_info_t` VALUES ('20', '17', '0', null, 'boss1', '2017-08-14 18:17:41', 'boss1', '2017-08-14 18:17:41', '0');
INSERT INTO `hk_table_info_t` VALUES ('21', '17', '0', null, 'boss1', '2017-08-14 18:19:18', 'boss1', '2017-08-14 18:19:18', '0');
INSERT INTO `hk_table_info_t` VALUES ('22', '17', '0', null, 'boss1', '2017-08-14 18:19:35', 'boss1', '2017-08-14 18:19:35', '0');
INSERT INTO `hk_table_info_t` VALUES ('23', '17', '0', null, 'boss1', '2017-08-14 18:23:03', 'boss', '2017-08-15 16:42:06', '0');
INSERT INTO `hk_table_info_t` VALUES ('24', '17', '0', null, 'boss1', '2017-08-15 16:41:15', 'boss', '2017-08-15 16:41:15', '0');
INSERT INTO `hk_table_info_t` VALUES ('27', '39', '0', '2123', 'boss', '2017-08-16 16:26:07', 'boss', '2017-08-16 16:26:07', '0');
INSERT INTO `hk_table_info_t` VALUES ('28', '39', '0', '3123', 'boss', '2017-08-17 09:01:44', 'boss', '2017-08-17 09:01:44', '0');
INSERT INTO `hk_table_info_t` VALUES ('29', '39', '0', '3', 'boss', '2017-08-17 09:01:47', 'boss', '2017-08-17 09:01:47', '0');

-- ----------------------------
-- Table structure for `hk_user_store_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_user_store_info_t`;
CREATE TABLE `hk_user_store_info_t` (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户编号',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  PRIMARY KEY (`USER_ID`,`STORE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_user_store_info_t
-- ----------------------------
INSERT INTO `hk_user_store_info_t` VALUES ('44', '39');
INSERT INTO `hk_user_store_info_t` VALUES ('49', '39');

-- ----------------------------
-- Table structure for `hk_user_sys_menu_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_user_sys_menu_info_t`;
CREATE TABLE `hk_user_sys_menu_info_t` (
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '系统菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hk_user_sys_menu_info_t
-- ----------------------------
