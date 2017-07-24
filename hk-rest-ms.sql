/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50625
 Source Host           : localhost
 Source Database       : hk-rest-ms

 Target Server Type    : MySQL
 Target Server Version : 50625
 File Encoding         : utf-8

 Date: 07/24/2017 20:42:36 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hk_book_info_t`
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_book_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_book_info_t` VALUES ('1', '12123123', '13478824245', '2017-07-24 20:32:51', '10011', '100022', 'lidl', '2017-07-18 09:22:28', 'lidongliang', '2017-07-24 20:32:50', '0'), ('5', 'xiaomingdingdan', '13478824245', '2017-07-24 20:25:10', '10011', '100022', 'lidl', '2017-07-24 20:25:10', 'lidongliang', '2017-07-24 20:25:10', '0'), ('6', 'xiaomingdingdan', '13478824245', '2017-07-24 20:25:30', '10011', '100022', 'lidl', '2017-07-24 20:25:29', 'lidongliang', '2017-07-24 20:25:29', '0'), ('7', 'xiaomingdingdan', '13478824245', '2017-07-24 20:27:45', '10011', '100022', 'lidl', '2017-07-24 20:27:44', 'lidongliang', '2017-07-24 20:27:44', '0'), ('8', 'xiaomingdingdan', '13478824245', '2017-07-24 20:32:51', '10011', '100022', 'lidl', '2017-07-24 20:32:50', 'lidongliang', '2017-07-24 20:32:50', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_menu_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_menu_info_t`;
CREATE TABLE `hk_menu_info_t` (
  `DISHES_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜肴编号',
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单ID',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  `DISHES_NAME` varchar(50) NOT NULL COMMENT '菜肴名称',
  `DISHES_PRICE` float(5,2) NOT NULL COMMENT '菜肴价钱',
  `DISHES_DISCOUNT_PRICE` varchar(3) DEFAULT NULL COMMENT '菜肴折扣',
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
  PRIMARY KEY (`DISHES_ID`,`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_menu_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_menu_info_t` VALUES ('2', '2', '10002', '水煮肉1', '30.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-18 11:17:26', 'lidongliang', '2017-07-24 20:32:51', '0'), ('5', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-19 21:04:09', 'lidongliang', '2017-07-19 21:04:09', '0'), ('6', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:25:10', 'lidongliang', '2017-07-24 20:25:10', '0'), ('7', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:25:30', 'lidongliang', '2017-07-24 20:25:30', '0'), ('8', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:27:45', 'lidongliang', '2017-07-24 20:27:45', '0'), ('9', '10001', '10002', '水煮肉', '20.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-24 20:32:51', 'lidongliang', '2017-07-24 20:32:51', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_order_dish_info_t`
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_order_dish_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_order_dish_info_t` VALUES ('22', '12', '1234', '11', '大虾', '10.00', '10%', '2', '李栋梁', '2017-07-18 11:04:33', '2017-07-24 20:32:51', null, '0'), ('23', '12', '1013', '1001', '水煮鱼1', '98.00', '18%', '1', '李栋梁', '2017-07-18 11:04:33', '2017-07-18 11:04:33', '李栋梁', '0'), ('24', '12', '1014', '1001', '大鲍鱼', '98.00', '18%', '1', '李栋梁', '2017-07-18 11:04:33', '2017-07-18 11:04:33', '李栋梁', '0'), ('25', '13', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:25:10', '2017-07-24 20:25:10', '李栋梁', '0'), ('26', '13', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:25:10', '2017-07-24 20:25:10', '李栋梁', '0'), ('27', '13', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:25:10', '2017-07-24 20:25:10', '李栋梁', '0'), ('28', '14', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:25:30', '2017-07-24 20:25:30', '李栋梁', '0'), ('29', '14', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:25:30', '2017-07-24 20:25:30', '李栋梁', '0'), ('30', '14', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:25:30', '2017-07-24 20:25:30', '李栋梁', '0'), ('31', '15', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:27:45', '2017-07-24 20:27:45', '李栋梁', '0'), ('32', '15', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:27:45', '2017-07-24 20:27:45', '李栋梁', '0'), ('33', '15', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:27:45', '2017-07-24 20:27:45', '李栋梁', '0'), ('34', '16', '201', '400001', '锅包肉', '48.00', '10%', '2', '李栋梁', '2017-07-24 20:32:51', '2017-07-24 20:32:51', '李栋梁', '0'), ('35', '16', '202', '400001', '水牛蛙', '88.00', '1%', '1', '李栋梁', '2017-07-24 20:32:51', '2017-07-24 20:32:51', '李栋梁', '0'), ('36', '16', '203', '400001', '清蒸大鲍鱼', '50.00', '', '1', '李栋梁', '2017-07-24 20:32:51', '2017-07-24 20:32:51', '李栋梁', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_order_info_t`
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_order_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_order_info_t` VALUES ('12', '9', '9', '9', '2017-07-18 11:04:33', '9.00', '李栋梁', '9', 'XXXX', '李栋梁', '2017-07-18 11:04:33', '天天向上', '2017-07-18 11:12:50', '0'), ('13', '9', '9', '9', '2017-07-24 20:25:10', '9.00', '李栋梁', '9', 'XXXX', '李栋梁', '2017-07-24 20:25:10', '天天向上', '2017-07-24 20:32:51', '0'), ('14', '5002', '99', '1', '2017-07-24 20:25:30', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-24 20:25:30', '李栋梁', '2017-07-24 20:25:30', '0'), ('15', '5002', '99', '1', '2017-07-24 20:27:45', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-24 20:27:45', '李栋梁', '2017-07-24 20:27:45', '0'), ('16', '5002', '99', '1', '2017-07-24 20:32:51', '100.00', '李栋梁', '2', '测试', '李栋梁', '2017-07-24 20:32:51', '李栋梁', '2017-07-24 20:32:51', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_store_img_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_store_img_t`;
CREATE TABLE `hk_store_img_t` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `STORE_ID` bigint(20) DEFAULT NULL COMMENT '餐厅编号',
  `IMG_URL` varchar(16) DEFAULT NULL COMMENT '餐厅相片',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `hk_store_info_t`
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
  `STORE_IMG` varchar(200) DEFAULT NULL COMMENT '餐厅相片',
  `STORE_TYPE` int(20) DEFAULT NULL COMMENT '餐厅类型（00：日料，01:韩国，等）',
  `SEAT_COST` float(5,2) DEFAULT NULL COMMENT '茶位费',
  `SERVICE_COST` varchar(3) DEFAULT NULL COMMENT '服务费',
  `STORE_BUSINESS_AM_START_HOURS` datetime DEFAULT NULL COMMENT '餐厅营业上午营业开始时间',
  `STORE_BUSINESS_AM_END_HOURS` datetime DEFAULT NULL COMMENT '餐厅营业上午闭店结束时间',
  `STORE_BUSINESS_PM_START_HOURS` datetime DEFAULT NULL COMMENT '餐厅营业下午营业开始时间',
  `STORE_BUSINESS_PM_END_HOURS` datetime DEFAULT NULL COMMENT '餐厅营业下午闭店结束时间',
  `STORE_BUSINESS_DAY` varchar(30) DEFAULT NULL COMMENT '餐厅营业日',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`STORE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_store_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_store_info_t` VALUES ('7', '好利来1', '13478824245', '北京', '李栋梁', '环境优雅', '1', 'D:\\asd', 'aaaa', 'D:\\asd', '1', '22.11', '10%', '2017-07-24 19:21:26', '2017-07-24 19:21:26', '2017-07-24 19:21:26', '2017-07-24 19:21:26', null, '李栋梁', '2017-07-24 19:21:25', '李栋梁', '2017-07-24 19:21:25', '0'), ('10', '好利来1', '13478824245', '北京', '李栋梁', '环境优雅', '1', 'D:\\asd', 'aaaa', 'D:\\asd', '1', '22.11', '10%', '2017-07-24 20:25:11', '2017-07-24 20:25:11', '2017-07-24 20:25:11', '2017-07-24 20:25:11', null, '李栋梁', '2017-07-24 20:25:11', '李栋梁', '2017-07-24 20:25:11', '0'), ('11', '好利来1', '13478824245', '北京', '李栋梁', '环境优雅', '1', 'D:\\asd', 'aaaa', 'D:\\asd', '1', '22.11', '10%', '2017-07-24 20:25:31', '2017-07-24 20:25:31', '2017-07-24 20:25:31', '2017-07-24 20:25:31', null, '李栋梁', '2017-07-24 20:25:30', '李栋梁', '2017-07-24 20:25:30', '0'), ('12', '好利来1', '13478824245', '北京', '李栋梁', '环境优雅', '1', 'D:\\asd', 'aaaa', 'D:\\asd', '1', '22.11', '10%', '2017-07-24 20:27:46', '2017-07-24 20:27:46', '2017-07-24 20:27:46', '2017-07-24 20:27:46', null, '李栋梁', '2017-07-24 20:27:45', '李栋梁', '2017-07-24 20:27:45', '0'), ('13', '好利来1', '13478824245', '北京', '李栋梁', '环境优雅', '1', 'D:\\asd', 'aaaa', 'D:\\asd', '1', '22.11', '10%', '2017-07-24 20:32:52', '2017-07-24 20:32:52', '2017-07-24 20:32:52', '2017-07-24 20:32:52', null, '李栋梁', '2017-07-24 20:32:51', '李栋梁', '2017-07-24 20:32:51', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_sys_dictionary_info_t`
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_sys_dictionary_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_sys_dictionary_info_t` VALUES ('1', '90001', '用户角色', 'admin', '管理员', 'lidongliang', '2017-07-19 13:27:04', 'lidongliang', '2017-07-19 13:27:04', '0'), ('2', '90001', '用户角色', 'user', '用户', 'lidongliang', '2017-07-19 13:29:05', 'lidongliang', '2017-07-19 13:29:05', '0'), ('7', '90001', '用户角色2', 'user1', '用户4', 'lidongliang', '2017-07-19 20:27:22', 'lidongliang', '2017-07-19 20:27:22', '0'), ('8', '90001', '用户角色2', 'user1', '用户4', 'lidongliang', '2017-07-24 20:25:11', 'lidongliang', '2017-07-24 20:25:11', '0'), ('9', '90001', '用户角色2', 'user1', '用户4', 'lidongliang', '2017-07-24 20:25:30', 'lidongliang', '2017-07-24 20:25:30', '0'), ('10', '90001', '用户角色2', 'user1', '用户4', 'lidongliang', '2017-07-24 20:27:45', 'lidongliang', '2017-07-24 20:27:45', '0'), ('11', '90001', '用户角色2', 'user1', '用户4', 'lidongliang', '2017-07-24 20:32:51', 'lidongliang', '2017-07-24 20:32:51', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_sys_menu_info_t`
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
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_sys_menu_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_sys_menu_info_t` VALUES ('1001', '系统管理', '/system', 'layout/Layout', '', 'zujian', '0', 'admin,user', null, 'admin', '2017-07-16 16:26:48', 'admin', '2017-07-19 16:26:02', '0'), ('1003', '用户管理', 'user', 'system/user', '', '', '1', 'admin', '1001', 'admin', '2017-07-16 16:26:48', '', '2017-07-19 15:03:21', '0'), ('1004', '菜单管理', 'menu', 'system/menu', '', '', '1', 'admin', '1001', 'admin', '2017-07-16 16:26:48', '', '2017-07-19 15:03:34', '0'), ('1007', '门店管理', 'store', 'system/menu', null, null, '0', 'user', '1001', '', '2017-07-19 15:08:00', '', '2017-07-19 15:08:00', '0'), ('1009', '样例', '/example', 'layout/Layout', '', 'zujian', '0', 'admin', null, 'admin', '2017-07-19 15:56:15', 'admin', '2017-07-19 16:25:55', '0'), ('1010', '表格样例', 'table', 'example/table/table', null, null, '0', 'admin', '1009', 'admin', '2017-07-19 15:57:28', 'admin', '2017-07-19 15:57:28', '0'), ('1015', '123', '123', 'dasdd', null, '123', '0', 'admin, user', null, 'lll', '2017-07-24 20:25:11', 'llll', '2017-07-24 20:25:11', '0'), ('1016', '123', '123', 'dasdd', null, '123', '0', 'admin, user', null, 'lll', '2017-07-24 20:25:30', 'llll', '2017-07-24 20:25:30', '0'), ('1017', '123', '123', 'dasdd', null, '123', '0', 'admin, user', null, 'lll', '2017-07-24 20:27:45', 'llll', '2017-07-24 20:27:45', '0'), ('1018', '123', '123', 'dasdd', null, '123', '0', 'admin, user', null, 'lll', '2017-07-24 20:32:51', 'llll', '2017-07-24 20:32:51', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_sys_user_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_sys_user_info_t`;
CREATE TABLE `hk_sys_user_info_t` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `USER_NAME` varchar(16) DEFAULT NULL COMMENT '用户名字',
  `USER_PASSWORD` varchar(16) DEFAULT NULL COMMENT '用户密码',
  `USER_ROLE` varchar(30) DEFAULT NULL,
  `USER_PHONE` bigint(11) DEFAULT NULL COMMENT '用户电话',
  `USER_SEX` int(1) DEFAULT NULL COMMENT '用户性别',
  `USER_ADDRESS` varchar(50) DEFAULT NULL COMMENT '用户地址',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_sys_user_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_sys_user_info_t` VALUES ('4', 'admin', '123456', 'admin', '13478824245', '1', 'beijiang', 'admin', '2017-07-18 15:57:03', '', '2017-07-19 15:19:17', '0'), ('6', 'boss', '123456', 'user', '13478824245', '1', 'beijiang', 'admin', '2017-07-18 20:10:11', 'admin', '2017-07-18 20:10:11', '0'), ('17', '123123', 'a', 'admin, user', '13478824245', '1', 'beijiang', 'ldl', '2017-07-24 20:25:11', 'xiaoming', '2017-07-24 20:25:11', '0'), ('18', '123123', 'a', 'admin, user', '13478824245', '1', 'beijiang', 'ldl', '2017-07-24 20:25:30', 'xiaoming', '2017-07-24 20:25:30', '0'), ('19', '123123', 'a', 'admin, user', '13478824245', '1', 'beijiang', 'ldl', '2017-07-24 20:27:45', 'xiaoming', '2017-07-24 20:27:45', '0'), ('20', '123123', 'a', 'admin, user', '13478824245', '1', 'beijiang', 'ldl', '2017-07-24 20:32:51', 'xiaoming', '2017-07-24 20:32:51', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_table_info_t`
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_table_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_table_info_t` VALUES ('1', '2', '0', 'a123eaa', null, '2017-07-18 13:24:34', 'xiaomin1g', '2017-07-24 20:32:51', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_user_store_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_user_store_info_t`;
CREATE TABLE `hk_user_store_info_t` (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户编号',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  PRIMARY KEY (`USER_ID`,`STORE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_user_store_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_user_store_info_t` VALUES ('100001', '7'), ('100003', '10'), ('100003', '11'), ('100003', '12'), ('100003', '13');
COMMIT;

-- ----------------------------
--  Table structure for `hk_user_sys_menu_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_user_sys_menu_info_t`;
CREATE TABLE `hk_user_sys_menu_info_t` (
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '系统菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
