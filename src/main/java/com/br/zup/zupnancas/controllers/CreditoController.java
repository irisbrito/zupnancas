package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.entities.Credito;
import com.br.zup.zupnancas.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creditos/")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @PostMapping
    public Credito cadastrarCredito(@RequestBody Credito credito){
        return creditoService.cadastrarCredito(credito);
    }
}
