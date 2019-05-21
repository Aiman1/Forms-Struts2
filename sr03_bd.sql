-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 21 mai 2019 à 09:13
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sr03`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `id` int(5) NOT NULL DEFAULT '0',
  `family_name` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `first_name` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `tel` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `societe` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `gender` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `actif` tinyint(1) NOT NULL,
  `compte` int(5) NOT NULL,
  KEY `cleCompteAdmin` (`compte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `mdp` varchar(30) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

DROP TABLE IF EXISTS `stagiaire`;
CREATE TABLE IF NOT EXISTS `stagiaire` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `family_name` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `first_name` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `tel` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `societe` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `gender` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `actif` tinyint(1) NOT NULL,
  `compte` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cleCompte` (`compte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `cleCompteAdmin` FOREIGN KEY (`compte`) REFERENCES `compte` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD CONSTRAINT `cleCompte` FOREIGN KEY (`compte`) REFERENCES `compte` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
