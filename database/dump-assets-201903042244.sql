-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: assets
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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `idArea` int(11) NOT NULL AUTO_INCREMENT,
  `idCity` int(11) NOT NULL,
  `nameArea` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idArea`),
  KEY `area_city_FK` (`idCity`),
  CONSTRAINT `area_city_FK` FOREIGN KEY (`idCity`) REFERENCES `city` (`idCity`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,1,'Recursos Humanos'),(2,2,'Tecnologia'),(3,3,'Gerencia'),(4,4,'Contabilidad');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assets`
--

DROP TABLE IF EXISTS `assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assets` (
  `idAssets` int(11) DEFAULT NULL,
  `nameAssets` varchar(100) DEFAULT NULL,
  `descAssets` varchar(100) DEFAULT NULL,
  `typeAssets` varchar(100) DEFAULT NULL,
  `serialAssets` varchar(100) DEFAULT NULL,
  `internalNumAssets` varchar(100) DEFAULT NULL,
  `weightAssets` double DEFAULT NULL,
  `highAssets` double DEFAULT NULL,
  `longAssets` double DEFAULT NULL,
  `valueBuyAssets` double DEFAULT NULL,
  `dateBuyAssets` date DEFAULT NULL,
  `dateLowAssets` varchar(100) DEFAULT NULL,
  `idStatus` int(11) DEFAULT NULL,
  `colourAssets` varchar(100) DEFAULT NULL,
  `idTypeAss` int(11) DEFAULT NULL,
  `idPerson` int(11) DEFAULT NULL,
  KEY `assets_status_FK` (`idStatus`),
  KEY `assets_typeAssignment_FK` (`idTypeAss`),
  KEY `assets_person_FK` (`idPerson`),
  CONSTRAINT `assets_person_FK` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`),
  CONSTRAINT `assets_status_FK` FOREIGN KEY (`idStatus`) REFERENCES `status` (`idStatus`),
  CONSTRAINT `assets_typeAssignment_FK` FOREIGN KEY (`idTypeAss`) REFERENCES `typeAssignment` (`idTypeAss`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets`
--

LOCK TABLES `assets` WRITE;
/*!40000 ALTER TABLE `assets` DISABLE KEYS */;
/*!40000 ALTER TABLE `assets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `idCity` int(11) NOT NULL AUTO_INCREMENT,
  `nameCity` varchar(100) NOT NULL,
  PRIMARY KEY (`idCity`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Valledupar'),(2,'Bogota'),(3,'Medellin'),(4,'Bucaramanga');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `idPerson` int(11) NOT NULL AUTO_INCREMENT,
  `namePerson` varchar(100) NOT NULL,
  PRIMARY KEY (`idPerson`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Juan Perez'),(2,'Oneida Pinto'),(3,'Zeus Alfonso');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `idStatus` int(11) NOT NULL AUTO_INCREMENT,
  `nameStatus` varchar(100) NOT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Activo'),(2,'Dado De Baja'),(3,'En Reparacion'),(4,'Disponible'),(5,'Asignado');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typeAssignment`
--

DROP TABLE IF EXISTS `typeAssignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typeAssignment` (
  `idTypeAss` int(11) NOT NULL AUTO_INCREMENT,
  `nameTypeAss` varchar(100) NOT NULL,
  PRIMARY KEY (`idTypeAss`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typeAssignment`
--

LOCK TABLES `typeAssignment` WRITE;
/*!40000 ALTER TABLE `typeAssignment` DISABLE KEYS */;
INSERT INTO `typeAssignment` VALUES (1,'Área'),(2,'Persona');
/*!40000 ALTER TABLE `typeAssignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'assets'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-04 22:44:11
