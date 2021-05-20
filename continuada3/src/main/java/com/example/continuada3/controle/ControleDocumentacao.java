package com.example.continuada3.controle;

import com.example.Continuada1.documentos.Carro;
import com.example.Continuada1.documentos.Certidoes;
import com.example.Continuada1.documentos.Imovel;
import com.example.Continuada1.documentos.Moto;
import com.example.Continuada1.repository.Documentavel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/documentos")
public class ControleDocumentacao {

    private List<Documentavel> listaDocs = new ArrayList<Documentavel>();

    Boolean primeiroAcesso = false;


    public void getprimeiroAcesso() {
        if (!primeiroAcesso) {
            this.listaDocs.add(new Carro("civic", "gm", 2015,
                                         25000.00));
            this.listaDocs.add(new Moto("ninja", "honda", 2009,
                                         5000.00, 2000));
            this.listaDocs.add(new Imovel("jd. scs", "bell aliance", 90,
                                            103000.00));
            this.listaDocs.add(new Certidoes("Paulo silva", 7554456, 2));
            primeiroAcesso = true;

        }
    }


    @GetMapping
    public List<Documentavel> ListaDocs() {
        getprimeiroAcesso();
        return this.listaDocs;
    }

    //recuperar posicao
    @GetMapping("/recuperar/{posicao}")
    public Documentavel recuperar(@PathVariable int posicao) {
        getprimeiroAcesso();
        if (this.listaDocs.size() > posicao)
            return this.listaDocs.get(posicao);
        else {
            return null;
        }
    }

    //deletar
    @DeleteMapping("/{posicao}")
    public String deleteDocumentacao(@PathVariable int posicao) {
        getprimeiroAcesso();
        if (posicao < listaDocs.size()) {
            listaDocs.remove(posicao);
            return "Documentação excluida com sucesso";
        } else {
            return "Documentação não encontrado";
        }
    }


    // adiconar pelo postman
    @PostMapping("/new-carro")
    public String postCarro(@RequestBody Carro Documentavel) {
        ListaDocs().add(Documentavel);
        return "Novo carro criado com sucesso!";
    }

    @PostMapping("/new-moto")
    public String postCarro(@RequestBody Moto Documentavel) {
        ListaDocs().add(Documentavel);
        return "Novo carro criado com sucesso!";
    }

    @PostMapping("/new-imovel")
    public String postCarro(@RequestBody Imovel Documentavel) {
        ListaDocs().add(Documentavel);
        return "Novo carro criado com sucesso!";
    }

    @PostMapping("/new-certidao")
    public String postCarro(@RequestBody Certidoes Documentavel) {
        ListaDocs().add(Documentavel);
        return "Novo carro criado com sucesso!";
    }

    //adc MANUALMENTE pela url
    @GetMapping("cadastrar-carro/{nome}/{marca}/{anoLancamento}/{valor}")
    public String cadastrarCarro(@PathVariable String nome,
                                 @PathVariable String marca,
                                 @PathVariable Integer anoLancamento,
                                 @PathVariable Double valor) {
        this.listaDocs.add(new Carro(nome, marca, anoLancamento, valor));
        return "Carro cadastrado com sucesso!!!";
    }


    @GetMapping("cadastrar-moto/{nome}/{marca}/{anoLancamento}/{valor}/{cilindradas}")
    public String cadastrarMoto(@PathVariable String nome,
                                @PathVariable String marca,
                                @PathVariable Integer anoLancamento,
                                @PathVariable Double valor,
                                @PathVariable Integer cilindradas) {
        this.listaDocs.add(new Moto(nome, marca, anoLancamento, valor, cilindradas));
        return "Carro cadastrado com sucesso!!!";
    }

    @GetMapping("cadastrar-imovel/{bairro}/{rua}/{numero}/{valorDoImovel}")
    public String cadastrarImovel(@PathVariable String bairro,
                                  @PathVariable String rua,
                                  @PathVariable Integer numero,
                                  @PathVariable Double valorDoImovel) {
        this.listaDocs.add(new Imovel(bairro, rua, numero, valorDoImovel));
        return "imovel cadastrado com sucesso";
    }


}

