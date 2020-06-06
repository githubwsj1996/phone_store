-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: phone_store_demo
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `buyer_address`
--

DROP TABLE IF EXISTS `buyer_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyer_address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(22) NOT NULL COMMENT '买家姓名',
  `buyer_phone` varchar(11) NOT NULL COMMENT '买家手机号',
  `buyer_address` varchar(64) NOT NULL COMMENT '买家地址\n',
  `area_code` int NOT NULL COMMENT '地区编号',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='买家信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer_address`
--

LOCK TABLES `buyer_address` WRITE;
/*!40000 ALTER TABLE `buyer_address` DISABLE KEYS */;
INSERT INTO `buyer_address` VALUES (1,'张三','13784146215','广东省深圳市罗湖区科技路123号 7 楼 501室',440303,'2020-05-20 05:14:12','2020-05-20 05:15:11'),(2,'李四','13784146234','浙江省杭州市江干区光明路19号 8楼  303室',330104,'2020-05-21 05:14:12','2020-05-21 05:15:11'),(3,'小明','13784146215','浙江省杭州市江干区光明路189号 10楼  402室',330104,'2020-06-02 23:12:39','2020-06-02 23:12:43'),(9,'小红','12345678900','北京市北京市东城区123123',110101,'2020-06-05 13:04:20','2020-06-05 13:04:20');
/*!40000 ALTER TABLE `buyer_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_master`
--

DROP TABLE IF EXISTS `order_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL COMMENT '主键Id\n',
  `buyer_name` varchar(20) NOT NULL COMMENT '买家姓名',
  `buyer_phone` varchar(11) NOT NULL COMMENT '买家手机号\n',
  `buyer_address` varchar(64) NOT NULL COMMENT '买家住址\n',
  `phone_id` int NOT NULL COMMENT '商品编号',
  `phone_name` varchar(20) NOT NULL COMMENT '商品名称',
  `phone_quantity` int NOT NULL COMMENT '商品库存',
  `phone_icon` varchar(64) NOT NULL COMMENT '商品图片',
  `specs_id` int NOT NULL COMMENT '规格编号',
  `specs_name` varchar(10) NOT NULL COMMENT '规格名称',
  `specs_price` decimal(8,2) NOT NULL COMMENT '规格价格',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总价',
  `pay_status` int NOT NULL DEFAULT '0' COMMENT '订单状态 默认0,未支付\n',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_master`
--

LOCK TABLES `order_master` WRITE;
/*!40000 ALTER TABLE `order_master` DISABLE KEYS */;
INSERT INTO `order_master` VALUES ('1591330309764949252','小明','13678787878','广东省深圳市罗湖区科技路123号456室',1,'Honor 8A',2,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,5600.00,1,'2020-05-20 05:14:00','2020-06-05 04:11:50'),('1591352182923500485','张三','13678787878','广东省深圳市罗湖区科技路123号456室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,0,'2020-05-20 05:14:00','2020-06-05 10:16:23'),('1591352475098218346','小红','13678787878','广东省深圳市罗湖区科技路123号456室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,1,'2020-06-05 10:21:15','2020-06-05 10:21:15'),('1591365199676495832','张三','13784146215','广东省深圳市罗湖区科技路123号 7 楼 501室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,0,'2020-06-05 13:53:20','2020-06-05 13:53:20'),('1591365536750979349','张三','13784146215','广东省深圳市罗湖区科技路123号 7 楼 501室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,0,'2020-06-05 13:58:57','2020-06-05 13:58:57'),('1591365787428589572','李四','13784146234','浙江省杭州市江干区光明路19号 8楼  303室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'32GB',280000.00,2810.00,0,'2020-06-05 14:03:07','2020-06-05 14:03:07'),('1591366126163466400','小明','13784146215','浙江省杭州市江干区光明路189号 10楼  402室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,0,'2020-06-05 14:08:46','2020-06-05 14:08:46'),('1591366185595704978','张三','13784146215','广东省深圳市罗湖区科技路123号 7 楼 501室',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,1,'2020-06-05 14:09:46','2020-06-05 14:09:46'),('1591407814521223736','小红','12345678900','北京市北京市东城区123123',1,'Honor 8A',1,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',2,'64GB',320000.00,3210.00,1,'2020-06-06 01:43:35','2020-06-06 01:43:35');
/*!40000 ALTER TABLE `order_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_category`
--

DROP TABLE IF EXISTS `phone_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) NOT NULL COMMENT '类别名称',
  `category_type` int NOT NULL COMMENT '类别编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_category`
--

LOCK TABLES `phone_category` WRITE;
/*!40000 ALTER TABLE `phone_category` DISABLE KEYS */;
INSERT INTO `phone_category` VALUES (1,'魅焰红',1,'2020-05-20 05:14:12','2020-05-21 05:14:13'),(2,'极光蓝',2,'2020-05-20 05:15:20','2020-05-21 05:15:13'),(3,'铂光金',3,'2020-05-20 05:16:30','2020-05-21 05:16:13'),(4,'幻夜黑',4,'2020-05-20 05:17:12','2020-05-21 05:17:13');
/*!40000 ALTER TABLE `phone_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_info`
--

DROP TABLE IF EXISTS `phone_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_info` (
  `phone_id` int NOT NULL AUTO_INCREMENT,
  `phone_name` varchar(20) NOT NULL COMMENT '商品名称',
  `phone_price` decimal(10,2) NOT NULL COMMENT '商品价格\n',
  `phone_description` varchar(10) NOT NULL COMMENT '商品颜色信息',
  `phone_stock` int NOT NULL COMMENT '商品库存',
  `phone_icon` varchar(100) NOT NULL COMMENT '商品图片',
  `category_type` int NOT NULL COMMENT '商品类别编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `phone_tag` varchar(100) NOT NULL COMMENT '商品功能介绍',
  PRIMARY KEY (`phone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_info`
--

LOCK TABLES `phone_info` WRITE;
/*!40000 ALTER TABLE `phone_info` DISABLE KEYS */;
INSERT INTO `phone_info` VALUES (1,'Honor 8A',2800.00,'魅焰红',8,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg',1,'2020-05-20 05:14:00','2020-06-06 01:43:35','720P珍珠屏&Micro USB接口'),(2,'Honor 10 青春版',2800.00,'极光蓝',100,'../static/8f0bd0d0-a11e-4185-927e-04b54ff4a1bd.jpg',2,'2020-05-21 05:14:00','2020-05-22 05:14:00','720P珍珠屏&EMUI9 Lite'),(3,'Honor V20',3450.00,'铂光金',100,'../static/fd7fee3c-a35c-477b-b007-9fda6e9c589a.jpg',3,'2020-05-22 05:14:00','2020-05-23 05:14:00','2+1独立三卡槽'),(4,'HUAWEI Mate 20 Pro',4550.00,'幻夜黑',100,'../static/cb819ad9-ec6f-4123-a4e9-aa629e2f8224.jpg',4,'2020-05-23 05:14:00','2020-05-24 05:14:00','内存3GB&EMUI9 Lite'),(5,'HUAWEI nova 5 Pro',5450.00,'魅焰红',100,'../static/8a0f5be0-3c78-4f23-b58b-dc2a92f1f95a.jpg',1,'2020-05-24 05:14:00','2020-05-25 05:14:00','内存3GB&Micro USB接口'),(6,'HUAWEI P30',8700.00,'极光蓝',100,'../static/6dcad185-315f-40f0-87f2-52910f49c8b7.jpg',2,'2020-05-25 05:14:00','2020-05-26 05:14:00','720P珍珠屏&内存3GB'),(7,'HUAWEI P30 Pro',8988.00,'铂光金',100,'../static/b12a46a9-3738-49ab-ab3a-6878539bd76b.jpg',3,'2020-05-26 05:14:00','2020-05-27 05:14:00','720P珍珠屏&Micro USB接口'),(8,'HUAWEI 畅想9 Plus',2760.00,'幻夜黑',100,'../static/15a5dcf2-4b50-41a0-93e8-08df97c21341.jpg',4,'2020-05-27 05:14:00','2020-05-28 05:14:00','内存3GB&存储32GB'),(9,'SAMSUNG G S10',7254.00,'魅焰红',100,'../static/a4f0cef8-59da-4f7c-abfa-d373f6648035.jpg',1,'2020-05-28 05:14:00','2020-05-29 05:14:00','720P珍珠屏&存储32GB'),(10,'OPPO K3',2889.00,'极光蓝',100,'../static/efc31538-a1f0-4dba-a673-4369f17e5708.jpg',2,'2020-05-29 05:14:00','2020-05-30 05:14:00','存储32GB&Micro USB接口'),(11,'Iphone XR',9888.00,'铂光金',100,'../static/4ef5a3c0-ad88-495f-a6bc-a31c1dde667b.jpg',3,'2020-05-30 05:14:00','2020-05-31 05:14:00','1300万像素&Micro USB接口'),(12,'MI 8',5888.00,'幻夜黑',100,'../static/aff8224c-3196-42a9-ae9e-4f06e20555c4.jpg',4,'2020-05-31 05:14:00','2020-06-01 05:14:00','内存3GB&存储32GB'),(13,'VIVO X27',2888.00,'魅焰红',100,'../static/cdf065ec-e409-4204-93e6-600e172e461a.jpg',1,'2020-06-01 05:14:00','2020-06-02 05:14:00','F/1.8光圈&Micro USB接口'),(14,'Iphone 6',5678.00,'极光蓝',100,'../static/899a9c64-62d0-416d-b320-e730b4585cb0.jpg',2,'2020-06-02 05:14:00','2020-06-03 05:14:00','720P珍珠屏&F/1.8光圈'),(15,'Iphone 7',5576.00,'铂光金',100,'../static/67aa6e9b-681f-4a6f-aae4-97eb3ec51b08.jpg',3,'2020-06-03 05:14:00','2020-06-04 05:14:00','720P珍珠屏&1300万像素'),(16,'Iphone 8',6212.00,'幻夜黑',100,'../static/a8b5b846-7fbb-4e7b-abcf-01ae73979000.jpg',4,'2020-06-04 05:14:00','2020-06-05 05:14:00','内存3GB&F/1.8光圈'),(17,'Meizu 16s',1220.00,'魅焰红',100,'../static/1a2b8e30-6e98-405f-9a18-9cd31ff96c35.jpg',1,'2020-06-05 05:14:00','2020-06-06 05:14:00','720P珍珠屏&Micro USB接口'),(18,'Iphone X',6770.00,'极光蓝',100,'../static/6f2806ba-48f2-4c41-88f0-a455adc2bd38.jpg',2,'2020-06-06 05:14:00','2020-06-07 05:14:00','F/1.8光圈&Micro USB接口'),(19,'HUAWEI p20',5580.00,'铂光金',100,'../static/f382351b-7fc8-4b34-bcce-162085e75191.jpg',3,'2020-06-07 05:14:00','2020-06-08 05:14:00','1300万像素&Micro USB接口');
/*!40000 ALTER TABLE `phone_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_specs`
--

DROP TABLE IF EXISTS `phone_specs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_specs` (
  `specs_id` int NOT NULL AUTO_INCREMENT,
  `phone_id` int NOT NULL COMMENT '商品编号',
  `specs_name` varchar(20) NOT NULL COMMENT '商品规格名称',
  `specs_stock` int NOT NULL COMMENT '商品规格库存',
  `specs_price` decimal(10,2) NOT NULL COMMENT '商品规格价格',
  `specs_icon` varchar(60) NOT NULL COMMENT '商品规格图片大',
  `specs_preview` varchar(60) NOT NULL COMMENT '商品规格图片小',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`specs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品规格表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_specs`
--

LOCK TABLES `phone_specs` WRITE;
/*!40000 ALTER TABLE `phone_specs` DISABLE KEYS */;
INSERT INTO `phone_specs` VALUES (1,1,'32GB',4,280000.00,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','2020-06-05 14:03:07','2020-05-20 05:19:00'),(2,1,'64GB',4,320000.00,'../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg','2020-06-06 01:43:35','2020-05-20 05:21:00');
/*!40000 ALTER TABLE `phone_specs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-06 11:08:32
