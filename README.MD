*Pre-Requisities:*

1. Java 8 [Set Environment parameters]
2. Latest Maven
3. Mysql



*Configuring MYSQL:*

1. Install MYSQL with "root" user having "root" password or update "spring.datasource.username" and "spring.datasource.password" inside "application.properties" inside "src/main/resources".
2. Run "Items.sql" and then "orders.sql" from "src/main/resources" to create database, tables and sample dummy data.
		


*Create and run Executable Jar:*

1. Open commandline 
2. Navigate to base directory of project, where "POM.xml" file is present.
3. Execute "mvn  package"
4. After successful execution, navigate to "target" folder in base directory.
5. Run the jar file using "java -jar <Jar-filename>"



*Using Application:*

Web Application will be hosted on "http://localhosted:8080/<endpoints_URI>"

Rest API's exposed for items:

URI|request|response|description
---|---|---|---
/api/items|GET|200, [{"id":1,"name":"surf excel","quantity":100},{"id":2,"name":"Rim","quantity":30},{"id":3,"name":"Frooti","quantity":70}]| Get all items  with product id, product name and quantity
/api/items/{itemId}|GET |200, {"id":1,"name":"surf excel","quantity":99}| Get single item basis of item id with product id, product name and quantity
/api/items|POST, {"id": 1,"name": "lifeboy","quantity": 60}|200,{"id": 4,"name": "lifeboy","quantity": 60}| Insert new entry in DB with ID being auto increamented
/api/items|PUT, {"id": 4,"name": "lifeboy","quantity": 50} |200, {"id": 4,"name": "lifeboy","quantity": 50}| Update an item on basis of Id
/api/items/{itemId}|DELETE|200, Deleted Item Id - 4| Delete an item on basis of item Id



Rest API's exposed for Cart:

URI|request|response|description
---|---|---|---
/cart/orders|POST, (value="email")[x-www-form-urlencode]|200,[ { "id": 1, "item_id": 2, "email": "utk1@gmail.com", "quantity": 50, "orderId": "ORD151000000", "confirmation": "Order Successful" }, { "id": 3, "item_id": 1, "email": "utk1@gmail.com", "quantity": 100, "orderId": "ord1571130342045", "confirmation": "Successfully added to cart" }, { "id": 4, "item_id": 2, "email": "utk1@gmail.com", "quantity": 50, "orderId": "ord1571130342045", "confirmation": "Successfully added to cart" }]| Get all order details in cart on basis of email ID
/cart/save|POST, (value="email", value="item_ids")[x-www-form-urlencode] |200, Confirmation Message| Add new items in cart, if the items are available
/cart/clean|DELETE|200, Clean Successful| Delete all entries with order IDs  null.

Note:
value="item_ids" : Single/multiple Json data with item_ids and corresponding quantity.  {"1":"100","2":"50","3":"30"}
Confirmation Message: 
- If some of the selected items are available then following message comes  in response: "Some of the items are added to cart with order ID - ord1571131198023. Other items are either insufficient or out of stock"
- If all the selected items are available then following message comes in response : "All Items added to cart successfully with order ID - ord1571131198023"
- If none of the selected items are available then following message comes in response : "No items are added to cart. Items are either insufficient or out of stock"



