Demo spring boot application.

<h2>Run instructions</h2>
1. 'mvn install' in project root folder<br>
2. 'mvn spring-boot:run' in project root folder<br>

By default application will start on port 8080.

<h2>DataBase</h2>
You can find DB console on http://localhost:8080/h2-console/login.jsp <br>
URL: jdbc:h2:mem:logisticDB<br>
user: user<br>
password: <br>

<h2>URLs</h2>
1. add new TransportRequest<br>
curl --location --request POST 'http://localhost:8080/transport_request_with_new_cargo?
cargoName=aszaz&cargoPrice=2&cargoWidth=34&cargoHeight=566&requestComment=lolkek'<br>

2. get all TransportRequestList<br>
curl --location --request GET 'http://localhost:8080/all_transport_requests'<br>

3. get TransportRequest by id<br>
curl --location --request GET 'http://localhost:8080/transport_request_by_id?id=4'<br>

4. remove TransportRequest by id<br>
curl --location --request DELETE 'http://localhost:8080/transport_request_by_id?id=4'<br>
