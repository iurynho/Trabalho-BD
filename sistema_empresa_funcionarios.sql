CREATE DATABASE  IF NOT EXISTS `sistema_empresa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistema_empresa`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_empresa
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `data_admissao` date NOT NULL,
  `data_inicio_trabalho` date NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'Funcionario 1','111.111.111-01','Cargo 1','2022-01-01','2022-01-02'),(2,'Funcionario 2','111.111.111-02','Cargo 2','2022-01-03','2022-01-04'),(3,'Funcionario 3','111.111.111-03','Cargo 3','2022-01-05','2022-01-06'),(4,'Funcionario 4','111.111.111-04','Cargo 4','2022-01-07','2022-01-08'),(5,'Funcionario 5','111.111.111-05','Cargo 5','2022-01-09','2022-01-10'),(6,'Funcionario 6','111.111.111-06','Cargo 6','2022-01-11','2022-01-12'),(7,'Funcionario 7','111.111.111-07','Cargo 7','2022-01-13','2022-01-14'),(8,'Funcionario 8','111.111.111-08','Cargo 8','2022-01-15','2022-01-16'),(9,'Funcionario 9','111.111.111-09','Cargo 9','2022-01-17','2022-01-18'),(10,'Funcionario 10','111.111.111-10','Cargo 10','2022-01-19','2022-01-20'),(11,'Funcionario 11','111.111.111-11','Cargo 11','2022-01-21','2022-01-22'),(12,'Funcionario 12','111.111.111-12','Cargo 12','2022-01-23','2022-01-24'),(13,'Funcionario 13','111.111.111-13','Cargo 13','2022-01-25','2022-01-26'),(14,'Funcionario 14','111.111.111-14','Cargo 14','2022-01-27','2022-01-28'),(15,'Funcionario 15','111.111.111-15','Cargo 15','2022-01-29','2022-01-30'),(16,'Funcionario 16','111.111.111-16','Cargo 16','2022-02-01','2022-02-02'),(17,'Funcionario 17','111.111.111-17','Cargo 17','2022-02-03','2022-02-04'),(18,'Funcionario 18','111.111.111-18','Cargo 18','2022-02-05','2022-02-06'),(19,'Funcionario 19','111.111.111-19','Cargo 19','2022-02-07','2022-02-08'),(20,'Funcionario 20','111.111.111-20','Cargo 20','2022-02-09','2022-02-10'),(21,'Funcionario 21','111.111.111-21','Cargo 21','2022-02-11','2022-02-12'),(22,'Funcionario 22','111.111.111-22','Cargo 22','2022-02-13','2022-02-14'),(23,'Funcionario 23','111.111.111-23','Cargo 23','2022-02-15','2022-02-16'),(24,'Funcionario 24','111.111.111-24','Cargo 24','2022-02-17','2022-02-18'),(25,'Funcionario 25','111.111.111-25','Cargo 25','2022-02-19','2022-02-20'),(26,'Funcionario 26','111.111.111-26','Cargo 26','2022-02-21','2022-02-22'),(27,'Funcionario 27','111.111.111-27','Cargo 27','2022-02-23','2022-02-24'),(28,'Funcionario 28','111.111.111-28','Cargo 28','2022-02-25','2022-02-26'),(29,'Funcionario 29','111.111.111-29','Cargo 29','2022-02-27','2022-02-28'),(30,'Funcionario 30','111.111.111-30','Cargo 30','2022-03-01','2022-03-02'),(31,'Carlos Lima','123.456.789-00','Gerente','2023-01-10','2023-01-11'),(32,'Ana Rocha','987.654.321-00','Analista','2023-02-01','2023-02-02');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-10  0:04:10
