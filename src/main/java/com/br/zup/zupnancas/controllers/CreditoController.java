package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.dtos.CreditoDTO;
import com.br.zup.zupnancas.entities.Credito;
import com.br.zup.zupnancas.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("creditos/")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Credito cadastrarCredito(@RequestBody @Valid CreditoDTO credito){
        return creditoService.cadastrarCredito(credito.converterDTO());
    }

    @GetMapping
    public Iterable<Credito> pesquisarTodosOsCreditos(){
        return creditoService.pesquisarTodosOsCreditos();
    }
}
