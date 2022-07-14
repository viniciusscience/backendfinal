package br.com.triersistemas.banco.repository;

import br.com.triersistemas.banco.domain.Cliente;
import br.com.triersistemas.banco.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>,ClienteRepositoryCustom {

    List<Cliente> findByNomeContainsIgnoreCase(String nome);

    @Query(value = "SELECT * FROM Cliente WHERE email ilike '%' || ?1 || '%'", nativeQuery = true)
    List<Cliente> buscaPeloemail(String email);

    @Query(value = "SELECT s FROM  Cliente s WHERE lower(s.cpf) like concat('%', lower(?1), '%')")
    List<Cliente> buscaPeloCpf(String nome);

}
