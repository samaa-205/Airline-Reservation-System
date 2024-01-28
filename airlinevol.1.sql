CREATE DATABASE  IF NOT EXISTS `airlinesystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `airlinesystem`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: airlinesystem
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
-- Table structure for table `airline_enquiry`
--

DROP TABLE IF EXISTS `airline_enquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airline_enquiry` (
  `En_ID` int NOT NULL,
  `En_Date` date DEFAULT NULL,
  `En_Description` varchar(30) DEFAULT NULL,
  `En_Title` varchar(30) DEFAULT NULL,
  `En_Type` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`En_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airline_enquiry`
--

LOCK TABLES `airline_enquiry` WRITE;
/*!40000 ALTER TABLE `airline_enquiry` DISABLE KEYS */;
INSERT INTO `airline_enquiry` VALUES (1,'2022-05-12','wrong ticket number','no of ticket','tickets'),(2,'2022-05-15','wrong flight category','flight category','category'),(3,'2022-03-18','asking for flight time','flight time','flights'),(4,'2022-02-11','asking for flight status','flight status','flights'),(5,'2022-04-10','wrong flight time',NULL,'flights'),(6,'2022-08-09','wrong ticket time',NULL,'tickets'),(7,'0017-10-13','wrong ticket number','no of ticket','tickets');
/*!40000 ALTER TABLE `airline_enquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `Airport_Code` int NOT NULL,
  `Airport_Name` varchar(30) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `Country` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Airport_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (123,'Miami airport','Miami','Florida'),(124,'Sharm El Sheikh airport','Sharm El Sheikh','Egypt'),(125,'Los Angles airport','Los Angles','California'),(126,'Marsa Alam airport','Marsa Alam','Egypt'),(127,'Aswan airport','Aswan','Egypt'),(128,'Rome airport','Rome','Italy');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `FLIGHT_ID` int NOT NULL,
  `Airport_Code` int NOT NULL,
  `Passengers_No` int DEFAULT NULL,
  `Plane_Type` varchar(30) DEFAULT NULL,
  `TIME_FROM` time(6) DEFAULT NULL,
  `TIME_TO` time(6) DEFAULT NULL,
  PRIMARY KEY (`FLIGHT_ID`),
  KEY `Airport_Code` (`Airport_Code`),
  CONSTRAINT `flights_ibfk_1` FOREIGN KEY (`Airport_Code`) REFERENCES `airport` (`Airport_Code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `flights_chk_1` CHECK ((`Passengers_No` <= 250))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (159,123,2,'Jets','12:30:00.000000','15:20:00.000000'),(160,124,2,'Light Jets','19:00:05.000000','00:00:00.000000'),(162,126,4,'Jets','15:00:00.000000','19:00:00.000000'),(163,127,5,'Light Jets','13:00:00.000000','17:30:05.000000'),(164,128,7,'Mid-Size Jets','14:50:00.000000','18:15:00.000000'),(188,123,9,'JETS','00:30:00.000000','13:30:00.000000');
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `international_flight`
--

DROP TABLE IF EXISTS `international_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `international_flight` (
  `Destination_Country` varchar(30) DEFAULT NULL,
  `Passengers_Vaccinated` tinyint(1) DEFAULT NULL,
  `FLIGHT_ID` int NOT NULL,
  PRIMARY KEY (`FLIGHT_ID`),
  CONSTRAINT `international_flight_ibfk_1` FOREIGN KEY (`FLIGHT_ID`) REFERENCES `flights` (`FLIGHT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `international_flight`
--

LOCK TABLES `international_flight` WRITE;
/*!40000 ALTER TABLE `international_flight` DISABLE KEYS */;
INSERT INTO `international_flight` VALUES ('EGYPT',0,162),('ENGLAND',1,163),('ITALY',0,164);
/*!40000 ALTER TABLE `international_flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local_flight`
--

DROP TABLE IF EXISTS `local_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local_flight` (
  `Destination_City` varchar(30) DEFAULT NULL,
  `FLIGHT_ID` int NOT NULL,
  PRIMARY KEY (`FLIGHT_ID`),
  CONSTRAINT `local_flight_ibfk_1` FOREIGN KEY (`FLIGHT_ID`) REFERENCES `flights` (`FLIGHT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local_flight`
--

LOCK TABLES `local_flight` WRITE;
/*!40000 ALTER TABLE `local_flight` DISABLE KEYS */;
INSERT INTO `local_flight` VALUES ('ASWAN',159),('SIWA',160);
/*!40000 ALTER TABLE `local_flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `Passport_No` int NOT NULL,
  `Boarding_ID` int DEFAULT NULL,
  `En_ID` int DEFAULT NULL,
  `Ticket_id` int NOT NULL AUTO_INCREMENT,
  `FLIGHT_ID` int DEFAULT NULL,
  `First_Name` varchar(30) DEFAULT NULL,
  `Last_Name` varchar(30) DEFAULT NULL,
  `Vaccinated` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Passport_No`),
  KEY `En_ID` (`En_ID`),
  KEY `Ticket_id` (`Ticket_id`),
  CONSTRAINT `passengers_ibfk_1` FOREIGN KEY (`En_ID`) REFERENCES `airline_enquiry` (`En_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=318 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1234,45,7,317,NULL,'Ali','Hussien',0),(4546,34,NULL,1,NULL,'Omar','Hussien',1),(5001,13,1,310,162,'Sara','Ali',1),(5002,14,2,311,164,'liqaa','tarek',0),(5004,16,7,315,162,'alaa','hussien',1),(5005,14,NULL,313,188,'Gannat','ElSayed',1),(5007,15,6,314,188,'Reema','Amgad',1),(12345,19,5,316,159,'Fatema','Gamal',0);
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `Ticket_id` int NOT NULL AUTO_INCREMENT,
  `FLIGHT_ID` int NOT NULL,
  `Ticket_Date` date DEFAULT NULL,
  `Ticket_Destination` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Ticket_id`),
  KEY `FLIGHT_ID` (`FLIGHT_ID`) /*!80000 INVISIBLE */,
  KEY `tickets_ibfk_2_idx` (`Ticket_id`),
  CONSTRAINT `fk` FOREIGN KEY (`FLIGHT_ID`) REFERENCES `flights` (`FLIGHT_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=316 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (311,160,'2022-01-25','miami'),(313,162,'2022-02-03','italy'),(314,163,'2023-01-01','paris'),(315,164,'2023-01-03','ITALY');
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'airlinesystem'
--

--
-- Dumping routines for database 'airlinesystem'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-03 20:54:56
