-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: disney_api_data
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `audiovisual_productions`
--

DROP TABLE IF EXISTS `audiovisual_productions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audiovisual_productions` (
  `audiovisual_production_id` int NOT NULL AUTO_INCREMENT,
  `image` text NOT NULL,
  `title` varchar(100) NOT NULL,
  `release_date` date NOT NULL,
  `score` double NOT NULL,
  `fk_genre_id` int NOT NULL,
  PRIMARY KEY (`audiovisual_production_id`),
  KEY `fk_genre_idx` (`fk_genre_id`),
  CONSTRAINT `fk_genre` FOREIGN KEY (`fk_genre_id`) REFERENCES `genres` (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audiovisual_productions`
--

LOCK TABLES `audiovisual_productions` WRITE;
/*!40000 ALTER TABLE `audiovisual_productions` DISABLE KEYS */;
INSERT INTO `audiovisual_productions` VALUES (1,'https://lumiere-a.akamaihd.net/v1/images/p_moana_20530_214883e3.jpeg?region=0%2C0%2C540%2C810','Moana','2016-11-23',7.6,2),(2,'https://lumiere-a.akamaihd.net/v1/images/p_monstersinc_19751_55afa07a.jpeg','Monsters, Inc','2001-12-21',8.1,4),(3,'https://lumiere-a.akamaihd.net/v1/images/p_bighero6_19753_20bd6206.jpeg','Big Hero 6','2014-12-25',7.8,2),(4,'https://images.moviesanywhere.com/b1007cc8f77aea276c123b2cc543e8ec/05edd7b6-f452-4396-b547-71967c64a057.jpg','Aladdin','1992-11-25',8,1),(5,'https://static.wikia.nocookie.net/disneyprincess/images/0/09/Beauty_and_the_Beast_film_poster.jpg/revision/latest?cb=20200408144337','Beauty and the Beast','1991-11-25',8,1),(6,'https://lumiere-a.akamaihd.net/v1/images/p_sleepingbeauty_20525_0cc9243a.jpeg','Sleeping Beauty','1959-01-29',7.2,5),(7,'https://movieguide.b-cdn.net/wp-content/uploads/2014/05/the-little-mermaid-522a944095a57-768x1095.jpg','The Little Mermaid','1989-11-13',7.6,4),(8,'https://lumiere-a.akamaihd.net/v1/images/p_101dalmatians_481ccd9d.jpeg','One Hundred and One Dalmatians','1961-01-25',7.3,2),(9,'https://lumiere-a.akamaihd.net/v1/images/p_frozen_18373_3131259c.jpeg','Frozen','2019-11-21',7.4,3),(10,'https://upload.wikimedia.org/wikipedia/en/9/96/Brave_Poster.jpg','Brave','2012-07-20',7.1,1),(11,'https://upload.wikimedia.org/wikipedia/en/a/a8/Tangled_poster.jpg','Tangled','2011-01-07',7.7,6),(12,'https://lumiere-a.akamaihd.net/v1/images/p_liloandstitch_19755_0ba5c55e.jpeg','Lilo & Stitch','2002-06-21',7.3,7),(13,'https://lumiere-a.akamaihd.net/v1/images/p_themanyadventuresofwinniethepooh_19638_d29df8cf.jpeg','The Many Adventures of Winnie the Pooh','1977-03-11',7.5,12),(14,'https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_.jpg','Toy Story','1995-12-25',8.3,11),(15,'https://lumiere-a.akamaihd.net/v1/images/p_pinocchio_19879_d6304938.jpeg','Pinocchio ','1940-02-07',7.5,10),(16,'https://m.media-amazon.com/images/M/MV5BNzA4ODUwNDA0OF5BMl5BanBnXkFtZTgwMjc1NjM1NTM@._V1_.jpg','Big City Greens','2018-06-18',7.4,12),(17,'https://m.media-amazon.com/images/M/MV5BOGQ0MDQyYWMtNjdlYy00ZDAyLWE5YTItMzcyMjllZTA4MTcyXkEyXkFqcGdeQXVyMjEzNTg5Mzk@._V1_.jpg','The Owl House','2020-01-10',8.3,11),(18,'https://m.media-amazon.com/images/M/MV5BOTc5MmI4ODMtNThlNC00Yjk0LTllOTMtNzU1YjJkMjIxMWQ4XkEyXkFqcGdeQXVyMTEzMTI1Mjk3._V1_FMjpg_UX1000_.jpg','Ghost and Molly McGee','2021-10-01',7.3,8),(19,'https://pics.filmaffinity.com/Phineas_y_Ferb_Serie_de_TV-285111132-large.jpg','Phineas and Ferb','2007-08-17',8.1,9),(20,'https://m.media-amazon.com/images/M/MV5BODNkOWYwYjYtMWZhZS00NjdlLTg1YWEtMjNiMGFkYTgzNjZkXkEyXkFqcGdeQXVyNzMwOTY2NTI@._V1_.jpg','Kim Possible','2002-06-07',7.2,7);
/*!40000 ALTER TABLE `audiovisual_productions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-13 22:45:34
