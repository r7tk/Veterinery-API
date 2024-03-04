-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 04 Mar 2024, 15:15:13
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
-- Veritabanı: `vet`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `animals`
--

CREATE TABLE `animals` (
  `animal_id` bigint NOT NULL,
  `animal_breed` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `animal_color` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `animal_birth_day` date DEFAULT NULL,
  `animal_gender` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `animal_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `animal_species` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `animal_customer_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `animals`
--

INSERT INTO `animals` (`animal_id`, `animal_breed`, `animal_color`, `animal_birth_day`, `animal_gender`, `animal_name`, `animal_species`, `animal_customer_id`) VALUES
(2, 'calicos', 'threecolor', '2015-06-06', 'female', 'mia', 'cat', 3),
(3, 'corgi', 'brown', '2016-06-06', 'female', 'fındık', 'dog', 4),
(4, 'scottish shorthair', 'ash-grey', '2016-06-06', 'male', 'pati', 'cat', 5),
(5, 'iki hörgüçlü', 'pink', '2025-06-06', 'male', 'Cemal', 'Camel', 7),
(6, '125cc', 'white', '2025-06-06', 'male', 'Honda Dio', 'motor', 6),
(7, 'sarman', 'beyaz ve sarı', NULL, 'erkek', 'Bızdık', 'cat', 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `appointment_dates`
--

CREATE TABLE `appointment_dates` (
  `appointment_id` bigint NOT NULL,
  `appointment_date` datetime(6) DEFAULT NULL,
  `appointment_animal_id` bigint DEFAULT NULL,
  `appointment_doctor_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `appointment_dates`
--

INSERT INTO `appointment_dates` (`appointment_id`, `appointment_date`, `appointment_animal_id`, `appointment_doctor_id`) VALUES
(1, '2024-03-03 19:00:00.000000', 2, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `available_dates`
--

CREATE TABLE `available_dates` (
  `available_id` bigint NOT NULL,
  `available_date` date DEFAULT NULL,
  `availabledate_doctor_id` bigint DEFAULT NULL,
  `available_date_doctor_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `available_dates`
--

INSERT INTO `available_dates` (`available_id`, `available_date`, `availabledate_doctor_id`, `available_date_doctor_id`) VALUES
(1, '2024-03-03', 1, NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customers`
--

CREATE TABLE `customers` (
  `customer_id` bigint NOT NULL,
  `customer_address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `customer_city` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `customer_mail` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `customer_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `customer_phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `customers`
--

INSERT INTO `customers` (`customer_id`, `customer_address`, `customer_city`, `customer_mail`, `customer_name`, `customer_phone`) VALUES
(3, 'Kocasinan', 'Kayseri', 'omerfarukbaran@patika.dev', 'Ömer Faruk Baran', '0506 1316 706'),
(4, 'Tepe', 'İzmir', 'alpermudurlu@patika.dev', 'Alper Mudurlu', '0507 1316 706'),
(5, 'Tepe', 'İzmir', 'cumhurakarsu@patika.dev', 'Cumhur Akarsu', '0508 1316 706'),
(6, 'Nazilli', 'Aydın', 'aliorkan@patika.dev', 'Ali Orkan', '0509 1316 706'),
(7, 'Sapanca gölü etrafı', 'Sakarya', 'berkansener@patika.dev', 'Berkan Şener', '0510 1316 706');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `doctors`
--

CREATE TABLE `doctors` (
  `doctor_id` bigint NOT NULL,
  `doctor_address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `doctor_city` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `doctor_mail` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `doctor_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `doctor_phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `doctors`
--

INSERT INTO `doctors` (`doctor_id`, `doctor_address`, `doctor_city`, `doctor_mail`, `doctor_name`, `doctor_phone`) VALUES
(1, 'patika', 'İstanbul', 'ali@patika.dev', 'Ali Rıza Şimşek', '54654654132'),
(2, 'patika', 'İzmir', 'alpermudurnuoglu@patika.dev', 'Alper Müdürnüoğlu', '54654654135'),
(3, 'Ayvalık', 'Balıkesir', 'mrtyldz@vet.com', 'Mert Yıldız', '45654544655');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `vaccines`
--

CREATE TABLE `vaccines` (
  `vaccine_id` bigint UNSIGNED NOT NULL,
  `vaccine_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `vaccine_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `vaccine_protection_finish_date` date DEFAULT NULL,
  `vaccine_protection_start_date` date DEFAULT NULL,
  `animal_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `vaccines`
--

INSERT INTO `vaccines` (`vaccine_id`, `vaccine_code`, `vaccine_name`, `vaccine_protection_finish_date`, `vaccine_protection_start_date`, `animal_id`) VALUES
(1, '0000285', 'Kuduz Aşısı', '2024-12-03', '2024-06-03', 2),
(2, '0000286', 'Karma Aşı', '2024-12-03', '2024-06-03', 2),
(3, '0000287', 'Gençlik Aşısı', '2024-12-03', '2024-06-03', 2);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`animal_id`),
  ADD KEY `FKnjsvd8kplxqmf48ybxayrx6ru` (`animal_customer_id`);

--
-- Tablo için indeksler `appointment_dates`
--
ALTER TABLE `appointment_dates`
  ADD PRIMARY KEY (`appointment_id`),
  ADD KEY `FKkjblc1r2k6fw5rlkg1o2dmcvj` (`appointment_animal_id`),
  ADD KEY `FK86j937ho3nbll90e1tfr1wt23` (`appointment_doctor_id`);

--
-- Tablo için indeksler `available_dates`
--
ALTER TABLE `available_dates`
  ADD PRIMARY KEY (`available_id`),
  ADD KEY `FKrqb0ca2euhxjlmbkd4i3ncxfg` (`availabledate_doctor_id`),
  ADD KEY `FKf7jtwolyhaj07c4oh0j4pncb` (`available_date_doctor_id`);

--
-- Tablo için indeksler `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Tablo için indeksler `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`doctor_id`);

--
-- Tablo için indeksler `vaccines`
--
ALTER TABLE `vaccines`
  ADD PRIMARY KEY (`vaccine_id`),
  ADD UNIQUE KEY `vaccine_id` (`vaccine_id`),
  ADD KEY `FKeasdy15b2kp5j4k13x2dfudqs` (`animal_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `animals`
--
ALTER TABLE `animals`
  MODIFY `animal_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `appointment_dates`
--
ALTER TABLE `appointment_dates`
  MODIFY `appointment_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `available_dates`
--
ALTER TABLE `available_dates`
  MODIFY `available_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `doctors`
--
ALTER TABLE `doctors`
  MODIFY `doctor_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `vaccines`
--
ALTER TABLE `vaccines`
  MODIFY `vaccine_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `animals`
--
ALTER TABLE `animals`
  ADD CONSTRAINT `FKnjsvd8kplxqmf48ybxayrx6ru` FOREIGN KEY (`animal_customer_id`) REFERENCES `customers` (`customer_id`);

--
-- Tablo kısıtlamaları `appointment_dates`
--
ALTER TABLE `appointment_dates`
  ADD CONSTRAINT `FK86j937ho3nbll90e1tfr1wt23` FOREIGN KEY (`appointment_doctor_id`) REFERENCES `doctors` (`doctor_id`),
  ADD CONSTRAINT `FKkjblc1r2k6fw5rlkg1o2dmcvj` FOREIGN KEY (`appointment_animal_id`) REFERENCES `animals` (`animal_id`);

--
-- Tablo kısıtlamaları `available_dates`
--
ALTER TABLE `available_dates`
  ADD CONSTRAINT `FKf7jtwolyhaj07c4oh0j4pncb` FOREIGN KEY (`available_date_doctor_id`) REFERENCES `doctors` (`doctor_id`),
  ADD CONSTRAINT `FKrqb0ca2euhxjlmbkd4i3ncxfg` FOREIGN KEY (`availabledate_doctor_id`) REFERENCES `doctors` (`doctor_id`);

--
-- Tablo kısıtlamaları `vaccines`
--
ALTER TABLE `vaccines`
  ADD CONSTRAINT `FKeasdy15b2kp5j4k13x2dfudqs` FOREIGN KEY (`animal_id`) REFERENCES `animals` (`animal_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
