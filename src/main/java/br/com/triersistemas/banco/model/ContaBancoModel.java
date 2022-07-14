package br.com.triersistemas.banco.model;

import br.com.triersistemas.banco.Enuns.StatusConta;
import br.com.triersistemas.banco.Enuns.StatusTipo;
import br.com.triersistemas.banco.domain.Cliente;
import br.com.triersistemas.banco.domain.ContaBanco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ContaBancoModel {
    private UUID id;
    private UUID idCliente;
    private String nomeCliente;
    private int numConta;
    private Cliente cliente;
    protected StatusTipo tipo;
    private BigDecimal saldo;
    private StatusConta statusConta;
    private BigDecimal valor;
    private boolean status;
    private int agencia;
    private int senha;

    public ContaBancoModel(ContaBanco contaBanco) {
        this.id=contaBanco.getId();
        this.idCliente= contaBanco.getIdCliente();
        this.tipo = contaBanco.getTipo();
        this.saldo = contaBanco.getSaldo();
        this.statusConta = contaBanco.getStatusConta();
        this.valor = contaBanco.getValor();
        this.status = contaBanco.isStatus();
        this.agencia = contaBanco.getAgencia();
        this.senha = contaBanco.getSenha();
    }
}
