DROP DATABASE IF EXISTS dioceseSantos;

CREATE DATABASE dioceseSantos;

ALTER DATABASE dioceseSantos DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use dioceseSantos;

create table clero
(
    id       bigint auto_increment
        primary key,
    nome     varchar(255) null,
    url_site varchar(255) null
);

create table aviso
(
    id        bigint auto_increment
        primary key,
    descricao varchar(255) null,
    titulo    varchar(255) null
);

create table endereco
(
    id                bigint auto_increment
        primary key,
    cep               varchar(255) null,
    cidade            varchar(255) null,
    endereco_completo varchar(255) null,
    estado            varchar(255) null,
    latitude          double       not null,
    longitude         double       not null
);

create table evento
(
    id        bigint auto_increment
        primary key,
    data      date         null,
    descricao varchar(255) null,
    horario   varchar(255) null,
    local     varchar(255) null,
    titulo    varchar(255) null
);

create table missa
(
    id      bigint auto_increment
        primary key,
    domingo varchar(255) null,
    quarta  varchar(255) null,
    quinta  varchar(255) null,
    sabado  varchar(255) null,
    segunda varchar(255) null,
    sexta   varchar(255) null,
    terca   varchar(255) null
);

create table redes_sociais
(
    id        bigint auto_increment
        primary key,
    facebook  varchar(255) null,
    instagram varchar(255) null,
    youtube   varchar(255) null
);

create table paroquia
(
    id               bigint auto_increment
        primary key,
    email            varchar(255) null,
    nome             varchar(255) null,
    secretaria       varchar(255) null,
    telefone         varchar(255) null,
    url_site         varchar(255) null,
    endereco_id      bigint       null,
    missas_id        bigint       null,
    redes_sociais_id bigint       null,
    constraint FK76i9s6oa2xi9jhgauhyeaw7n0
        foreign key (missas_id) references missa (id),
    constraint FKjmihw5e2ex8k71n4wyolsem2e
        foreign key (redes_sociais_id) references redes_sociais (id),
    constraint FKllprmoy5n2nqdvhwjvribm3na
        foreign key (endereco_id) references endereco (id)
);

create table paroquias_cleros
(
    paroquia_id bigint not null,
    clero_id    bigint not null,
    constraint FKev0k08j5vq8mqq0x42pjxd4h8
        foreign key (paroquia_id) references paroquia (id),
    constraint FKpb59l8wi5rji2ueaqbnrk650d
        foreign key (clero_id) references clero (id)
);


use dioceseSantos;

