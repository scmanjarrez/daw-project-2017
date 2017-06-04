-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `url` varchar(100) NOT NULL,
  `description` varchar(400) DEFAULT NULL,
  `year` date DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `cast` varchar(400) DEFAULT NULL,
  `cover` varchar(100) DEFAULT NULL,
  `rating` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `url_UNIQUE` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Average man','https://www.youtube.com/watch?v=TuP1chV24jo','Movie about a man, who is an average man. Average.','1000-01-01','Average director','Average people','https://cdn.shopify.com/s/files/1/1115/4498/t/2/assets/average-logo-black.png',3),(3,'Movie 1','https://www.youtube.com/watch?v=yqr1BnpY628','Description about a movie. This description describes the main argument of a random movie.','9999-01-01','Average director','Average people','https://cdn.shopify.com/s/files/1/1115/4498/t/2/assets/average-logo-black.png',3),(4,'Goodbye Lenin','https://www.youtube.com/watch?v=P1CyPjQQTAM','Movie about DDR. Must watch.','1991-01-01','Lenin','Not Lenin','http://www.biografiasyvidas.com/biografia/s/fotos/stalin.jpg',5),(5,'Letters From Iwo Jima','https://www.youtube.com/watch?v=jVwjRC6Ncto','Segunda Guerra Mundial (1939-1945). Rodada íntegramente en japonés, la película ofrece la versión nipona de la batalla de Iwo Jima, el episodio más cruento de la guerra del Pacífico, en el que murieron más de 20.000 japoneses y 7.000 estadounidenses.','2006-01-01','Clint Eastwood','Ken Watanabe,  Kazunari Ninomiya,  Tsuyoshi Ihara,  Ryô Kase,  Shido Nakamura, Yuki Matsuzaki,  Takumi Bando,  Hiroshi Watanabe,  Nae,  Takashi Yamaguchi, Eijiro Ozaki,  Toshi Toda,  Sonny Saito,  Toshiya Agata,  Ken Kensei,  Ikuma Ando','http://pics.filmaffinity.com/letters_from_iwo_jima-293058340-large.jpg',5),(6,'Otoko-tachi no Yamato','https://www.youtube.com/watch?v=BA2bEXTnigc','On April, 6th 2005, in Makurazi, Kagoshima, Makiko Uchida seeks a boat in the local fishing cooperative to take her to the latitude N30, longitude L128, where the largest, heaviest and most powerfully armed battleships ever constructed Yamato was sunk on April, 7th 1945; however, her request is denied.','2006-01-01','Junya Sato',' Takashi Sorimachi, Shidô Nakamura, Yû Aoi','https://www.cinematerial.com/media/posters/md/7n/7n6biouq.jpg',5);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `name` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `permissions` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`name`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin','admin@mail.com',1),('admin2','admin2','admin2@mail.com',1),('user1','pass','user1@mail.com',0),('user2','pass','user2@mail.com',0),('user3','pass','user3@mail.com',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-12  5:05:58
