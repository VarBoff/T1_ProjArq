insert into aeroporto(id,nome) values(1,'POA');
insert into aeroporto(id,nome) values(2,'CWB');
insert into aeroporto(id,nome) values(3,'RIO');
insert into aeroporto(id,nome) values(4,'SP');

insert into aeronave(id,autonomia,prefixo,tipo,velocidade) values(1,5000,'PPLTW','PC',1000);
insert into aeronave(id,autonomia,prefixo,tipo,velocidade) values(2,5000,'PPLT5','CC',1000);
insert into aeronave(id,autonomia,prefixo,tipo,velocidade) values(3,5000,'PPLT6','CP',1000);
insert into aeronave(id,autonomia,prefixo,tipo,velocidade) values(4,5000,'PPLT7','PC',1000);
insert into aeronave(id,autonomia,prefixo,tipo,velocidade) values(5,5000,'PPLT8','CC',1000);
insert into aeronave(id,autonomia,prefixo,tipo,velocidade) values(6,5000,'PPLT9','CC',1000);


insert into rota(id,nome,tamanho,origem_id,destino_id) values(1,'POACWB1',1000,1,2);
insert into rota(id,nome,tamanho,origem_id,destino_id) values(2,'POACWB2',1000,1,2);
insert into rota(id,nome,tamanho,origem_id,destino_id) values(3,'POACWB3',1000,1,2);
insert into rota(id,nome,tamanho,origem_id,destino_id) values(4,'POACWB4',1000,1,2);
insert into rota(id,nome,tamanho,origem_id,destino_id) values(5,'POACWB5',1000,1,2);
insert into rota(id,nome,tamanho,origem_id,destino_id) values(6,'POACWB6',1000,1,2);

insert into ocupacao(id,data,rota_id,slot_altitude,slot_horario) values(1,'2022-12-31 23.59.59',1,26000,23);
insert into ocupacao(id,data,rota_id,slot_altitude,slot_horario) values(2,'2022-12-31 23.59.59',2,26000,23);

insert into plano_de_voo(id,altitude,data,slots_tempo,aeronave_id,rota_id) values(1,26000,'2022-12-31 23.59.59',23,1,1);




