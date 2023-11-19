# Turizm Acenta Sistemi

## Proje Açıklaması

Bu proje, bir turizm acentasının temel işlemlerini yönetmek amacıyla geliştirilmiş bir yazılım sistemidir. Sistem, kullanıcıların giriş yaparak rezervasyon yapmalarını, otel yönetimini kontrol etmelerini ve genel acente işlemlerini gerçekleştirmelerini sağlar.

## Proje Yapısı

Proje, MVC (Model-View-Controller) mimarisini temel alır ve işlemlerini üç ana parçada gerçekleştirir: `helper`, `model` ve `view`.

1. **Helper:** Sistemdeki yardımcı işlemleri yönetir. Veritabanı işlemleri, otel yönetimi ve rezervasyon listesi gibi temel işlevselliği içerir.

2. **Model:** Veritabanı işlemleri ve veri yapısı ile ilgili işlemleri yönetir. Kullanıcılar, oteller ve rezervasyonlar gibi veritabanı entegrasyonunu sağlar.

3. **View:** Kullanıcı arayüzlerini oluşturur. Login, Employee, Admin ve Reservation arayüzlerini içerir.

## Kullanıcı Arayüzleri

Projede toplam dört farklı arayüz bulunmaktadır:

1. **LoginGUI:** Giriş ekranı, kullanıcı adı ve şifre ile sisteme erişim sağlar.

![image](https://github.com/batuhanlog/Turizm-Acenta-Sistemi/assets/82649079/175f0d6f-0dfe-4c69-aee9-8191825d6abf)


2. **EmployeeGUI:** Acenta çalışanlarının kullanabileceği arayüz. Üç ana bölümden oluşur:
  - Otel Yönetim Sistemi
   ![image](https://github.com/batuhanlog/Turizm-Acenta-Sistemi/assets/82649079/5756b9fe-609b-44e9-985b-f21179d0d929)
  - Oda Yönetim Sistemi
   ![image](https://github.com/batuhanlog/Turizm-Acenta-Sistemi/assets/82649079/e358ae8c-0d46-4c72-b82c-685a2fd53da0)

  - Rezervasyon Listesi
  ![image](https://github.com/batuhanlog/Turizm-Acenta-Sistemi/assets/82649079/aae92706-ed7c-4355-a5c7-e03ff258bbf3)

  - Oda Ekleme
![image](https://github.com/batuhanlog/Turizm-Acenta-Sistemi/assets/82649079/ecfe2daf-3f6e-45eb-94ce-2320b3037163)


3. **AdminGUI:** Acenta yöneticilerinin kullanabileceği arayüz. Kullanıcı yönetimi ve arama özelliklerini içerir.
![image](https://github.com/batuhanlog/Turizm-Acenta-Sistemi/assets/82649079/fe664946-add6-4742-85d2-e16866014bfe)

4. **ReservationGUI:** Rezervasyon işlemlerini yönetir. İletişim bilgileri ve rezervasyon detayları gibi verileri alır.
    ![image](https://github.com/batuhanlog/Turizm-Acenta-Sistemi/assets/82649079/aae92706-ed7c-4355-a5c7-e03ff258bbf3)
