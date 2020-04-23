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
-- Table structure for table `Section`
--

DROP TABLE IF EXISTS `Section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Section` (
  `CRN` int NOT NULL,
  `Semester` varchar(45) NOT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `MeetingTimes` varchar(45) DEFAULT NULL,
  `StartTime` varchar(45) DEFAULT NULL,
  `EndTime` varchar(45) DEFAULT NULL,
  `Building` varchar(45) DEFAULT NULL,
  `Room` varchar(45) DEFAULT NULL,
  `InstructionalMethod` varchar(45) DEFAULT NULL,
  `Course_id` int NOT NULL,
  `Instructor_id` int NOT NULL,
  PRIMARY KEY (`CRN`,`Course_id`,`Instructor_id`),
  UNIQUE KEY `CRN_UNIQUE` (`CRN`),
  KEY `fk_Section_Course1_idx` (`Course_id`),
  KEY `fk_Section_Instructor1_idx` (`Instructor_id`),
  CONSTRAINT `fk_Section_Course1` FOREIGN KEY (`Course_id`) REFERENCES `Course` (`id`),
  CONSTRAINT `fk_Section_Instructor1` FOREIGN KEY (`Instructor_id`) REFERENCES `Instructor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Section`
--

LOCK TABLES `Section` WRITE;
/*!40000 ALTER TABLE `Section` DISABLE KEYS */;
INSERT INTO `Section` VALUES (20103,'Spring 2020','2020-01-13','2020-05-02','M,W','11:30 AM','12:50 PM','George South East','235','Lecture',19,12),(20107,'Spring 2020','2020-01-13','2020-05-02','M,W','08:30 AM','09:50 AM','George South East','293','Lecture',12,9),(20114,'Spring 2020','2020-01-13','2020-05-02','F','09:00 AM','11:50 AM','George South East','215','Lecture',21,13),(24413,'Spring 2020','2020-01-13','2020-05-02','T,TH','10:00 AM','11:20 AM','George South East','247','Lecture',19,9),(24743,'Spring 2020','2020-01-13','2020-05-02','T,TH','11:30 AM','12:50 PM','George South East','287','Lecture',12,9),(26836,'Spring 2020','2020-01-13','2020-05-02',NULL,NULL,NULL,NULL,NULL,'Online',12,10),(26839,'Spring 2020','2020-01-13','2020-05-02',NULL,NULL,NULL,NULL,NULL,'Online',8,10),(27817,'Spring 2020','2020-01-13','2020-05-02','M,W','01:30 PM','03:50 PM','George West','145','Lecture',5,3),(27822,'Spring 2020','2020-02-10','2020-05-02','M,W','12:30 PM','02:20 PM','George South East','163','Lecture',12,9),(28332,'Spring 2020','2020-01-13','2020-05-02','T,TH','08:30 AM','10:20 PM','George West','326','Lecture',6,4),(29430,'Spring 2020','2020-01-13','2020-05-02','M','06:00 PM','10:52 PM','Stanton','123A','Lecture',5,2),(29434,'Spring 2020','2020-01-13','2020-05-02','W','06:00 PM','09:50 PM','George West','152','Lecture',6,4),(30029,'Spring 2020','2020-01-13','2020-05-02','M,W','06:00 PM','10:50 PM','George South East','152','Lecture',2,1),(31714,'Spring 2020','2020-01-13','2020-05-02','T,TH','01:30 PM','03:50 PM',NULL,NULL,'Video Conference',18,16),(32946,'Spring 2020','2020-01-13','2020-05-02','M','01:00 PM','03:20 PM','George South East','142B','Lecture',2,1),(32947,'Spring 2020','2020-01-13','2020-05-02','M,W','01:00 PM','03:20 PM','George South East','216','Lecture',10,4),(33136,'Spring 2020','2020-01-13','2020-05-02',NULL,NULL,NULL,NULL,NULL,'Online',19,11),(33291,'Spring 2020','2020-01-13','2020-05-02','W','01:30 PM','02:50 PM','Stanton','255','Hybrid',4,16),(33351,'Spring 2020','2020-01-13','2020-05-02',NULL,NULL,NULL,NULL,NULL,'Online',8,11);
/*!40000 ALTER TABLE `Section` ENABLE KEYS */;
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
