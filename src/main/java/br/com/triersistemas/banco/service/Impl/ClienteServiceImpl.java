package br.com.triersistemas.banco.service.Impl;

import br.com.triersistemas.banco.domain.Cliente;
import br.com.triersistemas.banco.exceptions.NaoExisteException;
import br.com.triersistemas.banco.model.ClienteModel;
import br.com.triersistemas.banco.repository.ClienteRepository;
import br.com.triersistemas.banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<ClienteModel> consultar() {
        return clienteRepository.findAll().stream().map(ClienteModel::new).collect(Collectors.toList());
    }

    @Override
    public ClienteModel consultar(UUID id) {
        return new ClienteModel(this.buscaPorId(id));
    }

    @Override
    public ClienteModel cadastrar(ClienteModel model) {
        var cliente = new Cliente(model);

        return new ClienteModel(clienteRepository.save(cliente));
    }
    protected Cliente IMPLbuscarPorId(UUID id) {
        return clienteRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
    @Override
    public ClienteModel alterar(ClienteModel model) {
        Cliente cliente = this.buscaPorId(model.getId());
        cliente.alterar(model.getNome(), model.getCpf(), model.getEmail(), model.getTelefone(), model.getDataNascimento(), model.getEndereco());
        return new ClienteModel(this.clienteRepository.save(cliente));
    }

    @Override
    public ClienteModel remover(UUID id) {
        Cliente cliente = this.buscaPorId(id);
        clienteRepository.delete(cliente);
        return new ClienteModel(cliente);
    }

    @Override
    public List<Cliente> findByNomeContainsIgnoreCase(String nome) {

            return this.clienteRepository.findByNomeContainsIgnoreCase(nome);
    }

    @Override
    public List<Cliente> buscaPeloemail(String nome) {
        return this.clienteRepository.buscaPeloemail(nome);
    }

    @Override
    public List<Cliente> buscarPeloCpf(String cpf) {
        return this.clienteRepository.buscaPeloCpf(cpf);
    }

    private Cliente buscaPorId(UUID id){
        return clienteRepository.findById(id).orElseThrow(NaoExisteException::new);
    }
}
