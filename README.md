# BE-take-home-test
take home test Backend Engineer

## requirement 
1. minimum java 17
2. postgresql 14 keatas
3. maven 3.8.x
4. IDE editor eclipse/intellij
5. curl 

## running application
1. create db *demo* in postgres with user *postgres* and password *postgres*
2. import sql *demo.sql* on the database *demo*
3. setup java home and maven
4. run with following command :
    <pre>./mvn springboot:run</pre>


## build application
run with following command :
<pre>./mvn clean package </pre>


## test application
- list product test 
  <pre>
    curl --request GET \
    --url http://localhost:8080/product \
    --header 'Content-Type: application/json'
    </pre>
- find product by id test
    <pre>
    curl --request GET \
  --url http://localhost:8080/product/2
  </pre>
-- add product test
   <pre>
    curl --request POST \
  --url http://localhost:8080/product/add \
  --header 'Content-Type: application/json' \
  --data '{
  "sku": "ELEK-KOM-00005",
  "title" : "SSD PORTABLE CRUCIAL X6 4TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "description" : "SSD PORTABLE CRUCIAL X6 4TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "category" : "Media Simpan Data",
  "etalase" : "Komputer dan Laptop", 
  "images" : "/images/elektronic/ssd_portable_3tb.png",
  "weight" : "60 gram",
  "price" : 60000.00
}'
    </pre>

- update product test
  <pre>
    curl --request POST \
  --url http://localhost:8080/product/save/2 \
  --header 'Content-Type: application/json' \
  --data '{
  "title" : "SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "description" : "SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "category" : "Media Simpan Data",
  "etalase" : "Komputer dan Laptop", 
  "images" : "/images/elektronic/ssd_portable_1tb.png",
  "weight" : "50 gram",
  "price" : 18000.00
    }'
  </pre>
- search product by criteria test
    <pre>
    curl --request GET \
  --url 'http://localhost:8080/product/search/category?value=media' \
  --header 'Content-Type: application/json' \
  --data '{
  "title" : "SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "description" : "SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "category" : "Media Simpan Data",
  "etalase" : "Komputer dan Laptop", 
  "images" : "/images/elektronic/ssd_portable_1tb.png",
  "weight" : "50 gram",
  "price" : 18000.00
    }'
  </pre>

- search product by rating test
    <pre>
    curl --request GET \
  --url 'http://localhost:8080/product/rating/high?value=media' \
  --header 'Content-Type: application/json' \
  --data '{
  "title" : "SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "description" : "SSD PORTABLE CRUCIAL X6 1TB USB C SSD EXTERNAL MOBILE ORIGINAL",
  "category" : "Media Simpan Data",
  "etalase" : "Komputer dan Laptop", 
  "images" : "/images/elektronic/ssd_portable_1tb.png",
  "weight" : "50 gram",
  "price" : 18000.00
    }'
  </pre>
- list product review test
    <pre>
    curl --request GET \
  --url http://localhost:8080/review
  </pre>

- find product review by id test
    <pre>
    curl --request GET \
  --url http://localhost:8080/review/1
  </pre>
  
- add product review test test
    <pre>
    curl --request POST \
  --url http://localhost:8080/review/add \
  --header 'Content-Type: application/json' \
  --data '{
  "productid" : 2,
  "rating" : 1.1,
  "reviews_comment" : "seller tidak responsif, jangan di pesan lagi barangny"
    }'
  </pre>
