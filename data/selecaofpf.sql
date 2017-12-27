CREATE DATABASE  IF NOT EXISTS `selecaofpf` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `selecaofpf`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: selecaofpf
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `tb_categorias`
--

DROP TABLE IF EXISTS `tb_categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_categorias` (
  `idcat` int(11) NOT NULL AUTO_INCREMENT,
  `desccat` varchar(50) NOT NULL,
  PRIMARY KEY (`idcat`),
  UNIQUE KEY `idcat_UNIQUE` (`idcat`),
  UNIQUE KEY `desccat_UNIQUE` (`desccat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categorias`
--

LOCK TABLES `tb_categorias` WRITE;
/*!40000 ALTER TABLE `tb_categorias` DISABLE KEYS */;
INSERT INTO `tb_categorias` VALUES (1,'ELETRÔNICO'),(2,'LIVRO'),(3,'MÚSICA');
/*!40000 ALTER TABLE `tb_categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_origens`
--

DROP TABLE IF EXISTS `tb_origens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_origens` (
  `idorig` int(11) NOT NULL AUTO_INCREMENT,
  `descorig` varchar(50) NOT NULL,
  PRIMARY KEY (`idorig`),
  UNIQUE KEY `idorig_UNIQUE` (`idorig`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_origens`
--

LOCK TABLES `tb_origens` WRITE;
/*!40000 ALTER TABLE `tb_origens` DISABLE KEYS */;
INSERT INTO `tb_origens` VALUES (1,'NACIONAL'),(2,'IMPORTADO');
/*!40000 ALTER TABLE `tb_origens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_produtos`
--

DROP TABLE IF EXISTS `tb_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produtos` (
  `idprod` int(11) NOT NULL AUTO_INCREMENT,
  `proddesc` text NOT NULL,
  `proddtcompra` date DEFAULT NULL,
  `prodpreco` double NOT NULL,
  `prodimage` text,
  `prodorigem` int(11) NOT NULL,
  `prodcat` int(11) NOT NULL,
  PRIMARY KEY (`idprod`),
  UNIQUE KEY `idprod_UNIQUE` (`idprod`),
  KEY `fk_prodcat_idcat_idx` (`prodcat`),
  KEY `fk_prodorigem_idorig_idx` (`prodorigem`),
  CONSTRAINT `fk_prodcat_idcat` FOREIGN KEY (`prodcat`) REFERENCES `tb_categorias` (`idcat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_prodorigem_idorig` FOREIGN KEY (`prodorigem`) REFERENCES `tb_origens` (`idorig`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produtos`
--

LOCK TABLES `tb_produtos` WRITE;
/*!40000 ALTER TABLE `tb_produtos` DISABLE KEYS */;
INSERT INTO `tb_produtos` VALUES (1,'NINTENDO 3DS XL',NULL,899.99,'',2,1),(2,'ROTEADOR LINKSYS',NULL,129.99,'',1,1),(3,'PROGRAMANDO COM KOTLIN',NULL,98.99,'',1,2),(4,'DRAGONFORCE - THROUGH THE FIRE AND THE FLAMES',NULL,3.9,'',2,3),(6,'Produto 11','2017-12-15',259,NULL,1,1);
/*!40000 ALTER TABLE `tb_produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-26 22:04:27
