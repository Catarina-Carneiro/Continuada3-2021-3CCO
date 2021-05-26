package com.example.continuada3.controle;

import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.obj.PilhaObj;
import com.example.continuada3.repository.CertidoesRepository;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/certidoes")
public class CertidoesController {

    @Autowired
    private CertidoesRepository repository;

    @Autowired
    private TipoCertidaoRepository tipoCertidaoRepository;

    //PilhaObj<Certidao> certidaoDeletada = new PilhaObj(3);

    @GetMapping
    public ResponseEntity getCertidoes() {
        return ResponseEntity.status(200).body(repository.findAll());
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
    public ResponseEntity deletaCertidao(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }




//    @DeleteMapping("/{id}")
//    public ResponseEntity deletarCertidao(@PathVariable int id){
//        if (repository.existsById(id)){
//            certidaoDeletada.push(repository.getById(id));
//            repository.delete(id);
//            return ResponseEntity.status(200).build();
//        }else{
//            return ResponseEntity.status(404).build();
//        }
//    }
//
//    @PostMapping("/desfazerDelete")
//    public ResponseEntity desfazerDelete(){
//        if (!certidaoDeletada.isEmpty()){
//            repository.save(certidaoDeletada.pop());
//            return ResponseEntity.status(201).build();
//        }else {
//            return ResponseEntity.status(204).body("Não há Delete para desfazer");
//        }
// }




//    @GetMapping("/tipo/{idTipo}")
//    public ResponseEntity getEsportesPorTipo(@PathVariable Integer idTipo) {
//        return ResponseEntity.status(200).body(repository.pesquisarPorTipo(idTipo));
//    }



}
