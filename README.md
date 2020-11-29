# Courier-Tracking

H2 Database kullanılmıstır.

Tarayıcı url : http://localhost:8080/h2-console 

datasource.url : jdbc:h2:mem:migrosDB

datasource.username : migros  

datasource.password : migros

Migros magazaları MIGROS_STORE tablosundadır.

http://localhost:8080/courier urlini kullanarak post atabilirsiniz.(courierId,lng,lat)İstek yaptıktan sonra tracking tablosundan logları kontrol edebilirsiniz.

http://localhost:8080/courier/totalTravelDistance/{courierId} ile kuryelerin toplam mesafelerini goruntuleyebilirsiniz.
