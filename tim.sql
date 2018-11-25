/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : tim

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-11-25 20:36:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` varchar(50) NOT NULL COMMENT '组id',
  `group_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群号',
  `group_faceImage_big` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '群头像',
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组名称',
  `group_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '组描述',
  `qrCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '群的二维码',
  `users_num` int(11) NOT NULL DEFAULT '0' COMMENT '组的用户数量',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group_accept_chat_content
-- ----------------------------
DROP TABLE IF EXISTS `group_accept_chat_content`;
CREATE TABLE `group_accept_chat_content` (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组用户接收消息id',
  `group_send_content_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群发送消息的id',
  `accept_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收用户的id',
  `accept_group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '群聊组的id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '消息内容',
  `sign_flag` int(11) NOT NULL DEFAULT '0' COMMENT '是否签收',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群聊接收消息表';

-- ----------------------------
-- Table structure for group_request
-- ----------------------------
DROP TABLE IF EXISTS `group_request`;
CREATE TABLE `group_request` (
  `id` varchar(50) NOT NULL COMMENT '组请求关联id',
  `send_group_id` varchar(50) DEFAULT NULL COMMENT '发送组id',
  `accept_user_id` varchar(50) NOT NULL COMMENT '接收者id',
  `accept_status` int(11) NOT NULL DEFAULT '0' COMMENT '请求状态,0:未接收,1:同意,2:拒绝,3:忽略',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group_send_chat_content
-- ----------------------------
DROP TABLE IF EXISTS `group_send_chat_content`;
CREATE TABLE `group_send_chat_content` (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组用户发送消息id',
  `send_user_id` varchar(50) NOT NULL COMMENT '发送者id',
  `accept_group_id` varchar(50) NOT NULL COMMENT '接收组id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='群聊发送消息表';

-- ----------------------------
-- Table structure for group_users
-- ----------------------------
DROP TABLE IF EXISTS `group_users`;
CREATE TABLE `group_users` (
  `id` varchar(50) NOT NULL COMMENT '组用户关联id',
  `group_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组id',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL COMMENT '入群时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for single_chat_content
-- ----------------------------
DROP TABLE IF EXISTS `single_chat_content`;
CREATE TABLE `single_chat_content` (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '私人信息id',
  `send_user_id` varchar(50) NOT NULL COMMENT '发送者id',
  `accept_user_id` varchar(50) NOT NULL COMMENT '接收者id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `sign_flag` int(11) NOT NULL COMMENT '对方是否签收,0:未签收,1:已签收',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for single_request
-- ----------------------------
DROP TABLE IF EXISTS `single_request`;
CREATE TABLE `single_request` (
  `id` varchar(50) NOT NULL COMMENT '好友请求关联id',
  `send_user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送者id',
  `accept_user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收者id',
  `accept_status` int(11) NOT NULL DEFAULT '0' COMMENT '请求状态,0:未接收,1:同意,2:拒绝,3:忽略',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for single_users
-- ----------------------------
DROP TABLE IF EXISTS `single_users`;
CREATE TABLE `single_users` (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '好友关联id',
  `my_id` varchar(50) NOT NULL COMMENT '我的id',
  `my_friend_id` varchar(50) NOT NULL COMMENT '我好友的id',
  `create_time` datetime NOT NULL COMMENT '关联时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `qq_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号(qq号)',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `face_image_cut` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '头像修剪',
  `face_image_big` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '头像原图',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '描述,签名',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `qrCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '个人二维码',
  `app_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机唯一标识',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建事件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
