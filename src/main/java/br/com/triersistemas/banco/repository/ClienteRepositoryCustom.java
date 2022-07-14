package br.com.triersistemas.banco.repository;

import br.com.triersistemas.banco.domain.Cliente;

import java.util.List;

public interface ClienteRepositoryCustom {
    List<Cliente> listarPorNome(String nome);
}
