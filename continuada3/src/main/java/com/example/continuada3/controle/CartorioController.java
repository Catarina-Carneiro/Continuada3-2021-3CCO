package com.example.continuada3.controle;

import com.example.continuada3.documentos.Cartorio;
import com.example.continuada3.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/certidoes2")
public class CartorioController {

    @Autowired
    private CartorioRepository repository;

    @PostMapping
    public ResponseEntity novoSorteio() {

        String protocolo = UUID.randomUUID().toString();
        LocalDateTime previsao = LocalDateTime.now().plusSeconds(16);


        Thread sorteador = new Thread(() -> {
            try {
                Thread.sleep(15_000);
                Integer numero = ThreadLocalRandom.current().nextInt(1, 3);

                Cartorio lugarDeBusca= new Cartorio();
                lugarDeBusca.setProtocolo(protocolo);
                lugarDeBusca.setCartorioDeBusca(numero);

                repository.save(lugarDeBusca);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sorteador.start();

        return ResponseEntity
                .status(202)
                .header("protocolo", protocolo)
                .header("previsao", previsao.toString())
                .build();
    }

    @GetMapping("/{protocolo}")
    public ResponseEntity getSorteio(@PathVariable String protocolo) {
        Optional<Cartorio> protocoloOptional = repository.findById(protocolo);

        if (protocoloOptional.isPresent()) {
            return ResponseEntity
                    .status(200).body("O cartorio de busca da sua certidão é o de número: "
                            +protocoloOptional.get().getCartorioDeBusca());
        } else {
            LocalDateTime previsao = LocalDateTime.now().plusSeconds(5);
            return ResponseEntity.status(404).header("previsao", previsao.toString()).build();
        }
    }
}
