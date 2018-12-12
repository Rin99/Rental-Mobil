-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2018 at 09:10 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rental_mobil`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_mobil`
--

CREATE TABLE IF NOT EXISTS `data_mobil` (
  `nopol_mobil` varchar(20) NOT NULL,
  `merk_mobil` varchar(20) NOT NULL,
  `tipe_mobil` varchar(15) NOT NULL,
  `tahun_mobil` int(5) NOT NULL,
  `sewa_mobil` int(15) NOT NULL,
  `status_mobil` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_mobil`
--

INSERT INTO `data_mobil` (`nopol_mobil`, `merk_mobil`, `tipe_mobil`, `tahun_mobil`, `sewa_mobil`, `status_mobil`) VALUES
('123', 'Daihatsu', 'Ayla', 2014, 350000, 'Tersedia'),
('1234', 'Brio', 'Sedan', 2012, 500000, 'Tersedia'),
('12345', 'Daihatsu', 'Agya', 2015, 400000, 'Tersedia'),
('N 1250 BS', 'Civic', 'Sedan', 2015, 600000, 'Keluar');

-- --------------------------------------------------------

--
-- Table structure for table `data_pelanggan`
--

CREATE TABLE IF NOT EXISTS `data_pelanggan` (
  `ktp_pelanggan` varchar(20) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `alamat_pelanggan` varchar(50) NOT NULL,
  `telp_pelanggan` varchar(20) NOT NULL,
  `kode_trans` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_pelanggan`
--

INSERT INTO `data_pelanggan` (`ktp_pelanggan`, `nama_pelanggan`, `alamat_pelanggan`, `telp_pelanggan`, `kode_trans`) VALUES
('12345', 'Izzu', 'Jalan Mawar', '0899', 'T001'),
('133314', 'z', 'jalan', '088', 'T001'),
('1234512313', 'Rinda', 'Malang', '089764175123', '123'),
('12345', 'Izzu', 'Jalan Mawar', '0899', 'T001'),
('133314', 'z', 'jalan', '088', 'T001'),
('123', 'shella', 'bandulan', '123', '123'),
('111', 'bima', 'malang', '111', '111'),
('111', 'shella', 'malang', '111', '111'),
('111', 'shella', 'malang', '111', '111'),
('111', 'shella', 'malang	', '111', '111'),
('111', 'apil', 'madiun', '111', '111'),
('111', 'shella', 'malang', '111', '111'),
('111', 'bima', 'bima', '111', '111'),
('1', 'apil', 'apil', '1', '1'),
('1', 'q', '1', '1', '1'),
('1', 'q', 'q', '1', '1'),
('1', 'q', '1', '1', '1'),
('1', 'q', 'q	', '1', '1'),
('1', 'q', 'q', '1', '1'),
('1', 'q', 'q', '1', '1'),
('12345123', 'kei', 'Jepun', '0987654', 'KT001'),
('123', 'qwe', 'qwe', '123', 'qwe'),
('12345', 'qwe1', 'qwe1', '123', 'qwe2'),
('6725672573', 'Yudoyono', 'adoh kono numpak becak kopling', '0987654', '123');

-- --------------------------------------------------------

--
-- Table structure for table `data_sopir`
--

CREATE TABLE IF NOT EXISTS `data_sopir` (
  `id_sopir` varchar(5) NOT NULL,
  `nama_sopir` text NOT NULL,
  `alamat_sopir` text NOT NULL,
  `telp_sopir` varchar(20) NOT NULL,
  `no_sim` varchar(30) NOT NULL,
  `tarif_sopir` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_sopir`
--

INSERT INTO `data_sopir` (`id_sopir`, `nama_sopir`, `alamat_sopir`, `telp_sopir`, `no_sim`, `tarif_sopir`) VALUES
('123', 'Bambank', 'Malang', '62123', '123', 120000),
('666', 'Susilo', 'adoh kono numpak unto', '08666666666', '666666', -100000);

-- --------------------------------------------------------

--
-- Table structure for table `data_user`
--

CREATE TABLE IF NOT EXISTS `data_user` (
  `nik_user` varchar(20) NOT NULL,
  `nama_user` varchar(20) NOT NULL,
  `alamat_user` varchar(20) NOT NULL,
  `telp_user` varchar(20) NOT NULL,
  `username_user` varchar(20) NOT NULL,
  `password_user` varchar(20) NOT NULL,
  `type_user` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_user`
--

INSERT INTO `data_user` (`nik_user`, `nama_user`, `alamat_user`, `telp_user`, `username_user`, `password_user`, `type_user`) VALUES
('123', 'bima', '123', '123', 'bima', 'bima', 'Karyawan'),
('123456789', 'rin chan', 'turen', '08912345', 'rin', 'rin', 'Karyawan'),
('234', 'admin', '234', '234', 'admin', 'admin', 'Admin'),
('345', 'saishoku', '345', '345', 'saishoku', 'saishoku', 'Karyawan');

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE IF NOT EXISTS `kendaraan` (
  `NoPlat` varchar(10) NOT NULL,
  `Tahun` int(5) NOT NULL,
  `TarifPerJam` int(11) NOT NULL,
  `StatusRental` varchar(10) NOT NULL,
  `IDType` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`NoPlat`, `Tahun`, `TarifPerJam`, `StatusRental`, `IDType`) VALUES
('B1234XY', 2013, 50000, 'Tersedia', 'TY001'),
('M1105AB', 2011, 30000, 'Tersedia', 'TY003'),
('N0608AG', 2012, 40000, 'Tersedia', 'TY004'),
('N2004AP', 2012, 35000, 'Tersedia', 'TY005'),
('N5994BZ', 2013, 45000, 'Tersedia', 'TY002');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE IF NOT EXISTS `pelanggan` (
  `NoKTP` varchar(20) NOT NULL,
  `NamaPelanggan` text NOT NULL,
  `AlamatPelanggan` text NOT NULL,
  `TelpPelanggan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`NoKTP`, `NamaPelanggan`, `AlamatPelanggan`, `TelpPelanggan`) VALUES
('11056781293', 'Anisa', 'Klojen', '0352192103'),
('12346768543', 'Nur', 'Klojen', '0862471527'),
('12373910131', 'Izzuddin', 'Mulyorejo', '0892716223'),
('12417381384', 'Dyahayu', 'Gadang', '0847289272'),
('12436388302', 'Bagoes', 'Bandulan', '0846251719');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `NoTransaksi` varchar(10) NOT NULL,
  `NoKTP` varchar(20) NOT NULL,
  `NoPlat` varchar(10) NOT NULL,
  `TglPesan` date NOT NULL,
  `TglPinjam` date NOT NULL,
  `JamPinjam` time NOT NULL,
  `TglKembaliRencana` date NOT NULL,
  `JamKembaliRencana` time NOT NULL,
  `BiayaPinjam` int(11) NOT NULL,
  `TglKembaliReal` date DEFAULT NULL,
  `JamKembaliReal` time DEFAULT NULL,
  `Denda` int(11) DEFAULT NULL,
  `KilometerPinjam` int(11) NOT NULL,
  `KilometerKembali` int(11) DEFAULT NULL,
  `BBMPinjam` int(11) NOT NULL,
  `BBMKembali` int(11) DEFAULT NULL,
  `KondisiMobilPinjam` text NOT NULL,
  `KondisiMobilKembali` text,
  `IDSopir` varchar(10) DEFAULT NULL,
  `BiayaSopir` int(11) NOT NULL,
  `TotalBiaya` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`NoTransaksi`, `NoKTP`, `NoPlat`, `TglPesan`, `TglPinjam`, `JamPinjam`, `TglKembaliRencana`, `JamKembaliRencana`, `BiayaPinjam`, `TglKembaliReal`, `JamKembaliReal`, `Denda`, `KilometerPinjam`, `KilometerKembali`, `BBMPinjam`, `BBMKembali`, `KondisiMobilPinjam`, `KondisiMobilKembali`, `IDSopir`, `BiayaSopir`, `TotalBiaya`) VALUES
('1', '1', '1234', '2018-12-10', '2018-12-10', '00:00:00', '2018-12-12', '00:00:00', 2480000, '2018-12-13', '00:00:00', 1240000, 1, 1, 1, 1, 'oke', 'qwe', '123', 120000, 3720000),
('123', '6725672573', 'N 1250 BS', '2018-12-12', '2018-12-09', '00:00:00', '2018-12-01', '00:00:00', -8000000, NULL, NULL, NULL, 100, NULL, 100, NULL, '', NULL, '666', -100000, NULL),
('KT001', '12345123', 'N 1250 BS', '2018-12-12', '2018-12-13', '07:30:00', '2018-12-16', '10:00:00', 4320000, '2018-12-16', '00:00:00', 0, 35, 12, 27, 12, 'baik', 'qwe', '123', 120000, 4320000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_mobil`
--
ALTER TABLE `data_mobil`
  ADD PRIMARY KEY (`nopol_mobil`);

--
-- Indexes for table `data_user`
--
ALTER TABLE `data_user`
  ADD PRIMARY KEY (`nik_user`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`NoPlat`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`NoKTP`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`NoTransaksi`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
