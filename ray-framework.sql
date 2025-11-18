-- MySQL dump 10.13  Distrib 8.3.0, for macos14 (arm64)
--
-- Host: localhost    Database: ray-framework
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `sys_auth_log`
--

DROP TABLE IF EXISTS `sys_auth_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_auth_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint NOT NULL COMMENT '日志类型：1=登录；2=登出；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录人',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `login_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录IP地址',
  `browser` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器',
  `browser_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器版本',
  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '平台',
  `os` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统',
  `os_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统版本',
  `engine` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎',
  `engine_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎版本',
  `exe_time` bigint NOT NULL DEFAULT '0' COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统认证日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_auth_log`
--

LOCK TABLES `sys_auth_log` WRITE;
/*!40000 ALTER TABLE `sys_auth_log` DISABLE KEYS */;
INSERT INTO `sys_auth_log` VALUES (1,1,'2025-04-07 03:10:25','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',188),(2,1,'2025-04-08 08:57:24','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',194),(3,2,'2025-04-08 08:58:04','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',10),(4,1,'2025-04-08 08:58:50','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',192),(5,2,'2025-04-08 08:59:05','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',13),(6,1,'2025-04-08 09:04:30','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',183),(7,2,'2025-04-08 09:07:17','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',12),(8,1,'2025-04-08 09:11:22','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',41),(9,1,'2025-04-15 06:11:01','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',219),(10,2,'2025-04-15 06:58:05','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',9),(11,1,'2025-04-15 06:58:07','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',31),(12,1,'2025-07-08 10:08:51','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','137.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',244),(13,2,'2025-07-08 10:16:40','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','137.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',7),(14,1,'2025-07-08 10:20:29','2bd631f674af40f19c73c0d8962a4d28','17600891908','127.0.0.1','Chrome','137.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',35);
/*!40000 ALTER TABLE `sys_auth_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '父级编号',
  `code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
  `sequence` int NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(256) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_dept_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (1,'0','6220837f5a994d11a4f5cb4833fc216a','德玛西亚',1,0,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-28 07:18:51','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:56:51'),(2,'6220837f5a994d11a4f5cb4833fc216a','4baaf0e7b8384147ab1309f5f12d8294','研发部',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:22:02','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:22:02'),(3,'6220837f5a994d11a4f5cb4833fc216a','66ec739c41644db9a1ef6c2f085c8370','产品部',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:57:20','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 08:57:20'),(4,'6220837f5a994d11a4f5cb4833fc216a','47e92a5f57114126b95fd62a46f391df','test',1,1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:04:01','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:04:04'),(5,'4baaf0e7b8384147ab1309f5f12d8294','20b16b73651541739f1a298f2b9933f3','研发一部',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:22','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:22'),(6,'4baaf0e7b8384147ab1309f5f12d8294','c31ab656ddcd4446aef40ba8eaabdea1','研发二部',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:30','2bd631f674af40f19c73c0d8962a4d28','2024-09-18 09:43:30');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `value` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'3606a726056c4f72903493a43a62b193','性别','GENDER',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-28 06:22:59','2bd631f674af40f19c73c0d8962a4d28','2024-10-22 08:59:03'),(2,'a812a48ce14a48f38c8ddc9f5ab984af','方向','DIRECTION',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 06:39:27','bd385b2b16e64aba89e46a668901fbe8','2025-01-07 08:21:27'),(3,'bc14496899be4d61a4314ff0025c672e','测试1','TEST1',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:11:41','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(4,'223e8c29d02e43b78be25a93f99f593e','测试2','TEST2',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:54:14','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(5,'77b64a60db80486f8238d1e492e02daf','测试3','TEST3',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:55:50','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(6,'5bd0023525cd4b03b7ba6290be3d4a36','测试4','TEST4',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:55:59','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(7,'2f1a03b292b9402287454c9a12c18d09','测试5','TEST5',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 10:56:04','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(8,'ec500a22f9ce46d3a18b9e87a782fdfe','测试6','TEST6',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:05:49','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(9,'c9d2372540464bd9999d1603da6008ae','测试7','TEST7',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:05:55','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(10,'06a80c6ba3614cb6803a7f7837272aa1','测试8','TEST8',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:06:01','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(11,'6bc10de58ba148c9af40f9e972b8fba3','测试9','TEST9',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:06:06','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11'),(12,'17419b93799a42d8b23e3183eb270d2f','测试10','TEST10',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 11:06:13','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:53:11');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_item`
--

DROP TABLE IF EXISTS `sys_dict_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_item` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_value` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属字典',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容名称',
  `value` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典值',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用',
  `sequence` int NOT NULL DEFAULT '100' COMMENT '排序',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_item`
--

LOCK TABLES `sys_dict_item` WRITE;
/*!40000 ALTER TABLE `sys_dict_item` DISABLE KEYS */;
INSERT INTO `sys_dict_item` VALUES (2,'GENDER','50d32e1e15cf498e87dfccdefe7d9bc9','男','MALE',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 03:58:13','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:48:26'),(3,'GENDER','8c583631b761435bb6ff4c03022f4367','女','FEMALE',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:39:54','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:20'),(5,'DIRECTION','fc60415f377b4ef183675f7a964aed34','东','EAST',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:36','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:36'),(6,'DIRECTION','c9ce6f8cf7e34e32a9022e24e0d402da','西','WEST',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:50:44','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:22'),(7,'DIRECTION','229eb399e9ec43b4a25b4206a94018bb','南','SOUTH',1,3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:18','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:18'),(8,'DIRECTION','16505e5563fe4965846662f78e2cc6e1','北','NORTH',1,4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:51','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:51');
/*!40000 ALTER TABLE `sys_dict_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_func`
--

DROP TABLE IF EXISTS `sys_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_func` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '父级编号',
  `code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型：0=目录，1=功能；2=按钮；3=外链',
  `icon` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `path` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '路由地址',
  `redirect` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '重定向地址',
  `linkable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否外链',
  `cacheable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否缓存',
  `visible` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可见',
  `always_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '始终显示根菜单',
  `permission` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限',
  `component` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '组件',
  `sequence` int NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_func_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统功能表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_func`
--

LOCK TABLES `sys_func` WRITE;
/*!40000 ALTER TABLE `sys_func` DISABLE KEYS */;
INSERT INTO `sys_func` VALUES (1,'0','0e5580ae61f54380bbc9f473655060bc','系统管理',0,'system','/system','',0,0,1,1,'ray:system','Layout',99,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-29 02:40:45','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:50:12'),(2,'0e5580ae61f54380bbc9f473655060bc','6bfb7cc5de7a4d9c9b70d8563c7377ec','用户管理',1,'user','user','',0,0,1,0,'ray:system:users','system/user/index',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-29 09:22:11','2bd631f674af40f19c73c0d8962a4d28','2024-05-24 13:13:48'),(3,'0e5580ae61f54380bbc9f473655060bc','7982cdc53a124340ab7da5e3f130b419','角色管理',1,'role','role','',0,0,1,0,'ray:system:roles','system/role/index',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:44:17','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:44:17'),(4,'0e5580ae61f54380bbc9f473655060bc','86132348f09a4a8299d949d12f1237b4','菜单管理',1,'menu','menu','',0,0,1,0,'ray:system:funcs','system/menu/index',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:46:02','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:47:56'),(5,'0e5580ae61f54380bbc9f473655060bc','9c476acf5ed34dd19a4f8037a065a669','部门管理',1,'tree','dept','',0,0,1,0,'ray:system:depts','system/dept/index',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:47:50','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:51:55'),(6,'0e5580ae61f54380bbc9f473655060bc','5b9a474efbc14b6e865e51cbbd16f311','字典管理',1,'dict','dict','',0,0,1,0,'ray:system:dicts','system/dict/index',5,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:48:49','2bd631f674af40f19c73c0d8962a4d28','2024-10-08 06:18:09'),(7,'0e5580ae61f54380bbc9f473655060bc','76ed9e00ddcc4e58a60a8b86ebc5bbc6','日志管理',1,'document','log','',0,1,1,0,'ray:system:logs','system/log/index',7,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-30 03:29:58','2bd631f674af40f19c73c0d8962a4d28','2025-04-02 10:41:49'),(8,'5b9a474efbc14b6e865e51cbbd16f311','cf7068d9d6d84afcb4a59b803e1e1a2f','创建字典',2,'','','',0,0,0,0,'ray:system:dicts:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:20:18','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:07'),(9,'5b9a474efbc14b6e865e51cbbd16f311','97d0150bf2ec45fbbf14cc3c6e0f5d14','搜索字典',2,'','','',0,0,0,0,'ray:system:dicts:search','',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:20:57','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:34:53'),(10,'5b9a474efbc14b6e865e51cbbd16f311','0bd07cc721d94942bc1001ccd1fe9e14','编辑字典',2,'','','',0,0,0,0,'ray:system:dicts:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:25:23','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:10'),(11,'5b9a474efbc14b6e865e51cbbd16f311','fb05ae0889da4e089c09a987e2e1673c','删除字典',2,'','','',0,0,0,0,'ray:system:dicts:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:25:52','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:13'),(12,'5b9a474efbc14b6e865e51cbbd16f311','c37f6402651a4dc09cd250dda79ed7fc','字典项管理',2,'','','',0,0,0,0,'ray:system:dicts:items','',5,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:26:29','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:34:56'),(13,'5b9a474efbc14b6e865e51cbbd16f311','6b7666bd1dab4e20974422295de536e2','创建字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:create','',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:29:21','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:16'),(14,'5b9a474efbc14b6e865e51cbbd16f311','cb5684b760cf4fa29f1816e141b3ee10','搜索字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:search','',6,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:31:44','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:00'),(15,'5b9a474efbc14b6e865e51cbbd16f311','89bdd7e788e1476fb56035a8b4760e44','编辑字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:edit','',5,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:38:28','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:20'),(16,'5b9a474efbc14b6e865e51cbbd16f311','62e4f7d81aa2417db99845a4f663d419','删除字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:delete','',6,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:38:43','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:24'),(17,'6bfb7cc5de7a4d9c9b70d8563c7377ec','a69358b0070f447db2ad7c3c42297270','创建用户',2,'','','',0,0,0,0,'ray:system:users:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:50','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:18'),(18,'6bfb7cc5de7a4d9c9b70d8563c7377ec','85471b98e6e0478f916c431b93e65dad','编辑用户',2,'','','',0,0,0,0,'ray:system:users:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:22:53','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:21'),(19,'6bfb7cc5de7a4d9c9b70d8563c7377ec','4fe517c3a47a4b3e820ae812327f48cd','删除用户',2,'','','',0,0,0,0,'ray:system:users:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:23:07','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:26'),(20,'6bfb7cc5de7a4d9c9b70d8563c7377ec','b60ca056b2404078ac905f59caa992d2','重置密码',2,'','','',0,0,0,0,'ray:system:users:reset','',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:23:25','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:29'),(21,'9c476acf5ed34dd19a4f8037a065a669','743f88e0ec7a4047b74d9487a8826e93','创建部门',2,'','','',0,0,0,0,'ray:system:depts:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:44','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:44'),(22,'9c476acf5ed34dd19a4f8037a065a669','6371d5a4b47c41fe984d8e4d960c9460','编辑部门',2,'','','',0,0,0,0,'ray:system:depts:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:59','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:59'),(23,'9c476acf5ed34dd19a4f8037a065a669','9b3793acfb7d485dbeee68e11524cc1d','删除部门',2,'','','',0,0,0,0,'ray:system:depts:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:12:11','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:12:11'),(24,'0e5580ae61f54380bbc9f473655060bc','51e96aa3fa43456eb5ff9be56ae26914','字典项管理',1,'dict','dictItem','',0,0,0,0,'ray:system:dict-items','system/dict/item',6,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-01 08:44:32','2bd631f674af40f19c73c0d8962a4d28','2025-04-02 01:55:29'),(25,'0','3c7948cf4a254fc58ae44ebbec192e7a','资产管理',0,'homepage','/asset','',0,0,1,1,'ray:asset','Layout',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:47:55','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:52:44'),(26,'3c7948cf4a254fc58ae44ebbec192e7a','74fd75f1fdae4f65859e4723ccdc2236','分类管理',1,'tree','category','',0,0,1,0,'ray:asset:category','asset/category/index',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:53:57','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:53:57');
/*!40000 ALTER TABLE `sys_func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operate_log`
--

DROP TABLE IF EXISTS `sys_operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_operate_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` tinyint NOT NULL COMMENT '日志类型：1=操作；2=错误；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录人',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `module` varchar(16) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块名称',
  `func` varchar(16) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '功能名称',
  `remark` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '功能描述',
  `action` varchar(16) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '动作描述',
  `ip` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求IP',
  `url` varchar(512) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Url',
  `uri` varchar(512) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Uri',
  `method` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Method',
  `class_name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求类名',
  `method_name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求方法名',
  `browser` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器',
  `browser_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器版本',
  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '平台',
  `os` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统',
  `os_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统版本',
  `engine` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎',
  `engine_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎版本',
  `exe_time` bigint NOT NULL DEFAULT '0' COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operate_log`
--

LOCK TABLES `sys_operate_log` WRITE;
/*!40000 ALTER TABLE `sys_operate_log` DISABLE KEYS */;
INSERT INTO `sys_operate_log` VALUES (3,1,'2025-04-07 03:12:22','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','用户管理','修改用户','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysUserController','','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',21),(4,1,'2025-04-08 09:04:36','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','用户管理','修改用户','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysUserController','','Chrome','134.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',46),(5,1,'2025-04-15 06:47:56','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','创建功能','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1','/console/v1/funcs/v1','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',18),(6,1,'2025-04-15 06:49:39','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','修改功能','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a','/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',45),(7,1,'2025-04-15 06:50:04','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','修改功能','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a','/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',15),(8,1,'2025-04-15 06:50:12','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','修改功能','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1/0e5580ae61f54380bbc9f473655060bc','/console/v1/funcs/v1/0e5580ae61f54380bbc9f473655060bc','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',17),(9,1,'2025-04-15 06:52:45','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','修改功能','UPDATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a','/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a','PUT','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',20),(10,1,'2025-04-15 06:53:58','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','功能管理','创建功能','CREATE','127.0.0.1','http://127.0.0.1:28080/console/v1/funcs/v1','/console/v1/funcs/v1','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',15),(11,1,'2025-04-15 06:58:02','2bd631f674af40f19c73c0d8962a4d28','17600891908','系统管理','角色管理','保存授权功能','GRANT','127.0.0.1','http://127.0.0.1:28080/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func','/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func','POST','cc.xuepeng.ray.framework.module.system.api.controller.SysRoleController','','Chrome','135.0.0.0','Mac','OSX','10_15_7','Webkit','537.36',33),(12,1,'2025-10-30 09:04:27','','','系统管理','操作日志管理','分页查询操作日志','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/operate-logs/v1/page','/console/v1/operate-logs/v1/page','GET','controller.cc.xuepeng.ray.framework.module.log.SysOperateLogController','','Unknown','','Unknown','Unknown','','Unknown','',0);
/*!40000 ALTER TABLE `sys_operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operate_log_detail`
--

DROP TABLE IF EXISTS `sys_operate_log_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_operate_log_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_id` bigint DEFAULT NULL COMMENT '系统日志主键',
  `param` text COLLATE utf8mb4_general_ci COMMENT '请求路径参数',
  `args` text COLLATE utf8mb4_general_ci COMMENT '请求方法参数',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '返回值',
  `error` text COLLATE utf8mb4_general_ci COMMENT '错误信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operate_log_detail`
--

LOCK TABLES `sys_operate_log_detail` WRITE;
/*!40000 ALTER TABLE `sys_operate_log_detail` DISABLE KEYS */;
INSERT INTO `sys_operate_log_detail` VALUES (1,3,NULL,'[arg0:2bd631f674af40f19c73c0d8962a4d28][arg1:SysUserRequest(deptCode=6220837f5a994d11a4f5cb4833fc216a, roleCodes=[2c2650abd2814511a7eee37e422ac97a], phoneNumber=17600891908, name=盖伦, email=17600891908@qq.com, status=BizStatus.ENABLE(code=1, desc=启用), remark=)]','Result(code=20000, desc=成功, msg=修改系统用户成功, data=true)',NULL),(2,4,NULL,'[arg0:2bd631f674af40f19c73c0d8962a4d28][arg1:SysUserRequest(deptCode=6220837f5a994d11a4f5cb4833fc216a, roleCodes=[2c2650abd2814511a7eee37e422ac97a], phoneNumber=17600891908, name=盖伦, email=17600891908@qq.com, status=BizStatus.ENABLE(code=1, desc=启用), remark=)]','Result(code=20000, desc=成功, msg=修改系统用户成功, data=true)',NULL),(3,5,NULL,'[arg0:SysFuncRequest(parentCode=0, name=资产管理, type=SysFuncType.DICT(code=0, desc=目录), icon=homepage, path=asset, redirect=null, linkable=null, cacheable=false, visible=true, alwaysShow=true, permission=null, component=null, sequence=1, remark=null)]','Result(code=20000, desc=成功, msg=创建系统功能成功, data=true)',NULL),(4,6,NULL,'[arg0:3c7948cf4a254fc58ae44ebbec192e7a][arg1:SysFuncRequest(parentCode=0, name=资产管理, type=SysFuncType.DICT(code=0, desc=目录), icon=homepage, path=asset, redirect=, linkable=false, cacheable=false, visible=true, alwaysShow=true, permission=, component=Layout, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=修改系统功能成功, data=true)',NULL),(5,7,NULL,'[arg0:3c7948cf4a254fc58ae44ebbec192e7a][arg1:SysFuncRequest(parentCode=0, name=资产管理, type=SysFuncType.DICT(code=0, desc=目录), icon=homepage, path=asset, redirect=, linkable=false, cacheable=false, visible=true, alwaysShow=true, permission=ray:asset, component=Layout, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=修改系统功能成功, data=true)',NULL),(6,8,NULL,'[arg0:0e5580ae61f54380bbc9f473655060bc][arg1:SysFuncRequest(parentCode=0, name=系统管理, type=SysFuncType.DICT(code=0, desc=目录), icon=system, path=/system, redirect=, linkable=false, cacheable=false, visible=true, alwaysShow=true, permission=ray:system, component=Layout, sequence=99, remark=)]','Result(code=20000, desc=成功, msg=修改系统功能成功, data=true)',NULL),(7,9,NULL,'[arg0:3c7948cf4a254fc58ae44ebbec192e7a][arg1:SysFuncRequest(parentCode=0, name=资产管理, type=SysFuncType.DICT(code=0, desc=目录), icon=homepage, path=/asset, redirect=, linkable=false, cacheable=false, visible=true, alwaysShow=true, permission=ray:asset, component=Layout, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=修改系统功能成功, data=true)',NULL),(8,10,NULL,'[arg0:SysFuncRequest(parentCode=3c7948cf4a254fc58ae44ebbec192e7a, name=分类管理, type=SysFuncType.MENU(code=1, desc=功能), icon=tree, path=category, redirect=null, linkable=false, cacheable=false, visible=true, alwaysShow=false, permission=ray:asset:category, component=asset/category/index, sequence=1, remark=)]','Result(code=20000, desc=成功, msg=创建系统功能成功, data=true)',NULL),(9,11,NULL,'[arg0:2c2650abd2814511a7eee37e422ac97a][arg1:[3c7948cf4a254fc58ae44ebbec192e7a, 74fd75f1fdae4f65859e4723ccdc2236, 0e5580ae61f54380bbc9f473655060bc, 6bfb7cc5de7a4d9c9b70d8563c7377ec, a69358b0070f447db2ad7c3c42297270, 85471b98e6e0478f916c431b93e65dad, 4fe517c3a47a4b3e820ae812327f48cd, b60ca056b2404078ac905f59caa992d2, 7982cdc53a124340ab7da5e3f130b419, 86132348f09a4a8299d949d12f1237b4, 9c476acf5ed34dd19a4f8037a065a669, 743f88e0ec7a4047b74d9487a8826e93, 6371d5a4b47c41fe984d8e4d960c9460, 9b3793acfb7d485dbeee68e11524cc1d, 5b9a474efbc14b6e865e51cbbd16f311, cf7068d9d6d84afcb4a59b803e1e1a2f, 0bd07cc721d94942bc1001ccd1fe9e14, fb05ae0889da4e089c09a987e2e1673c, 6b7666bd1dab4e20974422295de536e2, 89bdd7e788e1476fb56035a8b4760e44, 62e4f7d81aa2417db99845a4f663d419, 51e96aa3fa43456eb5ff9be56ae26914, 76ed9e00ddcc4e58a60a8b86ebc5bbc6]]','Result(code=20000, desc=成功, msg=授权功能成功, data=true)',NULL),(10,12,NULL,'[arg0:SysOperateLogRequest(module=null)]','Result(code=20000, desc=成功, msg=分页查询操作日志列表, data=PageResponse(current=1, size=20, total=9, records=[SysOperateLogResponse(id=11, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-15T14:58:02, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=角色管理, remark=保存授权功能, action=GRANT, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func, uri=/console/v1/roles/v1/2c2650abd2814511a7eee37e422ac97a/grant-func, method=POST, className=cc.xuepeng.ray.framework.module.system.api.controller.SysRoleController, methodName=, browser=Chrome, browserVersion=135.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=33), SysOperateLogResponse(id=10, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-15T14:53:58, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=功能管理, remark=创建功能, action=CREATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/funcs/v1, uri=/console/v1/funcs/v1, method=POST, className=cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController, methodName=, browser=Chrome, browserVersion=135.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=15), SysOperateLogResponse(id=9, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-15T14:52:45, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=功能管理, remark=修改功能, action=UPDATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a, uri=/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a, method=PUT, className=cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController, methodName=, browser=Chrome, browserVersion=135.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=20), SysOperateLogResponse(id=8, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-15T14:50:12, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=功能管理, remark=修改功能, action=UPDATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/funcs/v1/0e5580ae61f54380bbc9f473655060bc, uri=/console/v1/funcs/v1/0e5580ae61f54380bbc9f473655060bc, method=PUT, className=cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController, methodName=, browser=Chrome, browserVersion=135.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=17), SysOperateLogResponse(id=7, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-15T14:50:04, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=功能管理, remark=修改功能, action=UPDATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a, uri=/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a, method=PUT, className=cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController, methodName=, browser=Chrome, browserVersion=135.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=15), SysOperateLogResponse(id=6, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-15T14:49:39, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=功能管理, remark=修改功能, action=UPDATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a, uri=/console/v1/funcs/v1/3c7948cf4a254fc58ae44ebbec192e7a, method=PUT, className=cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController, methodName=, browser=Chrome, browserVersion=135.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=45), SysOperateLogResponse(id=5, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-15T14:47:56, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=功能管理, remark=创建功能, action=CREATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/funcs/v1, uri=/console/v1/funcs/v1, method=POST, className=cc.xuepeng.ray.framework.module.system.api.controller.SysFuncController, methodName=, browser=Chrome, browserVersion=135.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=18), SysOperateLogResponse(id=4, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-08T17:04:36, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=用户管理, remark=修改用户, action=UPDATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28, uri=/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28, method=PUT, className=cc.xuepeng.ray.framework.module.system.api.controller.SysUserController, methodName=, browser=Chrome, browserVersion=134.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=46), SysOperateLogResponse(id=3, createUser=2bd631f674af40f19c73c0d8962a4d28, createTime=2025-04-07T11:12:22, phoneNumber=17600891908, type=SysOperateLogType.ACCESS(code=1, desc=操作日志), module=系统管理, func=用户管理, remark=修改用户, action=UPDATE, ip=127.0.0.1, url=http://127.0.0.1:28080/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28, uri=/console/v1/users/v1/2bd631f674af40f19c73c0d8962a4d28, method=PUT, className=cc.xuepeng.ray.framework.module.system.api.controller.SysUserController, methodName=, browser=Chrome, browserVersion=134.0.0.0, platform=Mac, os=OSX, osVersion=10_15_7, engine=Webkit, engineVersion=537.36, exeTime=21)]))',NULL);
/*!40000 ALTER TABLE `sys_operate_log_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
  `sequence` int NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_role_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'2c2650abd2814511a7eee37e422ac97a','ROLE_SUPER_ADMIN',1,1,'超级管理员',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-28 07:19:30','2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:32:05'),(2,'c1b1d17824a14a2286a0150c048987d8','ROLE_SYSTEM_ADMIN',1,2,'系统管理员',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:18:04','2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:32:05');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_func_relation`
--

DROP TABLE IF EXISTS `sys_role_func_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_func_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `func_code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '功能编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与功能的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_func_relation`
--

LOCK TABLES `sys_role_func_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_func_relation` DISABLE KEYS */;
INSERT INTO `sys_role_func_relation` VALUES (200,'c1b1d17824a14a2286a0150c048987d8','0e5580ae61f54380bbc9f473655060bc'),(201,'c1b1d17824a14a2286a0150c048987d8','6bfb7cc5de7a4d9c9b70d8563c7377ec'),(202,'c1b1d17824a14a2286a0150c048987d8','a69358b0070f447db2ad7c3c42297270'),(203,'c1b1d17824a14a2286a0150c048987d8','85471b98e6e0478f916c431b93e65dad'),(204,'c1b1d17824a14a2286a0150c048987d8','4fe517c3a47a4b3e820ae812327f48cd'),(205,'c1b1d17824a14a2286a0150c048987d8','b60ca056b2404078ac905f59caa992d2'),(206,'c1b1d17824a14a2286a0150c048987d8','9c476acf5ed34dd19a4f8037a065a669'),(207,'c1b1d17824a14a2286a0150c048987d8','743f88e0ec7a4047b74d9487a8826e93'),(208,'c1b1d17824a14a2286a0150c048987d8','6371d5a4b47c41fe984d8e4d960c9460'),(209,'c1b1d17824a14a2286a0150c048987d8','9b3793acfb7d485dbeee68e11524cc1d'),(231,'2c2650abd2814511a7eee37e422ac97a','3c7948cf4a254fc58ae44ebbec192e7a'),(232,'2c2650abd2814511a7eee37e422ac97a','74fd75f1fdae4f65859e4723ccdc2236'),(233,'2c2650abd2814511a7eee37e422ac97a','0e5580ae61f54380bbc9f473655060bc'),(234,'2c2650abd2814511a7eee37e422ac97a','6bfb7cc5de7a4d9c9b70d8563c7377ec'),(235,'2c2650abd2814511a7eee37e422ac97a','a69358b0070f447db2ad7c3c42297270'),(236,'2c2650abd2814511a7eee37e422ac97a','85471b98e6e0478f916c431b93e65dad'),(237,'2c2650abd2814511a7eee37e422ac97a','4fe517c3a47a4b3e820ae812327f48cd'),(238,'2c2650abd2814511a7eee37e422ac97a','b60ca056b2404078ac905f59caa992d2'),(239,'2c2650abd2814511a7eee37e422ac97a','7982cdc53a124340ab7da5e3f130b419'),(240,'2c2650abd2814511a7eee37e422ac97a','86132348f09a4a8299d949d12f1237b4'),(241,'2c2650abd2814511a7eee37e422ac97a','9c476acf5ed34dd19a4f8037a065a669'),(242,'2c2650abd2814511a7eee37e422ac97a','743f88e0ec7a4047b74d9487a8826e93'),(243,'2c2650abd2814511a7eee37e422ac97a','6371d5a4b47c41fe984d8e4d960c9460'),(244,'2c2650abd2814511a7eee37e422ac97a','9b3793acfb7d485dbeee68e11524cc1d'),(245,'2c2650abd2814511a7eee37e422ac97a','5b9a474efbc14b6e865e51cbbd16f311'),(246,'2c2650abd2814511a7eee37e422ac97a','cf7068d9d6d84afcb4a59b803e1e1a2f'),(247,'2c2650abd2814511a7eee37e422ac97a','0bd07cc721d94942bc1001ccd1fe9e14'),(248,'2c2650abd2814511a7eee37e422ac97a','fb05ae0889da4e089c09a987e2e1673c'),(249,'2c2650abd2814511a7eee37e422ac97a','6b7666bd1dab4e20974422295de536e2'),(250,'2c2650abd2814511a7eee37e422ac97a','89bdd7e788e1476fb56035a8b4760e44'),(251,'2c2650abd2814511a7eee37e422ac97a','62e4f7d81aa2417db99845a4f663d419'),(252,'2c2650abd2814511a7eee37e422ac97a','51e96aa3fa43456eb5ff9be56ae26914'),(253,'2c2650abd2814511a7eee37e422ac97a','76ed9e00ddcc4e58a60a8b86ebc5bbc6');
/*!40000 ALTER TABLE `sys_role_func_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_user_relation`
--

DROP TABLE IF EXISTS `sys_role_user_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_user_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `user_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与用户的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user_relation`
--

LOCK TABLES `sys_role_user_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_user_relation` DISABLE KEYS */;
INSERT INTO `sys_role_user_relation` VALUES (10,'c1b1d17824a14a2286a0150c048987d8','bd385b2b16e64aba89e46a668901fbe8'),(11,'c1b1d17824a14a2286a0150c048987d8','67348a262c4048a9b12ddbdbfb2b437c'),(15,'2c2650abd2814511a7eee37e422ac97a','2bd631f674af40f19c73c0d8962a4d28');
/*!40000 ALTER TABLE `sys_role_user_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dept_code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门编号',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `phone_number` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `name` varchar(32) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `password` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(128) COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `avatar` varchar(256) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'6220837f5a994d11a4f5cb4833fc216a','2bd631f674af40f19c73c0d8962a4d28','17600891908','盖伦','670b14728ad9902aecba32e22fa4f6bd','17600891908@qq.com','http://5b0988e595225.cdn.sohucs.com/images/20190513/8e9becdd22bc47ba95ec7c79cebdbcb2.jpeg',1,'',0,'6220837f5a994d11a4f5cb4833fc216a','2024-04-25 08:18:08','2bd631f674af40f19c73c0d8962a4d28','2025-04-08 09:11:15'),(2,'6220837f5a994d11a4f5cb4833fc216a','67348a262c4048a9b12ddbdbfb2b437c','15810051066','卡特琳娜','670b14728ad9902aecba32e22fa4f6bd','15810051066@qq.com','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-22 02:03:21','2bd631f674af40f19c73c0d8962a4d28','2025-01-02 05:58:00'),(3,'66ec739c41644db9a1ef6c2f085c8370','bd385b2b16e64aba89e46a668901fbe8','13840586729','伊泽瑞尔','670b14728ad9902aecba32e22fa4f6bd','13840586729@qq.com','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-02 05:57:52','2bd631f674af40f19c73c0d8962a4d28','2025-01-07 08:20:42');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ray-framework'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-11 17:42:10
