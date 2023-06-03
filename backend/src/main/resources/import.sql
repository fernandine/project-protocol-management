-- -------------------------------------------
-- Usuários e perfis
-- -------------------------------------------
INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Alex', 'Brown', '31971734658', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Maria', 'Green', '31978455484', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Natiele', 'Dutra', '31978455484', 'natiele@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

-- -------------------------------------------
-- Protocolo
-- -------------------------------------------
INSERT INTO tb_protocol (protocol_number, core, management, operating_unit, user_id) VALUES (123456, 'SESI', 'gerencia', 'unidade_operacional', 1);
INSERT INTO tb_protocol (protocol_number, core, management, operating_unit, user_id) VALUES (123456, 'SENAI', 'gerencia', 'unidade_operacional', 2);
INSERT INTO tb_protocol (protocol_number, core, management, operating_unit, user_id) VALUES (123456, 'FIEMG', 'gerencia', 'unidade_operacional', 1);

-- -------------------------------------------
-- Tipos de documentos
-- -------------------------------------------
INSERT INTO tb_accounting (protocol_id, entity, number_document, invoice_value, discharge, number_pay, bordero) VALUES (1, 'SESI', 123456, 500.00, '2022-07-25T13:00:00Z', 123456, 4561);
INSERT INTO tb_collective_labor_agreement (protocol_id, entity, box_number, number_process, company, date_year) VALUES (2, 'SENAI', 123456, 5465464, 'Companhia limitada', '2022-07-25T13:00:00Z');
INSERT INTO tb_contracts (protocol_id, entity, contract_number, supplier, operating_unit, cnpj) VALUES (3, 'FIEMG', '12345678', 'Nome do fornecedor', 'unidade operacional', '50.644.169/0001-14');
--INSERT INTO document_type (entity, number_document, invoice_value, discharge, number_pay, bordero, protocol_id) VALUES ('IEL', 123456, 350.00, TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 123456, 123456, 1);
--INSERT INTO document_type (entity, box_number, guide_type, period, protocol_id) VALUES ('IER', 123456, 'tipo de guia', TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 2);
--INSERT INTO document_type (entity, status, registry_employee, box_number, shutdown, protocol_id) VALUES ('CIEMG', 0, 'registro funcionario', 123456, TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 3);
--INSERT INTO document_type (entity, box_number, process_number, company, protocol_id) VALUES ('SESI', 123456, 12345678, 'companhia limitada', 1);
--INSERT INTO document_type (entity, box_number, employee, period, protocol_id) VALUES ('SENAI', 12345678, 'nome do funcionario', TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 2);
--INSERT INTO tb_selection_process (entity, employee, registry, vacancy_number, vacancy_name, box_number, protocol_id) VALUES ('FIEMG', 'nome do funcionario', 12345678, 123456, 'nome da vaga', 371734658, 3);
--INSERT INTO tb_supplies (entity, type, date_year, protocol_id) VALUES ('IEL', 0, TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 1);
--INSERT INTO tb_technical_report (entity, box_Number, project_name, period, protocol_id) VALUES ('SENAI', 12345678, 'nome do projeto', TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 2);



