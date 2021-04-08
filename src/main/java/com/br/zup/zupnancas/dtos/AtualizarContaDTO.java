package com.br.zup.zupnancas.dtos;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.enums.Status;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class AtualizarContaDTO {

    private double valor;
    private String descricao;
    private LocalDate dataDeVencimento;
    private Status status;

    @ManyToOne
    private Saldo saldo;

    public AtualizarContaDTO() {
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

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public Conta converterDTOParaConta(int id){
        Conta conta = new Conta();
        conta.setId(id);
        conta.setValor(this.valor);
        conta.setDataDeVencimento(this.dataDeVencimento);
        conta.setStatus(this.status);
        conta.setDescricao(this.descricao);
        conta.setDataDeEntrada(conta.getDataDeEntrada());
        conta.setSaldo(conta.getSaldo());

        return conta;

    }
}
