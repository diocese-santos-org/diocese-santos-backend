insert into endereco (cep, complemento, endereco, numero) values ('454787', 'Casa', 'Rua 1', '1');
insert into endereco (cep, complemento, endereco, numero) values ('3121', 'Casa 2', 'Rua 2', '12');

insert into endereco (cep, complemento, endereco, numero) values ('51312', 'Casa 3', 'Rua 3', '14');

insert into concessionaria (cnpj, dt_criacao, email, endereco_id, nome_fantasia, telefone) values ('23.831.876/0021-31', '2023-08-03T12:35:19.496233', 'con1@gmail.com', 1, 'Concessionaria 1', '4123123')

    insert into concessionaria (cnpj, dt_criacao, email, endereco_id, nome_fantasia, telefone) values ('04.831.876/0001-38', '2023-08-03T12:35:19.496233', 'con2@gmail.com', 2, 'Concessionaria 2', '4586778645')


insert into concessionaria (cnpj, dt_criacao, email, endereco_id, nome_fantasia, telefone) values ('04.831.876/0021-38', '2023-08-03T12:35:19.496233', 'con3@gmail.com', 2, 'Concessionaria 3', '41231221312')


insert into usuario (cnh, concessionaria_id, cpf, email, endereco_id, nome, senha, telefone) values ('423443',
    1, '23423', 'Paulo@gmail.com', 3, 'Paulo 1', '$2a$10$VaQvHpgu67VTl0zAnUgN5e0IjWOuP4lv5UbFe1MrTd/qhfd08RGiS','312');

insert into usuario (cnh, concessionaria_id, cpf, email, endereco_id, nome, senha, telefone) values ('312312',
                                                                                                     2, '5412321', 'leo1@gmail.com', 2, 'Leonardo 1', '$2a$10$VaQvHpgu67VTl0zAnUgN5e0IjWOuP4lv5UbFe1MrTd/qhfd08RGiS','312312');

insert into usuario (cnh, concessionaria_id, cpf, email, endereco_id, nome, senha, telefone) values ('5123123123',
                                                                                                     3, '4123123', 'joao1@gmail.com', 1, 'Joao 1', '$2a$10$VaQvHpgu67VTl0zAnUgN5e0IjWOuP4lv5UbFe1MrTd/qhfd08RGiS','4123123');