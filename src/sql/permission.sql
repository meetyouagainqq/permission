/*
 Navicat Premium Data Transfer

 Source Server         : mysqltest
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 20/07/2022 21:52:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '权限(菜单)功能id',
  `per_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `per_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限路径',
  `per_identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限标识(控制器标识)',
  `per_logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限图标',
  `per_status` tinyint(1) NULL DEFAULT NULL COMMENT '状态  0 不显示  1  显示',
  `parent_per_id` int(0) NULL DEFAULT NULL COMMENT '上级权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '系统管理', '#', '-', 'fa fa-gear', 1, 0);
INSERT INTO `permission` VALUES (2, '系统监控', '#', '-', 'fa fa-video-camera', 1, 0);
INSERT INTO `permission` VALUES (3, '系统工具', '#', '-', 'fa fa-bars', 1, 0);
INSERT INTO `permission` VALUES (4, '用户管理', '	/system/user', 'system:user:view', 'fa fa-user-o', 1, 1);
INSERT INTO `permission` VALUES (5, '角色管理', '/system/role', 'system:role:view', 'fa fa-user-secret', 1, 1);
INSERT INTO `permission` VALUES (6, '部门管理', '/system/dept', 'system:menu:view', NULL, 1, 1);
INSERT INTO `permission` VALUES (7, '岗位管理', '/system/post', 'system:post:view', NULL, 1, 1);
INSERT INTO `permission` VALUES (9, '在线用户', '/monitor/online', 'monitor:online:view', 'fa fa-user-circle', 1, 2);
INSERT INTO `permission` VALUES (10, '定时任务', '	/monitor/job', '	monitor:job:view', 'fa fa-tasks', 1, 2);
INSERT INTO `permission` VALUES (11, '服务监控', '/monitor/server', 'monitor:server:view', 'fa fa-server', 1, 2);
INSERT INTO `permission` VALUES (12, ' 缓存监控', '/monitor/cache', '	monitor:cache:view', 'fa fa-cube', 1, 2);
INSERT INTO `permission` VALUES (13, '表单构建', '	/tool/build', 'tool:build:view', 'fa fa-wpforms', 1, 3);
INSERT INTO `permission` VALUES (14, '代码生成', '/tool/gen', 'tool:gen:view', 'fa fa-code', 1, 3);
INSERT INTO `permission` VALUES (15, '系统接口', '/tool/swagger', '	tool:swagger:view', 'fa fa-gg', 1, 3);
INSERT INTO `permission` VALUES (16, ' 用户查询', '/system/user/list', 'system:user:list', NULL, 1, 4);
INSERT INTO `permission` VALUES (17, ' 用户新增', NULL, 'system:user:add', NULL, 1, 4);
INSERT INTO `permission` VALUES (18, ' 用户修改', NULL, 'system:user:edit', NULL, 1, 4);
INSERT INTO `permission` VALUES (19, '用户删除', NULL, '	system:user:remove', NULL, 1, 4);
INSERT INTO `permission` VALUES (20, '用户导出', NULL, '	system:user:export', NULL, 1, 4);
INSERT INTO `permission` VALUES (21, ' 用户导入', NULL, 'system:user:import', NULL, 1, 4);
INSERT INTO `permission` VALUES (22, ' 重置密码', NULL, 'system:user:resetPwd', NULL, 1, 4);
INSERT INTO `permission` VALUES (23, '角色查询', NULL, '	system:role:list', NULL, 1, 5);
INSERT INTO `permission` VALUES (24, '角色新增', NULL, 'system:role:add', NULL, 1, 5);
INSERT INTO `permission` VALUES (25, '角色修改', NULL, '	system:role:edit', NULL, 1, 5);
INSERT INTO `permission` VALUES (26, '角色删除', NULL, 'system:role:remove	', NULL, 1, 5);
INSERT INTO `permission` VALUES (27, '角色导出', NULL, 'system:role:export', NULL, 1, 5);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_status` tinyint(1) NULL DEFAULT NULL,
  `role_desc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '一般人员', 1, NULL);
INSERT INTO `role` VALUES (2, '测试人员', 1, NULL);
INSERT INTO `role` VALUES (3, '管理员', 1, NULL);
INSERT INTO `role` VALUES (4, '123', 1, '1');
INSERT INTO `role` VALUES (5, '123', 1, '2');
INSERT INTO `role` VALUES (6, 'hahahahtest', 1, 'h');

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per`  (
  `rid` int(0) NULL DEFAULT NULL,
  `pid` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_per
-- ----------------------------
INSERT INTO `role_per` VALUES (1, 16);
INSERT INTO `role_per` VALUES (1, 20);
INSERT INTO `role_per` VALUES (2, 16);
INSERT INTO `role_per` VALUES (2, 20);
INSERT INTO `role_per` VALUES (5, 1);
INSERT INTO `role_per` VALUES (5, 2);
INSERT INTO `role_per` VALUES (5, 3);
INSERT INTO `role_per` VALUES (5, 2);
INSERT INTO `role_per` VALUES (5, 3);
INSERT INTO `role_per` VALUES (5, 4);
INSERT INTO `role_per` VALUES (5, 5);
INSERT INTO `role_per` VALUES (7, 13);
INSERT INTO `role_per` VALUES (7, 14);
INSERT INTO `role_per` VALUES (7, 15);
INSERT INTO `role_per` VALUES (8, 9);
INSERT INTO `role_per` VALUES (8, 10);
INSERT INTO `role_per` VALUES (8, 11);
INSERT INTO `role_per` VALUES (8, 12);
INSERT INTO `role_per` VALUES (11, 1);
INSERT INTO `role_per` VALUES (11, 2);
INSERT INTO `role_per` VALUES (11, 3);
INSERT INTO `role_per` VALUES (11, 4);
INSERT INTO `role_per` VALUES (6, 1);
INSERT INTO `role_per` VALUES (6, 2);
INSERT INTO `role_per` VALUES (6, 3);
INSERT INTO `role_per` VALUES (6, 4);
INSERT INTO `role_per` VALUES (6, 5);
INSERT INTO `role_per` VALUES (6, 6);

SET FOREIGN_KEY_CHECKS = 1;
