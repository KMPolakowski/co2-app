
# API Spec

`GET /api/v1/districts/{districtName}/measurements`

`POST /api/v1/districts/{districtName}/measurements`
`BODY {
    "value": {value} (dobule),
    "createdAt": "{timestamp}" (string)
}`

# Curl Examples

## POST Measurement
`` curl --header "Content-Type: application/json" 
--request POST --data '{"value":131.99,"createdAt":"2022-01-19T19:46:30.655+00:00"}' 
-u vienna:schnitzel http://localhost:8080/api/v1/districts/innenstadt/measurements``

## GET Measurement

`` curl --header "Content-Type: application/json"
-u vienna:schnitzel http://localhost:8080/api/v1/districts/innenstadt/measurements``

# BASIC AUTHS that can be used

 * vienna:schnitzel
 * barcelona:burito
 * munich:frankfurter

# Service is publicly reachable at http://104.154.154.120

# HOW TO DEPLOY LOCALLY (PORT 8080)

``./mvnw spring-boot:run``

