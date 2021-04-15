package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("saldos/")
public class SaldoController {

    @Autowired
    private SaldoService saldoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Saldo adicionarSaldo(@RequestBody Saldo saldo){
        return saldoService.adicionarSaldo(saldo);
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Saldo visualizarSaldo(@PathVariable String cpf){
        return saldoService.pesquisarSaldo(cpf);
    }
}
