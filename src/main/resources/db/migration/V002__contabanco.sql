CREATE TABLE contabanco (
    id_cliente VARCHAR(255),
    conta_id uuid PRIMARY KEY ,
    tipo VARCHAR(255),
    valor VARCHAR(255),
    saldo VARCHAR(255),
    agencia VARCHAR(255),
    senha VARCHAR(255),
    status VARCHAR(255)
);

