/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50173
Source Host           : 127.0.0.1:3306
Source Database       : griefgrocerystore

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-10-17 13:17:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `dailyID` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  `useredID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '20170915211628229', '我天', '2017-09-18 09:40:23', '639478920');
INSERT INTO `comment` VALUES ('3', '20170915211628229', '外网  我', '2017-09-18 10:44:26', '7fee5b4c1');
INSERT INTO `comment` VALUES ('4', '20170915211628229', '啊', '2017-09-18 10:45:31', '7fee5b4c1');
INSERT INTO `comment` VALUES ('5', '20170915211607980', 'wee', '2017-09-18 10:48:25', '7fee5b4c1');
INSERT INTO `comment` VALUES ('6', '20170915211628229', '我了个靠', '2017-09-18 10:55:11', '7fee5b4c1');
INSERT INTO `comment` VALUES ('7', '20170915211628229', ' 我', '2017-09-18 11:04:57', '7fee5b4c1');
INSERT INTO `comment` VALUES ('8', '20170915211628229', '呜呜呜呜', '2017-09-18 11:05:09', '7fee5b4c1');
INSERT INTO `comment` VALUES ('9', '20170915211628229', '呜呜呜呜我我我娃娃', '2017-09-18 11:05:31', '7fee5b4c1');
INSERT INTO `comment` VALUES ('10', '20170915211628229', '我爱的人', '2017-09-18 11:38:17', '7fee5b4c1');
INSERT INTO `comment` VALUES ('11', '20170915211628229', '我我我', '2017-09-18 11:39:12', '7fee5b4c1');
INSERT INTO `comment` VALUES ('12', '20170915211628229', '我我我的', '2017-09-18 11:39:19', '7fee5b4c1');
INSERT INTO `comment` VALUES ('13', '20170915211628229', 'w ', '2017-09-18 11:46:39', '7fee5b4c1');
INSERT INTO `comment` VALUES ('14', '20170915211628229', 'W ', '2017-09-18 18:20:07', '7fee5b4c1');
INSERT INTO `comment` VALUES ('15', '20170915211628229', 'WE', '2017-09-18 18:20:39', '7fee5b4c1');
INSERT INTO `comment` VALUES ('16', '20170915211628229', 'FW', '2017-09-18 18:21:31', '7fee5b4c1');
INSERT INTO `comment` VALUES ('17', '20170915170822160', '好漂亮！！！', '2017-09-18 18:33:17', '639478920');
INSERT INTO `comment` VALUES ('20', '20170915211628229', '阿斯蒂芬', '2017-09-18 18:46:57', '639478920');
INSERT INTO `comment` VALUES ('21', '20170915211628229', 'fasd', '2017-09-18 22:45:12', '639478920');
INSERT INTO `comment` VALUES ('22', '20170915211628229', 'wef', '2017-09-18 22:45:16', '639478920');
INSERT INTO `comment` VALUES ('23', '20170918225438555', '我我 ', '2017-09-18 22:54:52', '639478920');
INSERT INTO `comment` VALUES ('24', '20170919165816633', '好看', '2017-09-19 18:35:40', '639478920');
INSERT INTO `comment` VALUES ('25', '20170919165816633', '好看', '2017-09-19 18:35:42', '639478920');
INSERT INTO `comment` VALUES ('26', '20170915211628229', '去去', '2017-09-19 18:36:41', '639478920');
INSERT INTO `comment` VALUES ('27', '20170915211628229', '我的天\n', '2017-09-19 18:36:53', '639478920');
INSERT INTO `comment` VALUES ('28', '20170919165816633', '我啊', '2017-09-19 18:37:12', '639478920');
INSERT INTO `comment` VALUES ('29', '20170919152856269', '分', '2017-09-19 18:37:21', '639478920');
INSERT INTO `comment` VALUES ('30', '20170919184027253', '分', '2017-09-19 19:13:23', '639478920');
INSERT INTO `comment` VALUES ('31', '20170919165816633', '我', '2017-09-19 19:13:28', '639478920');
INSERT INTO `comment` VALUES ('32', '20170919184027253', 'w ', '2017-09-19 20:26:42', '639478920');
INSERT INTO `comment` VALUES ('33', '20170919223724535', '545', '2017-09-22 15:23:27', '639478920');
INSERT INTO `comment` VALUES ('34', '20170919184027253', '16', '2017-09-22 15:23:34', '639478920');
INSERT INTO `comment` VALUES ('35', '20170919184027253', '516', '2017-09-22 15:23:41', '639478920');
INSERT INTO `comment` VALUES ('36', '20170922160109281', 'f ', '2017-09-22 17:27:38', '639478920');
INSERT INTO `comment` VALUES ('37', '20170922160109281', 'fsa ', '2017-09-22 17:29:03', '639478920');
INSERT INTO `comment` VALUES ('38', '20170922160109281', 'asdf ', '2017-09-22 17:29:06', '639478920');

-- ----------------------------
-- Table structure for daily
-- ----------------------------
DROP TABLE IF EXISTS `daily`;
CREATE TABLE `daily` (
  `ID` varchar(20) NOT NULL,
  `userID` varchar(255) DEFAULT NULL,
  `contentType` int(11) DEFAULT NULL COMMENT '1--一般说说  2--图片说说   3--文章',
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `pictureID` varchar(255) DEFAULT NULL,
  `releaseTime` datetime DEFAULT NULL,
  `musicSrc` varchar(255) DEFAULT NULL,
  `loved` int(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daily
-- ----------------------------
INSERT INTO `daily` VALUES ('1', '639478920', '2', '3', '4', '20170915160214871', '2017-09-11 00:00:00', null, '1');
INSERT INTO `daily` VALUES ('2', '639478920', '3', 'dfa', 'dadf', 'adf', '2017-09-11 18:36:56', null, null);
INSERT INTO `daily` VALUES ('20170914001456821', '639478920', '2', null, '', '20170914001406930', '2017-09-14 00:14:56', null, null);
INSERT INTO `daily` VALUES ('20170914001456823', '639478920', '2', null, '', '20170915165020192', '2017-09-15 16:50:39', null, '1');
INSERT INTO `daily` VALUES ('20170914001456825', '639478920', '2', null, '', '20170915161352294', '2017-09-15 17:02:12', null, '2');
INSERT INTO `daily` VALUES ('20170914001456828', '639478920', '2', null, '女神', '20170915164040929', '2017-09-15 17:02:12', null, null);
INSERT INTO `daily` VALUES ('2017091400145683', '639478920', '2', null, '', '20170915163642127', '2017-09-15 16:50:39', null, '3');
INSERT INTO `daily` VALUES ('20170914001726461', '639478920', '2', null, '', '20170915164040929', '2017-09-14 00:17:26', null, '4');
INSERT INTO `daily` VALUES ('20170914001726467', '639478920', '2', null, '', '20170914001724459', '2017-09-14 00:17:26', null, '2');
INSERT INTO `daily` VALUES ('20170915165919651', '639478920', '2', null, '', '20170915165918068', '2017-09-15 16:59:19', null, null);
INSERT INTO `daily` VALUES ('20170915165919655', '639478920', '2', null, '', '20170915163335931', '2017-09-15 16:59:19', null, '2');
INSERT INTO `daily` VALUES ('20170915170104056', '639478920', '2', null, '', '20170915163642127', '2017-09-15 17:01:04', null, '2');
INSERT INTO `daily` VALUES ('20170915170104057', '639478920', '2', null, '', '20170915162844118', '2017-09-15 17:01:04', null, null);
INSERT INTO `daily` VALUES ('20170915170822160', '639478920', '2', null, '女神', '20170915163335931', '2017-09-15 17:08:22', null, '8');
INSERT INTO `daily` VALUES ('20170915170822162', '639478920', '2', null, '', '20170915160900594', '2017-09-15 17:08:22', null, '3');
INSERT INTO `daily` VALUES ('20170915204032375', '639478920', '1', null, '<p>我啊啊啊</p>', null, '2017-09-15 20:40:32', null, null);
INSERT INTO `daily` VALUES ('20170915204906680', 'rig4343434', '1', null, '<p>我是大大的美女</p><p>&nbsp;</p>', null, '2017-09-15 20:49:06', null, null);
INSERT INTO `daily` VALUES ('20170915210004601', 'rig4343434', '1', null, '<p>我大大</p>', null, '2017-09-15 21:00:04', null, '3');
INSERT INTO `daily` VALUES ('20170915211528988', 'dafag434d', '3', '我', '<p>我</p>', null, '2017-09-15 21:15:28', null, '3');
INSERT INTO `daily` VALUES ('20170915211607980', 'rig4343434', '3', '我打', '<p>我</p>', null, '2017-09-15 21:16:07', null, '3');
INSERT INTO `daily` VALUES ('20170915211628229', 'rig4343434', '3', '我', '<p>我打</p>', null, '2017-09-15 21:16:28', null, '19');
INSERT INTO `daily` VALUES ('20170918225438555', '639478920', '2', null, '外网', '20170915164320619', '2017-09-18 22:54:38', null, '8');
INSERT INTO `daily` VALUES ('20170919152759022', 'rig4343434', '2', null, '哼哼', '20170919152756684', '2017-09-19 15:27:59', null, '1');
INSERT INTO `daily` VALUES ('20170919152827214', 'rig4343434', '2', null, '', '20170919152825844', '2017-09-19 15:28:27', null, '1');
INSERT INTO `daily` VALUES ('20170919152856269', 'rig4343434', '2', null, '', '20170919152854529', '2017-09-19 15:28:56', null, '5');
INSERT INTO `daily` VALUES ('20170919165816633', '639478920', '2', null, '', '20170919165815309', '2017-09-19 16:58:16', null, '2');
INSERT INTO `daily` VALUES ('20170919184027253', '639478920', '2', null, '', '20170919184020829', '2017-09-19 18:40:27', null, '6');
INSERT INTO `daily` VALUES ('20170919223724535', '639478920', '2', null, '', '20170919223723676', '2017-09-19 22:37:24', null, '3');
INSERT INTO `daily` VALUES ('20170922160109281', '639478920', '2', null, '我', '20170922160108296', '2017-09-22 16:01:09', null, '2');
INSERT INTO `daily` VALUES ('20170922172939534', '639478920', '1', null, '<p>威风威风</p>', null, '2017-09-22 17:29:39', null, '0');
INSERT INTO `daily` VALUES ('20170922173005139', '639478920', '2', null, '2 22 ', '20170922173003979', '2017-09-22 17:30:05', null, '0');

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `ID` varchar(20) NOT NULL,
  `userID` varchar(255) DEFAULT NULL,
  `friendID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('1', '639478920', 'rig4343434');
