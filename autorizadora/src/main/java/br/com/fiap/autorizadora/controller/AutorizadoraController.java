package br.com.fiap.autorizadora.controller;

import br.com.fiap.autorizadora.dto.TransacaoDTO;
import br.com.fiap.autorizadora.dto.TransacaoSimpleDTO;
import br.com.fiap.autorizadora.dto.TransacoesConsultaDTO;
import br.com.fiap.autorizadora.service.AutorizadoraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("autorizadora")
public class AutorizadoraController {

    private AutorizadoraService autorizadoraService;

    public AutorizadoraController(AutorizadoraService autorizadoraService) {
        this.autorizadoraService = autorizadoraService;
    }

    @PostMapping
    public ResponseEntity<String> pagamento(@Valid @RequestBody TransacaoDTO transacaoDTO){
        return ResponseEntity.ok(autorizadoraService.pagamento(transacaoDTO));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransacaoSimpleDTO> extratoEmail(@RequestBody TransacoesConsultaDTO transacoesConsultaDTO){
        return autorizadoraService.extratoEmail(transacoesConsultaDTO);
    }

}
