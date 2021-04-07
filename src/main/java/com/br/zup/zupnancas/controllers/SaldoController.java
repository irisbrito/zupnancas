package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.entities.Saldo;
import com.br.zup.zupnancas.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("saldos/")
public class SaldoController {

    @Autowired
    private SaldoService saldoService;

    @PostMapping
    public Saldo adicionarSaldo(@RequestBody Saldo saldo){
        return saldoService.adicionarSaldo(saldo);
    }

    @GetMapping("{cpf}/")
    public Optional<Saldo> visualizarSaldo(@PathVariable String cpf){
        return saldoService.visualizarSaldo(cpf);
    }

}
