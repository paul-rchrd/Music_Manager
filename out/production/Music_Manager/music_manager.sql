-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Erstellungszeit: 01. Mrz 2023 um 11:15
-- Server-Version: 10.4.21-MariaDB
-- PHP-Version: 7.4.29

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
  `startzeit` datetime(6) DEFAULT NULL,
  `aid` int(255) NOT NULL,
  `pid` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `abstimmung`
--

INSERT INTO `abstimmung` (`bezeichnung`, `abstimmdauer`, `spieldauer`, `startzeit`, `aid`, `pid`) VALUES
('we', 2, 2, NULL, 1, NULL);

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
  `songnr` int(255) NOT NULL,
  `titel` varchar(1000) NOT NULL,
  `spieldauer` int(255) NOT NULL,
  `interpret` varchar(1000) NOT NULL,
  `anzahlStimmen` int(255) DEFAULT NULL,
  `aid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `song`
--

INSERT INTO `song` (`songnr`, `titel`, `spieldauer`, `interpret`, `anzahlStimmen`, `aid`) VALUES
(4, 'Hot', 3, 'Luca', NULL, 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `abstimmung`
--
ALTER TABLE `abstimmung`
  ADD PRIMARY KEY (`aid`),
  ADD KEY `pid` (`pid`);

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
  ADD PRIMARY KEY (`songnr`),
  ADD KEY `aid` (`aid`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `song`
--
ALTER TABLE `song`
  MODIFY `songnr` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `song`
--
ALTER TABLE `song`
  ADD CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `abstimmung` (`aid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
