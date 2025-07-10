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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `data_cadastro` date NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Usuario 1','usuario1@empresa.com','senha1','2023-01-01'),(2,'Usuario 2','usuario2@empresa.com','senha2','2023-01-02'),(3,'Usuario 3','usuario3@empresa.com','senha3','2023-01-03'),(4,'Usuario 4','usuario4@empresa.com','senha4','2023-01-04'),(5,'Usuario 5','usuario5@empresa.com','senha5','2023-01-05'),(6,'Usuario 6','usuario6@empresa.com','senha6','2023-01-06'),(7,'Usuario 7','usuario7@empresa.com','senha7','2023-01-07'),(8,'Usuario 8','usuario8@empresa.com','senha8','2023-01-08'),(9,'Usuario 9','usuario9@empresa.com','senha9','2023-01-09'),(10,'Usuario 10','usuario10@empresa.com','senha10','2023-01-10'),(11,'Usuario 11','usuario11@empresa.com','senha11','2023-01-11'),(12,'Usuario 12','usuario12@empresa.com','senha12','2023-01-12'),(13,'Usuario 13','usuario13@empresa.com','senha13','2023-01-13'),(14,'Usuario 14','usuario14@empresa.com','senha14','2023-01-14'),(15,'Usuario 15','usuario15@empresa.com','senha15','2023-01-15'),(16,'Usuario 16','usuario16@empresa.com','senha16','2023-01-16'),(17,'Usuario 17','usuario17@empresa.com','senha17','2023-01-17'),(18,'Usuario 18','usuario18@empresa.com','senha18','2023-01-18'),(19,'Usuario 19','usuario19@empresa.com','senha19','2023-01-19'),(20,'Usuario 20','usuario20@empresa.com','senha20','2023-01-20'),(21,'Usuario 21','usuario21@empresa.com','senha21','2023-01-21'),(22,'Usuario 22','usuario22@empresa.com','senha22','2023-01-22'),(23,'Usuario 23','usuario23@empresa.com','senha23','2023-01-23'),(24,'Usuario 24','usuario24@empresa.com','senha24','2023-01-24'),(25,'Usuario 25','usuario25@empresa.com','senha25','2023-01-25'),(26,'Usuario 26','usuario26@empresa.com','senha26','2023-01-26'),(27,'Usuario 27','usuario27@empresa.com','senha27','2023-01-27'),(28,'Usuario 28','usuario28@empresa.com','senha28','2023-01-28'),(29,'Usuario 29','usuario29@empresa.com','senha29','2023-01-29'),(30,'Usuario 30','usuario30@empresa.com','senha30','2023-01-30'),(31,'João Silva','joao@empresa.com','senha123','2024-01-01'),(32,'Maria Souza','maria@empresa.com','senha456','2024-01-02');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-10  0:04:09
