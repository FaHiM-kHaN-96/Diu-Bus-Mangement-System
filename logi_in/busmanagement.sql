CREATE DATABASE  IF NOT EXISTS `busmangement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `busmangement`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: busmangement
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `add_bus`
--

DROP TABLE IF EXISTS `add_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `add_bus` (
  `bus_name` varchar(100) NOT NULL,
  `bus_capacity` int NOT NULL,
  PRIMARY KEY (`bus_name`),
  UNIQUE KEY `bus_name_UNIQUE` (`bus_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_bus`
--

LOCK TABLES `add_bus` WRITE;
/*!40000 ALTER TABLE `add_bus` DISABLE KEYS */;
INSERT INTO `add_bus` VALUES ('s1',60),('s2',60),('s3',60),('s4',60),('s5',60),('s6',60);
/*!40000 ALTER TABLE `add_bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assign_busn`
--

DROP TABLE IF EXISTS `assign_busn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assign_busn` (
  `bus_nam` varchar(100) NOT NULL,
  `houre` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `am_pm` varchar(45) NOT NULL,
  `route` varchar(600) NOT NULL,
  PRIMARY KEY (`bus_nam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assign_busn`
--

LOCK TABLES `assign_busn` WRITE;
/*!40000 ALTER TABLE `assign_busn` DISABLE KEYS */;
/*!40000 ALTER TABLE `assign_busn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avilable_busp`
--

DROP TABLE IF EXISTS `avilable_busp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avilable_busp` (
  `id_bus` int NOT NULL AUTO_INCREMENT,
  `bus_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avilable_busp`
--

LOCK TABLES `avilable_busp` WRITE;
/*!40000 ALTER TABLE `avilable_busp` DISABLE KEYS */;
INSERT INTO `avilable_busp` VALUES (74,'s4'),(78,'s2'),(80,'s5'),(81,'s1'),(82,'s6'),(83,'s3');
/*!40000 ALTER TABLE `avilable_busp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_authority`
--

DROP TABLE IF EXISTS `bus_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bus_authority` (
  `id_bus_authority` int NOT NULL AUTO_INCREMENT,
  `ath_username` varchar(10) NOT NULL,
  `ath_password` varchar(45) NOT NULL,
  PRIMARY KEY (`id_bus_authority`,`ath_username`),
  UNIQUE KEY `ath_username_UNIQUE` (`ath_username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_authority`
--

LOCK TABLES `bus_authority` WRITE;
/*!40000 ALTER TABLE `bus_authority` DISABLE KEYS */;
INSERT INTO `bus_authority` VALUES (3,'@example','test1');
/*!40000 ALTER TABLE `bus_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_chk`
--

DROP TABLE IF EXISTS `card_chk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card_chk` (
  `bus_namp` varchar(300) NOT NULL,
  PRIMARY KEY (`bus_namp`),
  UNIQUE KEY `bus_namp_UNIQUE` (`bus_namp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_chk`
--

LOCK TABLES `card_chk` WRITE;
/*!40000 ALTER TABLE `card_chk` DISABLE KEYS */;
/*!40000 ALTER TABLE `card_chk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `on_trip`
--

DROP TABLE IF EXISTS `on_trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `on_trip` (
  `bus_nme` varchar(200) NOT NULL,
  PRIMARY KEY (`bus_nme`),
  UNIQUE KEY `idon_trip_UNIQUE` (`bus_nme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `on_trip`
--

LOCK TABLES `on_trip` WRITE;
/*!40000 ALTER TABLE `on_trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `on_trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_info` (
  `id_student_info` int NOT NULL AUTO_INCREMENT,
  `student_email` varchar(60) NOT NULL,
  `student_password` varchar(10) NOT NULL,
  PRIMARY KEY (`id_student_info`,`student_email`),
  UNIQUE KEY `student_email_UNIQUE` (`student_email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (4,'example.com','test1');
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_prt_bus`
--

DROP TABLE IF EXISTS `student_prt_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_prt_bus` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bus_nam` varchar(255) NOT NULL,
  `houre` varchar(10) NOT NULL,
  `minute` varchar(10) NOT NULL,
  `am_pm` varchar(2) NOT NULL,
  `route` varchar(600) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_prt_bus`
--

LOCK TABLES `student_prt_bus` WRITE;
/*!40000 ALTER TABLE `student_prt_bus` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_prt_bus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10  3:57:04
