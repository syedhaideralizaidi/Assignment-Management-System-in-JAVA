CREATE TABLE `announcement` (
  `a_id` int NOT NULL AUTO_INCREMENT,
  `announcement` text,
  `member_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
);

CREATE TABLE `members` (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `member_name` varchar(30) DEFAULT NULL,
  `username` varchar(40) NOT NULL,
  `dob` date DEFAULT NULL,
  `passwords` varchar(40) NOT NULL,
  PRIMARY KEY (`m_id`)
);

CREATE TABLE `project` (
  `projName` varchar(255) DEFAULT NULL,
  `projDeadline` varchar(255) DEFAULT NULL,
  `projDesc` varchar(255) DEFAULT NULL,
  `proj_ID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`proj_ID`)
);

CREATE TABLE `tasks` (
  `taskName` varchar(255) NOT NULL,
  `taskDeadline` date NOT NULL,
  `taskDesc` varchar(255) DEFAULT NULL,
  `task_ID` int NOT NULL AUTO_INCREMENT,
  `m_id` int DEFAULT NULL,
  `member_name` varchar(30) NOT NULL,
  `proj_name` varchar(255) NOT NULL,
  `proj_ID` int DEFAULT NULL,
  PRIMARY KEY (`task_ID`),
  KEY `m_id` (`m_id`),
  KEY `proj_fk` (`proj_ID`),
  CONSTRAINT `proj_fk` FOREIGN KEY (`proj_ID`) REFERENCES `project` (`proj_ID`),
  CONSTRAINT `tasks_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `members` (`m_id`)
);

CREATE TABLE `team` (
  `m_id` int NOT NULL,
  `L_id` int NOT NULL,
  `proj_ID` int DEFAULT NULL,
  KEY `FK_Lid` (`L_id`),
  KEY `m_id` (`m_id`),
  KEY `p_fk` (`proj_ID`),
  CONSTRAINT `FK_Lid` FOREIGN KEY (`L_id`) REFERENCES `teamleader` (`L_id`),
  CONSTRAINT `p_fk` FOREIGN KEY (`proj_ID`) REFERENCES `project` (`proj_ID`),
  CONSTRAINT `team_ibfk_1` FOREIGN KEY (`m_id`) REFERENCES `members` (`m_id`)
);

CREATE TABLE `teamleader` (
  `L_id` int NOT NULL AUTO_INCREMENT,
  `m_id` int DEFAULT NULL,
  `proj_ID` int DEFAULT NULL,
  PRIMARY KEY (`L_id`),
  KEY `FK_m_id` (`m_id`),
  KEY `p_l_fk` (`proj_ID`),
  CONSTRAINT `FK_m_id` FOREIGN KEY (`m_id`) REFERENCES `members` (`m_id`),
  CONSTRAINT `p_l_fk` FOREIGN KEY (`proj_ID`) REFERENCES `project` (`proj_ID`)
);