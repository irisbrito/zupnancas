package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.entities.Credito;
import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {

    @Autowired
    private SaldoRepository saldoRepository;

    public Saldo adicionarSaldo(Saldo saldo){
       return saldoRepository.save(saldo);
    }

    public Saldo pesquisarSaldo(String cpf){
        Optional<Saldo> optionalSaldo = saldoRepository.findById(cpf);

        if (optionalSaldo.isEmpty()) {
            throw new RuntimeException("CPF não cadastrado" + cpf);
        }

        return optionalSaldo.get();
    }

    public void creditarSaldo(Credito credito) {
        Saldo saldo = pesquisarSaldo(credito.getSaldo().getCpf());
        Double valorAtualizado = saldo.getValor() + credito.getValor();
        saldo.setValor(valorAtualizado);

        saldoRepository.save(saldo);
    }

    public boolean debitar(Conta conta){
        Saldo saldo = pesquisarSaldo(conta.getSaldo().getCpf());
        double novoSaldo = saldo.getValor() + saldo.getLimite();

        if(novoSaldo > conta.getValor()){
            novoSaldo = saldo.getValor() - conta.getValor();
            saldo.setValor(novoSaldo);
            saldoRepository.save(saldo);

            return true;
        }

        return false;
    }
}
