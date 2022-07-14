package br.com.triersistemas.banco.service.Impl;

import br.com.triersistemas.banco.domain.ContaBanco;
import br.com.triersistemas.banco.exceptions.NaoExisteException;
import br.com.triersistemas.banco.model.ClienteModel;
import br.com.triersistemas.banco.model.ContaBancoModel;
import br.com.triersistemas.banco.repository.ContaBancoReposity;
import br.com.triersistemas.banco.service.ClienteService;
import br.com.triersistemas.banco.service.ContaBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContaBancoServiceImpl implements ContaBancoService {

    @Autowired
    private ContaBancoReposity contaBancoReposity;
    @Autowired
    ClienteServiceImpl ClienteService;

    @Override
    public List<ContaBancoModel> consultar() {
        return contaBancoReposity.findAll().stream().map(ContaBancoModel::new).collect(Collectors.toList());
    }

    @Override
    public ContaBancoModel consultar(UUID id) {
        return new ContaBancoModel(this.buscarPorId(id));

    }
    @Override
    public ContaBancoModel cadastrar(UUID id ,ContaBancoModel model) {
        var cliente = this.ClienteService.IMPLbuscarPorId(model.getIdCliente());
        var contaBanco =  new ContaBanco(model.getIdCliente());
        return new ContaBancoModel(this.contaBancoReposity.save(contaBanco));
    }

    @Override
    public ContaBancoModel remover(UUID id) {
        ContaBanco contaBanco = this.buscarPorId(id);
        contaBancoReposity.delete(contaBanco);
        return new ContaBancoModel(contaBanco);
    }


    private ContaBanco buscarPorId(UUID id){
        return contaBancoReposity.findById(id).orElseThrow(NaoExisteException::new);
    }
}

