-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2014 at 12:14 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `wargame`
--

-- --------------------------------------------------------

--
-- Table structure for table `enemy_launcher`
--

CREATE TABLE IF NOT EXISTS `enemy_launcher` (
  `id` varchar(10) NOT NULL,
  `destination` varchar(15) NOT NULL,
  `damage` int(11) NOT NULL,
  `flyTime` int(11) NOT NULL,
  `isHidden` bit(1) NOT NULL,
  `firstHiddenState` bit(1) NOT NULL,
  `beenHit` bit(1) NOT NULL,
  `HitTime` datetime NOT NULL,
  `timeStamp` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enemy_missile`
--

CREATE TABLE IF NOT EXISTS `enemy_missile` (
  `id` varchar(10) NOT NULL,
  `whoLaunchedMeId` varchar(10) DEFAULT NULL,
  `destination` varchar(15) DEFAULT NULL,
  `flyTime` int(11) DEFAULT NULL,
  `damage` int(11) DEFAULT NULL,
  `launchTime` varchar(10) DEFAULT NULL,
  `beenHit` bit(1) NOT NULL DEFAULT b'0',
  `hitTime` datetime DEFAULT NULL,
  `timeStamp` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
