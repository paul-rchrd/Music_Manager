-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 01. Feb 2023 um 08:50
-- Server-Version: 10.4.22-MariaDB
-- PHP-Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `music_manager`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `aufnahme`
--

CREATE TABLE `aufnahme` (
  `aid` int(255) NOT NULL,
  `mid` int(255) NOT NULL,
  `kid` int(255) NOT NULL,
  `spieldauer` int(255) NOT NULL,
  `aufnahmedatum` date NOT NULL,
  `sid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kuenstler`
--

CREATE TABLE `kuenstler` (
  `kid` int(255) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `typ` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `musikstueck`
--

CREATE TABLE `musikstueck` (
  `mid` int(255) NOT NULL,
  `titel` varchar(1000) NOT NULL,
  `kid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `studio`
--

CREATE TABLE `studio` (
  `sid` int(255) NOT NULL,
  `nachname` varchar(1000) NOT NULL,
  `vorname` varchar(1000) NOT NULL,
  `plz` varchar(1000) NOT NULL,
  `straße` varchar(1000) NOT NULL,
  `Land` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `aufnahme`
--
ALTER TABLE `aufnahme`
  ADD PRIMARY KEY (`aid`),
  ADD KEY `mid` (`mid`),
  ADD KEY `kid` (`kid`),
  ADD KEY `sid` (`sid`);

--
-- Indizes für die Tabelle `kuenstler`
--
ALTER TABLE `kuenstler`
  ADD PRIMARY KEY (`kid`);

--
-- Indizes für die Tabelle `musikstueck`
--
ALTER TABLE `musikstueck`
  ADD PRIMARY KEY (`mid`),
  ADD KEY `kid` (`kid`);

--
-- Indizes für die Tabelle `studio`
--
ALTER TABLE `studio`
  ADD PRIMARY KEY (`sid`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `aufnahme`
--
ALTER TABLE `aufnahme`
  ADD CONSTRAINT `aufnahme_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `musikstueck` (`mid`),
  ADD CONSTRAINT `aufnahme_ibfk_2` FOREIGN KEY (`kid`) REFERENCES `kuenstler` (`kid`),
  ADD CONSTRAINT `aufnahme_ibfk_3` FOREIGN KEY (`sid`) REFERENCES `studio` (`sid`);

--
-- Constraints der Tabelle `musikstueck`
--
ALTER TABLE `musikstueck`
  ADD CONSTRAINT `musikstueck_ibfk_1` FOREIGN KEY (`kid`) REFERENCES `musikstueck` (`mid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
