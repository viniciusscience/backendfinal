CREATE TABLE cliente (
    cliente_id uuid PRIMARY KEY,
    nome VARCHAR(200),
    cpf VARCHAR(11)  UNIQUE,
    email VARCHAR(255),
    telefone VARCHAR(11),
    data_nascimento date,
    endereco VARCHAR(244)
);
