package com.br.zup.zupnancas.dtos;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.enums.Status;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "O valor deve ser informado")
    private double valor;
    @NotNull(message = "Informe a descrição")
    private String descricao;
    @NotNull(message = "Informe a data de vencimento da conta")
    private LocalDate dataDeVencimento;
    @NotNull(message = "Informe o status correto da conta")
    private Status status;
    @CPF(message = "CPF inválido")
    private String cpf;

    public ContaDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        Saldo saldo = new Saldo();
        saldo.setCpf(cpf);

        conta.setId(id);
        conta.setDataDeEntrada(LocalDate.now());
        conta.setDescricao(descricao);
        conta.setStatus(status);
        conta.setDataDeVencimento(dataDeVencimento);
        conta.setValor(valor);
        conta.setSaldo(saldo);

        return conta;
    }

    public static Iterable<ContaDTO> converterIterableDeModelParaDTO(Iterable<Conta> contas){
        List<ContaDTO> contasDTOS = new ArrayList<>();

        for(Conta conta : contas){
            contasDTOS.add(converterModelParaDTO(conta));
        }

        return contasDTOS;
    }

    public static ContaDTO converterModelParaDTO(Conta conta){
        ContaDTO contasDTO = new ContaDTO();

        contasDTO.setDescricao(conta.getDescricao());
        contasDTO.setStatus(conta.getStatus());
        contasDTO.setDataDeVencimento(conta.getDataDeVencimento());
        contasDTO.setValor(conta.getValor());
        contasDTO.setId(conta.getId());
        contasDTO.setCpf(conta.getSaldo().getCpf());

        return contasDTO;

    }

}
