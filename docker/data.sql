create table endereco (id bigint not null auto_increment, cep varchar(255), cidade varchar(255), endereco_completo varchar(255), estado varchar(255), latitude double precision not null, longitude double precision not null, primary key (id)) engine=InnoDB;
create table missa (id bigint not null auto_increment, domingo varchar(255), quarta varchar(255), quinta varchar(255), sabado varchar(255), segunda varchar(255), sexta varchar(255), terca varchar(255), primary key (id)) engine=InnoDB;
create table paroquia (id bigint not null auto_increment, email varchar(255), nome varchar(255), secretaria varchar(255), telefone varchar(255), endereco_id bigint, primary key (id)) engine=InnoDB;
create table perfil (id bigint not null auto_increment, nome varchar(255), primary key (id)) engine=InnoDB;
create table redes_sociais (id bigint not null auto_increment, facebook varchar(255), instagram varchar(255), youtube varchar(255), primary key (id)) engine=InnoDB;
create table usuario (id bigint not null auto_increment, cpf varchar(255), email varchar(255), nome varchar(255), senha varchar(255), telefone varchar(255), primary key (id)) engine=InnoDB;
create table usuario_perfis (usuario_id bigint not null, perfis_id bigint not null) engine=InnoDB;
alter table usuario drop index UK_692bsnqxa8m9fmx7m1yc6hsui;
alter table usuario add constraint UK_692bsnqxa8m9fmx7m1yc6hsui unique (cpf);
alter table usuario drop index UK_5171l57faosmj8myawaucatdw;
alter table usuario add constraint UK_5171l57faosmj8myawaucatdw unique (email);
alter table paroquia add constraint FKllprmoy5n2nqdvhwjvribm3na foreign key (endereco_id) references endereco (id);
alter table usuario_perfis add constraint FK7bhs80brgvo80vhme3u8m6ive foreign key (perfis_id) references perfil (id);
alter table usuario_perfis add constraint FKs91tgiyagbilt959wbufiphgc foreign key (usuario_id) references usuario (id);

INSERT INTO dioceseSantos.endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES (1, '11340340', 'São Vicente', 'Rua 1 - São Vicente/SP', 'SP', -23.947322, -46.391601);
INSERT INTO dioceseSantos.endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES (1, '11349349', 'São Vicente', 'Rua 2 - São Vicente/SP', 'SP', -24.947322, -47.391601);
INSERT INTO dioceseSantos.endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES (1, '11403923', 'São Vicente', 'Rua 3 - São Vicente/SP', 'SP', -24.947322, -45.391601);