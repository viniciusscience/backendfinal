package br.com.triersistemas.banco.service;

import br.com.triersistemas.banco.domain.Cliente;
import br.com.triersistemas.banco.domain.ContaBanco;
import br.com.triersistemas.banco.model.ClienteModel;
import br.com.triersistemas.banco.model.ContaBancoModel;
import br.com.triersistemas.banco.model.PagarContaModel;

import java.util.List;
import java.util.UUID;

public interface ContaBancoService {


    List<ContaBancoModel> consultar();

    ContaBancoModel consultar(UUID id);

    ContaBancoModel cadastrar(UUID id ,ContaBancoModel model);


    ContaBancoModel remover(UUID id);

}
