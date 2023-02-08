-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 01. Feb 2023 um 09:54
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
-- Tabellenstruktur für Tabelle `abstimmung`
--

CREATE TABLE `abstimmung` (
  `bezeichnung` varchar(1000) NOT NULL,
  `abstimmdauer` int(255) NOT NULL,
  `spieldauer` int(255) NOT NULL,
  `startzeit` datetime(6) NOT NULL,
  `aid` int(255) NOT NULL,
  `sid` int(255) NOT NULL,
  `pid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `playlist`
--

CREATE TABLE `playlist` (
  `bezeichnung` varchar(1000) NOT NULL,
  `pid` int(255) NOT NULL,
  `songid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `song`
--

CREATE TABLE `song` (
  `autowert` int(255) NOT NULL,
  `songnr` int(255) NOT NULL,
  `titel` varchar(1000) NOT NULL,
  `spieldauer` int(255) NOT NULL,
  `interpret` varchar(1000) NOT NULL,
  `anzahlStimmen` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `abstimmung`
--
ALTER TABLE `abstimmung`
  ADD PRIMARY KEY (`aid`),
  ADD KEY `pid` (`pid`),
  ADD KEY `sid` (`sid`);

--
-- Indizes für die Tabelle `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `songid` (`songid`);

--
-- Indizes für die Tabelle `song`
--
ALTER TABLE `song`
  ADD PRIMARY KEY (`autowert`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `abstimmung`
--
ALTER TABLE `abstimmung`
  ADD CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `playlist` (`pid`),
  ADD CONSTRAINT `sid` FOREIGN KEY (`sid`) REFERENCES `song` (`autowert`);

--
-- Constraints der Tabelle `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `songid` FOREIGN KEY (`songid`) REFERENCES `song` (`autowert`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
