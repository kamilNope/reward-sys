# reward-sys
## Api doc in swagger (works after run app)
http://localhost:8080/swagger-ui/

## Requirements to run
* install java 11 or higher
* install maven 3 or use bundled in IntelliJ
* install CURL or Postman
* download project and move to project directory
* build application in maven ```mvn clean install```
* run application by IntelliJ or by command ```mvn spring-boot:run```

## Test of app
Basic test data is loaded along with application start.

1. Run application
2. Use postman or curl to run scenarios
3. to get reward points total
```
curl -X GET localhost:8080/api/reward-program/1/total-score
```
4. to get reward points for one month
```
curl -X GET localhost:8080/api/reward-program/1/month-score
```
5. to add/update transaction
```
curl -X POST -H "Content-Type: application/json" -d  "{ \"id\": null, \"price\": 120.1, \"customerId\": 1 }"  localhost:8080/api/transactions/add
```
5. to update transaction
```
curl -X PUT -H "Content-Type: application/json" --data "{ \"id\": 10000, \"price\": 100, \"customerId\": 1 }"  localhost:8080/api/transactions/update
```
6. to get error handling
```
curl -X GET localhost:8080/api/reward-program/11/month-score
```
