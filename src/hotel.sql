-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 19 Kas 2023, 20:47:35
-- Sunucu sürümü: 8.0.31
-- PHP Sürümü: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `hotel`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hotel`
--

CREATE TABLE `hotel` (
  `hotel_id` int NOT NULL,
  `hotel_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_city` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_region` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_mail` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_tel` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_stars` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_features` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_board` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `hotel`
--

INSERT INTO `hotel` (`hotel_id`, `hotel_name`, `hotel_address`, `hotel_city`, `hotel_region`, `hotel_mail`, `hotel_tel`, `hotel_stars`, `hotel_features`, `hotel_board`) VALUES
(1, 'Rixos', 'Cumhuriyet mh,', 'istanbul', 'soganlı', 'batu@hotmail.com', '555 444 33 33', '4', 'Wi-fi , Otopark , fitness ', 'All includeseive'),
(8, 'Diamond', 'otak sk 5.bina', 'İstanbul', 'Bahçelievler', 'DiamondHotel@hotmail.com', '444 333 22 22', '5', 'Oto-park,Spa', 'Tam Pansion'),
(13, 'Concorde Luxury', 'vatan cd.5sk', 'Kıbrıs', 'Levent', 'concorde@gmail.com', '433 222 15 15', '5', 'Spa,Havuz,Park', 'Tam Pansiyon'),
(14, 'Cratos Premium', 'Sancak 5.sk', 'İzmir', 'Girne', 'CratosPremium@gmail.com', '377 764 45 45', '4', 'Park,Havuz', 'Tam Pansiyon'),
(15, 'Artemis', 'Atakan mh.6sk', 'Kıbrıs', 'Bafra', 'artemis@hotmail.com', '433 677 67 67', '5', 'Park,havuz', 'Tam Pansiyon'),
(16, 'Palazzo', 'muhtar mh 6.sk', 'Antalya', 'Gazi', 'Palazzo@hotmail.com', '366 666 56 56', '4', 'Park,havuz,Spa', 'Tam Pansiyon');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `reservation`
--

CREATE TABLE `reservation` (
  `id` int NOT NULL,
  `client_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `client_phone` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `client_email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `client_note` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `day` int NOT NULL,
  `reservation_start` date NOT NULL,
  `reservation_end` date NOT NULL,
  `room_id` int NOT NULL,
  `total_price` int NOT NULL,
  `hotel_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `reservation`
--

INSERT INTO `reservation` (`id`, `client_name`, `client_phone`, `client_email`, `client_note`, `day`, `reservation_start`, `reservation_end`, `room_id`, `total_price`, `hotel_id`) VALUES
(1, 'Batuhan', '555 444 32 32', 'ornek@hotmail.com', 'Yok', 0, '2023-10-01', '2023-10-05', 1, 900, 8),
(3, 'Mehmet', '444 222 22 22', 'mehmet@hotmail.com', 'Yok', 0, '2023-10-01', '2023-10-05', 1, 1000, 13),
(4, 'Ahmet', '333 222 22 22', 'ahmet@hotmail.com', 'Yok', 0, '2023-10-01', '2023-10-05', 3, 1400, 16),
(5, 'Ali', '222 223 34 34', 'Ali@hotmail.com', 'Yok', 0, '2023-10-01', '2023-10-05', 1, 2000, 14),
(6, 'Hasan', '333 333 333 333', 'hasan@hotmail.com', 'Yok', 0, '2023-10-01', '2023-10-05', 2, 1000, 13),
(7, 'batuhan', '23423', 'batuahsn', 'sadads', 3, '2023-02-01', '2023-02-04', 10500, 8, 13);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `room`
--

