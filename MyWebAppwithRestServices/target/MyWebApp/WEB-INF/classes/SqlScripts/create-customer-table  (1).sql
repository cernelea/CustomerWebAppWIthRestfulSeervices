CREATE DATABASE  IF NOT EXISTS `customer_database` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `customer_database`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: web_customer_tracker
-- ------------------------------------------------------
-- Server version	8.0.12


--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `customer`
--

INSERT INTO `customer` VALUES (5,'Ion','Rusnac','vanea@mail.ru'),(6,'Alina','Rotaru','alinushca@gmail.com'),(8,'Gheorghe','Volontir','ion.ciobanu@gmail.com'),(9,'Andrei','Rusnac','cerneleaaa@gmail.com');


-- Dump completed on 2018-11-02 16:44:29
