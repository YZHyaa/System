/*
Navicat MySQL Data Transfer

Source Server         : localhost-5.1
Source Server Version : 50155
Source Host           : localhost:3306
Source Database       : ezhao

Target Server Type    : MYSQL
Target Server Version : 50155
File Encoding         : 65001

Date: 2020-12-13 22:21:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `col_id` int(10) NOT NULL AUTO_INCREMENT,
  `note_id` int(10) DEFAULT NULL,
  `u_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`col_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('3', '6', '3');
INSERT INTO `collection` VALUES ('4', '7', '3');
INSERT INTO `collection` VALUES ('5', '8', '3');
INSERT INTO `collection` VALUES ('6', '6', '1');
INSERT INTO `collection` VALUES ('7', '8', '5');
INSERT INTO `collection` VALUES ('8', '1', '2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `com_id` int(10) NOT NULL AUTO_INCREMENT,
  `com_content` varchar(1000) DEFAULT NULL,
  `com_date` datetime DEFAULT NULL,
  `to_note_id` int(10) DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '你这互联网+队伍稳不稳啊', '2019-05-02 21:54:16', '1', '李四');
INSERT INTO `comment` VALUES ('2', '我想加入你们的队伍，老哥考虑一下', '2020-01-01 20:10:30', '1', '王五');
INSERT INTO `comment` VALUES ('3', '就你们还想抱大腿？', '2019-05-03 22:04:19', '4', '赵六');
INSERT INTO `comment` VALUES ('4', '来啊来啊，我的大腿粗', '2019-05-03 07:05:37', '4', '李四');
INSERT INTO `comment` VALUES ('6', '你们水泥厂会塌掉的么', '2019-05-07 02:22:40', '8', '赵六');
INSERT INTO `comment` VALUES ('7', '这么晚你还在测试？', '2019-05-04 02:41:08', '10', '王五');

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `fol_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_id` int(10) DEFAULT NULL,
  `fans_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`fol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('2', '1', '3');
INSERT INTO `follow` VALUES ('3', '1', '4');
INSERT INTO `follow` VALUES ('4', '2', '3');
INSERT INTO `follow` VALUES ('6', '5', '1');
INSERT INTO `follow` VALUES ('7', '4', '3');
INSERT INTO `follow` VALUES ('8', '3', '1');
INSERT INTO `follow` VALUES ('9', '7', '2');

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `info_id` int(10) NOT NULL AUTO_INCREMENT,
  `info_name` varchar(100) DEFAULT NULL,
  `info_gender` varchar(10) DEFAULT NULL,
  `info_school` varchar(100) DEFAULT NULL,
  `info_cid` varchar(20) DEFAULT NULL,
  `info_profession` varchar(100) DEFAULT NULL,
  `info_phone` varchar(11) DEFAULT NULL,
  `u_name` varchar(100) DEFAULT NULL,
  `u_id` int(10) NOT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', '张散散', '男', '西安邮电大学', '01181045', '信息对抗', '12345678901', '张三', '1');
INSERT INTO `information` VALUES ('2', '李丝丝', '女', '西安邮电大学', '02182045', '通信工程', '12345678902', '李四', '2');
INSERT INTO `information` VALUES ('3', '王五五', '男', '西安邮电大学', '03183045', '信息安全', '12345678903', '王五', '3');
INSERT INTO `information` VALUES ('4', '赵柳柳', '女', '西安邮电大学', '04184045', '信息工程', '12345678904', '赵六', '4');
INSERT INTO `information` VALUES ('5', '李琪琪', '男', '西安邮电大学', '05032072', '信息对抗', '1870327562', '李七', '5');
INSERT INTO `information` VALUES ('6', '实验室', null, '西安邮电大学', null, null, null, '实验室', '6');
INSERT INTO `information` VALUES ('7', '老师', '女', '西安邮电大学', null, null, '12345678907', '老师', '7');
INSERT INTO `information` VALUES ('8', '企业', null, null, null, null, null, '企业', '8');
INSERT INTO `information` VALUES ('9', '侧石', '男', '西安邮电大学', '09189045', '挖矿', '12345678909', '测试', '9');
INSERT INTO `information` VALUES ('10', null, null, null, null, null, null, null, '10');
INSERT INTO `information` VALUES ('11', null, null, null, null, null, null, null, '10');
INSERT INTO `information` VALUES ('12', null, null, null, null, null, null, null, '11');
INSERT INTO `information` VALUES ('13', null, null, null, null, null, null, null, '12');
INSERT INTO `information` VALUES ('14', null, null, null, null, null, null, null, '13');
INSERT INTO `information` VALUES ('15', null, null, null, null, null, null, null, '9');
INSERT INTO `information` VALUES ('16', null, null, null, null, null, null, null, '14');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `lab_id` int(10) NOT NULL AUTO_INCREMENT,
  `lab_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', '推荐');
INSERT INTO `label` VALUES ('2', '比赛组队');
INSERT INTO `label` VALUES ('3', '企业招聘');
INSERT INTO `label` VALUES ('4', '项目');
INSERT INTO `label` VALUES ('5', '比赛推送');
INSERT INTO `label` VALUES ('6', '社团活动');
INSERT INTO `label` VALUES ('7', '每日新闻');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `msg_id` int(10) NOT NULL AUTO_INCREMENT,
  `from_id` int(10) DEFAULT NULL,
  `to_id` int(10) DEFAULT NULL,
  `msg_content` varchar(500) DEFAULT NULL,
  `msg_date` datetime DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '1', '2', '你好啊', '2019-05-01 20:18:46');
INSERT INTO `message` VALUES ('2', '2', '1', '你是谁', '2019-05-03 04:42:09');
INSERT INTO `message` VALUES ('3', '1', '2', '我是张三，你呢', '2019-05-03 04:42:26');
INSERT INTO `message` VALUES ('4', '2', '1', '哦哦，我是李四', '2019-05-03 04:42:40');
INSERT INTO `message` VALUES ('5', '1', '2', '哈哈哈哈', '2019-05-03 04:42:56');
INSERT INTO `message` VALUES ('6', '2', '1', '???', '2019-05-03 04:45:58');
INSERT INTO `message` VALUES ('7', '1', '3', '我是谁啊？', '2019-05-04 05:03:59');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `news_id` int(10) NOT NULL AUTO_INCREMENT,
  `news_content` varchar(10000) DEFAULT NULL,
  `news_title` varchar(100) DEFAULT NULL,
  `news_date` datetime DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  `news_school` varchar(100) DEFAULT NULL,
  `lab_id` int(10) DEFAULT NULL,
  `pic_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '今天美国总统换届大选，特朗普下台', '特朗普下台！', '2019-05-03 03:45:33', '张三', '西安邮电大学', '7', 'C:/Users/13275/Documents/Uploads/ssm-demo/20190508153124.png');
INSERT INTO `news` VALUES ('2', '第二十一届电子设计大赛开幕了，将于今天举行开幕式', '电赛开幕', '2019-05-03 03:47:32', '李四', '西安邮电大学', '5', 'C:/Users/13275/Documents/Uploads/ssm-demo/20190508153124.png');
INSERT INTO `news` VALUES ('3', '科协今天下午将在图书馆前召开大神学长面对面讲座，届时签到者都将有8学分', '学分来啦', '2019-05-03 03:50:42', '王五', '西安邮电大学', '6', 'C:/Users/13275/Documents/Uploads/ssm-demo/20190508153124.png');
INSERT INTO `news` VALUES ('4', '校青协将在今天下午，前往周边小学进行执教活动，请有兴趣的同学按时到来', '一起去当志愿者', '2019-05-03 04:50:47', '王五', '西安邮电大学', '6', 'C:/Users/13275/Documents/Uploads/ssm-demo/20190508153124.png');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `note_id` int(10) NOT NULL AUTO_INCREMENT,
  `note_title` varchar(100) DEFAULT NULL,
  `note_content` varchar(10000) DEFAULT NULL,
  `lab_id` int(100) DEFAULT NULL,
  `note_date` datetime DEFAULT NULL,
  `author_id` int(10) DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  `pic_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('1', '互联网+找队友', '我们已经做好大部分工作，现在需要一名懂财务的小伙伴加入我们', '4', '2019-05-01 10:00:00', '1', '张三', 'C:/Users/13275/Documents/Uploads/EZhao/QQ截图20190121154844.png');
INSERT INTO `note` VALUES ('4', '三创找队友', '我们什么都没做，求大腿带躺', '2', '2019-03-02 21:50:12', '1', '张三', 'C:/Users/13275/Documents/Uploads/EZhao/QQ截图20190121154844.png');
INSERT INTO `note` VALUES ('6', '工地招聘！', '招聘搬砖工，五险一金，996。。。', '3', '2019-05-05 22:18:28', '2', '李四', 'C:/Users/13275/Documents/Uploads/EZhao/QQ截图20190121154844.png');
INSERT INTO `note` VALUES ('7', '实验室纳新', '我们开始找人啦，要加入的小伙伴快来面试吧', '1', '2019-05-07 22:19:50', '3', '王五', 'C:/Users/13275/Documents/Uploads/EZhao/QQ截图20190121154844.png');
INSERT INTO `note` VALUES ('8', '水泥厂招聘', '五一了！来拉砖啊老弟，别犹豫了', '3', '2019-05-01 22:20:55', '1', '赵六', 'C:/Users/13275/Documents/Uploads/EZhao/QQ截图20190121154844.png');
INSERT INTO `note` VALUES ('10', '这还是一个测试', '哈哈哈哈哈', '4', '2019-05-04 02:23:15', '2', '李四', 'C:/Users/13275/Documents/Uploads/EZhao/QQ截图20190121154844.png');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rep_id` int(10) NOT NULL AUTO_INCREMENT,
  `rep_content` varchar(1000) DEFAULT NULL,
  `rep_date` datetime DEFAULT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  `to_com_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`rep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '小老弟你怎么这么皮？', '2020-01-02 01:02:03', '李七', '3');
INSERT INTO `reply` VALUES ('2', '都稳成什么了，来吧', '2019-05-06 23:45:35', '张三', '1');
INSERT INTO `reply` VALUES ('3', '一点都不稳，别去啊，来搬砖吧', '2019-05-05 23:46:36', '李四', '1');
INSERT INTO `reply` VALUES ('4', '你腿粗来我们水泥厂啊，不来浪费人才了', '2019-05-04 23:48:08', '赵六', '4');
INSERT INTO `reply` VALUES ('5', '对呀，去搬砖啊', '2019-05-05 01:01:29', '李七', '1');
INSERT INTO `reply` VALUES ('6', '哈哈哈哈哈哈,你真憨', '2019-05-03 01:08:17', '王五', '1');
INSERT INTO `reply` VALUES ('7', '你说什么', '2019-05-04 02:09:39', '老师', '2');
INSERT INTO `reply` VALUES ('8', '你去之日，就是塌方之时', '2019-05-08 18:20:33', '企业', '6');
INSERT INTO `reply` VALUES ('9', '哎，，是啊', '2019-05-04 02:43:05', '李四', '7');

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `res_id` int(10) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(100) DEFAULT NULL,
  `res_profession` varchar(10) DEFAULT NULL,
  `res_school` varchar(100) DEFAULT NULL,
  `res_phone` varchar(11) DEFAULT NULL,
  `res_address` varchar(100) DEFAULT NULL,
  `res_introduce` varchar(10000) DEFAULT NULL,
  `u_id` int(10) NOT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('1', '张散散', '信息对抗', '西安邮电大学', '12345678901', null, '我是张散散，我热爱学习', '1');
INSERT INTO `resume` VALUES ('2', '李丝丝', '通信工程', '西安邮电大学', '12345678902', null, '我是李丝丝，我热爱体育', '2');
INSERT INTO `resume` VALUES ('3', '王五五', '信息安全', '西安邮电大学', '12345678903', null, '我是王五五，我热爱编程', '3');
INSERT INTO `resume` VALUES ('4', '赵六六', '信息工程', '西安邮电大学', '12345678904', null, '我是赵六六，我喜欢睡觉', '4');
INSERT INTO `resume` VALUES ('5', '李琪琪', '信息对抗', '西安邮电大学', '12345678901', null, '我是李琪琪，我爱玩游戏', '5');
INSERT INTO `resume` VALUES ('6', '实验室', null, '西安邮电大学', null, '图书馆1楼', '本实验室专注于web开发，兼带机器学习与服务器开发', '6');
INSERT INTO `resume` VALUES ('7', '老师', '人工智能', '西安邮电大学', '12345678907', null, '我潜心于研究人工智能，对这方面感兴趣的同学可以联系我', '7');
INSERT INTO `resume` VALUES ('8', '企业', null, null, '12345678908', '智慧国际', '我们有着深厚的企业文化底蕴，期待你们的加入', '8');
INSERT INTO `resume` VALUES ('9', '策士', '搬砖', '蓝翔', '12345678909', '中国', '我很熟啊', '9');
INSERT INTO `resume` VALUES ('10', null, null, null, null, null, null, '10');
INSERT INTO `resume` VALUES ('11', null, null, null, null, null, null, '10');
INSERT INTO `resume` VALUES ('12', null, null, null, null, null, null, '11');
INSERT INTO `resume` VALUES ('13', null, null, null, null, null, null, '12');
INSERT INTO `resume` VALUES ('14', null, null, null, null, null, null, '13');
INSERT INTO `resume` VALUES ('15', null, null, null, null, null, null, '9');
INSERT INTO `resume` VALUES ('16', null, null, null, null, null, null, '14');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(10) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(100) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三');
INSERT INTO `user` VALUES ('2', '李四');
INSERT INTO `user` VALUES ('3', '王五');
INSERT INTO `user` VALUES ('4', '赵六');
INSERT INTO `user` VALUES ('5', '李七');
INSERT INTO `user` VALUES ('6', '实验室');
INSERT INTO `user` VALUES ('7', '老师');
INSERT INTO `user` VALUES ('8', '企业');
INSERT INTO `user` VALUES ('9', '测试');
INSERT INTO `user` VALUES ('11', '\"ehiqi\"');
INSERT INTO `user` VALUES ('12', '\"qjioeqio\"');
INSERT INTO `user` VALUES ('13', 'hhhh');
INSERT INTO `user` VALUES ('14', '再次测试');
