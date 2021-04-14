package com.br.zup.zupnancas.exceptions;

public class ObjetoDeErro {
    private String mensagem;
    private String campoDoErro;

    public ObjetoDeErro() {
    }

    public ObjetoDeErro(String mensagem, String campoDoErro) {
        this.mensagem = mensagem;
        this.campoDoErro = campoDoErro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCampoDoErro() {
        return campoDoErro;
    }

    public void setCampoDoErro(String campoDoErro) {
        this.campoDoErro = campoDoErro;
    }
}
