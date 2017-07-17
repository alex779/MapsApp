CREATE TABLE `City` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Location` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Location_UNIQUE` (`Location`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

CREATE TABLE `Road` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Location1` int(11) NOT NULL,
  `Location2` int(11) NOT NULL,
  `City_id` int(11) NOT NULL,
  `City_id1` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Road_City_idx` (`City_id`),
  KEY `fk_Road_City1_idx` (`City_id1`),
  CONSTRAINT `fk_Road_City` FOREIGN KEY (`City_id`) REFERENCES `City` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Road_City1` FOREIGN KEY (`City_id1`) REFERENCES `City` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT 'someuser',
  `email` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role_user` enum('ROLE_USER','ROLE_ADMIN') NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;