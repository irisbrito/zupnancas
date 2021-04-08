package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.enums.Status;
import com.br.zup.zupnancas.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta cadastrarConta(Conta conta){
        conta.setDataDeEntrada(LocalDate.now());
        validarStatusDaConta(conta);
        return contaRepository.save(conta);
    }

    public void validarStatusDaConta(Conta conta) {
        if (conta.getStatus() == Status.PAGO) {
            throw new RuntimeException("Não é possível cadastrar uma conta paga");
        }
    }
}
