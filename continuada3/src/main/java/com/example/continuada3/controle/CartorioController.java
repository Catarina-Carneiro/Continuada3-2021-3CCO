package com.example.continuada3.controle;

//import com.example.continuada3.agendamento.AgendamentoService;


import com.example.continuada3.dominio.Cartorio;
import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.obj.FilaObj;
import com.example.continuada3.obj.PilhaObj;
import com.example.continuada3.repository.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/cartorio")
public class CartorioController {

    @Autowired
    private CartorioRepository repository;

//    @Autowired
//    private AgendamentoService agendamentoService;

    public FilaObj<Cartorio> filaAgendamento = new FilaObj<>(3);

    @GetMapping
    public ResponseEntity getCartorios() {
        List<Cartorio> ceartorio = repository.findAll();
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @Scheduled(fixedRate = 60000)
    @PostMapping("/agendamento")
    public ResponseEntity novaBusca() {


      //  Cartorio cartorio = new Cartorio();
      //  agendamentoService.agendar(agendamentoService.filaAgendamento);
      //  agendamentoService.filaAgendamento.insert(cartorio.getId());


            String protocolo = UUID.randomUUID().toString();
            LocalDateTime previsao = LocalDateTime.now().plusSeconds(16);


            Thread sorteador = new Thread(() -> {
                try {
                    Thread.sleep(15_000);
                    Integer numero = ThreadLocalRandom.current().nextInt(1, 3);

                    Cartorio lugarDeBusca = new Cartorio();
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
                            + protocoloOptional.get().getCartorioDeBusca());
        } else {
            LocalDateTime previsao = LocalDateTime.now().plusSeconds(5);
            return ResponseEntity.status(404).header("previsao", previsao.toString()).build();
        }
    }


}
