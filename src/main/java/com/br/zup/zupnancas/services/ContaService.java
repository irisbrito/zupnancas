package com.br.zup.zupnancas.services;

import com.br.zup.zupnancas.dtos.FiltroDeContasPorStatusDTO;
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

    @Autowired
    private CategoriaService categoriaService;

    public Conta cadastrarConta(Conta conta){
        conta.setDataDeEntrada(LocalDate.now());
        validarStatusDaConta(conta);
        verificarSeAContaEstaAtrasada(conta);

        return contaRepository.save(conta);
    }

    public void validarStatusDaConta(Conta conta) {
        if (conta.getStatus() == Status.PAGO) {
            throw new RuntimeException("Não é possível cadastrar uma conta paga");
        }
    }

    public void verificarSeAContaEstaAtrasada(Conta conta){
        LocalDate today = LocalDate.now();

        if (today.isAfter(conta.getDataDeVencimento())) {
            conta.setStatus(Status.ATRASADO);
        }
    }

    public Conta atualizarConta(Conta conta) {
        if (contaRepository.existsById(conta.getId())) {
            Conta objetoConta = cadastrarConta(conta);

            return conta;
        }

        throw new RuntimeException("Conta não encontrada");
    }

    public Iterable<Conta> pesquisarContasPeloStatus(FiltroDeContasPorStatusDTO filtro){
        if(filtro.getStatus() == null){
            return contaRepository.findAll();
        }

        return contaRepository.findAllByStatus(filtro.getStatus());
    }


}
