--CREATE DATABASE  IF NOT EXISTS `protocol-document` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
--USE `protocol-document`;
--
--CREATE TABLE tb_user (
--  id INT NOT NULL AUTO_INCREMENT,
--  first_name VARCHAR(50) NOT NULL,
--  last_name VARCHAR(50) NOT NULL,
--  mobile_number VARCHAR(20) NOT NULL,
--  email VARCHAR(100) NOT NULL,
--  password VARCHAR(255) NOT NULL,
--  PRIMARY KEY (id)
--);
--
--CREATE TABLE tb_role (
--  id INT NOT NULL AUTO_INCREMENT,
--  authority VARCHAR(20) NOT NULL,
--  PRIMARY KEY (id)
--);
--
--CREATE TABLE tb_user_role (
--  user_id INT NOT NULL,
--  role_id INT NOT NULL,
--  FOREIGN KEY (user_id) REFERENCES tb_user(id),
--  FOREIGN KEY (role_id) REFERENCES tb_role(id)
--);
--
--CREATE TABLE tb_protocol (
--  id INT NOT NULL AUTO_INCREMENT,
--  protocol_number INT NOT NULL,
--  institution VARCHAR(50) NOT NULL,
--  management VARCHAR(50) NOT NULL,
--  operating_unit VARCHAR(50) NOT NULL,
--  user_id INT NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (user_id) REFERENCES tb_user(id)
--);
--
--CREATE TABLE tb_document_type (
--  id INT NOT NULL AUTO_INCREMENT,
--  entity VARCHAR(50) NOT NULL,
--  protocol_id INT NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (protocol_id) REFERENCES tb_protocol(id)
--);
--
--CREATE TABLE tb_accounting (
--  id INT NOT NULL,
--  number_document INT NOT NULL,
--  invoice_value DECIMAL(10,2) NOT NULL,
--  discharge TIMESTAMP NOT NULL,
--  number_pay INT NOT NULL,
--  bordero INT NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_collective_labor_agreement (
--  id INT NOT NULL,
--  box_number INT NOT NULL,
--  company VARCHAR(50) NOT NULL,
--  date_year TIMESTAMP NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_contracts (
--  id INT NOT NULL,
--  contract_number VARCHAR(20) NOT NULL,
--  supplier VARCHAR(50) NOT NULL,
--  operating_unit VARCHAR(50) NOT NULL,
--  cnpj VARCHAR(18) NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_financial_report (
--  id INT NOT NULL,
--  number_document INT NOT NULL,
--  invoice_value DECIMAL(10,2) NOT NULL,
--  discharge TIMESTAMP NOT NULL,
--  number_pay INT NOT NULL,
--  bordero INT NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_fiscal_document (
--  id INT NOT NULL,
--  box_number INT NOT NULL,
--  guide_type VARCHAR(20) NOT NULL,
--  period TIMESTAMP NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_functional_folder (
--  id INT NOT NULL,
--  status INT NOT NULL,
--  registry_employee VARCHAR(50) NOT NULL,
--  box_number INT NOT NULL,
--  shutdown TIMESTAMP NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_international_certification (
--  id INT NOT NULL,
--  box_number INT NOT NULL,
--  process_number INT NOT NULL,
--  company VARCHAR(50) NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_medical_record (
--  id INT NOT NULL,
--  box_number INT NOT NULL,
--  employee VARCHAR(50) NOT NULL,
--  period TIMESTAMP NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_selection_process (
--  id INT NOT NULL,
--  employee VARCHAR(50) NOT NULL,
--  registry INT NOT NULL,
--  vacancy_number INT NOT NULL,
--  vacancy_name VARCHAR(50) NOT NULL,
--  box_number INT NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_supplies (
--  id INT NOT NULL,
--  supplie_type INT NOT NULL,
--  date_year TIMESTAMP NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);
--
--CREATE TABLE tb_technical_report (
--  id INT NOT NULL,
--  box_number INT NOT NULL,
--  project_name VARCHAR(50) NOT NULL,
--  period TIMESTAMP NOT NULL,
--  PRIMARY KEY (id),
--  FOREIGN KEY (id) REFERENCES tb_document_type(id)
--);

INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Alex', 'Brown', '31971734658', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Maria', 'Green', '31978455484', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Natiele', 'Dutra', '31978455484', 'natiele@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (123456, 'SESI', 'gerencia', 'unidade_operacional', true, '2023-05-25T13:00:00Z', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (1234567, 'SENAI', 'gerencia', 'unidade_operacional', false, '2023-04-25T13:00:00Z', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (12345678, 'FIEMG', 'gerencia', 'unidade_operacional', false, '2023-03-25T13:00:00Z', 2);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (123456, 'SESI', 'gerencia', 'unidade_operacional', true, '2023-05-25T13:00:00Z', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (1234567, 'SENAI', 'gerencia', 'unidade_operacional', false, '2023-04-25T13:00:00Z', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES (12345678, 'FIEMG', 'gerencia', 'unidade_operacional', false, '2023-03-25T13:00:00Z', 2);

INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 1);
INSERT INTO tb_accounting (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (1, 123456, 500.00, '2022-07-25T13:00:00Z', 123456, 4561);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 1);
INSERT INTO tb_collective_labor_agreement (id, box_number, company, date_year) VALUES (1, 123456, 'Companhia limitada', '2022-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 2);
INSERT INTO tb_contracts (id, contract_number, supplier, operating_unit, cnpj) VALUES (3, '12345678', 'Nome do fornecedor', 'unidade operacional', '50.644.169/0001-14');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IER', 2);
INSERT INTO tb_financial_report (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (4, 123456, 350.00, '2022-07-25T13:00:00Z', 123456, 123456);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 3);
INSERT INTO tb_fiscal_document (id, box_number, guide_type, period) VALUES (5, 123456, 'tipo de guia', '2022-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 3);
INSERT INTO tb_functional_folder (id, status, registry_employee, box_number, shutdown) VALUES (6, 0, 'registro funcionario', 123456, '2022-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('FIEMG', 4);
INSERT INTO tb_international_certification (id, box_number, process_number, company) VALUES (7, 123456, 12345678, 'companhia limitada');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 4);
INSERT INTO tb_medical_record (id, box_number, employee, period) VALUES (8, 12345678, 'nome do funcionario', '2022-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 5);
INSERT INTO tb_selection_process (id, employee, registry, vacancy_number, vacancy_name, box_number) VALUES (9, 'nome do funcionario', 12345678, 123456, 'nome da vaga', 371734658);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 5);
INSERT INTO tb_supplies (id, supplie_type, date_year) VALUES (10, 0, '2022-07-25T13:00:00Z');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 5);
INSERT INTO tb_technical_report (id, box_Number, project_name, period) VALUES (11, 12345678, 'nome do projeto', '2022-07-25T13:00:00Z');

--ATENÇÃO!
--Este documento tem um prazo de 10 dias úteis para ser devolvido.
--A não devolução pode acarretar descumprimento da LGPD e expor informações que
--deveriam ser mantidas em sigilo.
--Por favor, certifique-se de devolver o documento o mais breve possível.