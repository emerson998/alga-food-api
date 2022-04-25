insert into food.cozinha (nome) values ('Tailandesa');
insert into food.cozinha (nome) values ('Indiana');

insert into food.estado (nome) values ('Minas Gerais');
insert into food.estado (nome) values ('São Paulo');
insert into food.estado (nome) values ('Ceará');

insert into food.cidade (nome, estado_id) values ('Uberlândia', 1);
insert into food.cidade (nome, estado_id) values ('Belo Horizonte', 1);
insert into food.cidade (nome, estado_id) values ('São Paulo', 2);
insert into food.cidade (nome, estado_id) values ('Campinas', 2);
insert into food.cidade (nome, estado_id) values ('Fortaleza', 3);

insert into food.restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values ('Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into food.restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
insert into food.restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp);

insert into food.forma_pagamento (descricao) values ('Cartão de crédito');
insert into food.forma_pagamento (descricao) values ('Cartão de débito');
insert into food.forma_pagamento (descricao) values ('Dinheiro');

insert into food.permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into food.permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into food.restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);