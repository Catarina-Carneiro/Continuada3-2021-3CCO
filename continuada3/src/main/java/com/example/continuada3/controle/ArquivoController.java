package com.example.continuada3.controle;

import com.example.continuada3.arquivo.Arquivo;
import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.dominio.TipoCertidao;
import com.example.continuada3.repository.ArquivoRepository;
import com.example.continuada3.repository.CertidoesRepository;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {


    @Autowired
    private ArquivoRepository repository;


//    @PostMapping()
//    public ResponseEntity postArquivo(@RequestParam MultipartFile arquivo) {
//
//        BufferedReader valor = null;
//        String texto;
//        String tipoTexto;
//
//        if (!arquivo.getOriginalFilename().endsWith(".txt")) {
//            return ResponseEntity.status(400).body("formato de arquivo invalido");
//        } else {
//
//            try {
//                valor = new BufferedReader(new FileReader(arquivo.getOriginalFilename()));
//            }
//
//            catch (FileNotFoundException e) {
//                return ResponseEntity.status(400).body("tente novamente, falha ao abrir o arquivo");
//            }
//
//            try {
//                texto = valor.readLine();
//                Certidao certidao = new Certidao();
//                TipoCertidao tipo = new TipoCertidao();
//                while (texto == null) {
//
//                    tipoTexto = texto.substring(0, 2);
//                    texto = texto.replaceAll("", "");
//                    switch (tipoTexto) {
//                        case "02":
//                            certidao.setCpf(texto.substring(2, 13));
//                            certidao.setDataNascimento(texto.substring(13, 21));
//                            certidao.setNome(texto.substring(21, 51));
//                            certidao.setCidadeDeNascimento(texto.substring(51, 66));
//                            certidao.setMae(texto.substring(66, 96));
//                            certidao.setPai(texto.substring(96, 126));
//                            break;
//                        case "03":
//                            tipo.setNome();
//                            break;
//                    }
//                    texto = valor.readLine();
//                }
//                CertidoesRepository.save(Certidao);
//                TipoCertidaoRepository.save(TipoCertidao);
//                return ResponseEntity.status(200).body(tipo);
//            } catch (IOException e) {
//                return ResponseEntity.status(404).body("Erro");
//            }
//
//        }
//    }


    @PostMapping
    public ResponseEntity criarArquivo(@RequestParam MultipartFile arquivo) throws IOException {

        // recuperando o nome original do arquivo
        System.out.println("Recebendo um arquivo de nome: " + arquivo.getOriginalFilename());

        // recuperando o tipo do arquivo
        System.out.println("Recebendo um arquivo do tipo: " + arquivo.getContentType());

        // recuperando o conteúdo do arquivo
        byte[] conteudo = arquivo.getBytes();

        // aqui estamos gravando o arquivo na pasta de trabalho da API
        Path path = Paths.get(arquivo.getOriginalFilename());
        Files.write(path, conteudo);

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/anexo")
    public ResponseEntity criarAnexo(@RequestParam MultipartFile arquivo) throws IOException {

        Arquivo novoAnexo = new Arquivo();
        novoAnexo.setNomeArquivo(arquivo.getOriginalFilename());
        novoAnexo.setConteudoArquivo(arquivo.getBytes());

        repository.save(novoAnexo);

        return ResponseEntity.status(201).build();
    }

}

