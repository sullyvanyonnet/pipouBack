-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 14 fév. 2020 à 13:12
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ztm2-zyonnetsu`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `password`, `login`) VALUES
(1, 'nom', 'prenom', 'password', 'login');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `idcommande` int(11) NOT NULL AUTO_INCREMENT,
  `statut_idstatut` int(11) DEFAULT NULL,
  `dateComande` date DEFAULT NULL,
  `panier_idPanier` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcommande`),
  KEY `fk_commande_statut1_idx` (`statut_idstatut`),
  KEY `fk_Commande_panier1_idx` (`panier_idPanier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idcommande`, `statut_idstatut`, `dateComande`, `panier_idPanier`) VALUES
(2, 1, '2020-01-10', 2),
(3, 1, '2020-01-10', 2);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idCommentaire` int(11) NOT NULL AUTO_INCREMENT,
  `Client_idClient` int(11) DEFAULT NULL,
  `Film_idFilm` int(11) DEFAULT NULL,
  `texte` text DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idCommentaire`),
  KEY `fk_Client_has_Film_Film1_idx` (`Film_idFilm`),
  KEY `fk_Client_has_Film_Client1_idx` (`Client_idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`idCommentaire`, `Client_idClient`, `Film_idFilm`, `texte`, `date`) VALUES
(1, 1, 1, 'fdfddfdf', '2020-01-15'),
(2, 1, 1, 'fdfdfdfsdfd', '2020-01-08'),
(3, 2, 1, 'fddffdsdf', '2020-01-15'),
(4, 1, 1, 'fdsffdfddfdfssdf', '2020-01-16'),
(6, 1, 1, 'fdfxdxfdf', '2020-01-01'),
(7, 1, 1, 'coucou', '2020-02-07'),
(8, 1, 1, 'hello', '2020-02-07'),
(9, 1, 1, 'yo !', '2020-02-07'),
(10, 1, 1, 'yo !', '2020-02-07'),
(11, 1, 1, 'yo !', '2020-02-07'),
(12, 1, 1, 'hey', '2020-02-07');

-- --------------------------------------------------------

--
-- Structure de la table `elementpanier`
--

DROP TABLE IF EXISTS `elementpanier`;
CREATE TABLE IF NOT EXISTS `elementpanier` (
  `Film_idFilm` int(11) NOT NULL,
  `idElementPanier` int(11) NOT NULL AUTO_INCREMENT,
  `panier_idPanier` int(11) NOT NULL,
  PRIMARY KEY (`idElementPanier`),
  KEY `fk_Film_has_Client_Film_idx` (`Film_idFilm`),
  KEY `fk_ElementPanier_panier1_idx` (`panier_idPanier`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `elementpanier`
--

INSERT INTO `elementpanier` (`Film_idFilm`, `idElementPanier`, `panier_idPanier`) VALUES
(1, 5, 2),
(1, 6, 2);

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `idFilm` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `realisateur` varchar(45) DEFAULT NULL,
  `dateSortie` date DEFAULT NULL,
  `synopsis` varchar(255) DEFAULT NULL,
  `lienImage` varchar(255) DEFAULT NULL,
  `tarif` float DEFAULT NULL,
  PRIMARY KEY (`idFilm`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`idFilm`, `nom`, `realisateur`, `dateSortie`, `synopsis`, `lienImage`, `tarif`) VALUES
(1, 'nom', 'realisateur', '2019-12-09', 'Pellentesque vehicula leo in mi luctus mattis. Curabitur ultricies enim sit amet ipsum ultrices, ut posuere mi aliquam. Maecenas vehicula maximus ex et', 'https://www.scribendi.com/images/cms/thumbnails/Question-Marks_720x370.jpg', 10),
(2, 'Les trois petits cochons', 'Walt Disney', '2020-01-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam laoreet vulputate lectus, eu fermentum nisl. Curabitur bibendum ipsum ex, eu pretium nisi rutrum ut.', 'https://i.ytimg.com/vi/eJi-6kZiMWw/hqdefault.jpg', 50);

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

DROP TABLE IF EXISTS `historique`;
CREATE TABLE IF NOT EXISTS `historique` (
  `Client_idClient` int(11) NOT NULL,
  `Film_idFilm` int(11) NOT NULL,
  `commande_idcommande` int(11) DEFAULT NULL,
  PRIMARY KEY (`Client_idClient`,`Film_idFilm`),
  KEY `fk_Client_has_Film_Film2_idx` (`Film_idFilm`),
  KEY `fk_Client_has_Film_Client2_idx` (`Client_idClient`),
  KEY `fk_Client_has_Film_commande1_idx` (`commande_idcommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `historique`
--

INSERT INTO `historique` (`Client_idClient`, `Film_idFilm`, `commande_idcommande`) VALUES
(1, 1, 2),
(1, 2, 2),
(3, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `idPanier` int(11) NOT NULL AUTO_INCREMENT,
  `adresseFacturation` varchar(45) DEFAULT NULL,
  `Client_idClient` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPanier`),
  KEY `fk_panier_Client1_idx` (`Client_idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`idPanier`, `adresseFacturation`, `Client_idClient`) VALUES
(2, 'adresse', NULL),
(7, NULL, NULL),
(8, NULL, NULL),
(9, NULL, NULL),
(10, 'titi', NULL),
(13, 'tutu', 1),
(14, 'yoyo', 1),
(15, 'dflpfodkojkpgoj', 1),
(16, 'fdofijj,gdosjofig', 1),
(17, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

DROP TABLE IF EXISTS `statut`;
CREATE TABLE IF NOT EXISTS `statut` (
  `idStatut` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStatut`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`idStatut`, `nom`) VALUES
(1, 'paye'),
(2, 'a_payer'),
(3, 'livre'),
(4, 'a livrer');

-- --------------------------------------------------------

--
-- Structure de la table `t1n_atdj_creneau`
--

DROP TABLE IF EXISTS `t1n_atdj_creneau`;
CREATE TABLE IF NOT EXISTS `t1n_atdj_creneau` (
  `idCreneau` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`idCreneau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `t1n_atdj_salle`
--

DROP TABLE IF EXISTS `t1n_atdj_salle`;
CREATE TABLE IF NOT EXISTS `t1n_atdj_salle` (
  `idSalle` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`idSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `t1n_atdj_salle_creneau`
--

DROP TABLE IF EXISTS `t1n_atdj_salle_creneau`;
CREATE TABLE IF NOT EXISTS `t1n_atdj_salle_creneau` (
  `idSalleCreneau` int(11) NOT NULL AUTO_INCREMENT,
  `idSalle` int(11) NOT NULL,
  `idCreneau` int(11) NOT NULL,
  PRIMARY KEY (`idSalleCreneau`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `t1n_stdj_creneau`
--

DROP TABLE IF EXISTS `t1n_stdj_creneau`;
CREATE TABLE IF NOT EXISTS `t1n_stdj_creneau` (
  `idCreneau` int(11) NOT NULL AUTO_INCREMENT,
  `idSalle` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`idCreneau`),
  KEY `idSalle` (`idSalle`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `t1n_stdj_creneau`
--

INSERT INTO `t1n_stdj_creneau` (`idCreneau`, `idSalle`, `nom`) VALUES
(1, 1, 'creneau 2');

-- --------------------------------------------------------

--
-- Structure de la table `t1n_stdj_salle`
--

DROP TABLE IF EXISTS `t1n_stdj_salle`;
CREATE TABLE IF NOT EXISTS `t1n_stdj_salle` (
  `idSalle` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`idSalle`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `t1n_stdj_salle`
--

INSERT INTO `t1n_stdj_salle` (`idSalle`, `nom`) VALUES
(1, 'salle 2');

-- --------------------------------------------------------

--
-- Structure de la table `tnn_groupe`
--

DROP TABLE IF EXISTS `tnn_groupe`;
CREATE TABLE IF NOT EXISTS `tnn_groupe` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`idGroupe`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tnn_groupe`
--

INSERT INTO `tnn_groupe` (`idGroupe`, `nom`) VALUES
(2, 'Anglais');

-- --------------------------------------------------------

--
-- Structure de la table `tnn_groupe_membre`
--

DROP TABLE IF EXISTS `tnn_groupe_membre`;
CREATE TABLE IF NOT EXISTS `tnn_groupe_membre` (
  `idGroupe` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tnn_groupe_membre`
--

INSERT INTO `tnn_groupe_membre` (`idGroupe`, `idMembre`) VALUES
(2, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `tnn_membre`
--

DROP TABLE IF EXISTS `tnn_membre`;
CREATE TABLE IF NOT EXISTS `tnn_membre` (
  `idMembre` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`idMembre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tnn_membre`
--

INSERT INTO `tnn_membre` (`idMembre`, `nom`) VALUES
(1, 'Winston');

-- --------------------------------------------------------

--
-- Structure de la table `t_client`
--

DROP TABLE IF EXISTS `t_client`;
CREATE TABLE IF NOT EXISTS `t_client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `t_client`
--

INSERT INTO `t_client` (`idClient`, `nom`, `prenom`) VALUES
(1, 'nom1', 'prenom1');

-- --------------------------------------------------------

--
-- Structure de la table `t_mot`
--

DROP TABLE IF EXISTS `t_mot`;
CREATE TABLE IF NOT EXISTS `t_mot` (
  `idMot` int(11) NOT NULL AUTO_INCREMENT,
  `mot` varchar(255) NOT NULL,
  PRIMARY KEY (`idMot`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `t_mot`
--

INSERT INTO `t_mot` (`idMot`, `mot`) VALUES
(1, 'ActionScript'),
(2, 'AppleScript'),
(3, 'Asp'),
(4, 'BASIC'),
(5, 'C'),
(6, 'C++'),
(7, 'Clojure'),
(8, 'COBOL'),
(9, 'ColdFusion'),
(10, 'Erlang'),
(11, 'Fortran'),
(12, 'Groovy'),
(13, 'Haskell'),
(14, 'Java'),
(15, 'JavaScript'),
(16, 'Lisp'),
(17, 'Perl'),
(18, 'PHP'),
(19, 'Python'),
(20, 'Ruby'),
(21, 'Scala'),
(22, 'Scheme');

-- --------------------------------------------------------

--
-- Structure de la table `t_utilisateur`
--

DROP TABLE IF EXISTS `t_utilisateur`;
CREATE TABLE IF NOT EXISTS `t_utilisateur` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  PRIMARY KEY (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `t_utilisateur`
--

INSERT INTO `t_utilisateur` (`idUtilisateur`, `nom`, `prenom`) VALUES
(1, 'test', 'testtttt'),
(2, 'tewx', 'testtttt'),
(3, 'tewx', 'testtttt');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_Commande_panier1` FOREIGN KEY (`panier_idPanier`) REFERENCES `panier` (`idPanier`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_commande_statut1` FOREIGN KEY (`statut_idstatut`) REFERENCES `statut` (`idStatut`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `elementpanier`
--
ALTER TABLE `elementpanier`
  ADD CONSTRAINT `fk_ElementPanier_panier1` FOREIGN KEY (`panier_idPanier`) REFERENCES `panier` (`idPanier`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Film_has_Client_Film` FOREIGN KEY (`Film_idFilm`) REFERENCES `film` (`idFilm`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
