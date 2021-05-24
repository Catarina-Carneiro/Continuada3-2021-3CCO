package com.example.continuada3.controle;

import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.repository.CartorioRepository;
import com.example.continuada3.repository.CertidoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certidoes")
public class CertidoesController {

    @Autowired
    private CertidoesRepository repository;

    @GetMapping
    public ResponseEntity getCertidoes(){
        return ResponseEntity.status(200).body(repository.findAll());
    }



}
