-- Insert das referencias Geograficas dos Destinos(Aeroporto) e Pontos Aéreos(Referencia)
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -30.033056, -50.243056, 'A1' ); --Aeroporto1
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -15.033056, -27.243056, 'A2' ); --Aeroporto2
INSERT INTO ref_geo( latitude, longitude, nome) VALUES (  20.033056,  10.243056, 'A3' ); --Aeroporto3
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -70.033056, -50.243056, 'A4' ); --Aeroporto4
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -42.033056, -12.243056, 'A5' ); --Aeroporto5
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -27.033056, -19.243056, 'R1' ); --Referencia1
INSERT INTO ref_geo( latitude, longitude, nome) VALUES ( -19.033056, -40.243056, 'R2' ); --Referencia2

-- Insert das aerovias Onde o nome A indica Aeroporto e R referencia
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA1A2', 800, 1, 2);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA2A1', 800, 2, 1);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA3A4', 500, 3, 4);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA4A5', 200, 4, 5);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA5A3', 650, 5, 3);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA1R1', 300, 1, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR1A4', 600, 6, 4);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA2R2', 700, 2, 7);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR2A5', 1000, 7, 5);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA3R1', 200, 3, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR1A2', 400, 6, 2);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA4R1', 200, 4, 6);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR1A3', 150, 6, 3);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaA5R2', 1000, 5, 7);
Insert into aerovia(nome, distancia, ref_geo_destiny_id, ref_geo_origin_id) VALUES ('AeroviaR2A1', 860, 7, 1);

-- Insert das rotas
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA1A2', 1, 2);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA2A1', 2, 1);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA3A4', 3, 4);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA4A5', 4, 5);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA5A3', 5, 3);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA1A4', 1, 4);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA2A5', 2, 5);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA3A2', 3, 2);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA4A3', 4, 3);
Insert into rota(nome, ref_geo_origin_id, ref_geo_destiny_id) VALUES ('RotaA5A1', 5, 1);

-- Insert da tabela intermediária ligando aerovias com as rotas
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (1, 1);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (2, 2);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (3, 3);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (4, 4);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (5, 5);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (6, 6);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (6, 7);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (7, 8);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (7, 9);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (8, 10);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (8, 11);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (9, 12);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (9, 13);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (10, 14);
Insert into rota_aerovia(id_rota, id_aerovia) VALUES (10, 15);

-- Insert dos slots de Ocupacao Aerovia
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 1);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 2);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 3);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 4);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 5);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 6);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 7);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 8);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 19);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 20);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 25000, 21);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 26000, 10);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 26000, 5);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 26000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 27000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 28000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 33000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 1, 34000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 12);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 12);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 13);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 14);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 14);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 18);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 10, 30000, 22);
Insert into ocupacao_aerovia(data, id_aerovia, slot_altitude, slot_horario) VALUES ('2022-10-19', 11, 30000, 22);

-- Insert dos Planos de Voo
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (34000, '2022-10-19', 18, 800, 1);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 12, 200, 8);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 14, 600, 8);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 18, 600, 8);
Insert into plano_voo(altitude, data, horario_partida, vel_cruzeiro, id_rota) VALUES (30000, '2022-10-19', 22, 850, 8);