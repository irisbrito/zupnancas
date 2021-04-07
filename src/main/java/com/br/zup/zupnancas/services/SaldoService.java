package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Credito;
import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {

    @Autowired
    private SaldoRepository saldoRepository;

    public Saldo adicionarSaldo(Saldo saldo){
       return saldoRepository.save(saldo);
    }

}
