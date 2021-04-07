package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.entities.Categoria;
import com.br.zup.zupnancas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria){
        return categoriaService.cadastrarCategoria(categoria);
    }
}
