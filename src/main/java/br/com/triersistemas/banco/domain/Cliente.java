package br.com.triersistemas.banco.domain;

import br.com.triersistemas.banco.model.ClienteModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Table(name = "cliente")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "cliente_id",updatable = false)
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "endereco")
    private String endereco;

    public Cliente(ClienteModel clienteModel) {
      this.nome=  clienteModel.getNome();
      this.cpf= clienteModel.getCpf();
      this.id=clienteModel.getId();
      this.telefone= clienteModel.getTelefone();
      this.endereco= clienteModel.getEndereco();
      this.email=  clienteModel.getEmail();
      this.dataNascimento=clienteModel.getDataNascimento();

    }

    public Cliente(final String nome, final String cpf, String email, String telefone, LocalDate dataNascimento, String endereco) {
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
    }


    public void alterar(String nome, String cpf, String email, String telefone, LocalDate dataNascimento, String endereco) {
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf;
    }


}
