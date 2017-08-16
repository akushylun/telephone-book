
Web application "Phone Book"

Technologies: Spring Boot, Spring Security, Spring Mvc, Spring data, MySQL, Mongo, JUnit, Mockito, JQuery, Bootstrap, Maven, 



--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `u_username` varchar(45) NOT NULL,
  `u_password` varchar(45) NOT NULL,
  `u_full_name` varchar(45) NOT NULL,
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_username_UNIQUE` (`u_username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `r_surname` varchar(45) NOT NULL,
  `r_name` varchar(45) NOT NULL,
  `r_middle_name` varchar(45) NOT NULL,
  `r_mobile_tel` varchar(45) NOT NULL,
  `r_home_tel` varchar(45) DEFAULT NULL,
  `r_address` varchar(45) DEFAULT NULL,
  `r_email` varchar(45) DEFAULT NULL,
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_user_id` int(11) NOT NULL,
  PRIMARY KEY (`r_id`),
  KEY `fk_user_id_idx` (`r_user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`r_user_id`) REFERENCES `person` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
