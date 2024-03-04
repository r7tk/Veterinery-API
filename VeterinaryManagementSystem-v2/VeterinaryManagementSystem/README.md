# Başlamadan Önce

## Yazarlar ve Teşekkür

- [@Alper Mudurlu](https://www.github.com/devalper35) Proje Geliştirme Aşamasında Yardımcı.
- [@Berkan Şener](https://www.github.com/berkansener) Proje Geliştirme Aşamasında Yardımcı.
- [@Cumhur Akarsu](https://www.github.com/akarsu35) Proje Geliştirme Aşamasında Yardımcı.
- [@Ömer Faruk BARAN](https://www.github.com/r7tk) Proje Geliştirme Aşamasında Yardımcı.


- [@Fatih Fedai](https://www.github.com/mffedai) Proje bitirmede ve Bug Fixlemede Yardımcı olduğu için.

-

* Bu proje Alper Mudurlu , Berkan Şener ve Ömer Faruk BARAN, Cumhur Akarsu
* Özel Olarakta Fatih Fedai Teşekkürlerimi Sunarım.

### PROJENİN TEMEL FONKSİYONLARI

* **5 NUMARALI SORGU**  Projede DB bağlantı konfigürasyonu doğru bir şekilde yapılmış mı?

![dbresim.png](images%2Fdbresim.png)

* **6 NUMARALI SORGU** Katmanlı mimari kullanılmış mı? Entity, repository (dao), service (business), controller (api)
  katmanları oluşturulmuş mu?

![sorgu6.png](images%2Fsorgu6.png)

* **7 NUMARALI SORGU** UML diyagramı doğru şekilde oluşturulmuş mu?

* ![uml.png](images%2Fuml.png)

* **8 NUMARALI SORGU** Entity’ler doğru bir şekilde tanımlanmış mı?

![entities.png](images%2Fentities.png)

* **9 NUMARALI SORGU** Entity’ler arasındaki ilişkiler (@OneToMany, @ManyToOne, @ManyToMany vs.) doğru bir şekilde
  tanımlanmış mı?
  ![mto.png](images%2Fmto.png)
  ![mto1.png](images%2Fmto1.png)
  ![mto2.png](images%2Fmto2.png)

* **10 NUMARALI SORGU** Proje isterlerine göre hayvan sahibi kaydediliyor mu?

Kayıt etmek için kullandığımız SQL kodumuz.

```
{
"name": "string",
"phone": "string",
"mail": "string",
"address": "string",
"city": "string"
}

```

* **11 NUMARALI SORGU** Hayvan sahipleri isme göre filtreleniyor mu?

![getanimalsbycostumerid.png](images%2Fgetanimalsbycostumerid.png)

**İşlem sonrası response kısmı**

```
[
{
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
{
"id": 7,
"name": "Bızdık",
"species": "cat",
"breed": "sarman",
"gender": "erkek",
"color": "beyaz ve sarı",
"dateofBirth": "2024-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
}
]
```

* **12.DEĞERLENDİRME FORMU**  Proje isterlerine göre hayvan kaydediliyor mu?


* Save Metotu için çağıralacak link

```
http://localhost:8080/v1/animals/save
```

![responsebody.png](images%2Fresponsebody.png)
![save+response.png](images%2Fsave%2Bresponse.png)

* **13.DEĞERLENDİRME FORMU**  Hayvanlar isme göre filtreleniyor mu?
*

```
http://localhost:8080/v1/animals/getFilteredAnimalByName/mia
```

![animalfiltersearch.png](images%2Fanimalfiltersearch.png)
![animalfiltername.png](images%2Fanimalfiltername.png)

* **14.DEĞERLENDİRME FORMU**  Girilen hayvan sahibinin sistemde kayıtlı tüm hayvanlarını görüntüleme
  (sadece bir kişiye ait hayvanları görüntüle işlemi) başarılı bir şekilde çalışıyor mu?

```
http://localhost:8080/v1/animals/getAnimalsByCustomerId/3
```

```
[
{
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
{
"id": 7,
"name": "Bızdık",
"species": "cat",
"breed": "sarman",
"gender": "erkek",
"color": "beyaz ve sarı",
"dateofBirth": "2024-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
}
]
```

* **15.DEĞERLENDİRME FORMU**  Proje isterlerine göre doktor kaydediliyor mu?
*

```
http://localhost:8080/v1/doctors/save
```

```
{
"name": "Ali BARAN",
"phone": "533 369 333 333",
"mail": "alibaran@vet.com",
"address": "kocasinan",
"city": "Kayseri"
}
```

```
	
Response body

{
  "id": 4,
  "name": "Ali BARAN",
  "phone": "533 369 333 333",
  "mail": "alibaran@vet.com",
  "address": "kocasinan",
  "city": "Kayseri"
}
```

* **16.DEĞERLENDİRME FORMU**  Proje isterlerine göre doktor müsait günü kaydediliyor mu?

```
http://localhost:8080/v1/availabledates/save
```
SQL GİRDİSİ İÇİN
```
{

"availableDateDate": "2024-03-03",
"doctor": {
"id": 1
}
}
```

```
{
  "id": 4,
  "appointmentDate": "2024-03-03T10:00:00",
  "animal": {
    "id": 2,
    "name": null,
    "species": null,
    "breed": null,
    "gender": null,
    "color": null,
    "dateofBirth": null,
    "customer": null
  },
  "doctor": {
    "id": 1,
    "name": null,
    "phone": null,
    "mail": null,
    "address": null,
    "city": null
  }
}
```

* **17.DEĞERLENDİRME FORMU**  Proje isterlerine göre randevu kaydediliyor mu?

```
http://localhost:8080/v1/appointments/save
```
SQL GİRDİSİ İÇİN
```
{
"appointmentDate": "2024-03-03T10:00:00",
"animal": {
"id": 2
},
"customer": {
"id":3

    },

"doctor": {
"id": 1

    }
}
```

```
{
  "id": 4,
  "appointmentDate": "2024-03-03T10:00:00",
  "animal": {
    "id": 2,
    "name": null,
    "species": null,
    "breed": null,
    "gender": null,
    "color": null,
    "dateofBirth": null,
    "customer": null
  },
  "doctor": {
    "id": 1,
    "name": null,
    "phone": null,
    "mail": null,
    "address": null,
    "city": null
  }
}
```

* **18.DEĞERLENDİRME FORMU** Randevu oluşturulurken, doktorun o saatte başka bir randevusu var mı, 
doktorun müsait günü var mı  kontrolü yapılıyor mu? Sadece randevusu yoksa ve müsait günü varsa randevu kaydına izin veriyor mu?


* **19. DEĞERLENDİRME FORMU** Randevular kullanıcı tarafından girilen tarih 
aralığına ve hayvana göre filtreleniyor mu?

![appointmentfilterbyanimal.png](images%2Fappointmentfilterbyanimal.png)

RESPONSE KISMI

```
http://localhost:8080/v1/appointments/filterbyAnimal?animal_id=2&startDate=2024-01-01T12%3A00%3A00&endDate=2024-09-09T12%3A00%3A00
```

```
[
{
"id": 1,
"appointmentDate": "2024-03-03T19:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
},
{
"id": 2,
"appointmentDate": "2024-03-03T20:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
},
{
"id": 3,
"appointmentDate": "2024-03-03T21:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
},
{
"id": 4,
"appointmentDate": "2024-03-03T10:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
}
]
```

* **20.DEĞERLENDİRME FORMU** Randevular kullanıcı tarafından girilen tarih aralığına ve doktora göre filtreleniyor mu?

```
http://localhost:8080/v1/appointments/filterbyDoctor?doctor_id=1&startDate=2024-01-01T12%3A00%3A00&endDate=2024-12-12T12%3A00%3A00
```
![filterbydoctor.png](images%2Ffilterbydoctor.png)

RESPONSE KISMI
```
[
{
"id": 1,
"appointmentDate": "2024-03-03T19:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
},
{
"id": 2,
"appointmentDate": "2024-03-03T20:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
},
{
"id": 3,
"appointmentDate": "2024-03-03T21:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
},
{
"id": 4,
"appointmentDate": "2024-03-03T10:00:00",
"animal": {
"id": 2,
"name": "mia",
"species": "cat",
"breed": "calicos",
"gender": "female",
"color": "threecolor",
"dateofBirth": "2015-06-06",
"customer": {
"id": 3,
"name": "Ömer Faruk Baran",
"phone": "0506 1316 706",
"mail": "omerfarukbaran@patika.dev",
"address": "Kocasinan",
"city": "Kayseri"
}
},
"doctor": {
"id": 1,
"name": "Ali Rıza Şimşek",
"phone": "54654654132",
"mail": "ali@patika.dev",
"address": "patika",
"city": "İstanbul"
}
}
]
```

* **21.22.23.24.25.26.27. DEĞERLENDİRME FORMU**
  ![vaccine.png](images%2Fvaccine.png)

