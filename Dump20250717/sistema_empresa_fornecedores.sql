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
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedores` (
  `id_fornecedor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `contato` varchar(100) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `data_inicio_contrato` date NOT NULL,
  PRIMARY KEY (`id_fornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (1,'TechFornecedor','contato@tech.com','Av. Central, 123','2023-03-01'),(2,'OfficeSuppliers','vendas@office.com','Rua B, 456','2023-04-01'),(3,'Fornecedor Alfa','contato1@fornecedoralfa.com',NULL,'2023-01-01'),(4,'Fornecedor Beta','(11) 91234-5678',NULL,'2023-01-01'),(5,'Fornecedor Gama','contato3@fornecedorgama.com',NULL,'2023-01-01'),(6,'Fornecedor Delta','(21) 98765-4321',NULL,'2023-01-01'),(7,'Fornecedor Épsilon','contato5@fornecedorepsilon.com',NULL,'2023-01-01'),(8,'Fornecedor Zeta','(31) 99876-5432',NULL,'2023-01-01'),(9,'Fornecedor Eta','contato7@fornecedoreta.com',NULL,'2023-01-01'),(10,'Fornecedor Theta','(41) 98765-1234',NULL,'2023-01-01'),(11,'Fornecedor Iota','contato9@fornecedorota.com',NULL,'2023-01-01'),(12,'Fornecedor Kappa','(51) 99999-8888',NULL,'2023-01-01'),(13,'Fornecedor Lambda','contato11@fornecedorlambda.com',NULL,'2023-01-01'),(14,'Fornecedor Mi','(61) 91234-8765',NULL,'2023-01-01'),(15,'Fornecedor Ni','contato13@fornecedorni.com',NULL,'2023-01-01'),(16,'Fornecedor Xi','(71) 93456-7890',NULL,'2023-01-01'),(17,'Fornecedor Omicron','contato15@fornecedoromicron.com',NULL,'2023-01-01'),(18,'Fornecedor Pi','(81) 94567-1234',NULL,'2023-01-01'),(19,'Fornecedor Rho','contato17@fornecedorrho.com',NULL,'2023-01-01'),(20,'Fornecedor Sigma','(91) 98765-4321',NULL,'2023-01-01'),(21,'Fornecedor Tau','contato19@fornecedortau.com',NULL,'2023-01-01'),(22,'Fornecedor Upsilon','(31) 99876-1234',NULL,'2023-01-01'),(23,'Fornecedor Phi','contato21@fornecedorphi.com',NULL,'2023-01-01'),(24,'Fornecedor Chi','(21) 91234-5678',NULL,'2023-01-01'),(25,'Fornecedor Psi','contato23@fornecedorpsi.com',NULL,'2023-01-01'),(26,'Fornecedor Omega','(11) 98765-4321',NULL,'2023-01-01'),(27,'Fornecedor Alfa2','contato25@fornecedoralfa2.com',NULL,'2023-01-01'),(28,'Fornecedor Beta2','(41) 91234-8765',NULL,'2023-01-01'),(29,'Fornecedor Gama2','contato27@fornecedorgama2.com',NULL,'2023-01-01'),(30,'Fornecedor Delta2','(51) 99876-5432',NULL,'2023-01-01'),(31,'Fornecedor Épsilon2','contato29@fornecedorepsilon2.com',NULL,'2023-01-01'),(32,'Fornecedor Zeta2','(61) 98765-1234',NULL,'2023-01-01');
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-17 11:20:47
