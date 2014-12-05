-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 05, 2014 at 02:36 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bankingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `accinfo`
--

CREATE TABLE IF NOT EXISTS `accinfo` (
  `accountnumber` int(11) NOT NULL AUTO_INCREMENT,
  `accounttype` varchar(120) NOT NULL,
  `balance` int(11) NOT NULL,
  `pin` int(11) NOT NULL,
  `userid` varchar(120) NOT NULL,
  PRIMARY KEY (`accountnumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `accinfo`
--

INSERT INTO `accinfo` (`accountnumber`, `accounttype`, `balance`, `pin`, `userid`) VALUES
(1, 'savings', 1000, 123, 'admin'),
(2, 'DPS', 500, 123, 'bokul');

-- --------------------------------------------------------

--
-- Table structure for table `persinfo`
--

CREATE TABLE IF NOT EXISTS `persinfo` (
  `userid` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `name` varchar(120) NOT NULL,
  `fname` varchar(120) NOT NULL,
  `address` varchar(240) NOT NULL,
  `emailid` varchar(120) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `persinfo`
--

INSERT INTO `persinfo` (`userid`, `password`, `name`, `fname`, `address`, `emailid`) VALUES
('admin', 'admin', 'rhine', 'fdsfs', 'south monipur, mirpur, dhaka', 'abc@yopmail.com'),
('bokul', 'bokul', 'bokul', 'Null', 'Tangail Sadar, Tangail', 'ra.bokul@yopmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `name`) VALUES
(100, 'RHINE'),
(101, 'RHINE');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
