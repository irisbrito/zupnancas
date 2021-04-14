package com.br.zup.zupnancas.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<ObjetoDeErro> objetosDeErro = getErros(ex);
        RespostaDeErro respostaDeErro = new RespostaDeErro("Validação", status.value(),
                status.getReasonPhrase(), objetosDeErro);
        return ResponseEntity.status(status).body(respostaDeErro);
    }

    private List<ObjetoDeErro> getErros(MethodArgumentNotValidException exception){
        List<ObjetoDeErro> objetosDeErro = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(erro -> new ObjetoDeErro(erro.getDefaultMessage(), erro.getField()))
                .collect(Collectors.toList());

        return objetosDeErro;
    }

}
