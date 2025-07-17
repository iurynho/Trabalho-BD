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
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id_produto` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `quantidade_em_estoque` int NOT NULL,
  `data_cadastro` date NOT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Notebook','Eletrônicos',3500.00,10,'2024-01-10'),(2,'Mouse','Periféricos',150.00,41,'2024-01-11'),(3,'Caneta','Material Escolar',2.50,150,'2024-01-10'),(4,'Caderno','Material Escolar',15.00,80,'2024-01-11'),(5,'Mochila','Acessórios',120.00,40,'2024-01-12'),(6,'Lápis','Material Escolar',1.20,200,'2024-01-13'),(7,'Borracha','Material Escolar',1.00,170,'2024-01-14'),(8,'Apontador','Material Escolar',3.00,130,'2024-01-15'),(9,'Régua','Material Escolar',4.50,95,'2024-01-16'),(10,'Calculadora','Eletrônicos',55.00,30,'2024-01-17'),(11,'Cadeira','Móveis',200.00,25,'2024-01-18'),(12,'Mesa','Móveis',350.00,10,'2024-01-19'),(13,'Monitor','Eletrônicos',1200.00,15,'2024-01-20'),(14,'Teclado','Eletrônicos',150.00,50,'2024-01-21'),(15,'Mouse','Eletrônicos',90.00,55,'2024-01-22'),(16,'Notebook','Eletrônicos',3500.00,20,'2024-01-23'),(17,'Impressora','Eletrônicos',800.00,12,'2024-01-24'),(18,'Smartphone','Eletrônicos',2800.00,45,'2024-01-25'),(19,'Tablet','Eletrônicos',1500.00,35,'2024-01-26'),(20,'Cabo USB','Eletrônicos',25.00,100,'2024-01-27'),(21,'Fone de Ouvido','Eletrônicos',220.00,60,'2024-01-28'),(22,'Caixa de Som','Eletrônicos',300.00,40,'2024-01-29'),(23,'Livro Técnico','Livros',80.00,70,'2024-01-30'),(24,'Livro Romance','Livros',45.00,90,'2024-02-01'),(25,'Livro Infantil','Livros',30.00,100,'2024-02-02'),(26,'Câmera','Eletrônicos',2200.00,15,'2024-02-03'),(27,'Projetor','Eletrônicos',2500.00,10,'2024-02-04'),(28,'Scanner','Eletrônicos',900.00,8,'2024-02-05'),(29,'Microfone','Eletrônicos',180.00,40,'2024-02-06'),(30,'Webcam','Eletrônicos',160.00,50,'2024-02-07'),(31,'Pen Drive','Eletrônicos',45.00,120,'2024-02-08'),(32,'HD Externo','Eletrônicos',350.00,30,'2024-02-09'),(33,'SSD','Eletrônicos',450.00,25,'2024-02-10');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-17 11:20:48
