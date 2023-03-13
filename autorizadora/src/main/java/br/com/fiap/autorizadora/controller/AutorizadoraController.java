package br.com.fiap.autorizadora.controller;

import br.com.fiap.autorizadora.dto.TransacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
//@RestController
@RequestMapping("/autorizadora")
public class AutorizadoraController {

    @PostMapping
    public ResponseEntity<String> pagamento(@RequestBody TransacaoDTO transacaoDTO){

        return ResponseEntity.ok("Eae");
    }

}
