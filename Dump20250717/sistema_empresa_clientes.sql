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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(25) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `data_cadastro` date NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Cliente 1','11999999999','Rua XPTO, 999','2024-02-01'),(2,'Cliente 2','11888888888','Rua ABC, 123','2024-02-02'),(3,'Sarah Moura','+55 71 3036 3055','Viela de Azevedo, 542, Vila São Francisco, 98654341 Novaes / RO','2025-04-15'),(4,'Gabriel Peixoto','(084) 0952-7151','Viela Cavalcanti, 36, Sport Club, 41863424 Rocha / AP','2024-06-17'),(5,'Bianca Correia','+55 (031) 2269-9268','Vila Luigi Dias, 7, Vila Maria, 19942-175 Cardoso / RR','2023-08-22'),(6,'Dr. Arthur Barros','(051) 9697-9733','Rua da Paz, 3, Vila Paquetá, 35852442 Ramos / MG','2024-11-17'),(7,'Beatriz da Cruz','0500 722 7020','Feira Guilherme da Costa, 806, Vila Da Paz, 99710-334 Pereira / MT','2025-05-27'),(8,'Felipe Batista','+55 48 9210-9807','Rua Marechal Hermes, 401, Centro Histórico, 88010-000 Florianópolis / SC','2023-07-09'),(9,'Júlia Nogueira','(011) 97888-4412','Avenida Paulista, 1234, Bela Vista, 01310-100 São Paulo / SP','2024-01-15'),(10,'Marcos Silva','+55 61 99310-2233','SHN Quadra 1, Bloco A, Asa Norte, 70701-000 Brasília / DF','2022-12-01'),(11,'Renata Oliveira','62 99123-4567','Rua T-36, Setor Bueno, 74230-030 Goiânia / GO','2024-03-21'),(12,'Lucas Martins','(81) 99999-8888','Av. Boa Viagem, 5000, Boa Viagem, 51020-000 Recife / PE','2023-10-12'),(13,'Amanda Rocha','71 99888-1234','Rua das Rosas, 110, Pituba, 41810-070 Salvador / BA','2025-02-17'),(14,'Bruno Fernandes','85 99666-7788','Av. Beira Mar, 123, Meireles, 60165-121 Fortaleza / CE','2023-06-01'),(15,'Patrícia Lima','(31) 98877-6655','Rua da Bahia, 2000, Lourdes, 30160-011 Belo Horizonte / MG','2024-08-03'),(16,'Rodrigo Cunha','41 98765-4321','Rua XV de Novembro, 100, Centro, 80020-310 Curitiba / PR','2024-09-11'),(17,'Elaine Freitas','95 99111-2233','Av. Mário Homem de Melo, 700, Centro, 69305-110 Boa Vista / RR','2023-04-27'),(18,'João Pedro','92 99444-3322','Av. Djalma Batista, 1500, Chapada, 69050-010 Manaus / AM','2025-01-30'),(19,'Larissa Souza','98 98888-7777','Rua Grande, 321, Centro, 65020-000 São Luís / MA','2022-11-09'),(20,'Rafael Lima','21 99090-9090','Av. das Américas, 5000, Barra da Tijuca, 22640-102 Rio de Janeiro / RJ','2023-03-03'),(21,'Viviane Pires','51 99888-1234','Rua da Praia, 45, Centro Histórico, 90010-000 Porto Alegre / RS','2024-05-14'),(22,'César Gomes','47 99222-3344','Rua Blumenau, 77, Victor Konder, 89010-000 Blumenau / SC','2023-09-25'),(23,'Isabela Mendes','44 97777-6666','Av. Brasil, 999, Zona 01, 87013-000 Maringá / PR','2024-02-08'),(24,'Leandro Silva','62 98444-5566','Rua 9, Setor Oeste, 74120-090 Goiânia / GO','2023-11-20'),(25,'Carla Torres','34 99123-9999','Av. João Naves de Ávila, 2121, Santa Mônica, 38408-100 Uberlândia / MG','2024-06-30'),(26,'Daniel Costa','79 98877-5544','Av. Hermes Fontes, 200, Grageru, 49025-310 Aracaju / SE','2023-01-19'),(27,'Simone Araújo','13 99123-1111','Rua João Pessoa, 400, Centro, 11013-500 Santos / SP','2025-03-12'),(28,'Edson Marques','69 99988-8877','Rua Rui Barbosa, 23, Centro, 76801-072 Porto Velho / RO','2023-08-06'),(29,'Tatiane Souza','83 98888-5566','Rua Maciel Pinheiro, 101, Centro, 58013-120 João Pessoa / PB','2024-04-22'),(30,'Victor Mendes','61 99777-4433','SCS Quadra 5, Bloco A, Asa Sul, 70300-500 Brasília / DF','2023-12-13'),(31,'Aline Ferreira','82 99333-7788','Av. Fernandes Lima, 1200, Farol, 57055-000 Maceió / AL','2024-07-05'),(32,'Henrique Batista','95 99090-1122','Rua Benjamin Constant, 21, Centro, 69301-050 Boa Vista / RR','2023-05-29');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
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
