package com.br.zup.zupnancas.dtos;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.enums.Status;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class ContaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double valor;
    private String descricao;
    private LocalDate dataDeVencimento;
    private Status status;

    public ContaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Conta converterParaConta(){
        Conta conta = new Conta();

        conta.setId(id);
        conta.setDataDeEntrada(LocalDate.now());
        conta.setDescricao(descricao);
        conta.setStatus(status);
        conta.setDataDeVencimento(dataDeVencimento);
        conta.setValor(valor);

        return conta;
    }
}
