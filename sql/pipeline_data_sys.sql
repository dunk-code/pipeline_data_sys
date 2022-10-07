/*
 Navicat Premium Data Transfer

 Source Server         : windows
 Source Server Type    : MySQL
 Source Server Version : 50561
 Source Host           : localhost:3306
 Source Schema         : pipeline_data_sys

 Target Server Type    : MySQL
 Target Server Version : 50561
 File Encoding         : 65001

 Date: 25/09/2022 14:03:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_attribute`;
CREATE TABLE `t_attribute`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tab_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表名',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '类别id',
  `category_identifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别编号',
  `category_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `english_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '英文名',
  `chinese_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中文名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段描述',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `type_precision` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型与精度',
  `range_constraint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_attribute
-- ----------------------------
INSERT INTO `t_attribute` VALUES (1, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (2, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (3, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (4, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (5, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (6, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (7, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (8, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (9, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (10, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (11, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (12, '表B.09.0001泵', 8, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (13, '表B.09.0001泵', 9, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (14, '表B.09.0001泵', 10, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (15, '表B.09.0001泵', 11, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (16, '表B.09.0001泵', 12, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (17, '表B.09.0001泵', 13, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (18, '表B.09.0001泵', 14, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (19, '表B.09.0001泵', 15, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (20, '表B.09.0001泵', 16, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (21, '表B.09.0001泵', 17, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (22, '表B.09.0001泵', 22, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (23, '表B.09.0001泵', 23, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (24, '表B.09.0001泵', 24, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (25, '表B.09.0001泵', 25, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (26, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (27, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (28, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (29, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', NULL, 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (30, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (31, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (32, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (33, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (34, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (35, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (36, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (37, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (38, '表B.09.0001泵', 26, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (39, '表B.09.0001泵', 2, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (40, '表B.09.0001泵', 3, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (41, '表B.09.0001泵', 4, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (42, '表B.09.0001泵', 5, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (43, '表B.09.0001泵', 6, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (44, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (45, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (46, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (47, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (48, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (49, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (50, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (51, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (52, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (53, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (54, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (55, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (56, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (57, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (58, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (59, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (60, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (61, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (62, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (63, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (64, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (65, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (66, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (67, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (68, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (69, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);
INSERT INTO `t_attribute` VALUES (70, '表B.09.0001泵', 19, NULL, NULL, 'Classification', '分类', '泵类型', 'MPa\r\n', 'c(10)', '｛离心泵，往复泵，轴流泵，混流泵，转子泵，计量泵，化工流程泵，其他泵｝', '2022-09-25 00:25:54', NULL);

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `identifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别名',
  `attribute_tab_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性表名',
  `parent_id` int(10) NULL DEFAULT NULL COMMENT '父级id',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1, 'G01', '管道基础数据', NULL, NULL, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (2, 'G0101', '坐标系', '表B.09.0001泵', 1, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (3, 'G0102', '管道工程', '表B.09.0001泵', 1, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (4, 'G0103', '管线', '表B.09.0001泵', 1, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (5, 'G0104', '管段', '表B.09.0001泵', 1, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (6, 'G0105', '分输口', '表B.09.0001泵', 1, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (7, 'G0106', '线路段', NULL, 1, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (8, 'G010601', '清管段', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (9, 'G010602', '管材（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (10, 'G010603', '设计压力（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (11, 'G010604', '外防腐层（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (12, 'G010605', '内涂层（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (13, 'G010606', '行政区划（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (14, 'G010607', '地质地貌（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (15, 'G010608', '清管测径（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (16, 'G010609', '试压（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (17, 'G010610', '干燥（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (18, 'G010611', '防腐类型（段）', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (19, 'G010699', '其他线路段基础数据', '表B.09.0001泵', 7, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (20, 'G09', '管道基础数据\r\n管道基础数据', NULL, NULL, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (21, 'G0901', '坐标系', NULL, 20, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (22, 'G090101', '管道工程', '表B.09.0001泵', 21, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (23, 'G090102', '管线', '表B.09.0001泵', 21, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (24, 'G090103', '管段', '表B.09.0001泵', 21, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (25, 'G090104', '分输口', '表B.09.0001泵', 21, '2022-09-25 00:25:54', NULL);
INSERT INTO `t_category` VALUES (26, 'G090105', '线路段', '表B.09.0001泵', 21, '2022-09-25 00:25:54', NULL);

SET FOREIGN_KEY_CHECKS = 1;
