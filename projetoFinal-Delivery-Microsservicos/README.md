## Passos para rodar os microsserviços:

Primeiramente é necessário ter o docker funcionando, o nodeJS e o GO Language instalado na máquina

### Micro-serviço mapping:
Rodar o comando tanto na pasta backend quanto frontend
```bash
npm install
```

```bash
dos2unix .backend\.docker\entrypoint.sh
```

no arquivo frontend\env.example:
renomear o arquivo de env.example para apenas .env e colocar a API Key do seu My Maps.

Rodar com:
```bash
docker-compose up
```

### Micro-serviço order:
Rodar o comando tanto na pasta backend quanto frontend
```bash
npm install
```

```bash
dos2unix .docker\entrypoint.sh
```

no arquivo frontend\env.example:
renomear o arquivo de env.example e colocar o endereço de IP do seu docker ou máquina se não der certo

Rodar com:
```bash
docker-compose up
```

### Micro-serviço RabbitMQ:
Rodar com:
```bash
docker-compose up
```

### Micro-serviço Simulador:
Para gerar um executável .exe do Go e fazer deploy desse microsserviço pelo executável, rodar o comando:
```bash
go build simulator.go
```
A partir do executável gerado basta somente abri-lo.

Para rodar pelo terminal mesmo, rodar o comando:
```bash
go run simulator.go
```

### Micro-serviço Usuario:
Instalar as dependencias do NestJS:
```bash
npm install
```

Rodar com:
```bash
docker-compose up
```


### Qualquer duvida basta acessar o link para rodar os microsserviços:
https://www.youtube.com/watch?v=MRk2Y_h2F-Q

### Observação:
Lembrando que na maratona em que o video do youtube passa nós excluímos do projeto o microsserviço de drivers e alocamos junto a Orders. 
E adicionado um novo microsserviço de users, além de que a aplicação em Order foi extendida, com mais telas e cruds.
Outro ponto é que obviamente deve estar executando todos os micro-serviços nos terminais simultaneamente para que a aplicação esteja 100% funcional

### Segue os links do projeto e documentação completo:
https://wetransfer.com/downloads/35743526dc80011362919ce1835cb3b520201126021906/1c0d53

### Segue o link da maratona:
https://drive.google.com/file/d/1a280LMgLeO26XsmlvK9kl-tm_BLH7LBC/view?usp=sharing
