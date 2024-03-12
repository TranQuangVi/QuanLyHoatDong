-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3305
-- Generation Time: Mar 12, 2024 at 02:55 AM
-- Server version: 8.0.33
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyhoatdong`
--

--
-- Dumping data for table `chitietchucvu`
--

INSERT INTO `chitietchucvu` (`maChucVu`, `maSo`) VALUES
('ADMIN', '1111111111'),
('GIANGVIEN', '2080600809'),
('SINHVIEN', '2080600800'),
('SINHVIEN', '2080600801'),
('SINHVIEN', '2080600802'),
('SINHVIEN', '2080600803'),
('SINHVIEN', '2080600804'),
('SINHVIEN', '2080600805'),
('SINHVIEN', '2080600806'),
('SINHVIEN', '2080600807'),
('SINHVIEN', '2080600808'),
('SINHVIEN', '2080600810'),
('SINHVIEN', '2080600811'),
('SINHVIEN', '2080600820'),
('SINHVIEN', '2080600822'),
('SINHVIEN', '2080600825'),
('SINHVIEN', '2080600831');

--
-- Dumping data for table `chitietnoidung`
--

INSERT INTO `chitietnoidung` (`maNoiDung`, `maSo`, `vaiTro`, `linkBaiTrinhBay`, `thoiLuongTrinhBay`, `qua`, `ghiChu`) VALUES
('MODAUHD2', '2080600808', NULL, '', 15, '', ''),
('MODAUHD2', '2080600809', NULL, '', NULL, '', ''),
('MODAUKTVDBCLPM', '2080600808', NULL, '', NULL, '', ''),
('MODAUTESTINGQA112023', '2080600808', NULL, '', 15, '', ''),
('MODAUTESTINGQA112023', '2080600809', NULL, '', 15, '', ''),
('MODAUVAITROQA122023', '2080600809', NULL, '', 15, '', ''),
('PHAN2QTPTVQLPM29112023', '2080600808', NULL, '', NULL, '', ''),
('PHAN3QTPTVQLPM29112023', '2080600808', NULL, '', NULL, '', '');

--
-- Dumping data for table `chucvu`
--

INSERT INTO `chucvu` (`maChucVu`, `tenChucVu`) VALUES
('ADMIN', 'Admin'),
('GIANGVIEN', 'Giảng viên'),
('SINHVIEN', 'Sinh viên');

--
-- Dumping data for table `dssinhviendangky`
--

INSERT INTO `dssinhviendangky` (`maHoatDong`, `maSo`, `ngayDangKy`, `gioDiemDanh`) VALUES
('HD1', '2080600809', '2023-11-27 21:18:09', NULL),
('HD2', '2080600809', '2023-11-27 21:18:20', NULL),
('KTVDBCLPM1', '2080600809', '2023-11-27 21:17:29', NULL),
('QTPTVQLPM29112023', '2080600808', '2023-11-29 22:15:41', NULL),
('QTPTVQLPM29112023', '2080600809', '2023-11-29 22:15:41', NULL),
('TESTINGQA112023', '2080600808', '2023-12-10 11:11:17', NULL),
('TESTINGQA112023', '2080600809', '2023-12-10 11:09:50', NULL),
('TESTINGQA112023', '2080600829', '2024-03-12 09:53:35', NULL),
('TESTINGQA112023', '2080600830', '2023-12-24 17:57:23', '2023-12-25 21:38:56'),
('TESTINGQA112023', '2080600831', '2023-12-24 18:01:41', NULL),
('VAITROQA112023', '2080600809', '2023-12-04 11:11:33', '2023-12-08 22:19:41'),
('VAITROQA112023', '2080600828', '2023-12-25 22:03:22', NULL),
('VAITROQA112023', '2080600830', '2023-12-24 17:58:29', '2023-12-25 21:34:33'),
('VAITROQA122023', '2080600825', '2023-12-25 23:46:00', NULL),
('VAITROQA122023', '2080600828', '2023-12-25 23:23:11', NULL),
('VAITROQA122023', '2080600829', '2024-03-12 09:55:18', NULL),
('VAITROQA122023', '2080600830', '2023-12-26 00:05:01', '2023-12-26 00:44:19');

--
-- Dumping data for table `hoatdong`
--

INSERT INTO `hoatdong` (`maHoatDong`, `maTieuChi`, `maLoaiHoatDong`, `tenHoatDong`, `thoiGianBatDau`, `thoiGianKetThuc`, `diaChi`, `soLuongSinhVien`, `yeuCau`, `hinh`, `trangThai`, `moTa`, `maSo`) VALUES
('HD1', 'HOCTAP', 'HOINHAP', 'hd1', NULL, NULL, NULL, NULL, '', 'https://scontent.fsgn15-1.fna.fbcdn.net/v/t39.30808-6/402111590_648532580801951_2517260631823624238_n.jpg?stp=dst-jpg_p960x960&_nc_cat=101&ccb=1-7&_nc_sid=3635dc&_nc_eui2=AeEuYSLrwitH5O6e1B-UKPXeQ9OlBgaR3zdD06UGBpHfN4dlstgez_6jGPEDqkFBebmonXa-1GMOEsRD9FIcVJm4&_nc_ohc=yrpaKrH1200AX-nQhgX&_nc_ht=scontent.fsgn15-1.fna&oh=00_AfAkW85AGMdo36l3rJAj5_dXoL6MJ6hxkk-QkvfISllrFw&oe=656D426A', 'Chưa mở', '', '2080600809'),
('HD2', 'HOCTAP', 'HOINHAP', 'hd2', '2023-11-17 22:17:17', NULL, NULL, 40, '', NULL, 'Đã hoàn thành', '', '2080600809'),
('KTVDBCLPM', 'HOCTAP', 'HOINHAP', 'HỘI THẢO: “KIỂM THỬ VÀ ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM”', '2023-11-17 08:39:40', '2023-11-17 08:56:42', 'Phòng E3 - 05.01, Thu Duc Campus.', 100, '', NULL, 'Đã hoàn thành', '', '2080600809'),
('KTVDBCLPM1', 'HOCTAP', 'HOINHAP', 'HỘI THẢO: “KIỂM THỬ VÀ ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM”', '2023-11-17 08:39:40', '2023-01-17 08:56:42', 'Phòng E3 - 05.01, Thu Duc Campus.', 10, '', NULL, 'Đã hoàn thành', '', '2080600809'),
('KTVDBCLPM2', 'HOCTAP', 'HOINHAP', 'HỘI THẢO: “KIỂM THỬ VÀ ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM”', '2023-11-17 08:39:40', '2023-11-17 08:56:42', 'Phòng E3 - 05.01, Thu Duc Campus.', 1000, '<p>&igrave;nksef</p>', NULL, 'Chưa mở', '<p>dọicoiwwe</p>', '2080600809'),
('KTVDBCLPM4', 'HOCTAP', 'HOINHAP', 'HỘI THẢO: “KIỂM THỬ VÀ ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM”', '2023-11-17 08:39:40', '2023-11-17 08:56:42', 'Phòng E3 - 05.01, Thu Duc Campus.', 1000, '', NULL, 'Chưa triển khai', '', '2080600809'),
('NEWKTVDBCLPM4', 'HOCTAP', 'HOINHAP', 'HỘI THẢO: “NEW KIỂM THỬ VÀ ĐẢM BẢO CHẤT LƯỢNG PHẦN MỀM”', '2023-11-21 12:30:00', '2023-11-21 16:30:00', 'E1-02.12, Thu Duc campus', 999, '', NULL, 'Chưa mở', '', '2080600809'),
('NEWQTPTVQLPM29112023', 'HOCTAP', 'HOINHAP', ' HỘI THẢO: \"NEW QUY TRÌNH PHÁT TRIỂN & QUẢN LÝ DỰ ÁN PHẦN MỀM” ', '2023-11-21 12:30:00', '2023-11-21 16:30:00', 'E1-02.12, Thu Duc campus', 1000, '', NULL, 'Chưa mở', '', '2080600809'),
('QTPTVQLPM29112023', 'HOCTAP', 'HOINHAP', ' HỘI THẢO: \"QUY TRÌNH PHÁT TRIỂN & QUẢN LÝ DỰ ÁN PHẦN MỀM” ', '2023-11-24 13:30:00', '2023-11-24 16:30:00', 'E1-02.12, Thu Duc campus', 1000, '', NULL, 'Chưa mở', '<div class=\"x11i5rnm xat24cr x1mh8g0r x1vvkbs xtlvy1s x126k92a\">\n<div dir=\"auto\">Bạn đang chuẩn bị bước ch&acirc;n v&agrave;o thế giới phần mềm v&agrave; muốn hiểu r&otilde; hơn về quy tr&igrave;nh ph&aacute;t triển cũng như quản l&yacute; dự &aacute;n trong lĩnh vực n&agrave;y? H&atilde;y tham gia Hội thảo \"Quy tr&igrave;nh ph&aacute;t triển &amp; Quản l&yacute; dự &aacute;n phần mềm\" do khoa C&ocirc;ng nghệ Th&ocirc;ng tin phối hợp c&ugrave;ng với TMA Techgroup tổ chức để đồng h&agrave;nh c&ugrave;ng những chuy&ecirc;n gia h&agrave;ng đầu v&agrave; kh&aacute;m ph&aacute; b&iacute; quyết th&agrave;nh c&ocirc;ng trong ng&agrave;nh c&ocirc;ng nghệ phần mềm.</div>\n</div>\n<div class=\"x11i5rnm xat24cr x1mh8g0r x1vvkbs xtlvy1s x126k92a\">\n<div dir=\"auto\">Phần mềm l&agrave; hạt nh&acirc;n của sự đổi mới trong mọi ng&agrave;nh, v&agrave; quy tr&igrave;nh ph&aacute;t triển cũng như quản l&yacute; dự &aacute;n đ&oacute;ng vai tr&ograve; quan trọng trong việc đảm bảo th&agrave;nh c&ocirc;ng của mỗi dự &aacute;n. Tại hội thảo, bạn sẽ được kh&aacute;m ph&aacute;:</div>\n</div>\n<div class=\"x11i5rnm xat24cr x1mh8g0r x1vvkbs xtlvy1s x126k92a\">&nbsp;</div>\n<div class=\"x11i5rnm xat24cr x1mh8g0r x1vvkbs xtlvy1s x126k92a\">&nbsp;</div>', '2080600809'),
('TESTINGQA112023', 'HOCTAP', 'HOITHAO', 'HỘI THẢO: \"TESTING & QA - VAI TRÒ, CƠ HỘI NGHỀ NGHIỆP\"', '2023-11-21 12:30:00', '2023-11-21 16:30:00', 'Phòng E2 - 02.12, Thu Duc Campus', 50, '<p>C&aacute;c bạn sinh vi&ecirc;n khi tham gia đều mặt đồng phục Hutech</p>', 'https://scontent.fdad2-1.fna.fbcdn.net/v/t39.30808-6/410683296_661394679515741_8698748821953956183_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=dd5e9f&_nc_ohc=wPMvUO_5h3cAX9BBkrn&_nc_ht=scontent.fdad2-1.fna&oh=00_AfDtJuvlhhHpS8CQcZGiy2SOx1-XVhHtllcR1jqQcOTc6A&oe=65A4A62F', 'Đang triển khai', '<p>Bạn đang quan t&acirc;m đến lĩnh vực Testing &amp; QA v&agrave; muốn t&igrave;m hiểu về vai tr&ograve; quan trọng cũng như cơ hội nghề nghiệp trong ng&agrave;nh n&agrave;y? H&atilde;y tham gia Hội thảo \"Testing &amp; QA - Vai tr&ograve;, cơ hội nghề nghiệp\" do khoa C&ocirc;ng nghệ Th&ocirc;ng tin phối hợp c&ugrave;ng c&ocirc;ng ty DXC tổ chức nhằm mục đ&iacute;ch gi&uacute;p c&aacute;c bạn sinh vi&ecirc;n kh&aacute;m ph&aacute; thế giới của Testing &amp; QA v&agrave; nhận định về cơ hội việc l&agrave;m của lĩnh vực n&agrave;y trong tương lai.</p>\n<p>Testing &amp; QA (Testing and Quality Assurance) đ&oacute;ng vai tr&ograve; quan trọng trong qu&aacute; tr&igrave;nh ph&aacute;t triển phần mềm v&agrave; ứng dụng c&ocirc;ng nghệ. Với sự gia tăng về quy m&ocirc; v&agrave; phức tạp của c&aacute;c dự &aacute;n c&ocirc;ng nghệ, việc đảm bảo chất lượng v&agrave; độ tin cậy của sản phẩm l&agrave; điều cần thiết. Testing &amp; QA đảm bảo rằng c&aacute;c sản phẩm v&agrave; dịch vụ đ&aacute;p ứng được y&ecirc;u cầu của người d&ugrave;ng v&agrave; tu&acirc;n thủ c&aacute;c ti&ecirc;u chuẩn chất lượng.</p>', '2080600809'),
('VAITROQA112023', 'HOCTAP', 'HOINHAP', 'HỘI THẢO: \"ĐỊNH HƯỚNG NGHỀ IT & TƯ VẤN CHUYÊN NGÀNH CÔNG NGHỆ THÔNG TIN\"', '2023-10-21 12:30:00', '2023-10-21 16:30:00', 'E1 - 02.12, Thu Duc Campus', 50, '', 'https://scontent.fdad2-1.fna.fbcdn.net/v/t39.30808-6/410831915_665427332445809_1407236644246901694_n.jpg?stp=dst-jpg_p960x960&_nc_cat=108&ccb=1-7&_nc_sid=3635dc&_nc_ohc=b1oMDu7LyT4AX9fx1d7&_nc_ht=scontent.fdad2-1.fna&oh=00_AfA8nzGxpwzkRya74U3xJug3h7jWJx0OEoaxFNN_p6tWmg&oe=65A441CA', 'Đang triển khai', '', '2080600809'),
('VAITROQA122023', 'HOCTAP', 'HOITHAO', 'Hội thảo “Software Testing – Vai trò và cơ hội nghề nghiệp”', '2023-12-25 22:24:20', '2023-12-26 22:24:25', 'E1 - 02.12, Thu Duc Campus', 3, '', 'https://file1.hutech.edu.vn/file/editor/vjit/828738-123456789.jpg', 'Đang triển khai', '', '2080600809');

--
-- Dumping data for table `loaihoatdong`
--

INSERT INTO `loaihoatdong` (`maLoaiHoatDong`, `tenLoaiHoatDong`) VALUES
('HOCTHUAT', 'Học thuật'),
('HOINHAP', 'Hội nhập'),
('HOITHAO', 'Hội thảo');

--
-- Dumping data for table `noidungtochuc`
--

INSERT INTO `noidungtochuc` (`maNoiDung`, `maHoatDong`, `tenNoiDung`, `thoiGianBatDau`, `thoiGianKetThuc`, `noiDung`, `ghiChu`) VALUES
('DDKTVDBCLPM2', 'KTVDBCLPM2', 'dd', NULL, NULL, '', ''),
('MODAU1HD2', 'HD2', 'Mở đầu1', NULL, NULL, '', ''),
('MODAUHD1', 'HD1', 'Mở đầu', NULL, NULL, 'dđ', ''),
('MODAUHD2', 'HD2', 'Mở đầu', NULL, NULL, '', ''),
('MODAUKTVDBCLPM', 'KTVDBCLPM', 'Mở đầu', '2023-12-25 15:50:43', '2023-12-25 15:50:43', 'Nội dung', 'string'),
('MODAUKTVDBCLPM4', 'KTVDBCLPM4', 'Mở đầu', NULL, NULL, '', ''),
('MODAUTESTINGQA112023', 'TESTINGQA112023', 'Mở đầu', '2023-11-24 13:00:00', '2023-11-24 14:00:00', '', ''),
('MODAUVAITROQA122023', 'VAITROQA122023', 'Mở đầu', '2023-12-25 15:50:43', '2023-12-25 15:50:43', '', ''),
('PHAN1HD1', 'HD1', 'Phần 1', NULL, NULL, '', ''),
('PHAN1HD2', 'HD2', 'Phần 1', NULL, NULL, 'ssss', ''),
('PHAN1QTPTVQLPM29112023', 'QTPTVQLPM29112023', 'Phần 1', '2023-11-24 14:00:00', '2023-11-24 15:00:00', 'Nội dung phần 1', ''),
('PHAN1TESTINGQA112023', 'TESTINGQA112023', 'Phần 1', '2023-11-24 13:00:00', '2023-11-24 13:00:00', '', ''),
('PHAN2QTPTVQLPM29112023', 'QTPTVQLPM29112023', 'Phần 2', '2023-11-24 15:00:00', '2023-11-24 16:00:00', 'Nội dung phần 2', ''),
('PHAN3QTPTVQLPM29112023', 'QTPTVQLPM29112023', 'Phần 3', NULL, NULL, 'Nội dung phần 3', '');

--
-- Dumping data for table `phieudangky`
--

INSERT INTO `phieudangky` (`maPhieu`, `maSo`, `maHoatDong`, `tenPhieu`, `ngayGui`, `ngayDuyet`, `trangThai`, `ghiChu`) VALUES
('KTVDBCLPM4', '2080600809', 'KTVDBCLPM4', 'KTVDBCLPM4', '2023-11-29 17:23:38', '2023-12-25 21:50:11', 'Đã duyệt', NULL),
('ma4', '2080600809', 'Hd1', 'Phiếu 4', '2023-11-29 06:08:27', '2023-12-10 14:46:07', 'Không được duyệt', 'không'),
('PDHOATDONGHD2', '2080600809', 'Hd2', 'Phiếu duyệt khởi tạo hoạt động', '2023-12-09 01:22:15', '2023-12-08 18:34:17', 'Đã duyệt', NULL),
('PDTESTINGQA112023', '2080600809', 'TESTINGQA112023', 'Phiếu duyệt khởi tạo hoạt động', '2023-12-09 01:51:25', '2023-12-08 18:52:22', 'Đã duyệt', NULL),
('PDVAITROQA112023', '2080600809', 'VAITROQA112023', 'Phiếu duyệt khởi tạo hoạt động', '2023-12-08 18:00:18', '2023-12-08 18:43:59', 'Đã duyệt', NULL),
('PDVAITROQA122023', '2080600809', 'VAITROQA122023', 'Phiếu duyệt khởi tạo hoạt động', '2023-12-26 06:12:01', '2023-12-25 23:21:08', 'Đã duyệt', 'Không');

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`maSo`, `hoTen`, `gioiTinh`, `ngaySinh`, `email`, `sdt`, `diaChi`, `hinh`, `matKhau`) VALUES
('1111111111', 'Admin', 'Nam', '2023-12-25', 'admin@gmail.com', '0355034864', 'E1-02.12, Thu Duc campus', 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$LsI7MqKxZfZCLAD4lHPUjOD5yxya.MK6xqfSuC4iWPf4h/zor6Kdi'),
('2080600800', 'SINHVIEN00', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$xBOM09lHZkdAokAQn3XyAO.Q7JG.PjT61frxI5MzzHbJNtC/mqFJ6'),
('2080600801', 'SINHVIEN01', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$15VKazJM8Och1rD1PUltmu5MkSKTEHKyPHfEFAAyDPQGrtD0.kOO6'),
('2080600802', 'SINHVIEN02', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$U4cURDF.be9W/HAPDYCWiO775ZkWxDbVyEATmilKY6Ebu.oRI.Ox2'),
('2080600803', 'SINHVIEN03', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$DGbviCe4OVEOkDdSOLw17.a7XIa/pmyStEmUT4YMkiRWjzCKzGFIW'),
('2080600804', 'SINHVIEN04', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$Y5WUPBx9pXJ5vLjvvB6yEeTXdmc8di2/44hZar3WS8q2ZTbp5YHn.'),
('2080600805', 'SINHVIEN05', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$hH0QakeggDYuU7LuDXu4teGaoBlWdmgaI54yoDBSKKCSBAGmZF2QO'),
('2080600806', 'SINHVIEN06', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$k262Ht/dmX835cNiVoO3Buy.XvAtsJHN/wK9D5wRqpKdeUQIjhr6y'),
('2080600807', 'SINHVIEN07', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$h3Mvm4RyM4pM13xe7VZCV.yhcNHxMWaBE49uIVKNs56hzsp8PuUJ.'),
('2080600808', 'Trần Quang Vỉ', NULL, NULL, NULL, NULL, NULL, 'https://www.speak2university.com/assets/admin/dist/img/user-avatar.png', NULL),
('2080600809', 'Quang Vĩ', 'Nam', NULL, 'vitran.0905202@gmail.com', '0355034864', 'E1 - 02.12, Thu Duc Campus', 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$1PXumXcID/lvV62nawh6SOnnniq.qYxZhzITUvRl2cK15SC7WGg2W'),
('2080600810', 'SINHVIEN10', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$60/gk/4wAoMOdRtdwQKB2e9evy93/qsqhhgNLDQiVHx7HHdKX4TUS'),
('2080600811', 'SINHVIEN11', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$huVo5BIf1sbqzwAquxu/mOWI3tuTt4mUZPuPUkPxVihoYquEqGRK6'),
('2080600820', '2080600820', 'Nam', '2023-12-23', 'string', 'string', 'string', 'string', '$2a$10$pXNT4xMroGU8RIKBpiJ/reCMDiNeiDjBpgvxwrK2/WhsdeKpSxAfC'),
('2080600821', 'Phạm Trọng Quốc', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$csnRIrTRqhFDqUFtN9rbGuPAYdOnfmvZHUVhMvr//1FQ0l6Eng1yy'),
('2080600822', '2080600822', 'Nam', '2023-12-23', 'string', 'string', 'string', 'string', '$2a$10$qdEk/Fp3XuiogNZWsFarX.7nQp1c.jHg8x/nua2JaVykfUq2pCww6'),
('2080600823', '2080600823', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$DIH301sxRWWHdde/qQdic.x1iio0jkAHAtXvYQcvp2uSjYkFAMM9i'),
('2080600824', '2080600824', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$XW33wapHgLKdEKJFeDfR4uQm2oggYR.Q7tlaSszzZRgKNCDXGeKKi'),
('2080600825', '2080600825', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$xEMoj.x/R19KIIuYk/hsaeh2VFZ2FNjY7g.hFpkd.Ry63wmcXy4tm'),
('2080600826', '2080600826', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$Wnpn7LieF5abwxbw.VNGx.17dpn8.F8.vizcua7b/QjJRUuyDZrUq'),
('2080600827', '2080600827', NULL, NULL, NULL, NULL, NULL, 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$QBXeEZPLTo0cHnt4yEKNl.acq6CWI76QGX1QfHPubOXx53iOd7cVG'),
('2080600828', 'Trung nè', 'Nữ', '2002-12-01', 'trungne@gmail.com', '0354782699', 'nhà của trung ', 'https://p16-capcut-sign-va.ibyteimg.com/tos-alisg-v-643f9f/3e6ad78f37934e9584cc0fe78ea35eae~tplv-nhvfeczskr-1:250:0.webp?from=1152184139&x-expires=1729167668&x-signature=3SRyogQrMTZ0skwisMPDpjD7H40%3D', '$2a$10$y71Cz50tLyLddHVzmvCErufOI8KP4MvQQO0.Jkx/hqdXYJOti29Ke'),
('2080600829', 'Phạm Trọng Quốc', 'Nữ ', '1970-01-01', 'Wbebd@gmail.com', '0985006759', '76', 'Qww', '$2a$10$iJ3pPg1eiY8CV5JP6AstD.Jm6CrZi79tvTYy3Lpwl8ySNnrc6pE.e'),
('2080600830', 'Phan Hoàng Kha', 'Nam', '2002-05-24', 'phanhoangkha@gmail.com', '0355034864', 'nhà của kha', 'https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png', '$2a$10$TtiIDonOj4egrt4/uALPc.1xbMPg.ELxTlhkcrwWndZkj40Mq9R92'),
('2080600831', 'Nguyễn Đình Hiếu', 'Nam', '2002-01-20', NULL, NULL, NULL, 'https://htmlstream.com/preview/unify-v2.6/assets/img-temp/400x450/img5.jpg', '$2a$10$XeXyubKfCD7oNqrgQwDl..HPgRrpg7JWFEkeHrSwTIe4NfodvxJr2');

--
-- Dumping data for table `tieuchi`
--

INSERT INTO `tieuchi` (`maTieuChi`, `tenTieuChi`) VALUES
('HOCTAP', 'Học tập');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
