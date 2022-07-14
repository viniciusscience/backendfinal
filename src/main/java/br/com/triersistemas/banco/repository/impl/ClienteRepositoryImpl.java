package br.com.triersistemas.banco.repository.impl;

import br.com.triersistemas.banco.domain.Cliente;

import br.com.triersistemas.banco.domain.QCliente;
import br.com.triersistemas.banco.repository.ClienteRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;



public class ClienteRepositoryImpl implements ClienteRepositoryCustom {

    @PersistenceContext
    private EntityManager am;


    @Override
    public List<Cliente> listarPorNome(String nome) {
    final   QCliente cliente = QCliente.cliente;
            BooleanBuilder where = new BooleanBuilder();
            where.and(cliente.nome.containsIgnoreCase(nome));

        return new JPAQuery<Cliente>(am).select(cliente).from(cliente).where(where).fetch();
    }

    public List<Cliente> buscarPeloemail (String nome) {
        final QCliente cliente = QCliente.cliente;
        BooleanBuilder where = new BooleanBuilder();
        where.and(cliente.email.containsIgnoreCase(nome));

        return new JPAQuery<Cliente>(am).select(cliente).from(cliente).where(where).fetch();

    }
    public List<Cliente> buscaPeloCpf (String cpf) {
        final QCliente cliente = QCliente.cliente;
        BooleanBuilder where = new BooleanBuilder();
        where.and(cliente.cpf.containsIgnoreCase(cpf));

        return new JPAQuery<Cliente>(am).select(cliente).from(cliente).where(where).fetch();

    }


}