INSERT INTO clero (id, nome, url_site) VALUES ('1', 'Frei Paulo Henrique Romero, OFMCap - Pároco', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('2', 'Frei Ernani de Paula, OFMCap  ', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('3', 'Frei Sérgio de Araújo, OFMCap', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('4', 'Padre Claudenil Moraes da Silva - Pároco', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('5', 'Padre Ronaldo Gueiros Bezerra ', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('6', 'Diácono Avelino Nunes da Mota', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('7', 'Frei Lino de Oliveira, OC - Reitor', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('8', 'Padre Sebastiano Nunzio Antonio Franciulli, CMF - Pároco', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('9', 'Padre Almir Roberto Borges, CMF', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('10', 'Diácono Alexandre Ornelas Forganes', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('11', 'Padre Dr. Caetano Rizzi - Pároco', 'NULL');
INSERT INTO clero (id, nome, url_site) VALUES ('12', 'Diácono Fabiano Piqui Souza', 'NULL');

INSERT INTO endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES ('1', '11045-400', 'Santos', 'Av. Bartolomeu de Gusmão, 32 - Embaré', 'São Paulo', '-23.974304', '-46.320092');
INSERT INTO endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES ('2', '11013-190', 'Santos', 'Praça Patriarca José Bonifácio, s/nº', 'São Paulo', '-23.936799', '-46.324580');
INSERT INTO endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES ('3', '11010-040', 'Santos', ' Praça Barão do Rio Branco, 16, Centro', 'São Paulo', '-23.932926', '-46.327177');
INSERT INTO endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES ('4', '11060-000', 'Santos', 'Av. Ana Costa, 74, Vila Mathias', 'São Paulo', '-23.947122', '-46.330646');
INSERT INTO endereco (id, cep, cidade, endereco_completo, estado, latitude, longitude) VALUES ('5', '11013-553', 'Santos', 'Av. Rangel Pestana, 397, Jabaquara', 'São Paulo', '-23.942083 ', '-46.339401');

INSERT INTO missa (id, domingo, quarta, quinta, sabado, segunda, sexta, terca) VALUES ('1', '8h, 9h30, 11h, 18h e 19h30', '7h e 19h30', '7h e 19h30', '7h e 20h', '7h', '7h', '7h, 9h, 16h e 19h30');
INSERT INTO missa (id, domingo, quarta, quinta, sabado, segunda, sexta, terca) VALUES ('2', '9h e 18h', '17h00', '17h00', '9h e 18h', '17h00', '17h00', 'NULL');
INSERT INTO missa (id, domingo, quarta, quinta, sabado, segunda, sexta, terca) VALUES ('3', '8h, 11h, 18hs', '7h30, 12h30 e 18h', '7h30, 12h30 e 18h', '7h30 e 17h', '7h30, 12h30 e 18h', '7h30, 12h30 e 18h', '7h30, 12h30 e 18h');
INSERT INTO missa (id, domingo, quarta, quinta, sabado, segunda, sexta, terca) VALUES ('4', '7h30, 9h, 17h e 19h', 'NULL', '16h', '16h', '7h30, 19h', 'NULL', '18h30');
INSERT INTO missa (id, domingo, quarta, quinta, sabado, segunda, sexta, terca) VALUES ('5', '8h e 18h30', 'NULL', 'NULL', '18h30', 'NULL', 'NULL', '18h30');

INSERT INTO redes_sociais (id, facebook, instagram, youtube) VALUES ('1', 'https://www.facebook.com/basilicaembare', 'NULL', 'NULL');
INSERT INTO redes_sociais (id, facebook, instagram, youtube) VALUES ('2', 'https://www.facebook.com/Catedraldiocesedesantos', 'NULL', 'NULL');
INSERT INTO redes_sociais (id, facebook, instagram, youtube) VALUES ('3', 'https://www.facebook.com/conventodocarmodesantos', 'NULL', 'NULL');
INSERT INTO redes_sociais (id, facebook, instagram, youtube) VALUES ('4', 'https://www.facebook.com/coracaodemaria/', 'NULL', 'NULL');
INSERT INTO redes_sociais (id, facebook, instagram, youtube) VALUES ('5', 'https://www.facebook.com/parjesuscrucificado', 'NULL', 'NULL');

INSERT INTO paroquia (id, redes_sociais_id, missas_id, endereco_id, nome, secretaria, email, telefone, url_site) VALUES ('1', '1', '1', '1', 'Basílica Menor de Santo Antônio do Embaré', 'Segunda a Sexta-Feira: 8h às 11h30, 13h às 16h30
Sábado: 8h às 11h30', 'sec.paroquial@bsaembare.com.br', '(13) 3227-5977 - 99118-0719', 'NULL');
INSERT INTO paroquia (id, redes_sociais_id, missas_id, endereco_id, nome, secretaria, email, telefone, url_site) VALUES ('2', '2', '2', '2', 'Catedral - Nossa Senhora do Rosário', 'NULL', 'catedraldesantos@gmail.com', '(13) 3224-1593 - 3232-4593', 'NULL');
INSERT INTO paroquia (id, redes_sociais_id, missas_id, endereco_id, nome, secretaria, email, telefone, url_site) VALUES ('3', '3', '3', '3', 'CONVENTO NOSSA SENHORA DO CARMO', 'Segunda a Sexta-Feira: 8h às 16h
', 'provincia-santos@uol.com.br', '(13)3234-5566', 'NULL');
INSERT INTO paroquia (id, redes_sociais_id, missas_id, endereco_id, nome, secretaria, email, telefone, url_site) VALUES ('4', '4', '4', '4', 'PARÓQUIA IMACULADO CORAÇÃO DE MARIA', 'Segunda, quarta, quinta e sexta-feira: 9h às 18h', 'secretaria@coracaodemaria.org.br', '(13)3223-7381 - (13) 3224-8302', 'www.coracaodemaria.org.br');
INSERT INTO paroquia (id, redes_sociais_id, missas_id, endereco_id, nome, secretaria, email, telefone, url_site) VALUES ('5', '5', '5', '5', 'PARÓQUIA JESUS CRUCIFICADO', 'Terça-Feira a Sábado: 14h30 às 18h30', 'parjesus@uol.com.br', '(13)3223-2338', 'NULL');

INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('1', '1');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('2', '1');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('3', '1');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('4', '2');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('5', '2');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('6', '2');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('7', '3');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('8', '4');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('9', '4');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('10', '4');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('11', '5');
INSERT INTO paroquias_cleros (clero_id, paroquia_id) VALUES ('12', '5');


INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-01-10', 'Aula inaugural de Dança', '14:00', 'Sala de Dança', 'Aula de Dança: Novos Passos');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-02-05', 'Conferência sobre Meio Ambiente', '09:00', 'Centro Comunitário', 'Conferência: Preservação Ambiental');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-03-20', 'Feira de Empreendedorismo', '11:00', 'Espaço de Convivência', 'Feira de Ideias Empreendedoras');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-04-12', 'Concerto Beneficente', '19:30', 'Teatro Municipal', 'Concerto em Benefício da Comunidade');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-05-18', 'Simpósio de Saúde Mental', '08:30', 'Centro de Convenções', 'Simpósio: Bem-Estar Mental');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-06-30', 'Festa Junina', '17:00', 'Área Externa', 'Arraiá Beneficente');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-07-22', 'Curso de Artesanato', '14:00', 'Sala de Artes', 'Curso: Técnicas Artesanais');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-08-10', 'Encontro de Famílias', '16:00', 'Salão Principal', 'Encontro Familiar');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-09-05', 'Palestra sobre Alimentação Saudável', '18:00', 'Cozinha Comunitária', 'Palestra: Nutrição Balanceada');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-10-20', 'Dia das Crianças', '10:00', 'Pátio Central', 'Celebração do Dia das Crianças');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-11-15', 'Workshop de Fotografia', '15:30', 'Estúdio Fotográfico', 'Workshop: Técnicas Fotográficas');

INSERT INTO evento (data, descricao, horario, local, titulo)
VALUES ('2024-12-22', 'Confraternização de Natal', '19:00', 'Salão de Festas', 'Jantar de Natal');

-- Insira mais eventos conforme necessário

INSERT INTO aviso (descricao, titulo)
VALUES ('Estudo bíblico toda quarta-feira às 19h. Todos são bem-vindos!', 'Estudo Bíblico');
INSERT INTO aviso (descricao, titulo)
VALUES ('Encontro de jovens neste sábado às 17h. Venha participar!', 'Encontro de Jovens');

INSERT INTO aviso (descricao, titulo)
VALUES ('Visitação aos enfermos do hospital local. Participe como voluntário!', 'Visitação aos Enfermos');

INSERT INTO aviso (descricao, titulo)
VALUES ('Grupo de apoio para famílias. Reunião mensal no salão principal.', 'Grupo de Apoio para Famílias');

INSERT INTO aviso (descricao, titulo)
VALUES ('Inscrições para o retiro espiritual de fim de semana já estão abertas!', 'Retiro Espiritual');

INSERT INTO aviso (descricao, titulo)
VALUES ('Concerto beneficente de música clássica em prol da comunidade.', 'Concerto Beneficente');

INSERT INTO aviso (descricao, titulo)
VALUES ('Semana de oração pelas crianças em situação de vulnerabilidade.', 'Semana de Oração pelas Crianças');

INSERT INTO aviso (descricao, titulo)
VALUES ('Aula inaugural do curso de línguas estrangeiras. Inscreva-se!', 'Curso de Línguas Estrangeiras');

INSERT INTO aviso (descricao, titulo)
VALUES ('Café da manhã comunitário todo domingo após o culto.', 'Café Comunitário');

INSERT INTO aviso (descricao, titulo)
VALUES ('Reunião de líderes de grupos de estudo na próxima segunda-feira às 18h.', 'Reunião de Líderes de Grupos de Estudo');

INSERT INTO aviso (descricao, titulo)
VALUES ('Arrecadação de roupas de inverno para doação aos necessitados.', 'Campanha de Doação de Roupas');

INSERT INTO aviso (descricao, titulo)
VALUES ('Coral da igreja buscando novos membros. Venha fazer parte!', 'Recrutamento para o Coral');

INSERT INTO aviso (descricao, titulo)
VALUES ('Aviso sobre interrupção temporária do serviço de água na igreja. Manutenção em progresso.', 'Interrupção do Serviço de Água');

INSERT INTO aviso (descricao, titulo)
VALUES ('Festa junina beneficente no próximo sábado às 18h. Traga sua família!', 'Festa Junina Beneficente');

INSERT INTO aviso (descricao, titulo)
VALUES ('Conferência de saúde mental e emocional. Inscrições abertas!', 'Conferência de Saúde Mental');

INSERT INTO aviso (descricao, titulo)
VALUES ('Projeto de revitalização do jardim da igreja. Voluntários são bem-vindos!', 'Revitalização do Jardim');

INSERT INTO aviso (descricao, titulo)
VALUES ('Culto especial de Páscoa com apresentação teatral.', 'Culto de Páscoa');

INSERT INTO aviso (descricao, titulo)
VALUES ('Reunião do conselho administrativo na próxima quinta-feira às 16h.', 'Reunião do Conselho Administrativo');

INSERT INTO aviso (descricao, titulo)
VALUES ('Convidamos todos a participar da feira de artesanato no próximo domingo.', 'Feira de Artesanato');

INSERT INTO aviso (descricao, titulo)
VALUES ('Encontro de casais para fortalecimento dos laços matrimoniais.', 'Encontro de Casais');

