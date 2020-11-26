Microsserviço de pedidos construído com Nest.js Framework + React.js + RabbitMQ

## Rodar a aplicação

#### Antes de começar


```bash
$ docker-compose up
```

#### Accesse no browser

```
http://localhost:3000
```
docker exec -it ecedfca7ae38 mysql -uroot -p

docker container exec -it 941e03aa64cd /bin/bash

Para resolução do problema iremos utilizar um sistema de delivery em que um microsserviço denominado “Order” será usado para criar a ordem de serviço da entrega. Essa ordem será publicada em uma fila no serviço de Message Broker RabbitMQ, utilizando o protocolo AMQP, que estará implementado em outro microsserviço.