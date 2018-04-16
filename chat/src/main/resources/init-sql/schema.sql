SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `boot_user`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `permission` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boot_user
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'klay', '13799008800','15215cdfdc1766360e8ab8c271753a88','admin','edit,view' , '2016-06-27 00:01:39');
INSERT INTO `user_info` VALUES ('2', 'Tome', '18988991234','Tome','admin','edit,view' , '2016-06-27 00:35:28');
