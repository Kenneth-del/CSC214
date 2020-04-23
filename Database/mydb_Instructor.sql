-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `Instructor`
--

DROP TABLE IF EXISTS `Instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `OfficeBuilding` varchar(45) DEFAULT NULL,
  `OfficeNumber` varchar(5) DEFAULT NULL,
  `Email` varchar(120) DEFAULT NULL,
  `PhoneNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instructor`
--

LOCK TABLES `Instructor` WRITE;
/*!40000 ALTER TABLE `Instructor` DISABLE KEYS */;
INSERT INTO `Instructor` VALUES (1,'Hseuh-Ming','Lu','George West','269','tommy.lu@dtcc.edu','3025735475'),(2,'Frank','Sciallo','George West','268','frank.sciallo@dtcc.edu','3024345564'),(3,'Jin','An','George West','263','jin.an@dtcc.edu','3025735453'),(4,'Tianzhong','Ding','George West','255','tding@dtcc.edu','3025735455'),(5,'Justin','Schaller',NULL,NULL,'justin.schaller@dtcc.edu	','3025715300'),(6,'Vincent','Monsen',NULL,NULL,'vincent.monsen@dtcc.edu	',NULL),(7,'Billy','Machage','George West','250','billy.machage@dtcc.edu','3026575162'),(8,'Megan','Smith',NULL,NULL,'mrice13@dtcc.edu','NULL'),(9,'Michelle','Smith','George South East','210F','msmit164@dtcc.edu','3026575193'),(10,'Rita','Wierzbicki',NULL,NULL,'rwierzbi@dtcc.edu','3025715300'),(11,'Chris','Mcbride',NULL,NULL,'cmcbrid3@dtcc.edu	',NULL),(12,'Nadia','Colon',NULL,NULL,'ncolon4@dtcc.edu	','3024345547'),(13,'Jennifer','Hutt','Wilmington South East','210H','jennifer.hutt@dtcc.edu','3025715324'),(14,'Jennifer','Baker','Stanton','B132','Jennifer.Baker@dtcc.edu','3024543909'),(15,'Kara-Zoe','McGonegal','Stanton','B134','kmcgoneg@dtcc.edu','3024533773'),(16,'Josepha','Paola','Stanton','B133','jpaola@dtcc.edu','3024533765'),(17,'Wayne','Manrakhan','Stanton','B134','wmanrakh@dtcc.edu','3022923821'),(18,'Anupama','Bhat',NULL,NULL,'abhat@dtcc.edu',NULL),(19,'Dimitry','Gusakov',NULL,NULL,'dgusakov@dtcc.edu	',NULL),(20,'John','Bertelsen',NULL,NULL,'jbertels@dtcc.edu','3025715300');
/*!40000 ALTER TABLE `Instructor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-22 23:59:44
