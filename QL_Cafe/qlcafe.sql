-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2016 at 03:57 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qlcafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `ban`
--

CREATE TABLE IF NOT EXISTS `ban` (
`MaBan` int(11) NOT NULL,
  `TenBan` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ban`
--

INSERT INTO `ban` (`MaBan`, `TenBan`, `TrangThai`) VALUES
(1, 'Bàn 1', 'Đã đặt trước'),
(2, 'Bàn 2', 'Trống'),
(3, 'Bàn 3', 'Trống'),
(4, 'Bàn 4', 'Trống'),
(5, 'Bàn 5', 'Đã đặt trước'),
(6, 'Bàn 6', 'Đang phục vụ'),
(7, 'Bàn 7', 'Trống'),
(8, 'Bàn 8', 'Đang phục vụ'),
(9, 'Bàn 9', 'Trống'),
(10, 'Bàn 10', 'Trống'),
(11, 'Bàn 12', 'Đã đặt trước'),
(12, 'Bàn 13', 'Trống'),
(13, 'Bàn 13', 'Đã đặt trước'),
(14, 'Bàn 14', 'Đã đặt trước'),
(15, 'Bàn 15', 'Trống'),
(16, 'Bàn 16', 'Trống'),
(17, 'Bàn 17', 'Đang phục vụ'),
(18, 'Bàn 18', 'Trống'),
(19, 'Bàn 19', 'Trống'),
(25, 'Bàn 25', 'Trống'),
(26, 'bàn 26', 'Trống'),
(27, 'bàn 27', 'Trống'),
(28, 'bàn 28', 'Trống'),
(29, 'bàn 29', 'Trống'),
(30, 'bàn 30', 'Trống');

-- --------------------------------------------------------

--
-- Table structure for table `chitiethd`
--

CREATE TABLE IF NOT EXISTS `chitiethd` (
`MaChiTietHD` int(11) NOT NULL,
  `MaHoaDon` int(11) NOT NULL,
  `MaMon` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Gia` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=347 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitiethd`
--

INSERT INTO `chitiethd` (`MaChiTietHD`, `MaHoaDon`, `MaMon`, `SoLuong`, `Gia`) VALUES
(293, 159, 9, 5, 50000),
(294, 160, 32, 10, 60000),
(295, 161, 40, 12, 20000),
(296, 162, 16, 2, 25000),
(297, 163, 21, 5, 500000),
(298, 164, 15, 1, 25000),
(299, 165, 7, 1, 25000),
(300, 166, 37, 1, 25000),
(302, 168, 7, 1, 25000),
(304, 170, 21, 12, 500000),
(306, 172, 10, 3, 40000),
(307, 173, 21, 2, 500000),
(308, 174, 33, 2, 20000),
(310, 176, 27, 1, 35000),
(311, 177, 14, 1, 20000),
(313, 179, 11, 2, 69000),
(314, 180, 29, 2, 15000),
(315, 181, 20, 1, 15000),
(316, 182, 44, 2, 25000),
(317, 183, 23, 2, 35000),
(318, 184, 17, 1, 20000),
(319, 184, 45, 1, 25000),
(320, 184, 34, 3, 25000),
(321, 184, 35, 2, 25000),
(322, 184, 30, 2, 15000),
(323, 184, 8, 2, 25000),
(324, 185, 26, 1, 30000),
(325, 186, 26, 1, 30000),
(326, 187, 17, 1, 20000),
(327, 188, 34, 1, 25000),
(328, 189, 35, 2, 25000),
(329, 187, 9, 1, 50000),
(330, 187, 36, 3, 25000),
(331, 187, 37, 2, 25000),
(332, 190, 17, 1, 20000),
(333, 191, 20, 1, 15000),
(334, 192, 11, 1, 69000),
(335, 193, 41, 1, 20000),
(342, 195, 15, 1, 15000),
(343, 195, 44, 1, 25000),
(344, 191, 26, 1, 30000),
(346, 191, 17, 2, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE IF NOT EXISTS `hoadon` (
`MaHoaDon` int(11) NOT NULL,
  `GiamGia` int(11) DEFAULT NULL,
  `MaBan` int(11) NOT NULL,
  `GioDen` datetime NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `GiamGia`, `MaBan`, `GioDen`, `TongTien`, `TrangThai`) VALUES
(159, NULL, 5, '2016-02-17 19:44:48', 250000, 1),
(160, NULL, 17, '2016-01-17 19:45:04', 600000, 1),
(161, NULL, 13, '2016-01-17 19:45:13', 240000, 1),
(162, NULL, 6, '2016-03-17 19:45:20', 50000, 1),
(163, NULL, 9, '2016-03-17 19:45:33', 2500000, 1),
(164, NULL, 1, '2016-03-17 19:50:24', 25000, 1),
(165, NULL, 9, '2016-03-17 19:50:28', 25000, 1),
(166, NULL, 13, '2016-03-17 19:50:33', 25000, 1),
(168, NULL, 7, '2016-02-17 19:50:42', 25000, 1),
(170, NULL, 1, '2016-03-17 20:14:16', 6000000, 1),
(172, NULL, 9, '2016-03-17 20:14:37', 102000, 1),
(173, NULL, 8, '2016-03-17 20:14:47', 1000000, 1),
(174, NULL, 16, '2016-03-17 20:14:59', 40000, 1),
(176, NULL, 1, '2016-03-17 20:15:37', 35000, 1),
(177, 20000, 14, '2016-03-17 23:47:38', 0, 1),
(179, 35, 5, '2016-03-17 23:52:59', 89700, 1),
(180, NULL, 17, '2016-03-17 23:53:14', 30000, 1),
(181, 5, 7, '2016-03-17 23:53:50', 14250, 1),
(182, 30, 2, '2016-03-17 23:54:01', 35000, 1),
(183, 5, 9, '2016-03-18 00:11:27', 66500, 1),
(184, 10, 14, '2015-12-18 00:11:57', 225000, 1),
(185, NULL, 14, '2015-09-18 00:15:15', 30000, 1),
(186, NULL, 17, '2015-07-18 00:15:20', 30000, 1),
(187, 20, 2, '2016-02-18 00:15:25', 156000, 1),
(188, NULL, 8, '2016-01-18 00:15:31', 25000, 1),
(189, NULL, 25, '2016-03-18 00:15:42', 50000, 1),
(190, NULL, 3, '2016-03-18 09:17:29', 20000, 1),
(191, 20, 8, '2016-03-18 09:28:01', NULL, 0),
(192, NULL, 17, '2016-03-18 09:28:05', NULL, 0),
(193, NULL, 6, '2016-03-18 09:28:09', NULL, 0),
(195, 10, 2, '2016-03-18 09:34:47', 36000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhommon`
--

CREATE TABLE IF NOT EXISTS `nhommon` (
`MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MauSac` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhommon`
--

INSERT INTO `nhommon` (`MaLoai`, `TenLoai`, `MauSac`) VALUES
(1, 'Cà phê', '#ac3939'),
(2, 'Nước đóng chai', '#66b3ff'),
(3, 'Nước-Lon', '#9900ff'),
(4, 'Lipton-Trà', '#ffcc00'),
(5, 'Sinh tố', '#40ff00'),
(6, 'Thứ khác', '#e68a00'),
(14, 'Đồ ăn nhanh', '#009966'),
(15, 'Chè', '#dee612');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE IF NOT EXISTS `taikhoan` (
`id` int(11) NOT NULL,
  `username` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `lv` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `username`, `password`, `lv`) VALUES
(2, 'nhanvien', '1', 2),
(6, 'thanggun99', 'thang', 1),
(7, 'nhanvien1', '1', 2),
(9, 'hoa', '1', 1),
(10, 'nhanvien2', '1', 2),
(11, 'nhanvien3', '1', 2),
(12, 'nhanvien4', '1', 2),
(13, 'nhanvien5', '1', 2);

-- --------------------------------------------------------

--
-- Table structure for table `thucdon`
--

CREATE TABLE IF NOT EXISTS `thucdon` (
`MaMon` int(11) NOT NULL,
  `TenMon` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `DVT` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thucdon`
--

INSERT INTO `thucdon` (`MaMon`, `TenMon`, `MaLoai`, `DonGia`, `DVT`) VALUES
(7, 'Nâu đá xào me', 1, 25000, 'Ly'),
(8, 'Nâu nóng không sữa', 1, 25000, 'Ly'),
(9, 'Cafe Sữa', 1, 50000, 'Ly'),
(10, 'Lọc đá vắt chanh', 2, 40000, 'Chậu'),
(11, 'Nâu lắc', 1, 69000, 'Ly'),
(12, 'Trà Xanh ', 2, 25000, 'Chai'),
(13, 'Trà C2', 2, 20000, 'Chai'),
(14, 'Chanh muối', 2, 20000, 'Chai'),
(15, 'Coca Cola', 3, 25000, 'Lon'),
(16, 'RedBull', 3, 25000, 'Lon'),
(17, 'Pepsi', 3, 20000, 'Lon'),
(18, 'Trà Gừng', 4, 25000, 'Ly'),
(19, 'Trà Dilmah', 4, 25000, 'Ly'),
(20, 'Trà chanh', 4, 15000, 'Ly'),
(21, 'Trà My', 15, 200000, 'Bát'),
(22, 'Sinh tố Xoài', 5, 30000, 'Ly'),
(23, 'Sinh tố bơ', 5, 35000, 'Ly'),
(24, 'Sinh tố Dưa Hấu', 5, 30000, 'Ly'),
(25, 'Sinh tố Mãng Cầu', 5, 35000, 'Ly'),
(26, 'Sinh tố chanh leo', 5, 30000, 'Ly'),
(27, 'Sinh tố dưa chuột', 5, 35000, 'Ly'),
(28, 'Chó xào xả ớt', 6, 250000, 'Đĩa'),
(29, 'Hướng Dương', 6, 15000, 'Đĩa'),
(30, 'Khoai chiên', 6, 15000, 'Miếng'),
(31, 'Vinaphone', 6, 30000, 'Bao'),
(32, '555', 6, 60000, 'Bao'),
(33, 'Thăng Long', 6, 20000, 'Bao'),
(34, 'Cao cao nóng', 1, 25000, 'Ly'),
(35, 'Ca cao nguội', 1, 25000, 'Ly'),
(36, 'Đen đá', 1, 25000, 'Ly'),
(37, 'Đen nóng ', 1, 25000, 'Ly'),
(38, 'Bia Ken', 3, 25000, 'Lon'),
(40, 'Bia Sài Gòn', 3, 20000, 'Lon'),
(41, 'Bia Hà Nội', 3, 20000, 'Lon'),
(44, 'Bia Kenn', 3, 25000, 'Lon'),
(45, 'Bia Ken', 3, 25000, 'Lon'),
(57, 'Mỳ tôm', 14, 15000, 'Bát'),
(58, 'Bánh mỳ pate', 14, 15000, 'Cái'),
(59, 'Mực nướng', 14, 55000, 'Con'),
(60, 'chè thập cẩm', 15, 20000, 'Cốc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ban`
--
ALTER TABLE `ban`
 ADD PRIMARY KEY (`MaBan`);

--
-- Indexes for table `chitiethd`
--
ALTER TABLE `chitiethd`
 ADD PRIMARY KEY (`MaChiTietHD`), ADD KEY `MaHoaDon` (`MaHoaDon`), ADD KEY `MaMon` (`MaMon`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
 ADD PRIMARY KEY (`MaHoaDon`), ADD KEY `MaBan` (`MaBan`);

--
-- Indexes for table `nhommon`
--
ALTER TABLE `nhommon`
 ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thucdon`
--
ALTER TABLE `thucdon`
 ADD PRIMARY KEY (`MaMon`), ADD KEY `MaLoai` (`MaLoai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ban`
--
ALTER TABLE `ban`
MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `chitiethd`
--
ALTER TABLE `chitiethd`
MODIFY `MaChiTietHD` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=347;
--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=196;
--
-- AUTO_INCREMENT for table `nhommon`
--
ALTER TABLE `nhommon`
MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `thucdon`
--
ALTER TABLE `thucdon`
MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=61;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethd`
--
ALTER TABLE `chitiethd`
ADD CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`),
ADD CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`MaMon`) REFERENCES `thucdon` (`MaMon`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`);

--
-- Constraints for table `thucdon`
--
ALTER TABLE `thucdon`
ADD CONSTRAINT `thucdon_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `nhommon` (`MaLoai`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;