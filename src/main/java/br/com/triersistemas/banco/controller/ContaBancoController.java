package br.com.triersistemas.banco.controller;


import br.com.triersistemas.banco.domain.ContaBanco;
import br.com.triersistemas.banco.model.ContaBancoModel;
import br.com.triersistemas.banco.model.PagarContaModel;

import br.com.triersistemas.banco.service.ContaBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contabanco")
public class ContaBancoController {

    @Autowired
    private ContaBancoService contaBancoService;

    @GetMapping("/consultar")
    public List<ContaBancoModel> consultar() {
        return contaBancoService.consultar();
    }

    @PostMapping("/cadastrar/{id}")
    public ContaBancoModel cadastrar(@PathVariable UUID id,@RequestBody ContaBancoModel model) {
        return contaBancoService.cadastrar(id ,model);
    }

    @DeleteMapping("/remover/{id}")
    public ContaBancoModel remover(@PathVariable UUID id) {
        return contaBancoService.remover(id);
    }

}
