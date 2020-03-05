-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  jeu. 05 mars 2020 à 17:54
-- Version du serveur :  10.3.9-MariaDB
-- Version de PHP :  7.2.9

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
-- Structure de la table `Film`
--

CREATE TABLE `Film` (
  `idFilm` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `realisateur` varchar(45) DEFAULT NULL,
  `dateSortie` date DEFAULT NULL,
  `synopsis` varchar(255) DEFAULT NULL,
  `lienImage` varchar(255) DEFAULT NULL,
  `tarif` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Film`
--

INSERT INTO `Film` (`idFilm`, `nom`, `realisateur`, `dateSortie`, `synopsis`, `lienImage`, `tarif`) VALUES
(1, 'nom', 'realisateur', '2019-12-09', 'Pellentesque vehicula leo in mi luctus mattis. Curabitur ultricies enim sit amet ipsum ultrices, ut posuere mi aliquam. Maecenas vehicula maximus ex et', 'https://www.scribendi.com/images/cms/thumbnails/Question-Marks_720x370.jpg', 10),
(2, 'Les trois petits cochons', 'Walt Disney', '2020-01-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam laoreet vulputate lectus, eu fermentum nisl. Curabitur bibendum ipsum ex, eu pretium nisi rutrum ut.', 'https://i.ytimg.com/vi/eJi-6kZiMWw/hqdefault.jpg', 50),
(3, 'Les quatres filles du Dr March', 'Greta Gerwig', '2019-12-09', 'Les Filles du docteur March est un film dramatique américain écrit et réalisé par Greta Gerwig, sorti en 2019. Il s\'agit de l\'une des nombreuses adaptations du roman Les Quatre Filles du docteur March de Louisa May Alcott, paru en 1868.', 'https://img2.cdn.cinoche.com/images/105365b91336f3397a165cb8796532b0.jpg', 1),
(4, 'Zootopia', 'Byron Howard, Rich Mooore', '2015-12-12', 'Zootopia est une ville qui ne ressemble à aucune autre : seuls les animaux y habitent ! On y trouve des quartiers résidentiels élégants comme le très chic Sahara Square, et d\'autres moins hospitaliers comme le glacial Tundratown. ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ-EuTfGhO7We_6ukEvaqWjaMFtbWjaLEXk2auC5UkrwD_OpzHj', 2),
(5, 'Asterix et Obélix Mission Cléopatre', 'Alain Chabat', '2004-01-20', 'Ulcérée par les sarcasmes de César, la fière et sublime reine Cléopâtre lui lance un défi : si elle parvient en trois mois à lui faire construire en plein désert le plus somptueux des palais', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSqKZm5dmrA4yhARCPqnzRjCICE75E-Fqzic9ULhqilJNbNqTm3', 3),
(6, 'Monstres et Cie', 'Pete Docter', '2004-01-20', 'Monstropolis est une petite ville peuplée de monstres dont la principale source d\'énergie provient des cris des enfants. Monstres & Cie est la plus grande usine de traitement de cris de la ville.', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTz59sb26DShd7EiOSEWpSiRfiC9JGPkHcpHaz32Ln5y2bZgMhe', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Film`
--
ALTER TABLE `Film`
  ADD PRIMARY KEY (`idFilm`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Film`
--
ALTER TABLE `Film`
  MODIFY `idFilm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
