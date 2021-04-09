package com.br.zup.zupnancas.dtos;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.enums.Status;

import java.time.LocalDate;

public class AtualizarContaDTO {

    private double valor;
    private String descricao;
    private LocalDate dataDeVencimento;
    private Status status;
    private String cpf;

    public AtualizarContaDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Conta converterDTOParaConta(int id){
        Conta conta = new Conta();
        Saldo saldo = new Saldo();
        saldo.setCpf(this.cpf);

        conta.setId(id);
        conta.setValor(this.valor);
        conta.setDataDeVencimento(this.dataDeVencimento);
        conta.setStatus(this.status);
        conta.setDescricao(this.descricao);
        conta.setDataDeEntrada(conta.getDataDeEntrada());
        conta.setSaldo(saldo);

        return conta;

    }
}
