package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Categoria;
import com.br.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> listarCategorias(){
        return categoriaRepository.findAll();

    }

   public Categoria buscarCategoriaPeloId(int id) {
        Optional<Categoria> optionalAlbum = categoriaRepository.findById(id);

        if (optionalAlbum.isPresent()) {
            return optionalAlbum.get();
        }

        throw new RuntimeException("Categoria não existe");
    }

    public void deletarCategoria(int id){
        categoriaRepository.deleteById(id);
    }
}
