package br.com.triersistemas.banco.model;

import br.com.triersistemas.banco.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class ClienteModel {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String endereco;

    public ClienteModel(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf= cliente.getCpf();
        this.email=cliente.getEmail();
        this.telefone=cliente.getTelefone();
        this.dataNascimento=cliente.getDataNascimento();
        this.endereco=cliente.getEndereco();
    }


}
