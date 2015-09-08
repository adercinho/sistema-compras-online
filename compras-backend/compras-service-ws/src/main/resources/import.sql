insert into CLIENTE (nome, endereco, telefone) values ('Adercio Reinan', 'Rua gonçalves', '11985022548')
insert into CLIENTE (nome, endereco, telefone) values ('Fernando Santana', 'Avenida Gomes', '11856325545')
insert into CLIENTE (nome, endereco, telefone) values ('Marcos Luis', 'Rua da Pedra', '11458452354')
insert into CLIENTE (nome, endereco, telefone) values ('Augusto Santos', 'Avenida Paulista', '1184588457')

insert into PRODUTO (descricao, estoque, preco) values ('Coca Cola 2L', 5, 80)
insert into PRODUTO (descricao, estoque, preco) values ('Kuat 2L', 4, 120)
insert into PRODUTO (descricao, estoque, preco) values ('Bicicleta monark azul', 10, 1250)
insert into PRODUTO (descricao, estoque, preco) values ('Geladeira 800L preta', 8, 3500)

insert into RESERVA (data, atendente, situacao, valor, ID_CLIENTE) values ('2015-09-09 00:00:00', 'Gustavo Matos', 0, 250, 1)
insert into RESERVA (data, atendente, situacao, valor, ID_CLIENTE) values ('2015-09-10 00:00:00', 'Humberto Macedo', 0, 500, 2)
insert into RESERVA (data, atendente, situacao, valor, ID_CLIENTE) values ('2015-09-10 00:00:00', 'Fernando Hugo', 0, 501, 1)
insert into RESERVA (data, atendente, situacao, valor, ID_CLIENTE) values ('2015-09-10 00:00:00', 'Fernando Hugo', 0, 550, 2)

insert into COMPRA (data, responsavel, situacao, valor, ID_RESERVA) values ('2015-09-09 00:00:00', 'Jhonatas Santana', 0, 250, 1)
insert into COMPRA (data, responsavel, situacao, valor, ID_RESERVA) values ('2015-09-10 00:00:00', 'Jhonatas Santana', 0, 500, 2)
insert into COMPRA (data, responsavel, situacao, valor, ID_RESERVA) values ('2015-09-10 00:00:00', 'Jhonatas Santana', 0, 501, 3)
insert into COMPRA (data, responsavel, situacao, valor, ID_RESERVA) values ('2015-09-10 00:00:00', 'Jhonatas Santana', 0, 850, 4)