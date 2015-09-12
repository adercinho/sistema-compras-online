Sistema Compras Online
==================

Tecnologias e Frameworks utilizados.

* Java 1.7
* Spring Boot 1.2.5
* Vaadin 7.5.5
* Maven 3
* Webservices(Jax-WS/RS)

Como Usar
-----
```bash

$ git clone git@github.com:adercinho/sistema-compras-online.git
$ cd sistema-compras-online/compras-frontend
$ mvn clean install
```

Subindo serviços JAX-REST
------
```bash

$ cd sistema-compras-online/compras-backend/compras-service-rs
$ mvn spring-boot:run
```

Subindo serviços JAX-WS
------
```bash

$ cd sistema-compras-online/compras-backend/compras-service-ws
$ mvn spring-boot:run
```

Subindo a aplicação
------
```bash

$ cd sistema-compras-online/compras-frontend
$ mvn jetty:run
```

Acesso ao aplicação:
------
[http://localhost:8080/compras-frontend/](http://localhost:8080/compras-frontend/) <br>


Localizalção REST:
---------

[http://localhost:8081/rs/cliente](http://localhost:8081/rs/cliente) <br>
[http://localhost:8081/rs/produto](http://localhost:8081/rs/produto) <br>
[http://localhost:8081/rs/reserva](http://localhost:8081/rs/reserva) <br>
[http://localhost:8081/rs/compra](http://localhost:8081/rs/compra) <br>


Localizalção WSDL:
---------
[http://localhost:8082/ws/cliente.wsdl](http://localhost:8082/ws/cliente.wsdl) <br>
[http://localhost:8082/ws/produto.wsdl](http://localhost:8082/ws/produto.wsdl) <br>
[http://localhost:8082/ws/reserva.wsdl](http://localhost:8082/ws/reserva.wsdl) <br>
[http://localhost:8082/ws/compra.wsdl](http://localhost:8082/ws/compra.wsdl) <br>



