package br.com.triersistemas.banco.domain;

import br.com.triersistemas.banco.Enuns.StatusConta;
import br.com.triersistemas.banco.Enuns.StatusTipo;
import br.com.triersistemas.banco.model.ContaBancoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "contabanco")
public class ContaBanco {
    @Id
    @Column(name = "conta_id")
    private UUID id;
    @Column(name = "id_cliente")
    private UUID idCliente;
    @Column(name = "tipo")
    private StatusTipo tipo;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "status")
    private StatusConta statusConta;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "status",insertable = false,updatable = false)
    private boolean status;
    @Column(name = "agencia")
    private int agencia;


    @Column(name = "senha")
    private int senha;


    public ContaBanco(UUID id) {
        this.id = UUID.randomUUID();
        this.idCliente = this.id;
        Random gerador = new Random();
        this.id = UUID.randomUUID();
        this.statusConta = StatusConta.ABERTA;
        this.saldo = BigDecimal.ZERO;
        this.tipo = StatusTipo.CONTACORRENTE;
        this.agencia = gerador.nextInt(0, 1000);

        this.status = true;
        this.valor = BigDecimal.ZERO;
        this.senha = gerador.nextInt(1000, 2000);

    }

    public ContaBanco(ContaBancoModel contaBancoModel) {
        contaBancoModel.getCliente();
        this.saldo = contaBancoModel.getSaldo();
        this.agencia = contaBancoModel.getAgencia();
        this.idCliente = contaBancoModel.getIdCliente();
        this.senha = contaBancoModel.getSenha();
        this.tipo = contaBancoModel.getTipo();
        this.valor = contaBancoModel.getValor();
    }
}




