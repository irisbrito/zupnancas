package com.br.zup.zupnancas.controllers;

import com.br.zup.zupnancas.dtos.AtualizarContaDTO;
import com.br.zup.zupnancas.dtos.ContaDTO;
import com.br.zup.zupnancas.dtos.FiltroDeContasPorStatusDTO;
import com.br.zup.zupnancas.entities.Conta;
import com.br.zup.zupnancas.enums.Status;
import com.br.zup.zupnancas.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contas/")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public Conta cadastrarConta(@RequestBody ContaDTO contaDTO){
        return contaService.cadastrarConta(contaDTO.converterParaConta());
    }

    @PutMapping("{id}/")
    public Conta atualizarConta(@PathVariable int id, @RequestBody AtualizarContaDTO contaDTO){
        Conta conta = contaDTO.converterDTOParaConta(id);
        return contaService.atualizarConta(conta);
    }

    @GetMapping
    public Iterable<ContaDTO> buscarContasPeloStatus(@ModelAttribute FiltroDeContasPorStatusDTO filtro){
        Iterable<Conta> contas = contaService.pesquisarContasPeloStatus(filtro);
        return ContaDTO.converterIterableDeModelParaDTO(contas);
    }
}
