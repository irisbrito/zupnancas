package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Categoria;
import com.br.zup.zupnancas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Método para cadastrar nova categoria
     * @param categoria
     * @return categoria
     */
    public Categoria cadastrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    /**
     * Método para listar as categorias
     * @return todas as listas
     */
    public Iterable<Categoria> listarCategorias(){
        return categoriaRepository.findAll();

    }

    /**
     * Método que busca uma categoria pelo id
     * @param id
     * @return categoria
     */
   public Categoria buscarCategoriaPeloId(int id) {
        Optional<Categoria> optionalAlbum = categoriaRepository.findById(id);

        if (optionalAlbum.isPresent()) {
            return optionalAlbum.get();
        }

        throw new RuntimeException("Categoria não existe");
   }

    /**
     * Método para buscar ou criar nova categoria
     * @param categoria
     * @return
     */
    public List<Categoria> buscarOuCriarCategoria(Categoria categoria) {
       List<Categoria> categorias = new ArrayList<>();

        for(Categoria objCategoria : categorias){
            if(categoria.getId() == null){
                objCategoria = buscarCategoriaPeloId(categoria.getId());
            } else {
                objCategoria = cadastrarCategoria(categoria);
            }
        }

       return categorias;
    }

    /**
     * Método para deletar uma categoria
     * @param id
     */
    public void deletarCategoria(int id){
        categoriaRepository.deleteById(id);
    }
}
