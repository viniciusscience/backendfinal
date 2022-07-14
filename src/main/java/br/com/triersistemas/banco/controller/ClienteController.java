package br.com.triersistemas.banco.controller;


import br.com.triersistemas.banco.domain.Cliente;
import br.com.triersistemas.banco.model.ClienteModel;
import br.com.triersistemas.banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/consultar")
    public List<ClienteModel> consultar() {
        return clienteService.consultar();
    }

    @PostMapping("/cadastrar")
    public ClienteModel cadastrar(@RequestBody  ClienteModel model) {
        return clienteService.cadastrar(model);
    }


    @GetMapping("/listar/{nome}")
    public List<Cliente> listarPorNome(@PathVariable String nome) {
        return clienteService.findByNomeContainsIgnoreCase(nome);
    }
    @GetMapping("/listarEmail/{nome}")
    public List<Cliente> buscarPeloemail(@PathVariable String nome){
        return clienteService.buscaPeloemail(nome);
    }
    @GetMapping("/listarCpf/{cpf}")
    public List<Cliente> buscaPeloCpf (@PathVariable String cpf){
        return clienteService.buscarPeloCpf(cpf);
    }

    @PutMapping("/alterar")
    public ClienteModel alterar(@RequestBody  ClienteModel model) {
        return clienteService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public ClienteModel remover(@PathVariable UUID id) {
        return clienteService.remover(id);
    }
}