CREATE TABLE `room` (
  `id` int NOT NULL,
  `room_type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `stock` int NOT NULL,
  `season_id` int NOT NULL,
  `adult_price` int NOT NULL,
  `child_price` int NOT NULL,
  `type_hotel_id` int NOT NULL,
  `hotel_id` int NOT NULL,
  `room_properties` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `room`
--

INSERT INTO `room` (`id`, `room_type`, `stock`, `season_id`, `adult_price`, `child_price`, `type_hotel_id`, `hotel_id`, `room_properties`) VALUES
(17, 'Single', 6, 31, 500, 400, 25, 16, NULL),
(18, 'Double', 5, 56, 750, 600, 53, 16, NULL),
(19, 'King', 1, 43, 2000, 1000, 38, 15, NULL),
(20, 'Single', 4, 33, 400, 200, 13, 8, NULL),
(21, 'King', 2, 47, 1000, 750, 44, 13, NULL),
(25, 'Single', 10, 43, 500, 400, 38, 15, NULL),
(26, 'Single', 10, 13, 400, 200, 21, 14, NULL),
(27, 'Double', 10, 43, 450, 200, 38, 15, NULL),
(28, 'King', 5, 43, 500, 400, 38, 15, NULL),
(29, 'Single', 5, 56, 500, 450, 53, 16, NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `roomfeatures`
--

CREATE TABLE `roomfeatures` (
  `id` int NOT NULL,
  `room_id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `roomfeatures`
--

INSERT INTO `roomfeatures` (`id`, `room_id`, `name`) VALUES
(17, 16, 'TV'),
(18, 16, 'Kasa'),
(19, 16, 'Projesiyon'),
(20, 15, 'TV'),
(21, 15, 'Kasa'),
(22, 15, 'Oyun Konsolu'),
(23, 20, 'TV'),
(24, 20, 'Kasa'),
(25, 20, 'Projesiyon'),
(26, 17, 'Kasa'),
(27, 17, 'Projesiyon'),
(28, 18, 'Kasa'),
(29, 18, 'Projesiyon'),
(30, 18, 'Oyun Konsolu'),
(31, 20, 'Projesiyon'),
(32, 20, 'Oyun Konsolu'),
(33, 21, 'Minibar'),
(34, 21, 'Projesiyon'),
(35, 25, 'Minibar'),
(36, 25, 'Projesiyon');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `season`
--

CREATE TABLE `season` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `hotel_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `season`
--

INSERT INTO `season` (`id`, `name`, `start_date`, `end_date`, `hotel_id`) VALUES
(12, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 14),
(13, 'Kış Dönemi', '2024-03-01', '2024-05-31', 14),
(14, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 1),
(15, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 1),
(16, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 1),
(17, 'Kış Dönemi', '2024-03-01', '2024-05-31', 1),
(18, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 8),
(19, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 8),
(20, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 8),
(21, 'Kış Dönemi', '2024-03-01', '2024-05-31', 8),
(22, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 13),
(23, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 13),
(24, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 13),
(25, 'Kış Dönemi', '2024-03-01', '2024-05-31', 13),
(26, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 15),
(27, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 15),
(28, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 15),
(29, 'Kış Dönemi', '2024-03-01', '2024-05-31', 15),
(30, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 16),
(31, 'Kış Dönemi', '2024-03-01', '2024-05-31', 16),
(32, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 8),
(33, 'Kış Dönemi', '2024-03-01', '2024-05-31', 8),
(34, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 17),
(35, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 17),
(36, 'Kış Dönemi', '2024-03-01', '2024-05-31', 17),
(37, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 13),
(38, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 13),
(39, 'Kış Dönemi', '2024-03-01', '2024-05-31', 13),
(40, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 15),
(41, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 15),
(42, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 15),
(43, 'Kış Dönemi', '2024-03-01', '2024-05-31', 15),
(44, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 13),
(45, 'Kış Dönemi', '2024-03-01', '2024-05-31', 13),
(46, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 13),
(47, 'Kış Dönemi', '2024-03-01', '2024-05-31', 13),
(48, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 1),
(49, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 1),
(50, 'Kış Dönemi', '2024-03-01', '2024-05-31', 1),
(51, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 1),
(52, 'Kış Dönemi', '2024-03-01', '2024-05-31', 1),
(53, 'Yaz Dönemi', '2024-06-01', '2024-09-01', 1),
(54, 'Kış Dönemi', '2024-03-01', '2024-05-31', 1),
(55, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 16),
(56, 'Kış Dönemi', '2024-03-01', '2024-05-31', 16),
(57, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 8),
(58, 'Kış Dönemi', '2024-03-01', '2024-05-31', 8),
(59, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 8),
(60, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 8),
(61, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 13),
(62, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 13),
(63, 'Son Bahar Dönemi', '2024-09-02', '2024-11-30', 21),
(64, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 21),
(65, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 22),
(66, 'Kış Dönemi', '2024-03-01', '2024-05-31', 22),
(67, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 23),
(68, 'İlk Bahar Dönemi', '2024-03-01', '2024-05-31', 16),
(69, 'Kış Dönemi', '2024-03-01', '2024-05-31', 16);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `type_hotel`
--

CREATE TABLE `type_hotel` (
  `id` int NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `type_hotel`
--

INSERT INTO `type_hotel` (`id`, `type`, `hotel_id`) VALUES
(1, 'Herşey Dahil', 1),
(2, 'Tam Pansiyon', 1),
(3, 'Sadece Yatak', 1),
(4, 'Ultra Herşey Dahil', 2),
(5, 'Sadece Yatak', 2),
(6, 'Yarım Pansiyon ', 4),
(7, 'Sadece Yatak', 4),
(8, 'Oda Kahvaltı', 1),
(9, 'Tam Pansiyon', 1),
(10, 'Herşey Dahil', 8),
(11, 'Oda Kahvaltı', 8),
(12, 'Yarım Pansiyon', 8),
(13, 'Sadece Yatak', 8),
(14, 'Herşey Dahil', 13),
(15, 'Oda Kahvaltı', 13),
(16, 'Tam Pansiyon', 13),
(17, 'Yarım Pansiyon', 13),
(18, 'Ultra Herşey Dahil', 14),
(19, 'Oda Kahvaltı', 14),
(20, 'Yarım Pansiyon', 14),
(21, 'Sadece Yatak', 14),
(22, 'Herşey Dahil', 16),
(23, 'Tam Pansiyon', 16),
(24, 'Yarım Pansiyon', 16),
(25, 'Sadece Yatak', 16),
(26, 'Oda Kahvaltı', 15),
(27, 'Tam Pansiyon', 15),
(28, 'Herşey Dahil', 17),
(29, 'Oda Kahvaltı', 17),
(30, 'Tam Pansiyon', 17),
(31, 'Ultra Herşey Dahil', 13),
(32, 'Sadece Yatak', 13),
(33, 'Ultra Herşey Dahil', 15),
(34, 'Herşey Dahil', 15),
(35, 'Oda Kahvaltı', 15),
(36, 'Tam Pansiyon', 15),
(37, 'Yarım Pansiyon', 15),
(38, 'Sadece Yatak', 15),
(39, 'Ultra Herşey Dahil', 13),
(40, 'Tam Pansiyon', 13),
(41, 'Herşey Dahil', 13),
(42, 'Oda Kahvaltı', 13),
(43, 'Tam Pansiyon', 13),
(44, 'Yarım Pansiyon', 13),
(45, 'Herşey Dahil', 1),
(46, 'Oda Kahvaltı', 1),
(47, 'Yarım Pansiyon', 1),
(48, 'Herşey Dahil', 1),
(49, 'Oda Kahvaltı', 1),
(50, 'Herşey Dahil', 16),
(51, 'Oda Kahvaltı', 16),
(52, 'Tam Pansiyon', 16),
(53, 'Yarım Pansiyon', 16),
(54, 'Herşey Dahil', 8),
(55, 'Tam Pansiyon', 8),
(56, 'Tam Pansiyon', 8),
(57, 'Yarım Pansiyon', 8),
(58, 'Tam Pansiyon', 13),
(59, 'Yarım Pansiyon', 13),
(60, 'Tam Pansiyon', 21),
(61, 'Yarım Pansiyon', 21),
(62, 'Oda Kahvaltı', 22),
(63, 'Sadece Yatak', 22),
(64, 'Tam Pansiyon', 23),
(65, 'Oda Kahvaltı', 16),
(66, 'Tam Pansiyon', 16);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `uname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `pass` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `name`, `uname`, `pass`, `type`) VALUES
(1, 'batuhan', 'hotel', 'hotelpass', 'employee'),
(2, 'yetkili', 'admin', 'admin123', 'admin'),
(9, 'batu', 'batu', 'batu', 'Employee');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotel_id`);

--
-- Tablo için indeksler `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `roomfeatures`
--
ALTER TABLE `roomfeatures`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `season`
--
ALTER TABLE `season`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `type_hotel`
--
ALTER TABLE `type_hotel`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `hotel`
--
ALTER TABLE `hotel`
  MODIFY `hotel_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Tablo için AUTO_INCREMENT değeri `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `room`
--
ALTER TABLE `room`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Tablo için AUTO_INCREMENT değeri `roomfeatures`
--
ALTER TABLE `roomfeatures`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Tablo için AUTO_INCREMENT değeri `season`
--
ALTER TABLE `season`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- Tablo için AUTO_INCREMENT değeri `type_hotel`
--
ALTER TABLE `type_hotel`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
