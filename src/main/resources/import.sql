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
