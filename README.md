spring-cloud-example
====================
Example of small distributed system, which is built with Netflix OSS and Spring Cloud.

This example covers:
* service discovery Eureka
* load balancing using Ribbon
* circuit breaker Hystrix
* reactive programming with RxJava 

Architecture
----

![screen](https://cloud.githubusercontent.com/assets/15219684/12378679/0b3a96e8-bd46-11e5-8268-45e40435e51d.jpg)

##### book-catalog
Provide catalog of books with basic information (title and discription).

##### book-review
This service provides reviews of books.

##### book-gateway
This is api gateway which integrate microservices and expose book details via a REST API.

In the feature
----
Built each service and deployed using Docker. End-to-end integration testing should be done on a developer's machine using Docker compose.
