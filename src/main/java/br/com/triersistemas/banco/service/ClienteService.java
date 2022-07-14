package br.com.triersistemas.banco.service;

import br.com.triersistemas.banco.domain.Cliente;
import br.com.triersistemas.banco.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<ClienteModel> consultar();

    ClienteModel consultar(UUID id);

    ClienteModel cadastrar(ClienteModel model);

    ClienteModel alterar(ClienteModel model);

    ClienteModel remover(UUID id);

    List<Cliente> findByNomeContainsIgnoreCase(String nome);

    List<Cliente> buscaPeloemail(String nome);


    List<Cliente> buscarPeloCpf(String cpf);
}
