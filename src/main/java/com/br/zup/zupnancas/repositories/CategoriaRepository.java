package com.br.zup.zupnancas.repositories;

import com.br.zup.zupnancas.entities.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria,Integer> {
    Optional<Categoria> findByNome(String nome);
    Iterable<Categoria> findAllByNome(Categoria categoria);
}
