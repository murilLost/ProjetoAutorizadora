package br.com.fiap.autorizadora.controller;

import br.com.fiap.autorizadora.dto.TransacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autorizadora")
public class AutorizadoraController {

    @PostMapping
    public ResponseEntity<String> pagamento(@RequestBody TransacaoDTO transacaoDTO){
        
        return ResponseEntity.ok("Eae");
    }

}
