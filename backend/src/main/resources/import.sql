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
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, user_id) VALUES (123456, 'SESI', 'gerencia', 'unidade_operacional', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, user_id) VALUES (1234567, 'SENAI', 'gerencia', 'unidade_operacional', 2);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, user_id) VALUES (12345678, 'FIEMG', 'gerencia', 'unidade_operacional', 1);

-- -------------------------------------------
-- Tipos de documentos
-- -------------------------------------------
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 1);
--INSERT INTO tb_accounting (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (1, 123456, 500.00, '2022-07-25T13:00:00Z', 123456, 4561);
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 1);
--INSERT INTO tb_collective_labor_agreement (id, entity, protocol_id, box_number, number_process, company, date_year) VALUES (1, 'SESI', 1, 123456, 5465464, 'Companhia limitada', '2022-07-25T13:00:00Z');
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 1);
--INSERT INTO tb_contracts (id, contract_number, supplier, operating_unit, cnpj) VALUES (3, '12345678', 'Nome do fornecedor', 'unidade operacional', '50.644.169/0001-14');
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IER', 2);
--INSERT INTO tb_financial_report (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (4, 123456, 350.00, TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 123456, 123456);
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 3);
--INSERT INTO tb_fiscal_document (id, box_number, guide_type, period) VALUES (5, 123456, 'tipo de guia', TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z');
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 3);
--INSERT INTO tb_functional_folder (id, status, registry_employee, box_number, shutdown) VALUES (6, 0, 'registro funcionario', 123456, TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z');
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('FIEMG', 1);
--INSERT INTO tb_international_certification (id, box_number, process_number, company) VALUES (7, 123456, 12345678, 'companhia limitada');
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 2);
--INSERT INTO tb_medical_record (id, box_number, employee, period) VALUES (8, 12345678, 'nome do funcionario', TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z');
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 3);
--INSERT INTO tb_selection_process (id, employee, registry, vacancy_number, vacancy_name, box_number) VALUES (9, 'nome do funcionario', 12345678, 123456, 'nome da vaga', 371734658);
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 1);
--INSERT INTO tb_supplies (id, supplie_type, date_year) VALUES (10, 0, TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z');
--
--INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 2);
--INSERT INTO tb_technical_report (id, box_Number, project_name, period) VALUES (11, 12345678, 'nome do projeto', TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z');



