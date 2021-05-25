package com.example.continuada3.controle;


import com.example.continuada3.dominio.TipoCertidao;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos")
public class TipoCertidaoController {

    @Autowired
    private TipoCertidaoRepository repository;

    @PostMapping()
    public ResponseEntity postTipo(@RequestBody TipoCertidao novoTipo) {
        repository.save(novoTipo);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getTipo() {
        return ResponseEntity.status(200).body(repository.findAll());
    }





}
