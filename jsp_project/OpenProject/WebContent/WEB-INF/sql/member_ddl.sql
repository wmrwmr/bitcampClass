CREATE TABLE `project`.`member` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `photo` varchar(100) COLLATE utf8_bin DEFAULT 'starwars.png',
  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idx`),
  UNIQUE KEY `id_UNIQUE` (`userid`)
);