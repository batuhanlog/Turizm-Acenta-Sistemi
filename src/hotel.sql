-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 12 Kas 2023, 18:16:10
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
  `room_id` int NOT NULL,
  `check_in` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `check_out` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `adult_numb` int NOT NULL,
  `child_numb` int NOT NULL,
  `total_price` int NOT NULL,
  `hotel_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `reservation`
--

INSERT INTO `reservation` (`id`, `client_name`, `client_phone`, `client_email`, `client_note`, `room_id`, `check_in`, `check_out`, `adult_numb`, `child_numb`, `total_price`, `hotel_id`) VALUES
(1, 'Batuhan', '555 444 32 32', 'ornek@hotmail.com', 'Yok', 1, '01/01/2023', '07/01/2023', 400, 500, 900, 8),
(3, 'Mehmet', '444 222 22 22', 'mehmet@hotmail.com', 'Yok', 1, '03/05/2023', '08/05/2023', 700, 300, 1000, 13),
(4, 'Ahmet', '333 222 22 22', 'ahmet@hotmail.com', 'Yok', 3, '26/11/2023', '30/11/2023', 1000, 400, 1400, 16),
(5, 'Ali', '222 223 34 34', 'Ali@hotmail.com', 'Yok', 1, '15/12/2023', '30/12/2023', 1200, 800, 2000, 14),
(6, 'Hasan', '333 333 333 333', 'hasan@hotmail.com', 'Yok', 2, '03/03/2024', '10/03/2024', 500, 500, 1000, 13);

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
  `hotel_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `room`
--

INSERT INTO `room` (`id`, `room_type`, `stock`, `season_id`, `adult_price`, `child_price`, `type_hotel_id`, `hotel_id`) VALUES
(1, 'Double', 4, 2, 400, 200, 2, 1),
(3, 'Single', 3, 2, 750, 450, 1, 8),
(5, 'King', 2, 1, 500, 400, 2, 13),
(6, 'Single', 4, 2, 600, 400, 1000, 1),
(7, 'Double', 3, 2, 1200, 700, 1900, 1),
(8, 'King', 3, 1, 2000, 1500, 3500, 13);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `room_properties`
--

CREATE TABLE `room_properties` (
  `id` int NOT NULL,
  `property` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `room_id` int NOT NULL,
  `bed` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `area` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `room_properties`
--

INSERT INTO `room_properties` (`id`, `property`, `room_id`, `bed`, `area`) VALUES
(1, 'Televizyon\r\nMinibar', 1, '', 50),
(2, 'Oyun Konsolu\r\nKasa', 2, '', 20);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `season`
--

CREATE TABLE `season` (
  `id` int NOT NULL,
  `season_start` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `season_end` char(255) COLLATE utf8mb4_general_ci NOT NULL,
  `hotel_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `season`
--

INSERT INTO `season` (`id`, `season_start`, `season_end`, `hotel_id`) VALUES
(1, '01/10/2024', '30/05/2023', 1),
(2, '01/06/2023', '30/09/2024', 1),
(3, '01/01/2025', '31/05/2025', 2),
(4, '01/06/2025', '31/12/2025', 2),
(5, '01/01/2024', '30/09/2023', 4);

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
(7, 'Sadece Yatak', 4);

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
(2, 'yetkili', 'admin', 'admin123', 'admin');

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
-- Tablo için indeksler `room_properties`
--
ALTER TABLE `room_properties`
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
  MODIFY `hotel_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Tablo için AUTO_INCREMENT değeri `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `room`
--
ALTER TABLE `room`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `room_properties`
--
ALTER TABLE `room_properties`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `season`
--
ALTER TABLE `season`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `type_hotel`
--
ALTER TABLE `type_hotel`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
