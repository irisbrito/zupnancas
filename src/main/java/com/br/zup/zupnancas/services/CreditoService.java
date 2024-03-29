package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Categoria;
import com.br.zup.zupnancas.entities.Credito;
import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditoService {

    private CreditoRepository creditoRepository;
    private SaldoService saldoService;
    private CategoriaService categoriaService;

    @Autowired
    public CreditoService(CreditoRepository creditoRepository, SaldoService saldoService, CategoriaService categoriaService) {
        this.creditoRepository = creditoRepository;
        this.saldoService = saldoService;
        this.categoriaService = categoriaService;
    }

    /**
     * Método para cadastro de novo crédito
     * @param credito
     * @return credito
     */
    public Credito cadastrarCredito(Credito credito){
        credito.setDataDeEntrada(LocalDate.now());

        Saldo saldo = saldoService.pesquisarSaldo(credito.getSaldo().getCpf());
        credito.setSaldo(saldo);

        //categoriaService.buscarOuCriarCategoria(credito.getCategorias());
        List<Categoria> categorias = pesquisarCategoriasDoCredito(credito.getCategorias());
        credito.setCategorias(categorias);

        Credito novoCredito = creditoRepository.save(credito);
        saldoService.creditarSaldo(novoCredito);

        return novoCredito;
    }

    /**
     * Método para pesquisar as categorias do crédito
     * @param categorias
     * @return lista com as categorias
     */
    public List<Categoria> pesquisarCategoriasDoCredito(Iterable<Categoria> categorias){
        List<Categoria> categoriasCadastradas = new ArrayList<>();

        for(Categoria categoria : categorias){
            if(categoria.getId() == null){
                categoriasCadastradas.add(categoriaService.cadastrarCategoria(categoria));
            } else {
                categoriasCadastradas.add(categoriaService.buscarCategoriaPeloId(categoria.getId()));
            }
        }

        return categoriasCadastradas;
    }

    /**
     * Método para pesquisar todos os créditos
     * @return lista com os créditos inseridos no sistema
     */
    public Iterable<Credito> pesquisarTodosOsCreditos(){
        return creditoRepository.findAll();
    }

}
