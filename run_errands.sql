-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: run_errands
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `m_order`
--

DROP TABLE IF EXISTS `m_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `m_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_receiving_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `commodity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `voucher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `commodity_price` decimal(10,2) NOT NULL,
  `expenses` decimal(10,2) NOT NULL,
  `delivery_place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contacts` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contacts_phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `payment_method` int NOT NULL,
  `order_time` datetime NOT NULL,
  `order_receiving_time` datetime DEFAULT NULL,
  `receiving_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_order`
--

LOCK TABLES `m_order` WRITE;
/*!40000 ALTER TABLE `m_order` DISABLE KEYS */;
INSERT INTO `m_order` VALUES (1,'下单者1','接单者2','物品1','购买凭证1',123.00,5.00,'收货地址1','联系人1','12345678910',1,'2020-09-03 18:21:31','2020-09-07 15:21:35','2020-09-08 10:52:48'),(2,'下单者2','接单者2','物品2','购买凭证2',10.00,2.00,'收货地址2','联系人2','12345678910',1,'2020-09-04 15:21:31','2020-09-07 15:21:35','2020-09-08 10:53:11'),(3,'下单者2','接单者4','物品3','购买凭证3',23.00,1.00,'收货地址2','联系人2','12345678910',2,'2020-09-04 21:21:31','2020-09-07 15:21:35','2020-09-08 10:53:14'),(4,'下单者3','接单者5','物品2','购买凭证4',34.00,2.00,'收货地址4','联系人4','12345678910',1,'2020-09-05 15:21:31','2020-09-07 15:21:35','2020-09-08 10:53:16'),(5,'下单者4','接单者6','物品4','购买凭证5',3423.00,3.00,'收货地址5','联系人5','12345678910',1,'2020-09-05 16:21:31','2020-09-07 15:21:35','2020-09-08 10:53:21'),(6,'下单者2','接单者7','物品5','购买凭证6',324.00,6.00,'收货地址3','联系人3','12345678910',2,'2020-09-05 19:21:31','2020-09-07 15:21:35','2020-09-08 10:53:24'),(7,'下单者4','接单者5','物品3','购买凭证7',53.00,5.00,'收货地址5','联系人5','12345678910',2,'2020-09-06 15:21:31','2020-09-07 15:21:35','2020-09-08 10:53:24'),(8,'下单者6','接单者2','物品2','购买凭证8',324.00,4.00,'收货地址6','联系人6','12345678910',2,'2020-09-06 17:21:31','2020-09-07 15:21:35','2020-09-08 10:53:24'),(9,'下单者2','接单者8','物品1','购买凭证9',324.00,3.00,'收货地址8','联系人8','12345678910',2,'2020-09-07 15:21:31','2020-09-07 15:21:35','2020-09-08 10:53:24'),(10,'下单者6','接单者1','物品4','购买凭证10',12.00,1.00,'收货地址1','联系人1','12345678910',2,'2020-09-08 15:21:31','2020-09-07 15:21:35','2020-09-08 10:53:24'),(11,'下单者1','接单者6','物品1','购买凭证11',2.00,2.00,'收货地址8','联系人8','12345678910',2,'2020-09-07 15:21:31','2020-09-07 15:21:35','2020-09-08 10:53:24');
/*!40000 ALTER TABLE `m_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_question`
--

DROP TABLE IF EXISTS `m_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `m_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `answer_a` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `answer_b` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `answer_c` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `answer_d` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `right_answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `question_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_question`
--

LOCK TABLES `m_question` WRITE;
/*!40000 ALTER TABLE `m_question` DISABLE KEYS */;
INSERT INTO `m_question` VALUES (3,'最好的编程语言是','C语言','C++','Java','Python','C','Clanguage'),(4,'写的第一句代码','helloworld','code is easy','code issimple','coding is interesting','A','Clanguage'),(5,'C语言提供的合法的数据类型关键字是？','Double','short','integer','Char','B','Clanguage'),(6,'表达式：10!=9的值是多少？','true','非零值','0','1','D','Clanguage'),(7,'C语言中非空的基本数据类型包括？','整型，实型，逻辑型','整型，实型，字符型','整型，字符型，逻辑型','整型，实型，逻辑型，字符型','B','Clanguage'),(10,'下列说法正确的是？','JAVA程序的main方法必须写在类里面','JAVA程序中可以有多个main方法','JAVA程序中类名必须与文件名一样','JAVA程序的main方法中如果只有一条语句，可以不用{}括起来','A','Java'),(11,'以下()不是合法的标识符？','String','x3x','void','de$f','C','Java'),(12,'表达式(11+3*8)/4%3的值是()','31','0','1','2','D','Java'),(13,'下列值不为true的表达式有()','\"john\"==\'john\'','\"john\".equals(\"john\")','\"john\"=\"john\"','\"john\".equals(new String(\"john\"))','C','Java'),(14,'对象的特征在类中表示为变量，称为类的()。','对象','属性','方法','数据类型','B','Java'),(15,'在CPU内部，反映程序运行状态或反映运算结果的一些特征寄存器是','PC','PSW','A','SP','B','singleChip'),(16,'要用传送指令访问MCS-51片外RAM，它的指令操作码助记符应是','MOV','MOVX','MOVC','以上都是','B','singleChip'),(17,'指令ALMP的跳转范围是','256KB','1KB','2KB','64KB','C','singleChip'),(18,'某种存储器芯片是8KB*4/片，那么它的地址线根数是','11根','12根','13根','14根','C','singleChip'),(20,'在数据结构中，从逻辑上可以把数据结构分为','动态结构和静态结构','紧凑结构和非紧凑结构','线性结构和非线性结构','内部结构和外部结构','C','dataStructure'),(21,'在数据结构中，与所使用的计算机无关的是数据的()结构','逻辑','存储','逻辑和存储','物理','A','dataStructure'),(22,'在决定选取何种存储结构时，一般不考虑','各结点的值如何','结点个数的多少','对数据有哪些运算','所用的编程语言实现这种结构是否方便','A','dataStructure'),(23,'在存储数据时，通常不仅要存储各数据元素的值，而且还要存储','数据的处理方法','数据元素的类型','数据元素之间的关系','数据的存储方法','C','dataStructure'),(24,'以下说法正确的是','数据项是数据的基本单位','数据元素是数据的最小单位','数据结构是带结构的数据项的集合','一些表面上很不相同的数据可以有相同的逻辑结构','D','dataStructure');
/*!40000 ALTER TABLE `m_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_user`
--

DROP TABLE IF EXISTS `m_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `m_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `student_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `major` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_user`
--

LOCK TABLES `m_user` WRITE;
/*!40000 ALTER TABLE `m_user` DISABLE KEYS */;
INSERT INTO `m_user` VALUES (1,'cjt','123','cjt','20170502344','物联网','1782173123'),(3,'阿巴阿巴','123','阿巴阿巴','201700000000','电子信息工程','17816093983'),(4,'褚锦涛','123','褚锦涛','201705021106','物联网工程','17816093983'),(6,'1','1','1','1','电子信息工程','1');
/*!40000 ALTER TABLE `m_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_information` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
INSERT INTO `user_information` VALUES (5,'褚锦涛','123','褚锦涛'),(6,'李四','123','李四'),(13,'张三','123','张三');
/*!40000 ALTER TABLE `user_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wrong_question`
--

DROP TABLE IF EXISTS `wrong_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wrong_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `question_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wrong_question`
--

LOCK TABLES `wrong_question` WRITE;
/*!40000 ALTER TABLE `wrong_question` DISABLE KEYS */;
INSERT INTO `wrong_question` VALUES (141,1,4),(142,1,6),(143,1,7),(144,1,20),(145,1,21),(146,1,22),(147,1,12),(148,1,13),(149,1,6),(150,1,5),(151,1,3),(152,1,3),(153,1,5),(154,1,4),(155,1,6),(156,1,7),(157,1,4),(158,1,5),(159,1,3),(160,1,7),(161,1,6);
/*!40000 ALTER TABLE `wrong_question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-30 12:33:49
