package com.br.zup.zupnancas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Saldo {

    @Id
    private String cpf;
    private double valor;
    private double limite;

    public Saldo() {
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

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
