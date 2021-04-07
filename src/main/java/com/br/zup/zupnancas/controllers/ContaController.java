package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contas/")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public Conta cadastrarConta(@RequestBody Conta conta){
        return contaService.cadastrarConta(conta);
    }
}
