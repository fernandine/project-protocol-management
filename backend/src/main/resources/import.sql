INSERT INTO tb_user (first_name, last_name, phone, email, password) VALUES ('Alex', 'Brown', '31971734658', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, phone, email, password) VALUES ('Maria', 'Green', '31978455484', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (123456, 'SESI', 'gerencia', 'unidade_operacional', true, '2023-05-25T13:00:00Z', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (1234567, 'SENAI', 'gerencia', 'unidade_operacional', false, '2023-04-25T13:00:00Z', 2);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (12345678, 'FIEMG', 'gerencia', 'unidade_operacional', false, '2023-03-25T13:00:00Z', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (123456789, 'SESI', 'gerencia', 'unidade_operacional', true, '2023-05-25T13:00:00Z', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (12345678910, 'SENAI', 'gerencia', 'unidade_operacional', false, '2023-04-25T13:00:00Z', 2);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (12345678911, 'FIEMG', 'gerencia', 'unidade_operacional', false, '2023-03-25T13:00:00Z', 1);

INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 1);
INSERT INTO tb_accounting (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (1, 123456, 500.00, '2022-07-25T13:00:00Z', 123456, 4561);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 1);
INSERT INTO tb_collective_labor_agreement (id, box_number, company, date_year) VALUES (1, 123456, 'Companhia limitada', '1994');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 2);
INSERT INTO tb_contracts (id, contract_number, supplier, operating_unit, cnpj) VALUES (3, '12345678', 'Nome do fornecedor', 'unidade operacional', '50.644.169/0001-14');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IER', 2);
INSERT INTO tb_financial_report (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (4, 123456, 350.00, '2022-07-25T13:00:00Z', 123456, 123456);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 3);
INSERT INTO tb_fiscal_document (id, box_number, guide_type, start_date, end_date) VALUES (5, 123456, 'tipo de guia', '2022-07-25T13:00:00Z', '2023-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 3);
INSERT INTO tb_functional_folder (id, status, registry_employee, box_number, shutdown) VALUES (6, 0, 'registro funcionario', 123456, '2022-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('FIEMG', 4);
INSERT INTO tb_international_certification (id, box_number, process_number, company) VALUES (7, 123456, 12345678, 'companhia limitada');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 4);
INSERT INTO tb_medical_record (id, box_number, employee, start_date, end_date) VALUES (8, 12345678, 'nome do funcionario', '2022-07-25T13:00:00Z', '2023-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 5);
INSERT INTO tb_selection_process (id, employee, registry, vacancy_number, vacancy_name, box_number) VALUES (9, 'nome do funcionario', 12345678, 123456, 'nome da vaga', 371734658);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 5);
INSERT INTO tb_supplies (id, supplie_type, date_year) VALUES (10, 0, '2002');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 5);
INSERT INTO tb_technical_report (id, box_Number, project_name, start_date, end_date) VALUES (11, 12345678, 'nome do projeto', '2022-07-25T13:00:00Z', '2022-07-25T13:00:00Z');

--ATENÇÃO!
--Este documento tem um prazo de 10 dias úteis para ser devolvido.
--A não devolução pode acarretar descumprimento da LGPD e expor informações que
--deveriam ser mantidas em sigilo.
--Por favor, certifique-se de devolver o documento o mais breve possível.