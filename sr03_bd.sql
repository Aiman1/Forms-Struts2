-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 18 juin 2019 à 16:08
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

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`id`, `family_name`, `first_name`, `tel`, `societe`, `gender`, `actif`, `compte`) VALUES
(0, 'admin', 'admin', 'admin', 'admin', 'male', 1, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `email`, `mdp`) VALUES
(1, 'admin@admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `parcours`
--

DROP TABLE IF EXISTS `parcours`;
CREATE TABLE IF NOT EXISTS `parcours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `duree` double NOT NULL,
  `score` int(11) NOT NULL,
  `utilisateur` int(11) NOT NULL,
  `questionnaire` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cleParcoursUtilisateur` (`utilisateur`),
  KEY `cleParcoursQuestionnaire` (`questionnaire`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `questionnaire` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cleQuestionnaire` (`questionnaire`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`id`, `intitule`, `statut`, `questionnaire`) VALUES
(1, 'question test 1 ?', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `questionnaire`
--

DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE IF NOT EXISTS `questionnaire` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `statut` tinyint(1) NOT NULL,
  `sujet` int(5) NOT NULL,
  `intitule` varchar(25) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cleSujet` (`sujet`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `questionnaire`
--

INSERT INTO `questionnaire` (`id`, `statut`, `sujet`, `intitule`) VALUES
(1, 1, 1, 'questionnaire sujet 1');

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE IF NOT EXISTS `reponse` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `bonne` tinyint(1) NOT NULL,
  `question` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cleQuestion` (`question`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `reponse`
--

INSERT INTO `reponse` (`id`, `intitule`, `statut`, `bonne`, `question`) VALUES
(1, 'reponse1', 1, 0, 1),
(2, 'reponse 2', 1, 1, 1),
(3, 'rep3', 1, 0, 1),
(4, 'rep4', 1, 0, 1);

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

-- --------------------------------------------------------

--
-- Structure de la table `sujet`
--

DROP TABLE IF EXISTS `sujet`;
CREATE TABLE IF NOT EXISTS `sujet` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `sujet` varchar(25) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Déchargement des données de la table `sujet`
--

INSERT INTO `sujet` (`id`, `sujet`) VALUES
(1, 'sujet1'),
(2, 'sujet2');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `cleCompteAdmin` FOREIGN KEY (`compte`) REFERENCES `compte` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `parcours`
--
ALTER TABLE `parcours`
  ADD CONSTRAINT `cleParcoursQuestionnaire` FOREIGN KEY (`questionnaire`) REFERENCES `questionnaire` (`id`),
  ADD CONSTRAINT `cleParcoursUtilisateur` FOREIGN KEY (`utilisateur`) REFERENCES `stagiaire` (`id`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `cleQuestionnaire` FOREIGN KEY (`questionnaire`) REFERENCES `questionnaire` (`id`);

--
-- Contraintes pour la table `questionnaire`
--
ALTER TABLE `questionnaire`
  ADD CONSTRAINT `cleSujet` FOREIGN KEY (`sujet`) REFERENCES `sujet` (`id`);

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `cleQuestion` FOREIGN KEY (`question`) REFERENCES `question` (`id`);

--
-- Contraintes pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD CONSTRAINT `cleCompte` FOREIGN KEY (`compte`) REFERENCES `compte` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
