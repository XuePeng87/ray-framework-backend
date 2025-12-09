-- MySQL dump 10.13  Distrib 8.3.0, for macos14 (arm64)
--
-- Host: localhost    Database: anov-server-system
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
  `tenant_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户编号',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统认证日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_auth_log`
--

LOCK TABLES `sys_auth_log` WRITE;
/*!40000 ALTER TABLE `sys_auth_log` DISABLE KEYS */;
INSERT INTO `sys_auth_log` VALUES (1,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 09:35:21','236eda0717874d40bc3eec8148d3518b','15810051066','0:0:0:0:0:0:0:1','Unknown','','Unknown','Unknown','','Unknown','',69);
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
  `tenant_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户编号',
  `parent_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '父级编号',
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
  UNIQUE KEY `sys_dept_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (1,'e79b0554909b4d43921e53d99f325842','0','cec9d9f97c63401280f4d1eade22cdd9','超级部门',1,0,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-11-27 03:06:56','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:39:05'),(4,'1375e003afdd4603b8a39b562bd78892','0','bcd1888183ef4070a70718d8427e4140','德玛西亚',1,1,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:49:03','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:49:03'),(5,'1375e003afdd4603b8a39b562bd78892','bcd1888183ef4070a70718d8427e4140','93f5ca31f8ea41b8ad3746c8262b96cb','坦克组',1,1,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:49:42','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:49:42'),(6,'1375e003afdd4603b8a39b562bd78892','bcd1888183ef4070a70718d8427e4140','0b50dc4527be4ceb80ca0b9530b47b49','战士组',1,2,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:49:51','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:52:12'),(7,'1375e003afdd4603b8a39b562bd78892','bcd1888183ef4070a70718d8427e4140','7ae3b8a6c2b74ce297934d8f47d73d3b','刺客组',1,3,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:50:15','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:53:29'),(8,'1375e003afdd4603b8a39b562bd78892','bcd1888183ef4070a70718d8427e4140','30464a20e5e84a979c9af072a1ec88db','法师组',1,4,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:02:25','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:03:11');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'3606a726056c4f72903493a43a62b193','性别','GENDER',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-28 06:22:59','2bd631f674af40f19c73c0d8962a4d28','2024-10-22 08:59:03'),(2,'a812a48ce14a48f38c8ddc9f5ab984af','方向','DIRECTION',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-30 06:39:27','bd385b2b16e64aba89e46a668901fbe8','2025-01-07 08:21:27'),(13,'40d6966bd87048a9961c8a2472195720','季节','SEASON',1,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:07:32','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:14:38');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_item`
--

LOCK TABLES `sys_dict_item` WRITE;
/*!40000 ALTER TABLE `sys_dict_item` DISABLE KEYS */;
INSERT INTO `sys_dict_item` VALUES (2,'GENDER','50d32e1e15cf498e87dfccdefe7d9bc9','男','MALE',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 03:58:13','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:48:26'),(3,'GENDER','8c583631b761435bb6ff4c03022f4367','女','FEMALE',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:39:54','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:20'),(5,'DIRECTION','fc60415f377b4ef183675f7a964aed34','东','EAST',1,1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:36','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:49:36'),(6,'DIRECTION','c9ce6f8cf7e34e32a9022e24e0d402da','西','WEST',1,2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:50:44','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:22'),(7,'DIRECTION','229eb399e9ec43b4a25b4206a94018bb','南','SOUTH',1,3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:18','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:18'),(8,'DIRECTION','16505e5563fe4965846662f78e2cc6e1','北','NORTH',1,4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:51','2bd631f674af40f19c73c0d8962a4d28','2024-06-04 06:51:51'),(9,'SEASON','ce8493c5a98b40cdaa92cd82329def6a','春','SPRING',1,1,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:23:17','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:23:17'),(10,'SEASON','3e1b1fdc586347a38b6fd8b459a9f74d','夏','SUMMER',1,2,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:23:41','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:25:17'),(11,'SEASON','be0495926d2242c0892fd395c5087455','秋','AUTUMN',1,3,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:24:00','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:24:00'),(12,'SEASON','bce1b1c4b32e4263a4ec355bdeaa7e89','冬','WINTER',1,4,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:24:16','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 03:29:51');
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
  `parent_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '父级编号',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型：0=目录，1=功能；2=按钮；3=外链',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统功能表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_func`
--

LOCK TABLES `sys_func` WRITE;
/*!40000 ALTER TABLE `sys_func` DISABLE KEYS */;
INSERT INTO `sys_func` VALUES (1,'0','0e5580ae61f54380bbc9f473655060bc','系统管理',0,'system','/system','',0,0,1,1,'ray:system','Layout',99,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-29 02:40:45','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:50:12'),(2,'0e5580ae61f54380bbc9f473655060bc','6bfb7cc5de7a4d9c9b70d8563c7377ec','用户管理',1,'user','user','',0,0,1,0,'ray:system:users','system/user/index',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-29 09:22:11','2bd631f674af40f19c73c0d8962a4d28','2024-05-24 13:13:48'),(3,'0e5580ae61f54380bbc9f473655060bc','7982cdc53a124340ab7da5e3f130b419','角色管理',1,'role','role','',0,0,1,0,'ray:system:roles','system/role/index',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:44:17','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:44:17'),(4,'0e5580ae61f54380bbc9f473655060bc','86132348f09a4a8299d949d12f1237b4','菜单管理',1,'menu','menu','',0,0,1,0,'ray:system:funcs','system/menu/index',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:46:02','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:47:56'),(5,'0e5580ae61f54380bbc9f473655060bc','9c476acf5ed34dd19a4f8037a065a669','部门管理',1,'tree','dept','',0,0,1,0,'ray:system:depts','system/dept/index',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:47:50','2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:51:55'),(6,'0e5580ae61f54380bbc9f473655060bc','5b9a474efbc14b6e865e51cbbd16f311','字典管理',1,'dict','dict','',0,0,1,0,'ray:system:dicts','system/dict/index',5,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-05-25 09:48:49','2bd631f674af40f19c73c0d8962a4d28','2024-10-08 06:18:09'),(7,'0e5580ae61f54380bbc9f473655060bc','76ed9e00ddcc4e58a60a8b86ebc5bbc6','日志管理',1,'document','log','',0,1,1,0,'ray:system:logs','system/log/index',7,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-09-30 03:29:58','2bd631f674af40f19c73c0d8962a4d28','2025-04-02 10:41:49'),(8,'5b9a474efbc14b6e865e51cbbd16f311','cf7068d9d6d84afcb4a59b803e1e1a2f','创建字典',2,'','','',0,0,0,0,'ray:system:dicts:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:20:18','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:07'),(9,'5b9a474efbc14b6e865e51cbbd16f311','97d0150bf2ec45fbbf14cc3c6e0f5d14','搜索字典',2,'','','',0,0,0,0,'ray:system:dicts:search','',1,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:20:57','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:34:53'),(10,'5b9a474efbc14b6e865e51cbbd16f311','0bd07cc721d94942bc1001ccd1fe9e14','编辑字典',2,'','','',0,0,0,0,'ray:system:dicts:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:25:23','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:10'),(11,'5b9a474efbc14b6e865e51cbbd16f311','fb05ae0889da4e089c09a987e2e1673c','删除字典',2,'','','',0,0,0,0,'ray:system:dicts:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:25:52','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:13'),(12,'5b9a474efbc14b6e865e51cbbd16f311','c37f6402651a4dc09cd250dda79ed7fc','字典项管理',2,'','','',0,0,0,0,'ray:system:dicts:items','',5,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:26:29','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:34:56'),(13,'5b9a474efbc14b6e865e51cbbd16f311','6b7666bd1dab4e20974422295de536e2','创建字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:create','',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:29:21','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:16'),(14,'5b9a474efbc14b6e865e51cbbd16f311','cb5684b760cf4fa29f1816e141b3ee10','搜索字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:search','',6,'',1,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:31:44','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:00'),(15,'5b9a474efbc14b6e865e51cbbd16f311','89bdd7e788e1476fb56035a8b4760e44','编辑字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:edit','',5,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:38:28','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:20'),(16,'5b9a474efbc14b6e865e51cbbd16f311','62e4f7d81aa2417db99845a4f663d419','删除字典项',2,'','','',0,0,0,0,'ray:system:dicts:items:delete','',6,'',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-08 02:38:43','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:24'),(17,'6bfb7cc5de7a4d9c9b70d8563c7377ec','a69358b0070f447db2ad7c3c42297270','创建用户',2,'','','',0,0,0,0,'ray:system:users:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 07:35:50','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:18'),(18,'6bfb7cc5de7a4d9c9b70d8563c7377ec','85471b98e6e0478f916c431b93e65dad','编辑用户',2,'','','',0,0,0,0,'ray:system:users:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:22:53','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:21'),(19,'6bfb7cc5de7a4d9c9b70d8563c7377ec','4fe517c3a47a4b3e820ae812327f48cd','删除用户',2,'','','',0,0,0,0,'ray:system:users:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:23:07','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:26'),(20,'6bfb7cc5de7a4d9c9b70d8563c7377ec','b60ca056b2404078ac905f59caa992d2','重置密码',2,'','','',0,0,0,0,'ray:system:users:reset','',4,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:23:25','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 08:56:29'),(21,'9c476acf5ed34dd19a4f8037a065a669','743f88e0ec7a4047b74d9487a8826e93','创建部门',2,'','','',0,0,0,0,'ray:system:depts:create','',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:44','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:44'),(22,'9c476acf5ed34dd19a4f8037a065a669','6371d5a4b47c41fe984d8e4d960c9460','编辑部门',2,'','','',0,0,0,0,'ray:system:depts:edit','',2,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:59','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:11:59'),(23,'9c476acf5ed34dd19a4f8037a065a669','9b3793acfb7d485dbeee68e11524cc1d','删除部门',2,'','','',0,0,0,0,'ray:system:depts:delete','',3,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:12:11','2bd631f674af40f19c73c0d8962a4d28','2025-01-06 09:12:11'),(24,'0e5580ae61f54380bbc9f473655060bc','51e96aa3fa43456eb5ff9be56ae26914','字典项管理',1,'dict','dictItem','',0,0,0,0,'ray:system:dict-items','system/dict/item',6,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-01 08:44:32','2bd631f674af40f19c73c0d8962a4d28','2025-04-02 01:55:29'),(25,'0','3c7948cf4a254fc58ae44ebbec192e7a','资产管理',0,'homepage','/asset','',0,0,1,1,'ray:asset','Layout',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:47:55','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:52:44'),(26,'3c7948cf4a254fc58ae44ebbec192e7a','74fd75f1fdae4f65859e4723ccdc2236','分类管理',1,'tree','category','',0,0,1,0,'ray:asset:category','asset/category/index',1,'',0,'2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:53:57','2bd631f674af40f19c73c0d8962a4d28','2025-04-15 06:53:57'),(27,'0','4e6c9a574f5746e4aa0d5cc15cc6bd56','测试111',0,'system1','/system1','',0,0,0,0,'ray:system1','Layout',1,'',1,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 06:53:36','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 06:59:48');
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
  `tenant_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户编号',
  `type` tinyint NOT NULL COMMENT '日志类型：1=操作；2=错误；',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录人',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `module` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模块名称',
  `func` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '功能名称',
  `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '功能描述',
  `action` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '动作描述',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求IP',
  `url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Url',
  `uri` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Uri',
  `method` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求Method',
  `class_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求类名',
  `method_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求方法名',
  `browser` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器',
  `browser_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '浏览器版本',
  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '平台',
  `os` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统',
  `os_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统版本',
  `engine` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎',
  `engine_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '引擎版本',
  `exe_time` bigint NOT NULL DEFAULT '0' COMMENT '执行时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operate_log`
--

LOCK TABLES `sys_operate_log` WRITE;
/*!40000 ALTER TABLE `sys_operate_log` DISABLE KEYS */;
INSERT INTO `sys_operate_log` VALUES (14,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 07:37:37','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','身份认证','获取当前登录人','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/auth/v1/current-user','/console/v1/auth/v1/current-user','GET','cc.xuepeng.ray.framework.module.auth.api.SysAuthController','','Unknown','','Unknown','Unknown','','Unknown','',3),(15,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 07:34:45','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','身份认证','获取当前登录人','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/auth/v1/current-user','/console/v1/auth/v1/current-user','GET','cc.xuepeng.ray.framework.module.auth.api.SysAuthController','','Unknown','','Unknown','Unknown','','Unknown','',80),(16,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 07:43:15','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','认证日志管理','分页查询认证日志','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/auth-logs/v1/page','/console/v1/auth-logs/v1/page','GET','cc.xuepeng.ray.framework.facade.system.log.api.SysAuthLogController','','Unknown','','Unknown','Unknown','','Unknown','',70),(17,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 07:43:21','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','操作日志管理','分页查询操作日志','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/operate-logs/v1/page','/console/v1/operate-logs/v1/page','GET','cc.xuepeng.ray.framework.facade.system.log.api.SysOperateLogController','','Unknown','','Unknown','Unknown','','Unknown','',32),(18,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 07:35:05','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','身份认证','获取当前登录人','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/auth/v1/current-user','/console/v1/auth/v1/current-user','GET','cc.xuepeng.ray.framework.module.auth.api.SysAuthController','','Unknown','','Unknown','Unknown','','Unknown','',7),(19,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 09:37:57','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','部门管理','查询部门树','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/depts/v1/tree','/console/v1/depts/v1/tree','GET','cc.xuepeng.ray.framework.facade.system.dept.api.SysDeptController','','Unknown','','Unknown','Unknown','','Unknown','',12),(20,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 09:39:12','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','部门管理','查询部门树','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/depts/v1/tree','/console/v1/depts/v1/tree','GET','cc.xuepeng.ray.framework.facade.system.dept.api.SysDeptController','','Unknown','','Unknown','Unknown','','Unknown','',280),(21,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 10:18:41','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','用户管理','分页查询用户','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/users/v1/page','/console/v1/users/v1/page','GET','cc.xuepeng.ray.framework.facade.system.user.api.SysUserController','','Unknown','','Unknown','Unknown','','Unknown','',305),(22,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 10:20:50','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','用户管理','创建用户','CREATE','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/users/v1','/console/v1/users/v1','POST','cc.xuepeng.ray.framework.facade.system.user.api.SysUserController','','Unknown','','Unknown','Unknown','','Unknown','',316),(23,'1375e003afdd4603b8a39b562bd78892',1,'2025-12-09 10:20:58','236eda0717874d40bc3eec8148d3518b','15810051066','系统管理','用户管理','分页查询用户','QUERY','0:0:0:0:0:0:0:1','http://localhost:28080/console/v1/users/v1/page','/console/v1/users/v1/page','GET','cc.xuepeng.ray.framework.facade.system.user.api.SysUserController','','Unknown','','Unknown','Unknown','','Unknown','',26);
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
  `tenant_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户编号',
  `log_id` bigint NOT NULL COMMENT '系统日志主键',
  `param` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '请求路径参数',
  `args` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '请求方法参数',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '返回值',
  `error` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '错误信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志详情表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operate_log_detail`
--

LOCK TABLES `sys_operate_log_detail` WRITE;
/*!40000 ALTER TABLE `sys_operate_log_detail` DISABLE KEYS */;
INSERT INTO `sys_operate_log_detail` VALUES (1,'1375e003afdd4603b8a39b562bd78892',14,NULL,NULL,NULL,NULL),(2,'1375e003afdd4603b8a39b562bd78892',15,NULL,NULL,NULL,NULL),(3,'1375e003afdd4603b8a39b562bd78892',16,NULL,'[arg0:SysAuthLogRequest(type=null, loginIp=null)]',NULL,NULL),(4,'1375e003afdd4603b8a39b562bd78892',17,NULL,'[arg0:SysOperateLogRequest(module=null)]',NULL,NULL),(5,'1375e003afdd4603b8a39b562bd78892',18,NULL,NULL,NULL,NULL),(6,'1375e003afdd4603b8a39b562bd78892',19,NULL,'[arg0:SysDeptRequest(parentCode=null, code=null, name=null, status=null, sequence=null, remark=null)]',NULL,'\'cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus cc.xuepeng.ray.framework.facade.system.dept.request.SysDeptRequest.getStatus()\''),(7,'1375e003afdd4603b8a39b562bd78892',20,NULL,'[arg0:SysDeptRequest(parentCode=null, code=null, name=null, status=null, sequence=null, remark=null)]',NULL,NULL),(8,'1375e003afdd4603b8a39b562bd78892',21,NULL,'[arg0:SysUserRequest(roleCodes=null, phoneNumber=null, name=null, email=null, status=null, remark=null)]',NULL,NULL),(9,'1375e003afdd4603b8a39b562bd78892',22,NULL,'[arg0:SysUserRequest(roleCodes=[06d8e0132001460389915c954a4b37c5], phoneNumber=15810051067, name=盖伦, email=15810051067@qq.com, status=BizStatusDto.ENABLE(code=1, desc=启用), remark=)]','Result(code=20000, desc=成功, msg=创建系统用户成功, data=true)',NULL),(10,'1375e003afdd4603b8a39b562bd78892',23,NULL,'[arg0:SysUserRequest(roleCodes=null, phoneNumber=null, name=null, email=null, status=null, remark=null)]',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'2c2650abd2814511a7eee37e422ac97a','ROLE_SUPER_ADMIN',1,1,'超级管理员',0,'2bd631f674af40f19c73c0d8962a4d28','2024-04-28 07:19:30','2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:32:05'),(2,'c1b1d17824a14a2286a0150c048987d8','ROLE_SYSTEM_ADMIN',1,2,'系统管理员',0,'2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:18:04','2bd631f674af40f19c73c0d8962a4d28','2024-10-10 06:32:05'),(3,'06d8e0132001460389915c954a4b37c5','ROLE_TENANT_ADMIN',1,3,'租户管理员',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 07:07:24','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 07:10:10');
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
  `role_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
  `func_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '功能编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与功能的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_func_relation`
--

LOCK TABLES `sys_role_func_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_func_relation` DISABLE KEYS */;
INSERT INTO `sys_role_func_relation` VALUES (200,'c1b1d17824a14a2286a0150c048987d8','0e5580ae61f54380bbc9f473655060bc'),(201,'c1b1d17824a14a2286a0150c048987d8','6bfb7cc5de7a4d9c9b70d8563c7377ec'),(202,'c1b1d17824a14a2286a0150c048987d8','a69358b0070f447db2ad7c3c42297270'),(203,'c1b1d17824a14a2286a0150c048987d8','85471b98e6e0478f916c431b93e65dad'),(204,'c1b1d17824a14a2286a0150c048987d8','4fe517c3a47a4b3e820ae812327f48cd'),(205,'c1b1d17824a14a2286a0150c048987d8','b60ca056b2404078ac905f59caa992d2'),(206,'c1b1d17824a14a2286a0150c048987d8','9c476acf5ed34dd19a4f8037a065a669'),(207,'c1b1d17824a14a2286a0150c048987d8','743f88e0ec7a4047b74d9487a8826e93'),(208,'c1b1d17824a14a2286a0150c048987d8','6371d5a4b47c41fe984d8e4d960c9460'),(209,'c1b1d17824a14a2286a0150c048987d8','9b3793acfb7d485dbeee68e11524cc1d'),(231,'2c2650abd2814511a7eee37e422ac97a','3c7948cf4a254fc58ae44ebbec192e7a'),(232,'2c2650abd2814511a7eee37e422ac97a','74fd75f1fdae4f65859e4723ccdc2236'),(233,'2c2650abd2814511a7eee37e422ac97a','0e5580ae61f54380bbc9f473655060bc'),(234,'2c2650abd2814511a7eee37e422ac97a','6bfb7cc5de7a4d9c9b70d8563c7377ec'),(235,'2c2650abd2814511a7eee37e422ac97a','a69358b0070f447db2ad7c3c42297270'),(236,'2c2650abd2814511a7eee37e422ac97a','85471b98e6e0478f916c431b93e65dad'),(237,'2c2650abd2814511a7eee37e422ac97a','4fe517c3a47a4b3e820ae812327f48cd'),(238,'2c2650abd2814511a7eee37e422ac97a','b60ca056b2404078ac905f59caa992d2'),(239,'2c2650abd2814511a7eee37e422ac97a','7982cdc53a124340ab7da5e3f130b419'),(240,'2c2650abd2814511a7eee37e422ac97a','86132348f09a4a8299d949d12f1237b4'),(241,'2c2650abd2814511a7eee37e422ac97a','9c476acf5ed34dd19a4f8037a065a669'),(242,'2c2650abd2814511a7eee37e422ac97a','743f88e0ec7a4047b74d9487a8826e93'),(243,'2c2650abd2814511a7eee37e422ac97a','6371d5a4b47c41fe984d8e4d960c9460'),(244,'2c2650abd2814511a7eee37e422ac97a','9b3793acfb7d485dbeee68e11524cc1d'),(245,'2c2650abd2814511a7eee37e422ac97a','5b9a474efbc14b6e865e51cbbd16f311'),(246,'2c2650abd2814511a7eee37e422ac97a','cf7068d9d6d84afcb4a59b803e1e1a2f'),(247,'2c2650abd2814511a7eee37e422ac97a','0bd07cc721d94942bc1001ccd1fe9e14'),(248,'2c2650abd2814511a7eee37e422ac97a','fb05ae0889da4e089c09a987e2e1673c'),(249,'2c2650abd2814511a7eee37e422ac97a','6b7666bd1dab4e20974422295de536e2'),(250,'2c2650abd2814511a7eee37e422ac97a','89bdd7e788e1476fb56035a8b4760e44'),(251,'2c2650abd2814511a7eee37e422ac97a','62e4f7d81aa2417db99845a4f663d419'),(252,'2c2650abd2814511a7eee37e422ac97a','51e96aa3fa43456eb5ff9be56ae26914'),(253,'2c2650abd2814511a7eee37e422ac97a','76ed9e00ddcc4e58a60a8b86ebc5bbc6'),(254,'06d8e0132001460389915c954a4b37c5','0e5580ae61f54380bbc9f473655060bc'),(255,'06d8e0132001460389915c954a4b37c5','6bfb7cc5de7a4d9c9b70d8563c7377ec');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与用户的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user_relation`
--

LOCK TABLES `sys_role_user_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_user_relation` DISABLE KEYS */;
INSERT INTO `sys_role_user_relation` VALUES (1,'2c2650abd2814511a7eee37e422ac97a','5664b7f6cddb42aca28aedd07bb051a1'),(4,'06d8e0132001460389915c954a4b37c5','236eda0717874d40bc3eec8148d3518b'),(5,'06d8e0132001460389915c954a4b37c5','95c71eba1b5d427fa94b3eaeb277d77f');
/*!40000 ALTER TABLE `sys_role_user_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_tenant`
--

DROP TABLE IF EXISTS `sys_tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_tenant` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(32) NOT NULL DEFAULT '1' COMMENT '编号',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '名称',
  `phone_number` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
  `email` varchar(128) NOT NULL DEFAULT '' COMMENT '邮箱',
  `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用',
  `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '有效期',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '备注',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user` char(32) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_user` char(32) NOT NULL DEFAULT '' COMMENT '修改人',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统租户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_tenant`
--

LOCK TABLES `sys_tenant` WRITE;
/*!40000 ALTER TABLE `sys_tenant` DISABLE KEYS */;
INSERT INTO `sys_tenant` VALUES (1,'e79b0554909b4d43921e53d99f325842','超级租户','17600891908','100103081@qq.com',1,'2030-12-31 15:59:59','',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-11-27 03:00:58','5664b7f6cddb42aca28aedd07bb051a1','2025-11-27 03:07:12'),(4,'1375e003afdd4603b8a39b562bd78892','英雄联盟','15810051066','66695802@qq.com',1,'2025-12-04 02:43:04','',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:43:04','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 02:43:04');
/*!40000 ALTER TABLE `sys_tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户编号',
  `dept_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门编号',
  `code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
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
INSERT INTO `sys_user` VALUES (1,'e79b0554909b4d43921e53d99f325842','cec9d9f97c63401280f4d1eade22cdd9','5664b7f6cddb42aca28aedd07bb051a1','17600891908','薛鹏','670b14728ad9902aecba32e22fa4f6bd','100103081@qq.com','',1,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-11-27 03:09:00','5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 07:28:48'),(2,'1375e003afdd4603b8a39b562bd78892','bcd1888183ef4070a70718d8427e4140','236eda0717874d40bc3eec8148d3518b','15810051066','嘉文四世','670b14728ad9902aecba32e22fa4f6bd','66695802@qq.com','',1,'',0,'5664b7f6cddb42aca28aedd07bb051a1','2025-12-04 07:25:05','5664b7f6cddb42aca28aedd07bb051a1','2025-12-09 07:17:16'),(3,'1375e003afdd4603b8a39b562bd78892','93f5ca31f8ea41b8ad3746c8262b96cb','95c71eba1b5d427fa94b3eaeb277d77f','15810051067','盖伦','670b14728ad9902aecba32e22fa4f6bd','15810051067@qq.com','',1,'',0,'236eda0717874d40bc3eec8148d3518b','2025-12-09 10:20:51','236eda0717874d40bc3eec8148d3518b','2025-12-09 10:20:51');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'anov-server-system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-09 18:21:45
