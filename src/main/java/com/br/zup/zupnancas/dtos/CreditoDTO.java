package com.br.zup.zupnancas.dtos;

import com.br.zup.zupnancas.entities.Categoria;
import com.br.zup.zupnancas.entities.Credito;
import com.br.zup.zupnancas.entities.Saldo;

import java.util.List;

public class CreditoDTO {

    private double valor;
    private String descricao;

    private List<Categoria> categorias;

    private String cpf;

    public CreditoDTO() {
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Credito converterDTO(){
        Credito credito = new Credito();

        Saldo saldo = new Saldo();
        saldo.setCpf(cpf);
        credito.setCategorias(categorias);
        credito.setSaldo(saldo);
        credito.setValor(valor);
        credito.setDescricao(descricao);

        return credito;
    }

}
