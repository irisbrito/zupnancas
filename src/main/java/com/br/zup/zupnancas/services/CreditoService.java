package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Credito;
import com.br.zup.zupnancas.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;

    @Autowired
    private SaldoService saldoService;

    public Credito cadastrarCredito(Credito credito){
        return creditoRepository.save(credito);
    }

    public Iterable<Credito> pesquisarTodosOsCreditos(){
        return creditoRepository.findAll();
    }
}
