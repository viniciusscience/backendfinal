package br.com.triersistemas.banco.repository;

import br.com.triersistemas.banco.domain.Cliente;
import br.com.triersistemas.banco.domain.ContaBanco;
import br.com.triersistemas.banco.model.ContaBancoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContaBancoReposity extends JpaRepository<ContaBanco,UUID> {


}
