package com.br.zup.zupnancas.repositories;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.enums.Status;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta,Integer> {
    Iterable<Conta> findAllByStatus(Status status);
}
