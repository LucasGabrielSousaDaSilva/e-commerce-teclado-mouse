insert into construcao (peso, comprimento, revestimento, cor) values(2.45, 3.2,'Polinesio', 'Preto');
insert into construcao (peso, comprimento, revestimento, cor) values(2.45, 3.2,'Polinesio', 'Azul');
insert into construcao (peso, comprimento, revestimento, cor) values(2.45, 3.2,'Polinesio', 'Verde');

insert into formato (comprimento, largura) values(3.4, 2.4);
insert into formato (comprimento, largura) values(5.3, 3.1);
insert into formato (comprimento, largura) values(2.6, 4.2);

insert into marca (nome, empresa) values('Speed', 'Vintage');
insert into marca (nome, empresa) values('Robot', 'Alien');

insert into modelo (nome, serie) values('Paliin', '78821');
insert into modelo (nome, serie) values('Alien', '25410');
insert into modelo (nome, serie) values('Motor', '93551');

insert into produto (nome, modelo, descricao, valor, quantidade, id_marca, conexao) values('dragon', 'Vintage', 'top', 52.10, 5, 1, 1);
insert into produto (nome, modelo, descricao, valor, quantidade, id_marca, conexao) values('dagon', 'mariato', 'bom', 30.2, 4, 2, 1);

insert into mouse (id, iluminacao, botao, made, pegada, id_construcao) values(1, 'RGB', '2 botões', 'tailandia', 2, 1);
insert into mouse (id, iluminacao, botao, made, pegada, id_construcao) values(2, 'RGB', '2 botões', 'tailandia', 2, 1);

insert into sensor (nome, dpi, ips, id_modelo, id_formato, id_mouse) values('Speed', 16000.0, 7000.0, 1, 1, 1);
insert into sensor (nome, dpi, ips, id_modelo, id_formato, id_mouse) values('Snow', 6000.0, 5400.0, 2, 2, 1);
insert into sensor (nome, dpi, ips, id_modelo, id_formato, id_mouse) values('Slow', 8000.0, 600.0, 2, 2, 1);

insert into teclado (id, layout, design, tipoTeclado, iluminacao, id_construcao) values(1, 'ABNT2', 'Carcaça alta', '60% com numerico', 'RGB', 1);
insert into teclado (id, layout, design, tipoTeclado, iluminacao, id_construcao) values(2, 'ABNT2', 'Carcaça alta', '60% com numerico', 'RGB', 1);


-- Pessoas

insert into usuario(username, senha) values ('Lucas', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjMiLCJuYW1lIjoiTHVjYXMiLCJpYXQiOjE1MTYyMzkwMjJ9.rhXZeFSvavRfJN_zDauRpsOKpiPcxab-DFlrIBph8Bc');
insert into usuario(username, senha) values ('Gabriel', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI0NTYiLCJuYW1lIjoiR2FicmllbCIsImlhdCI6MTUxNjIzOTAyMn0.J-jIgzgF4bqLgyExvXme98hUzBzAVml68How6IxFxz8');

insert into pessoa (nome, idade, email, id_usuario) values('Lucas', 18, 'teste@teste', 1);
insert into pessoa (nome, idade, email, id_usuario) values('Gabriel', 20, 'teste@teste', 2);

insert into cliente(endereço, id_Pessoa) values ('Rua ali pra la', 2);

insert into funcionario(cargo, salario, id_Pessoa) values('Estocador', 1200.00, 1);


-- Pedido

insert into formaPagamento(parcela, dataPagamento, tipoPagamento) values(2, '2024-05-30T09:00:51', 2);

insert into pedido(valorTotal, data, statusPagamento, statusPedido, id_formaPagamento, id_cliente) values(504.57, '2024-05-30', 2, 3, 1, 1);

insert into itemPedido(valor, quantidade, desconto, id_produto, id_pedido) values(58.69, 1, 23.27, 1, 1);
