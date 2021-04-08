package com.br.zup.zupnancas.dtos;

import com.br.zup.zupnancas.enums.Status;

public class FiltroDeContasPorStatusDTO {

    private Status status;

    public FiltroDeContasPorStatusDTO() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
