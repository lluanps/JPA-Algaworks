insert into Produto (id, nome, preco, descricao) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into Produto (id, nome, preco, descricao) values (3, 'Celular', 2000.0, 'Inovaçãoe praticidade em um só aparelho');

insert into Cliente (id, nome) values (1, 'Fernando Medeiros');
insert into Cliente (id, nome) values (2, 'Marcos Mariano');

insert into pedido (id, cliente_id, data_pedido, total, status) values (1, 1, CURRENT_TIMESTAMP, 100.0, 'AGUARDANDO');

insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2);