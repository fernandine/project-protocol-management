CREATE DATABASE  IF NOT EXISTS `protocol-document`;
USE `protocol-document`;

CREATE TABLE tb_user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  mobile_number VARCHAR(20),
  email VARCHAR(100),
  password VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE tb_role (
  id BIGINT NOT NULL AUTO_INCREMENT,
  authority VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE tb_user_role (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES tb_user(id),
  FOREIGN KEY (role_id) REFERENCES tb_role(id)
);

CREATE TABLE tb_protocol (
  id BIGINT NOT NULL AUTO_INCREMENT,
  protocol_number VARCHAR(20),
  institution VARCHAR(50),
  management VARCHAR(50),
  operating_unit VARCHAR(50),
  received BOOLEAN,
  received_date TIMESTAMP,
  user_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

CREATE TABLE tb_document_type (
  id BIGINT NOT NULL AUTO_INCREMENT,
  entity VARCHAR(50) NOT NULL,
  protocol_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (protocol_id) REFERENCES tb_protocol(id)
);

CREATE TABLE tb_accounting (
  id BIGINT NOT NULL,
  number_document BIGINT NOT NULL,
  invoice_value DECIMAL(10,2) NOT NULL,
  discharge TIMESTAMP NOT NULL,
  number_pay BIGINT NOT NULL,
  bordero BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_collective_labor_agreement (
  id BIGINT NOT NULL,
  box_number BIGINT NOT NULL,
  company VARCHAR(50) NOT NULL,
  date_year TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_contracts (
  id BIGINT NOT NULL,
  contract_number VARCHAR(20) NOT NULL,
  supplier VARCHAR(50) NOT NULL,
  operating_unit VARCHAR(50) NOT NULL,
  cnpj VARCHAR(18) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_financial_report (
  id BIGINT NOT NULL,
  number_document BIGINT NOT NULL,
  invoice_value DECIMAL(10,2) NOT NULL,
  discharge TIMESTAMP NOT NULL,
  number_pay BIGINT NOT NULL,
  bordero BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_fiscal_document (
  id BIGINT NOT NULL,
  box_number BIGINT NOT NULL,
  guide_type VARCHAR(20) NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_functional_folder (
  id BIGINT NOT NULL,
  status BIGINT NOT NULL,
  registry_employee VARCHAR(50) NOT NULL,
  box_number BIGINT NOT NULL,
  shutdown TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_international_certification (
  id BIGINT NOT NULL,
  box_number BIGINT NOT NULL,
  process_number BIGINT NOT NULL,
  company VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_medical_record (
  id BIGINT NOT NULL,
  box_number BIGINT NOT NULL,
  employee VARCHAR(50) NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_selection_process (
  id BIGINT NOT NULL,
  employee VARCHAR(50) NOT NULL,
  registry BIGINT NOT NULL,
  vacancy_number BIGINT NOT NULL,
  vacancy_name VARCHAR(50) NOT NULL,
  box_number BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_supplies (
  id BIGINT NOT NULL,
  supplie_type BIGINT NOT NULL,
  date_year TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_technical_report (
  id BIGINT NOT NULL,
  box_number BIGINT NOT NULL,
  project_name VARCHAR(50) NOT NULL,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES tb_document_type(id)
);

CREATE TABLE tb_company (
  id BIGINT NOT NULL,
  corporate_name varchar(60) DEFAULT NULL,
  cnpj varchar(45) DEFAULT NULL,
  mobile_number varchar(20) DEFAULT NULL,
  email varchar(60) DEFAULT NULL,
  PRIMARY KEY (id)
)

INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Alex', 'Brown', '31971734658', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Maria', 'Green', '31978455484', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, mobile_number, email, password) VALUES ('Natiele', 'Dutra', '31978455484', 'natiele@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_USER');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES ('DOC1-123456', 'SESI', 'gerencia', 'unidade_operacional', true, '2023-05-25T13:00:00', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES ('DOC2-1234567', 'SENAI', 'gerencia', 'unidade_operacional', false, '2023-04-25T13:00:00', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES ('DOC3-1234568', 'FIEMG', 'gerencia', 'unidade_operacional', false, '2023-03-25T13:00:00', 2);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES ('DOC4-1234569', 'SESI', 'gerencia', 'unidade_operacional', true, '2023-05-25T13:00:00', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES ('DOC5-12345610', 'SENAI', 'gerencia', 'unidade_operacional', false, '2023-04-25T13:00:00', 1);
INSERT INTO tb_protocol (protocol_number, institution, management, operating_unit, received, received_date, user_id) VALUES ('DOC5-12345611', 'FIEMG', 'gerencia', 'unidade_operacional', false, '2023-03-25T13:00:00', 2);

INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 1);
INSERT INTO tb_accounting (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (1, 123456, 500.00, '2022-07-25T13:00:00', 123456, 4561);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 1);
INSERT INTO tb_collective_labor_agreement (id, box_number, company, date_year) VALUES (1, 123456, 'Companhia limitada', '2022-07-25T13:00:00');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 2);
INSERT INTO tb_contracts (id, contract_number, supplier, operating_unit, cnpj) VALUES (3, '12345678', 'Nome do fornecedor', 'unidade operacional', '50.644.169/0001-14');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IER', 2);
INSERT INTO tb_financial_report (id, number_document, invoice_value, discharge, number_pay, bordero) VALUES (4, 123456, 350.00, '2022-07-25T13:00:00', 123456, 123456);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 3);
INSERT INTO tb_fiscal_document (id, box_number, guide_type, start_date, end_date) VALUES (5, 123456, 'tipo de guia', '2022-07-25T13:00:00','2023-07-25T13:00:00');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 3);
INSERT INTO tb_functional_folder (id, status, registry_employee, box_number, shutdown) VALUES (6, 0, 'registro funcionario', 123456, '2022-07-25T13:00:00');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('FIEMG', 4);
INSERT INTO tb_international_certification (id, box_number, process_number, company) VALUES (7, 123456, 12345678, 'companhia limitada');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SENAI', 4);
INSERT INTO tb_medical_record (id, box_number, employee, start_date, end_date) VALUES (8, 12345678, 'nome do funcionario', '2022-07-25T13:00:00', '2023-07-25T13:00:00');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('SESI', 5);
INSERT INTO tb_selection_process (id, employee, registry, vacancy_number, vacancy_name, box_number) VALUES (9, 'nome do funcionario', 12345678, 123456, 'nome da vaga', 371734658);
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('CIEMG', 5);
INSERT INTO tb_supplies (id, supplie_type, date_year) VALUES (10, 0, '2022-07-25T13:00:00');
INSERT INTO tb_document_type (entity, protocol_id) VALUES ('IEL', 5);
INSERT INTO tb_technical_report (id, box_Number, project_name, start_date, end_date) VALUES (11, 12345678, 'nome do projeto', '2022-07-25T13:00:00', '2023-07-25T13:00:00');

INSERT INTO tb_company (corporate_name, cnpj, mobile_number, email) VALUES ('FIEMG', '17.212.069/0001-81', '(31) 3257-6403', 'cit@fiemg.com.br');