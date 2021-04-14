package com.br.zup.zupnancas.exceptions;

public class SaldoNaoEncontradoException extends RuntimeException {

    private int Status = 400;
    private String campo = "id";
    private String razaoDoErro = "Bad request";
    private String tipoDoErro = "CPF não cadastrado";

    public SaldoNaoEncontradoException(String message) {
        super(message);
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getRazaoDoErro() {
        return razaoDoErro;
    }

    public void setRazaoDoErro(String razaoDoErro) {
        this.razaoDoErro = razaoDoErro;
    }

    public String getTipoDoErro() {
        return tipoDoErro;
    }

    public void setTipoDoErro(String tipoDoErro) {
        this.tipoDoErro = tipoDoErro;
    }
}
