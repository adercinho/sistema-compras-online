insert into CLIENTE (nome, endereco, telefone) values ('Adercio Reinan', 'Rua gonçalves', '11985022548')
insert into CLIENTE (nome, endereco, telefone) values ('Fernando Santana', 'Avenida Gomes', '11856325545')

insert into PRODUTO (descricao, estoque, preco) values ('Coca Cola 2L', 5, 80)
insert into PRODUTO (descricao, estoque, preco) values ('Kuat 2L', 4, 120)

insert into RESERVA (data, atendente, situacao, valor, ID_CLIENTE) values ('2015-09-09 00:00:00', 'Gustavo Matos', 0, 250, 1)
insert into RESERVA (data, atendente, situacao, valor, ID_CLIENTE) values ('2015-09-10 00:00:00', 'Humberto Macedo', 0, 500, 2)

insert into COMPRA (data, responsavel, situacao, valor, ID_RESERVA) values ('2015-09-09 00:00:00', 'Jhonatas Santana', 0, 250, 1)
insert into COMPRA (data, responsavel, situacao, valor, ID_RESERVA) values ('2015-09-10 00:00:00', 'Jhonatas Santana', 0, 500, 2)