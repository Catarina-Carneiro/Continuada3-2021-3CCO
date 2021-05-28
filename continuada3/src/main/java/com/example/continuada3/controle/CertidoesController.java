package com.example.continuada3.controle;

import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.obj.PilhaObj;
import com.example.continuada3.repository.CertidoesRepository;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/certidoes")
public class CertidoesController {

    @Autowired
    private CertidoesRepository repository;

    @Autowired
    private TipoCertidaoRepository tipoCertidaoRepository;

    PilhaObj<Certidao> certidaoDeletada = new PilhaObj(3);

    @GetMapping
    public ResponseEntity<List<Certidao>> getCertidoes() {

        List<Certidao> certidao = repository.findAll();

        return certidao.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(certidao);
    }


    @PostMapping
    public ResponseEntity postCertidao(@RequestBody @Valid Certidao novaCertidao) {
        if (tipoCertidaoRepository.existsById(novaCertidao.getTipo().getId())) {
            repository.save(novaCertidao);
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(400).body("Tipo de certidao não encontrado!");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletarCertidao(@PathVariable int id) {
        if (repository.existsById(id)) {
            Optional<Certidao> certidao = repository.findById(id);
            certidaoDeletada.push(certidao.get());
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/desfazer-delete")
    public ResponseEntity desfazerDelete() {
        if (!certidaoDeletada.isEmpty()) {
            repository.save(certidaoDeletada.pop());
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(204).body("Não há Delete para desfazer");
        }
    }


//    @GetMapping("/tipo/{idTipo}")
//    public ResponseEntity getEsportesPorTipo(@PathVariable Integer idTipo) {
//        return ResponseEntity.status(200).body(repository.pesquisarPorTipo(idTipo));
//    }


}
