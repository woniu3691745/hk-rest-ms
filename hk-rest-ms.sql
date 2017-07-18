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

 Date: 07/18/2017 20:37:45 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_book_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_book_info_t` VALUES ('1', '12123123', '13478824245', '2017-07-18 11:21:38', '10011', '100022', 'lidl', '2017-07-18 09:22:28', 'lidongliang', '2017-07-18 11:21:38', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_dictionary_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_dictionary_info_t`;
CREATE TABLE `hk_dictionary_info_t` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CODE_ID` varchar(30) NOT NULL COMMENT '代码',
  `CODE_VALUE` varchar(30) NOT NULL COMMENT '代码值',
  `CODE_NAME` varchar(50) DEFAULT NULL COMMENT '代码名称',
  `CODE_TYPE_NAME` varchar(50) DEFAULT NULL COMMENT '代码类型名',
  `CREATER` varchar(16) DEFAULT NULL COMMENT '创建者',
  `CREATE_DATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MODIFY` varchar(16) DEFAULT NULL COMMENT '修改者',
  `UPDATE_DATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态（0：不可用，1：可用）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_menu_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_menu_info_t` VALUES ('2', '2', '10002', '水煮肉1', '30.35', '0.8', '鱼水肉', '1', '333', '1', '1', '1', '1', 'lidl', '2017-07-18 11:17:26', 'lidongliang', '2017-07-18 11:18:26', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_order_dish_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_order_dish_info_t` VALUES ('22', '12', '1234', '11', '大虾', '10.00', '10%', '2', '李栋梁', '2017-07-18 11:04:33', '2017-07-18 11:11:52', null, '0'), ('23', '12', '1013', '1001', '水煮鱼1', '98.00', '18%', '1', '李栋梁', '2017-07-18 11:04:33', '2017-07-18 11:04:33', '李栋梁', '0'), ('24', '12', '1014', '1001', '大鲍鱼', '98.00', '18%', '1', '李栋梁', '2017-07-18 11:04:33', '2017-07-18 11:04:33', '李栋梁', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_order_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_order_info_t` VALUES ('12', '9', '9', '9', '2017-07-18 11:04:33', '9.00', '李栋梁', '9', 'XXXX', '李栋梁', '2017-07-18 11:04:33', '天天向上', '2017-07-18 11:12:50', '0');
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
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户编号',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_store_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_store_info_t` VALUES ('2', '1001', 'aibaba', '13478824245', 'ddss1212', 'aaaa', 'dddddd', '1', 'D:\\asd', '123213', '123123213', '1', '22.11', '10%', '2017-07-18 11:29:28', '2017-07-18 11:29:28', '2017-07-18 11:29:28', '2017-07-18 11:29:28', null, '111', '2017-07-18 11:29:27', '2222', '2017-07-18 11:29:27', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_sys_menu_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_sys_menu_info_t` VALUES ('1001', '组件1', '/components', 'layout/Layout', '/components/index', 'zujian', '0', 'admin,user', null, 'admin', '2017-07-16 16:26:48', 'admin', '2017-07-16 16:26:54', '0'), ('1002', '组件2', '/components', 'layout/Layout', '/components/index', 'zujian', '0', 'admin', null, 'admin', '2017-07-16 16:26:48', 'admin', '2017-07-16 16:26:54', '0'), ('1003', '子组件1', '/components-sub', 'layout/Layout-sub', '/components/index-sub', 'zujian-sub', '1', 'admin,user', '1001', 'admin', '2017-07-16 16:26:48', 'admin', '2017-07-16 16:26:54', '0'), ('1004', '子组件2', '/components4', 'layout/Layout4', '/components/index4', 'zujian4', '1', 'admin,user', '1002', 'admin', '2017-07-16 16:26:48', 'admin', '2017-07-16 16:26:54', '0'), ('1005', '子组件3', '/components', 'layout/Layout', '/components/index', 'zujian', '1', 'admin', '1001', 'admin', '2017-07-16 16:26:48', 'admin', '2017-07-16 16:26:54', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_sys_user_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_sys_user_info_t` VALUES ('4', 'lidongliang', 'a', null, '13478824245', '1', 'beijiang', 'ldl', '2017-07-18 15:57:03', 'xiaoming', '2017-07-18 15:57:03', '0'), ('6', 'lidongliang', 'a', 'admin,user', '13478824245', '1', 'beijiang', 'ldl', '2017-07-18 20:10:11', 'xiaoming', '2017-07-18 20:10:11', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `hk_table_info_t`
-- ----------------------------
BEGIN;
INSERT INTO `hk_table_info_t` VALUES ('1', '2', '0', 'a123eaa', null, '2017-07-18 13:24:34', 'xiaomin1g', '2017-07-18 13:30:22', '0'), ('5', '1', '0', 'aaa', 'lidongliang', '2017-07-18 15:49:26', 'xiaoming', '2017-07-18 15:49:26', '0');
COMMIT;

-- ----------------------------
--  Table structure for `hk_user_store_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_user_store_info_t`;
CREATE TABLE `hk_user_store_info_t` (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户编号',
  `STORE_ID` bigint(20) NOT NULL COMMENT '餐厅编号',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `hk_user_sys_menu_info_t`
-- ----------------------------
DROP TABLE IF EXISTS `hk_user_sys_menu_info_t`;
CREATE TABLE `hk_user_sys_menu_info_t` (
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '系统菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