INSERT INTO `friend` VALUES ('2', '639478920', 'dafag434d');
INSERT INTO `friend` VALUES ('20170919153106181', 'rig4343434', '639478920');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `ID` varchar(20) NOT NULL,
  `pictureName` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `userID` varchar(255) DEFAULT NULL,
  `pulishTime` datetime DEFAULT NULL,
  `state` int(255) DEFAULT NULL COMMENT '1--待审核 2--通过  3--不通过',
  `picDescribe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', '1', '20170913234657927.jpeg', '639478920', '2017-09-14 00:00:00', '2', '1');
INSERT INTO `picture` VALUES ('20170913234657917', 'loginbackImg.jpeg', '20170913234657927.jpeg', '639478920', '2017-09-13 23:46:57', '1', null);
INSERT INTO `picture` VALUES ('20170913235416015', 'jiantou.gif', '20170913235416744.gif', '639478920', '2017-09-13 23:54:16', '1', null);
INSERT INTO `picture` VALUES ('20170914001406930', 'zhangwanqing.jpg', '2017091400140665.jpg', '639478920', '2017-09-14 00:14:06', '1', null);
INSERT INTO `picture` VALUES ('20170914001724459', 'zhangwanqing.jpg', '2017091400172491.jpg', '639478920', '2017-09-14 00:17:24', '1', null);
INSERT INTO `picture` VALUES ('20170914001931832', 'zhangwanqing.jpg', '20170914001931132.jpg', '639478920', '2017-09-14 00:19:31', '1', null);
INSERT INTO `picture` VALUES ('20170915141913397', 'header.jpg', '20170915141913518.jpg', '639478920', '2017-09-15 14:19:13', '1', null);
INSERT INTO `picture` VALUES ('20170915151101828', 'header.jpg', '20170915151101455.jpg', '639478920', '2017-09-15 15:11:01', '1', null);
INSERT INTO `picture` VALUES ('20170915151153914', 'header.jpg', '20170915151153503.jpg', '639478920', '2017-09-15 15:11:53', '1', null);
INSERT INTO `picture` VALUES ('20170915154201319', 'timg.jpg', '20170915154201978.jpg', '639478920', '2017-09-15 15:42:01', '1', null);
INSERT INTO `picture` VALUES ('20170915154314726', 'j1_dt_bg1.png', '20170915154314635.png', '639478920', '2017-09-15 15:43:14', '1', null);
INSERT INTO `picture` VALUES ('20170915160214871', 'header.jpg', '20170915160214811.jpg', '639478920', '2017-09-15 16:02:14', '1', null);
INSERT INTO `picture` VALUES ('20170915160900594', 'header.jpg', '20170915160900967.jpg', '639478920', '2017-09-15 16:09:00', '1', null);
INSERT INTO `picture` VALUES ('20170915161352294', 'header.jpg', '20170915161352460.jpg', '639478920', '2017-09-15 16:13:52', '1', null);
INSERT INTO `picture` VALUES ('20170915162844118', 'zhangwanqing.jpg', '20170915162844986.jpg', '639478920', '2017-09-15 16:28:44', '1', null);
INSERT INTO `picture` VALUES ('20170915163335931', 'zhangwanqing.jpg', '20170915163335491.jpg', '639478920', '2017-09-15 16:33:35', '1', null);
INSERT INTO `picture` VALUES ('20170915163642127', 'zhangwanqing.jpg', '20170915163642945.jpg', '639478920', '2017-09-15 16:36:42', '1', null);
INSERT INTO `picture` VALUES ('20170915164040929', 'zhangwanqing.jpg', '20170915164040855.jpg', '639478920', '2017-09-15 16:40:40', '1', null);
INSERT INTO `picture` VALUES ('20170915164320619', 'zhangwanqing.jpg', '20170915164320852.jpg', '639478920', '2017-09-15 16:43:20', '1', null);
INSERT INTO `picture` VALUES ('20170915165020192', 'zhangwanqing.jpg', '20170915165020314.jpg', '639478920', '2017-09-15 16:50:20', '1', null);
INSERT INTO `picture` VALUES ('20170915165918068', 'zhangwanqing.jpg', '20170915165918291.jpg', '639478920', '2017-09-15 16:59:18', '1', null);
INSERT INTO `picture` VALUES ('20170915170101949', 'zhangwanqing.jpg', '20170915170101122.jpg', '639478920', '2017-09-15 17:01:01', '1', null);
INSERT INTO `picture` VALUES ('20170915170211720', 'zhangwanqing.jpg', '20170915170211310.jpg', '639478920', '2017-09-15 17:02:11', '1', null);
INSERT INTO `picture` VALUES ('20170915170820108', 'zhangwanqing.jpg', '20170915170820157.jpg', '639478920', '2017-09-15 17:08:20', '1', null);
INSERT INTO `picture` VALUES ('20170918225435404', '2017091400140665.jpg', '20170918225435721.jpg', '639478920', '2017-09-18 22:54:35', '1', null);
INSERT INTO `picture` VALUES ('20170919152756684', '20170915154201978.jpg', '20170919152756286.jpg', 'rig4343434', '2017-09-19 15:27:56', '1', null);
INSERT INTO `picture` VALUES ('20170919152825844', '20170915151101455.jpg', '20170919152825534.jpg', 'rig4343434', '2017-09-19 15:28:25', '1', null);
INSERT INTO `picture` VALUES ('20170919152854529', '20170915164040855.jpg', '20170919152854498.jpg', 'rig4343434', '2017-09-19 15:28:54', '1', null);
INSERT INTO `picture` VALUES ('20170919163704009', '20170915154314635.png', '20170919163704301.png', 'dafag434d', '2017-09-19 16:37:04', '1', null);
INSERT INTO `picture` VALUES ('20170919164211490', '20170915151153503.jpg', '20170919164211890.jpg', 'dafag434d', '2017-09-19 16:42:11', '1', null);
INSERT INTO `picture` VALUES ('20170919165815309', '20170914001931132.jpg', '20170919165815172.jpg', '639478920', '2017-09-19 16:58:15', '1', null);
INSERT INTO `picture` VALUES ('20170919170559339', '2017091400172491.jpg', '20170919170559927.jpg', '639478920', '2017-09-19 17:05:59', '1', null);
INSERT INTO `picture` VALUES ('20170919170833108', '2017091400172491.jpg', '20170919170833607.jpg', '639478920', '2017-09-19 17:08:33', '1', null);
INSERT INTO `picture` VALUES ('20170919171018505', '20170915151101455.jpg', '20170919171018242.jpg', '639478920', '2017-09-19 17:10:18', '1', null);
INSERT INTO `picture` VALUES ('20170919171129723', '20170915141913518.jpg', '20170919171129176.jpg', '639478920', '2017-09-19 17:11:29', '1', null);
INSERT INTO `picture` VALUES ('20170919171648634', '20170915161352460.jpg', '20170919171648413.jpg', '639478920', '2017-09-19 17:16:48', '1', null);
INSERT INTO `picture` VALUES ('20170919171829505', '20170915151101455.jpg', '2017091917182978.jpg', '639478920', '2017-09-19 17:18:29', '1', null);
INSERT INTO `picture` VALUES ('20170919171853769', '20170915141913518.jpg', '20170919171853914.jpg', '639478920', '2017-09-19 17:18:53', '1', null);
INSERT INTO `picture` VALUES ('20170919172039040', '20170915154201978.jpg', '20170919172039510.jpg', '639478920', '2017-09-19 17:20:39', '1', null);
INSERT INTO `picture` VALUES ('20170919184020829', '20170914001931132.jpg', '20170919184020414.jpg', '639478920', '2017-09-19 18:40:20', '1', null);
INSERT INTO `picture` VALUES ('20170919185243984', 'user04.png', '20170919185243764.png', '639478920', '2017-09-19 18:52:43', '1', null);
INSERT INTO `picture` VALUES ('20170919190838924', 'user05.png', '20170919190838655.png', '1', '2017-09-19 19:08:38', '1', null);
INSERT INTO `picture` VALUES ('20170919190915252', 'user07.png', '20170919190915670.png', '1', '2017-09-19 19:09:15', '1', null);
INSERT INTO `picture` VALUES ('20170919191031270', 'user06.png', '2017091919103169.png', '1', '2017-09-19 19:10:31', '1', null);
INSERT INTO `picture` VALUES ('20170919192020555', 'user03.png', '20170919192020867.png', '639478920', '2017-09-19 19:20:20', '1', null);
INSERT INTO `picture` VALUES ('20170919192117860', 'user03.png', '20170919192117100.png', '639478920', '2017-09-19 19:21:17', '1', null);
INSERT INTO `picture` VALUES ('20170919195017988', 'user06.png', '20170919195017472.png', '639478920', '2017-09-19 19:50:17', '1', null);
INSERT INTO `picture` VALUES ('20170919195115394', 'user03.png', '2017091919511518.png', '639478920', '2017-09-19 19:51:15', '1', null);
INSERT INTO `picture` VALUES ('20170919195630196', 'user07.png', '20170919195630483.png', '639478920', '2017-09-19 19:56:30', '1', null);
INSERT INTO `picture` VALUES ('20170919223723676', '20170915151153503.jpg', '20170919223723975.jpg', '639478920', '2017-09-19 22:37:23', '1', null);
INSERT INTO `picture` VALUES ('20170922160108296', '20170915162844986.jpg', '20170922160108271.jpg', '639478920', '2017-09-22 16:01:08', '1', null);
INSERT INTO `picture` VALUES ('20170922173003979', '20170915141913518.jpg', '20170922173003347.jpg', '639478920', '2017-09-22 17:30:03', '1', null);
INSERT INTO `picture` VALUES ('5', '头像1', 'backstage/assets/img/a1.png', '639478920', '2017-09-06 00:00:00', '1', '不同于其它的主流编程语言，JavaScript的构造函数并不是作为类的一个特定方法存在的；当任意一个普通函数用于创建一类对象时，它就被称作构造函数，或构造器。一个函数要作为一个真正意义上的构造函数，需要满足下列条件：\r\n\r\n1、 在函数内部对新对象（this）的属性进行设置，通常是添加属性和方法。\r\n\r\n2、 构造函数可以包含返回语句（不推荐），但返回值必须是this，或者');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` varchar(255) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `type` int(255) DEFAULT NULL COMMENT '1--管理员  2--用户',
  `headImg` varchar(255) DEFAULT NULL,
  `registerTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '639478920', '永无岛', '2', '1452754335@qq.com', '1', 'http://127.0.0.1:8080/image/20170919192117100.png', '2017-09-08 00:00:00');
INSERT INTO `user` VALUES ('13', '7fee5b4c1', '许中鹏', '333', 'xuhenao@qq.com', '1', 'module/img/touxiang/user01.png', '2017-09-13 00:00:00');
INSERT INTO `user` VALUES ('14', '3oiajfsadjfl', '付建飞', '111', 'fujianfei@qq.com', '2', 'module/img/touxiang/user02.png', '2017-09-13 09:44:36');
INSERT INTO `user` VALUES ('15', 'rig4343434', '一路向北', '23', 'wnn@outlook.com', '1', 'module/img/touxiang/user02.png', '2017-09-13 09:45:16');
INSERT INTO `user` VALUES ('16', 'dafag434d', '苏亚宁', '3', 'suyaning@qq.com', '1', 'module/img/touxiang/user02.png', '2017-09-13 09:46:14');
INSERT INTO `user` VALUES ('17', 'gd34fag43', '永无岛', '1', 'yongwudao@163.com', '1', 'module/img/touxiang/user02.png', '2017-09-13 09:46:47');
