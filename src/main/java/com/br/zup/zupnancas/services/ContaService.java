package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta cadastrarConta(Conta conta){
        return contaRepository.save(conta);
    }
}
