package com.example.continuada3.controle;

import com.example.continuada3.documentos.Cartorio;
import com.example.continuada3.documentos.Certidao;
import com.example.continuada3.repository.CertidoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/certidoes")
public class CertidoesController {

    @Autowired
    private CertidoesRepository repository;


}
