-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 31 mars 2021 à 08:59
-- Version du serveur :  5.7.31-log
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdd_al2m`
--

-- --------------------------------------------------------

--
-- Structure de la table `caserne`
--

DROP TABLE IF EXISTS `caserne`;
CREATE TABLE IF NOT EXISTS `caserne` (
  `CASERNE_ID` int(2) NOT NULL,
  `NOM` char(255) DEFAULT NULL,
  `RUE` char(255) NOT NULL,
  `COPOS` char(255) NOT NULL,
  `VILLE` char(255) NOT NULL,
  PRIMARY KEY (`CASERNE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `caserne`
--

INSERT INTO `caserne` (`CASERNE_ID`, `NOM`, `RUE`, `COPOS`, `VILLE`) VALUES
(1, 'Quimper', '17 rue de la quimper', '14000', 'Caen'),
(2, 'SDIS', '15 rue de la concorde', '14000', 'Caen'),
(3, 'CIS Caen-Canada', '12 rue de la république', '14000', 'Caen'),
(4, 'CIS CAEN IFS', '14 rue de la espérance', '14000', 'Caen');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `COMP_ID` int(2) NOT NULL,
  `COM_POMPIER` varchar(255) NOT NULL,
  `LOGIN` char(255) NOT NULL,
  `MDP` char(255) NOT NULL,
  `RESPONSABLE` tinyint(1) NOT NULL,
  PRIMARY KEY (`COMP_ID`),
  KEY `FK_COMPTE_POMPIER` (`COM_POMPIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`COMP_ID`, `COM_POMPIER`, `LOGIN`, `MDP`, `RESPONSABLE`) VALUES
(1, '986995', 'robert1', 'mprobert1', 1),
(2, '95141', 'jacob1', 'mpjacob1', 0),
(3, '47889', 'sogane1', 'mpsogane1', 0),
(4, '14154', 'dimitri1', 'mpdimitri1', 0);

-- --------------------------------------------------------

--
-- Structure de la table `engin`
--

DROP TABLE IF EXISTS `engin`;
CREATE TABLE IF NOT EXISTS `engin` (
  `ENGIN_ID` int(2) NOT NULL,
  `CASERNE_ID` int(2) NOT NULL,
  `NUMORDRE` char(255) NOT NULL,
  `TYPE` char(255) NOT NULL,
  PRIMARY KEY (`ENGIN_ID`),
  KEY `FK_ENGIN_CASERNE` (`CASERNE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `engin`
--

INSERT INTO `engin` (`ENGIN_ID`, `CASERNE_ID`, `NUMORDRE`, `TYPE`) VALUES
(1, 1, 'ENG01', 'VSAV , véhicule de secours aux victimes'),
(2, 1, 'ENG02', 'FPT , fourgon pompe-tonne'),
(3, 1, 'ENG03', 'EPA , échelle pivotante automatique');

-- --------------------------------------------------------

--
-- Structure de la table `fonction`
--

DROP TABLE IF EXISTS `fonction`;
CREATE TABLE IF NOT EXISTS `fonction` (
  `FONCT_CODE` int(2) NOT NULL,
  `LIBELLE` char(255) NOT NULL,
  PRIMARY KEY (`FONCT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fonction`
--

INSERT INTO `fonction` (`FONCT_CODE`, `LIBELLE`) VALUES
(1, 'Conducteur véhicule de secours routier'),
(2, 'Conducteur fourgon pompe-tonne'),
(3, 'Équiper échelle pivotante automatique'),
(4, 'Équiper incendie');

-- --------------------------------------------------------

--
-- Structure de la table `foneng`
--

DROP TABLE IF EXISTS `foneng`;
CREATE TABLE IF NOT EXISTS `foneng` (
  `FONCT_CODE` int(2) NOT NULL,
  `ENGIN_ID` int(2) NOT NULL,
  `NOMBREINTERVENANT` int(2) DEFAULT NULL,
  PRIMARY KEY (`FONCT_CODE`,`ENGIN_ID`),
  KEY `FK_FONENG_ENGIN` (`ENGIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `foneng`
--

INSERT INTO `foneng` (`FONCT_CODE`, `ENGIN_ID`, `NOMBREINTERVENANT`) VALUES
(2, 2, 1),
(4, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `GRAD_ID` int(2) NOT NULL,
  `LIBELLE` char(255) NOT NULL,
  PRIMARY KEY (`GRAD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `grade`
--

INSERT INTO `grade` (`GRAD_ID`, `LIBELLE`) VALUES
(1, 'Capitaine'),
(2, 'Auxiliaire'),
(3, 'Sapeur 2nd Classe'),
(4, 'Sapeur 1er Classe'),
(5, 'Caporal'),
(6, 'Caporal-chef'),
(7, 'Sergent'),
(8, 'Sergent-chef'),
(9, 'Adjudant'),
(10, 'Adjudant-chef'),
(11, 'Lieutenant'),
(12, 'Commandant'),
(13, 'Lieutenant-colonel'),
(14, 'Colonel et colonel hors classe'),
(15, 'Contrôleur général'),
(16, 'Contrôleur général (investi de responsabilités particulières à l\'état)');

-- --------------------------------------------------------

--
-- Structure de la table `intereng`
--

DROP TABLE IF EXISTS `intereng`;
CREATE TABLE IF NOT EXISTS `intereng` (
  `ENGIN_ID` int(2) NOT NULL,
  `INTER_ID` char(32) NOT NULL,
  PRIMARY KEY (`ENGIN_ID`,`INTER_ID`),
  KEY `FK_INTERENG_INTERVENTION` (`INTER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `intereng`
--

INSERT INTO `intereng` (`ENGIN_ID`, `INTER_ID`) VALUES
(2, '1'),
(3, '1'),
(1, '2'),
(2, '2'),
(1, '3'),
(2, '3');

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

DROP TABLE IF EXISTS `intervention`;
CREATE TABLE IF NOT EXISTS `intervention` (
  `INTER_ID` char(32) NOT NULL,
  `TYPEINTER_ID` int(2) NOT NULL,
  `LIEU` char(255) NOT NULL,
  `DTINTER` char(255) NOT NULL,
  `DUREE` char(255) NOT NULL,
  `HEUREAPPEL` char(255) NOT NULL,
  `HEUREARRIVEE` char(255) NOT NULL,
  PRIMARY KEY (`INTER_ID`),
  KEY `FK_INTERVENTION_TYPEINTER` (`TYPEINTER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `intervention`
--

INSERT INTO `intervention` (`INTER_ID`, `TYPEINTER_ID`, `LIEU`, `DTINTER`, `DUREE`, `HEUREAPPEL`, `HEUREARRIVEE`) VALUES
('1', 2, 'Paris', '25-09-2021', '2 heures', '16h25', '16h50'),
('2', 3, 'Ifs', '17-03-2021', '1h30', '11h05', '11h10'),
('3', 2, 'Cormelles Le Royal', '18-03-2021', '2h00', '13h10', '13h20');

-- --------------------------------------------------------

--
-- Structure de la table `pomfonc`
--

DROP TABLE IF EXISTS `pomfonc`;
CREATE TABLE IF NOT EXISTS `pomfonc` (
  `POMP_MATRICULE` varchar(255) NOT NULL,
  `FONCT_CODE` int(2) NOT NULL,
  PRIMARY KEY (`POMP_MATRICULE`,`FONCT_CODE`),
  KEY `FK_POMFONC_FONCTION` (`FONCT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pomfonc`
--

INSERT INTO `pomfonc` (`POMP_MATRICULE`, `FONCT_CODE`) VALUES
('95141', 2),
('986995', 2),
('47889', 3),
('14154', 4);

-- --------------------------------------------------------

--
-- Structure de la table `pominter`
--

DROP TABLE IF EXISTS `pominter`;
CREATE TABLE IF NOT EXISTS `pominter` (
  `INTER_ID` char(32) NOT NULL,
  `POMP_MATRICULE` varchar(255) NOT NULL,
  PRIMARY KEY (`INTER_ID`,`POMP_MATRICULE`),
  KEY `FK_POMINTER_POMPIER` (`POMP_MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pominter`
--

INSERT INTO `pominter` (`INTER_ID`, `POMP_MATRICULE`) VALUES
('1', '14154'),
('2', '47889'),
('3', '95141'),
('1', '986995');

-- --------------------------------------------------------

--
-- Structure de la table `pompier`
--

DROP TABLE IF EXISTS `pompier`;
CREATE TABLE IF NOT EXISTS `pompier` (
  `POMP_MATRICULE` varchar(255) NOT NULL,
  `POMP_CASERNE` int(2) NOT NULL,
  `POMP_GRADE` int(2) NOT NULL,
  `NOM` char(255) NOT NULL,
  `PRENOM` char(255) NOT NULL,
  `DATENAISSANCE` char(255) NOT NULL,
  `NUMEROBIP` int(2) NOT NULL,
  `SEXE` char(255) NOT NULL,
  `TELEPHONE` char(255) NOT NULL,
  PRIMARY KEY (`POMP_MATRICULE`),
  KEY `FK_POMPIER_CASERNE` (`POMP_CASERNE`),
  KEY `FK_POMPIER_GRADE` (`POMP_GRADE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pompier`
--

INSERT INTO `pompier` (`POMP_MATRICULE`, `POMP_CASERNE`, `POMP_GRADE`, `NOM`, `PRENOM`, `DATENAISSANCE`, `NUMEROBIP`, `SEXE`, `TELEPHONE`) VALUES
('120145', 2, 6, 'Lenine', 'Xavier', '29-07-1991', 17, 'Masculin', '0645988741'),
('123456', 3, 5, 'Estiba', 'Yasmine', '19-04-1992', 28, 'Feminin', '0789457894'),
('141414', 3, 9, 'Potter', 'Marc', '27-01-1994', 25, 'Masculin', '0754895447'),
('14154', 3, 5, 'Dimitri', 'Kurbanedov', '15-04-1991', 17, 'Masculin', '02 47 88 59 61'),
('28092002', 4, 11, ' Bahri', 'Noureddine', '14-09-1998', 65, 'Masculin', '0754785492'),
('47889', 2, 7, 'Sogane', 'Long', '15-05-1994', 10, 'Masculin', '02 58 99 47 12'),
('487595', 3, 4, 'Sirel', 'Nicolas', '17-06-1990', 75, 'Masculin', '0698784594'),
('95141', 1, 3, 'Jacob', 'Miringal', '10-09-1994', 21, 'Masculin', '02 15 87 45 87'),
('986995', 1, 1, 'Robert', 'Dumontel', '10-01-1969', 15, 'Masculin', '02 98 56 85 42');

-- --------------------------------------------------------

--
-- Structure de la table `profession`
--

DROP TABLE IF EXISTS `profession`;
CREATE TABLE IF NOT EXISTS `profession` (
  `PROF_ID` int(2) NOT NULL,
  `LIBELLE` char(255) NOT NULL,
  `VILLE` char(255) NOT NULL,
  PRIMARY KEY (`PROF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `profession`
--

INSERT INTO `profession` (`PROF_ID`, `LIBELLE`, `VILLE`) VALUES
(1, 'Cuisinier', 'Toulouse'),
(2, 'Rugbyman', 'Marseille'),
(3, 'Développeur web', 'Saint-Étienne'),
(4, 'Professeur d\'histoire', 'Ifs'),
(5, 'Maitre Nageur', 'Caen'),
(6, 'Graphiste', 'Ifs'),
(7, 'Footballeur', 'Cherbourg'),
(8, 'Avocat', 'Condés sur noireau');

-- --------------------------------------------------------

--
-- Structure de la table `professionnel`
--

DROP TABLE IF EXISTS `professionnel`;
CREATE TABLE IF NOT EXISTS `professionnel` (
  `POMP_MATRICULE` varchar(255) NOT NULL,
  `INDICETRAITEMENT` int(2) NOT NULL,
  `DATEOBENTIONINDICE` char(255) NOT NULL,
  PRIMARY KEY (`POMP_MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `professionnel`
--

INSERT INTO `professionnel` (`POMP_MATRICULE`, `INDICETRAITEMENT`, `DATEOBENTIONINDICE`) VALUES
('120145', 15, '15-10-2012'),
('141414', 14, '16-04-2015'),
('14154', 13, '28-09-2019'),
('47889', 12, '21-09-2020');

-- --------------------------------------------------------

--
-- Structure de la table `typeinter`
--

DROP TABLE IF EXISTS `typeinter`;
CREATE TABLE IF NOT EXISTS `typeinter` (
  `TYPEINTER_ID` int(2) NOT NULL,
  `LIBELLE` char(255) NOT NULL,
  PRIMARY KEY (`TYPEINTER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `typeinter`
--

INSERT INTO `typeinter` (`TYPEINTER_ID`, `LIBELLE`) VALUES
(1, 'Feu dans un appartement'),
(2, 'Feu de broussailles'),
(3, 'Ascenseur bloqué'),
(4, 'Chat coincé dans un arbre');

-- --------------------------------------------------------

--
-- Structure de la table `volontaire`
--

DROP TABLE IF EXISTS `volontaire`;
CREATE TABLE IF NOT EXISTS `volontaire` (
  `POMP_MATRICULE` varchar(255) NOT NULL,
  `PROF_ID` int(2) NOT NULL,
  PRIMARY KEY (`POMP_MATRICULE`),
  KEY `FK_VOLONTAIRE_PROFESSION` (`PROF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `volontaire`
--

INSERT INTO `volontaire` (`POMP_MATRICULE`, `PROF_ID`) VALUES
('986995', 1),
('95141', 4),
('123456', 5),
('28092002', 6),
('487595', 8);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`COM_POMPIER`) REFERENCES `pompier` (`POMP_MATRICULE`);

--
-- Contraintes pour la table `engin`
--
ALTER TABLE `engin`
  ADD CONSTRAINT `engin_ibfk_1` FOREIGN KEY (`CASERNE_ID`) REFERENCES `caserne` (`CASERNE_ID`);

--
-- Contraintes pour la table `foneng`
--
ALTER TABLE `foneng`
  ADD CONSTRAINT `foneng_ibfk_1` FOREIGN KEY (`FONCT_CODE`) REFERENCES `fonction` (`FONCT_CODE`),
  ADD CONSTRAINT `foneng_ibfk_2` FOREIGN KEY (`ENGIN_ID`) REFERENCES `engin` (`ENGIN_ID`);

--
-- Contraintes pour la table `intereng`
--
ALTER TABLE `intereng`
  ADD CONSTRAINT `intereng_ibfk_1` FOREIGN KEY (`ENGIN_ID`) REFERENCES `engin` (`ENGIN_ID`),
  ADD CONSTRAINT `intereng_ibfk_2` FOREIGN KEY (`INTER_ID`) REFERENCES `intervention` (`INTER_ID`);

--
-- Contraintes pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD CONSTRAINT `intervention_ibfk_1` FOREIGN KEY (`TYPEINTER_ID`) REFERENCES `typeinter` (`TYPEINTER_ID`);

--
-- Contraintes pour la table `pomfonc`
--
ALTER TABLE `pomfonc`
  ADD CONSTRAINT `pomfonc_ibfk_1` FOREIGN KEY (`POMP_MATRICULE`) REFERENCES `pompier` (`POMP_MATRICULE`),
  ADD CONSTRAINT `pomfonc_ibfk_2` FOREIGN KEY (`FONCT_CODE`) REFERENCES `fonction` (`FONCT_CODE`);

--
-- Contraintes pour la table `pominter`
--
ALTER TABLE `pominter`
  ADD CONSTRAINT `pominter_ibfk_1` FOREIGN KEY (`INTER_ID`) REFERENCES `intervention` (`INTER_ID`),
  ADD CONSTRAINT `pominter_ibfk_2` FOREIGN KEY (`POMP_MATRICULE`) REFERENCES `pompier` (`POMP_MATRICULE`);

--
-- Contraintes pour la table `pompier`
--
ALTER TABLE `pompier`
  ADD CONSTRAINT `pompier_ibfk_1` FOREIGN KEY (`POMP_CASERNE`) REFERENCES `caserne` (`CASERNE_ID`),
  ADD CONSTRAINT `pompier_ibfk_2` FOREIGN KEY (`POMP_GRADE`) REFERENCES `grade` (`GRAD_ID`);

--
-- Contraintes pour la table `professionnel`
--
ALTER TABLE `professionnel`
  ADD CONSTRAINT `professionnel_ibfk_1` FOREIGN KEY (`POMP_MATRICULE`) REFERENCES `pompier` (`POMP_MATRICULE`);

--
-- Contraintes pour la table `volontaire`
--
ALTER TABLE `volontaire`
  ADD CONSTRAINT `volontaire_ibfk_1` FOREIGN KEY (`PROF_ID`) REFERENCES `profession` (`PROF_ID`),
  ADD CONSTRAINT `volontaire_ibfk_2` FOREIGN KEY (`POMP_MATRICULE`) REFERENCES `pompier` (`POMP_MATRICULE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
