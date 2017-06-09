-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: videoclub
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cast` varchar(255) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `rating` float NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `url` varchar(2000) DEFAULT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,NULL,'https://image.tmdb.org/t/p/w300/inVq3FRqcYIRl2la8iZikYYxFNR.jpg','Based upon Marvel Comics’ most unconventional anti-hero, DEADPOOL tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.',NULL,7.3,'DeadPool','https://www.youtube.com/embed/FyKWUTwSYAs',2016),(2,NULL,'https://image.tmdb.org/t/p/w300/fGn85pj0Ti4vajiTPZZA8xaNLvz.jpg','Hamlet, Prince of Denmark, finds out that his uncle Claudius killed his father to obtain the throne, and plans revenge.',NULL,6.6,'Hamlet','https://www.youtube.com/embed/-rd74Gniz-A',1990),(3,NULL,'https://image.tmdb.org/t/p/w300/seWQ6UKCrhGH0eP7dFZvmIBQtKF.jpg','When Gerda Wegener asks her husband Einar to fill in as a portrait model, Einar discovers the person she\'s meant to be and begins living her life as Lili Elbe. Having realized her true self and with Gerda\'s love and support, Lili embarks on a groundbreaking journey as a transgender pioneer.',NULL,7.3,'La chica danesa','https://www.youtube.com/embed/ENiuBpdrnZ8',2015),(4,NULL,'https://image.tmdb.org/t/p/w300/nWJJqOryTQOmVXvKUkLcEETUHgT.jpg','The story of the battle of Iwo Jima between the United States and Imperial Japan during World War II, as told from the perspective of the Japanese who fought it.',NULL,7.2,'Letters From Iwo Jima','https://www.youtube.com/embed/51lo2dpaZ_g',2006),(5,NULL,'https://image.tmdb.org/t/p/w300/tcC9vMOACPmznLvH9AJ3jv4cBhT.jpg','Directed by Junya Sato and based on a book by Jun Henmi, \"Yamato\" has a framing story set in the present day and uses flashbacks to tell the story of the crew of the World War II Japanese battleship Yamato. The film was never released in the United States, where reviewers who have seen it have compared the military epic to \"Titanic\" and \"Saving Private Ryan.\"',NULL,5.6,'Otoko-tachi no Yamato','https://www.youtube.com/embed/q4QWqDTCk2A',2005),(6,NULL,'https://image.tmdb.org/t/p/w300/ewVHnq4lUiovxBCu64qxq5bT2lu.jpg','Bound for a remote planet on the far side of the galaxy, the crew of the colony ship Covenant discovers what they think is an uncharted paradise, but is actually a dark, dangerous world — whose sole inhabitant is the “synthetic” David, survivor of the doomed Prometheus expedition.',NULL,6,'Alien: Covenant','https://www.youtube.com/embed/svnAD0TApb8',2017),(7,NULL,'https://image.tmdb.org/t/p/w300/xbpSDU3p7YUGlu9Mr6Egg2Vweto.jpg','Captain Jack Sparrow is pursued by an old rival, Captain Salazar, who along with his crew of ghost pirates has escaped from the Devil\'s Triangle, and is determined to kill every pirate at sea. Jack seeks the Trident of Poseidon, a powerful artifact that grants its possessor total control over the seas, in order to defeat Salazar.',NULL,6.5,'Piratas del Caribe 5','https://www.youtube.com/embed/IPf4rGw3XHw',2017),(8,NULL,'https://image.tmdb.org/t/p/w300/y4MBh0EjBlMuOzv9axM4qJlmhzz.jpg','The Guardians must fight to keep their newfound family together as they unravel the mysteries of Peter Quill\'s true parentage.',NULL,7.6,'Guardianes de la Galaxia 2','https://www.youtube.com/embed/12gvJgLE4us',2017),(9,NULL,'https://image.tmdb.org/t/p/w300/1SwAVYpuLj8KsHxllTF8Dt9dSSX.jpg','Chris and his girlfriend Rose go upstate to visit her parents for the weekend. At first, Chris reads the family\'s overly accommodating behavior as nervous attempts to deal with their daughter\'s interracial relationship, but as the weekend progresses, a series of increasingly disturbing discoveries lead him to a truth that he never could have imagined.',NULL,7.1,'Déjame salir','https://www.youtube.com/embed/X-tg05cAVwE',2017),(10,NULL,'https://image.tmdb.org/t/p/w300/iNpz2DgTsTMPaDRZq2tnbqjL2vF.jpg','When a mysterious woman seduces Dom into the world of crime and a betrayal of those closest to him, the crew face trials that will test them as never before.',NULL,6.7,'Fast & Furious 8','https://www.youtube.com/embed/uisBaTkQAEs',2017);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','admin@admin.com','$2a$10$3dxC3k4cJVH1TDdyYZ2x7OCq5gjyhzPivGmqxmMEI6hGb1htwT1H.'),('user','user@user.com','$2a$10$eCKlwaeB..9sZsCyY21jHuCyU1mJbyRMel84beQ/0V7cBllCn9JKW');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_username` varchar(255) NOT NULL,
  `roles` tinyblob,
  KEY `FK1misndtpfm9hx3ttvixdus8d1` (`user_username`),
  CONSTRAINT `FK1misndtpfm9hx3ttvixdus8d1` FOREIGN KEY (`user_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('admin','�\�\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0�\0L\0rolet\0Ljava/lang/String;xpt\0\nROLE_ADMIN'),('user','�\�\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0�\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-04 17:33:56
