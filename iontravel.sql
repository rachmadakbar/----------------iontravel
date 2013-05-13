-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 12, 2013 at 05:28 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `iontravel`
--

-- --------------------------------------------------------

--
-- Table structure for table `custompaket`
--

CREATE TABLE IF NOT EXISTS `custompaket` (
  `id` int(11) NOT NULL,
  `username` varchar(40) DEFAULT NULL,
  `kuantitas` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `custompaket`
--

INSERT INTO `custompaket` (`id`, `username`, `kuantitas`, `status`) VALUES
(1, 'inasjunus', 10, 1),
(2, 'inasjunus', 5, 1),
(3, 'vemmyy', 3, 0),
(4, 'JohnPantaw', 5, 1),
(5, 'vemmyy', 9, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(40) DEFAULT NULL,
  `provinsi` varchar(40) DEFAULT NULL,
  `namahotel` varchar(40) DEFAULT NULL,
  `tipe` varchar(40) NOT NULL,
  `tarif` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `nama` (`nama`,`provinsi`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `nama`, `provinsi`, `namahotel`, `tipe`, `tarif`, `status`) VALUES
(1, 'Depok', 'Jawa Barat', 'Bumi Wiyata', 'VIP', 500000, 1),
(2, 'Bandung', 'Jawa Barat', 'Hilton', 'VVIP', 1000000, 1),
(3, 'Yogyakarta', 'Yogyakarta', 'Matahari', 'Ekonomi', 250000, 0),
(4, 'Surabaya', 'Jawa Timur', 'Grand Hotel', 'VIP', 700000, 1),
(5, 'Denpasar', 'Bali', 'Bali Hotel', 'Ekonomi', 300000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hotelcustompaket`
--

CREATE TABLE IF NOT EXISTS `hotelcustompaket` (
  `idcustompaket` int(11) NOT NULL DEFAULT '0',
  `idhotel` int(11) NOT NULL DEFAULT '0',
  `tanggal` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcustompaket`,`idhotel`),
  KEY `idhotel` (`idhotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hotelcustompaket`
--

INSERT INTO `hotelcustompaket` (`idcustompaket`, `idhotel`, `tanggal`, `jumlah`) VALUES
(1, 1, '2013-05-23', 3),
(1, 4, '2013-05-08', 3),
(2, 4, '2013-05-15', 3),
(5, 4, '2013-05-08', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

CREATE TABLE IF NOT EXISTS `kota` (
  `nama` varchar(40) NOT NULL,
  `provinsi` varchar(40) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`nama`,`provinsi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kota`
--

INSERT INTO `kota` (`nama`, `provinsi`, `status`) VALUES
('Bandung', 'Jawa Barat', 1),
('Denpasar', 'Bali', 0),
('Depok', 'Jawa Barat', 1),
('Jakarta', 'Jakarta', 1),
('Lombok', 'NTT', 0),
('Surabaya', 'Jawa Timur', 1),
('Yogyakarta', 'Yogyakarta', 1);

-- --------------------------------------------------------

--
-- Table structure for table `paketfix`
--

CREATE TABLE IF NOT EXISTS `paketfix` (
  `namapaket` varchar(40) NOT NULL,
  `idtransportasiperjalanan` int(11) DEFAULT NULL,
  `idhotel` int(11) DEFAULT NULL,
  `mulai` date DEFAULT NULL,
  `berakhir` date DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`namapaket`),
  KEY `idhotel` (`idhotel`),
  KEY `idtransportasiperjalanan` (`idtransportasiperjalanan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paketfix`
--

INSERT INTO `paketfix` (`namapaket`, `idtransportasiperjalanan`, `idhotel`, `mulai`, `berakhir`, `status`) VALUES
('Backpacker''s Trip', 3, 5, '2013-05-14', '2013-05-19', 1),
('Luxury Trip', 1, 4, '2013-05-15', '2013-05-23', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pemesananpaketfix`
--

CREATE TABLE IF NOT EXISTS `pemesananpaketfix` (
  `namapaket` varchar(40) NOT NULL DEFAULT '',
  `username` varchar(40) NOT NULL DEFAULT '',
  `kuantitas` int(11) DEFAULT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`namapaket`,`username`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemesananpaketfix`
--

INSERT INTO `pemesananpaketfix` (`namapaket`, `username`, `kuantitas`, `tanggal`) VALUES
('Luxury Trip', 'vemmyy', 1, '2013-05-15');

-- --------------------------------------------------------

--
-- Table structure for table `perjalanan`
--

CREATE TABLE IF NOT EXISTS `perjalanan` (
  `darikota` varchar(40) NOT NULL DEFAULT '',
  `dariprovinsi` varchar(40) NOT NULL DEFAULT '',
  `kekota` varchar(40) NOT NULL DEFAULT '',
  `keprovinsi` varchar(40) NOT NULL DEFAULT '',
  `jarak` double DEFAULT NULL,
  PRIMARY KEY (`darikota`,`dariprovinsi`,`kekota`,`keprovinsi`),
  KEY `kekota` (`kekota`,`keprovinsi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perjalanan`
--

INSERT INTO `perjalanan` (`darikota`, `dariprovinsi`, `kekota`, `keprovinsi`, `jarak`) VALUES
('Depok', 'Jawa Barat', 'Yogyakarta', 'Yogyakarta', NULL),
('Jakarta', 'Jakarta', 'Bandung', 'Jawa Barat', 500),
('Surabaya', 'Jawa Timur', 'Denpasar', 'Bali', NULL),
('Yogyakarta', 'Yogyakarta', 'Depok', 'Jawa Barat', 800);

-- --------------------------------------------------------

--
-- Table structure for table `perjalanancustompaket`
--

CREATE TABLE IF NOT EXISTS `perjalanancustompaket` (
  `idcustompaket` int(11) NOT NULL DEFAULT '0',
  `idtransportasiperjalanan` int(11) NOT NULL DEFAULT '0',
  `berangkat` date DEFAULT NULL,
  `tiba` date DEFAULT NULL,
  PRIMARY KEY (`idcustompaket`,`idtransportasiperjalanan`),
  KEY `idtransportasiperjalanan` (`idtransportasiperjalanan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perjalanancustompaket`
--

INSERT INTO `perjalanancustompaket` (`idcustompaket`, `idtransportasiperjalanan`, `berangkat`, `tiba`) VALUES
(5, 2, '2013-05-15', '2013-05-18');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE IF NOT EXISTS `review` (
  `idreview` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `idtempatwisata` int(11) NOT NULL,
  `isi` text NOT NULL,
  `rating` int(11) NOT NULL,
  PRIMARY KEY (`idreview`),
  KEY `idtempatwisata` (`idtempatwisata`),
  KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`idreview`, `username`, `idtempatwisata`, `isi`, `rating`) VALUES
(1, 'inasjunus', 1, 'Sangat recommended untuk piknik', 4),
(2, 'vemmyy', 4, 'Agak terlalu mahal untuk kantong mahasiswa', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tempat_wisata`
--

CREATE TABLE IF NOT EXISTS `tempat_wisata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(40) NOT NULL,
  `kota` varchar(40) NOT NULL,
  `provinsi` varchar(40) NOT NULL,
  `tipe` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tempat_wisata`
--

INSERT INTO `tempat_wisata` (`id`, `nama`, `kota`, `provinsi`, `tipe`) VALUES
(1, 'Monas', 'Jakarta', 'Jakarta', 'Objek Wisata'),
(2, 'Pantai Parangtritis', 'Yogyakarta', 'Yogyakarta', 'Pantai'),
(3, 'Tanah Lot', 'Denpasar', 'Bali', 'Pantai'),
(4, 'Margo City', 'Depok', 'Jawa Barat', 'Pusat Perbelanjaan'),
(5, 'Cihampelas Walk', 'Bandung', 'Jawa Barat', 'Pusat Perbelanjaan');

-- --------------------------------------------------------

--
-- Table structure for table `transportasi`
--

CREATE TABLE IF NOT EXISTS `transportasi` (
  `namamaskapai` varchar(40) NOT NULL,
  `jenis` varchar(40) DEFAULT NULL,
  `kelas` varchar(40) DEFAULT NULL,
  `tarif` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`namamaskapai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transportasi`
--

INSERT INTO `transportasi` (`namamaskapai`, `jenis`, `kelas`, `tarif`, `status`) VALUES
('Argo Parahyangan', 'Kereta Api', 'VIP', 300000, 1),
('Deborah', 'Bus', 'Ekonomi', 40000, 1),
('Garuda Airlines', 'Pesawat', 'Bisnis', 900000, 1),
('Lion Air', 'Pesawat', 'Ekonomi', 700000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `transportasiperjalanan`
--

CREATE TABLE IF NOT EXISTS `transportasiperjalanan` (
  `id` int(11) NOT NULL,
  `darikota` varchar(40) DEFAULT NULL,
  `dariprovinsi` varchar(40) DEFAULT NULL,
  `kekota` varchar(40) DEFAULT NULL,
  `keprovinsi` varchar(40) DEFAULT NULL,
  `namamaskapai` varchar(40) DEFAULT NULL,
  `berangkat` time NOT NULL,
  `tiba` time NOT NULL,
  `tarif` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `darikota` (`darikota`,`dariprovinsi`,`kekota`,`keprovinsi`),
  KEY `namamaskapai` (`namamaskapai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transportasiperjalanan`
--

INSERT INTO `transportasiperjalanan` (`id`, `darikota`, `dariprovinsi`, `kekota`, `keprovinsi`, `namamaskapai`, `berangkat`, `tiba`, `tarif`, `status`) VALUES
(1, 'Yogyakarta', 'Yogyakarta', 'Depok', 'Jawa Barat', 'Garuda Airlines', '00:20:13', '00:20:13', 900000, 1),
(2, 'Jakarta', 'Jakarta', 'Bandung', 'Jawa Barat', 'Argo Parahyangan', '00:20:13', '00:20:13', 300000, 1),
(3, 'Surabaya', 'Jawa Timur', 'Denpasar', 'Bali', 'Deborah', '00:20:13', '00:20:13', 40000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `email` varchar(40) NOT NULL,
  `no_tlp` varchar(20) NOT NULL,
  `peran` varchar(40) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`,`no_tlp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `nama`, `alamat`, `email`, `no_tlp`, `peran`, `status`) VALUES
('AntoBudi', '123456', 'Anto Budiman', 'di jakarta', 'antooooo@ui.ac.id', '0217716188', 'customer', 0),
('inasjunus', '123456', 'Inas Junus', 'di depok', 'inas.sofiyah@ui.ac.id', '085228093956', 'customer', 1),
('JohnPantaw', '123456', 'John Pantaw', 'di jakarta', 'john@gmail.com', '0217716188', 'customer', 0),
('rachmadakbar', '123456', 'Rachmad Akbar', 'di bojonegoro', 'rachmad.akbar@ui.ac.id', '085655066327', 'manager', 1),
('vemmyy', '123456', 'Vemmy Yusiana', 'di depok', 'vemmy.yusiana@ui.ac.id', '085228093956', 'customer', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `custompaket`
--
ALTER TABLE `custompaket`
  ADD CONSTRAINT `custompaket_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE;

--
-- Constraints for table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`nama`, `provinsi`) REFERENCES `kota` (`nama`, `provinsi`) ON DELETE CASCADE;

--
-- Constraints for table `hotelcustompaket`
--
ALTER TABLE `hotelcustompaket`
  ADD CONSTRAINT `hotelcustompaket_ibfk_1` FOREIGN KEY (`idcustompaket`) REFERENCES `custompaket` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `hotelcustompaket_ibfk_2` FOREIGN KEY (`idhotel`) REFERENCES `hotel` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `paketfix`
--
ALTER TABLE `paketfix`
  ADD CONSTRAINT `paketfix_ibfk_1` FOREIGN KEY (`idhotel`) REFERENCES `hotel` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `paketfix_ibfk_2` FOREIGN KEY (`idtransportasiperjalanan`) REFERENCES `transportasiperjalanan` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `pemesananpaketfix`
--
ALTER TABLE `pemesananpaketfix`
  ADD CONSTRAINT `pemesananpaketfix_ibfk_1` FOREIGN KEY (`namapaket`) REFERENCES `paketfix` (`namapaket`) ON DELETE CASCADE,
  ADD CONSTRAINT `pemesananpaketfix_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE;

--
-- Constraints for table `perjalanan`
--
ALTER TABLE `perjalanan`
  ADD CONSTRAINT `perjalanan_ibfk_1` FOREIGN KEY (`darikota`, `dariprovinsi`) REFERENCES `kota` (`nama`, `provinsi`) ON DELETE CASCADE,
  ADD CONSTRAINT `perjalanan_ibfk_2` FOREIGN KEY (`kekota`, `keprovinsi`) REFERENCES `kota` (`nama`, `provinsi`) ON DELETE CASCADE;

--
-- Constraints for table `perjalanancustompaket`
--
ALTER TABLE `perjalanancustompaket`
  ADD CONSTRAINT `perjalanancustompaket_ibfk_1` FOREIGN KEY (`idcustompaket`) REFERENCES `custompaket` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `perjalanancustompaket_ibfk_2` FOREIGN KEY (`idtransportasiperjalanan`) REFERENCES `transportasiperjalanan` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`idtempatwisata`) REFERENCES `tempat_wisata` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transportasiperjalanan`
--
ALTER TABLE `transportasiperjalanan`
  ADD CONSTRAINT `transportasiperjalanan_ibfk_1` FOREIGN KEY (`darikota`, `dariprovinsi`, `kekota`, `keprovinsi`) REFERENCES `perjalanan` (`darikota`, `dariprovinsi`, `kekota`, `keprovinsi`) ON DELETE CASCADE,
  ADD CONSTRAINT `transportasiperjalanan_ibfk_2` FOREIGN KEY (`namamaskapai`) REFERENCES `transportasi` (`namamaskapai`) ON DELETE CASCADE;
