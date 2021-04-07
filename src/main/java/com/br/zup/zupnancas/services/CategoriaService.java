package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Categoria;
import com.br.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria cadastrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
