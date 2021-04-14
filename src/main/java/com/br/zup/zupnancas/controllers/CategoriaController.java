package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.entities.Categoria;
import com.br.zup.zupnancas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria){
        return categoriaService.cadastrarCategoria(categoria);
    }

    @GetMapping("{id}/")
    public Categoria pesquisarCategoriaPorId(@PathVariable int id){
        return categoriaService.buscarCategoriaPeloId(id);
    }

    @GetMapping
    public Iterable<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @DeleteMapping
    public void deletarCategoria(@PathVariable int id){
        categoriaService.deletarCategoria(id);
    }
}
